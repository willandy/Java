package com.will.statictest;
/*
 * һȺѡ�����ͶƱ��ÿ����ֻ����Ͷһ��Ʊ�����ҵ�ͶƱ�ﵽ100ʱ��ֹͣͶƱ
 */
public class VectorStaticTest {
	
	//ѡ��ĸ���
	public static String vectorName;
	//ͶƱ����
	public static int count;
	//����ѡƱ�������
	public static final int MaxVectorNUm = 100;
	
	//�յĹ��췽��
	public VectorStaticTest(){}
	
	//���أ��������Ĺ��췽��
	public VectorStaticTest(String vectorName){
		this.vectorName = vectorName;
	}
	
	//ѡƱ���ӷ���
	/*
	 * params:vectorName
	 */
	public void addVertor(){
		if(count > MaxVectorNUm){
			System.out.println("ͶƱ�Ѿ�������");
			return;
		}else{
			count++;
			System.out.println("ллͶƱ��");
		}
	}
	
	//����ͶƱ����
	public void vectorNum(){
		System.out.println("��ǰ��ͶƱ����Ϊ :"+count);
		System.out.println(vectorName);
	}

	//��������
	public static void main(String[] args){
		VectorStaticTest v = new VectorStaticTest();
		v.vectorNum();
		//���������ݽ�����
		VectorStaticTest v1 = new VectorStaticTest("���»�");
		v1.addVertor();
		VectorStaticTest v2 = new VectorStaticTest("��ѧ��");
		v2.addVertor();
		//ѭ����������
		for(int i=0;i<=100;i++){
			VectorStaticTest v3 = new VectorStaticTest("v"+i);
			v3.addVertor();
		}
		
	}
	
}
