package com.will.abstracttestthree;

/*
 * 这里来测试子类调用父类的方法，如果不调用构造方法的情况
 */
 class Car {

	 private int site = 4; //初始化载客量
	 
	 //空的构造方法
	 public Car(){
		 System.out.println("载客量是："+site);
	 }
	 //给site赋值
	 public void setSite(int site){
		 this.site = site;
	 }
	 
	 void print(){
		 System.out.println("载客量是:"+site);
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
		Car car =new Car(); //这里就会调用父类空的构造方法
		bus.print();
	}
}
 
 
 
 
 
 
 
 
 
 
 