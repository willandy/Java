package com.will.polymorphism;

public class Penguin extends Pet{

	private String sex ="男"; //性别

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	//空的构造方法
	public Penguin(){}
	//带参数的构造方法
	public Penguin(String name,String sex){
		this.sex = sex;
	}
	
	public void show(){
		System.out.println("宠物的自白:我的名字是："+this.getName()+" ,健康值是:"+this.getHealth()+" ,亲密度是："+this.getLove()+" ,性别是："+this.sex);
	}
	
	//去医院的方法
		public void toHospital(){
			if(this.getHealth()<50){
				System.out.println("吃药，休假");
				this.setHealth(60);
			}
		}
	
		//企鹅会游泳
		public void swimming(){
			System.out.println("企鹅游泳!");
		}
		
}
