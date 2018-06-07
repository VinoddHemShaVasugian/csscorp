package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		String s="testsaa";
//		Pattern p = Pattern.compile(".s");
//		Matcher m = p.matcher(s);
//		boolean result=m.matches();
//		System.out.println(result);
		
		boolean res=Pattern.compile("....s..").matcher(s).matches();
		System.out.println(res);
		boolean storeValue = Pattern.matches(".s", "as");
		System.out.println("storeValue: "+storeValue);
	}
}
