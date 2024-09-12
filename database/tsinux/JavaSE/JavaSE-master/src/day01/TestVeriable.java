package day01;

public class TestVeriable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myInt1=10;
		double d1=12.4;
		
		System.out.println(myInt1);
		System.out.println(myInt1 + d1);
		//System.out.println(i1);
		
		byte b1=12;
		//byte b2=128;
		short s1=128;
		int i1=12;
		long l1=21341235L;
		System.out.println(l1);
		
		double d2=12.3;
		float f1=12.3f;
		System.out.println(f1);
		
		char c1='a';
		//char c2='ab';
		String str="ab";
		char c3='中';
		String str1="中国";
		
		//可以表示转义字符
		char c4='\t';
		char c5='\n';
		System.out.println("abc"+c5+"def");
		
		char c6='\u1234';
		System.out.println(c6);
		
		boolean bool1=true;
		if(bool1){
			System.out.println("我们");
		}else{
			System.out.println("你们");
		}
		
		
	}
	
	public void method1(){
		int i1=10;
		System.out.println(i1);
	}

}
