package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.ITestBiz;
import biz.TestBiz;

public class Test {

	public static void main(String[] args) {
		//���ִ�ͳ�´�������ķ���������Dao��ᱨ����Ϊ��û�д�ֵ��ȥ
		//new TestBiz().testBiz(); 
       //��classpath�²��������ļ�����Ϊ��Ŀ�������ļ��ŵ��˸�Ŀ¼��
		//��������ļ��Ƿŵ��˰��£����ǰ���.xxx
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//���ڲ���advisor�ķ�������������Ҫ�޸������ļ�������
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_Advisor.xml");
		
	    //������˿��Ը���classpathĿ¼�����ļ��⣬Ҳ���Ը����ļ�ϵͳ���ң�����ֱ��·���ͺ�
		//new FileSystemXmlApplicationContext("")
		System.out.println("=======================��ʼ�����=============================");
		//��ȡ�����ļ���Ȼ�����ҵ��㣬��ȡspring�����ļ��е�ҵ�����Ȼ��ҵ�����շ���
		ITestBiz biz=(ITestBiz) ctx.getBean("testBiz");
		//biz.testBiz("test msg");
		//biz.testBiz("test", "test1");//������֤���ӵ��÷���ֵ������
		System.out.println(biz.testBiz("test", "test1"));//����ͨ�������get�����󣬾��Ѿ��õ���������ˣ����������Ǵ�����󣬶�����ԭʼ����
		/*
		 * �ܽ᣺��ô��Ϊ���Ʒ�ת��IOC����
		 * ԭ����ҵ���ֱ�Ӵ�������������ͨ��������ֵ��Ҳ����˵��ǰ��ҵ����������Ҫ��DAO��
		 * ������ͨ��������������ʽ����ֵ��ҵ��㣬���ǿ��Ʒ�ת��
		 */
		//ITestBiz biz1=(ITestBiz) ctx.getBean("testBiz");
		//����ģʽ������ÿ�ε��ö���ͬһ��Դ���ڴ��ַһ��
		/*
		 * ����ģʽ�£��и�����Ҫ��������ǣ����ҵ����и�ȫ�ֱ���string��
		 * ��A�û����ã�����ֵʱ��B�û�Ҳ���ø�string��Ҳ��������һ��ֵ����ô
		 * A�û������ݾͻ���󣬷��ص���B�û������ݣ����Ե���ģʽ�²��þֲ�������
		 * ���������ԣ���ȫ�ֱ�����
		 */
		//System.out.println(biz==biz1);
	}
	
}
