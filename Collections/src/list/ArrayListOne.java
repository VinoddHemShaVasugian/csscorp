package list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ListIterator;

public class ArrayListOne {

	public static void main(String args[]) {
		/*
		 * ArrayList<String> al = new ArrayList<String>(); al.add("Amit");
		 * al.add("Vijay"); al.add("Kumar"); al.add(1, "Sachin");
		 * System.out.println("element at 2nd position: " + al.get(2));
		 * ListIterator<String> itr = al.listIterator();
		 * System.out.println("traversing elements in forward direction...");
		 * while (itr.hasNext()) { System.out.println(itr.next()); }
		 * System.out.println("traversing elements in backward direction...");
		 * while (itr.hasPrevious()) { System.out.println(itr.previous()); }
		 */

		int[] a = { 1, 2, 3 };

		ArrayList al = new ArrayList();
		for (int i = 0; i < a.length; i++) {
			al.add(a[i]);
		}

		int[] v = { 1, 2, 5, 4, 3 };

		ArrayList vl = new ArrayList();
		for (int i = 0; i < v.length; i++) {
			vl.add(v[i]);
		}

		System.out.println("Collection 1");

		for (Object b : al)
			System.out.println(b);

		System.out.println("Collection 2");

		for (Object b : vl)
			System.out.println(b);

		// for(Object b:al)
		// System.out.println(b);

		System.out.println("---------------------");
		// System.out.println(al.lastIndexOf(1));
		// Collections.sort(al);
		// for(Object b:vl)
		// System.out.println(b);

		// al.addAll(vl);
		// al.retainAll(vl);

		// System.out.println("After added");

		// for(Object b:al)
		// System.out.println(b);

		System.out.println("After Retained");

		vl.retainAll(al);

		for (Object b : al)
			System.out.println(b);

		// for(Object b:vl)
		// System.out.println(b);
		//
		// System.out.println("test");
		// System.out.println(al.indexOf(2));
		// System.out.println(al.lastIndexOf(2));

	}
}