package com.will.overloading;

public class Dog extends Pet{

	private String strain = "��԰Ȯ";//����Ʒ��

	//���췽��
	public Dog(){}
	
	public Dog(String name,String strain){
		/*
		 * �������û�е��ø���Ĺ��췽����Ҳ��Ĭ�ϵ��ø�����޲ι��췽��
		 */
		//super(name);
		this.strain = strain;
		System.out.println("����Dog�Ĵ��ι��췽��!");
	}
	
	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	public void show(){
		System.out.println("�����԰ף��ҵ������ǣ�"+this.getName()+" ,����ֵ��:"+this.getHealth()+" ,���ܶȣ�"+this.getLove()+" ,Ʒ����:"+this.strain);
	}
	
}
