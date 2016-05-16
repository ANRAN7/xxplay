package com.xxplay.service.base;

import java.util.List;

import com.xxplay.pojo.base.PubError;

/**
 * 系统错误代码服务层 接口
 * 
 * @file:IErrorService.java
 * @package_name:com.xxplay.service.base
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @date:2016年4月9日
 */
public interface IErrorService {

	/**
	 * 获取系统的错误代码 
	 *
	 * @return
	 *
	 * @author:陈明
	 * @date : 2016年4月9日
	 */
	List<PubError> getErrorList();

}
