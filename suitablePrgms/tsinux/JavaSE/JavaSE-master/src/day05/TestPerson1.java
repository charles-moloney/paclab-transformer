package day05;

import gov.nasa.jpf.symbc.Debug;


/*
 * 
 */
public class TestPerson1 {
}

class Person1{
	//����
	public void study(){
	}
	public void showAge(){
	}
	//�����ô˷����Ķ����age��������i�꣬�������µ�age
	public int addAge(int i){
		int age = Debug.makeSymbolicInteger("x0");
		age+=i;
		return age;
	}
}