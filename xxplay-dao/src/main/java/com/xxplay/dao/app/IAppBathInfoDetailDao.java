package com.xxplay.dao.app;

import java.util.List;

import com.xxplay.model.persistent.app.AppBathInfoDetail;

public interface IAppBathInfoDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AppBathInfoDetail record);
    
    int insertBath(List<AppBathInfoDetail> item);

    int insertSelective(AppBathInfoDetail record);

    AppBathInfoDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppBathInfoDetail record);

    int updateByPrimaryKey(AppBathInfoDetail record);

	List<AppBathInfoDetail> selectByBathId(int infoId);
}