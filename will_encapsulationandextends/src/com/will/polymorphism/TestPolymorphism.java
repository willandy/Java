package com.will.polymorphism;

/*
 * ��̬������
 */
public class TestPolymorphism {
      public static void main(String[] args) {
    	  //����ȥҽԺ
    	  Pet pet = new Dog("jj","����Ȯ");
    	  pet.setHealth(30);
    	  pet.show();
    	  //pet.catchDisk();//�������еĵ�ɵ��ķ�����û��
    	  //��������ת���и�������ǣ��������ǿ��ת���ɵ����࣬���������͵�����ͻᱨ������:ԭ��������dog��ת������penguin
    	  //����Ϊ�˼�������ת��ʱ�Ĵ�����instanceof�����ж�
    	  if(pet instanceof Dog){
        	  //��Ϊ����ת�ͣ�����������������޷������������еķ�����������Ҫ����ת�ͣ�����ǿ��ת��������
    		  Dog dog =(Dog)pet;
        	  dog.catchDisk();//�Ϳ��Ի�ȡ�������еķ�����
    	  }else if(pet instanceof Penguin){
    		  //����ж������
    		  Penguin penguin =(Penguin)pet;
    		  penguin.swimming();
    	  }
    	  System.out.println("-------------------------------------");
    	  Master master =new Master();
    	  master.cure(pet);
    	  pet.show();
    	  System.out.println("===============================================");
    	  //���ȥҽԺ
    	  Pet pet_penguin = new Penguin("qq","��");
    	  pet_penguin.setHealth(40);
    	  pet_penguin.show();
    	  System.out.println("-----------------------------------");
    	  master.cure(pet_penguin);
    	  pet_penguin.show();
	}
}
