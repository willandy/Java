package com.will.encapsulation;

/*
 * ��������࣬Ȼ����з�װ
 * author:will
 */
public class Penguin {

	private String name="������";//����
	private Integer health = 100;//����ֵ��Ĭ��ֵΪ100������ֵΪ1-100֮�䣬С��60Ϊ������
	private Integer love = 20;//���ܶ�
	private String sex = "Q��";//�Ա�
	
	/*
	 * get��set��װ
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		//���н���ֵ�����ж�
		if(health<=0 || health>100){
			System.out.println("���������������������!");
			this.health = 60;//����Ĭ��ֵ
		}else{
		this.health = health;
	    }
	}
	public Integer getLove() {
		return love;
	}
	public void setLove(Integer love) {
		//�������ܶ������ж�
		if(love<=0 || love>100){
			System.out.println("���������������������!");
			this.love = 60;//����Ĭ��ֵ
		}else{
		this.love = love;
	    }
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/*
	 * ���������Ϣ
	 * return:void
	 */
	public void show(){
		System.out.println("���������� :"+this.name+" ,����ֵ:"+this.health+" ,���ܶ�:"+this.love+" ,�Ա�:"+this.sex);
	}
	
}
