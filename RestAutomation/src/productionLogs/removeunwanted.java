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

public class removeunwanted {

	public static void main(String[] args) throws IOException {

		String line = "";
		String encoding = "UTF-8";

		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"D:\\production logs\\extracted\\Entire log files\\folder wise results\\final results\\vanityfinal.txt"),
						encoding));

		while ((line = br.readLine()) != null) {

			// if(line.toLowerCase().startsWith("GET")) {

			if (!line.startsWith("HTTP")) {

				File file = new File(
						"D:\\production logs\\extracted\\Entire log files\\folder wise results\\final results\\vanityunwanted.txt");

				FileWriter cw = new FileWriter(file, true);

				BufferedWriter bw = new BufferedWriter(cw);

				bw.write(line);

				bw.newLine();

				bw.close();
			}

		}

	}
}
