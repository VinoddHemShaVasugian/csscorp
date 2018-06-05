package restPackage;

public class stringclass {

	public static void main(String[] args) {
		// String str = "http://stackoverflow.com/questions/ask/";

		String str = "http://www.google.com/bot.html)";

		// String result = str.substring(0,str.lastIndexOf("/")+1);

		// str = str.replaceAll("/$", "");

		/*
		 * int dot1 = str.indexOf("/");
		 * 
		 * System.out.println(dot1);
		 * 
		 * str = str.substring(str.indexOf("//") + 2, dot1+1);
		 * 
		 * System.out.println(str);
		 */

		str = str.substring(str.indexOf("//") + 2);

		System.out.println(str);

		if (str.contains("/")) {

			str = str.substring(0, str.indexOf("/"));

			System.out.println(str + "inside if");
		}

		else {
			System.out.println(str + "inside else");
		}

	}

}
