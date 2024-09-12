package day03;

public class TestFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		
		System.out.println();
		
		for(int i=0;i<4;i++){
			System.out.println("HelloWorld");
		}
		
		int j=1;
		for(System.out.println('a');j<4;System.out.println('b'),j++){
			System.out.println('c');
		}
		
		//输出100以内的所有偶数
		//所有偶数的和
		//偶数的个数
		int sum=0;
		int count=0;
		for(int k=0;k<=100;k++){
			if(k%2==0){
				System.out.println(k);
				sum=sum+k;
				count++;
			}
		}
		System.out.println("总和为："+sum);
		System.out.println("100以内偶数的个数为："+count);
	}

}
