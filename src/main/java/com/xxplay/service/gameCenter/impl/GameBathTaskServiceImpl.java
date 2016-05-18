package com.xxplay.service.gameCenter.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xxplay.core.utils.DateUtils;
import com.xxplay.pojo.app.AppBathInfo;
import com.xxplay.pojo.app.AppBathInfoDetail;
import com.xxplay.service.gameCenter.IAppBathInfoDetailService;
import com.xxplay.service.gameCenter.IAppBathInfoService;
import com.xxplay.service.gameCenter.IGameBathTaskService;
import com.xxplay.utils.IConstant;

/**
 * 游戏批量任务服务 实现类
 * 
 * @Author:chenssy
 * @date:2016年5月14日 下午3:01:03
 * 
 */
@Service("gameBathTaskService")
public class GameBathTaskServiceImpl implements IGameBathTaskService{
	private final static Logger LOGGER = Logger.getLogger(GameBathTaskServiceImpl.class);
	@Resource
	private IAppBathInfoService appBathInfoService;
	
	@Resource
	private IAppBathInfoDetailService appBathInfoDetailService;
	
	@Override
	public void excuteGameBathTask() {
		//获取未开始的批量任务
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", IConstant.GAME_SAVE_BATH_STATUS_NOTSTART);
		//每次仅取一个
		AppBathInfo bathInfo = appBathInfoService.getAppBathInfoByCondition(params).get(0);
		bathInfo.setStatus(IConstant.GAME_SAVE_BATH_STATUS_TSTARTING);  //状态正在执行中
		bathInfo.setStartTime(DateUtils.getCurrentDate());
		
		appBathInfoService.updateAppBathInfo(bathInfo);
		
		//开启执行批次任务
		new Thread(new excuteGameBathTask(bathInfo)).start();;
	}

	/**
	 * 执行批次任务的线程
	 * 
	 * @author chenming
	 *
	 */
	private class excuteGameBathTask implements Runnable{
		private boolean excuteRightFlag = false;	//任务执行情况--正确标识
		private boolean excuteErrorFlag = false;	//任务执行情况--错误标识
		private AppBathInfo bathInfo ;
		public excuteGameBathTask(AppBathInfo bathInfo){
			this.bathInfo = bathInfo;
		}
		@Override
		public void run() {
			//获取该批次任务中的所有详情任务
			final List<AppBathInfoDetail> bathInfoDetails = appBathInfoDetailService.getDetailByBathId(bathInfo.getId());
			final CountDownLatch countDownLatch = new CountDownLatch(bathInfoDetails.size());
			ExecutorService executorService = Executors.newFixedThreadPool(5);		//线程池大小为5
			//迭代任务
			for(final AppBathInfoDetail infoDetail : bathInfoDetails){
				infoDetail.setCreateAdmin(bathInfo.getCreateId());
				infoDetail.setCreatTime(DateUtils.getCurrentDate());
				Future<?> future = executorService.submit(new Runnable() {
					@Override
					public void run() {
						try {
							appBathInfoDetailService.executeAppBathInfoDetail(infoDetail);
						} catch (Exception e) {
						} finally{
							countDownLatch.countDown();		//计数-1
						}
					}
				});
				//判断线程是否抛出异常，抛出异常标识改任务执行失败
				try {
					future.get();
					excuteRightFlag = true;
				} catch (Exception e) {		//抛出异常
					excuteErrorFlag = true;
				}
			}
			
			try {
				//等待所有线程全部执行完成
				countDownLatch.await();
				LOGGER.info("所有执行解析线程任务均已完成...,开始分析解析结果....");
				String result = null;
				if(excuteRightFlag && !excuteErrorFlag){	//有正确、无错误，标识任务全部成功
					bathInfo.setStatus(IConstant.GAME_SAVE_BATH_STATUS_SUCCESS);
					result = "成功";
				}else if(excuteRightFlag && excuteErrorFlag){	//有正确，有错误，标识任务为部分成功
					bathInfo.setStatus(IConstant.GAME_SAVE_BATH_STATUS_PARTIALSUCCESS);
					result = "部分成功";
				}else{			//标识任务为失败
					bathInfo.setStatus(IConstant.GAME_SAVE_BATH_STATUS_FAILED);
					result = "失败";
				}
				LOGGER.info("所有执行解析线程任务均已完成...,任务解析结果为：" + result);
				appBathInfoService.updateAppBathInfo(bathInfo);		//更改批次任务执行情况
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
