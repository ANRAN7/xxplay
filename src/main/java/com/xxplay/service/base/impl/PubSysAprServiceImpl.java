package com.xxplay.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.base.IPubSysAprDao;
import com.xxplay.pojo.base.PubSysApr;
import com.xxplay.service.base.IPubSysAprService;

/**
 * ϵͳ��������ʵ���� 
 * 
 * @file:PubSysAprServiceImpl.java
 * @package_name:com.xxplay.service.base.impl
 * @Project:xxplay
 *
 * @Author:����
 * @Copyright ����   2016 All Rights Reserved.
 * 
 * @date:2016��4��7��
 */
@Service("pubSysAprService")
public class PubSysAprServiceImpl implements IPubSysAprService{

	@Resource
	IPubSysAprDao pubSysAprDao;

	@Override
	public List<PubSysApr> getPubSysAprs() {
		return pubSysAprDao.selectPubSysAprList();
	}
	
}
