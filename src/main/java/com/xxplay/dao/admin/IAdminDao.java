package com.xxplay.dao.admin;

import java.util.List;

import com.xxplay.core.pojo.PageParams;
import com.xxplay.pojo.admin.Admin;

/**
 * 管理员DAO层
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 * 
 */
public interface IAdminDao {
    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 根据用户名获取Admin 
     *
     * @param userName
     * @return
     *
     * @author:chenssy
     * @date : 2016年4月9日
     */
	Admin queryAdminByUserName(String userName);

	/**
	 * 获取管理员列表，分页
	 *
	 * @param pageParams
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月16日
	 */
	List<Admin> queryAdminListPage(PageParams pageParams);

	/**
	 * 获取总记录数 
	 *
	 * @param pageParams
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月16日
	 */
	int queryAdminCountPage(PageParams pageParams);
}