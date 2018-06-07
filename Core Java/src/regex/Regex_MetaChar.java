package regex;

import java.util.regex.Pattern;

public class Regex_MetaChar {

	public static void main(String[] args) {
		String s="test";
		if(Pattern.matches("\\d", s)){
			System.out.println("its digit");
		}
		if(Pattern.matches(".", s)){
			System.out.println("its special character");
		}
		if(Pattern.matches("\\D", s)){
			System.out.println("its non-digit");
		}
		if(Pattern.matches("\\s", s)){
			System.out.println("its whitespace character");
		}
		if(Pattern.matches("\\S", s)){
			System.out.println("its non-whitespace character");
		}
		if(Pattern.matches("\\w", s)){
			System.out.println("its word character");
		}
		if(Pattern.matches("\\W", s)){
			System.out.println("its non-word character");
		}
		if(Pattern.matches("\\b", s)){
			System.out.println("its word boundary");
		}
		if(Pattern.matches("\\B", s)){
			System.out.println("its non-word boundary");
		}
	}
}