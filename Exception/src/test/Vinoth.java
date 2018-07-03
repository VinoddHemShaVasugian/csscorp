package test;

public class Vinoth extends Exception {

	public Vinoth(String string) {
		System.out.println("exception class constructor");
	}

	public static void main(String[] args)throws Exception{
		String s=null;
		String s2="test";
		
		if(s!=s2){
			throw new Vinoth(s2);
		}

	}

}
