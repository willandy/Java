package advisor;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogger implements MethodBeforeAdvice {
	private Logger logger = Logger.getLogger(BeforeLogger.class);

	/*
	 * arg0表示获得方法名，相当于JoinPoint.getSignature().getName()
	 * arg2表示代理的目标对象，相当于JoinPoint.getTarget()
	 * arg1表示连接点方法的参数，相当于JoinPoint.getArgs()
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println(arg2);//连接点类型
		System.out.println(arg0.getName());//连接点名
		System.out.println(arg1[0]);//连接点中传入的参数
		
        logger.info("开始执行Advisor前置方法...");
		
		
	}

}
