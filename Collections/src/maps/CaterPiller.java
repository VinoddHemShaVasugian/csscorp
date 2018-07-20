package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CaterPiller {

	public static void main(String[] args) {
		int input[] = {3,1,1,2,3,2,3,1,1};
		
		Map<Integer,Integer> hm=new HashMap<Integer, Integer>();
		
		for(int a:input){
			if(!hm.containsKey(a)){
				hm.put(a, 1);
			}
			else{
				int occurance=hm.get(a);
				occurance++;
				hm.replace(a, occurance);
			}
		}
		for(Integer key:hm.keySet()){
			int value=hm.get(key);
			System.out.println("Key: "+key+" Value: "+value);
			
		}
		System.out.println("test: "+hm.values());
		System.out.println("size: "+hm.values().size());
//		hm.values().s
		
		System.out.println(hm);
		
		Map<Integer, Integer> tm = new TreeMap<Integer, Integer>(hm);
		System.out.println(tm);
		
		for(Integer key:tm.keySet()){
			int value=tm.get(key);
			System.out.println("Key: "+key+" Value: "+value);
			
		}
		
	    //pretty print a map
//	    public static <K, V> void printMap(Map<K, V> map) {
//	        for (Map.Entry<K, V> entry : map.entrySet()) {
//	            System.out.println("Key : " + entry.getKey()+ " Value : " + entry.getValue());
//	        }
//	    }
	    

	}

}
