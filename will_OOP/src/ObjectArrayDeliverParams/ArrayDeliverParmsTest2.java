package ObjectArrayDeliverParams;

import java.util.Scanner;

import SearchStudent.Student;

/*
 * ������������
 * �������鴫�ݲ������ԣ�����֤��������������(����)������ǵ�ַ���βθı䣬ʵ��Ҳ��ı䣬����Ĳ鿴���ͽ���
 * ��������5λ���֣���ƽ�����������
 */
public class ArrayDeliverParmsTest2 {
        
	   //����ƽ��ֵ
	    public void cal(int[] num){
	    	int sum=0;
	    	for(int i=0;i<num.length;i++){
	    	     	sum +=num[i];
	    	}
	    	int avg = sum/num.length;
	    	System.out.println("ƽ��ֵΪ: "+avg);
	    }

	    //�������ֵ
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
	    	System.out.println("���ֵΪ: "+max);
	    }

	    public static void main(String[] args) {
               Scanner scanner =new Scanner(System.in);
               //��������
               int[] num = new int[5];
	    	   System.out.println("�������������:");
	    	   for(int i=0;i<num.length;i++){
	    		   num[i] = scanner.nextInt();
	    	   }
               
	    	   ArrayDeliverParmsTest2 arrayDeliverParms =new ArrayDeliverParmsTest2();
	    	   //�����ܺ�
	    	   arrayDeliverParms.cal(num);
	    	   //����ƽ��ֵ
	    	   arrayDeliverParms.max(num);
		}
	    
}
