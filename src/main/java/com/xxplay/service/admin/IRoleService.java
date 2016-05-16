package com.xxplay.service.admin;

import java.util.List;

import com.xxplay.pojo.admin.Role;

/**
 * 用户权限角色服务  接口
 * 
 * @Author:chenssy
 * @date:2016年4月16日
 * 
 */
public interface IRoleService {

	/**
	 * 获取权限列表
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月16日
	 */
	List<Role> getRoleSelectModal();

}
