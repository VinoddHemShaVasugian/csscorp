package Execution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Datadriven {

	private String DataDrivenDatasetName;
	public String getDataDrivenDatasetName() {
		return DataDrivenDatasetName;
	}
	public void setDataDrivenDatasetName(String dataDrivenDatasetName) {
		DataDrivenDatasetName = dataDrivenDatasetName;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
	private String[] values;
	
	public static String getData(String path, String Sheet, int r, int c) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println("getData - File not available");
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			System.out.println("getData - File format is not xlsx");
		}
		String data = wb.getSheet(Sheet).getRow(r).getCell(c)
				.getStringCellValue();
		return data;
	}
}
