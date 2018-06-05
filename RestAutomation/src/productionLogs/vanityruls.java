package productionLogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class vanityruls {

	public static void main(String[] args) throws IOException {
		String line = "";
		String encoding = "UTF-8";
		int counter = 1;

		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"D:\\production logs\\extracted\\Entire log files\\folder wise results\\final result\\backup\\redirectarun.txt"),
						encoding));

		while ((line = br.readLine()) != null) {

			if (line.length() < 20) {

				File file = new File(
						"D:\\production logs\\extracted\\Entire log files\\folder wise results\\final result\\backup\\redirectmorelesschars.txt");

				FileWriter cw = new FileWriter(file, true);

				BufferedWriter bw = new BufferedWriter(cw);

				bw.write(line);

				bw.newLine();

				bw.close();

				counter++;

				System.out.println(line);

			}
		}

		System.out.println("total lines : " + counter);

	}

}