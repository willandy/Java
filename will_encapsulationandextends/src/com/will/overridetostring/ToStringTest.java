package com.will.overridetostring;

/*
 * 判断并测试toString方法
 */
public class ToStringTest {

	public static void main(String[] args) {
		//创建一个student1实例
		Student s1 = new Student("Jack",2010,12);
		//创建一个student2实例
		Student s2 = new Student("Jack",2010,12);
		//因为每个new对象就表示在堆里新建了一个对象，就属于两个不同的对象，当在实体类里没有重写object的equals的时候，是两个不同的对象
		//System.out.println(s1.equals(s2)); //这里有equals是因为每个类都继承了object父类，object类有equals方法
		
		//当在Student里重写了toString方法后，再测试新建的student是否一样
		boolean flag=s1.equals(s2);
		System.out.println(flag);
		//==对比的也是两个对象的内存地址
		System.out.println(s1.getAge()==s2.getAge());
		
	}
	
}
