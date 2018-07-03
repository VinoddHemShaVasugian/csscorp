package test;

public class ThrowThrows {

	public static void main(String[] args) throws Exception{
	
		//try{
			ThrowThrows t= new ThrowThrows();
		t.add("Vinoth","nagireddy");
		
		//t.add("Vinoth",null);
		t.add(null,"...");
		/*}catch(Exception e){
			System.out.println("Don't pass null values");
		}*/

	}
	
	private  void add(String s1,String s2)throws Exception{
		if(s1==null)
			throw new VinothException("avv");
		else if(s2==null)
			throw new NagiReddyException("...");
		else{
			System.out.println(s1.compareTo(s2));
		}
	}
	
	class VinothException extends Exception{
		public VinothException(String s){
			System.out.println("Null value for Vinoth");
		}
	}

	class  NagiReddyException extends Exception{
		public NagiReddyException(String s){
			System.out.println("Null value for NagiReddy");
		}
	}
}
