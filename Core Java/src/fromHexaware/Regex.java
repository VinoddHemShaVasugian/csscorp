package fromHexaware;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		
		//Program 1 - Find the number of specific occurrences in given string.
		//Program 2 - Find the start and end position of the required word in given string.
//		String given = "test for testing engineer";
//		int count =0;
//		Pattern p = Pattern.compile("test");
//		Matcher m= p.matcher(given);
//		while (m.find()) {
//			int start = m.start();
//			int end = m.end()-1;
//			count++;
//			System.out.println("Start at "+start+" and end with "+end);
//		} System.out.println("Count is: "+count);
		
		
		//Program 3 - Split the string based on given pattern
		String given = "vino123hem123sha123dd123";
		String[] r = given.split("123");
		for (String string : r) {
			System.out.println(string);
		}

	}

}
