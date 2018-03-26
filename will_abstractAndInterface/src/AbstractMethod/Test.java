package AbstractMethod;

public class Test {

public static void main(String[] args) {
	/*
	 * 静态绑定（成员变量、静态方法）
	 * 动态绑定（重写后的方法）
	 */
	Base base = new Sub1();
	base.method1();//子类重写了父类方法，调用的是子类重写后的方法，属于动态绑定，跟着对象走
	/*
	 * 如果父类中写了静态方法和成员变量,如果子类也写了静态方法和成员变量，但是调用的是
	 * 父类的静态方法和成员变量，这就是静态绑定，因为静态方法，成员变量以及静态变量，是
	 * 跟着类型走的，而不是对象
	 */
	base.method4();
	System.out.println(base.value);
}
	
}
