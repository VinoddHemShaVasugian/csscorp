package signup;

import java.io.FileReader;
import org.apache.poi.ss.usermodel.Cell;

import au.com.bytecode.opencsv.CSVReader;

public class Test {
	
	public static Iterable<Cell> exportedData;
	public static String exportData_Path ="D:\\Downloads\\investigators.csv";
	public static Test step;

	public static void main(String[] args) throws Exception{
//		exportedData=step.getlastRowData(exportData_Path, 0);
//		System.out.println(exportedData);

	}
	
	
//		private static final String FILE_PATH=”F:/test.xls”;

		
//		public void test() throws Exception {

//		}
	
	
	
	
	
//	CSVReader reader = new CSVReader(new FileReader("C:\\Users\\mukesh_otwani\\Desktop\\demo.csv"));
	
//	public static Iterable<Cell> getlastRowData(String path, int Sheet) {
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(path);
//		} catch (FileNotFoundException e) {
//			System.out.println("getData - File not available");
//		}
//		Workbook wb = null;
//		try {
//			wb = WorkbookFactory.create(fis);
//		} catch (Exception e) {
//			System.out.println("getData - File format is not xlsx");
//		}
//		int lastRowNum=wb.getSheetAt(Sheet).getLastRowNum();
////		String data = wb.getSheet(Sheet).getRow(r).getCell(c)
////				.getStringCellValue();
//		Iterable<Cell> data = wb.getSheetAt(Sheet).getRow(lastRowNum);
//		return data;
//	}
//	
//	public static String getData(String path, String Sheet, int r, int c) {
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(path);
//		} catch (FileNotFoundException e) {
//			System.out.println("getData - File not available");
//		}
//		Workbook wb = null;
//		try {
//			wb = WorkbookFactory.create(fis);
//		} catch (Exception e) {
//			System.out.println("getData - File format is not xlsx");
//		}
//		String data = wb.getSheet(Sheet).getRow(r).getCell(c)
//				.getStringCellValue();
//		return data;
//	}
}
