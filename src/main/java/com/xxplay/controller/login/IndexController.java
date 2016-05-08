package com.xxplay.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index
 * 
 * @file:IndexController.java
 * @package_name:com.xxplay.controller.admin
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月9日
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
