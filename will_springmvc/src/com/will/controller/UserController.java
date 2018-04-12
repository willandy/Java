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
 * һ���������ǰ��ҲҪ��һ��RequestMapping��ֻ����ͨ�����ϵ�RequestMapping����
 * ��������ķ����ϵ�RequestMapping��Ȼ�����ϵ�"/user"�ͳ��˸�Ŀ¼���������
 * "/list"�ͳ������·��
 */
@RequestMapping(value="/user")//http://localhost:8900/will_springmvc/user/list
public class UserController {

	private Map<String,User> userList = new HashMap<String,User>();
	
	public UserController(){
		userList.put("1", new User("1","Test01","111111","test@test.com"));
		userList.put("2", new User("2","Test02","222222","test@test.com"));
		userList.put("3", new User("3","Test03","333333","test@test.com"));
	}
	//����һ��ȫ�ֱ�����ʵ�ֶ����б�
    //��Ϊspringmvc�ǵ���ģʽ�ģ����Բ��ʺ���ȫ�ֱ���
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("userList", userList);
		return "user/userlist";
	}

	/*
	 * ���󴫲� ������������arrayList��ʽ����β���model�����ǲ���servletapi���HttpServletRequest,
	 * ��request�������򴫲Σ�requestҲ��map��ʽ��
	 */
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String list(HttpServletRequest request){
		System.out.println("HttpServletRequest��������=========");
		List<User> userList = new ArrayList<User>();
		userList.add(new User("1","Test01","111111","test@test.com"));
		userList.add(new User("2","Test02","222222","test@test.com"));
		userList.add(new User("3","Test03","333333","test@test.com"));
		request.setAttribute("userList", userList);
		return "user/userlist";
	}
	
	/*
	 * ������:ModelAndView����
	 */
	 //�����params="test"������Ϊ��һrequestMapping������requestMapping������һ�£��ͻᱨ�����Կ�����Ӳ�����Ҳ������requestMapping���ж������
	@RequestMapping(value="/list",method=RequestMethod.GET,params="ttt")//ע�⣺value="/list"���洫����url,ͬʱrequestMapping����������Ŀ�е�ֵ��Ӧ����Ψһ��
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userlist");//�߼���ͼ��
		mv.addObject("userList", userList);//����ģ��
		return mv;
	}
	
	/*
	 * ��������
	 */
	/*@RequestMapping(value="/add",method=RequestMethod.GET)//��������ӣ�Ϊʲôдget����Ϊ����ֻ�����ӵ����ҳ�棬�������ύ����
	public String add(Model model){
		//����һ����ֵ��modelAttribute����model�ķ�ʽ
		model.addAttribute(new User());//��model�ﴫ��һ��user���󣬾���add.jsp���modelAttribute="user"
		return  "user/add";
	}*/
	//��ʽ������ֵ��modelAttribute����ע��@ModelAttribute�ķ�ʽ
	@RequestMapping(value="/add",method=RequestMethod.GET)
	//����@ModelAttribute("user")���൱��key��User user���൱��valueֵ
	public String add(@ModelAttribute("user") User user,String abc){//���ϲ���String abc,����Ϊ����������ظ�
		return  "user/add";
	}
	
	//���ҳ���ύ��ʱ��ָ��action����ô�����value���ֵ���൱��action
	//requestMapping���治������url������method��cokkie������
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user){
		userList.put(user.getId(), user);
		//return "user/userlist"; //����ʹ���߼���ͼ���Ƿ���ȷ����Ϊreturn���߼���ͼ����������ҳ����ת�����ڷ�������Ϊ��
		//�����������ӹ��ܣ���������ת��ҳ����ȥ���������ݲ��ԣ�������������ҳ������
		return "redirect:/user/list";//��������������user�����list����������������������list�������ص��߼���ͼ
	   //����������ȡ��redirect(�ض���)����forward�󣬾ͻ�Ѻ���ĵ�ַ����url��ַ�������󣬶����ǰ��������߼���ͼ��
	}
	
	//�����ǲ���ҳ����û�����action�ķ�����������ҳ���������action�ķ���
//	@RequestMapping(value="/addsave",method=RequestMethod.POST)
//	public String addsave(@Validated User user,BindingResult bindingresult,//BindingResultһ��Ҫ@Validate������ᱨ��
//			MultipartFile attach,HttpServletRequest request){//attach,request ��Ϊ�˵õ��ϴ�·��
//		
//		if(bindingresult.hasErrors()){
//			return "user/add";
//		}
//		
//		//ָ���ϴ�λ��,������ļ��ͻ��Զ����浽MultipartFile����
//		String uploadFilePath = request.getSession().getServletContext().getRealPath("/statics/upload");
//		//����ϴ��ļ���һЩ����
//		//ԭʼ��
//		System.out.println(attach.getOriginalFilename());
//		//����
//		System.out.println(attach.getContentType());
//		//ҳ����ؼ���ֵ
//		System.out.println(attach.getName());
//		//�ϴ��ļ���ָ���ĵط�
//		try{
//			if(!attach.isEmpty()){
//				//File.separator�����Զ�ʶ������windowsϵͳ������linuxϵͳ��
//				File saveFile = new File(uploadFilePath+File.separator+attach.getOriginalFilename());
//				//�ļ���������ʽ����ָ����·��
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
	
	//����������Ĳ�ͬ����ǣ�������ö��ļ��ϴ�����ʽ
	@RequestMapping(value="/addsave",method=RequestMethod.POST)
	public String addsave(@Validated User user,BindingResult bindingresult,
			//���ļ��ϴ�Ҳ���Ǵ������飬Ȼ��ǰ��Ҫ@RequestParam
			@RequestParam MultipartFile[] attachs,HttpServletRequest request){
		
		if(bindingresult.hasErrors()){
			return "user/add";
		}
		
		//ָ���ϴ�λ��,������ļ��ͻ��Զ����浽MultipartFile����
		String uploadFilePath = request.getSession().getServletContext().getRealPath("/statics/upload");
		//�ϴ��ļ���ָ���ĵط�
		try{
			for(MultipartFile attach:attachs){
				if(!attach.isEmpty()){
					//File.separator�����Զ�ʶ������windowsϵͳ������linuxϵͳ��
					File saveFile = new File(uploadFilePath+File.separator+attach.getOriginalFilename());
					//�ļ���������ʽ����ָ����·��
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
	//rest���
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable String id,Model model){
		System.out.println("�������ǲ���json���ݷ��صķ���");
		model.addAttribute(userList.get(id));
		return "user/view";
	}
	
	//�����������������Ƕ��˸�����params����Ϊ����������������𣬲���������ֿ��������
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET,params="json")
	@ResponseBody//����������һ���ǣ����ص�һ����������ķ������ص����߼���ͼ����Ȼ��
	//���ݴ浽model�Ȼ����Ⱦ�����ﷵ�ص��Ƕ���Ȼ��ҳ���ȡ�ö���ҳ���ȡ������
	//ResponseBody��ResponseHttp����������
	//���������ajax��������������һ��json��������һ������
	//controller��ķ������ض��󣬷��صĽ��д�뵽http response body����������
	public User view(@PathVariable String id){
		System.out.println("��������json���ݷ��صķ���");
		return userList.get(id);
	}
	
	//rest����µ�����
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model){
		model.addAttribute(userList.get(id));
		return "user/update";
	}
	
	//�������ݣ��ύ��
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String updatesave(@PathVariable String id,@Validated User user,BindingResult bindingresult){
		
		if(bindingresult.hasErrors()){
			return "user/update";
		}
		
		userList.put(id, user);//ͨ��id��ֵ�����´���user��ֵ
		return "redirect:/user/list";
	}
	
	//ɾ������
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String id){
		userList.remove(id);
		return "redirect:/user/list";
	}
	
	//�û���¼
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam String userName,@RequestParam String password,HttpSession session){
		boolean flag=false;//�����쳣�ж�
		//�Աȴ��������û��������룬����map(key,value)
		for(User user:userList.values()){
			if(userName.equals(user.getUserName()) && password.equals(user.getPassword())){
				System.out.println("��¼�ɹ�!");
				//��user����ӵ�session��ȥ������������ҳ��ʾ�û���
				session.setAttribute("loginUser", user);
				flag = true;
				break;
			}
		}
		
		if(!flag){
			throw  new UserException("�û��������벻��ȷ������������");
		}
		
		//����map
		//1��userList.values()
		//2��userList.keySet() �õ�key�ļ���
		for(String key:userList.keySet()){
			System.out.println("key-->"+key+",values-->"+userList.get(key).getUserName());
		}
		//3��iterator
		System.out.println("========================================");
		Iterator<Map.Entry<String, User>> it=userList.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, User> map=it.next();
			System.out.println("key-->"+map.getKey()+",values-->"+map.getValue().getUserName());
		}
		
		return "redirect:/user/list";
		
	}
	
	
	//���þֲ��쳣����,�����ȫ�ֱ���һ���ã��ֲ��쳣����ȫ���쳣
	/*
	 * �ֲ��쳣ֻ��Ե���controller�������п������controller�����ж���쳣��Ŀǰֻ��һ����
	 * ����value�����쳣���Ҫ���쳣��Ž��β���
	 * ע�⣺���value���������飬����д����쳣
	 */
//	@ExceptionHandler(value={UserException.class})
//	public String handlerException(UserException e,HttpServletRequest request){//��HttpServletRequest������Ϊ����ҳ�������뱨�쳣������
//		request.setAttribute("e", e);
//		return "error";
//	}
	
}
