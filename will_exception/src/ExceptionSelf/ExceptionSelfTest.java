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
		if(sex.equals("男") || sex.equals("女")){
			this.sex = sex;
		}else{
			throw new SexException("性别必须是男女");
		}
	}
	
	public static void main(String[] args) {
		ExceptionSelfTest e =new ExceptionSelfTest();
		try{
			e.setSex("公");
		}catch(SexException ex){
			ex.printStackTrace();
		}
	}
	
}
