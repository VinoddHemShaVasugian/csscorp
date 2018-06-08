package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimplePattern1 {

	public static void main(String[] args) {
		/*Pattern pattern = Pattern.compile("geeks");
		 
        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher("geeksforgeeks.org");
 
        // Print starting and ending indexes of the pattern
        // in text
        while (m.find())
            System.out.println("Pattern found from " + m.start() +
                               " to " + (m.end()-1));*/
		String text="am living in ambit";
		Pattern p=Pattern.compile("am");
//		Pattern p=Pattern.compile("i*");
		Matcher m = p.matcher(text);
		while(m.find()){
//			int start=m.start();
			int start=m.start();
			int end=m.end()-1;
//			System.out.println("Patterm found from "+m.start()+" to "+(m.end()-1));
			System.out.println("Patterm found from "+start+" to "+end);
			
		}
		

	}

}
