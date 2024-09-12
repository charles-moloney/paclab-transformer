package day04;

public class TestPritimive {

	public static void main(String[] args) {
		Pritimive d=new Pritimive();
		for(int i=0;i<d.t.length;i++){	
			System.out.println(d.t[i]);
		}
	}
}


class Pritimive{
	boolean[] t=new boolean[3];
}