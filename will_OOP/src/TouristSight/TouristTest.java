package TouristSight;

import java.util.Scanner;

/*
 * 测试游客景点门票价格
 */
public class TouristTest {

	/*
	 * return :void
	 * param:args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		String answer ="";
		do{
			//创建实体类实例
			Tourist tourist = new Tourist();
			//控制台输入文本内容
			System.out.println("请输入游客名字 ：");
			//输入游客名字
			tourist.touristName = scanner.next();
			//控制台输入文本内容
			System.out.println("请输入游客年龄 ：");
			//输入游客年龄
			tourist.touristAge = scanner.nextInt();
			
			//显示信息
			tourist.show();
			//判断是否继续售票
			System.out.println("是否继续：y/n");
			answer = scanner.next();
		}while(answer.equals("y"));  //当输入y的时候，继续执行方法体里的内容,注意这里只能在上面定义一个string方法，然后去等于输入的字段，用scanner.next()=="y"，无法执行方法体
	}
	
}
