package InkTest;

public class Test {

	
	
	public static void main(String[] args) {
		Factory factory =new Factory();
		Ink ink = null;
		Paper paper = null;
		
		//��ӡ�ڰ�ī����A4�ϴ�ӡ
		ink = new GrayInk();
		paper = new A4Paper();
		factory.setInk(ink);
		factory.setPaper(paper);
		factory.print();
		
		//��ɫī����B5�ϴ�ӡ
		ink = new ColorInk();
		paper = new B5Paper();
		factory.setInk(ink);
		factory.setPaper(paper);
		factory.print();
	}
	
}
