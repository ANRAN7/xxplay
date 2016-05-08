package com.xxplay.core.pojo;

import java.util.List;

/**
 * 分页工具类
 * 
 * @file:PageBeanUtils.java
 * @package_name:com.xxplay.core.utils
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月16日
 */
public class PageBean {
	/** 当前页码，默认值1 */
	private int pageNo = 1;
	
	/** 总量 */
	private long totalNo ;
	
	/** 总页面数量 */
	private long totalPage;
	
	/** 页面大小，默认20 */
	private int pageSize = 20;
	
	/** 结果集 */
	private List<?> resultList;
	
	public PageBean(){
		
	}
	
	public PageBean(int totalNo,List<?> resultList,int pageNo){
		this.totalNo = totalNo;
		this.totalPage = totalNo % pageSize == 0 ? totalNo / pageSize : totalNo / pageSize + 1;
		this.resultList = resultList;
		this.pageNo = pageNo;
	}
	
	public PageBean(int totalNo,List<?> resultList , int pageSize,int pageNo){
		this.totalNo = totalPage;
		this.totalPage = totalNo % pageSize == 0 ? totalNo / pageSize : totalNo / pageSize + 1;
		this.resultList = resultList;
		this.pageNo = pageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(long totalNo) {
		this.totalNo = totalNo;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}
}
