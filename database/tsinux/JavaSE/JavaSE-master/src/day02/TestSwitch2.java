package day02;

public class TestSwitch2 {

	public static void main(String[] args) {

		String season = "Spring";
		
		switch(season){
			case "Spring":
				System.out.println("春天");
				break;
			case "Summer":
				System.out.println("夏天");
				break;
			case "Autumn":
				System.out.println("秋天");
				break;
			case "Winter":
				System.out.println("冬天");
				break;
			default:
				System.out.println("输入有误");
				break;
		}
		
	}

}
