package maps;

import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();           
		   map.put(101,"Let us C");  
		   map.put(102, "Operating System");  
		   map.put(103, "Data Communication");  
		   System.out.println("Values before remove: "+ map);    
		   // Remove value for key 102  
//		   map.remove(102);
		   System.out.println(map.containsKey(101));
		   System.out.println(map.containsValue("Operating System"));
		   System.out.println(map.entrySet());
//		   System.out.println("Values after remove: "+ map); 

	}

}
