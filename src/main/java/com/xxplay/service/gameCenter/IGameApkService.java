package com.xxplay.service.gameCenter;

import com.xxplay.pojo.app.PackInfo;

/**
 * 游戏APK包服务类 接口
 * 
 * @file:IGameApkService.java
 * @package_name:com.xxplay.service.gameCenter
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @date:2016年5月3日 下午10:39:17
 */
public interface IGameApkService {

	/**
	 * 新增游戏包基本信息
	 *
	 * @param packInfo
	 *
	 * @author:陈明
	 * @date : 2016年5月3日 下午11:17:57
	 */
	void addGameApkInfo(PackInfo packInfo);


}
