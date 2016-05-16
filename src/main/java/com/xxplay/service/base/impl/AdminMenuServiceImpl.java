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
 * @Author:chenssy
 * @date:2016年4月10日
 * 
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
