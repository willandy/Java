package com.will.polymorphism;

public class Penguin extends Pet{

	private String sex ="��"; //�Ա�

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	//�յĹ��췽��
	public Penguin(){}
	//�������Ĺ��췽��
	public Penguin(String name,String sex){
		this.sex = sex;
	}
	
	public void show(){
		System.out.println("������԰�:�ҵ������ǣ�"+this.getName()+" ,����ֵ��:"+this.getHealth()+" ,���ܶ��ǣ�"+this.getLove()+" ,�Ա��ǣ�"+this.sex);
	}
	
	//ȥҽԺ�ķ���
		public void toHospital(){
			if(this.getHealth()<50){
				System.out.println("��ҩ���ݼ�");
				this.setHealth(60);
			}
		}
	
		//������Ӿ
		public void swimming(){
			System.out.println("�����Ӿ!");
		}
		
}
