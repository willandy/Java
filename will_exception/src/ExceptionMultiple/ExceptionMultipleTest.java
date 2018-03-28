package ExceptionMultiple;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMultipleTest {

     public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		try{
			//尝试运行的代码（可能发生异常的代码）
			System.out.println("请输入被除数：");
			int num1 = in.nextInt();
			System.out.println("请输入除数：");
			int num2 = in.nextInt();
			System.out.println(num1+"/"+num2+"="+num1/num2);
			System.out.println("感谢使用本程序!");
		}catch(InputMismatchException e){
			//数据类型不匹配异常处理代码
			System.err.println("输入有误，除数或者被除数必须为整数！");
			e.printStackTrace();
		}catch(ArithmeticException ex){
			//算数异常处理代码
			System.err.println("输入有误，除数不能为0！");
			ex.printStackTrace();
		}catch(Exception e){
			//其他异常处理代码
			e.printStackTrace();
		}
	}
	
}
