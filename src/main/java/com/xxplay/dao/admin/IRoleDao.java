package com.xxplay.dao.admin;

import java.util.List;

import com.xxplay.pojo.admin.Role;

/**
 * 管理员角色DAO层
 * 
 * @file:IRoleDao.java
 * @package_name:com.xxplay.dao.admin
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @date:2016年4月9日
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
     * @author:陈明
     * @date : 2016年4月16日
     */
	List<Role> getRoleList();
}