package productionLogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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

public class removedup {

	public static void main(String[] args) throws IOException {

		File expfile = new File(
				"D:\\production logs\\extracted\\Entire log files\\folder wise results\\folder14\\myfile14.txt");

		String expectedcontent = FileUtils.readFileToString(expfile);

		ArrayList<String> items = new ArrayList(Arrays.asList(expectedcontent
				.split("\\s*,\\s*")));

		System.out.println("before dup :" + items.size());

		Set<String> hs = new HashSet<>();
		hs.addAll(items);
		items.clear();
		items.addAll(hs);

		System.out.println("after dup :" + items.size());

		File file = new File(
				"D:\\production logs\\extracted\\Entire log files\\folder wise results\\folder14\\finalfile14.txt");

		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < items.size(); i++) {
			bw.write(items.get(i));
			bw.newLine();
		}
		bw.close();

	}
}
