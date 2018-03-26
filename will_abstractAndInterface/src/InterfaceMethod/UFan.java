package InterfaceMethod;

/*
 * 风扇实现类
 */
public class UFan implements UsbInterface {

	@Override
	public void service() {
		// TODO Auto-generated method stub
       System.out.println("风扇链接上，风吹了...");
	}

}
