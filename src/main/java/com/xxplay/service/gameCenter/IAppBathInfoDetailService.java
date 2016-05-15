package com.xxplay.service.gameCenter;

import java.util.List;

import com.xxplay.pojo.app.AppBathInfoDetail;

/**
 * 批量上传游戏任务详情服务 接口 
 * 
 * @file:IAppBathInfoDetailService.java
 * @package_name:com.xxplay.service.gameCenter
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年5月14日 下午12:47:12
 */
public interface IAppBathInfoDetailService {

	/**
	 * 批量保存游戏详情信息
	 *
	 * @param details
	 *
	 * @author:陈明
	 * @data : 2016年5月14日 下午1:05:53
	 */
	void addBathInfo(List<AppBathInfoDetail> details);

}
