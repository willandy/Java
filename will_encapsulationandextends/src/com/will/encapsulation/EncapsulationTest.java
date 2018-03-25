package com.will.encapsulation;

import java.util.Scanner;

/*
 * 测试封装的数据
 * author:will
 */
public class EncapsulationTest {
	private static Dog dog; //狗狗类别
	private static Penguin penguin;//企鹅类别
	private static int selectPetData;
	private static String name;//宠物名字
	private static int health;//宠物健康值
	private static int love;//宠物亲密值
	public static void main(String[] args) {
		/*
		 * 创建狗的实例
		 */
//		Dog dog = new Dog();
//		dog.setName("Tom");//设置狗的名字
//		dog.setHealth(1000);//设置狗的健康值，健康值在pojo中控制在1-100
//		dog.setLove(70);//设置亲密度
//		dog.setStrain("泰迪");//设置狗的品种
//		dog.show();
		
		/*
		 * 创建企鹅的实例
		 */
//		Penguin penguin = new Penguin();
//		penguin.setName("Micheal");//设置狗的名字
//		penguin.setHealth(70);//设置狗的健康值，健康值在pojo中控制在1-100
//		penguin.setLove(20);//设置亲密度
//		penguin.setSex("妹子");//设置企鹅的性别
//		penguin.show();
		
		/*
		 * 创建一个基础的电子宠物系统，保证健康值的有效性(0-100)，否则默认值为60
		 * 亲密度的有效性(0-100),否则默认值为60
		 */
		Scanner scanner = new Scanner(System.in);//控制台输入功能
		System.out.println("=============欢迎您来宠物店==============");
		System.out.println("请输入要领养宠物的类型(1/2):");
		selectPetData = scanner.nextInt();
		if(selectPetData==1){
		    dog =new Dog();//创建狗狗的实体类
			//进入狗狗领养
		}else if(selectPetData==2){
		    penguin = new Penguin();//创建企鹅的实体类
		}else{
			System.out.println("请输入正确的数字!");
			System.exit(0);;
		}
		/*
		 * 调用方法
		 * 用来输入宠物的基础数据
		 * params:姓名，健康值，亲密度
		 */
		System.out.println("请输入宠物的姓名:");
		name = scanner.next();
		System.out.println("请输入宠物的健康值:");
		health = scanner.nextInt();
		System.out.println("请输入宠物的亲密值:");
		love = scanner.nextInt();
		BasePetData(name,health,love);
	}
	
	//输入姓名，健康值和亲密值
	public static void BasePetData(String PetName,int PetHealth,int PetLove){
		   Scanner scanner = new Scanner(System.in);//控制台输入功能
			if(selectPetData == 1){
				//如果是狗狗，就加品种
				System.out.println("请输入狗狗的品种:");
				dog.setStrain(scanner.next());
				dog.setName(PetName);
				dog.setHealth(PetHealth);
				dog.setLove(PetLove);
				System.out.println("宠物的自白:");
				dog.show();
			}else{
				//如果是企鹅，就加性别
				System.out.println("请输入企鹅的性别:");
				penguin.setSex(scanner.next());
				penguin.setName(PetName);
				penguin.setHealth(PetHealth);
				penguin.setLove(PetLove);
				System.out.println("宠物的自白:");
				penguin.show();
			}	
	}
	
	
}
