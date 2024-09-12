//嵌套循环：循环中还可以声明循环
package day03;

public class TestForFor {

	public static void main(String[] args) {

		for(int i=0;i<5;i++){
			for(int j=0;j<5-i;j++){
				System.out.print(" ");
			}
			for(int k=0;k<i+1;k++){
				System.out.print("* ");
			}
			
			System.out.println();
		}
		
		for(int i=0;i<4;i++){
			for(int j=0;j<i+2;j++){
				System.out.print(" ");
			}
			for(int k=0;k<4-i;k++){
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}

}
