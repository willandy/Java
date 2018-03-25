package SearchStudent;

import java.util.Scanner;

/*
 * 搜查学生姓名测试类
 * 
 */
public class SearchStudentTest {
    //设置学生数组
	Student[] student = new Student[5];
	
	/*
	 * 增加学生
	 */
	public void addStudent(Student s){
		/*
		 * 循环增加学生姓名
		 */
		//判断是否插入成功
		boolean flag = false;
		for(int i=0;i<student.length;i++){
			if(student[i] == null){
				student[i] = s;
				flag = true;
				System.out.println("数据插入成功!");
				break;
			}
		}
		if(!flag){
			System.out.println("学员数组已满，不能再增加学生!");
		}
	}
	
	/*
	 * 显示学员信息
	 */
	public void infoStudent(){
		for(int i=0;i<student.length;i++){
			if(student[i]!=null){
				System.out.println("添加的学员姓名为："+student[i].name);
			}
		}
	}
	
	/*
	 * 再指定范文内搜索相应的学生名称
	 * return : void
	 * params:name:学生名称,start：查找开始,end：查找结尾
	 */
	public void searchInfo(String name,int start,int end){
		if(start >=0 && end <=student.length){
			for(int i=start;i<=end;i++){
				if(student[i].name.toString().trim().equals("Tom")){
					System.out.println("该学生存在!");
					break;
				}
			}
		}
	}
	
	/*
	 * 进行数据测试
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		SearchStudentTest search = new SearchStudentTest();
		String result = "";
		do{
		Student s = new Student();
		//添加学生信息
		System.out.println("请添加学生姓名:");
		s.name = scanner.next();
		System.out.println("请添加学生年龄:");
		s.age = scanner.nextInt();
		System.out.println("请添加学生专业:");
		s.major = scanner.next();
		//添加数据
		search.addStudent(s);

		System.out.println("是否继续添加学员信息?y/n");
		result = scanner.next();
		}while(result.equals("y"));//判断是否继续添加学员信息，如果为y，就继续添加
		
		//显示学员数据
	   search.infoStudent();
		//根据条件查找学员姓名
		search.searchInfo("Tom", 0, 1);
		
	}
	
}

