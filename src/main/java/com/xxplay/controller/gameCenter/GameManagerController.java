package com.xxplay.controller.gameCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xxplay.core.base.AppConstants;
import com.xxplay.core.base.AppContextUtils;
import com.xxplay.core.exception.ServiceException;
import com.xxplay.pojo.admin.Admin;
import com.xxplay.pojo.app.AppInfos;
import com.xxplay.pojo.app.AppTab;
import com.xxplay.pojo.app.AppType;
import com.xxplay.pojo.app.PackInfo;
import com.xxplay.service.gameCenter.IGameCategoryService;
import com.xxplay.service.gameCenter.IGameService;
import com.xxplay.service.gameCenter.IGameTabService;
import com.xxplay.utils.ApkReadUtils;
import com.xxplay.utils.RequestFileUtils;

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
	
	/**
	 * 新增游戏页面
	 *
	 * @return
	 *
	 * @author:陈明
	 * @data : 2016年4月23日 下午7:05:04
	 */
	@RequestMapping("/addGame")
	public String addGameIndex(Model model){
		List<AppType> appTyps = gameCategoryService.getGameCategorys();
		model.addAttribute("categories",appTyps);
		
		List<AppTab> appTabs = gameTabService.getGameTabs();
		model.addAttribute("tabs",appTabs);
		
		return "game/gameManagerAdd";
	}
	
	/**
	 * 保存游戏的基本信息<br>
	 * 新增游戏的第一步
	 *
	 * @param params
	 * 				
	 * @param request
	 *
	 * @author:陈明
	 * @data : 2016年4月24日 下午11:43:42
	 */
	@RequestMapping("/saveGameInfoStep1")
	@ResponseBody
	public void saveGameInfoStep1(@RequestBody Map<String, String> params,HttpServletRequest request){
		request.getSession().setAttribute(AppConstants.SESSION_GAME_ADD_APPINFO, params);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveGameInfoStep3")
	@ResponseBody
	public Map<String, Object> saveGameInfoStep3(@RequestBody Map<String, String> params,HttpServletRequest request){
		HttpSession session = request.getSession();
		//游戏基本新
		Map<String, String> appInfos = (Map<String, String>) session.getAttribute(AppConstants.SESSION_GAME_ADD_APPINFO);
		//游戏图片列表
		List<String> picList = (List<String>) session.getAttribute(AppConstants.SESSION_GAME_ADD_PIC_LIST);
		//游戏apk信息
		PackInfo packInfo = (PackInfo) session.getAttribute(AppConstants.SESSION_GAME_ADD_PACKINFO);
		
		Admin admin = (Admin) session.getAttribute(AppConstants.SESSION_LOGIN_ADMIN);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//保存游戏信息
		try {
			int appId = gameService.addGame(admin,appInfos,params,picList,packInfo);
			resultMap.put("appId", appId);
			resultMap.put("resultFlag", "1");	//保存成功返回1
		} catch (Exception e) {
			resultMap.put("resultFlag", "0");	//保存失败返回0
			LOGGER.error("保存游戏失败...",e);
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 上传游戏图片列表
	 *
	 * @param request
	 * @throws ServiceException
	 *
	 * @author:陈明
	 * @data : 2016年4月27日 上午12:02:02
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadGamePicList")
	@ResponseBody
	public void uploadGamePicList(HttpServletRequest request) throws ServiceException{
		LOGGER.info("上传游戏列表图片....");
		//上传图片
		String path = request.getSession().getServletContext().getRealPath(AppContextUtils.getPropertiesValue(AppConstants.GAME_PIC_LIST_TEMP_PATH));
		String filePath = RequestFileUtils.uploadFile(request, "files", path);
		//上传成功，将图片路径保存到session中，以便于保存游戏信息时进行图片转移并删除该路径下相应的图片
		if(StringUtils.isNotBlank(filePath)){
        	//将图片地址入库，在最后一步是进行图片路径转移，同时删除该路径下的图片
            List<String> picList = (List<String>) request.getSession().getAttribute(AppConstants.SESSION_GAME_ADD_PIC_LIST);
            if(picList == null){
            	picList = new ArrayList<>();
            }
            picList.add(filePath);
            request.getSession().setAttribute(AppConstants.SESSION_GAME_ADD_PIC_LIST, picList);;
            
            LOGGER.info("上传游戏列表图片成功::::::" + filePath);
        }else{
        	LOGGER.info("上传游戏列表图片失败::::::");
        }
	}
	
	/**
	 * 上传App并解析
	 *
	 * @param request
	 *
	 * @author:陈明
	 * @data : 2016年4月30日 上午11:21:17
	 */
	@RequestMapping(value = "/uploadAppPackAndRead", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadAppPackAndRead(HttpServletRequest request,@RequestParam("apkFile") CommonsMultipartFile apkFile){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//上传APK
		String path = request.getSession().getServletContext().getRealPath(AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_TEMP_PATH));
		String filePath = RequestFileUtils.uploadFile(apkFile, path);
		//解析APK
		//icon 图片路径--图片路径保存到服务器路径中，在保存游戏信息时再将图片转移到oos中
		String iconPath = request.getSession().getServletContext().getRealPath(AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_ICON_TEMP_PATH));
		PackInfo packInfo = null;
		try {
			packInfo = ApkReadUtils.readApk(filePath,iconPath);
		} catch (Exception e) {
			resultMap.put("errorTips", "解析APK文件失败...");
		}
		resultMap.put("packInfo", packInfo);
		
		//将信息保存到session中
		request.getSession().setAttribute(AppConstants.SESSION_GAME_ADD_PACKINFO, packInfo);
		
		return resultMap;
	}
	
	/**
	 * 获取APK上传进度
	 *
	 * @param request
	 * @return
	 *
	 * @author:陈明
	 * @data : 2016年5月1日 下午12:04:39
	 */
	@RequestMapping("/getUploadApkProgress")
	@ResponseBody
	public Map<String, Object> getUploadApkProgress(HttpServletRequest request){
		Map<String,Object> result = new HashMap<>();
		if(request.getSession().getAttribute("progress") != null){
			double progress = (double) request.getSession().getAttribute("progress");
			result.put("progress", progress);
		}
		return result;
	}
	
	/**
	 * 上传并解析游戏信息模板
	 *
	 * @param request
	 * @param gameExcelModal
	 * @return
	 *
	 * @author:陈明
	 * @data : 2016年5月2日 下午1:17:54
	 */
	@RequestMapping("/uploadGameInfoAndRead")
	@ResponseBody
	public List<AppInfos> uploadGameInfoAndRead(HttpServletRequest request,@RequestParam("gameExcelModal") CommonsMultipartFile gameExcelModal){
		//上传模板
		
		//解析模板
		return null;
	}
}
