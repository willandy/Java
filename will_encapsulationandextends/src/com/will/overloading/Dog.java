package com.will.overloading;

public class Dog extends Pet{

	private String strain = "田园犬";//狗的品种

	//构造方法
	public Dog(){}
	
	public Dog(String name,String strain){
		/*
		 * 这里就算没有调用父类的构造方法，也会默认调用父类的无参构造方法
		 */
		//super(name);
		this.strain = strain;
		System.out.println("子类Dog的带参构造方法!");
	}
	
	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	public void show(){
		System.out.println("宠物自白：我的名字是："+this.getName()+" ,健康值是:"+this.getHealth()+" ,亲密度："+this.getLove()+" ,品种是:"+this.strain);
	}
	
}
