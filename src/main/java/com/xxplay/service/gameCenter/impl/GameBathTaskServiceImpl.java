package com.xxplay.service.gameCenter.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.core.utils.DateUtils;
import com.xxplay.pojo.app.AppBathInfo;
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

	private class excuteGameBathTask implements Runnable{
		private int bathId ;
		public excuteGameBathTask(int bathId){
			this.bathId = bathId;
		}
		@Override
		public void run() {
			
		}
	}
}
