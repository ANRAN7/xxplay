package com.xxplay.service.gameCenter;

import java.util.List;

import com.xxplay.pojo.app.AppBathInfoDetail;

/**
 * 批量上传游戏任务详情服务 接口 
 *
 * @Author:chenssy
 * @date:2016年5月14日 下午12:47:12
 * 
 */
public interface IAppBathInfoDetailService {

	/**
	 * 批量保存游戏详情信息
	 *
	 * @param details
	 *
	 * @author:chenssy
	 * @date : 2016年5月14日 下午1:05:53
	 */
	void addBathInfo(List<AppBathInfoDetail> details);

	/**
	 * 根据批次ID获取所有任务详情
	 *
	 * @param bathId
	 * 					批次号
	 * @return
	 * 
	 * @author : chenssy
	 * @date : 2016年5月16日 上午11:36:16
	 */
	List<AppBathInfoDetail> getDetailByBathId(int bathId);

	/**
	 * 执行批次详细任务<br>
	 *
	 * @param infoDetail
	 * 
	 * @author : chenssy
	 * @date : 2016年5月16日 下午12:52:46
	 */
	void executeAppBathInfoDetail(AppBathInfoDetail infoDetail);

}
