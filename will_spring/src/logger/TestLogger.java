package logger;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.swing.JScrollBar;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 * 这里创建logger类，就可以设计成依赖注入的方式
 */
public class TestLogger {

	private Logger logger = Logger.getLogger(TestLogger.class);
	
	public void beforeLogger(JoinPoint jp) {
		System.out.println("获取连接点的类型："+jp.getTarget());
		System.out.println("获得连接点的方法："+jp.getSignature().getName());
		System.out.println("获得连接点的参数列表，是数组形式的:"+jp.getArgs()[0]);
		logger.info("开始执行方法......");
	}
	//后置方法中object可以获得执行完毕后，获得返回值的问题
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
	
	public void afterThrowing(JoinPoint jp,Exception e){
		logger.info("方法执行出现异常："+e);
	}
	
	public void after(JoinPoint jp){
		logger.info("总是会执行的通知");
	}
	
}
