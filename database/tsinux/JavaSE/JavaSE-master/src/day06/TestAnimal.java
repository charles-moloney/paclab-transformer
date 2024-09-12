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

/*
 * 权限修饰符  public private protected 缺省
 *     可以用来修饰属性，方法
 *    注意：(1)权限从大到小排列：public protected 缺省 private
 *    	  (2)修饰类的权限有： public 缺省
 *    
 */
public class TestAnimal {

	public static void main(String[] args) {
		Animal a1=new Animal();
//		a1.name="花花";
//		a1.legs=4;
		a1.setLegs(4);
		a1.setName("果果");
		
		a1.info();
		a1.eat();
		
//		a1.getLegs();
//		a1.getName();
		System.out.println(a1.getLegs());
		System.out.println(a1.getName());
	}
	
}

class Animal{
	
//	String name; //动物的姓名
//	int legs;  //腿的条数
	
	//private修饰的属性，只能在本类中被调用，出了此类，就不能被调用了
	private String name; //动物的姓名
	private int legs;  //腿的条数
	String color;
	
	public void eat(){
		System.out.println("动物进食");
	}
	
	public void sleep(){
		System.out.println("动物睡觉");
	}
	
	public void info(){
		System.out.println("name:"+name+"  legs:"+legs);
	}
	
	//设置类的属性
	public void setLegs(int l){
		if(l>0 && l%2==0){
			legs=l;
		}else{
			System.out.println("您输入的数据有误！");
		}
	}
	
	//获取类的属性
	public int getLegs(){
		return legs;
	}
	
//	public int doLegs(int l){
//		legs=l;
//		return legs;
//	}
//	
	public void setName(String n){
		name=n;
	}
	
	public String getName(){
		return name;
	}
	
}