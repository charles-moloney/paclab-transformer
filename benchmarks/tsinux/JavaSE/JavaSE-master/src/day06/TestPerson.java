package day06;

import gov.nasa.jpf.symbc.Debug;


/*
 * 创建程序，在其中定义两个类：Person和TestPerson类。
 * 定义如下：
 * 用setAge()设置人的合法年龄(0~130),用getAge()返回人的年龄
 * 在TestPerson类中实例化Person类的对象b，调用setAge()和getAge()方法
 * 体会java的封装性
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
			//System.out.println("您输入的数据有误！");
			//抛出异常
			throw new RuntimeException("您输入的数据有误！");
		}
	}
	
	public Object getName(){
		return new Object();
	}
	
	
}