package day05;


/*
 * 
 */
public class TestPerson1 {

	public static void main(String[] args) {
		Person1 p=new Person1();
		p.study();
		p.showAge();
		p.addAge(2);
		p.showAge();
		
		Person1 p1=new Person1();
		p1.showAge();
	}
}

class Person1{
	//属性
	String name;
	int age;
	int sex;
	
	//方法
	public void study(){
		System.out.println("studying");
	}
	public void showAge(){
		System.out.println(age);
		//打印调用showAge()方法的对象的age属性
	}
	//给调用此方法的对象的age属性增加i岁，并返回新的age
	public int addAge(int i){
		age+=i;
		return age;
	}
}