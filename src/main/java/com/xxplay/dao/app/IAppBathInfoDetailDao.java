package com.xxplay.dao.app;

import com.xxplay.pojo.app.AppBathInfoDetail;

public interface IAppBathInfoDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AppBathInfoDetail record);

    int insertSelective(AppBathInfoDetail record);

    AppBathInfoDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppBathInfoDetail record);

    int updateByPrimaryKey(AppBathInfoDetail record);
}