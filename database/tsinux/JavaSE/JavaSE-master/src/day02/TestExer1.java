package day02;

public class TestExer1 {

	public static void main(String[] args) {
		int m=12;
		int n=5;
		System.out.println("m:"+m+"n:"+n);
		
		/**
		//方法一：提供一个临时变量
		int temp=m;
		m=n;
		n=temp;
		System.out.println("m:"+m+"n:"+n);
		*/
		
		/**
		//方法二：当m和n较大时，有可能出现精度损失
		m=m+n;
		n=m-n;
		m=m-n;
		System.out.println("m:"+m+"n:"+n);
		*/
		
		//方法三:位运算符
		m=m^n;
		n=m^n;//(m^n)^n==m
		m=m^n;//(m^n)^m==n
		System.out.println("m:"+m+"n:"+n);
		
		
		
	}
	

}
