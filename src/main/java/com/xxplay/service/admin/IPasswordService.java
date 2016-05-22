package com.xxplay.service.admin;

import com.xxplay.core.exception.ServiceException;

/**
 * 密码服务接口
 *
 * @Author:chenssy
 * @data:2016年5月21日 下午6:06:26
 */
public interface IPasswordService {

	/**
	 * 获取用户登录密码的密文 
	 *
	 * @author:chenssy
	 * @data : 2016年5月21日 下午6:09:55
	 *
	 * @param password	
	 * 					登录密码
	 * @return
	 */
	String getUserLoginPassword(String password);

	/**
	 * 校验登录密码
	 *
	 * @author:chenssy
	 * @data : 2016年5月22日 下午3:39:36
	 *
	 * @param loginPassword
	 * 							登录密码
	 * @param adminPassword
	 * 							管理员密码
	 * @throws ServiceException 
	 */
	void checkAdminPassword(String loginPassword, String adminPassword) throws ServiceException;

}
