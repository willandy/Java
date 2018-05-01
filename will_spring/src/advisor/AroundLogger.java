package advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLogger implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("���Ʒ�����ʼ...");
		//������ӵ�Ĳ����б�
		System.out.println(arg0.getArguments()[0]);
		//��ö���
		System.out.println(arg0.getThis());
		//��÷���
		System.out.println(arg0.getMethod().getName());
		//���ƿ��Ծ���ҵ�񷽷��ܷ�ִ�У��Լ��ع�����ֵ
		Object result = arg0.proceed();
		return result;
	}

}
