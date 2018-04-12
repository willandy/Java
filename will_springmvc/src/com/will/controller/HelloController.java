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
 * 主要用于注解的方式来处理的后台方法
 * */
//@controller注解看可以让普通的javabean变成spring的类，这个很重要，重视
@Controller
public class HelloController {

	//逻辑视图名：方法一
	/*
	 *@requestMapping主要用来url映射,通过@RequestMapping里面的值，来映射controller,
	 *映射到类 HelloController里面具体的方法hello()
	 */
	@RequestMapping(value="/hello")//这里的正斜杠是指部署路径的根目录
	//传参的方法一：@RequestParam(value="username",required=false) String username
	//传参的方法二：直接传参String username
	//这里从url获得参数有上面的两种方式，那么如何把参数传到页面上去呢？
	/*
	 * 两种方式：一种是map形式的，另一种是springmvc自带的model格式，下面return用的逻辑视图名，
	 * 数据模型，就需要用model模型，也是map格式，属于键值对
	 */
	public String hello(@RequestParam(value="username",required=false) String username,Model model,HttpServletRequest request,HttpSession session){ //@RequestParam数据传输,required是判断url里面里设置参数是否是必须的，默认是true，改成false，是表示不是必须的，如果为发了，不设置参数，就会返回null
		System.out.println("hello,spring MVC!");
		//来接收传递的参数
		System.out.println("spring MVC！username="+username);//网页需调用http://localhost:8900/will_springmvc/hello?username=XXX
		//如果加了requestParam，url后面需要加参数，不加会报错，因为springmvc支持rest风格，会把url后面的参数，当做url的一部分，没有参数，会报请求的错，可以加上参数required来判断是否参数是必须的
		model.addAttribute("username", username);//数据模型，这个username，就可以用el表达式传到页面上去
		request.setAttribute("username", username);//但是注意model的作用域是和request一个级别的
		//既然是一个级别，也就是说，参数只能在请求的页面，也就是welcome里面才可以取到，其他页面取不到
		session.setAttribute("sessionid", "123");//使用session的话在页面上get一下就好
		/*
		 * 在页面上想取到sessionid：
		 *   <%
            String user =(String)session.getAttribute("sessionid");
            out.print(user);
             %>
		 */
		return "welcome";//注意这里是一个逻辑视图名，然后映射到web.xml里面的视图解析器
		//如果没有家requestParam,网页上直接调用：http://localhost:8900/will_springmvc/hello
	}
	
	//逻辑视图名：方法二
	@RequestMapping(value="/hello2")
	public ModelAndView hello(String username){
		System.out.println("hello2-----");
		ModelAndView mvView = new ModelAndView();
		mvView.setViewName("welcome");//返回一个逻辑视图名
		//mvView.addObject("username", username);//返回一个数据模型
		//mvView.addObject("string", username);//在jsp页面中就是${string}
		//mvView.addObject("user", new user());//如果是对象就key值为对象
		/*
		 * 注意，这里用ModelAndView里传值，如果用的是只传一个参数的方法，而不是
		 * 键值对，那么如果想取到username里面的值，那么前面要加上string，注意是
		 * 小写，这个string代表的是类型，如果传进去的是对象，那么前面加上对象名，
		 * 注意也是小写
		 */
		mvView.addObject(username);//在jsp页面中就是${string}
		return mvView;
	}
	
	//逻辑视图名：方法三
	@RequestMapping(value="/hello3")
	public String hello(String username,Map<String,Object> model){//不推荐用map，最好用springmvc自带model
		System.out.println("hello3=========");
		model.put("username", username);
		return "welcome";
	}
	
	
	
}
