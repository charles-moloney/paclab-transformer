package day05;

import java.util.Scanner;

/*
 * 关于变量的分类:
 * 1)按照数据类型的不同：基本数据类型（8种）& 引用数据类型
 * 2)按照声明的位置的不同 ：成员变量  & 局部变量
 */
public class TestPerson {

	public static void main(String[] args) {

		//类的实例化
		Person p1=new Person();
		p1.info();
		
		p1.name="松子";
		p1.age=23;
		p1.sex=true;
		p1.info();
		
		p1.setName("棋子");
		System.out.println(p1.getName());
		p1.info();
		
		Person p2=p1;
		System.out.println("p1:"+p1);
		System.out.println("p2:"+p2);
		p2.info();
		
		p2=new Person();
		System.out.println("p2:"+p2);
		p2.info();
		
		//实例化Scanner类的对象，通过此对象.nextInt()调用，完成相应的功能
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		
		Person p3=new Person();
		p3.info();
		
		
	}
}

class Person{
	//属性
	String name;
	int age=10;
	boolean sex;
	
	//方法
	public void eat(){
		System.out.println("人吃饭");
	}
	public void sleep(){
		System.out.println("人睡觉");
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public void info(){
		eat();
		sleep();
		System.out.println("name:"+name+" age:"+age+" sex:"+sex);
	}
	
	
	
}
