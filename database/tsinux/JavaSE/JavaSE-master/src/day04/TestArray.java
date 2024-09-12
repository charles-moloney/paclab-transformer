package day04;

public class TestArray {

	public static void main(String[] args) {
		
		//引用类型的变量构成的数组，默认初始化值为null
		String[] strs = new String[4];
		strs[0] = "AA";
		strs[1] = "BB";
		//strs[2] = "CC";  //null
		strs[3] = "DD";
		
		for(int i=0;i<strs.length;i++){
			System.out.println(strs[i]);
		}
		
		//byte,short,int,long  创建数组默认值为0
		int[] scores = new int[4];
		scores[0]=89;
		scores[3]=90;
		for(int i=0;i<scores.length;i++){
			System.out.println(scores[i]);
		}
		
		//float,double 创建数组默认值为0.0
		float[] f=new float[3];
		f[0]=1.2F;
		for(int i=0;i<f.length;i++){
			System.out.println(f[i]);
		}
		
		//char 创建数组默认值为空格
		char[] c=new char[3];
		for(int i=0;i<c.length;i++){
			System.out.println(c[i]);
		}
		
		//boolean 创建数组默认值为false
		boolean[] b= new boolean[3];
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
		
		//class引用类型  null
		Person[] pers=new Person[3];
		for(int i=0;i<pers.length;i++){
			System.out.println(pers[i]);
		}
		
		int[] myInt= new int[]{1,2,3};
		int[] myInt1={1,2,3};
		
		
		
		
	}
}


class Person{
	
}