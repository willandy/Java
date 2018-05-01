package dao;

import org.springframework.stereotype.Repository;

@Repository("testDao")//相当于<bean id="testDao" class=""></bean>
public class NewDao implements ITestDao {

	@Override
	public void testDao() {
		System.out.println("执行新的DAO方法");

	}

}
