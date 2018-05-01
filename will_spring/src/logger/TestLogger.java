package logger;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.swing.JScrollBar;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 * ���ﴴ��logger�࣬�Ϳ�����Ƴ�����ע��ķ�ʽ
 */
public class TestLogger {

	private Logger logger = Logger.getLogger(TestLogger.class);
	
	public void beforeLogger(JoinPoint jp) {
		System.out.println("��ȡ���ӵ�����ͣ�"+jp.getTarget());
		System.out.println("������ӵ�ķ�����"+jp.getSignature().getName());
		System.out.println("������ӵ�Ĳ����б���������ʽ��:"+jp.getArgs()[0]);
		logger.info("��ʼִ�з���......");
	}
	//���÷�����object���Ի��ִ����Ϻ󣬻�÷���ֵ������
	public void afterReturningLogger(JoinPoint jp,Object result) {
		logger.info("����ִ�����......");
		System.out.println("��ȡ���ӵ�����ͣ�"+jp.getTarget());
		System.out.println("������ӵ�ķ�����"+jp.getSignature().getName());
		System.out.println("������ӵ�Ĳ����б���������ʽ��:"+jp.getArgs()[0]);
		//�����ļ���ҲҪ���ã����ܻ�ȡ������ֵ���
		System.out.println("���صĽ���ǣ�"+result);
	}
	
	//���Ʒ���
	//ע�⣬����ĺ��÷����������޸ķ���ֵ�������ƿ����޸ķ���ֵ
	public Object around(ProceedingJoinPoint jp){
		logger.info("��ʼִ�л��Ʒ���.....");
		boolean canExec = false;
		
		String input=(String) jp.getArgs()[0];
		//�����򵥵�ҵ���߼��жϣ�Ȼ������Ϊtrue
		if(input.equals("test")) canExec=true;
		Object result=null;
		try{
			//����������ʱ���͵��÷���������ȡ����ֵ
			if(canExec){
				//���ƵĻ��������proceed()�ͱ�ʾ�������÷�����������ǰ�������һϵ��
				//ҵ���жϣ�������ĳ�������Ϳ��Ե��ø�ҵ�񷽷�
				result=jp.proceed();
			}
			
			//ִ�л��߲�ִ��ʱ���Է���ֵ���޸�
			if(canExec){
				result="ҵ�񷽷�˵��"+jp.proceed();
			}else{
				result = "��β�����Ҫ������������";
			}
			
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		//������ǶԷ���ֵ���ع������صľͲ�����ԭ����ֵ�������޸ĺ�ķ���ֵ
		//result = new User();
		
		logger.info("����ִ�����......");
		return result;
	}
	
	public void afterThrowing(JoinPoint jp,Exception e){
		logger.info("����ִ�г����쳣��"+e);
	}
	
	public void after(JoinPoint jp){
		logger.info("���ǻ�ִ�е�֪ͨ");
	}
	
}
