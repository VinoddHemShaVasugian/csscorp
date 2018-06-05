package productionLogs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class getfilenames {

	public static void main(String[] args) {

		String directory = "D:\\production logs\\extracted\\Entire log files\\folder wise results\\folder1";
		List<String> logFiles = new ArrayList<String>();
		File dir = new File(directory);
		for (File file : dir.listFiles()) {
			if (file.getName().toLowerCase().matches((".*.log.*"))) {
				logFiles.add(file.getName());
			}
		}
		System.out.println(logFiles.size());
		for (int i = 0; i < logFiles.size(); i++) {
			System.out.println(logFiles.get(i));
		}

	}

}
