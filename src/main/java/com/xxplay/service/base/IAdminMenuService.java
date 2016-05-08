package com.xxplay.service.base;

import java.util.List;

import com.xxplay.pojo.base.AdminMenu;

/**
 * 管理员与菜单对应关系服务类  接口
 * 
 * @file:IAdminMenuService.java
 * @package_name:com.xxplay.service.base
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月10日
 */
public interface IAdminMenuService {

	/**
	 * 后去管理员的可操作菜单
	 *
	 * @param adminId
	 * 					管理员编号
	 * @return
	 *
	 * @author:陈明
	 * @data : 2016年4月10日
	 */
	List<AdminMenu> getAdminMenus(String adminId);

	/**
	 * 删除管理员的菜单
	 *
	 * @param adminId
	 *
	 * @author:陈明
	 * @data : 2016年4月17日
	 */
	void deleteAdminMenu(String adminId);

}
