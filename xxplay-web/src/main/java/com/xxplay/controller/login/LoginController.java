package com.xxplay.controller.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxplay.common.core.AppConstants;
import com.xxplay.common.exception.ServiceException;
import com.xxplay.model.persistent.admin.Admin;
import com.xxplay.model.persistent.base.MenuItem;
import com.xxplay.service.admin.IAdminService;
import com.xxplay.service.base.IMenuService;

/**
 * 登录Controller
 * 
 * @Author:chenssy
 * @Copyright chenssy   2016 All Rights Reserved.
 * 
 * @date:2016年4月9日
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	private IAdminService adminService;
	
	@Resource
	private IMenuService menuService;
	
	/**
	 * 验证管理员登录信息
	 *
	 * @param params
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	@RequestMapping("/checkAdmin")
	public @ResponseBody Map<String, Object> checkAdmin(@RequestBody Map<String, String> params){
		String userName = params.get("userName");
		String password = params.get("password");
		
		boolean result = true;
		String error = "";
		//根据userName获取admin
		try {
			adminService.adminTranLogin(userName,password);
		} catch (ServiceException e) {
			result = false;
			error = e.getErrorTips();
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("error", error);
		
		return resultMap;
	}
	
	/**
	 * 用户登录
	 *
	 * @param userName
	 * @param password
	 * @return
	 *
	 * @author:chenssy
	 * @throws com.xxplay.common.exception.ServiceException
	 * @date : 2016年4月9日
	 */
	@RequestMapping("/login")
	public String login(String userName,String password,HttpServletRequest request) throws ServiceException{
		//验证用户登录
		Admin admin = adminService.adminTranLogin(userName,password);
		
		//用户保存到session中
		request.getSession().setAttribute(AppConstants.SESSION_LOGIN_ADMIN, admin);
		
		return "redirect:/login/toMain";
	}
	
	/**
	 * 用户登录成功后跳转到主界面<br>
	 * 在主界面主要做如下事情:<br>
	 * 1、获取用户所能操作的菜单
	 * 
	 * @return
	 *
	 * @author:chenssy
	 * @throws com.xxplay.common.exception.ServiceException
	 * @date : 2016年4月11日
	 */
	@RequestMapping("/toMain")
	public String toMain(HttpServletRequest request) throws ServiceException{
		Admin admin = (Admin) request.getSession().getAttribute(AppConstants.SESSION_LOGIN_ADMIN);
		//获取用户能够操作的菜单
		List<MenuItem> roots = menuService.getAdminMenuItem(admin);
		//保存用户的菜单到session中
		request.getSession().setAttribute(AppConstants.SESSION_ADMID_MENU_ITEM, roots);
		
		return "main/main";
	}
	
	/**
	 * 获取菜单
	 *
	 * @param request
	 * @return
	 * @throws com.xxplay.common.exception.ServiceException
	 *
	 * @author:chenssy
	 * @date : 2016年4月12日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryMenu")
	public @ResponseBody Map<String, Object> queryMenu(HttpServletRequest request) throws ServiceException{
		List<MenuItem> roots = (List<MenuItem>) request.getSession().getAttribute(AppConstants.SESSION_ADMID_MENU_ITEM);
	
		//如果用户菜单为null，通过用户获取然后保存到session中
		if(roots == null){
			Admin admin = (Admin) request.getSession().getAttribute(AppConstants.SESSION_LOGIN_ADMIN);
			roots = menuService.getAdminMenuItem(admin);
			
			request.getSession().setAttribute(AppConstants.SESSION_ADMID_MENU_ITEM, roots);
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("roots", roots);
		
		return resultMap;
	}
}
