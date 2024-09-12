/*
 * 100以内的所有质数
 */

package day03;

public class TestPrimeNum1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//获取系统当前运行的毫秒数
		long start = System.currentTimeMillis();
		
		//boolean flag=false;
		
		label:for(int i=2;i<=100000;i++){
			//for(int j=2;j<i;j++){
			//改成平方根
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					//flag=true;
					//注意逻辑，加个break，节省大量时间
					//break;
					continue label;
				}
			}
			System.out.println(i+"  是质数");
			/*
				if(flag==false){
					System.out.println(i+"  是质数");
				}
				//注意重置flag的值
				flag=false;
			*/
		}
		
		//再次获取系统当前运行的毫秒数
		long end=System.currentTimeMillis();
		System.out.println("所有花费的时间为："+(end-start));
	}

}
