package com.will.overloading;

public class TestOverloading {
    public static void main(String[] args) {
    	//����һ������ʵ��
    	Dog dog = new Dog("Jack","��԰Ȯ");
    	dog.setHealth(30);
    	System.out.println("=========��������ҩǰ==========");
    	dog.show();
    	Master master = new Master();
    	master.cure(dog);
    	System.out.println("=========��������ҩ��==========");
    	dog.show();
	}
}
