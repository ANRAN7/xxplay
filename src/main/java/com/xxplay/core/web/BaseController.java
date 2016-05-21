package com.xxplay.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Spring mvc 基础Controller
 *
 * @Author:chenssy
 * @data:2016年5月21日 下午7:36:03
 */
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	  
	/**
	 * ThreadLocal确保高并发下每个请求的request，response都是独立的
	 */
	/** 当前线程的request 对象*/
    private static ThreadLocal<HttpServletRequest> currentThreadRequest = new ThreadLocal<HttpServletRequest>();
   
    /** 当前线程的response对象 **/
    private static ThreadLocal<HttpServletResponse> currentThreadResponse = new ThreadLocal<HttpServletResponse>();
    
    /** 当前线程的model对象 */ 
    private static ThreadLocal<Model> currentThreadModel = new ThreadLocal<Model>();
    
    /**
     * 初始化request、response对象<br>
     * ModelAttribute注解能够确保其标识的方法在每个控制器中的方法访问之前先调用
     *
     * @author:chenssy
     * @data : 2016年5月21日 下午7:46:43
     *
     * @param request
     * @param response
     */
    @ModelAttribute
    public void initReqAndRep(HttpServletRequest request , HttpServletResponse response,Model model){
    	currentThreadRequest.set(request);
    	currentThreadResponse.set(response);
    	currentThreadModel.set(model);
    }
    
    /**
     * 获取当前线程的request对象
     *
     * @author:chenssy
     * @data : 2016年5月21日 下午7:49:38
     *
     * @return
     */
    protected HttpServletRequest getRequest(){
    	return currentThreadRequest.get();
    }
    
    /**
     * 获取当前线程的response对象
     *
     * @author:chenssy
     * @data : 2016年5月21日 下午7:50:31
     *
     * @return
     */
    protected HttpServletResponse getResponse(){
    	return currentThreadResponse.get();
    }
    
    /**
     * 获取当前线程的session对象
     *
     * @author:chenssy
     * @data : 2016年5月21日 下午7:51:26
     *
     * @return
     */
    protected HttpSession getSession(){
    	return getRequest().getSession();
    }
    
    /**
     * 获取当前线程的model对象
     *
     * @author:chenssy
     * @data : 2016年5月21日 下午7:55:19
     *
     * @return
     */
    protected Model getModel(){
    	return currentThreadModel.get();
    }
}
