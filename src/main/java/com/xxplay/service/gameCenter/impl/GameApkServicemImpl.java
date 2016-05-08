package com.xxplay.service.gameCenter.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.core.utils.DateUtils;
import com.xxplay.dao.app.IPackInfoDao;
import com.xxplay.pojo.app.PackInfo;
import com.xxplay.service.gameCenter.IGameApkService;
import com.xxplay.utils.IConstant;

/**
 * 游戏apk服务类 实现类
 * 
 * @file:GameApkServicemImpl.java
 * @package_name:com.xxplay.service.gameCenter.impl
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年5月3日 下午10:49:46
 */
@Service("gameApkService")
public class GameApkServicemImpl implements IGameApkService{

	@Resource
	private IPackInfoDao packInfoDao;
	
	@Override
	public void addGameApkInfo(PackInfo packInfo) {
		packInfo.setCreateTime(DateUtils.getCurrentDate());
		packInfo.setStatus(IConstant.GAME_STATUS_USING);
		
		packInfoDao.insert(packInfo);
	}

}
