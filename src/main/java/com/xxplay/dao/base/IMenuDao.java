package com.xxplay.dao.base;

import java.util.List;

import com.xxplay.pojo.base.Menu;

/**
 * 系统菜单DAO层
 * 
 * @file:IMenuDao.java
 * @package_name:com.xxplay.dao.base
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @date:2016年4月9日
 */
public interface IMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

   /**
    * 获取菜单列表
    *
    * @return
    * 
    * @author : chenssy
    * @date : 2016年5月16日 下午6:21:53
    */
	List<Menu> queryMenuList();
}