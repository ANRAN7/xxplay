package com.xxplay.dao.base;

import java.util.List;

import com.xxplay.pojo.base.PubSysApr;

/**
 * 系统应用参数DAO层
 * 
 * @file:IPubSysAprDao.java
 * @package_name:com.xxplay.dao.base
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月9日
 */
public interface IPubSysAprDao {
    int deleteByPrimaryKey(String id);

    int insert(PubSysApr record);

    int insertSelective(PubSysApr record);

    PubSysApr selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PubSysApr record);

    int updateByPrimaryKey(PubSysApr record);
    
    /**
     * ��ȡϵͳ����������Ϣ
     *
     * @return
     *
     * @author:����
     * @data : 2016��4��7��
     */
    List<PubSysApr> selectPubSysAprList();
}