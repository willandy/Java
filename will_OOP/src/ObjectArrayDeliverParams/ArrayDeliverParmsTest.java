package ObjectArrayDeliverParams;

import SearchStudent.Student;

/*
 * 方法参数传递
 * 对于数组传递参数测试，用以证明引用数据类型(数组)传输的是地址，形参改变，实参也会改变，具体的查看博客介绍
 * 在学生数组中，有低于60分的，整体分数加2
 */
public class ArrayDeliverParmsTest {

	   /*
	    *params:Student[]
	    * return: void
	    */
	    public void ScoreAddTwo(Student[] s){
	    	//如果有分数低于60分的，集体成绩加2
	    	boolean flag = false;
	    	for(int i=0;i<s.length;i++){
	    		if(s[i].score<60){
	    			flag = true;
	    			break;
	    		}
	    	}
	    	//集体分数加2
	    	for(int j=0;j<s.length;j++){
	    		s[j].score +=2;
	    	}
	    	
	    }

	    public static void main(String[] args) {
	    	//创建学生数组
	    	Student[] stu = new Student[2];
            //实例化两个学生对象
	    	Student student1 =new Student();
	    	student1.name="Tom";
	    	student1.age=12;
	    	student1.major="computer";
	    	student1.score = 80;
	    	
	    	Student student2 =new Student();
	    	student2.name="Jack";
	    	student2.age=15;
	    	student2.major="math";
	    	student2.score = 30;
	    	
	    	//学生信息传入数组
	    	stu[0]=student1;
	    	stu[1]=student2;
	    	
	    	ArrayDeliverParmsTest arrayDeliverParms = new ArrayDeliverParmsTest();
	    	arrayDeliverParms.ScoreAddTwo(stu);
	    	
	    	System.out.println("========================测试后的数据=============================");
	    	for(int x=0;x<stu.length;x++){
	    		System.out.println("学生的姓名为  :"+stu[x].name+" ,分数为:"+stu[x].score);
	    	}
	    	
		}
	    
}
