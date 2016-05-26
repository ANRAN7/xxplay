package com.xxplay.service.gameCenter;

import java.util.List;

/**
 * 游戏图片列表服务 接口
 * 
 * @Author:chenssy
 * @date:2016年5月3日 下午10:50:36
 * 
 */
public interface IGamePicListService {

	/**
	 * 增加游戏图片列表
	 *
	 * @param picList
	 * @param appId
	 *
	 * @author:chenssy
	 * @date : 2016年5月4日 下午9:03:13
	 */
	void saveGamePickList(List<String> picList, Integer appId);

}
