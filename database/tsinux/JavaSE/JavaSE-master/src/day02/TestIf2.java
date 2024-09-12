package day02;

import java.util.Scanner;

public class TestIf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		System.out.println("请输入小明的期末成绩：");
		int score =s.nextInt();
		if(score>100 || score <0){
			System.out.println("您输入的有误");
		}else{
			if(score == 100){
				System.out.println("奖励一辆BMW");
			}else if(score >80 && score<=99){
				System.out.println("奖励一台IPHONE");
			}else if(score >60 && score<=80){
				System.out.println("奖励一本书");
			}else{
				System.out.println("什么都没有");
			}
		}
		
	}

}
