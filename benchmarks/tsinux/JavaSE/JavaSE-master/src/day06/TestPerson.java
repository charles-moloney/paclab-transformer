package day06;

import gov.nasa.jpf.symbc.Debug;


/*
 * �������������ж��������ࣺPerson��TestPerson�ࡣ
 * �������£�
 * ��setAge()�����˵ĺϷ�����(0~130),��getAge()�����˵�����
 * ��TestPerson����ʵ����Person��Ķ���b������setAge()��getAge()����
 * ���java�ķ�װ��
 */


public class TestPerson {
	
}

class Person{
	public int getAge(){
		int age = Debug.makeSymbolicInteger("x0");
		return age;
	}
	
	public void setAge(int a){
		int age = Debug.makeSymbolicInteger("x0");
		if(a>0 && a<=130){
			age=a;
		}else{
			//System.out.println("���������������");
			//�׳��쳣
			throw new RuntimeException("���������������");
		}
	}
	
	public Object getName(){
		return new Object();
	}
	
	
}