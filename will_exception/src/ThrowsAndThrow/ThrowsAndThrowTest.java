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
		if(sex.equals("��") || sex.equals("Ů")){
			this.sex = sex;
		}else{
			//�����ֵ�����⣬�׳��쳣
			throw new Exception("�Ա��������Ů");
		}
	}
	
	public static void main(String[] args) {
		ThrowsAndThrowTest t = new ThrowsAndThrowTest();
		try{
			t.setSex("��");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
