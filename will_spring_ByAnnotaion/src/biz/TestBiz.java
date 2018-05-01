package biz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.ITestDao;

@Scope("prototype")//表示这个类型按照原型方式创建
@Service("testBiz")//相当于<bean id="testBiz" class=""></bean>
public class TestBiz implements ITestBiz {

	@Autowired //表示属性需要被注入
	@Qualifier("testDao")
	private ITestDao dao;
	
	public ITestDao getDao() {
		return dao;
	}

	public void setDao(ITestDao dao) {
		this.dao = dao;
	}

	//现在用构造方法注入，同时注意，无参构造最好添加，因为，很多方法都是需要调用默认的无参构造，
	//比如structs2的action，spring的bean都是需要加载无参构造的
	public TestBiz() {}
	
	public TestBiz(ITestDao dao) {
		this.dao=dao;
	}
	// 重载
	public TestBiz(ITestDao dao,String msg) {
		this.dao=dao;
	}
	//下面的构造方法和上面的构造方法是一样的，但是构造注入时，配置<constructor-arg>时，是不分顺序的，所以分不出来是哪一个
	//那么如何区分上面和下面的区别，需要在<constructor-arg>中加入参数index
	public TestBiz(String key,ITestDao dao) {
		this.dao=dao;
	}
	
	public TestBiz(ITestDao dao,int msg) {
		this.dao=dao;
	}
	
	
	@Override
	public void testBiz(String msg) {
			System.out.println("执行业务逻辑");
		       dao.testDao();
	}

	//这个方法是来验证连接点拿到返回值的问题
	@Override
	public String testBiz(String msg, String msg1) {
		// TODO Auto-generated method stub
		System.out.println("执行业务逻辑1"+msg);
		dao.testDao();
		//下面的代码用来测试异常增强方法
		//int i=10/0;//算法错误
		return "hello";
	}

}
