package com.xxplay.dao.app;

import com.xxplay.model.persistent.app.PackInfo;

public interface IPackInfoDao {
    int deleteByPrimaryKey(String packid);

    int insert(PackInfo record);

    int insertSelective(PackInfo record);

    PackInfo selectByPrimaryKey(String packid);

    int updateByPrimaryKeySelective(PackInfo record);

    int updateByPrimaryKey(PackInfo record);
}