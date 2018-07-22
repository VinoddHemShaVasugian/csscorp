package javasolutions;

public class ConcatStrings {

	public static void main(String[] args) {
		String s="system";
		String rev="";
		System.out.println(s.length());
		for(int i=s.length()-1;i>=0;i--){
			char c = s.charAt(i);
			rev=rev+c;
		}
		System.out.println("Reverse String is: "+rev);

	}

}
