package com.will.abstracttesttwo;

/*
 * ��Ҫ�����鿴������ø���Ĺ��췽��
 */
 class Person {

	 String name = "������";
	 
	 public Person(){
		 System.out.println("ִ��person()");
	 }
	 
	 public Person(String name){
		 this.name = name;
		 System.out.println("ִ��Person(name)");
	 }	 
}

 class Student extends Person{
	 
	 String school = "�廪��ѧ";//ѧУ
	 
	 public Student(){
		 //super();//д��д��Ч����һ������Ĭ��Ч�ø����޲εĹ��췽�������д�˴��εĹ��췽���ͻḲ��Ĭ�ϵ��޲ι��췽��
		 System.out.println("ִ��Student()");
	 }
	 
	 public Student(String school,String name){
		 super(name);//��ʾ�����˸�����ι��췽��������ִ���޲ι��췽��
		 this.school = school;
	 }
	 
 }
 
 
 