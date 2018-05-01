package advisor;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogger implements MethodBeforeAdvice {
	private Logger logger = Logger.getLogger(BeforeLogger.class);

	/*
	 * arg0��ʾ��÷��������൱��JoinPoint.getSignature().getName()
	 * arg2��ʾ�����Ŀ������൱��JoinPoint.getTarget()
	 * arg1��ʾ���ӵ㷽���Ĳ������൱��JoinPoint.getArgs()
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println(arg2);//���ӵ�����
		System.out.println(arg0.getName());//���ӵ���
		System.out.println(arg1[0]);//���ӵ��д���Ĳ���
		
        logger.info("��ʼִ��Advisorǰ�÷���...");
		
		
	}

}
