package TouristSight;

import java.util.Scanner;

/*
 * �����ο;�����Ʊ�۸�
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
			//����ʵ����ʵ��
			Tourist tourist = new Tourist();
			//����̨�����ı�����
			System.out.println("�������ο����� ��");
			//�����ο�����
			tourist.touristName = scanner.next();
			//����̨�����ı�����
			System.out.println("�������ο����� ��");
			//�����ο�����
			tourist.touristAge = scanner.nextInt();
			
			//��ʾ��Ϣ
			tourist.show();
			//�ж��Ƿ������Ʊ
			System.out.println("�Ƿ������y/n");
			answer = scanner.next();
		}while(answer.equals("y"));  //������y��ʱ�򣬼���ִ�з������������,ע������ֻ�������涨��һ��string������Ȼ��ȥ����������ֶΣ���scanner.next()=="y"���޷�ִ�з�����
	}
	
}
