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
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//现在采用advisor的方法来，所以需要修改配置文件的名字
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_Advisor.xml");
		
	    //上面除了可以根据classpath目录查找文件外，也可以根据文件系统查找，配置直接路径就好
		//new FileSystemXmlApplicationContext("")
		System.out.println("=======================初始化完毕=============================");
		//获取配置文件后，然后调用业务层，获取spring配置文件中的业务对象，然后业务层接收返回
		ITestBiz biz=(ITestBiz) ctx.getBean("testBiz");
		//biz.testBiz("test msg");
		//biz.testBiz("test", "test1");//现在验证连接点获得返回值的问题
		System.out.println(biz.testBiz("test", "test1"));//这里通过上面的get方法后，就已经得到代理对象了，所以这里是代理对象，而不是原始方法
		/*
		 * 总结：那么何为控制反转（IOC）：
		 * 原来的业务层直接创建对象，现在是通过容器传值，也就是说以前是业务层控制所需要的DAO，
		 * 现在是通过容器或其他方式来赋值给业务层，就是控制反转。
		 */
		//ITestBiz biz1=(ITestBiz) ctx.getBean("testBiz");
		//单例模式，就是每次调用都是同一资源，内存地址一致
		/*
		 * 单例模式下，有个很重要的问题就是，如果业务层有个全局变量string，
		 * 当A用户调用，并赋值时，B用户也调用该string，也赋了另外一个值，那么
		 * A用户的数据就会错误，返回的是B用户的数据，所以单利模式下采用局部变量，
		 * 而不用属性，即全局变量。
		 */
		//System.out.println(biz==biz1);
	}
	
}
