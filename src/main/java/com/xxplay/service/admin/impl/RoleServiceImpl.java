package com.xxplay.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.admin.IRoleDao;
import com.xxplay.pojo.admin.Role;
import com.xxplay.service.admin.IRoleService;

/**
 * 用户权限服务 实现类
 * 
 * @file:RoleServiceImpl.java
 * @package_name:com.xxplay.service.admin.impl
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月16日
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	@Resource
	private IRoleDao roleDao;

	@Override
	public List<Role> getRoleSelectModal() {
		return roleDao.getRoleList();
	}
	
}
