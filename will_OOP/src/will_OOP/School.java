package will_OOP;

/*
 * School类
 */
public class School {

	//学校名称
	public String schoolName;
	//学校机房
	public int equipmentRoom;
	//学校数量
	public int schoolNum;
	
	/*
	 * 方法：打印学校信息
	 * return void
	 */
	public void show(){
		System.out.println("学校名称为 ："+schoolName+" , 机房有 :"+equipmentRoom+" : 学校数量有 :"+schoolNum);
	}
	
}
