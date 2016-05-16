package com.xxplay.service.gameCenter.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xxplay.core.exception.ServiceException;
import com.xxplay.core.pojo.PageBean;
import com.xxplay.core.pojo.PageParams;
import com.xxplay.dao.app.IAppTypeDao;
import com.xxplay.pojo.app.AppType;
import com.xxplay.service.gameCenter.IGameCategoryService;

/**
 * 游戏分类服务层 实现类
 * 
 * @file:GameCategoryServiceImpl.java
 * @package_name:com.xxplay.service.gameCenter.impl
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @date:2016年4月22日 下午11:37:26
 */
@Service("gameCategoryService")
public class GameCategoryServiceImpl implements IGameCategoryService{
	private final static Logger LOGGER = Logger.getLogger(GameCategoryServiceImpl.class);

	@Resource
	private IAppTypeDao appTypeDao;
	
	@Override
	public PageBean queryGameCategoryList(Map<String, String> params) {
		int pageNo = Integer.valueOf(params.get("pageNo"));
		PageParams pageParams = PageParams.getInstance(pageNo,params);
		
		List<AppType> result = appTypeDao.getAppListPage(pageParams);
		int totalNo = appTypeDao.getAppListCountPage();
		
		return new PageBean(totalNo, result, pageNo);
	}

	@Override
	public void updateGameCategory(AppType appType) throws ServiceException {
		try {
			appTypeDao.updateByPrimaryKeySelective(appType);
		} catch (Exception e) {
			LOGGER.error("更改游戏分类信息失败");
			e.printStackTrace();
			throw new ServiceException(null, "更改游戏分类信息失败");
		}
	}

	@Override
	public List<AppType> getGameCategorys() {
		return appTypeDao.getAppTypes();
	}

	@Override
	public Map<Integer, String> getGameCategoryMaps() {
		Map<Integer, String> results = new HashMap<Integer, String>();
		List<AppType> types = getGameCategorys();
		for(AppType type : types){
			results.put(type.getTypeId(), type.getTypeName());
		}
		return results;
	}
	
	
}
