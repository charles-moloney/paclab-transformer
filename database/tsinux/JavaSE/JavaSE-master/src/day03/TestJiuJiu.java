/*
 *   1*1=1
 *   2*1=2  2*2=4
 *   ...
 *   9*1=9  9*2=18  9*3=27...9*9=81
 */

package day03;

public class TestJiuJiu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println();
		}
	
	}

}
