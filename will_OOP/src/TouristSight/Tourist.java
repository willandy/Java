package TouristSight;
/*
 * 创建游客的实体类
 */
public class Tourist {

	public String touristName; //游客名字
	public int touristAge;   //游客年龄
	
	/*
	 * 输出方法
	 * 根据游客名字输出不同的价格，成年20源，未成年半折
	 */
	public void show(){
		if(touristAge >= 18){
			//成年人门票价格20元
			System.out.println(" 游客名字为  :"+touristName+" ,年龄为  :"+touristAge+" ,门票为 :20元");
		}else if(touristAge >=0){
			//未成年人门票价格20元
			System.out.println(" 游客名字为  :"+touristName+" ,年龄为  :"+touristAge+" ,门票为 :10元");
		}
	}
	
}
