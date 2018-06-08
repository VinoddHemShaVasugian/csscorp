package regex;

import java.util.regex.Pattern;

public class Email {

	public static void main(String[] args) {
		String email="Vinoth123@gmail.com";
//		String regexNumber ="[0-9]";
//		String regexAlphabet="[a-zA-Z]";
//		String regexSpecialChar="[@.]";
		
		String regexNumber ="[^0-9]";
		String regexAlphabet="[^a-zA-Z]";
		String regexSpecialChar="[^@.]";
		
		Pattern pNumber=Pattern.compile(regexNumber);
		String number=pNumber.matcher(email).replaceAll("");
		System.out.println("Numerics from given string: "+number);
		
		Pattern pAlphabet = Pattern.compile(regexAlphabet);
		String alphabet=pAlphabet.matcher(email).replaceAll("");
		System.out.println("Alphabets from given string: "+alphabet);
		
		Pattern pSpecialChar = Pattern.compile(regexSpecialChar);
		String specialChar = pSpecialChar.matcher(email).replaceAll("");
		System.out.println("SpecialCharacters from given string: "+specialChar);
		

	}

}
