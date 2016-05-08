package com.xxplay.core.base;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.xxplay.pojo.base.Menu;

/**
 * ϵͳ��ʼ���������������
 * 
 * @file:AppData.java
 * @package_name:com.xxplay.core.base
 * @Project:xxplay
 *
 * @Author:����
 * @Copyright ����   2016 All Rights Reserved.
 * 
 * @data:2016��4��8��
 */
public class AppData {
	
	/** properties配置文件 */
	private static Properties PUB_PROPERTIES;
	
	/** 系统配置参数 **/
	private static Map<String,Map<String, String>>  APP_SYSAPR;

	/** 系统的菜单 */
	private static List<Menu> MENUS;
	
	/** 系统错误码 **/
	private static Map<String, String> errorMaps;
	
	@SuppressWarnings("static-access")
	AppData(Properties pubProperties,Map<String,Map<String, String>> appSysAPr,List<Menu> menus,
			Map<String, String> errorMaps){
		this.PUB_PROPERTIES = pubProperties;
		this.APP_SYSAPR = appSysAPr;
		this.MENUS = menus;
		this.errorMaps = errorMaps;
	}

	protected static Properties getPUB_PROPERTIES() {
		return PUB_PROPERTIES;
	}

	protected static Map<String, Map<String, String>> getAPP_SYSAPR() {
		return APP_SYSAPR;
	}

	protected static List<Menu> getMENUS() {
		return MENUS;
	}

	protected static Map<String, String> getErrorMaps() {
		return errorMaps;
	}
	
}
