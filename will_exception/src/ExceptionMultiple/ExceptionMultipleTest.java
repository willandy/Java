package ExceptionMultiple;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMultipleTest {

     public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		try{
			//�������еĴ��루���ܷ����쳣�Ĵ��룩
			System.out.println("�����뱻������");
			int num1 = in.nextInt();
			System.out.println("�����������");
			int num2 = in.nextInt();
			System.out.println(num1+"/"+num2+"="+num1/num2);
			System.out.println("��лʹ�ñ�����!");
		}catch(InputMismatchException e){
			//�������Ͳ�ƥ���쳣�������
			System.err.println("�������󣬳������߱���������Ϊ������");
			e.printStackTrace();
		}catch(ArithmeticException ex){
			//�����쳣�������
			System.err.println("�������󣬳�������Ϊ0��");
			ex.printStackTrace();
		}catch(Exception e){
			//�����쳣�������
			e.printStackTrace();
		}
	}
	
}
