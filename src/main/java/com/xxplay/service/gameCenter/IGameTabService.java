package com.xxplay.service.gameCenter;

import java.util.List;
import java.util.Map;

import com.xxplay.pojo.app.AppTab;

/**
 * 游戏标签服务类  接口
 *
 * @Author:chenssy
 * @date:2016年4月24日 下午9:25:38
 * 
 */
public interface IGameTabService {

	/**
	 * 获取游戏标签
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月24日 下午10:26:54
	 */
	List<AppTab> getGameTabs();

	/**
	 * 获取游戏标签
	 * 
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年5月10日 下午10:25:56
	 */
	Map<Integer, String> getGameTabsMaps();

}
