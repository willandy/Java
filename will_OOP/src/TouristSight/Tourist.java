package TouristSight;
/*
 * �����ο͵�ʵ����
 */
public class Tourist {

	public String touristName; //�ο�����
	public int touristAge;   //�ο�����
	
	/*
	 * �������
	 * �����ο����������ͬ�ļ۸񣬳���20Դ��δ�������
	 */
	public void show(){
		if(touristAge >= 18){
			//��������Ʊ�۸�20Ԫ
			System.out.println(" �ο�����Ϊ  :"+touristName+" ,����Ϊ  :"+touristAge+" ,��ƱΪ :20Ԫ");
		}else if(touristAge >=0){
			//δ��������Ʊ�۸�20Ԫ
			System.out.println(" �ο�����Ϊ  :"+touristName+" ,����Ϊ  :"+touristAge+" ,��ƱΪ :10Ԫ");
		}
	}
	
}
