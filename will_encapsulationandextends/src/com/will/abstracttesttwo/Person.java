package com.will.abstracttesttwo;

/*
 * 主要是来查看子类调用父类的构造方法
 */
 class Person {

	 String name = "无名氏";
	 
	 public Person(){
		 System.out.println("执行person()");
	 }
	 
	 public Person(String name){
		 this.name = name;
		 System.out.println("执行Person(name)");
	 }	 
}

 class Student extends Person{
	 
	 String school = "清华大学";//学校
	 
	 public Student(){
		 //super();//写不写，效果都一样，会默认效用父类无参的构造方法，如果写了带参的构造方法就会覆盖默认的无参构造方法
		 System.out.println("执行Student()");
	 }
	 
	 public Student(String school,String name){
		 super(name);//显示调用了父类带参构造方法，将不执行无参构造方法
		 this.school = school;
	 }
	 
 }
 
 
 