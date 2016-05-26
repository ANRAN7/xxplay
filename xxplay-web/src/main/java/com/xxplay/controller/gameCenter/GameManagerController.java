package com.xxplay.controller.gameCenter;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xxplay.model.persistent.app.AppType;
import com.xxplay.service.gameCenter.IGameCategoryService;
import com.xxplay.service.gameCenter.IGameService;
import com.xxplay.service.gameCenter.IGameTabService;

/**
 * 游戏管理控制层
 * 
 * @Author:chenssy
 * @Copyright chenssy   2016 All Rights Reserved.
 * 
 * @date:2016年4月19日
 */
@Controller
@RequestMapping("/gameManager")
public class GameManagerController {
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
	 * @author:chenssy
	 * @date : 2016年4月20日
	 */
	@RequestMapping("/gameManagerIndex")
	public String gameManagerIndex(Model model){
		List<AppType> appTyps = gameCategoryService.getGameCategorys();
		
		model.addAttribute("categories",appTyps);
		
		return "game/gameManagerIndex";
	}
}
