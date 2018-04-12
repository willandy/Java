package com.will.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/*
 * 
 * ��Ҫ����ע��ķ�ʽ������ĺ�̨����
 * */
//@controllerע�⿴��������ͨ��javabean���spring���࣬�������Ҫ������
@Controller
public class HelloController {

	//�߼���ͼ��������һ
	/*
	 *@requestMapping��Ҫ����urlӳ��,ͨ��@RequestMapping�����ֵ����ӳ��controller,
	 *ӳ�䵽�� HelloController�������ķ���hello()
	 */
	@RequestMapping(value="/hello")//�������б����ָ����·���ĸ�Ŀ¼
	//���εķ���һ��@RequestParam(value="username",required=false) String username
	//���εķ�������ֱ�Ӵ���String username
	//�����url��ò�������������ַ�ʽ����ô��ΰѲ�������ҳ����ȥ�أ�
	/*
	 * ���ַ�ʽ��һ����map��ʽ�ģ���һ����springmvc�Դ���model��ʽ������return�õ��߼���ͼ����
	 * ����ģ�ͣ�����Ҫ��modelģ�ͣ�Ҳ��map��ʽ�����ڼ�ֵ��
	 */
	public String hello(@RequestParam(value="username",required=false) String username,Model model,HttpServletRequest request,HttpSession session){ //@RequestParam���ݴ���,required���ж�url���������ò����Ƿ��Ǳ���ģ�Ĭ����true���ĳ�false���Ǳ�ʾ���Ǳ���ģ����Ϊ���ˣ������ò������ͻ᷵��null
		System.out.println("hello,spring MVC!");
		//�����մ��ݵĲ���
		System.out.println("spring MVC��username="+username);//��ҳ�����http://localhost:8900/will_springmvc/hello?username=XXX
		//�������requestParam��url������Ҫ�Ӳ��������ӻᱨ����Ϊspringmvc֧��rest��񣬻��url����Ĳ���������url��һ���֣�û�в������ᱨ����Ĵ����Լ��ϲ���required���ж��Ƿ�����Ǳ����
		model.addAttribute("username", username);//����ģ�ͣ����username���Ϳ�����el���ʽ����ҳ����ȥ
		request.setAttribute("username", username);//����ע��model���������Ǻ�requestһ�������
		//��Ȼ��һ������Ҳ����˵������ֻ���������ҳ�棬Ҳ����welcome����ſ���ȡ��������ҳ��ȡ����
		session.setAttribute("sessionid", "123");//ʹ��session�Ļ���ҳ����getһ�¾ͺ�
		/*
		 * ��ҳ������ȡ��sessionid��
		 *   <%
            String user =(String)session.getAttribute("sessionid");
            out.print(user);
             %>
		 */
		return "welcome";//ע��������һ���߼���ͼ����Ȼ��ӳ�䵽web.xml�������ͼ������
		//���û�м�requestParam,��ҳ��ֱ�ӵ��ã�http://localhost:8900/will_springmvc/hello
	}
	
	//�߼���ͼ����������
	@RequestMapping(value="/hello2")
	public ModelAndView hello(String username){
		System.out.println("hello2-----");
		ModelAndView mvView = new ModelAndView();
		mvView.setViewName("welcome");//����һ���߼���ͼ��
		//mvView.addObject("username", username);//����һ������ģ��
		//mvView.addObject("string", username);//��jspҳ���о���${string}
		//mvView.addObject("user", new user());//����Ƕ����keyֵΪ����
		/*
		 * ע�⣬������ModelAndView�ﴫֵ������õ���ֻ��һ�������ķ�����������
		 * ��ֵ�ԣ���ô�����ȡ��username�����ֵ����ôǰ��Ҫ����string��ע����
		 * Сд�����string����������ͣ��������ȥ���Ƕ�����ôǰ����϶�������
		 * ע��Ҳ��Сд
		 */
		mvView.addObject(username);//��jspҳ���о���${string}
		return mvView;
	}
	
	//�߼���ͼ����������
	@RequestMapping(value="/hello3")
	public String hello(String username,Map<String,Object> model){//���Ƽ���map�������springmvc�Դ�model
		System.out.println("hello3=========");
		model.put("username", username);
		return "welcome";
	}
	
	
	
}
