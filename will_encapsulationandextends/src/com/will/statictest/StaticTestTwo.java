package com.will.statictest;

/*
 * author:will
 * 用来测试静态变量
 */
public class StaticTestTwo {
     static int num;//这里之所以要用静态变量，是因为静态方法无法调用非静态变量和非静态方法
     
     /*
      * 运行结果是4，这里就证明了静态变量在内存中只有一个copy，不管你新建多少个对象，操作的始终是同一个对象
      * static变量的作用：
        ①能被类的所有实例共享，可作为实例之间进行交流的共享数据
        ②如果类的所有实例都包含一个相同的常量属性，可把这个属性定义为静态常量类型，从而节省内存空间

      */
     public static void main(String[] args) {
		num++;
		//创建第一个StaticTestTwo实体，并调用其静态变量，加1
		StaticTestTwo s1 = new StaticTestTwo();
		s1.num++;
		//创建第二个StaticTestTwo实体，并调用其静态变量，加1
		StaticTestTwo s2 = new StaticTestTwo();
		s2.num++;
		StaticTestTwo.num++;
		System.out.println(num);
	}
	
	
}
