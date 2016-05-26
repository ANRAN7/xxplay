package com.xxplay.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.base.IPubSysAprDao;
import com.xxplay.model.persistent.base.PubSysApr;
import com.xxplay.service.base.IPubSysAprService;

@Service("pubSysAprService")
public class PubSysAprServiceImpl implements IPubSysAprService{

	@Resource
	IPubSysAprDao pubSysAprDao;

	@Override
	public List<PubSysApr> getPubSysAprs() {
		return pubSysAprDao.selectPubSysAprList();
	}
	
}
