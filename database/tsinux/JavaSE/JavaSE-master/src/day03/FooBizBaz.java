//编写程序FooBizBaz.java,从1循环到150并在每一行打印一个值
//并在每个3的倍数行上打印出“foo”，在每个5的倍数行上打印“biz”，在每个7的倍数行上打印“baz”
package day03;

public class FooBizBaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1;i<=150;i++){
			System.out.print(i+" ");
			
			if(i%3==0){
				System.out.print("foo  ");
			}
			
			if(i%5==0){
				System.out.print("biz  ");
			}
			
			if(i%7==0){
				System.out.print("baz  ");
			}
			System.out.println();
		}
	}

}
