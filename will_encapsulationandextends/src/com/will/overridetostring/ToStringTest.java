package com.will.overridetostring;

/*
 * �жϲ�����toString����
 */
public class ToStringTest {

	public static void main(String[] args) {
		//����һ��student1ʵ��
		Student s1 = new Student("Jack",2010,12);
		//����һ��student2ʵ��
		Student s2 = new Student("Jack",2010,12);
		//��Ϊÿ��new����ͱ�ʾ�ڶ����½���һ�����󣬾�����������ͬ�Ķ��󣬵���ʵ������û����дobject��equals��ʱ����������ͬ�Ķ���
		//System.out.println(s1.equals(s2)); //������equals����Ϊÿ���඼�̳���object���࣬object����equals����
		
		//����Student����д��toString�������ٲ����½���student�Ƿ�һ��
		boolean flag=s1.equals(s2);
		System.out.println(flag);
		//==�Աȵ�Ҳ������������ڴ��ַ
		System.out.println(s1.getAge()==s2.getAge());
		
	}
	
}
