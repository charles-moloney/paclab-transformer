package day02;

import java.util.Scanner;

public class TestIf3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		System.out.println("请输入第一个整数");
		int num1=s.nextInt();
		System.out.println("请输入第二个整数");
		int num2=s.nextInt();
		System.out.println("请输入第三个整数");
		int num3=s.nextInt();
		
		System.out.println("从小到大的排序为：");
		if(num1>num2){
			if(num3>num1){
				System.out.println(num2+","+num1+","+num3);
			}else if(num3<num2){
				System.out.println(num3+","+num2+","+num1);
			}else{
				System.out.println(num2+","+num3+","+num1);
			}
		}else{
			if(num3>num2){
				System.out.println(num1+","+num2+","+num3);
			}else if(num3<num1){
				System.out.println(num3+","+num1+","+num2);
			}else{
				System.out.println(num1+","+num3+","+num2);
			}
		}
		
		
	}

}
