package com.will.override;

/*
 * ��д�����Ĳ���
 */
class Base {

	//��ͨ����
	public void method1(){
		System.out.println("�������ͨ����method1");
	}
	//���ظ�������
	public Base method2(){
		System.out.println("�������ͨ����method2");
		return new Base();
	}
	//���ྲ̬����
	public static void method3(){
		System.out.println("����ľ�̬����method3");
	}
	//����˽�з���
	private void method4(){
		System.out.println("�����˽�з���mehod4");
	}
	
}

/*
 * �̳�Base�࣬Ȼ����дBase������ķ���
 */
class Sub extends Base{
	//��д������ͨmethod1�ķ���
	public void method1(){
		System.out.println("�������ͨ����method1");
	}
	
	//��д�����method2�����������������ͣ�Ҳ����д
	public Sub method2(){
		return new Sub();  //����һ���������б�һ��������ֵ�����࣬Ҳ����д
	}
	
	//��̬����������д��ͬʱ����ȥ��static����������Ǿ�̬�����Ͳ��ܱ����า��Ϊ�Ǿ�̬��������������ǷǾ�̬�������ܱ����า��Ϊ��̬����
	public static void method3(){
		System.out.println("����ľ�̬����method3");
	}
	//˽�з����޷��̳У����޷���д
	private void method4(){
		System.out.println("�����˽�з���mehod4");
	}
	
}











