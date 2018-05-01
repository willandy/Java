package biz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.ITestDao;

@Scope("prototype")//��ʾ������Ͱ���ԭ�ͷ�ʽ����
@Service("testBiz")//�൱��<bean id="testBiz" class=""></bean>
public class TestBiz implements ITestBiz {

	@Autowired //��ʾ������Ҫ��ע��
	@Qualifier("testDao")
	private ITestDao dao;
	
	public ITestDao getDao() {
		return dao;
	}

	public void setDao(ITestDao dao) {
		this.dao = dao;
	}

	//�����ù��췽��ע�룬ͬʱע�⣬�޲ι��������ӣ���Ϊ���ܶ෽��������Ҫ����Ĭ�ϵ��޲ι��죬
	//����structs2��action��spring��bean������Ҫ�����޲ι����
	public TestBiz() {}
	
	public TestBiz(ITestDao dao) {
		this.dao=dao;
	}
	// ����
	public TestBiz(ITestDao dao,String msg) {
		this.dao=dao;
	}
	//����Ĺ��췽��������Ĺ��췽����һ���ģ����ǹ���ע��ʱ������<constructor-arg>ʱ���ǲ���˳��ģ����Էֲ���������һ��
	//��ô�����������������������Ҫ��<constructor-arg>�м������index
	public TestBiz(String key,ITestDao dao) {
		this.dao=dao;
	}
	
	public TestBiz(ITestDao dao,int msg) {
		this.dao=dao;
	}
	
	
	@Override
	public void testBiz(String msg) {
			System.out.println("ִ��ҵ���߼�");
		       dao.testDao();
	}

	//�������������֤���ӵ��õ�����ֵ������
	@Override
	public String testBiz(String msg, String msg1) {
		// TODO Auto-generated method stub
		System.out.println("ִ��ҵ���߼�1"+msg);
		dao.testDao();
		//����Ĵ������������쳣��ǿ����
		//int i=10/0;//�㷨����
		return "hello";
	}

}
