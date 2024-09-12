//数组一旦初始化，其长度是不可变的
package day04;

public class TestArray1 {

	public static void main(String[] args) {
		
		int[] i=new int[]{1,2,3};
		
		int[] j=new int[10];
		
		for(int k=0;k<i.length;k++){
			j[k]=i[k];
		}
		
		j[3]=15;
		j[4]=16;
		
		for(int k=0;k<j.length;k++){
			System.out.println(j[k]);
		}
		
	}

}
