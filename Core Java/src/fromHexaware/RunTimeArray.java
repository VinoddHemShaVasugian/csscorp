package fromHexaware;

import java.util.Scanner;

public class RunTimeArray {

	public static void main(String[] args) {
		System.out.println("Enter array size and elements");
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int testing[] = new int[size];
		for (int i = 0; i < size; i++) {
			testing[i]=sc.nextInt();
		}
		
		for (int i = 0; i < testing.length; i++) {
			System.out.print("array values: "+testing[i]+" ");
		}

	}

}
