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

public class extracturls {

	public static void main(String[] args) throws IOException {
		String line = "";
		String encoding = "UTF-8";
		List<String> containedredirectUrls = new ArrayList<String>();
		List<String> containedvanityUrls = new ArrayList<String>();
		int counter = 1;
		int folder = 1;
		// String directory =
		// "D:\\production logs\\extracted\\Entire log files\\folder wise results\\folder"+folder;
		String directory = "D:\\production logs 221\\extracted\\folder wise results\\folder"
				+ folder;
		System.out.println(directory + ":directory");
		List<String> logFiles = new ArrayList<String>();
		File dir = new File(directory);
		for (File file : dir.listFiles()) {
			if (file.getName().toLowerCase().matches((".*.log.*"))) {
				logFiles.add(file.getName());
			}
		}

		for (int k = 0; k < logFiles.size(); k++) {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(directory + "\\" + logFiles.get(k)),
					encoding));

			System.out.println(directory + "\\" + logFiles.get(k));

			while ((line = br.readLine()) != null) {
				// && counter < 4500000
				if (line.contains("autocarevegas.com")
						|| line.contains("bfmastercare.com")
						|| line.contains("bfrc.jobs")
						|| line.contains("bsro.jobs")
						|| line.contains("carcareacademy.com")
						|| line.contains("carcareacademy.net")
						|| line.contains("carcareacademy.org")
						|| line.contains("driveafirestone.com")
						|| line.contains("ecooilchange.com")
						|| line.contains("expert-tire.biz")
						|| line.contains("experttire.com")
						|| line.contains("expert-tire.com")
						|| line.contains("experttire.net")
						|| line.contains("experttire.org")
						|| line.contains("fcac.biz")
						|| line.contains("firestonecomplete.biz")
						|| line.contains("firestonecomplete.com")
						|| line.contains("firestonecomplete.info")
						|| line.contains("firestonecomplete.net")
						|| line.contains("firestonecomplete.org")
						|| line.contains("firestonecomplete.us")
						|| line.contains("firestonecompleteautocare.biz")
						|| line.contains("firestonecompleteautocare.info")
						|| line.contains("firestonecompleteautocare.jobs")
						|| line.contains("firestonecompleteautocare.mobi")
						|| line.contains("firestonecompleteautocare.net")
						|| line.contains("firestonecompleteautocare.org")
						|| line.contains("firestonenitrogen.com")
						|| line.contains("firestonesweepstakes.com")
						|| line.contains("gasonomics101.com")
						|| line.contains("lemanstire.com")
						|| line.contains("lemanstire.net")
						|| line.contains("lemanstire.org")
						|| line.contains("mastercare-usa.biz")
						|| line.contains("mastercareusa.com")
						|| line.contains("mastercare-usa.com")
						|| line.contains("mastercareusa.info")
						|| line.contains("mastercare-usa.info")
						|| line.contains("mastercareusa.net")
						|| line.contains("mastercare-usa.net")
						|| line.contains("mastercareusa.org")
						|| line.contains("mastercare-usa.org")
						|| line.contains("myfirestone.com")
						|| line.contains("onwardcareer.com")
						|| line.contains("pennytiretest.com")
						|| line.contains("rideminderapp.com")
						|| line.contains("rideminderapp.mobi")
						|| line.contains("rideminderapp.net")
						|| line.contains("takethegreenroad.com")
						|| line.contains("takethegreenroad.net")
						|| line.contains("takethegreenroad.org")
						|| line.contains("tirequote.biz")
						|| line.contains("tirequote.com")
						|| line.contains("tirequote.net")
						|| line.contains("tirequote.org")
						|| line.contains("firestonesurvey")
						|| line.contains("experttiresurvey")) {

					File file = new File(directory + "\\vanitycontent" + folder
							+ ".txt");

					FileWriter cw = new FileWriter(file, true);

					BufferedWriter bw = new BufferedWriter(cw);

					bw.write(line);

					bw.newLine();

					bw.close();

					String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";

					Pattern pattern = Pattern.compile(urlRegex,
							Pattern.CASE_INSENSITIVE);

					Matcher urlMatcher = pattern.matcher(line);

					while (urlMatcher.find()) {

						containedvanityUrls.add(line.substring(
								urlMatcher.start(0), urlMatcher.end(0)));

					}
					counter++;
				} else if (line.contains("\" 301")) {

					File file = new File(directory + "\\redirectcontent"
							+ folder + ".txt");

					FileWriter cw = new FileWriter(file, true);

					BufferedWriter bw = new BufferedWriter(cw);

					bw.write(line);

					bw.newLine();

					bw.close();

					String urlRegex = "((GET\\s)((/)|(\\\\))+([\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*))";

					Pattern pattern = Pattern.compile(urlRegex,
							Pattern.CASE_INSENSITIVE);

					Matcher urlMatcher = pattern.matcher(line);

					while (urlMatcher.find()) {

						containedredirectUrls.add(line.substring(
								urlMatcher.start(0), urlMatcher.end(0)));

					}
					counter++;
				}
			}

			br.close();
			System.out.println(counter
					+ ":total number of lines(redirect and vanity)");
			System.out.println(containedredirectUrls.size()
					+ ":redirect original");
			System.out.println(containedvanityUrls.size() + ":vanity original");

			Set<String> vs = new HashSet<>();
			vs.addAll(containedvanityUrls);
			containedvanityUrls.clear();
			containedvanityUrls.addAll(vs);
			System.out.println(containedvanityUrls.size()
					+ ":removing vanity duplicates");

			Set<String> hs = new HashSet<>();
			hs.addAll(containedredirectUrls);
			containedredirectUrls.clear();
			containedredirectUrls.addAll(hs);
			System.out.println(containedredirectUrls.size()
					+ ":removing redirect duplicates");

			File vanityfile = new File(directory + "\\vanity" + folder + ".txt");

			System.out.println(directory + "\\vanity" + folder + ".txt");

			FileWriter fv = new FileWriter(vanityfile, true);
			BufferedWriter bv = new BufferedWriter(fv);
			for (int i = 0; i < containedvanityUrls.size(); i++) {
				bv.write(containedvanityUrls.get(i));
				bv.newLine();
			}
			bv.close();

			File redirectfile = new File(directory + "\\redirect" + folder
					+ ".txt");

			System.out.println(directory + "\\redirect" + folder + ".txt");

			FileWriter fr = new FileWriter(redirectfile, true);
			BufferedWriter brr = new BufferedWriter(fr);
			for (int j = 0; j < containedredirectUrls.size(); j++) {
				brr.write(containedredirectUrls.get(j));
				brr.newLine();
			}
			brr.close();

			counter = 0;
			containedredirectUrls.clear();
			containedvanityUrls.clear();

		}

		BufferedReader vanityin = new BufferedReader(new FileReader(directory
				+ "\\vanity" + folder + ".txt"));

		String vanitystr;

		List<String> vanityitems = new ArrayList<String>();
		while ((vanitystr = vanityin.readLine()) != null) {
			vanityitems.add(vanitystr);
		}

		System.out.println("before dup vanity final:" + vanityitems.size());

		Set<String> vff = new HashSet<>();
		vff.addAll(vanityitems);
		vanityitems.clear();
		vanityitems.addAll(vff);

		System.out.println("after dup vanity final:" + vanityitems.size());

		File file = new File(directory + "\\vanityfinal" + folder + ".txt");

		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < vanityitems.size(); i++) {
			bw.write(vanityitems.get(i));
			bw.newLine();
		}
		bw.close();

		BufferedReader redirectin = new BufferedReader(new FileReader(directory
				+ "\\redirect" + folder + ".txt"));

		String redirectstr;

		List<String> redirectitems = new ArrayList<String>();
		while ((redirectstr = redirectin.readLine()) != null) {
			redirectitems.add(redirectstr);
		}

		System.out.println("before dup redirect final:" + redirectitems.size());

		Set<String> rff = new HashSet<>();
		rff.addAll(redirectitems);
		redirectitems.clear();
		redirectitems.addAll(rff);

		System.out.println("after dup redirect final:" + redirectitems.size());

		File file1 = new File(directory + "\\redirectfinal" + folder + ".txt");

		FileWriter fww = new FileWriter(file1, true);
		BufferedWriter bww = new BufferedWriter(fww);

		for (int i = 0; i < redirectitems.size(); i++) {
			bww.write(redirectitems.get(i));
			bww.newLine();
		}
		bww.close();

	}
}