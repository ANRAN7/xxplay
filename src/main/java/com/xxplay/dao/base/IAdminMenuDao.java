package com.xxplay.dao.base;

import java.util.List;

import com.xxplay.pojo.base.AdminMenu;

public interface IAdminMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(AdminMenu record);

    int insertSelective(AdminMenu record);

    AdminMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminMenu record);

    int updateByPrimaryKey(AdminMenu record);

    /**
     * 获取管理员的菜单
     *
     * @param id
     * @return
     *
     * @author:陈明
     */
	List<AdminMenu> getAdminMenus(String adminId);

	/**
	 * 删除管理员的菜单信息 
	 *
	 * @param adminId
	 *
	 * @author:陈明
	 * @date : 2016年4月17日
	 */
	void delteAdminMenu(String adminId);
}