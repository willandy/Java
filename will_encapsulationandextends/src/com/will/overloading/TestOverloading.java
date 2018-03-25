package com.will.overloading;

public class TestOverloading {
    public static void main(String[] args) {
    	//创建一个狗狗实例
    	Dog dog = new Dog("Jack","田园犬");
    	dog.setHealth(30);
    	System.out.println("=========看病，吃药前==========");
    	dog.show();
    	Master master = new Master();
    	master.cure(dog);
    	System.out.println("=========看病，吃药后==========");
    	dog.show();
	}
}
