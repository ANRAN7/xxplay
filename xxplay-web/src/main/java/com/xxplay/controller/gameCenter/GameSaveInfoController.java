package com.xxplay.controller.gameCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.JUtils.excel.ExcelReadHelper;
import com.xxplay.common.core.AppConstants;
import com.xxplay.common.core.AppContextUtils;
import com.xxplay.common.exception.ServiceException;
import com.xxplay.common.utils.xxplay.ApkReadUtils;
import com.xxplay.common.web.FileBaseController;
import com.xxplay.model.dto.exportExcel.GameInfoExcelModel;
import com.xxplay.model.persistent.admin.Admin;
import com.xxplay.model.persistent.app.AppTab;
import com.xxplay.model.persistent.app.AppType;
import com.xxplay.model.persistent.app.PackInfo;
import com.xxplay.service.gameCenter.IGameCategoryService;
import com.xxplay.service.gameCenter.IGameService;
import com.xxplay.service.gameCenter.IGameTabService;

/**
 * 保存游戏Controller
 * 
 * @Author:chenssy
 * @Copyright chenssy   2016 All Rights Reserved.
 * 
 * @date:2016年5月14日 下午12:28:56
 */
@Controller
@RequestMapping("/saveGameInfo")
public class GameSaveInfoController extends FileBaseController{
	private static final Logger LOGGER = LoggerFactory.getLogger(GameSaveInfoController.class);
	
	@Resource
	private IGameService gameService;
	
	@Resource
	private IGameCategoryService gameCategoryService;
	
		
	private IGameTabService gameTabService;
	
	/**
	 * 新增游戏页面
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月23日 下午7:05:04
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
	 * @author:chenssy
	 * @date : 2016年4月24日 下午11:43:42
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
	 * @throws com.xxplay.common.exception.ServiceException
	 *
	 * @author:chenssy
	 * @date : 2016年4月27日 上午12:02:02
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadGamePicList")
	@ResponseBody
	public void uploadGamePicList(HttpServletRequest request) throws ServiceException{
		LOGGER.info("上传游戏列表图片....");
		//上传图片
		String path = request.getSession().getServletContext().getRealPath(AppContextUtils.getPropertiesValue(AppConstants.GAME_PIC_LIST_TEMP_PATH));
		String filePath = uploadFile(request, "files", path);
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
	 * @author:chenssy
	 * @date : 2016年4月30日 上午11:21:17
	 */
	@RequestMapping(value = "/uploadAppPackAndRead", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadAppPackAndRead(HttpServletRequest request,@RequestParam("apkFile") CommonsMultipartFile apkFile){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//上传APK---只需要保存到某个磁盘即可
		String path = AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_TEMP_PATH);
		String filePath = uploadFile(apkFile, path);
		//解析APK
		//icon 图片路径--图片路径保存到服务器路径中，在保存游戏信息时再将图片转移到oos中
		String iconPath = request.getSession().getServletContext().getRealPath(AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_ICON_TEMP_PATH));
		PackInfo packInfo = null;
		try {
			Map<String, Object> apkInfos = ApkReadUtils.readApk(filePath,iconPath);
		} catch (Exception e) {
			resultMap.put("errorTips", "解析APK文件失败...");
		}
		resultMap.put("packInfo", packInfo);
		
		//将信息保存到session中
		request.getSession().setAttribute(AppConstants.SESSION_GAME_ADD_PACKINFO, packInfo);
		
		return resultMap;
	}
	
	/**
	 * 上传并解析游戏信息模板
	 *
	 * @param request
	 * @param gameExcelModal
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年5月2日 下午1:17:54
	 */
	@RequestMapping("/uploadGameInfoAndRead")
	@ResponseBody
	public Map<String, List<GameInfoExcelModel>> uploadGameInfoAndRead(HttpServletRequest request,@RequestParam("gameExcelModal") CommonsMultipartFile gameExcelModal){
		//上传模板
		String excelPath = request.getServletContext().getRealPath(AppConstants.GAME_MODEL_TEMP_PATH);
		String filePath = uploadFile(gameExcelModal, excelPath);
		//完成模板上传，开始解析工作
		Map<String, List<GameInfoExcelModel>> resultMap = new HashMap<String, List<GameInfoExcelModel>>();
		try {
			List<Object> appInfos = ExcelReadHelper.excelRead(filePath,
						new String[]{"id","appName","showName","searchKeys","apptag","appType","isOnline","appdesc","picList","apkName","evilLevel","recommFlag","recommLevel","recommWord"} , 
						GameInfoExcelModel.class);
			
			//获取游戏分类
			Map<Integer, String> categorys = gameCategoryService.getGameCategoryMaps();
			//解析完成，对数据进行分析，刷选出错误的文件，提供下载
			resultMap = analyzeExcel(appInfos,categorys);
			//将正确、错误的信息保存到session中
			request.getSession().setAttribute("gameInofErrors", resultMap.get("errors"));
			request.getSession().setAttribute("gameInofRights", resultMap.get("rights"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 批量保存游戏
	 *
	 * @param request
	 * 
	 * @author : chenssy
	 * @date : 2016年5月13日 下午12:35:01
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveBathGameInfo")
	@ResponseBody
	public boolean saveBathGameInfo(HttpServletRequest request){
		boolean resultFlag = true;
		List<GameInfoExcelModel> gameInfos = (List<GameInfoExcelModel>) request.getSession().getAttribute("gameInofRights");
		Admin admin = (Admin) request.getSession().getAttribute(AppConstants.SESSION_LOGIN_ADMIN);
		try {
			gameService.saveGameBathTask(gameInfos,admin);
		} catch (ServiceException e) {
			resultFlag = false;
		}
		return resultFlag;
	}

	/**
	 * 分析excel，将正确的、错误的内容提炼出来
	 *
	 * @param appInfos
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年5月9日 下午10:29:07
	 */
	private Map<String, List<GameInfoExcelModel>> analyzeExcel(List<Object> appInfos,Map<Integer, String> categorys) {
		List<GameInfoExcelModel> rights = new ArrayList<GameInfoExcelModel>();
		List<GameInfoExcelModel> errors = new ArrayList<GameInfoExcelModel>();
		GameInfoExcelModel bean = null;
		for(Object object : appInfos){
			bean = (GameInfoExcelModel) object;
			analyzeGameInfo(bean,categorys);
			if(StringUtils.isNotBlank(bean.getErrorTips())){
				errors.add(bean);
			}else{
				rights.add(bean);
			}
		}
		
		Map<String, List<GameInfoExcelModel>> result = new HashMap<String, List<GameInfoExcelModel>>();
		result.put("rights", rights);
		result.put("errors", errors);
		return result;
	}

	/**
	 * 分析游戏基本信息内容
	 *
	 * @param bean
	 *
	 * @author:chenssy
	 * @date : 2016年5月9日 下午10:38:04
	 */
	private void analyzeGameInfo(GameInfoExcelModel bean,Map<Integer, String> category) {
		StringBuilder errorTips = new StringBuilder();
		if(StringUtils.isBlank(bean.getAppName())){
			errorTips.append("游戏名称不能为空；");
		}
		if(StringUtils.isBlank(bean.getShowName())){
			errorTips.append("展示给用户查看的游戏名称不能为空;");
		}
		if(StringUtils.isBlank(bean.getSearchKeys())){
			errorTips.append("关键词不能为空");
		}
		if(StringUtils.isBlank(bean.getApptag())){
			errorTips.append("应用标签不能为空");
		}
		if(StringUtils.isBlank(bean.getAppType())){
			errorTips.append("应用分类不能为空");
		}else{
			String[] strings = bean.getAppType().split(",");
			StringBuffer categoryTxt = new StringBuffer();
			for(int i = 0 , j = strings.length ; i < j ; i++){
				categoryTxt.append(category.get(Integer.valueOf(strings[i]))).append(",");
			}
			bean.setCategoryTxt(categoryTxt.substring(0, categoryTxt.length() - 1).toLowerCase());
		}
		if(StringUtils.isBlank(bean.getIsOnline())){
			errorTips.append("是否为网游不能为空");
		}else{
			if("1".equals(bean.getIsOnline())){
				bean.setIsOnlineTxt("网游");
			}else{
				bean.setIsOnlineTxt("单机");
			}
		}
		if(StringUtils.isBlank(bean.getAppdesc())){
			errorTips.append("游戏说明不能为空");
		}
		if(StringUtils.isBlank(bean.getPicList())){
			errorTips.append("游戏图片不能为空");
		}
		if(StringUtils.isBlank(bean.getApkName())){
			errorTips.append("apk文件名不能为空");
		}
		
		bean.setErrorTips(errorTips.toString());
	}
}
