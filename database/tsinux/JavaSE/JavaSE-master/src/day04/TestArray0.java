package day04;

public class TestArray0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=12;
		boolean b=true;
		
		//定义数组
		String[] names;
		int[] scores;
		
		//静态初始化
		names=new String[]{"张三","李四","王五"};
		
		//动态初始化
		scores=new int[4];
		
		//调用相应的数组元素
		scores[0] = 87;
		scores[1] = 89;
		scores[3] = 98;
		
		//数组的长度  length
		System.out.println(names.length);
		System.out.println(scores.length);
		
		//遍历数组元素
		System.out.println(names[0]);
		
		for(int j=0;j<names.length;j++){
			System.out.println(names[j]);
		}
		
		
	}

}
