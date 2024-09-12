
package day04;

public class TestException {

	public static void main(String[] args) {
		
		//1.数组下标越界的异常
		int[] i=new int[10];
		//i[0]=90;
		//i[10]=99;
		
		//for(int m=0;m<=i.length;m++){
		for(int m=0;m<i.length;m++){
			System.out.println(i[m]);
		}
		
		//2.空指针的异常
		//第一种
		boolean[] b=new boolean[3];
		//b=null;
		System.out.println(b[0]);
		
		//第二种
		String[] str=new String[4];
		System.out.println(str[3]);
		//System.out.println(str[3].toString());
		
		//第三种
		int[][] j=new int[3][];
		j[2][0]=12;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
