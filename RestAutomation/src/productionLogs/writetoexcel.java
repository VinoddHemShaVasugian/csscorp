package productionLogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writetoexcel {

	public static void main(String[] args) throws IOException,
			EncryptedDocumentException, InvalidFormatException {

		BufferedReader in = new BufferedReader(
				new FileReader(
						"D:\\production logs\\extracted\\Entire log files\\folder wise results\\final result\\backup\\redirectarun71.txt"));
		String str;

		List<String> items = new ArrayList<String>();
		while ((str = in.readLine()) != null) {
			items.add(str);
		}

		System.out.println("Total urls :" + items.size());

		String path = "D:\\production logs\\extracted\\Entire log files\\folder wise results\\final result\\backup\\redirecturls.xlsx";
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		Sheet sheet = wb.getSheetAt(0);
		for (int i = 0; i < items.size(); i++) {

			Row row = sheet.createRow(i);
			FileOutputStream out = new FileOutputStream(new File(path));
			Cell urls = row.createCell(0);
			urls.setCellType(Cell.CELL_TYPE_STRING);
			urls.setCellValue(items.get(i));
			System.out.println(items.get(i));
			wb.write(out);
			out.flush();
			out.close();
		}
	}
}
