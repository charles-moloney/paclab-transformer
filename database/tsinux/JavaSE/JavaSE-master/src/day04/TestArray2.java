
package day04;

public class TestArray2 {

	public static void main(String[] args) {
		
		int[] scores1=new int[10];
		int[][] scores2;
		String[][] names;
		
		//静态初始化
		scores2=new int[][]{{1,2,3},{4,5,6},{11}};
		//动态初始化
		names=new String[6][5];
		names=new String[6][];
		names[0]=new String[5];
		
		//引用具体的元素
		int[][] i=new int[3][2];
		i[1][0]=90;
		i[2][1]=100;
		
		//数组的长度  length
		System.out.println(i.length);     //行
		System.out.println(i[0].length);  //列
		
		System.out.println(names.length);
		System.out.println(names[0].length);
		
		//遍历二维数组
		for(int m=0;m<scores2.length;m++){
			for(int n=0;n<scores2[m].length;n++){
				System.out.print(scores2[m][n]+"  ");
			}
			System.out.println();
		}
		
		int[] x,y[];
		//int[] x;//一维
		//int[] y[];//二维
		y=new int[3][2];
		x=y[0];
		x[0]=y[1][2];
		
		
		
		
	}

}
