package advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLogger implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("环绕方法开始...");
		//获得连接点的参数列表
		System.out.println(arg0.getArguments()[0]);
		//获得对象
		System.out.println(arg0.getThis());
		//获得方法
		System.out.println(arg0.getMethod().getName());
		//环绕可以决定业务方法能否执行，以及重构返回值
		Object result = arg0.proceed();
		return result;
	}

}
