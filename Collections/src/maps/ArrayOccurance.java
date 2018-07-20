package maps;

import java.util.HashMap;
import java.util.Map;

public class ArrayOccurance {

	public static void main(String[] args) {

		int[] numbers = new int[] {3,1, 1,2,3,2,3,1,1};

		Map<Integer, Integer> map = new HashMap<>();
		for (int key : numbers) {
			if (map.containsKey(key)) {
				int occurrence = map.get(key);
				occurrence++;
				map.put(key, occurrence);
			} else {
				map.put(key, 1);
			}
		}

		for (Integer key : map.keySet()) {
			int occurrence = map.get(key);
			System.out.println(key + " occur " + occurrence + " time(s).");
		}
//		System.out.println("test");
	}

}