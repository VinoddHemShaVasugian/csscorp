package productionLogs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class distinctvanityurls {

	public static void main(String[] args) throws EncryptedDocumentException,
			InvalidFormatException, FileNotFoundException, IOException {
		int k = 1;
		String str = "";
		String path = "D:\\production logs\\extracted\\Entire log files\\folder wise results\\final result\\backup\\vanityurls.xlsx";
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		Sheet sheet = wb.getSheetAt(0);
		for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
			Row row = sheet.getRow(j);
			Cell CellRead = row.getCell(1);
			if (CellRead != null) {
				str = CellRead.getStringCellValue();

			}

		}

		FileOutputStream out = new FileOutputStream(new File(path));
		Row row = sheet.getRow(k);
		Cell urls = row.createCell(1);
		urls.setCellType(Cell.CELL_TYPE_STRING);
		urls.setCellValue(str);
		System.out.println(str);
		wb.write(out);
		out.flush();
		out.close();
	}
}
