package productionLogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class check {

	public static void main(String[] args) throws IOException {
		String line = "";
		String encoding = "UTF-8";
		List<String> containedUrls = new ArrayList<String>();
		int counter = 1;

		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"D:\\production logs\\extracted\\Entire log files\\folder wise results\\merged results\\check.txt"),
						encoding));

		while ((line = br.readLine()) != null) {
			if (line.contains("mastercare-usa.biz")
					|| line.contains("bfmastercare.com")) {
				File file = new File(
						"D:\\production logs\\extracted\\Entire log files\\folder wise results\\merged results\\checkresult.txt");

				FileWriter cw = new FileWriter(file, true);

				BufferedWriter bw = new BufferedWriter(cw);

				bw.write(line);

				bw.newLine();

				bw.close();
			}

		}
	}
}
