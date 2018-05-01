package advisor;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterLogger implements AfterReturningAdvice {
	private Logger logger = Logger.getLogger(BeforeLogger.class);
	/*
	 * arg0返回值
	 * arg1连接点方法
	 * arg2参数列表
	 * arg3目标对象
	 */
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
         logger.info("Advisor后置方法开始执行...");
         System.out.println(arg2);//连接点类型
 		System.out.println(arg1.getName());//连接点名
 		System.out.println(arg2[0]);//连接点中传入的参数
 		System.out.println("后置增强得到的返回值:"+arg0);
	}

}
