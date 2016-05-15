package com.xxplay.service.gameCenter.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.app.IAppBathInfoDetailDao;
import com.xxplay.pojo.app.AppBathInfoDetail;
import com.xxplay.service.gameCenter.IAppBathInfoDetailService;

/**
 * 批量上传游戏任务详情服务 实现类
 * 
 * @file:AppBathInfoDetailServiceImpl.java
 * @package_name:com.xxplay.service.gameCenter.impl
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年5月14日 下午12:47:39
 */
@Service("appBathInfoDetailService")
public class AppBathInfoDetailServiceImpl implements IAppBathInfoDetailService{
	
	@Resource
	private IAppBathInfoDetailDao appBathInfoDetailDao;

	@Override
	public void addBathInfo(List<AppBathInfoDetail> details) {
		appBathInfoDetailDao.insertBath(details);
	}
}
