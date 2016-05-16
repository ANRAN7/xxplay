package com.xxplay.service.gameCenter;

import java.util.List;
import java.util.Map;

import com.xxplay.core.exception.ServiceException;
import com.xxplay.pojo.admin.Admin;
import com.xxplay.pojo.app.AppInfos;
import com.xxplay.pojo.app.PackInfo;
import com.xxplay.pojo.exportExcel.GameInfoExcelModel;

/**
 * 游戏服务 接口
 * 
 * @Author:chenssy
 * @date:2016年4月19日
 * 
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
	 * @author:chenssy
	 * @date : 2016年5月3日 下午10:33:59
	 */
	int addGame(Admin admin, Map<String, String> appInfoMap,
			Map<String, String> params, List<String> picList, PackInfo packInfo);

	/**
	 * 保存批量游戏任务<br>
	 * 主要处理逻辑如下：<br>
	 * 1.保存一个任务，生成批次号，然后将所有的记录全部管理到改批次号下，然后批量保存即可<br>
	 * 2.开启另一个线程，对改任务进行处理，全部进行批量保存<br>
	 *
	 * @param gameInfos
	 * 
	 * @author : chenssy
	 * @throws ServiceException 
	 * @date : 2016年5月13日 下午12:45:00
	 */
	void saveGameBathTask(List<GameInfoExcelModel> gameInfos,Admin admin) throws ServiceException;

	/**
	 * 保存基本信息
	 *
	 * @param appInfos
	 * 
	 * @author : chenssy
	 * @date : 2016年5月16日 下午4:05:24
	 */
	void saveGameInfo(AppInfos appInfos);

}
