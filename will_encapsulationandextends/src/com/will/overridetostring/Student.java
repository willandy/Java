package com.will.overridetostring;

/*
 * author:will
 * 创建一个学生实体类，然后重写object中的tostring()方法
 */
public class Student {
    //姓名，学号，年龄
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
	 * 重写object里的equals方法
	 * 判断规则：当学生的姓名和学号一致的时候，就可以判定是同一个人
	 * obj是指传来的对象
	 * this指当前对象
	 */
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj == this){
			//如果传来的是当前对象，就返回为true
			flag = true;
		}
		if(obj instanceof Student){
			//如果obj是student对象
			if(((Student)obj).getName().equals(this.getName()) 
					&& ((Student)obj).getSid()==this.getSid()){
			//如果传进来的学生与当前学生的姓名和学号一致，就表示是同一个人
				flag = true;
			}
		}else{
			flag = false;
		}
        return flag;
    }
	
	
	
}
