//输出所有的水仙花数，所谓水仙花数是指一个3位数，在各个位上数字立方和等于其本身。
//例如 ： 153=1*1*1 + 3*3*3 + 5*5*5
package day03;

public class ShuiXianHua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=100;i<1000;i++){
			int j1=i/100;//百位
			int j2=(i-j1*100)/10;//十位
			int j3=i%10;//个位
			
			if(i==j1*j1*j1 + j2*j2*j2 + j3*j3*j3){
				System.out.println(i);
			}
		}
	}

}
