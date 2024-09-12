package day05;

import gov.nasa.jpf.symbc.Debug;


/*
 * 
 */
public class TestPerson1 {
}

class Person1{
	//方法
	public void study(){
	}
	public void showAge(){
	}
	//给调用此方法的对象的age属性增加i岁，并返回新的age
	public int addAge(int i){
		int age = Debug.makeSymbolicInteger("x0");
		age+=i;
		return age;
	}
}