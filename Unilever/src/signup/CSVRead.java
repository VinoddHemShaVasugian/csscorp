package signup;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import au.com.bytecode.opencsv.CSVReader;

public class CSVRead {
	public static Iterable<Cell> exportedData;
	public static String exportData_Path ="D:\\Downloads\\investigators.csv";
	public static Test step;

	public static void main(String[] args) throws Exception {
		
		CSVReader reader = new CSVReader(new FileReader(exportData_Path));
		List<String[]> test=reader.readAll();
		int rowscount=test.size();
		System.out.println(rowscount);
		String[] testing=test.get(rowscount-1);
//		ArrayList arr = null;
//		for(int i=0;i<rowscount;i++){
//			String val0=testing[0];
//			arr.add(val0);
//		}
//		Iterator itr=arr.iterator();  
//		  while(itr.hasNext()){  
//		   System.out.println(itr.next());  
//		  }  
//		while (((test.get(rowscount-1)) != null)) {
//			String val0=testing[0];
//			String val1=testing[1];
//			String val2=testing[2];
//			String val3=testing[3];
//			String val4=testing[4];
//			String val5=testing[5];
//			String val6=testing[6];
//			String val7=testing[7];
//			String val8=testing[8];
//			
//			System.out.println("Val0: "+val0);
//			System.out.println("Val1: "+val1);
//			System.out.println("Val2: "+val2);
//			System.out.println("Val3: "+val3);
//			System.out.println("Val4: "+val4);
//			System.out.println("Val5: "+val5);
//			System.out.println("Val6: "+val6);
//			System.out.println("Val7: "+val7);
//			System.out.println("Val8: "+val8);
//			break;
//		}
//		
		    for(String str: testing){
		    	
		        System.out.print(str+",");
			}
		reader.close();

	}

}
