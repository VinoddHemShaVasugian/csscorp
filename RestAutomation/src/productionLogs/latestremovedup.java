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

public class latestremovedup {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(
				new FileReader(
						"D:\\production logs\\extracted\\Entire log files\\folder wise results\\final result\\backup\\redirectarun70.txt"));
		String str;

		List<String> items = new ArrayList<String>();
		while ((str = in.readLine()) != null) {
			/*
			 * if(str.toLowerCase().endsWith(".js")) { str =
			 * str.substring(0,str.lastIndexOf("/")+1); items.add(str); } else {
			 * items.add(str); } }
			 */

			/*
			 * if(str.toLowerCase().endsWith("/")) { str = str.replaceAll("/$",
			 * ""); items.add(str); } }
			 */

			if (!str.toLowerCase().startsWith("get /tirecatalog/")) {
				items.add(str);
			}
		}
		/*
		 * if(str.toLowerCase().endsWith("/")) { items.add(str); } else { str =
		 * str+"/"; items.add(str); } }
		 */

		System.out.println("before dup :" + items.size());

		/*
		 * Set<String> hs = new HashSet<>(); hs.addAll(items); items.clear();
		 * items.addAll(hs);
		 */

		Set<String> hs = new HashSet<>();
		for (String arraystring : items) {
			hs.add(arraystring.toLowerCase());
		}
		items.clear();
		items.addAll(hs);

		System.out.println("after dup :" + items.size());

		File file = new File(
				"D:\\production logs\\extracted\\Entire log files\\folder wise results\\final result\\backup\\redirectarun71.txt");

		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < items.size(); i++) {
			bw.write(items.get(i));
			bw.newLine();
		}
		bw.close();

	}
}
