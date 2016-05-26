package com.xxplay.service.admin.impl;

import org.springframework.stereotype.Service;

import com.JUtils.encrypt.EncryptAndDecryptUtils;
import com.xxplay.common.core.AppContextUtils;
import com.xxplay.common.exception.ServiceException;
import com.xxplay.common.utils.xxplay.Des;
import com.xxplay.service.admin.IPasswordService;

/**
 * 密码服务  实现类
 *
 * @Author:chenssy
 * @data:2016年5月21日 下午6:07:22
 */
@Service("passwordService")
public class PasswordServiceImpl implements IPasswordService{
	@Override
	public String getUserLoginPassword(String password) {
		//登录密码DES解密
		password = Des.strDec(password, AppContextUtils.getPropertiesValue("login-key"), null, null);
		//先是md5加密
		password = EncryptAndDecryptUtils.md5Encrypt(password);
		//再是AES加密
		password = EncryptAndDecryptUtils.aesEncrypt(password, AppContextUtils.getPropertiesValue("login-key"));
		return password;
	}

	@Override
	public void checkAdminPassword(String loginPassword, String adminPassword) throws ServiceException {
		//登录密码md5加密
		loginPassword = EncryptAndDecryptUtils.md5Encrypt(loginPassword);
		adminPassword = EncryptAndDecryptUtils.aesDecrypt(adminPassword, AppContextUtils.getPropertiesValue("login-key"));
	
		//密码模式，判断登录是否需要密码
		String passwordModel =  AppContextUtils.getPropertiesValue("passWordModel");
		
		if("1".equals(passwordModel) && !loginPassword.equals(adminPassword)){
			throw new ServiceException("EC10002");
		}
	}
}
