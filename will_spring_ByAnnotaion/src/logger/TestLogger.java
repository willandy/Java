package logger;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.swing.JScrollBar;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/*
 * 这里创建logger类，就可以设计成依赖注入的方式
 */
@Aspect  //声明增强处理类
public class TestLogger {

	private Logger logger = Logger.getLogger(TestLogger.class);
	
	//如果一个业务类名字改了，需要修改，就会需要所有的注解类，所以需要把注解提炼出一个公共方法来调用切入点
	@Pointcut("execution(public * biz ..*(..))")//定义切入点，切入点名称即方法名
	public void pointcut(){}
	
	//@Before("execution(public * biz ..*(..))")//声明前置增强
	@Before("pointcut()")//声明前置增强
	public void beforeLogger(JoinPoint jp) {
		System.out.println("获取连接点的类型："+jp.getTarget());
		System.out.println("获得连接点的方法："+jp.getSignature().getName());
		System.out.println("获得连接点的参数列表，是数组形式的:"+jp.getArgs()[0]);
		logger.info("开始执行方法......");
	}
	//后置方法中object可以获得执行完毕后，获得返回值的问题
	/*@AfterReturning(pointcut="execution(public * biz..*(..))",
			returning="result")*/
	@AfterReturning(pointcut="pointcut()",
	returning="result")
	public void afterReturningLogger(JoinPoint jp,Object result) {
		logger.info("方法执行完毕......");
		System.out.println("获取连接点的类型："+jp.getTarget());
		System.out.println("获得连接点的方法："+jp.getSignature().getName());
		System.out.println("获得连接点的参数列表，是数组形式的:"+jp.getArgs()[0]);
		//配置文件中也要配置，才能获取到返回值结果
		System.out.println("返回的结果是："+result);
	}
	
	//环绕方法
	//注意，上面的后置方法不可以修改返回值，而环绕可以修改返回值
	//@Around("execution(public * biz..*(..))")
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint jp){
		logger.info("开始执行环绕方法.....");
		boolean canExec = false;
		
		String input=(String) jp.getArgs()[0];
		//做个简单的业务逻辑判断，然后设置为true
		if(input.equals("test")) canExec=true;
		Object result=null;
		try{
			//当满足条件时，就调用方法，并获取返回值
			if(canExec){
				//环绕的话，这里的proceed()就表示真正调用方法，所以在前面可以做一系列
				//业务判断，当满足某个条件就可以调用该业务方法
				result=jp.proceed();
			}
			
			//执行或者不执行时，对返回值的修改
			if(canExec){
				result="业务方法说："+jp.proceed();
			}else{
				result = "入参不符合要求，请重新输入";
			}
			
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		//下面就是对返回值的重构，返回的就不再是原返回值，而是修改后的返回值
		//result = new User();
		
		logger.info("方法执行完毕......");
		return result;
	}
	
	/*@AfterThrowing(pointcut="execution(public * biz..*(..))",
			throwing="e")*/
	@AfterThrowing(pointcut="pointcut()",
	throwing="e")
	public void afterThrowing(JoinPoint jp,Exception e){
		logger.info("方法执行出现异常："+e);
	}
	
	//@After("execution(public * biz..*(..))")
	@After("pointcut()")
	public void after(JoinPoint jp){
		logger.info("总是会执行的通知");
	}
	
}
