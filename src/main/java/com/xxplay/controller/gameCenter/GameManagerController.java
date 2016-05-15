package com.xxplay.controller.gameCenter;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xxplay.pojo.app.AppType;
import com.xxplay.service.gameCenter.IGameCategoryService;
import com.xxplay.service.gameCenter.IGameService;
import com.xxplay.service.gameCenter.IGameTabService;

/**
 * 游戏管理控制层
 * 
 * @file:GameManagerController.java
 * @package_name:com.xxplay.controller
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月19日
 */
@Controller
@RequestMapping("/gameManager")
public class GameManagerController {
	private static final Logger LOGGER = Logger.getLogger(GameCategoryManagerController.class);
	
	@Resource
	private IGameCategoryService gameCategoryService;
	
	@Resource 
	private IGameTabService gameTabService;
	
	@Resource
	private IGameService gameService;
	
	/**
	 * 游戏列表
	 *
	 * @return
	 *
	 * @author:陈明
	 * @data : 2016年4月20日
	 */
	@RequestMapping("/gameManagerIndex")
	public String gameManagerIndex(Model model){
		List<AppType> appTyps = gameCategoryService.getGameCategorys();
		
		model.addAttribute("categories",appTyps);
		
		return "game/gameManagerIndex";
	}
}
