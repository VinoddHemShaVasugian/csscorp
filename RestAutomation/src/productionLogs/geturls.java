package productionLogs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class geturls {

	public static void main(String[] args) throws EncryptedDocumentException,
			InvalidFormatException, FileNotFoundException, IOException {

		File expfile = new File("./Files/arun123.txt");

		String expectedcontent = FileUtils.readFileToString(expfile);
		// String text =
		// "Welcome to https://stackoverflow.com/abccccc/fred$dfdf=ddd/FFDFD/dsdfs/sdfsf/sdfsf/sdfsf and here is another link http://www.google.com/ \n which is a great search engine";
		List<String> containedUrls = new ArrayList<String>();
		String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
		Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
		Matcher urlMatcher = pattern.matcher(expectedcontent);

		while (urlMatcher.find()) {
			containedUrls.add(expectedcontent.substring(urlMatcher.start(0),
					urlMatcher.end(0)));
		}
		// System.out.println(containedUrls.get(0));
		// System.out.println(containedUrls.size());
		System.out.println(containedUrls.size());
		Set<String> hs = new HashSet<>();
		hs.addAll(containedUrls);
		containedUrls.clear();
		containedUrls.addAll(hs);
		System.out.println(containedUrls.size());
		String path = "./Files/urlextract.xls";
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		Sheet sheet = wb.getSheetAt(0);
		for (int i = 0; i < containedUrls.size(); i++) {

			Row row = sheet.createRow(i);
			FileOutputStream out = new FileOutputStream(new File(path));
			Cell urls = row.createCell(0);
			urls.setCellType(Cell.CELL_TYPE_STRING);
			urls.setCellValue(containedUrls.get(i));
			wb.write(out);
			out.flush();
			out.close();

		}
	}

}
