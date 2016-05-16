package com.xxplay.core.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.xxplay.core.pojo.SelectModal;
import com.xxplay.pojo.base.Menu;


public class AppContextUtils {

	/**
	 * 获取Bean<br>
	 * 【注：一般不推荐这样直接获取Bean，因为这样Spring则会与系统产生了强耦合】
	 *
	 * @param beanId
	 * @return
	 *
	 * @author:陈明
	 * @date : 2016年4月9日
	 */
	public static Object getBean(String beanId) {
		return AppContextInit.getContext().getBean(beanId);
	}

	/**
	 * 获取指定的Select
	 *
	 * @param key
	 * @return
	 *
	 * @author:陈明
	 * @date : 2016年4月9日
	 */
	public static List<SelectModal> getSelectModals(String key){
		List<SelectModal> selects = new ArrayList<SelectModal>();
		if(StringUtils.isNotBlank(key)){
			Map<String, String> apps = AppData.getAPP_SYSAPR().get(key);
			Iterator<String> iterator = apps.keySet().iterator();
			
			String value = null;
			String name = null;
			while(iterator.hasNext()){
				 value = iterator.next();
				 name = apps.get(value);
				
				selects.add(new SelectModal(name, value));
			}
		}
		return selects;
	}
	
	/**
	 * 获取系统参数配置表中指定code的value的name值
	 * @param code
	 * @param value
	 * @return
	 *
	 * @author:陈明
	 * @date : 2016年4月9日
	 */
	public static String getSysAprName(String code,String value){
		String name = "";
		if(StringUtils.isNotBlank(code) && StringUtils.isNotBlank(value)){
			Map<String, String> appMap = AppData.getAPP_SYSAPR().get(code);
			if(appMap != null){
				name = appMap.get(value);
			}
		}
		return name;
	}
	
	/**
	 * 获取properties的值
	 *
	 * @param key
	 * 			properties的key
	 * @return
	 *
	 * @author:陈明
	 * @date : 2016年4月9日
	 */
	public static String getPropertiesValue(String key){
		if(StringUtils.isNotBlank(key)){
			return AppData.getPUB_PROPERTIES().getProperty(key);
		}
		return ""; 
	}
	
	/**
	 * 获取指定的错误码
	 *
	 * @param errorCode
	 * @return
	 *
	 * @author:陈明
	 * @date : 2016年4月10日
	 */
	public static String getErrorValue(String errorCode){
		if(StringUtils.isNotBlank(errorCode)){
			return AppData.getErrorMaps().get(errorCode);
		}
		return "";
	}
	
	/**
	 * 获取系统的菜单
	 *
	 * @return
	 *
	 * @author:陈明
	 * @date : 2016年4月10日
	 */
	public static List<Menu> getMenus(){
		return AppData.getMENUS();
	}
}
