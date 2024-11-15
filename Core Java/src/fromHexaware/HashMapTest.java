package fromHexaware;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Integer, String> mp = new HashMap<Integer, String>();
		mp.put(1, "test");
		mp.put(2, "interview");

		for (Map.Entry m : mp.entrySet()) {
			System.out.println("Key " + m.getKey() + " Value: " + m.getValue());
		}

	}

}
