package fromHexaware;

public class ReverseString {

	public static void main(String[] args) {
		String s = "testing";
		String rev = "";
		for(int a = s.length()-1;a>=0;a--) {
			char c = s.charAt(a);
			rev = rev+c;
		}
System.out.println("reverse value: "+rev);
	}

}
