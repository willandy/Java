package advisor;

import java.io.IOException;
import java.lang.reflect.Method;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.aop.ThrowsAdvice;

public class AfterThrowingLogger implements ThrowsAdvice {

	public void AfterThrowing(Method arg0, Object[] arg1, Object arg2,
			IOException e) throws Throwable{
		
	}
	
	public void AfterThrowing(Method arg0, Object[] arg1, Object arg2,
			RuntimeException e) throws Throwable{
		
	}
	
}
