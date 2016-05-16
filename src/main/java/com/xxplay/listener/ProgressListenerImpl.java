package com.xxplay.listener;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

/**
 * 上传文件的进度监听器
 *
 * @Author:chenssy
 * @date:2016年5月1日 上午12:07:53
 * 
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
