package regex;

import java.util.regex.Pattern;

public class Regex_Metacharacters {

	public static void main(String[] args) {
		String s="abc";
		System.out.println(Pattern.matches("\\d", "abc"));
		System.out.println(Pattern.matches("\\d*", "abc"));
		System.out.println(Pattern.matches("\\d", "1"));
		System.out.println(Pattern.matches("\\d*", "1"));
		System.out.println(Pattern.matches("\\d", "4443"));
		System.out.println(Pattern.matches("\\d*", "4443"));
		System.out.println(Pattern.matches("\\d", "323abc"));
		System.out.println(Pattern.matches("\\d*", "323abc"));
		System.out.println("---------------------------------");
		System.out.println(Pattern.matches("\\D", "abc"));
		System.out.println(Pattern.matches("\\D*", "abc"));
		System.out.println(Pattern.matches("\\D", "a"));
		System.out.println(Pattern.matches("\\D*", "a"));
		System.out.println(Pattern.matches("\\D", "4443"));
		System.out.println(Pattern.matches("\\D*", "4443"));
		System.out.println(Pattern.matches("\\D", "323abc"));
		System.out.println(Pattern.matches("\\D*", "323abc"));
	}
}