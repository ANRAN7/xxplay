package com.xxplay.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取客户端的Request的信息
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 */
public class ClientRequestUtils {
	
	/**
	 * 获取IP地址
	 *
	 * @param request
	 * 					request
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	public static String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getRemoteAddr();
	    }
	    return ip;
	}
	
	/**
	 * 获取MAC地址
	 *
	 * @param ip
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	public static String getMAC(String ip){
		String str = "";
        String macAddress = "";
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
	}
}
