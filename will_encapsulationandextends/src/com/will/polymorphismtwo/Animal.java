package com.will.polymorphismtwo;

/*
 * ����ĸ��࣬����ʵ�ֶ�̬��ʹ�ø�����Ϊ�����ķ���ֵ����
 */
public abstract class Animal {
	public abstract void cry();
}
//����:��
class Dog extends Animal{

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("������...");
	}
}

//���ࣺѼ��
class Duck extends Animal{

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("������....");
	}
	
}
	
//���ظ��������ֵ,���ǵ��͵Ĺ�������
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

//���Է��ظ�������
class TestReturnAnimal{
	public static void main(String[] args) {
		String type = "dog";
		AnimalDoSomething dosomething = new AnimalDoSomething();
		Animal animal=dosomething.WhoisAnimal(type);
		animal.cry();
	}
}










