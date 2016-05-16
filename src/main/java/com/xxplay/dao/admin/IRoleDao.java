package com.xxplay.dao.admin;

import java.util.List;

import com.xxplay.pojo.admin.Role;

/**
 * 管理员角色DAO层
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 * 
 */
public interface IRoleDao {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 获取权限列表
     *
     * @return
     *
     * @author:chenssy
     * @date : 2016年4月16日
     */
	List<Role> getRoleList();
}