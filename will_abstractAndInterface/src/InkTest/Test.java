package InkTest;

public class Test {

	
	
	public static void main(String[] args) {
		Factory factory =new Factory();
		Ink ink = null;
		Paper paper = null;
		
		//打印黑白墨盒在A4上打印
		ink = new GrayInk();
		paper = new A4Paper();
		factory.setInk(ink);
		factory.setPaper(paper);
		factory.print();
		
		//彩色墨盒在B5上打印
		ink = new ColorInk();
		paper = new B5Paper();
		factory.setInk(ink);
		factory.setPaper(paper);
		factory.print();
	}
	
}
