package com.will.statictest;

/*
 * author:will
 * ������Ҫ����static�����з���
 */
public class StaticTest {
   
	//��̬����
	static int num=100;
	//��̬�����,����ж����̬�����Ͱ�˳��������
	static{
		num +=100;
		System.out.println(num);
	}
	static{
		num +=100;
		System.out.println(num);
	}
	
	
	public static void main(String[] args) {
		//������һ��StaticTest��ʵ��
		StaticTest st1 = new StaticTest();
		//�����ڶ���StaticTest��ʵ��
		StaticTest st2 = new StaticTest();
		//�鿴�����ֵ
		System.out.println(StaticTest.num);
	}
	/*
	 * �����еĽ�����Կ����õ��Ľ����200,300,300�� ��̬�����ֻ����һ�Σ����ԣ���st1�����Ľ����200,300.��st2���ټ��أ���ΪStaticTest.num��������300����ô���������Ľ������200,300,300
	 */
	
}
