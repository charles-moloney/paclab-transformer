package day05;
/*
 * 
 */
public class TestOverLoad1 {

	public static void main(String[] args) {
		TestOverLoad1 t=new TestOverLoad1();
		t.mOL(12);
		t.mOL("www.tsinux.com");
		t.mOL(1, 2);
		
		System.out.println(t.max(12, 13));
		System.out.println(t.max(12.1, 13.4));
		System.out.println(t.max(12.1, 13.4,19.5));
	}
	
	//以下三个方法构成重载
	public int max(int i,int j){
		return (i>j)?i:j;
	}
	
	public double max(double d1,double d2){
		return (d1>d2)?d1:d2;
	}
	
	public double max(double d1,double d2,double d3){
		return (max(d1,d2)>d3)?max(d1,d2):d3;
	}
	
	//以下三个方法构成重载
	public void mOL(int i){
		System.out.println(i*i);
	}
	
	public void mOL(int i,int j){
		System.out.println(i*j);
	}

	public void mOL(String str){
		System.out.println(str);
	}

}

