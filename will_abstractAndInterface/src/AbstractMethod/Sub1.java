package AbstractMethod;

public class Sub1 extends Base{
	public static int var = 3;//子类静态方法
	public String value = "restChild";//子类成员变量
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("子类方法");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	public static void method4(){
		System.out.println("父类静态方法");
	};
	
}
