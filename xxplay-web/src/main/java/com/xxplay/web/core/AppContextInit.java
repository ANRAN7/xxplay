package com.xxplay.web.core;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xxplay.common.bean.MenuBean;
import com.xxplay.common.core.AppConstants;
import com.xxplay.common.core.AppData;
import com.xxplay.model.persistent.base.Menu;
import com.xxplay.model.persistent.base.PubError;
import com.xxplay.model.persistent.base.PubSysApr;
import com.xxplay.service.base.IErrorService;
import com.xxplay.service.base.IMenuService;
import com.xxplay.service.base.IPubSysAprService;

/**
 * 系统初始化,跟随Spring容器一起启动<br>
 * 主要加载系统配置参数，对系统应用环境进行配置管理
 *
 * @Author:chenssy
 * @date:2016年4月9日
 * 
 */
public class AppContextInit extends ContextLoaderListener{
	private final static Logger logger = LoggerFactory.getLogger(AppContextInit.class);
	
	private static ApplicationContext context;
	
	@SuppressWarnings("static-access")
	public void contextInitialized(ServletContextEvent context) {
		logger.info("开始初始化系统配置");
		super.contextInitialized(context);
		
		//加载ApplicationContext
		this.context = WebApplicationContextUtils.getRequiredWebApplicationContext(context.getServletContext());
		
		logger.info("加载properties配置文件");
		Properties properties = this.loadProperties(AppConstants.SYSTEM_PROPS);
		
		logger.info("加载系统配置参数");
		Map<String,Map<String, String>> appSysApr = initAppSysApr();
		
		logger.info("加载系统菜单");
		List<MenuBean> menus = initMenu();
		
		logger.info("加载系统错误码");
		Map<String, String> errorMaps = initErrors();
		
		logger.info("系统初始化完成");
		
		new AppData(properties, appSysApr, menus,errorMaps);
	}

	/**
	 * 加载错误代码
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	private Map<String, String> initErrors() {
		IErrorService errorService = (IErrorService) getBean("errorService");
		List<PubError> errors = errorService.getErrorList();
		Map<String, String> errorMaps = new HashMap<String, String>();
		
		for(PubError error:errors){
			errorMaps.put(error.getCode(), error.getShowmsg());
		}
		return errorMaps;
	}

	/**
	 * 加载系统菜单<br>
	 * AppData位于xxplay-common包中，为了系统依赖问题，使用menuBeans中间件来完成
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	private List<MenuBean> initMenu() {
		IMenuService menuService = (IMenuService) getBean("menuService");
		List<Menu> menus = menuService.queryMenuList();
		List<MenuBean> menuBeans = new ArrayList<MenuBean>();
		
		BeanUtils.copyProperties(menus, menuBeans);
		
		return menuBeans;
	}

	/**
	 * 加载系统参数配置
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	private Map<String,Map<String, String>> initAppSysApr() {
		IPubSysAprService pubSysAprService = (IPubSysAprService) getBean("pubSysAprService");
		
		Map<String,Map<String, String>> sysPar = new HashMap<String, Map<String,String>>();
		List<PubSysApr> list = pubSysAprService.getPubSysAprs();
		Map<String, String> codeMap = null;
		for(PubSysApr sysApr : list){
			codeMap = sysPar.get(sysApr.getCode());
			if(codeMap == null){
				codeMap = new HashMap<String, String>();
			}
			codeMap.put(sysApr.getValue(), sysApr.getName());
			sysPar.put(sysApr.getCode(), codeMap);
		}
		return sysPar;
	}

	/**
	 * 加载properties配置文件
	 *
	 * @param file
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	@SuppressWarnings("rawtypes")
	private Properties loadProperties(String file) {
		Properties props = new Properties();
		ResourceBundle bundle = ResourceBundle.getBundle(file);
		Enumeration enums = bundle.getKeys();
		Object key = null;
		Object value = null;
		for (; enums.hasMoreElements(); props.put(key, value)) {
			key = enums.nextElement();
			value = bundle.getString(key.toString());
		}

		bundle = null;
		
		return props;
	}
	
	public ApplicationContext getContext() {
		return context;
	}
	
	public Object getBean(String beanId) {
		return getContext().getBean(beanId);
	}
}
