package regex;

import java.util.regex.Pattern;

public class Matches {

	public static void main(String[] args) {
		 
		        // Following line prints "true" because the whole
		        // text "geeksforgeeks" matches pattern "geeksforge*ks"
		        System.out.println (Pattern.matches("geeksforge*ks",
		                                            "geeksforgeeks"));
		 
		        // Following line prints "false" because the whole
		        // text "geeksfor" doesn't match pattern "g*geeks*"
		        System.out.println (Pattern.matches("g*geeks*",
		                                            "geeksfor"));
		    }

}
