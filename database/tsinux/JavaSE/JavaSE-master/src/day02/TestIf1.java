package day02;

public class TestIf1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int age=28;
		if(age>18){
			System.out.println("成年人");
		}else{
			System.out.println("未成年人");
		}
		
		if(age>200 || age<0){
			System.out.println("你估计不是人");
		}else if(age<30){
			System.out.println("年轻");
		}else{
			System.out.println("老了");
		}
		
		
		
		
	}

}
