package InterfaceMethod;

/*
 * 数据磁盘实现类
 */
public class UDisk implements UsbInterface {

	@Override
	public void service() {
		// TODO Auto-generated method stub
      System.out.println("数据连接，开始传输数据");
	}

}
