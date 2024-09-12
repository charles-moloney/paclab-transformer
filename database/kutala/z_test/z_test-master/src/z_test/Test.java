package z_test;

import java.util.Arrays;
import java.util.List;

public class Test {

	private static final String DATE_PATTERN = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
	public static void main(String[] args) {
	        System.out.println("年月日的日期格式验证");
	 
	        List<String> dateCandidates = Arrays.asList("2015-01-11", "2015-4-31",
	                "2015-13-01", "2015-12-35");
	        for (String dateCandidate : dateCandidates) {
	            System.out.println(dateCandidate
	                    + (dateCandidate.matches(DATE_PATTERN) ? "格式正确" : "格式错误"));
	        }
	    }
}
