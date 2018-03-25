package will_OOP;

/*
 * 创建学校的类
 */
public class CreateSchool {

	/*
	 * 程序测试口
	 * params : args
	 */
	public static void main(String[] args){
		/*
		 * 创建第一个实体类实例
		 */
		School first_school = new School();
		//设置学校名字
		first_school.schoolName = "宇宙大学";
		//设置学校机房数量
		first_school.equipmentRoom = 2000;
		//设置学校数量
		first_school.schoolNum = 10000;
		//展示学校信息
		first_school.show();
		
		/*
		 * 创建第二个实体类实例
		 */
		School second_school = new School();
		//设置学校名字
		second_school.schoolName = "社会大学";
		//设置学校机房数量
		second_school.equipmentRoom = 3000;
		//设置学校数量
		second_school.schoolNum = 70000;
		//展示学校信息
		second_school.show();
	}
	
}
