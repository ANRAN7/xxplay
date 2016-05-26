package com.xxplay.common.core;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.xxplay.common.bean.MenuBean;

public class AppData {
	
	/** properties配置文件 */
	private static Properties PUB_PROPERTIES;
	
	/** 系统配置参数 **/
	private static Map<String,Map<String, String>>  APP_SYSAPR;

	/** 系统的菜单 */
	private static List<MenuBean> MENUS;
	
	/** 系统错误码 **/
	private static Map<String, String> errorMaps;
	
	@SuppressWarnings("static-access")
	public AppData(Properties pubProperties,Map<String,Map<String, String>> appSysAPr,List<MenuBean> menus,
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

	protected static List<MenuBean> getMENUS() {
		return MENUS;
	}

	protected static Map<String, String> getErrorMaps() {
		return errorMaps;
	}
	
}
