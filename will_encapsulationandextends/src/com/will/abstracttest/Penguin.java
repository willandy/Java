package com.will.abstracttest;

public class Penguin extends Pet{

	private String sex ="��"; //�Ա�

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void show(){
		System.out.println("������԰�:�ҵ������ǣ�"+this.getName()+" ,����ֵ��:"+this.getHealth()+" ,���ܶ��ǣ�"+this.getLove()+" ,�Ա��ǣ�"+this.sex);
	}
	
	
}
