package com.will.overridetostring;

/*
 * author:will
 * ����һ��ѧ��ʵ���࣬Ȼ����дobject�е�tostring()����
 */
public class Student {
    //������ѧ�ţ�����
	private String name;
	private int sid;
	private int age;
	
	public Student() {
		super();
	}

	public Student(String name, int sid, int age) {
		super();
		this.name = name;
		this.sid = sid;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * ��дobject���equals����
	 * �жϹ��򣺵�ѧ����������ѧ��һ�µ�ʱ�򣬾Ϳ����ж���ͬһ����
	 * obj��ָ�����Ķ���
	 * thisָ��ǰ����
	 */
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj == this){
			//����������ǵ�ǰ���󣬾ͷ���Ϊtrue
			flag = true;
		}
		if(obj instanceof Student){
			//���obj��student����
			if(((Student)obj).getName().equals(this.getName()) 
					&& ((Student)obj).getSid()==this.getSid()){
			//�����������ѧ���뵱ǰѧ����������ѧ��һ�£��ͱ�ʾ��ͬһ����
				flag = true;
			}
		}else{
			flag = false;
		}
        return flag;
    }
	
	
	
}
