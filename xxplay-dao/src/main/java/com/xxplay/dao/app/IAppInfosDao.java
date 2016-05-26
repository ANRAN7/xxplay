package com.xxplay.dao.app;

import com.xxplay.model.persistent.app.AppInfos;

public interface IAppInfosDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AppInfos record);

    int insertSelective(AppInfos record);

    AppInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppInfos record);

    int updateByPrimaryKey(AppInfos record);
}