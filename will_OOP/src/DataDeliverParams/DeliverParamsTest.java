package DataDeliverParams;

import SearchStudent.Student;

/*
 * 方法传参
 * 主要来看基本数据类型和引用数据类型的传送数据区别，具体解释查看博客介绍
 */
public class DeliverParamsTest {
	 //传基本数据类型
      public void test1(int num){
    	  num = num +1;
      }
      //传引用数据类型
      public void test2(Student student){
    	  student.age = student.age + 1;
      }
      
      public static void main(String[] args){
    	  DeliverParamsTest deliverParams = new DeliverParamsTest();
    	  Student student = new Student();
    	  //传输基本数据类型
    	  int n=8;
    	  deliverParams.test1(n);
    	  //传输引用数据类型
    	  student.age = 18;
    	  deliverParams.test2(student);
    	  
    	  //查看结果
    	  System.out.print(n+"======="+student.age);//8====19
    	  
      }
      
}
