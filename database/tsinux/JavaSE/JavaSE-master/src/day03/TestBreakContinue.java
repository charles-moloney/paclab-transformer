/*
 *break:使用在switch-case中或者循环中
 *		如果使用在循环中，表示结束当前循环
 *
 *continue:使用在循环结构中
 *			表示为结束当次循环
 *
 *在break和continue之后不能添加其他语句，不能被执行
 */

package day03;

public class TestBreakContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1;i<=10;i++){
			if(i%4==0){
				//break;
				continue;
			}
			System.out.println(i);
		}
		
		//标签label
		label:for(int i=1;i<5;i++){
			for(int j=1;j<=10;j++){
				if(j%4==0){
					//break;
					//continue;
					
					//break label;
					continue label;
					
				}
				System.out.print(j);
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
