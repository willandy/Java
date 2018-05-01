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
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("=======================��ʼ�����=============================");
		//��ȡ�����ļ���Ȼ�����ҵ��㣬��ȡspring�����ļ��е�ҵ�����Ȼ��ҵ�����շ���
		ITestBiz biz=(ITestBiz) ctx.getBean("testBiz");
		System.out.println(biz.testBiz("test", "test1"));//����ͨ�������get�����󣬾��Ѿ��õ���������ˣ����������Ǵ�����󣬶�����ԭʼ����
	}
	
}
