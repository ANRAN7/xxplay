package com.xxplay.dao.app;

import java.util.List;

import com.xxplay.pojo.app.AppTab;

public interface IAppTabDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AppTab record);

    int insertSelective(AppTab record);

    AppTab selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppTab record);

    int updateByPrimaryKey(AppTab record);

	List<AppTab> selectAppTabs();
}