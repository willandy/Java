package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.ITestBiz;
import biz.TestBiz;

public class Test {

	public static void main(String[] args) {
		//这种传统新创建对象的方法并调用Dao层会报错，因为还没有传值进去
		//new TestBiz().testBiz(); 
       //在classpath下查找配置文件，因为项目把配置文件放到了根目录下
		//如果配置文件是放到了包下，就是包名.xxx
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("=======================初始化完毕=============================");
		//获取配置文件后，然后调用业务层，获取spring配置文件中的业务对象，然后业务层接收返回
		ITestBiz biz=(ITestBiz) ctx.getBean("testBiz");
		System.out.println(biz.testBiz("test", "test1"));//这里通过上面的get方法后，就已经得到代理对象了，所以这里是代理对象，而不是原始方法
	}
	
}
