package InterfaceMethod;

public class Test {

	public static void main(String[] args) {
		//�ӿ����ñ���ָ������ʵ����
		UsbInterface s = new UDisk();
		s.service();
		UsbInterface s1 = new UFan();
		s1.service();
	}
	
}
