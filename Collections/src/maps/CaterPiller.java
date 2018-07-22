package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CaterPiller {

	public static void main(String[] args) {
		int input[] = {3,1,1,2,3,2,3,1,1};
		
		Map<Integer,Integer> hm=new TreeMap<Integer, Integer>();
		
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
		
		System.out.println(hm.get(1));
	
		System.out.println("-----------------------------");
		
//		TreeMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
//		for (Map.Entry entry : hm.entrySet()) {
//		    sortedMap.put((Integer) entry.getValue(), (Integer)entry.getKey());
//		}

		for(Map.Entry m:hm.entrySet()){
			System.out.println("Occurance: "+m.getKey()+" Number: "+m.getValue());
		
		}
  

	}

}
