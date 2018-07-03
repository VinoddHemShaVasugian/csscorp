package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	Test(){
		
	}
	public static void main(String[] args) {
//		String s = get();
//		Test t = new Test();
//		System.out.println(t.hashCode());
		Map hs= new ConcurrentHashMap();
		hs.put(1,"css");
		hs.put(2,"corp");
		
		Set keys = hs.keySet();
		Iterator it = keys.iterator();
		while(it.hasNext()){
			Object key = it.next();
			System.out.println(hs.get(key));
			if(key.equals(2)){
			hs.remove(key);}
		}
		System.out.println(hs);
	}
	private static String get(){
		return "";
	}
	
	class CustomSet extends HashSet{
		
		public void add(int a,int b){
			add(a);
		}
	}
}
