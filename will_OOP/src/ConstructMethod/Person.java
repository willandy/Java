package ConstructMethod;

/*
 * ����һ��person��ʵ����
 */
public class Person {

	//���ԣ����������䣬�Ʋ�����ַ
	public String name;
	public Integer age;
	public float property;
	public String address;
	
	public Person(){}  //�޲ι��췽��
	
	/*
	 * this:��ǰ����
	 * this.����
	 * this.��ͨ����()
	 */
	public Person(String name,Integer age){  //���ι��췽��
		this.name = name;
		this.age = age;
	}
	
	/*
	 * ���๹�췽���ĵ���
	 * this(����)
	 * ע�⣺��仰Ҫ���ڵ�һ��
	 */
	public Person(String name,Integer age,float property,String address){
		this(name,age);  //���췽����Ҳ�����໥����
		this.property = property;
		this.address = address;
	}
	
}
