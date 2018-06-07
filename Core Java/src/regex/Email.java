package regex;

import java.util.regex.Pattern;

public class Email {

	public static void main(String[] args) {
		String email="Vinoth123@gmail.com";
		for(int i=0;i<=email.length();i++){
			char s=email.charAt(i);
			
			if(Pattern.matches("\\d", s)){
				System.out.println("its digit");
			}
			if(Pattern.matches(".", s)){
				System.out.println("its special character");
			}
			if(Pattern.matches("\\D", s)){
				System.out.println("its non-digit");
			}
		}

	}

}
