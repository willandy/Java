package com.will.encapsulation;

/*
 * ����Dog��ʵ���࣬�����з�װ
 * author:will
 */
public class Dog {

	private String name="������";//����
	private Integer health = 100;//����ֵ��Ĭ��ֵΪ100������ֵΪ1-100֮�䣬С��60Ϊ������
	private Integer love = 20;//���ܶ�
	private String strain = "��������������Ȯ";//Ʒ��
	
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
		//���н��������ж�
		if(health<=0 || health>100){
			System.out.println("��������������������룡");
			this.health = 60;//ƥ��Ĭ��ֵ
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
			System.out.println("��������������������룡");
			this.love = 60;//ƥ��Ĭ��ֵ
		}else{
		this.love = love;
	    }
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	/*
	 * ���������Ϣ
	 * return:void
	 */
	public void show(){
		System.out.println("������������ :"+this.name+" ,����ֵ:"+this.health+" ,���ܶ�:"+this.love+" ,Ʒ��:"+this.strain);
	}
	
	
}
