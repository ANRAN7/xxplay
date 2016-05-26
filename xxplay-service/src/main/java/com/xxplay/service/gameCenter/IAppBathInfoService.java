package com.xxplay.service.gameCenter;

import java.util.List;
import java.util.Map;

import com.xxplay.model.persistent.app.AppBathInfo;

/**
 * 游戏批量任务服务 接口
 *
 * @Author:chenssy
 * @date:2016年5月14日 下午12:41:00
 * 
 */
public interface IAppBathInfoService {

	/**
	 * 保存批量信息
	 *
	 * @param bathInfo
	 *
	 * @author:chenssy
	 * @date : 2016年5月14日 下午12:50:07
	 */
	void saveBathInfo(AppBathInfo bathInfo);

	/**
	 * 根据查询条件获取批次任务 
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年5月14日 下午11:31:20
	 */
	List<AppBathInfo> getAppBathInfoByCondition(Map<String, Object> params);

	/**
	 * 修改批次任务
	 *
	 * @param bathInfo
	 *
	 * @author:chenssy
	 * @date : 2016年5月15日 上午11:45:24
	 */
	void updateAppBathInfo(AppBathInfo bathInfo);

}
