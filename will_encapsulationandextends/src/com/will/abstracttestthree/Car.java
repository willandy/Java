package com.will.abstracttestthree;

/*
 * ����������������ø���ķ�������������ù��췽�������
 */
 class Car {

	 private int site = 4; //��ʼ���ؿ���
	 
	 //�յĹ��췽��
	 public Car(){
		 System.out.println("�ؿ����ǣ�"+site);
	 }
	 //��site��ֵ
	 public void setSite(int site){
		 this.site = site;
	 }
	 
	 void print(){
		 System.out.println("�ؿ�����:"+site);
	 }
	 
}

 class Bus extends Car{
	 Bus(int site){
		 setSite(site);
	 }
 }
 
class Test{
	public static void main(String[] args) {
		Bus bus = new Bus(20);
		Car car =new Car(); //����ͻ���ø���յĹ��췽��
		bus.print();
	}
}
 
 
 
 
 
 
 
 
 
 
 