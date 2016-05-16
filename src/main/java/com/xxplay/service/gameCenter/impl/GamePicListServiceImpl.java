package com.xxplay.service.gameCenter.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.app.IAppPicListDao;
import com.xxplay.pojo.app.AppPicList;
import com.xxplay.service.gameCenter.IGamePicListService;

/**
 * 游戏图片列表服务 实现类
 * 
 * @Author:chenssy
 * @date:2016年5月3日 下午10:51:12
 * 
 */
@Service("gamePicListService")
public class GamePicListServiceImpl implements IGamePicListService{
	
	@Resource
	private IAppPicListDao appPicListDao;
	
	@Override
	public void saveGamePickList(List<String> picList, Integer appId) {
		AppPicList appPic = null;
		int i = 1;
		for(String string : picList){
			appPic = new AppPicList();
			appPic.setAppinfoId(appId);
			appPic.setPicurl(string);
			appPic.setOrderNo(i);
			i++;
			
			//保存基本信息
			appPicListDao.insert(appPic);
		}
	}
}
