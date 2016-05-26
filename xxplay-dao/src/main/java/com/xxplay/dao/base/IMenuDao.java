package com.xxplay.dao.base;

import java.util.List;

import com.xxplay.model.persistent.base.Menu;

/**
 * 系统菜单DAO层
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 * 
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