package com.xxplay.service.base;

import java.util.List;

import com.xxplay.model.persistent.base.AdminMenu;

/**
 * 管理员与菜单对应关系服务类  接口
 * 
 * @Author:chenssy
 * @date:2016年4月10日
 * 
 */
public interface IAdminMenuService {

	/**
	 * 后去管理员的可操作菜单
	 *
	 * @param adminId
	 * 					管理员编号
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月10日
	 */
	List<AdminMenu> getAdminMenus(String adminId);

	/**
	 * 删除管理员的菜单
	 *
	 * @param adminId
	 *
	 * @author:chenssy
	 * @date : 2016年4月17日
	 */
	void deleteAdminMenu(String adminId);

}
