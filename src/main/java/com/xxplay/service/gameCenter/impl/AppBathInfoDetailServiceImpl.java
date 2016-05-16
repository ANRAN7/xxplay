package com.xxplay.service.gameCenter.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xxplay.core.base.AppConstants;
import com.xxplay.dao.app.IAppBathInfoDetailDao;
import com.xxplay.pojo.app.AppBathInfoDetail;
import com.xxplay.pojo.app.AppInfos;
import com.xxplay.pojo.app.PackInfo;
import com.xxplay.service.gameCenter.IAppBathInfoDetailService;
import com.xxplay.service.gameCenter.IGameApkService;
import com.xxplay.service.gameCenter.IGamePicListService;
import com.xxplay.service.gameCenter.IGameService;
import com.xxplay.utils.ApkReadUtils;

/**
 * 批量上传游戏任务详情服务 实现类
 * 
 * @Author:chenssy
 * @date:2016年5月14日 下午12:47:39
 * 
 */
@Service("appBathInfoDetailService")
public class AppBathInfoDetailServiceImpl implements IAppBathInfoDetailService{
	private final static  Logger LOGGER = Logger.getLogger(AppBathInfoDetailServiceImpl.class); 
	
	@Resource
	private IAppBathInfoDetailDao appBathInfoDetailDao;
	
	@Resource
	private IGameService gameService;

	@Resource
	private IGamePicListService gamePicListService;
	
	@Resource
	private IGameApkService gameApkService;
	
	@Override
	public void addBathInfo(List<AppBathInfoDetail> details) {
		appBathInfoDetailDao.insertBath(details);
	}

	@Override
	public List<AppBathInfoDetail> getDetailByBathId(int bathId) {
		return appBathInfoDetailDao.selectByBathId(bathId);
	}

	@Override
	public void executeAppBathInfoDetail(AppBathInfoDetail infoDetail) {
		LOGGER.info("执行解析游戏任务。游戏名称：" + infoDetail.getAppName());
		AppInfos appInfos = new AppInfos();
		BeanUtils.copyProperties(infoDetail, appInfos);
		
		//解析apk包
		PackInfo packInfo = null;
		try {
			packInfo = ApkReadUtils.readApk(infoDetail.getApkName(), AppConstants.GAME_APP_PACK_ICON_REAL_PATH);
		} catch (Exception e) {
			LOGGER.error("解析apk包失败,error:" + e.getMessage(), e);
			//标注失败
			
			appBathInfoDetailDao.updateByPrimaryKey(infoDetail);
			return;
		}
		
		appInfos.setMainIconpicurl(packInfo.getIconPicurl());
		appInfos.setMainPackid(packInfo.getPackid());		
		appInfos.setMainPacksize(Integer.valueOf(packInfo.getPackSize()));
		appInfos.setMainSigncode(packInfo.getSignCode());
		appInfos.setMainVercode(packInfo.getVerCode().toString());
		appInfos.setMainVername(packInfo.getVerName());
		
		//保存基本信息
		gameService.saveGameInfo(appInfos);
		
		//保存apk包信息
		packInfo.setAppinfoId(appInfos.getId().toString());
		packInfo.setUpdateDesc(infoDetail.getAppdesc());
		packInfo.setIsMainver("1");
		gameApkService.addGameApkInfo(packInfo);
		
		//保存图片列表
		String[] pics = infoDetail.getPicList().split(",");
		gamePicListService.saveGamePickList(Arrays.asList(pics), appInfos.getId());
		
		//设置任务为成功
		
		LOGGER.info("解析游戏任务成功。游戏名称：" + infoDetail.getAppName());
	}
	
}
