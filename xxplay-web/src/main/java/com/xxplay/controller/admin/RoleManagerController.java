package com.xxplay.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxplay.common.web.BaseController;
import com.xxplay.model.dto.page.PageBean;
import com.xxplay.model.persistent.admin.Role;
import com.xxplay.service.admin.IRoleService;
import com.xxplay.service.base.IMenuService;

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
	
	@Resource
	private IMenuService menuService;
	
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
	
	/**
	 * 修改角色状态
	 *
	 * @author:chenssy
	 * @data : 2016年5月22日 上午9:50:34
	 *
	 * @param role
	 * @return
	 */
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
	
	/**
	 * 新增角色
	 *
	 * @author:chenssy
	 * @data : 2016年5月22日 上午9:52:45
	 *
	 * @return
	 */
	@RequestMapping("/addRoleInit")
	public String addRoleInit(){
		return "/admin/roleEdit";
	}
}
