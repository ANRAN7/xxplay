package com.xxplay.service.gameCenter;

import java.util.List;
import java.util.Map;

import com.xxplay.pojo.admin.Admin;
import com.xxplay.pojo.app.PackInfo;

/**
 * 游戏服务 接口
 * 
 * @file:IGameService.java
 * @package_name:com.xxplay.service.gameCenter
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月19日
 */
public interface IGameService {

	/**
	 * 新增游戏<br>
	 * 游戏保存主要涉及如下：游戏基本信息、游戏APK信息、游戏图片列表、游戏标签
	 *
	 * @param admin			
	 * 						登录用户
	 * @param appInfoMap	
	 * 						游戏基本新
	 * @param appOthers 
	 * 						游戏补充信息
	 * @param picList	
	 * 						游戏图片列表
	 * @param packInfo	
	 * 						apk信息
	 * @return	id
	 * 						游戏的id
	 * @author:陈明
	 * @data : 2016年5月3日 下午10:33:59
	 */
	int addGame(Admin admin, Map<String, String> appInfoMap,
			Map<String, String> params, List<String> picList, PackInfo packInfo);

}
