package com.will.encapsulation;

/*
 * 创建企鹅类，然后进行封装
 * author:will
 */
public class Penguin {

	private String name="无名氏";//姓名
	private Integer health = 100;//健康值，默认值为100，健康值为1-100之间，小于60为不健康
	private Integer love = 20;//亲密度
	private String sex = "Q仔";//性别
	
	/*
	 * get和set封装
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		//进行健康值数据判断
		if(health<=0 || health>100){
			System.out.println("数据输入错误，请重新输入!");
			this.health = 60;//设置默认值
		}else{
		this.health = health;
	    }
	}
	public Integer getLove() {
		return love;
	}
	public void setLove(Integer love) {
		//进行亲密度数据判断
		if(love<=0 || love>100){
			System.out.println("数据输入错误，请重新输入!");
			this.love = 60;//设置默认值
		}else{
		this.love = love;
	    }
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/*
	 * 输出企鹅的信息
	 * return:void
	 */
	public void show(){
		System.out.println("企鹅的姓名是 :"+this.name+" ,健康值:"+this.health+" ,亲密度:"+this.love+" ,性别:"+this.sex);
	}
	
}
