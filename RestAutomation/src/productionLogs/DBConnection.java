package productionLogs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() throws Exception {

		Connection connection = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String connectionURL = "jdbc:oracle:thin:@"
					+ DBConstants.devDBHostName + ":"
					+ DBConstants.devDBConnectionPort + ":"
					+ DBConstants.devDBInstanceName + "";

			connection = DriverManager.getConnection(connectionURL,
					DBConstants.devDBUserName, DBConstants.devDBPassword);

			System.out.println("devDB Connection URL = { " + "" + connectionURL
					+ " }");

		} catch (Exception ex) {

			ex.printStackTrace();

			throw new Exception(ex);

		}

		return connection;

	}

}
