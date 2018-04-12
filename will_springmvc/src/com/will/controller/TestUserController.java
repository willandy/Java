package com.will.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.will.exception.UserException;
import com.will.pojo.User;

@Controller
/*
 * 现在来判定model的内存地址
 */
@RequestMapping(value="/test")//http://localhost:8900/will_springmvc/user/list
public class TestUserController {

	private Map<String,User> userList1 = new HashMap<String,User>();
	private Map<String,User> userList2 = new HashMap<String,User>();
	
	/*
	 * 即使值一样，但是是两张hash表，互不影响
	 */
	public TestUserController(){
		userList1.put("1", new User("1","Test01","111111","test@test.com"));
		userList1.put("2", new User("2","Test02","222222","test@test.com"));
		userList1.put("3", new User("3","Test03","333333","test@test.com"));
		
		userList2.put("1", new User("1","Test01","111111","test@test.com"));
		userList2.put("2", new User("2","Test02","222222","test@test.com"));
		userList2.put("3", new User("3","Test03","333333","test@test.com"));
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model1,Model model2,Model model3,Map<String,Object> map1,Map<String,Object> map2){
//		model1.addAttribute("userList", userList1);
//		System.out.println("model1-->"+model1);
//		model2.addAttribute("userList2",userList2);
//		System.out.println("model2-->"+model2);
//		System.out.println("model2-->"+model3);
		/*
		 * 上面出现的结果为：
		 * model1-->{userList={3=com.will.pojo.User@6db66fb4, 2=com.will.pojo.User@645fcab1, 1=com.will.pojo.User@4cf45df2}}
           model2-->{userList={3=com.will.pojo.User@6db66fb4, 2=com.will.pojo.User@645fcab1, 1=com.will.pojo.User@4cf45df2}, userList2={3=com.will.pojo.User@3f43e256, 2=com.will.pojo.User@1c09c8d, 1=com.will.pojo.User@c65ede1}}
           model2-->{userList={3=com.will.pojo.User@6db66fb4, 2=com.will.pojo.User@645fcab1, 1=com.will.pojo.User@4cf45df2}, userList2={3=com.will.pojo.User@3f43e256, 2=com.will.pojo.User@1c09c8d, 1=com.will.pojo.User@c65ede1}}
		 */
//		model1.addAttribute("userList", userList1);
//		model2.addAttribute("userList2",userList2);
//		model3.addAttribute(new User());
//		
//		System.out.println("model1-->"+model1);
//		System.out.println("model2-->"+model2);
//		System.out.println("model3-->"+model3);
		/*
		 * 上面出现的结果是:
		 * model1-->{userList={3=com.will.pojo.User@387ff7f6, 2=com.will.pojo.User@59705474, 1=com.will.pojo.User@5db8b98b}, userList2={3=com.will.pojo.User@a9d84bf, 2=com.will.pojo.User@6b761d0a, 1=com.will.pojo.User@176cb2a4}, user=com.will.pojo.User@614438ff}
           model2-->{userList={3=com.will.pojo.User@387ff7f6, 2=com.will.pojo.User@59705474, 1=com.will.pojo.User@5db8b98b}, userList2={3=com.will.pojo.User@a9d84bf, 2=com.will.pojo.User@6b761d0a, 1=com.will.pojo.User@176cb2a4}, user=com.will.pojo.User@614438ff}
           model2-->{userList={3=com.will.pojo.User@387ff7f6, 2=com.will.pojo.User@59705474, 1=com.will.pojo.User@5db8b98b}, userList2={3=com.will.pojo.User@a9d84bf, 2=com.will.pojo.User@6b761d0a, 1=com.will.pojo.User@176cb2a4}, user=com.will.pojo.User@614438ff}
		 */
		
		System.out.println("userList1-->"+userList1);
		System.out.println("userList2-->"+userList2);
		
		model1.addAttribute("userList", userList1);
		//这里是userList1的值，因为还没有重新指向
		System.out.println("model1-->"+model1);
		
		model2.addAttribute("userList",userList2);
		//这里model1和model2指向的都是userList2的内存地址，model3尽管没有放数据，但是指向的是同一个hash表
		System.out.println("model1-->"+model1);
		System.out.println("model2-->"+model2);
		System.out.println("model3-->"+model3);
		System.out.println("===================================================");
		model3.addAttribute(new User());
		
		System.out.println("model1-->"+model1);
		System.out.println("model2-->"+model2);
		System.out.println("model3-->"+model3);
		System.out.println("===================================================");
		//map也是一样的，操作的是同一张hash表
		System.out.println("map1-->"+map1);
		System.out.println("map2-->"+map2);
		/*
		 *userList1-->{3=com.will.pojo.User@301139ad, 2=com.will.pojo.User@3ae1a582, 1=com.will.pojo.User@34391801}
userList2-->{3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}
model1-->{userList={3=com.will.pojo.User@301139ad, 2=com.will.pojo.User@3ae1a582, 1=com.will.pojo.User@34391801}}
model1-->{userList={3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}}
model2-->{userList={3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}}
model3-->{userList={3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}}
===================================================
model1-->{userList={3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}, user=com.will.pojo.User@4d2a84fc}
model2-->{userList={3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}, user=com.will.pojo.User@4d2a84fc}
model3-->{userList={3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}, user=com.will.pojo.User@4d2a84fc}
===================================================
map1-->{userList={3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}, user=com.will.pojo.User@4d2a84fc}
map2-->{userList={3=com.will.pojo.User@10570470, 2=com.will.pojo.User@40e45d71, 1=com.will.pojo.User@50b2c6ff}, user=com.will.pojo.User@4d2a84fc}
		 */
	   return "user/userlist";
		//return "../../index";//用相对路径找到页面
	}
	
}
