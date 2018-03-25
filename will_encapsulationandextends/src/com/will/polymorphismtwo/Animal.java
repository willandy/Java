package com.will.polymorphismtwo;

/*
 * 动物的父类，现在实现多态：使用父类作为方法的返回值类型
 */
public abstract class Animal {
	public abstract void cry();
}
//子类:狗
class Dog extends Animal{

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("汪汪汪...");
	}
}

//子类：鸭子
class Duck extends Animal{

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("咯咯咯....");
	}
	
}
	
//返回父类的类型值,这是典型的工厂方法
class AnimalDoSomething{
	public Animal WhoisAnimal(String type){
		Animal animal = null;
		if(type.equals("dog")){
			animal = new Dog();
			animal.cry();
		}else if(type.equals("duck")){
			animal = new Duck();
			animal.cry();
		}
		return animal;
	}
}

//测试返回父类类型
class TestReturnAnimal{
	public static void main(String[] args) {
		String type = "dog";
		AnimalDoSomething dosomething = new AnimalDoSomething();
		Animal animal=dosomething.WhoisAnimal(type);
		animal.cry();
	}
}










