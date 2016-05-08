package com.xxplay.listener;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

/**
 * 上传文件的进度监听器
 * 
 * @file:ProgressListenerImpl.java
 * @package_name:com.xxplay.listener
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年5月1日 上午12:07:53
 */
public class ProgressListenerImpl implements ProgressListener {

	
	private HttpSession session;
	
	public ProgressListenerImpl(HttpSession session) {
		super();
		this.session = session;
	}

	@Override
	public void update(long bytesRead, long contentLength, int items) {
		session.setAttribute("progress", (double)bytesRead/contentLength);
	}

}
