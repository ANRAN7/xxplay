package com.xxplay.dao.base;

import java.util.List;

import com.xxplay.pojo.base.PubSysApr;

/**
 * 系统应用参数DAO层
 * 
 * @Author:chenssy
 * 
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
     * @date : 2016��4��7��
     */
    List<PubSysApr> selectPubSysAprList();
}