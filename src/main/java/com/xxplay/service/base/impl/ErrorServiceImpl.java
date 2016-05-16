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
 * @Author:chenssy
 * @date:2016年4月9日
 * 
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
