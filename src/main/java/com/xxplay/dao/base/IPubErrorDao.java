package com.xxplay.dao.base;

import java.util.List;

import com.xxplay.pojo.base.PubError;

/**
 * 系统错误码Dao层 
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 * 
 */
public interface IPubErrorDao {
    int deleteByPrimaryKey(String id);

    int insert(PubError record);

    int insertSelective(PubError record);

    PubError selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PubError record);

    int updateByPrimaryKey(PubError record);
    
	List<PubError> queryErrorList();
}