package InterfaceMethodTwo;

public class SecurityDoor extends Door implements Lock,Picture {
  //����
	@Override
	public void close() {
		// TODO Auto-generated method stub
    System.out.println("�������ţ��Ź����ˡ�");
	}
	//����
	@Override
	public void Locked() {
		// TODO Auto-generated method stub
    System.out.println("���Կ�ף�������תԿ����Ȧ�������ˣ��γ�Կ�ס�");
	}
    //����
	@Override
	public void takephoto() {
		// TODO Auto-generated method stub
		System.out.println("��...����...��Ƭ�洢");	
	}
	//����
	@Override
	public void unlocked() {
		// TODO Auto-generated method stub
	System.out.println("���Կ�ף�������תԿ����Ȧ�������ˣ��γ�Կ�ס�");
	}
     //����
	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("�����ƣ��ſ��ˡ�");
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

