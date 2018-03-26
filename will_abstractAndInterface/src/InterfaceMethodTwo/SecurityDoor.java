package InterfaceMethodTwo;

public class SecurityDoor extends Door implements Lock,Picture {
  //关门
	@Override
	public void close() {
		// TODO Auto-generated method stub
    System.out.println("轻轻拉门，门关上了。");
	}
	//关门
	@Override
	public void Locked() {
		// TODO Auto-generated method stub
    System.out.println("插进钥匙，向左旋转钥匙三圈，锁上了，拔出钥匙。");
	}
    //拍照
	@Override
	public void takephoto() {
		// TODO Auto-generated method stub
		System.out.println("铃...咔嚓...照片存储");	
	}
	//锁门
	@Override
	public void unlocked() {
		// TODO Auto-generated method stub
	System.out.println("插进钥匙，向右旋转钥匙三圈，锁打开了，拔出钥匙。");
	}
     //开门
	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("用力推，门开了。");
	}
}

  class test{
	public static void main(String[] args) {
		SecurityDoor s =new SecurityDoor();
		s.close();
		s.Locked();
		s.takephoto();
		s.unlocked();
		s.open();
	}
}

