package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	
	/**
	 * 所有用户登陆的页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/login")
	public String login(){
		return "login";
	}
	
	/**
	 * 只有管理员才能访问的页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/admin")
	public String admin(){
		return "admin";
	}

}
