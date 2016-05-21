package com.xxplay.service.admin.impl;

import org.springframework.stereotype.Service;

import com.JUtils.encrypt.EncryptAndDecryptUtils;
import com.xxplay.core.base.AppContextUtils;
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
		//先是md5加密
		password = EncryptAndDecryptUtils.md5Encrypt(password);
		//再是AES加密
		password = EncryptAndDecryptUtils.aesEncrypt(password, AppContextUtils.getPropertiesValue("login-key"));
		return password;
	}

}
