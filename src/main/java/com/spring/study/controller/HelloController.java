package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.study.domain.User;


@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET, value="/home")
	public String home(Model model){
		model.addAttribute("message", "hello word!");
		return "hello/home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/goto-post")
	public String gotoPost(User user){
		System.out.println("你好");
		return "post_home";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/home")
	public User postMethod(User user){
		return user;
	}
	
	/**
	 * 测试拦截器
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/test")
	public String test(Model model){
		System.out.println("controller interceptor");
		model.addAttribute("message", "hello word!");
		return "hello/home";
	}

}
