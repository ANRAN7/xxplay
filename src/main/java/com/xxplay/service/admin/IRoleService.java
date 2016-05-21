package com.xxplay.service.admin;

import java.util.List;

import com.xxplay.core.pojo.PageBean;
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

	/**
	 * 获取权限列表  分页处理
	 *
	 * @author:chenssy
	 * @data : 2016年5月21日 下午9:57:05
	 *
	 * @param pageNo
	 * @return
	 */
	PageBean getRoleListPage(int pageNo);

	/**
	 * 修改role
	 *
	 * @author:chenssy
	 * @data : 2016年5月21日 下午11:02:12
	 *
	 * @param role
	 */
	void updateRole(Role role);

}
