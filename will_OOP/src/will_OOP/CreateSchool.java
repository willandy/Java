package will_OOP;

/*
 * ����ѧУ����
 */
public class CreateSchool {

	/*
	 * ������Կ�
	 * params : args
	 */
	public static void main(String[] args){
		/*
		 * ������һ��ʵ����ʵ��
		 */
		School first_school = new School();
		//����ѧУ����
		first_school.schoolName = "�����ѧ";
		//����ѧУ��������
		first_school.equipmentRoom = 2000;
		//����ѧУ����
		first_school.schoolNum = 10000;
		//չʾѧУ��Ϣ
		first_school.show();
		
		/*
		 * �����ڶ���ʵ����ʵ��
		 */
		School second_school = new School();
		//����ѧУ����
		second_school.schoolName = "����ѧ";
		//����ѧУ��������
		second_school.equipmentRoom = 3000;
		//����ѧУ����
		second_school.schoolNum = 70000;
		//չʾѧУ��Ϣ
		second_school.show();
	}
	
}
