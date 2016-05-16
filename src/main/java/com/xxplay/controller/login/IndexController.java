package com.xxplay.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index
 * 
 * @Author:chenssy
 * @Copyright chenssy   2016 All Rights Reserved.
 * 
 * @date:2016年4月9日
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
