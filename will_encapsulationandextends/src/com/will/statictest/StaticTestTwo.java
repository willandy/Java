package com.will.statictest;

/*
 * author:will
 * �������Ծ�̬����
 */
public class StaticTestTwo {
     static int num;//����֮����Ҫ�þ�̬����������Ϊ��̬�����޷����÷Ǿ�̬�����ͷǾ�̬����
     
     /*
      * ���н����4�������֤���˾�̬�������ڴ���ֻ��һ��copy���������½����ٸ����󣬲�����ʼ����ͬһ������
      * static���������ã�
        ���ܱ��������ʵ����������Ϊʵ��֮����н����Ĺ�������
        ������������ʵ��������һ����ͬ�ĳ������ԣ��ɰ�������Զ���Ϊ��̬�������ͣ��Ӷ���ʡ�ڴ�ռ�

      */
     public static void main(String[] args) {
		num++;
		//������һ��StaticTestTwoʵ�壬�������侲̬��������1
		StaticTestTwo s1 = new StaticTestTwo();
		s1.num++;
		//�����ڶ���StaticTestTwoʵ�壬�������侲̬��������1
		StaticTestTwo s2 = new StaticTestTwo();
		s2.num++;
		StaticTestTwo.num++;
		System.out.println(num);
	}
	
	
}
