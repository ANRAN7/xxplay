package com.xxplay.service.gameCenter.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

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
 * @file:GameBathTaskServiceImpl.java
 * @package_name:com.xxplay.service.gameCenter.impl
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年5月14日 下午3:01:03
 */
@Service("gameTabService")
public class GameBathTaskServiceImpl implements IGameBathTaskService{
	
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
		new excuteGameBathTask(bathInfo.getId());
	}

	/**
	 * 执行批次任务的线程
	 * 
	 * @author chenming
	 *
	 */
	private class excuteGameBathTask implements Runnable{
		private int bathId ;
		public excuteGameBathTask(int bathId){
			this.bathId = bathId;
		}
		@Override
		public void run() {
			//获取该批次任务中的所有详情任务
			final List<AppBathInfoDetail> bathInfoDetails = appBathInfoDetailService.getDetailByBathId(bathId);
			final CountDownLatch countDownLatch = new CountDownLatch(bathInfoDetails.size());
			ExecutorService executorService = Executors.newFixedThreadPool(5);		//线程池大小为5
			//迭代任务
			for(final AppBathInfoDetail infoDetail : bathInfoDetails){
				executorService.submit(new Runnable() {
					@Override
					public void run() {
						try {
							appBathInfoDetailService.executeAppBathInfoDetail(infoDetail);
						} catch (Exception e) {
						} finally{
							countDownLatch.countDown();
						}
					}
				});
			}
			
			try {
				//等待所有线程全部执行完成
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
