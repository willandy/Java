package com.will.statictest;

/*
 * author:will
 * 现在主要测试static的运行方法
 */
public class StaticTest {
   
	//静态变量
	static int num=100;
	//静态代码块,如果有多个静态代码块就按顺序来加载
	static{
		num +=100;
		System.out.println(num);
	}
	static{
		num +=100;
		System.out.println(num);
	}
	
	
	public static void main(String[] args) {
		//创建第一个StaticTest的实例
		StaticTest st1 = new StaticTest();
		//创建第二个StaticTest的实例
		StaticTest st2 = new StaticTest();
		//查看输出的值
		System.out.println(StaticTest.num);
	}
	/*
	 * 从运行的结果可以看出得到的结果是200,300,300。 静态代码块只加载一次，所以，视st1出来的结果是200,300.而st2不再加载，因为StaticTest.num出来的是300，那么三个出来的结果就是200,300,300
	 */
	
}
