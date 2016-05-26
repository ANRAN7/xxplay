package com.xxplay.service.gameCenter.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.app.IAppTabDao;
import com.xxplay.model.persistent.app.AppTab;
import com.xxplay.service.gameCenter.IGameTabService;

/**
 * 游戏标签服务类  实现类
 * 
 * @Author:chenssy
 * @date:2016年4月24日 下午9:26:13
 * 
 */
@Service("gameTabService")
public class GameTabServiceImpl implements IGameTabService{
	
	@Resource
	private IAppTabDao appTabDao;
	
	@Override
	public List<AppTab> getGameTabs() {
		return appTabDao.selectAppTabs();
	}

	@Override
	public Map<Integer, String> getGameTabsMaps() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		List<AppTab> tabs = getGameTabs();
		for(AppTab tab : tabs){
			result.put(tab.getId(), tab.getTabName());
		}
		return result;
	}

}
