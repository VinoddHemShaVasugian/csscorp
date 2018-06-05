package productionLogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class filterurls {

	public static void main(String[] args) throws IOException {
		String encoding = "UTF-8";

		List<String> containedUrls = new ArrayList<String>();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"D:\\production logs\\extracted\\Entire log files\\folder wise results\\folder16\\access_ssl.log.1455494400"),
						encoding));
		String line;
		int counter = 1;

		while ((line = br.readLine()) != null && counter < 4500000) {

			if (line.contains("\" 301")) {

				File file = new File(
						"D:\\production logs\\extracted\\Entire log files\\folder wise results\\folder16\\mycontent.txt");

				FileWriter cw = new FileWriter(file, true);

				BufferedWriter bw = new BufferedWriter(cw);

				bw.write(line);

				bw.newLine();

				bw.close();

				// String urlRegex =
				// "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";

				String urlRegex = "((GET\\s)((/)|(\\\\))+([\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*))";

				Pattern pattern = Pattern.compile(urlRegex,
						Pattern.CASE_INSENSITIVE);

				Matcher urlMatcher = pattern.matcher(line);

				while (urlMatcher.find()) {

					containedUrls.add(line.substring(urlMatcher.start(0),
							urlMatcher.end(0)));

				}
				counter++;
			}
		}
		br.close();
		System.out.println(counter + ":number of lines");
		System.out.println(containedUrls.size() + ":original");
		Set<String> hs = new HashSet<>();
		hs.addAll(containedUrls);
		containedUrls.clear();
		containedUrls.addAll(hs);
		System.out.println(containedUrls.size() + ":removing duplicates");

		File file = new File(
				"D:\\production logs\\extracted\\Entire log files\\folder wise results\\folder16\\myfile.txt");

		FileWriter fw = new FileWriter(file, true);
		for (int i = 0; i < containedUrls.size(); i++) {
			fw.write(containedUrls.get(i) + ",");
		}
		fw.close();

	}

}
