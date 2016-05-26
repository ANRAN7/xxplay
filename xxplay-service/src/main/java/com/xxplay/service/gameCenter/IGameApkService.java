package com.xxplay.service.gameCenter;

import com.xxplay.model.persistent.app.PackInfo;

/**
 * 游戏APK包服务类 接口
 * 
 * @Author:chenssy
 * @date:2016年5月3日 下午10:39:17
 * 
 */
public interface IGameApkService {

	/**
	 * 新增游戏包基本信息
	 *
	 * @param packInfo
	 *
	 * @author:chenssy
	 * @date : 2016年5月3日 下午11:17:57
	 */
	void addGameApkInfo(PackInfo packInfo);


}
