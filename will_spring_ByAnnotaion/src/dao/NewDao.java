package dao;

import org.springframework.stereotype.Repository;

@Repository("testDao")//�൱��<bean id="testDao" class=""></bean>
public class NewDao implements ITestDao {

	@Override
	public void testDao() {
		System.out.println("ִ���µ�DAO����");

	}

}
