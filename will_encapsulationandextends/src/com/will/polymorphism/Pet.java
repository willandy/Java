package com.will.polymorphism;

public class Pet {

	private String name ="������";//�ǳ�
	private int health = 100;//����ֵ��Ĭ����1-100֮��
	private int love = 0;//���ܶ�
	
	public Pet(){
		System.out.println("�����޲ι��췽��!");
	}
	
	//��name��ֵ
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

	//������ֵ��ֵ
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health<=0 || health>100){
			System.out.println("����ֵ�������");
			this.health = 60;
		}else{
		this.health = health;
	    }
	}
 
	//�����ܶȸ�ֵ
	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		if(love<=0 || love>100){
			System.out.println("���ܶ��������!");
			this.love = 60;
		}else{
		this.love = love;
		}
	}
	
	//������԰�
	public void show(){
		System.out.println("������԰�: �ҵ����ֽ�:"+this.name+" ,�ҵĽ���ֵ��:"+this.health+" ,���ܶ���:"+this.love);
	}
	
	public void toHospital(){}
	
}
