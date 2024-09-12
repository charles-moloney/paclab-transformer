package day05;
/*
 * 
 */
public class TestCircle {

	public static void main(String[] args) {
		Circle c1=new Circle();
		c1.radius=2.3;
		//c1.findArea();
		System.out.println(c1.findArea());
		
		//c1.radius=4.5;
		c1.setRadius(4.5);
		System.out.println(c1.findArea());
	}
}

class Circle{
	double radius=1.0;
	
	//方法
	/*
	public void findArea(){
		System.out.println(3.14*radius*radius);
	}
	*/
	public double findArea(){
		return 3.14*radius*radius;
	}
	
	//返回圆的半径
	public double getRadius(){
		return radius;
	}
	
	//设置圆的半径
	public void setRadius(double r){
		radius=r;
	}
	
	
}