package day05;

/*
 * 类的属性（成员变量）
 * 成员变量 VS 局部变量
 * 不同点：
 * 1.声明位置不同：
 * 		成员变量：声明在类里，方法外
 * 		局部变量：声明在方法里，方法的形参部分
 * 2.成员变量的修饰符有四个：public，private，protected，缺省
 * 	 局部变量没有修饰符
 * 3.初始化值：一定会有初始化值
 * 	成员变量：如果在声明的时候，不显式的赋值，那么不同数据类型会有不同的默认初始化值
 * 		byte short int long  ==>0
 * 		float  double ==>0.0
 * 		char  ==>空格
 * 		boolean  ==>false
 *  	引用类型变量  ==>null
 * 	局部变量：一定要显式的赋值，局部变量没有默认初始化值
 * 4.二者在内存中存放的位置不同
 * 		成员变量存在于堆空间中
 * 		局部变量存在于栈空间中
 * 		
 */

/*
 * 类的方法：提供某种功能的实现
 * 1)实例：public void eat(){}
 * 		 public String getName(){}
 * 		 public void setName(String n){}
 * 	格式：权限修饰符  返回值类型(void 无返回值/具体的返回值) 方法名(形参){}
 * 
 * 2)关于返回值类型：
 * 		void表明此方法不需要返回值
 * 		有返回值的方法：在方法的最后一定有return + 返回值类型对应的变量
 * 	void 与return不能同时出现在一个方法中
 * 
 * 
 * 3)方法内可以调用本类的其他方法或属性，但是不能在方法内再定义方法
 * 	 
 * 
 * 
 */
public class Zoo {

	public static void main(String[] args) {
		//类的实例化
		Animal a1=new Animal();
		
		a1.name="玲玲";
		a1.age=10;
		System.out.println("name:"+a1.name+" age:"+a1.age);
		a1.eat();
		a1.sleep();
		System.out.println(a1.desc());
		
		System.out.println(a1.getName());
		a1.setName("花花");
		System.out.println(a1.getName());
		
		Animal a2=new Animal();
		System.out.println("name:"+a2.name+" age:"+a2.age);
		a2.eat();
		a2.name="紫紫";
		System.out.println("name:"+a1.name+" age:"+a1.age);
		System.out.println("name:"+a2.name+" age:"+a2.age);
		
		//a3与a1共用一个对象实体
		Animal a3=a1;
		System.out.println("name:"+a3.name+" age:"+a3.age);
		a3.name="维尼熊";
		System.out.println("name:"+a1.name+" age:"+a1.age);
		System.out.println("name:"+a3.name+" age:"+a3.age);
		
		System.out.println(a3.getName());
		
	}
}

class Animal{
	//属性
	String name;
	int age;
	
	//方法
	public void eat(){
		System.out.println("动物进食");
	}
	public void sleep(){
		System.out.println("动物休眠");
	}
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	public String desc(){
		if(age>18){
			return "恰同学少年";
		}else{
			return "还是看动画片的年龄";
		}
	}
	public void setName(String n){
		name=n;
	}
	
	//i 局部变量
	public void addAge(){
		int i=2;
		age+=i;
	}
	
	public void info(){
		eat();
		sleep();
	}
	
}