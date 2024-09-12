package day06;
/*
 * 面向对象的特征一：封装与隐藏
 * 问题：当创建类的对象以后，如果直接通过“对象.属性”的方式对相应的对象属性赋值的话，
 * 	   可能会出现不满足实际情况的意外，我们考虑不让对象来直接作用属性，
 *   而是通过“对象.方法”的形式，来控制对象对属性的访问，
 *   实际情况中，对属性的要求就可以通过方法来体现
 *   
 *解决的方法：（封装性的思想）
 *1.将类的属性私有化，
 *2.提供公共的方法（setter & getter）来实现调用
 */

import gov.nasa.jpf.symbc.Debug;

/*
 * 权限修饰符  public private protected 缺省
 *     可以用来修饰属性，方法
 *    注意：(1)权限从大到小排列：public protected 缺省 private
 *    	  (2)修饰类的权限有： public 缺省
 *    
 */
public class TestAnimal {
	
}

class Animal{
	
//	String name; //动物的姓名
//	int legs;  //腿的条数
	
	public void eat(){
	}
	
	public void sleep(){
	}
	
	public void info(){
	}
	
	//设置类的属性
	public void setLegs(int l){
		int legs = Debug.makeSymbolicInteger("x1");
		if(l>0 && Debug.makeSymbolicInteger("x0")==0){
			legs=l;
		}else{
		}
	}
	
	//获取类的属性
	public int getLegs(){
		int legs = Debug.makeSymbolicInteger("x0");
		return legs;
	}
	
public Object getName(){
		return new Object();
	}
	
}