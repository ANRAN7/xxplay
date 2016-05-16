package com.xxplay.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.base.IAdminMenuDao;
import com.xxplay.pojo.base.AdminMenu;
import com.xxplay.service.base.IAdminMenuService;

/**
 * 管理员与菜单对应关系服务类  实现类 
 * 
 * @file:AdminMenuServiceImpl.java
 * @package_name:com.xxplay.service.base.impl
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @date:2016年4月10日
 */
@Service("adminMenuService")
class AdminMenuServiceImpl implements IAdminMenuService{
	@Resource
	private IAdminMenuDao adminMenuDao;

	@Override
	public List<AdminMenu> getAdminMenus(String adminId) {
		return adminMenuDao.getAdminMenus(adminId);
	}

	@Override
	public void deleteAdminMenu(String adminId) {
		adminMenuDao.delteAdminMenu(adminId);
	}
}
