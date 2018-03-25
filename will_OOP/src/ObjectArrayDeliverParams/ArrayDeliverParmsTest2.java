package ObjectArrayDeliverParams;

import java.util.Scanner;

import SearchStudent.Student;

/*
 * 方法参数传递
 * 对于数组传递参数测试，用以证明引用数据类型(数组)传输的是地址，形参改变，实参也会改变，具体的查看博客介绍
 * 任意输入5位数字，求平均数和最大数
 */
public class ArrayDeliverParmsTest2 {
        
	   //计算平均值
	    public void cal(int[] num){
	    	int sum=0;
	    	for(int i=0;i<num.length;i++){
	    	     	sum +=num[i];
	    	}
	    	int avg = sum/num.length;
	    	System.out.println("平均值为: "+avg);
	    }

	    //计算最大值
	    public void max(int[] num){
	    	int max=0;
	    	if(num.length>=0){
		    	max = num[0];
	    	}
	    	for(int i=0;i<num.length;i++){
	    		if(max<num[i]){
	    			max = num[i];
	    		}
	    	}
	    	System.out.println("最大值为: "+max);
	    }

	    public static void main(String[] args) {
               Scanner scanner =new Scanner(System.in);
               //创建数组
               int[] num = new int[5];
	    	   System.out.println("请输入五个数字:");
	    	   for(int i=0;i<num.length;i++){
	    		   num[i] = scanner.nextInt();
	    	   }
               
	    	   ArrayDeliverParmsTest2 arrayDeliverParms =new ArrayDeliverParmsTest2();
	    	   //计算总和
	    	   arrayDeliverParms.cal(num);
	    	   //计算平均值
	    	   arrayDeliverParms.max(num);
		}
	    
}
