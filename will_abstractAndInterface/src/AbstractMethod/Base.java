package AbstractMethod;

public abstract class Base {

	public static int var = 2;//父类静态方法
	public String value = "rest";//父类成员变量
	
	public abstract void method1();
	
	public abstract void method2();
	
	public abstract void method3();
	
	public static void method4(){
		System.out.println("父类静态方法");
	};
	
}
