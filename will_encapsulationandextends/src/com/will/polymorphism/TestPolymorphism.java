package com.will.polymorphism;

/*
 * 多态测试类
 */
public class TestPolymorphism {
      public static void main(String[] args) {
    	  //狗狗去医院
    	  Pet pet = new Dog("jj","秋田犬");
    	  pet.setHealth(30);
    	  pet.show();
    	  //pet.catchDisk();//狗狗特有的叼飞碟的方法就没有
    	  //但是向下转型有个问题就是：如果父类强制转换成的子类，是其他类型的子类就会报错，比如:原本子类是dog，转换成了penguin
    	  //所以为了减少向下转型时的错误，用instanceof进行判断
    	  if(pet instanceof Dog){
        	  //因为向上转型：父类引用子类对象，无法调用子类特有的方法，所以需要向下转型，父类强制转换成子类
    		  Dog dog =(Dog)pet;
        	  dog.catchDisk();//就可以获取子类特有的方法了
    	  }else if(pet instanceof Penguin){
    		  //如果判断是企鹅
    		  Penguin penguin =(Penguin)pet;
    		  penguin.swimming();
    	  }
    	  System.out.println("-------------------------------------");
    	  Master master =new Master();
    	  master.cure(pet);
    	  pet.show();
    	  System.out.println("===============================================");
    	  //企鹅去医院
    	  Pet pet_penguin = new Penguin("qq","男");
    	  pet_penguin.setHealth(40);
    	  pet_penguin.show();
    	  System.out.println("-----------------------------------");
    	  master.cure(pet_penguin);
    	  pet_penguin.show();
	}
}
