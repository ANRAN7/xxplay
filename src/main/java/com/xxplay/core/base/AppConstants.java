package com.xxplay.core.base;

/**
 * 
 * 
 * @file:AppConstants.java
 * @package_name:com.xxplay.core.base
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月9日
 */
public class AppConstants {
	/**
	 * propertie配置文件
	 */
	public static final String SYSTEM_PROPS = "env.app";
	
	/** 用户登录信息 **/
	public static final String SESSION_LOGIN_ADMIN = "loginAdmin";
	
	/** 用户菜单 */
	public static final String SESSION_ADMID_MENU_ITEM = "adminMenuItem";
	
	/** 增加游戏基本信息--第一步 */
	public static final String SESSION_GAME_ADD_APPINFO = "addGameInfo";
	
	/** 增加游戏包信息--第二步 */
	public static final String SESSION_GAME_ADD_PACKINFO = "addGamePackInfo";
	
	/** 增加游戏其他信息：第三步 */
	public static final String SESSION_GAME_ADD_OTHERINFO = "addGameOtherInfo";
	
	/** 增加游戏基本信息-游戏 */
	public static final String SESSION_GAME_ADD_PIC_LIST = "addGamePicList";
	
	/** 游戏图片列表临时保存路径 */
	public static final String GAME_PIC_LIST_TEMP_PATH = "game_info_icon_path";
	
	/** 游戏APK保存临时路径 */
	public static final String GAME_APP_PACK_TEMP_PATH = "game_app_pack_path";
	
	/** 游戏APK IOCN临时保存路径 */
	public static final String GAME_APP_PACK_ICON_TEMP_PATH = "game_app_pack_icon_path";
	
	/** 游戏图片列表真实保存路径 */
	public static final String GAME_PIC_LIST_REAL_PATH = "game_info_icon_real_path";
	
	/** 游戏APK保存真实保存路径 */
	public static final String GAME_APP_PACK_REAL_PATH = "game_app_pack_real_path";
	
	/** 游戏APK IOCN真实保存路径 */
	public static final String GAME_APP_PACK_ICON_REAL_PATH = "game_app_pack_icon_real_path";
	
	/** 游戏批量上传模板保存路径 */
	public static final String GAME_MODEL_TEMP_PATH = "game_model_temp_path";
	
}
