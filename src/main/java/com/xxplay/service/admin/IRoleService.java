package com.xxplay.service.admin;

import java.util.List;

import com.xxplay.pojo.admin.Role;

/**
 * 用户权限角色服务  接口
 * 
 * @file:IRoleService.java
 * @package_name:com.xxplay.service.admin
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月16日
 */
public interface IRoleService {

	/**
	 * 获取权限列表
	 *
	 * @return
	 *
	 * @author:陈明
	 * @data : 2016年4月16日
	 */
	List<Role> getRoleSelectModal();

}
