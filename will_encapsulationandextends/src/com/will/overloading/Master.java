package com.will.overloading;
/*
 * ��������Ҫ�������｡��ֵ�͵�����´�������
 */
public class Master {
	/*
	 * ���������صķ�����������һ�£�������һ��
	 */
	//����������
	public void cure(Dog dog){
		if(dog.getHealth()<60){
			System.out.println("��������ҩ��");
			dog.setHealth(60);
		}
	}
	
	//����쿴��
		public void cure(Penguin penguin){
			if(penguin.getHealth()<60){
				System.out.println("������������");
				penguin.setHealth(60);
			}
		}
	
}
