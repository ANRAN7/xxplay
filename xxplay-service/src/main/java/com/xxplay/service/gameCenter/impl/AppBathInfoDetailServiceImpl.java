package com.xxplay.service.gameCenter.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xxplay.common.core.AppConstants;
import com.xxplay.common.core.AppContextUtils;
import com.xxplay.common.utils.xxplay.ApkReadUtils;
import com.xxplay.common.utils.xxplay.IConstant;
import com.xxplay.dao.app.IAppBathInfoDetailDao;
import com.xxplay.model.persistent.app.AppBathInfoDetail;
import com.xxplay.model.persistent.app.AppInfos;
import com.xxplay.model.persistent.app.PackInfo;
import com.xxplay.service.gameCenter.IAppBathInfoDetailService;
import com.xxplay.service.gameCenter.IGameApkService;
import com.xxplay.service.gameCenter.IGamePicListService;
import com.xxplay.service.gameCenter.IGameService;

/**
 * 批量上传游戏任务详情服务 实现类
 * 
 * @Author:chenssy
 * @date:2016年5月14日 下午12:47:39
 * 
 */
@Service("appBathInfoDetailService")
public class AppBathInfoDetailServiceImpl implements IAppBathInfoDetailService{
	private final static  Logger LOGGER = LoggerFactory.getLogger(AppBathInfoDetailServiceImpl.class); 
	
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
		LOGGER.info("执行解析游戏任务开始....游戏名称：" + infoDetail.getAppName());
		AppInfos appInfos = new AppInfos();
		BeanUtils.copyProperties(infoDetail, appInfos);
		appInfos.setPackName(infoDetail.getApkName());
		//解析apk包
		PackInfo packInfo = null;
		try {
			String apkPath = AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_TEMP_PATH) + "\\" + infoDetail.getApkName();
			//icon图片路径为真实图片路径
			Map<String, Object> apkMapInfos = ApkReadUtils.readApk(apkPath, AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_ICON_REAL_PATH));
		} catch (Exception e) {
			LOGGER.error("执行解析游戏任务失败（解析apk包失败）,error:" + e.getMessage(), e);
			//标注失败
			infoDetail.setStatus(IConstant.GAME_SAVE_BATH_STATUS_FAILED);
			infoDetail.setErrorTips("解析apk包错误，apk包名：" + infoDetail.getApkName());
			appBathInfoDetailDao.updateByPrimaryKey(infoDetail);
			//抛出异常，提供给线程池来判断任务执行状态
			throw new RuntimeException(e);
		}
		
		try {
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
			infoDetail.setStatus(IConstant.GAME_SAVE_BATH_STATUS_SUCCESS);
			appBathInfoDetailDao.updateByPrimaryKey(infoDetail);
			
		} catch (Exception e) {
			LOGGER.error("执行解析游戏任务失败（保存游戏错误）....error:" + e.getMessage(), e);
			//标注失败
			infoDetail.setStatus(IConstant.GAME_SAVE_BATH_STATUS_FAILED);
			infoDetail.setErrorTips("保存游戏信息出错");
			appBathInfoDetailDao.updateByPrimaryKey(infoDetail);
			
			//抛出异常，提供给线程池来判断任务执行状态
			throw new RuntimeException(e);
		}
		LOGGER.info("执行游戏解析任务成功......游戏名称：" + infoDetail.getAppName());
	}
	
}
