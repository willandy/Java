package ObjectArrayDeliverParams;

import SearchStudent.Student;

/*
 * ������������
 * �������鴫�ݲ������ԣ�����֤��������������(����)������ǵ�ַ���βθı䣬ʵ��Ҳ��ı䣬����Ĳ鿴���ͽ���
 * ��ѧ�������У��е���60�ֵģ����������2
 */
public class ArrayDeliverParmsTest {

	   /*
	    *params:Student[]
	    * return: void
	    */
	    public void ScoreAddTwo(Student[] s){
	    	//����з�������60�ֵģ�����ɼ���2
	    	boolean flag = false;
	    	for(int i=0;i<s.length;i++){
	    		if(s[i].score<60){
	    			flag = true;
	    			break;
	    		}
	    	}
	    	//���������2
	    	for(int j=0;j<s.length;j++){
	    		s[j].score +=2;
	    	}
	    	
	    }

	    public static void main(String[] args) {
	    	//����ѧ������
	    	Student[] stu = new Student[2];
            //ʵ��������ѧ������
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
	    	
	    	//ѧ����Ϣ��������
	    	stu[0]=student1;
	    	stu[1]=student2;
	    	
	    	ArrayDeliverParmsTest arrayDeliverParms = new ArrayDeliverParmsTest();
	    	arrayDeliverParms.ScoreAddTwo(stu);
	    	
	    	System.out.println("========================���Ժ������=============================");
	    	for(int x=0;x<stu.length;x++){
	    		System.out.println("ѧ��������Ϊ  :"+stu[x].name+" ,����Ϊ:"+stu[x].score);
	    	}
	    	
		}
	    
}
