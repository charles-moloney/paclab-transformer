package day06;
/*
 * 方法的参数传递
 * 1.形参：方法声明时，方法小括号内的参数
 * 	   实参：调用方法时，实际传入的参数的值
 * 2.规则：Java中的参数传递机制:值传递机制
 * 		1)形参是基本数据类型的：将实参的值传递给形参的基本数据类型的变量
 * 		2)形参是引用数据类型的:将实参的引用类型变量的值（对应的堆空间的对象实体的首地址值）传递给形参的引用类型变量
 * 
 * 
 * 
 */
public class TestArgsTransfer {

	public static void main(String[] args) {
		TestArgsTransfer tt=new TestArgsTransfer();
		
		int i=10;
		int j=5;
		System.out.println("i:"+i+"  j:"+j);
		
		//交换变量的值
//		int temp=i;
//		i=j;
//		j=temp;
//		System.out.println("i:"+i+"  j:"+j);
		
		tt.swap(i, j);
		System.out.println("i:"+i+"  j:"+j);
	}
	
	//定义一个方法，交换两个变量的值
	public void swap(int i,int j){
		int temp=i;
		i=j;
		j=temp;
		System.out.println("i:"+i+"  j:"+j);
	}
	
	
}
