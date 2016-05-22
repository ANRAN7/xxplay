package com.xxplay.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxplay.core.exception.ServiceException;
import com.xxplay.core.pojo.PageBean;
import com.xxplay.pojo.admin.Admin;
import com.xxplay.pojo.admin.Role;
import com.xxplay.service.admin.IAdminService;
import com.xxplay.service.admin.IRoleService;

/**
 * 用户管理Controller
 *
 * @Author:chenssy
 * @date:2016年4月13日
 */
@Controller
@RequestMapping("/admin")
public class AdminManagerController {
	
	@Resource
	private IAdminService adminService;
	
	@Resource
	private IRoleService roleService;
	
	/**
	 * 管理员管理界面
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月13日
	 */
	@RequestMapping("/adminIndex")
	public String adminIndex(){
		return "admin/adminManagerIndex";
	}
	
	/**
	 * 获取管理员列表
	 *
	 * @param params
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月16日
	 */
	@RequestMapping("/queryAdminList")
	public @ResponseBody PageBean queryAdminList(@RequestBody Map<String, String> params){
		return adminService.queryAdminListPage(params);
	}
	
	/**
	 * 管理员编辑页面
	 *
	 * @param model
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月17日
	 */
	@RequestMapping("/addManagerInit")
	public String addManagerInit(Model model){
		List<Role> roles = roleService.getRoleSelectModal();
		model.addAttribute("roles", roles);
		
		return "admin/addManager";
	}
	
	@RequestMapping("/addManager")
	public @ResponseBody Map<String, Object> addManager(@RequestBody Map<String, String> params){
		boolean resultFlag = true;
		String errorTips = null;
		
		String password = params.get("password");
		String rePassword = params.get("rePassword");
		if(!password.equals(rePassword)){
			resultFlag = false;
			errorTips = "登录密码和确认密码不一致，请重新输入.";
		}else{
			Admin admin = new Admin();
			admin.setPassword(password);
			admin.setRealName(params.get("realName"));
			admin.setUserName(params.get("userName"));
			admin.setRoleId(params.get("roleId"));
			
			try {
				adminService.addAdmin(admin);
			} catch (ServiceException e) {
				resultFlag = false;
				errorTips = e.getErrorTips();
			}
		}
			
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultFlag", resultFlag);
		resultMap.put("errorTips", errorTips);
		
		return resultMap;
	}
	
	/**
	 * 更改管理员状态
	 *
	 * @param params
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月17日
	 */
	@RequestMapping("/updateAdminStatus")
	public @ResponseBody Map<String, Object> updateAdminStatus(@RequestBody Map<String, String> params){
		boolean result = true;
		try {
			adminService.updateAdminStatus(params.get("id"),params.get("status"));
		} catch (Exception e) {
			result = false;
		}
		
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	/**
	 * 删除管理员 
	 *
	 * @param id
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月17日
	 */
	@RequestMapping("/deleteAdmin")
	public @ResponseBody Map<String, Object> deleteAdmin(@RequestBody Map<String, String> params){
		boolean result = true;
		try {
			adminService.deleteAdmin(params.get("id"));
		} catch (Exception e) {
			result = false;
		}
		
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	@RequestMapping("/updateManagerInit")
	public String updateManagerInit(String id,Model model){
		Admin admin = adminService.getAdminById(id);
		List<Role> roles = roleService.getRoleSelectModal();
		
		model.addAttribute("roles", roles);
		model.addAttribute("admin",admin);
		 
		return "/admin/adminUpdate";
	}
	
	/**
	 * 修改管理员基本信息
	 *
	 * @param admin
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月19日
	 */
	@RequestMapping("/updateManager")
	public @ResponseBody Map<String, Object> updateManager(@RequestBody Admin admin){
		boolean result = true;
		
		adminService.updateAdmin(admin);
		
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", result);
		return resultMap;
	}
}
