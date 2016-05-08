package com.xxplay.dao.app;

import com.xxplay.pojo.app.AppPicList;

public interface IAppPicListDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AppPicList record);

    int insertSelective(AppPicList record);

    AppPicList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppPicList record);

    int updateByPrimaryKey(AppPicList record);
}