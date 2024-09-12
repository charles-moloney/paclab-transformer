package day02;

import java.util.Scanner;

//从键盘上输入2014年的month和day，要求通过程序输出输入的日期为2014年的第几天
public class TestSwitch4 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("请输入月份;");
		int month = s.nextInt();
		System.out.println("请输入日期：");
		int day = s.nextInt();
		
		int sum= 0;
		switch(month){
			case 12:sum=sum+30;
			case 11:sum=sum+31;
			case 10:sum=sum+30;
			case 9:sum=sum+31;
			case 8:sum=sum+31;
			case 7:sum=sum+30;
			case 6:sum=sum+31;
			case 5:sum=sum+30;
			case 4:sum=sum+31;
			case 3:sum=sum+28;
			case 2:sum=sum+31;
			case 1:sum=sum+day;
			
		}
		
		
		
		System.out.println(sum);
	}

}
