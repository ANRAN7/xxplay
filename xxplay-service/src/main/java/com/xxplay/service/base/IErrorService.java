package com.xxplay.service.base;

import java.util.List;

import com.xxplay.model.persistent.base.PubError;

/**
 * 系统错误代码服务层 接口
 *
 * @Author:chenssy
 * @date:2016年4月9日
 * 
 */
public interface IErrorService {

	/**
	 * 获取系统的错误代码 
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	List<PubError> getErrorList();

}
