package object.Repo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class read_locators {
	static Properties prop;
	// static String fileName=null;
	static String prop_vaue = null;

	public static String get_property(String objectFileName, String props) {
		prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("./object/" + objectFileName);
			prop.load(input);
			prop_vaue = prop.getProperty(props);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop_vaue;
	}
}
