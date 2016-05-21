package com.xxplay.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxplay.core.base.AppConstants;
import com.xxplay.core.pojo.PageBean;
import com.xxplay.core.web.BaseController;
import com.xxplay.pojo.admin.Admin;
import com.xxplay.pojo.admin.Role;
import com.xxplay.service.admin.IRoleService;

/**
 * 角色管理Controller
 *
 * @Author:chenssy
 * @data:2016年5月21日 下午7:55:55
 */
@Controller
@RequestMapping("/role")
public class RoleManagerController extends BaseController{
	@Resource
	private IRoleService roleService;
	/**
	 * 权限管理界面
	 *
	 * @author:chenssy
	 * @data : 2016年5月21日 下午7:58:52
	 *
	 * @return
	 */
	@RequestMapping("/roleIndex")
	public String roleIndex(){
		return "/admin/roleManagerIndex";
	}
	
	/**
	 * 查询角色列表
	 *
	 * @author:chenssy
	 * @data : 2016年5月21日 下午9:50:25
	 *
	 * @param params
	 * @return
	 */
	@RequestMapping("/queryRoleList")
	@ResponseBody
	public PageBean queryRoleList(@RequestBody Map<String, Integer> params){
		return roleService.getRoleListPage(params.get("pageNo"));
	}
	
	@RequestMapping("/updateRoleStatus")
	@ResponseBody
	public Map<String, Object> updateRoleStatus(@RequestBody Role role){
		boolean result = true;
		
		try{
			roleService.updateRole(role);
		}catch(Exception e){
			result = false;
		}
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", result);
		return resultMap;
	}
}
