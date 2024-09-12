/*
 *一个数如果恰好等于它的因子之和，这个数称为“完数”
 *例如  6=1+2+3
 *找出1000以内的所有完数
 */

package day03;

public class TestWanShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int factor=0;
		
		for(int i=1;i<=1000;i++){
			for(int j=1;j<i;j++){
				if(i%j==0){
					factor=factor+j;
				}
			}
			if(i==factor){
				System.out.println(i);
			}
			
			//初始化
			factor=0;
		}
		
	
	}

}
