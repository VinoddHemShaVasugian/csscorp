package KeyWordDriven.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import Database.DBConstants;
import Framework.BSROException;



/**
 * Description : Functional Test Script
 * 
 * @author VenkataRaja
 */
public class DBConnection  {
	/**
	 * Script Name : <b>DBConnection</b> Generated : <b>Apr 23, 2013 12:25:47
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/04/23
	 * @author VenkataRaja
	 * @throws BSROException
	 */

	public static Connection getConnection() throws BSROException {

		Connection connection = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String connectionURL = "jdbc:oracle:thin:@"
					+ DBConstants.autoDBHostName + ":"
					+ DBConstants.autoDBConnectionPort + ":"
					+ DBConstants.autoDBInstanceName + "";

			connection = DriverManager.getConnection(connectionURL,
					DBConstants.autoDBUserName, DBConstants.autoDBPassword);

			System.out.println("AutoDB Connection URL = { " + ""
					+ connectionURL + " }");

			//logInfo("AutoDB Connection URL = { " + "" + connectionURL + " }");

		} catch (Exception ex) {

			ex.printStackTrace();

			throw new BSROException(ex);

		}

		return connection;

	}

}
