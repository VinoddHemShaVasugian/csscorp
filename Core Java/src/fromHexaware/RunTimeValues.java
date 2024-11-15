package fromHexaware;

import java.util.Scanner;

public class RunTimeValues {

	public static void main(String[] args) {
		System.out.println("Running");
		
		Scanner sc = new Scanner(System.in);
		
		String storeString = sc.nextLine();
		System.out.println("Entered string is: "+storeString);
		
		int storeInt = sc.nextInt();
		System.out.println("Entered int is: "+storeInt);
		
		float storeFloat = sc.nextFloat();
		System.out.println("Entered int is: "+storeFloat);
		
		sc.close();
		
		System.out.println("Scanner closed");

	}

}
