package maps;

import java.util.HashMap;
import java.util.Map;

public class Paypal {

	public static void main(String[] args) {
		int[] input = {3,1,1,2,3,2,3,1,1};
		
		Map<Integer,Integer> hm=new HashMap();
		
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
		for(Integer k:hm.keySet()){
			int a=hm.get(k);
			System.out.println("Key: "+k+" Value: "+a);
			
		}

	}

}
