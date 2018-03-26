package InterfaceMethod;

public class Test {

	public static void main(String[] args) {
		//接口引用变量指向具体的实现类
		UsbInterface s = new UDisk();
		s.service();
		UsbInterface s1 = new UFan();
		s1.service();
	}
	
}
