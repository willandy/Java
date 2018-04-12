package com.will.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.will.exception.UserException;
import com.will.pojo.User;

@Controller
/*
 * 一般情况下类前面也要加一个RequestMapping，只有先通过类上的RequestMapping才能
 * 访问下面的方法上的RequestMapping，然后类上的"/user"就成了根目录，而下面的
 * "/list"就成了相对路径
 */
@RequestMapping(value="/user")//http://localhost:8900/will_springmvc/user/list
public class UserController {

	private Map<String,User> userList = new HashMap<String,User>();
	
	public UserController(){
		userList.put("1", new User("1","Test01","111111","test@test.com"));
		userList.put("2", new User("2","Test02","222222","test@test.com"));
		userList.put("3", new User("3","Test03","333333","test@test.com"));
	}
	//方法一：全局变量，实现对象列表
    //因为springmvc是单例模式的，所以不适合用全局变量
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("userList", userList);
		return "user/userlist";
	}

	/*
	 * 对象传参 方法二：采用arrayList方式，入参不用model，而是采用servletapi里的HttpServletRequest,
	 * 用request的作用域传参，request也是map形式的
	 */
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String list(HttpServletRequest request){
		System.out.println("HttpServletRequest方法进入=========");
		List<User> userList = new ArrayList<User>();
		userList.add(new User("1","Test01","111111","test@test.com"));
		userList.add(new User("2","Test02","222222","test@test.com"));
		userList.add(new User("3","Test03","333333","test@test.com"));
		request.setAttribute("userList", userList);
		return "user/userlist";
	}
	
	/*
	 * 方法三:ModelAndView传参
	 */
	 //这里加params="test"，是因为万一requestMapping与其它requestMapping参数都一致，就会报错，所以可以添加参数，也表明了requestMapping里有多个参数
	@RequestMapping(value="/list",method=RequestMethod.GET,params="ttt")//注意：value="/list"里面传到是url,同时requestMapping在你整个项目中的值都应该是唯一的
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userlist");//逻辑视图名
		mv.addObject("userList", userList);//数据模型
		return mv;
	}
	
	/*
	 * 数据新增
	 */
	/*@RequestMapping(value="/add",method=RequestMethod.GET)//这里是添加，为什么写get，因为现在只是链接到添加页面，并不是提交数据
	public String add(Model model){
		//方法一：传值到modelAttribute，用model的方式
		model.addAttribute(new User());//在model里传入一个user对象，就是add.jsp里的modelAttribute="user"
		return  "user/add";
	}*/
	//方式二：传值到modelAttribute，用注解@ModelAttribute的方式
	@RequestMapping(value="/add",method=RequestMethod.GET)
	//这里@ModelAttribute("user")就相当于key，User user就相当于value值
	public String add(@ModelAttribute("user") User user,String abc){//加上参数String abc,是因为不与下面的重复
		return  "user/add";
	}
	
	//如果页面提交表单时不指定action，那么这里的value里的值就相当于action
	//requestMapping里面不单单是url，还有method，cokkie等数据
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user){
		userList.put(user.getId(), user);
		//return "user/userlist"; //这里使用逻辑视图名是否正确？因为return到逻辑视图名，仅仅是页面跳转，属于服务器行为，
		//这里又是增加功能，不可能跳转到页面上去，否则数据不对，而是重新请求页面数据
		return "redirect:/user/list";//这里是重新请求user下面的list方法，就是重新请求上面list方法返回的逻辑视图
	   //当服务器获取到redirect(重定向)或者forward后，就会把后面的地址当做url地址重新请求，而不是把它当作逻辑视图名
	}
	
	//上面是采用页面上没有添加action的方法，下面是页面上添加了action的方法
//	@RequestMapping(value="/addsave",method=RequestMethod.POST)
//	public String addsave(@Validated User user,BindingResult bindingresult,//BindingResult一定要@Validate，否则会报错
//			MultipartFile attach,HttpServletRequest request){//attach,request 是为了得到上传路径
//		
//		if(bindingresult.hasErrors()){
//			return "user/add";
//		}
//		
//		//指定上传位置,这里的文件就会自动保存到MultipartFile里面
//		String uploadFilePath = request.getSession().getServletContext().getRealPath("/statics/upload");
//		//获得上传文件的一些参数
//		//原始名
//		System.out.println(attach.getOriginalFilename());
//		//类型
//		System.out.println(attach.getContentType());
//		//页面表单控件的值
//		System.out.println(attach.getName());
//		//上传文件到指定的地方
//		try{
//			if(!attach.isEmpty()){
//				//File.separator可以自动识别是在windows系统还是在linux系统下
//				File saveFile = new File(uploadFilePath+File.separator+attach.getOriginalFilename());
//				//文件以流的形式传到指定的路径
//				FileUtils.copyInputStreamToFile(attach.getInputStream(), saveFile);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		
//		userList.put(user.getId(), user);
//		return "redirect:/user/list";
//	}
	
	//这里与上面的不同点就是，这里采用多文件上传的样式
	@RequestMapping(value="/addsave",method=RequestMethod.POST)
	public String addsave(@Validated User user,BindingResult bindingresult,
			//多文件上传也就是传入数组，然后前面要@RequestParam
			@RequestParam MultipartFile[] attachs,HttpServletRequest request){
		
		if(bindingresult.hasErrors()){
			return "user/add";
		}
		
		//指定上传位置,这里的文件就会自动保存到MultipartFile里面
		String uploadFilePath = request.getSession().getServletContext().getRealPath("/statics/upload");
		//上传文件到指定的地方
		try{
			for(MultipartFile attach:attachs){
				if(!attach.isEmpty()){
					//File.separator可以自动识别是在windows系统还是在linux系统下
					File saveFile = new File(uploadFilePath+File.separator+attach.getOriginalFilename());
					//文件以流的形式传到指定的路径
					FileUtils.copyInputStreamToFile(attach.getInputStream(), saveFile);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		userList.put(user.getId(), user);
		return "redirect:/user/list";
	}
	
	
	//?id=123 @requestParamter String id
	//rest风格
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable String id,Model model){
		System.out.println("进来的是不是json数据返回的方法");
		model.addAttribute(userList.get(id));
		return "user/view";
	}
	
	//这里与上面的区别就是多了个参数params就是为了与上面的做个区别，参数里的名字可以随便起
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET,params="json")
	@ResponseBody//用这个的情况一般是，返回的一个对象，上面的方法返回的是逻辑视图名，然后
	//数据存到model里，然后渲染，这里返回的是对象，然后页面获取该对象，页面获取数据在
	//ResponseBody的ResponseHttp的作用域里
	//这个经常与ajax连做，经常返回一个json串，或者一个对象
	//controller里的方法返回对象，返回的结果写入到http response body的数据区内
	public User view(@PathVariable String id){
		System.out.println("进来的是json数据返回的方法");
		return userList.get(id);
	}
	
	//rest风格下的新增
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model){
		model.addAttribute(userList.get(id));
		return "user/update";
	}
	
	//更新数据，提交表单
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String updatesave(@PathVariable String id,@Validated User user,BindingResult bindingresult){
		
		if(bindingresult.hasErrors()){
			return "user/update";
		}
		
		userList.put(id, user);//通过id的值，重新传入user的值
		return "redirect:/user/list";
	}
	
	//删除数据
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String id){
		userList.remove(id);
		return "redirect:/user/list";
	}
	
	//用户登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam String userName,@RequestParam String password,HttpSession session){
		boolean flag=false;//用于异常判断
		//对比传进来的用户名和密码，遍历map(key,value)
		for(User user:userList.values()){
			if(userName.equals(user.getUserName()) && password.equals(user.getPassword())){
				System.out.println("登录成功!");
				//将user对象加到session中去，可以用于首页显示用户名
				session.setAttribute("loginUser", user);
				flag = true;
				break;
			}
		}
		
		if(!flag){
			throw  new UserException("用户名或密码不正确，请重新输入");
		}
		
		//遍历map
		//1、userList.values()
		//2、userList.keySet() 得到key的集合
		for(String key:userList.keySet()){
			System.out.println("key-->"+key+",values-->"+userList.get(key).getUserName());
		}
		//3、iterator
		System.out.println("========================================");
		Iterator<Map.Entry<String, User>> it=userList.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, User> map=it.next();
			System.out.println("key-->"+map.getKey()+",values-->"+map.getValue().getUserName());
		}
		
		return "redirect:/user/list";
		
	}
	
	
	//设置局部异常变量,如果与全局变量一起用，局部异常优于全局异常
	/*
	 * 局部异常只针对单个controller，但是有可能这个controller里面有多个异常，目前只有一个，
	 * 这里value传入异常类后，要把异常类放进形参里
	 * 注意：这个value里面是数组，可以写多个异常
	 */
//	@ExceptionHandler(value={UserException.class})
//	public String handlerException(UserException e,HttpServletRequest request){//放HttpServletRequest参数是为了在页面上输入报异常的信心
//		request.setAttribute("e", e);
//		return "error";
//	}
	
}
