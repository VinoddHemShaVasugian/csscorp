package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Paypal {

	public static void main(String[] args) {
		int[] input = {3,1,1,2,3,2,3,1,1};
		
		Map<Integer,Integer> hm=new TreeMap();
		
		for(int key:input){
			if(!hm.containsKey(key)){
				hm.put(key, 1);
			}
			else{
				int occurance=hm.get(key);
				occurance++;
				hm.replace(key, occurance);
			}
		}
		for(Map.Entry m:hm.entrySet()){
			System.out.println("Number: "+m.getKey()+" Occurance: "+m.getValue());
		
		}
		
		System.out.println("-----------------------------");
		
		TreeMap<Integer, Integer> sortedMap = new TreeMap();
		for (Map.Entry m : hm.entrySet()) {
		    sortedMap.put((Integer) m.getValue(), (Integer)m.getKey());
		}

		for(Map.Entry m:sortedMap.entrySet()){
			System.out.println("Occurance: "+m.getKey()+" Number: "+m.getValue());
		
		}

	}

}
