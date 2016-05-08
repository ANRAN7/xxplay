package com.xxplay.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.base.IPubErrorDao;
import com.xxplay.pojo.base.PubError;
import com.xxplay.service.base.IErrorService;

/**
 * 系统错误代码服务层 实现类
 * 
 * @file:ErrorServiceImpl.java
 * @package_name:com.xxplay.service.base.impl
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月9日
 */
@Service("errorService")
public class ErrorServiceImpl implements IErrorService{
	
	@Resource
	private IPubErrorDao pubErrorDao;
	
	@Override
	public List<PubError> getErrorList() {
		return pubErrorDao.queryErrorList();
	}

}
