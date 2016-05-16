package com.xxplay.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @desc:文件工具类
 * 
 * @Author:chenssy
 * @date:2014年8月7日
 * 
 */
public class FileUtils {
	
	/**
	 * @desc:判断指定路径是否存在，如果不存在，根据参数决定是否新建
	 * @autor:chenssy
	 * @date:2014年8月7日
	 *
	 * @param filePath
	 * 			指定的文件路径
	 * @param isNew
	 * 			true：新建、false：不新建
	 * @return 存在返回TRUE，不存在返回FALSE
	 */
	public static boolean isExist(String filePath,boolean isNew){
		File file = new File(filePath);
		if(!file.exists() && isNew){    
			return file.mkdirs();    //新建文件路径
		}
		return false;
	}
	
	/**
	 * 获取指定文件的大小
	 *
	 * @param file
	 * @return
	 * @throws Exception
	 *
	 * @author:chenssy
	 * @date : 2016年4月30日 下午9:10:12
	 */
	@SuppressWarnings("resource")
	public static int getFileSize(File file) throws Exception {
		int size = 0;
		if (file.exists()) {
			FileInputStream fis = null;
			fis = new FileInputStream(file);
			size = fis.available();
		} else {
			file.createNewFile();
		}
		return size;
	}
	
	public static String getFileMD5(File file){
		if (!file.exists() || !file.isFile()) {  
            return null;  
        }  
        MessageDigest digest = null;  
        FileInputStream in = null;  
        byte buffer[] = new byte[1024];  
        int len;  
        try {  
            digest = MessageDigest.getInstance("MD5");  
            in = new FileInputStream(file);  
            while ((len = in.read(buffer, 0, 1024)) != -1) {  
                digest.update(buffer, 0, len);  
            }  
            in.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
        BigInteger bigInt = new BigInteger(1, digest.digest());  
        return bigInt.toString(16);  
	}
}
