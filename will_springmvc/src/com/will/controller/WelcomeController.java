package com.will.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/*
 * ��Ҫ����BeanNameUrlHandlerMapping������ĺ�̨����
 */
public class WelcomeController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("welcome,SpringMVC!");
		//���ﷵ�ص���һ���߼���ͼ��
		return new ModelAndView("welcome");
		//��ҳ��ֱ�ӵ��ã�http://localhost:8900/will_springmvc/welcome
	}

}
