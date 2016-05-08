package com.xxplay.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 上传文件的工具类
 * 
 * @file:RequestFileUtils.java
 * @package_name:com.xxplay.utils
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月26日 下午11:51:36
 */
public class RequestFileUtils {
	/**
	 * 上传图片<br>
	 *
	 * @param request
	 * 				request请求
	 * @param inputName
	 * 				对应form中的file name
	 * @param path
	 * 				文件保存路径
	 * @return
	 * 			上传成功返回图片路径，否则返回null
	 *
	 * @author:陈明
	 * @data : 2016年4月26日 下午11:53:22
	 */
	public static String uploadFile(HttpServletRequest request,String inputName,String path){
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;   
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(inputName);  
        
        return uploadFile(file, path);
	}
	
	public static String uploadFile(CommonsMultipartFile file,String path){
		//文件名
        String fileName = file.getOriginalFilename();
        //文件路径
        String tempPath = path;
	
        //如果路径不存在，则新建
        File dirPath = new File(tempPath);  
        if (!dirPath.exists()) {  
            dirPath.mkdirs();  
        }
        
        String filePath = tempPath + "/" +fileName;
        File uploadFile = new File(filePath);
        try {
			FileCopyUtils.copy(file.getBytes(), uploadFile);
		} catch (IOException e) {
			filePath = null;
		} 
        return filePath;
	}
}
