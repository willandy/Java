package advisor;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterLogger implements AfterReturningAdvice {
	private Logger logger = Logger.getLogger(BeforeLogger.class);
	/*
	 * arg0����ֵ
	 * arg1���ӵ㷽��
	 * arg2�����б�
	 * arg3Ŀ�����
	 */
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
         logger.info("Advisor���÷�����ʼִ��...");
         System.out.println(arg2);//���ӵ�����
 		System.out.println(arg1.getName());//���ӵ���
 		System.out.println(arg2[0]);//���ӵ��д���Ĳ���
 		System.out.println("������ǿ�õ��ķ���ֵ:"+arg0);
	}

}
