package SearchStudent;

import java.util.Scanner;

/*
 * �Ѳ�ѧ������������
 * 
 */
public class SearchStudentTest {
    //����ѧ������
	Student[] student = new Student[5];
	
	/*
	 * ����ѧ��
	 */
	public void addStudent(Student s){
		/*
		 * ѭ������ѧ������
		 */
		//�ж��Ƿ����ɹ�
		boolean flag = false;
		for(int i=0;i<student.length;i++){
			if(student[i] == null){
				student[i] = s;
				flag = true;
				System.out.println("���ݲ���ɹ�!");
				break;
			}
		}
		if(!flag){
			System.out.println("ѧԱ��������������������ѧ��!");
		}
	}
	
	/*
	 * ��ʾѧԱ��Ϣ
	 */
	public void infoStudent(){
		for(int i=0;i<student.length;i++){
			if(student[i]!=null){
				System.out.println("��ӵ�ѧԱ����Ϊ��"+student[i].name);
			}
		}
	}
	
	/*
	 * ��ָ��������������Ӧ��ѧ������
	 * return : void
	 * params:name:ѧ������,start�����ҿ�ʼ,end�����ҽ�β
	 */
	public void searchInfo(String name,int start,int end){
		if(start >=0 && end <=student.length){
			for(int i=start;i<=end;i++){
				if(student[i].name.toString().trim().equals("Tom")){
					System.out.println("��ѧ������!");
					break;
				}
			}
		}
	}
	
	/*
	 * �������ݲ���
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		SearchStudentTest search = new SearchStudentTest();
		String result = "";
		do{
		Student s = new Student();
		//���ѧ����Ϣ
		System.out.println("�����ѧ������:");
		s.name = scanner.next();
		System.out.println("�����ѧ������:");
		s.age = scanner.nextInt();
		System.out.println("�����ѧ��רҵ:");
		s.major = scanner.next();
		//�������
		search.addStudent(s);

		System.out.println("�Ƿ�������ѧԱ��Ϣ?y/n");
		result = scanner.next();
		}while(result.equals("y"));//�ж��Ƿ�������ѧԱ��Ϣ�����Ϊy���ͼ������
		
		//��ʾѧԱ����
	   search.infoStudent();
		//������������ѧԱ����
		search.searchInfo("Tom", 0, 1);
		
	}
	
}

