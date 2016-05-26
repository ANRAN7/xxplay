package com.xxplay.model.dto.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页查询参数工具类，继承HashMap<br>
 * 
 * @Author:chenssy
 * @date:2016年4月16日
 * 
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class PageParams extends HashMap{
	/** 页面大小 */
	private static int pageSize = 20;
	
	/**
	 * 私有构造器
	 */
	private PageParams(){
	}
	
	/**
	 * 获取分页参数,默认大小20
	 *
	 * @param pageNo
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月16日
	 */
	@SuppressWarnings("unchecked")
	public static PageParams getInstance(int pageNo){
		PageParams params = new PageParams();
		pageNo = pageNo < 1 ? 1 : pageNo;
		int begin = (pageNo - 1) * pageSize;
		int end = pageNo * pageSize;
		
		params.put("begin",begin);
		params.put("end", end);
		
		return params;
	}
	
	/**
	 * 获取分页参数，默认页面大小20
	 *
	 * @param pageNo
	 * 				当前页码
	 * @param map
	 * 				参数
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月16日
	 */
	@SuppressWarnings({ "unchecked" })
	public static PageParams getInstance(int pageNo,Map map){
		PageParams params = new PageParams();
		pageNo = pageNo < 1 ? 1 : pageNo;
		int begin = (pageNo - 1) * pageSize;
		int end = pageNo * pageSize;
		
		params.put("begin",begin);
		params.put("end", end);
		if(map != null){
			params.putAll(map);
		}
		
		return params;
	}
	
	/**
	 * 获取分页参数
	 *
	 * @param pageNo
	 * 				当前页码
	 * @param pageSize
	 * 				页面大小
	 * @param map
	 * 				参数
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月16日
	 */
	@SuppressWarnings({ "unchecked" })
	public static PageParams getInstance(int pageNo,int pageSize,Map map){
		PageParams params = new PageParams();
		pageNo = pageNo < 1 ? 1 : pageNo;
		pageSize = pageSize < 1 ? PageParams.pageSize : pageSize;
		
		int begin = (pageNo - 1) * pageSize;
		int end = pageNo * pageSize;
		
		params.put("begin",begin);
		params.put("end", end);
		if(map != null){
			params.putAll(map);
		}
		return params;
	}
}
