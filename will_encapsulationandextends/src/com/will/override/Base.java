package com.will.override;

/*
 * 重写方法的测试
 */
class Base {

	//普通方法
	public void method1(){
		System.out.println("父类的普通方法method1");
	}
	//返回父类类型
	public Base method2(){
		System.out.println("父类的普通方法method2");
		return new Base();
	}
	//父类静态方法
	public static void method3(){
		System.out.println("父类的静态方法method3");
	}
	//父类私有方法
	private void method4(){
		System.out.println("父类的私有方法mehod4");
	}
	
}

/*
 * 继承Base类，然后重写Base类里面的方法
 */
class Sub extends Base{
	//重写父类普通method1的方法
	public void method1(){
		System.out.println("子类的普通方法method1");
	}
	
	//重写父类的method2方法，返回子类类型，也是重写
	public Sub method2(){
		return new Sub();  //方法一样，参数列表一样，返回值是子类，也是重写
	}
	
	//静态方法不能重写，同时不能去掉static，如果父类是静态方法就不能被子类覆盖为非静态方法，父类如果是非静态方法不能被子类覆盖为静态方法
	public static void method3(){
		System.out.println("子类的静态方法method3");
	}
	//私有方法无法继承，即无法重写
	private void method4(){
		System.out.println("子类的私有方法mehod4");
	}
	
}











