package KeyWordDriven.TestExecution;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import resources.KeyWordDriven.TestExecution.ActiveTestCasesHelper;
import Framework.BSROException;
import KeyWordDriven.KeyWordDrivenConstants;
import KeyWordDriven.Database.DBConnection;


/**
 * Description : Functional Test Script
 * 
 * @author VenkataRaja
 */
public class ActiveTestCases {
	/**
	 * Script Name : <b>ActiveTestCases</b> Generated : <b>Apr 23, 2013 12:28:58
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/04/23
	 * @author VenkataRaja
	 * @throws BSROException
	 */
	public static ArrayList<String> getActiveTestCasesList()
			throws BSROException {

		ArrayList<String> arrayList_Active_Test_Cases_List = new ArrayList<String>();

		Connection connection = DBConnection.getConnection();

		if (connection != null) {

			try {

				Statement statement = connection.createStatement();

				// String Query =
				// "SELECT TC_ID FROM TC_ID WHERE ACTIVITY_STATE = 'ACTIVE' AND PROJECT_NAME='"
				// + KeyWordDrivenConstants.ACTIVE_PROJECT_NAME + "'";

				String Query = "SELECT TC_ID FROM TC_ID WHERE ACTIVITY_STATE = 'ACTIVE' AND PROJECT_NAME='"
						+ KeyWordDrivenConstants.ACTIVE_PROJECT_NAME
						+ "' AND TC_ID='"
						+ KeyWordDrivenConstants.RQM_TC_NAME
						+ "'";

				System.out.println("Query Executing => " + Query);

			//	logInfo("Query Executing => " + Query);

				ResultSet resultSet = statement.executeQuery(Query);

				while (resultSet.next()) {

					String TC_ID = resultSet.getString("TC_ID");

					if (KeyWordDrivenConstants.debug) {

						System.out.println("TC_ID = " + TC_ID);

					}

					arrayList_Active_Test_Cases_List.add(TC_ID);

				}

				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();

				throw new BSROException(e);

			}

			if (KeyWordDrivenConstants.debug) {

				System.out.println("arrayList_Active_Test_Cases_List size = "
						+ arrayList_Active_Test_Cases_List.size());

			}

			if (0 == arrayList_Active_Test_Cases_List.size()) {

				throw new BSROException(
						"No Test Cases Identified with test case name = "
								+ KeyWordDrivenConstants.RQM_TC_NAME
								+ "and project name = "
								+ RQM.RQMConstants.RQM_Project_Name);

			}

		}

		return arrayList_Active_Test_Cases_List;

	}

	public static boolean getActiveTestCaseDataDrivenID() throws BSROException {

		boolean resultState = false;

		Connection connection = DBConnection.getConnection();

		try {

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement
					.executeQuery("SELECT (DATA_DRIVEN_IDENTIFIER) FROM TC_ID WHERE TC_ID='"
							+ KeyWordDrivenConstants.TC_ID
							+ "' AND PROJECT_NAME='"
							+ KeyWordDrivenConstants.ACTIVE_PROJECT_NAME + "'");

			while (resultSet.next()) {

				String Data_Driven_ID = resultSet
						.getString("DATA_DRIVEN_IDENTIFIER");

				KeyWordDrivenConstants.TC_DATA_DRIVEN_ID = Data_Driven_ID;

			}

			resultState = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		//	logError("getActiveTestCaseDataDrivenID() function failed.");

			throw new BSROException(e);

		}

		return resultState;

	}

	public static ArrayList<String> getActiveTestCaseDataSets()
			throws BSROException {

		ArrayList<String> arrayList_DATA_DRIVEN_SETS = new ArrayList<String>();

		Connection connection = DBConnection.getConnection();

		try {

			Statement statement = connection.createStatement();

			String Query = "SELECT DISTINCT (DATA_DRIVEN_SET_NAME) FROM DATA_DRIVEN_DATA WHERE DATA_DRIVEN_IDENTIFIER = '"
					+ "" + KeyWordDrivenConstants.TC_DATA_DRIVEN_ID + "'";

			//logInfo("Query = " + Query);

			ResultSet resultSet = statement.executeQuery(Query);

			while (resultSet.next()) {

				arrayList_DATA_DRIVEN_SETS.add(resultSet
						.getString("DATA_DRIVEN_SET_NAME"));

			}

			if (KeyWordDrivenConstants.debug) {

				System.out
						.println("Data Driven Sets that are mapped to active testcase = "
								+ arrayList_DATA_DRIVEN_SETS.size());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		//	logError("getActiveTestCaseDataSets() function failed.");

			throw new BSROException(e);

		}

		return arrayList_DATA_DRIVEN_SETS;

	}

	public static boolean getDataDrivenValue() throws BSROException {

		boolean returnStatus = false;

		String data_Driven_Key_Value = "";

		Connection connection = DBConnection.getConnection();

		try {

			String Query = ""
					+ "SELECT DATA_DRIVEN_VALUE FROM DATA_DRIVEN_DATA WHERE DATA_DRIVEN_IDENTIFIER = '"
					+ "" + KeyWordDrivenConstants.TC_DATA_DRIVEN_ID
					+ "' AND DATA_DRIVEN_SET_NAME = '" + ""
					+ KeyWordDrivenConstants.TC_DATA_DRIVEN_SET_NAME
					+ "' AND DATA_DRIVEN_KEY = '" + ""
					+ KeyWordDrivenConstants.TC_DATA_DRIVEN_KEY + "'";

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(Query);

			if (KeyWordDrivenConstants.debug) {

				System.out.println("Query executing = " + Query);

			}

			while (resultSet.next()) {

				data_Driven_Key_Value = resultSet
						.getString("DATA_DRIVEN_VALUE");
			}

			connection.close();

			KeyWordDrivenConstants.TC_DATA_DRIVEN_VALUE = data_Driven_Key_Value;

			returnStatus = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

			throw new BSROException(e);

		}

		return returnStatus;

	}

	public static boolean getDataDrivenExpectedResult() throws BSROException {

		boolean returnStatus = false;

		String data_Driven_Expected_Result = "";

		Connection connection = DBConnection.getConnection();

		try {

			String Query = ""
					+ "SELECT EXPECTED FROM DATA_DRIVEN_DATA WHERE DATA_DRIVEN_IDENTIFIER = '"
					+ "" + KeyWordDrivenConstants.TC_DATA_DRIVEN_ID
					+ "' AND DATA_DRIVEN_SET_NAME = '" + ""
					+ KeyWordDrivenConstants.TC_DATA_DRIVEN_SET_NAME
					+ "' AND DATA_DRIVEN_KEY = '" + ""
					+ KeyWordDrivenConstants.TC_DATA_DRIVEN_KEY + "'";

			System.out.println("Query => " + Query);

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(Query);

			if (KeyWordDrivenConstants.debug) {

				System.out.println("Query executing = " + Query);

			}

			while (resultSet.next()) {

				data_Driven_Expected_Result = resultSet.getString("EXPECTED");
			}

			resultSet.close();

			statement.close();

			connection.close();

			KeyWordDrivenConstants.TC_EXPECTED = data_Driven_Expected_Result;

			returnStatus = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

			throw new BSROException(e);

		}

		return returnStatus;

	}

}
