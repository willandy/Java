package ExceptionSelf;

public class ExceptionSelfTest {

	String name;
	String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) throws SexException{
		if(sex.equals("��") || sex.equals("Ů")){
			this.sex = sex;
		}else{
			throw new SexException("�Ա��������Ů");
		}
	}
	
	public static void main(String[] args) {
		ExceptionSelfTest e =new ExceptionSelfTest();
		try{
			e.setSex("��");
		}catch(SexException ex){
			ex.printStackTrace();
		}
	}
	
}
