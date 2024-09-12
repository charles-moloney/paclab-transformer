package day01;

public class TestVeriable1 {

	public static void main(String[] args) {
		//自动类型转换
		int i1=12;
		short s1=2;
		int i2= i1 + s1;
		
		float f1=12.3f;
		float f2= f1 + i2;
		double d1=f2 + 12.3;
		
		System.out.println(i2);
		System.out.println(f2);
		System.out.println(d1);
		
		char c1='a';//97
		int i3=c1+1;
		System.out.println(i3);
		
		short ss1=12;
		byte bb1=1;
		char cc1='a';
		//short ss2=ss1+bb1;
		int ii1=ss1+bb1;
		//char cc2=cc1+bb1;
		int ii2=cc1+bb1;
		short ss2=11;
		//short ss3=ss1+ss2;
		
		
		
		//强制类型转换
		long l1=12345l;
		int m1=(int)l1;
		System.out.println(m1);
		
		byte by1=(byte)m1;
		System.out.println(by1);
		
		String nation="我是中国人";
		System.out.println(nation);
		
		String str="abc";
		String str1=str+m1;	
		System.out.println(str1);
		
		String st1="hello";
		int myInt1=12;
		char ch1='a';
		System.out.println(st1+myInt1+ch1);
		System.out.println(myInt1+ch1+st1);
		System.out.println(ch1+st1+myInt1);
		
		System.out.println("hello!"+3+4);
		
	}
	

}
