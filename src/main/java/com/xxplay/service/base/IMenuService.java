package com.xxplay.service.base;

import java.util.List;

import com.xxplay.core.exception.ServiceException;
import com.xxplay.pojo.admin.Admin;
import com.xxplay.pojo.base.Menu;
import com.xxplay.pojo.base.MenuItem;

/**
 * 系统菜单服务类 接口
 * 
 * @file:IMenuService.java
 * @package_name:com.xxplay.service.base
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @date:2016年4月10日
 */
public interface IMenuService {

	/**
	 * 获取系统菜单
	 *
	 * @return
	 *
	 * @author:陈明
	 * @date : 2016年4月10日
	 */
	List<Menu> queryMenuList();

	/**
	 * 获取管理员可操作菜单
	 *
	 * @param admin
	 * @return
	 *
	 * @author:陈明
	 * @throws ServiceException 
	 * @date : 2016年4月10日
	 */
	List<MenuItem> getAdminMenuItem(Admin admin) throws ServiceException;

}
