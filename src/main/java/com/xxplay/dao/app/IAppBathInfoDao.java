package com.xxplay.dao.app;

import java.util.List;
import java.util.Map;

import com.xxplay.pojo.app.AppBathInfo;

public interface IAppBathInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AppBathInfo record);

    int insertSelective(AppBathInfo record);

    AppBathInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppBathInfo record);

    int updateByPrimaryKey(AppBathInfo record);
    
    List<AppBathInfo> selectByCondition(Map<String, Object> params);
}