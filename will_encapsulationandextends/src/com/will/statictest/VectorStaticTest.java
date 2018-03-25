package com.will.statictest;
/*
 * 一群选民进行投票，每个人只允许投一次票，并且当投票达到100时，停止投票
 */
public class VectorStaticTest {
	
	//选民的个数
	public static String vectorName;
	//投票总数
	public static int count;
	//设置选票的最大数
	public static final int MaxVectorNUm = 100;
	
	//空的构造方法
	public VectorStaticTest(){}
	
	//重载，带参数的构造方法
	public VectorStaticTest(String vectorName){
		this.vectorName = vectorName;
	}
	
	//选票增加方法
	/*
	 * params:vectorName
	 */
	public void addVertor(){
		if(count > MaxVectorNUm){
			System.out.println("投票已经结束！");
			return;
		}else{
			count++;
			System.out.println("谢谢投票！");
		}
	}
	
	//计算投票总数
	public void vectorNum(){
		System.out.println("当前的投票总数为 :"+count);
		System.out.println(vectorName);
	}

	//测试数据
	public static void main(String[] args){
		VectorStaticTest v = new VectorStaticTest();
		v.vectorNum();
		//先两条数据进类里
		VectorStaticTest v1 = new VectorStaticTest("刘德华");
		v1.addVertor();
		VectorStaticTest v2 = new VectorStaticTest("张学友");
		v2.addVertor();
		//循环插入数据
		for(int i=0;i<=100;i++){
			VectorStaticTest v3 = new VectorStaticTest("v"+i);
			v3.addVertor();
		}
		
	}
	
}
