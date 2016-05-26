package com.xxplay.common.exception;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.xxplay.common.core.AppContextUtils;

/**
 * 服务层异常类，添加错误码
 *
 * @Author:chenssy
 * @date:2016年4月9日
 */
@SuppressWarnings("serial")
public class ServiceException extends Exception implements Serializable{
	
	//错误码
	private String errorCode;
	
	//错误信息
	private String errorMessage;
	
	//错误展示信息
	private String errorTips;
	

	public ServiceException(){
	}
	
	public ServiceException(String errorCode){
		this.errorCode = errorCode;
	}
	
	public ServiceException(String errorCode,String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public ServiceException(String errorCode,Throwable throwable){
		super(throwable);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorTips() {
		if(StringUtils.isNotBlank(errorMessage)){
			errorTips = errorMessage;
		}else if(StringUtils.isNotBlank(errorCode)){
			errorTips = AppContextUtils.getErrorValue(errorCode);
		}
		return errorTips;
	}
	
}
