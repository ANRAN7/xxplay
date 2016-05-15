package com.xxplay.service.gameCenter;

import java.util.List;
import java.util.Map;

import com.xxplay.pojo.app.AppBathInfo;

/**
 * 游戏批量任务服务 接口
 * 
 * @file:AppBathInfoService.java
 * @package_name:com.xxplay.service.gameCenter
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年5月14日 下午12:41:00
 */
public interface IAppBathInfoService {

	/**
	 * 保存批量信息
	 *
	 * @param bathInfo
	 *
	 * @author:陈明
	 * @data : 2016年5月14日 下午12:50:07
	 */
	void saveBathInfo(AppBathInfo bathInfo);

	/**
	 * 根据查询条件获取批次任务 
	 *
	 * @return
	 *
	 * @author:陈明
	 * @data : 2016年5月14日 下午11:31:20
	 */
	List<AppBathInfo> getAppBathInfoByCondition(Map<String, Object> params);

	/**
	 * 修改批次任务
	 *
	 * @param bathInfo
	 *
	 * @author:陈明
	 * @data : 2016年5月15日 上午11:45:24
	 */
	void updateAppBathInfo(AppBathInfo bathInfo);

}
