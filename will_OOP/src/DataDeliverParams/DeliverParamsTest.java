package DataDeliverParams;

import SearchStudent.Student;

/*
 * ��������
 * ��Ҫ���������������ͺ������������͵Ĵ����������𣬾�����Ͳ鿴���ͽ���
 */
public class DeliverParamsTest {
	 //��������������
      public void test1(int num){
    	  num = num +1;
      }
      //��������������
      public void test2(Student student){
    	  student.age = student.age + 1;
      }
      
      public static void main(String[] args){
    	  DeliverParamsTest deliverParams = new DeliverParamsTest();
    	  Student student = new Student();
    	  //���������������
    	  int n=8;
    	  deliverParams.test1(n);
    	  //����������������
    	  student.age = 18;
    	  deliverParams.test2(student);
    	  
    	  //�鿴���
    	  System.out.print(n+"======="+student.age);//8====19
    	  
      }
      
}
