package com.will.abstracttest;

public class TestPet {

	public static void main(String[] args) {
		Dog dog = new Dog("Tom","秋田犬");
	    dog.show();
	    /*
	     * 在这里，会自动调用父类的无参构造方法，子类的带参构造方法
	     */
	}
}
