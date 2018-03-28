package ThrowsAndThrow;

public class ThrowsAndThrowTest {

	String name;
	int age;
	String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) throws Exception{
		if(sex.equals("男") || sex.equals("女")){
			this.sex = sex;
		}else{
			//如果赋值有问题，抛出异常
			throw new Exception("性别必须是男女");
		}
	}
	
	public static void main(String[] args) {
		ThrowsAndThrowTest t = new ThrowsAndThrowTest();
		try{
			t.setSex("公");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
