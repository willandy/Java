package com.will.abstracttest;

public class Penguin extends Pet{

	private String sex ="男"; //性别

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void show(){
		System.out.println("宠物的自白:我的名字是："+this.getName()+" ,健康值是:"+this.getHealth()+" ,亲密度是："+this.getLove()+" ,性别是："+this.sex);
	}
	
	
}
