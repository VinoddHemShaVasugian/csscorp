package fromHexaware;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicteArray {

	public static void main(String[] args) {
		int a[] = { 10, 10, 20, 30, 20, 40 };
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < a.length; i++) {
			hs.add(a[i]);
		}
		System.out.println("Unique Values: " + hs);
		System.out.println("Before sorting");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}

		Arrays.sort(a);
		System.out.println("\n");
		System.out.println("After sorting");

		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}

	}

}
