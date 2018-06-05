package KeyWordDriven.TestExecution;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import resources.KeyWordDriven.TestExecution.DataDrivenHelper;
import Framework.BSROException;
import KeyWordDriven.KeyWordDrivenConstants;
import KeyWordDriven.Database.DBConnection;

/**
 * Description : Functional Test Script
 * 
 * @author VenkataRaja
 */
public class DataDriven  {
	/**
	 * Script Name : <b>DataDriven</b> Generated : <b>Apr 23, 2013 12:31:11
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/04/23
	 * @author VenkataRaja
	 * @throws BSROException
	 */
	public static boolean isDataDriven()throws BSROException {

		boolean returnState = false;

		Connection connection = DBConnection.getConnection();

		String DataDriven_Return_Value = "";

		try {

			Statement statement = connection.createStatement();

			String Query = "SELECT (DATA_DRIVEN) FROM TC_ID WHERE TC_ID='"
					+ KeyWordDrivenConstants.TC_ID
					+ "' AND PROJECT_NAME='"
					+ KeyWordDrivenConstants.ACTIVE_PROJECT_NAME
					+ "' AND ACTIVITY_STATE='ACTIVE'";

			ResultSet resultSet = statement.executeQuery(Query);

			System.out.println("Query Executing => " + Query);

			while (resultSet.next()) {

				DataDriven_Return_Value = resultSet.getString("DATA_DRIVEN");

			}

			connection.close();

			if (DataDriven_Return_Value.equals("YES")) {

				returnState = true;

			}

		} catch (SQLException e) {

			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.

			returnState = false;

		}

		return returnState;

	}
}
