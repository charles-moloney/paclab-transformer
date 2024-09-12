//问题一：从键盘读入个数为10个的整数，并判断读入的正数和负数的个数
//问题二：从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序
package day03;

import java.util.Scanner;

public class TestExer {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int a=0;//记录正数的个数
		int b=0;//记录负数的个数
		/* 问题一
		for(int i=0;i<10;i++){
			System.out.println("请输入第"+(i+1)+"个整数");
			int num=s.nextInt();
			if(num>0){
				a++;
			}else if(num<0){
				b++;
			}
		}
		*/
		
		//无限循环for(;;){}
		for(;;){
			System.out.println("请输入一个整数");
			int num= s.nextInt();
			if(num>0){
				a++;
			}else if(num<0){
				b++;
			}else{
				break;
			}
		}
		System.out.println("正数的个数为："+a);
		System.out.println("负数的个数为："+b);
		
		
		
	}

}
