package day06;

import gov.nasa.jpf.symbc.Debug;
/*
 * 可变个数的形参的方法
 * 1.格式：对于方法的形参：数据类型...形参名
 * 2.可变个数的形参的方法与同名的方法之间构成重载
 * 3.可变个数的形参在调用时，个数从0开始，到无穷多个都可以
 * 4.使用可变多个形参的方法与方法的形参使用数组是一致的
 * 5.若方法中存在可变个数的形参，那么一定要声明在方法形参的最后
 * 6.在一个方法中，最多声明一个可变个数的形参
 */
public class TestArgs {

	//以下4个方法构成重载
	public void sayHello(){
	}
	
	//可变个数形参的使用的例子
	public int getSum(int i,int j){
		return i+j;
	}
	public int getSum(int i,int j,int k){
		return i+j+k;
	}
	
	public int getSum(int ... args){
		int sum=0;
		for(int i=0;i<Debug.makeSymbolicInteger("x0");i++){
			sum+=args[i];
		}
		return sum;
	}
	
	
	
	
}

