package day02;

public class TestSanYuan {

	public static void main(String[] args) {
		
		//三元运算符
		int i=10;
		int j=20;
		
		int max=(i>j)?i:j;
		System.out.println(max);
		
		String str=(i>j)?"i大":"j大";
		System.out.println(str);
		
		
		
		int m=60;
		String binary=Integer.toBinaryString(m);
		System.out.println(binary);
		
		String hex=Integer.toHexString(m);
		System.out.println(hex);
		
		
		
		
		
	}
	

}
