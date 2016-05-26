package com.xxplay.common.utils.xxplay;

/**
 * 系统常量
 * 
 * @Author:chenssy
 * @date:2016年4月17日
 */
public class IConstant {
	/** 用户状态：启用 */
	public static final String	ADMIN_STUTS_USING = "1";
	/** 用户状态：停用 */
	public static final String	ADMIN_STUTS_STOPED = "0";
	
	/** 游戏状态：--启用：1 */
	public static final String GAME_STATUS_USING = "1";
	/** 游戏状态：--禁用：0 */
	public static final String GAME_STATUS_DISABLED = "0";
	/** 游戏状态：--已删除：2 */
	public static final String GAME_STATUS_DELETED = "2";
	
	/** 保存游戏批量任务状态--未开始 */
	public static final String GAME_SAVE_BATH_STATUS_NOTSTART = "1";
	/** 保存游戏批量任务状态--进行中 */
	public static final String GAME_SAVE_BATH_STATUS_TSTARTING = "2";
	/** 保存游戏批量任务状态--成功 */
	public static final String GAME_SAVE_BATH_STATUS_SUCCESS = "3";
	/** 保存游戏批量任务状态--部分成功 */
	public static final String GAME_SAVE_BATH_STATUS_PARTIALSUCCESS = "4";
	/** 保存游戏批量任务状态--失败*/
	public static final String GAME_SAVE_BATH_STATUS_FAILED = "4";
}
