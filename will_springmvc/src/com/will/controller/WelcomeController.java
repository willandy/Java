package com.will.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/*
 * 主要用于BeanNameUrlHandlerMapping来处理的后台方法
 */
public class WelcomeController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("welcome,SpringMVC!");
		//这里返回的是一个逻辑视图名
		return new ModelAndView("welcome");
		//网页上直接调用：http://localhost:8900/will_springmvc/welcome
	}

}
