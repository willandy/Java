package com.will.polymorphism;

public class Pet {

	private String name ="无名氏";//昵称
	private int health = 100;//健康值，默认在1-100之间
	private int love = 0;//亲密度
	
	public Pet(){
		System.out.println("父类无参构造方法!");
	}
	
	//给name赋值
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

	//给健康值赋值
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health<=0 || health>100){
			System.out.println("健康值输入错误！");
			this.health = 60;
		}else{
		this.health = health;
	    }
	}
 
	//给亲密度赋值
	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		if(love<=0 || love>100){
			System.out.println("亲密度输入错误!");
			this.love = 60;
		}else{
		this.love = love;
		}
	}
	
	//宠物的自白
	public void show(){
		System.out.println("宠物的自白: 我的名字叫:"+this.name+" ,我的健康值是:"+this.health+" ,亲密度是:"+this.love);
	}
	
	public void toHospital(){}
	
}
