package com.will.encapsulation;

import java.util.Scanner;

/*
 * ���Է�װ������
 * author:will
 */
public class EncapsulationTest {
	private static Dog dog; //�������
	private static Penguin penguin;//������
	private static int selectPetData;
	private static String name;//��������
	private static int health;//���｡��ֵ
	private static int love;//��������ֵ
	public static void main(String[] args) {
		/*
		 * ��������ʵ��
		 */
//		Dog dog = new Dog();
//		dog.setName("Tom");//���ù�������
//		dog.setHealth(1000);//���ù��Ľ���ֵ������ֵ��pojo�п�����1-100
//		dog.setLove(70);//�������ܶ�
//		dog.setStrain("̩��");//���ù���Ʒ��
//		dog.show();
		
		/*
		 * ��������ʵ��
		 */
//		Penguin penguin = new Penguin();
//		penguin.setName("Micheal");//���ù�������
//		penguin.setHealth(70);//���ù��Ľ���ֵ������ֵ��pojo�п�����1-100
//		penguin.setLove(20);//�������ܶ�
//		penguin.setSex("����");//���������Ա�
//		penguin.show();
		
		/*
		 * ����һ�������ĵ��ӳ���ϵͳ����֤����ֵ����Ч��(0-100)������Ĭ��ֵΪ60
		 * ���ܶȵ���Ч��(0-100),����Ĭ��ֵΪ60
		 */
		Scanner scanner = new Scanner(System.in);//����̨���빦��
		System.out.println("=============��ӭ���������==============");
		System.out.println("������Ҫ�������������(1/2):");
		selectPetData = scanner.nextInt();
		if(selectPetData==1){
		    dog =new Dog();//����������ʵ����
			//���빷������
		}else if(selectPetData==2){
		    penguin = new Penguin();//��������ʵ����
		}else{
			System.out.println("��������ȷ������!");
			System.exit(0);;
		}
		/*
		 * ���÷���
		 * �����������Ļ�������
		 * params:����������ֵ�����ܶ�
		 */
		System.out.println("��������������:");
		name = scanner.next();
		System.out.println("���������Ľ���ֵ:");
		health = scanner.nextInt();
		System.out.println("��������������ֵ:");
		love = scanner.nextInt();
		BasePetData(name,health,love);
	}
	
	//��������������ֵ������ֵ
	public static void BasePetData(String PetName,int PetHealth,int PetLove){
		   Scanner scanner = new Scanner(System.in);//����̨���빦��
			if(selectPetData == 1){
				//����ǹ������ͼ�Ʒ��
				System.out.println("�����빷����Ʒ��:");
				dog.setStrain(scanner.next());
				dog.setName(PetName);
				dog.setHealth(PetHealth);
				dog.setLove(PetLove);
				System.out.println("������԰�:");
				dog.show();
			}else{
				//�������죬�ͼ��Ա�
				System.out.println("�����������Ա�:");
				penguin.setSex(scanner.next());
				penguin.setName(PetName);
				penguin.setHealth(PetHealth);
				penguin.setLove(PetLove);
				System.out.println("������԰�:");
				penguin.show();
			}	
	}
	
	
}
