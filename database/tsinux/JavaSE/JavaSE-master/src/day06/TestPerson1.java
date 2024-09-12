package day06;

/*
 * 类的第三个成员：构造器（constructor 构造方法）
 * 构造器的作用：
 * 1.创建对象
 * 2.给创建的对象的属性赋值
 * 
 * 注意
 * 1.设置类时，若不显式声明类的构造器的话，程序会默认提供一个空参的构造器
 * 2.一旦显式的定义类的构造器，那么默认的构造器就不再提供
 * 3.如何声明类的构造器，格式： 权限修饰符   类名(形参){}
 * 4.类的多个构造器之间构成重载
 */
/*
 * 类对象的属性赋值的先后顺序：
 * 1.属性的默认初始化
 * 2.属性的显式初始化
 * 3.通过构造器给属性初始化
 * 4.通过"对象.方法"的方式给属性赋值
 * 
 */

public class TestPerson1 {
	public static void main(String[] args) {
		Person1 p1=new Person1();
		String str=new String("tsinux.com");
		System.out.println(str);
		
		Person1 p2=new Person1("松子");
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		
		Person1 p3=new Person1("梨子",23);
		System.out.println("name:"+p3.getName()+"  age:"+p3.getAge());
		
		//体会属性赋值的过程
		Person1 p4=new Person1();
		System.out.println("name:"+p4.getName()+"  age:"+p4.getAge());
		
		Person1 p5=new Person1(12);
		System.out.println("name:"+p5.getName()+"  age:"+p5.getAge());
	}
}

class Person1{
	//属性
	private String name;
	private int age=1;
	
	//构造器   构成重载
	public Person1(){
		
	}
	public Person1(String n){
		name=n;
	}
	
	public Person1(int a){
		age=a;
	}
	
	public Person1(String n,int a){
		name=n;
		age=a;
	}
	
	//方法
	public void setName(String n){
		name = n;
	}
	
	public void setAge(int a){
		age=a;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	
}