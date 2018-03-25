package ConstructMethod;

/*
 * 创建一个person的实体类
 */
public class Person {

	//属性：姓名，年龄，财产，地址
	public String name;
	public Integer age;
	public float property;
	public String address;
	
	public Person(){}  //无参构造方法
	
	/*
	 * this:当前对象
	 * this.属性
	 * this.普通方法()
	 */
	public Person(String name,Integer age){  //带参构造方法
		this.name = name;
		this.age = age;
	}
	
	/*
	 * 本类构造方法的调用
	 * this(参数)
	 * 注意：这句话要放在第一句
	 */
	public Person(String name,Integer age,float property,String address){
		this(name,age);  //构造方法间也可以相互调用
		this.property = property;
		this.address = address;
	}
	
}
