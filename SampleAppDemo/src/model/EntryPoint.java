package model;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import Database.DBConstants;
import Framework.BSROException;
import Framework.HtmlBrowser;
import Framework.UserConfig;
import KeyWordDriven.KeyWordDrivenConstants;
import KeyWordDriven.Database.DBConnection;
import KeyWordDriven.TestExecution.ActionType;
import KeyWordDriven.TestExecution.ActiveTestCases;
import KeyWordDriven.TestExecution.DataDriven;
import RQM.RQMUtils;

/**
 * Description : Functional Test Script
 * 
 * @author VenkataRaja
 */
public class EntryPoint  {
	private boolean TRUE;

	/**
	 * Script Name : <b>EntryPoint</b> Generated : <b>Jun 10, 2013 4:35:08
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/06/10
	 * @author VenkataRaja
	 */
	public void testMain(Object[] args) throws BSROException, Exception {




		boolean testMode =false;

		try {

			if (false == testMode)
			{

				try {

					try 
					{

						RQM.RQMConstants.RQM_Project_Name = DBMock.projectNames;

					} 
					catch (NullPointerException e)
					{

						//logError("RQM Param => ProjectName Missing.");

					}

					// //////////////////////////////////////////////////////////////////

					try 
					{

						RQM.RQMConstants.RQM_Browser_Type = DBConstants.Browser_Type;

					} 
					catch (NullPointerException e)
					{

						//logError("RQM Param => BrowserType Missing.");

					}

					// ////////////////////////////////////////////////////////////////////

					try 
					{

						RQM.RQMConstants.RQM_Application_URL = DBConstants.Application_URL;

					} 
					catch (NullPointerException e) 
					{

						//logError("RQM Param => ApplicationURL Missing.");
					}

					// ////////////////////////////////////////////////////////////

					try {

						RQM.RQMConstants.AutoDBHostName =DBConstants.autoDBHostName;

						DBConstants.autoDBHostName = RQM.RQMConstants.AutoDBHostName;

					} 
					catch (NullPointerException e)
					{

						//logError("RQM Param => AutoDBHost Missing.");

					}

					// ////////////////////////////////////////////////////////////////

					try 
					{

						RQM.RQMConstants.ProductDBHostName = RQM.RQMConstants.AutoDBHostName;

						DBConstants.productDBHostName = RQM.RQMConstants.ProductDBHostName;

					}
					catch (NullPointerException e) 
					{

						//logError("RQM Param => ProductDBHost Missing.");

					}

					try 
					{

						RQM.RQMConstants.AutoDBInstanceName =DBConstants.autoDBInstanceName;

						DBConstants.autoDBInstanceName = RQM.RQMConstants.AutoDBInstanceName;

					}
					catch (NullPointerException e) 
					{

						//logError("RQM Param => AutoDBInstName Missing.");

					}

					// //////////////////////////////////////////////////////////////////

					try
					{

						RQM.RQMConstants.ProductDBInstanceName =DBConstants.autoDBInstanceName;

						DBConstants.productDBInstanceName = RQM.RQMConstants.ProductDBInstanceName;

					} 
					catch (NullPointerException e) 
					{

						//logError("RQM Param => ProductDBInstName Missing.");

					}

					// ///////////////////////////////////////////////////////////////////////////

					try 
					{

						RQM.RQMConstants.AutoDBConPort = DBConstants.autoDBConnectionPort;

						DBConstants.autoDBConnectionPort = RQM.RQMConstants.AutoDBConPort;

					}
					catch (NullPointerException e)
					{

						//logError("RQM Param => AutoDBConPort Missing.");

					}

					// ///////////////////////////////////////////////////////////////////////////

					try 
					{

						RQM.RQMConstants.ProductDBConPort = DBConstants.autoDBConnectionPort;

						DBConstants.productDBConnectionPort = RQM.RQMConstants.ProductDBConPort;

					} 
					catch (NullPointerException e) 
					{

						//logError("RQM Param => ProductDBConPort Missing.");

					}

					// //////////////////////////////////////////////////////////////////////////

					KeyWordDrivenConstants.RQM_TC_NAME = RQMUtils.getTestCaseName().replaceAll("Auto-", "");

					// //////////////////////////////////////////////////////////////////////////

					KeyWordDrivenConstants.ACTIVE_PROJECT_NAME = RQM.RQMConstants.RQM_Project_Name;

					if (RQM.RQMConstants.RQM_Browser_Type.toUpperCase().equals("IE")) 
					{

						UserConfig.browserTypeToTest = 1;

					} 
					else if (RQM.RQMConstants.RQM_Browser_Type.toUpperCase().equals("FIREFOX"))
					{

						UserConfig.browserTypeToTest = 2;

					} 
					else if (RQM.RQMConstants.RQM_Browser_Type.toUpperCase().equals("CHROME"))
					{

						UserConfig.browserTypeToTest = 3;

					} 
					else 
					{

						throw new BSROException("Unknown browser type to test is defined in RQM.");

					}

					UserConfig.applicationURL = RQM.RQMConstants.RQM_Application_URL;

					try {

						if ("YES".equals("YES"))
						{
							//logInfo("Tray Notifications Enabled");

							UserConfig.showTrayNotifications = true;

						} 
						else 
						{

							UserConfig.showTrayNotifications = false;

							//logInfo("Tray Notifications Disabled");

						}

					} 
					catch (Exception e)
					{
						// TODO: handle exception
					}

					try {

						if ("YES".equals("YES")) 
						{

							//logInfo("Clear Cookies Enabled");

							UserConfig.deleteCookiesOnStartUp = true;

						} 
						else 
						{

							UserConfig.deleteCookiesOnStartUp = false;

							//logInfo("Clear Cookies Disabled");

						}

					} 
					catch (Exception e)
					{
						// TODO: handle exception
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					throw new BSROException(e);
				}
			}

			else 
			{

				// --------------- Tester Configuration

				RQM.RQMConstants.RQM_Project_Name = "FCAC-Desktop";

				RQM.RQMConstants.RQM_Browser_Type = "CHROME";

				// RQM.RQMConstants.RQM_Application_URL =
				// "http://hdc0005532.ad.csscorp.com:9083";

				RQM.RQMConstants.RQM_Application_URL = "http://qa01.firestonecompleteautocare.com";

				KeyWordDrivenConstants.RQM_TC_NAME = "FD_ScheduleAnAppointment_Linkthattakesbacktopreviouspage";

				UserConfig.deleteCookiesOnStartUp =true;

				if (RQM.RQMConstants.RQM_Browser_Type.toUpperCase().equals("IE"))
				{

					UserConfig.browserTypeToTest = 1;

				}
				else if (RQM.RQMConstants.RQM_Browser_Type.toUpperCase().equals("FIREFOX")) 
				{

					UserConfig.browserTypeToTest = 2;

				}
				else if (RQM.RQMConstants.RQM_Browser_Type.toUpperCase().equals("CHROME"))
				{
					UserConfig.browserTypeToTest = 3;

				}
				else
				{
					throw new BSROException("Unknown browser type to test is defined in RQM.");
				}

				KeyWordDrivenConstants.ACTIVE_PROJECT_NAME = RQM.RQMConstants.RQM_Project_Name;
				UserConfig.applicationURL = RQM.RQMConstants.RQM_Application_URL;

			}

			Iterator<String> iterator_Active_Test_Cases_List = ActiveTestCases.getActiveTestCasesList().iterator();

			while (iterator_Active_Test_Cases_List.hasNext()) 
			{
				KeyWordDrivenConstants.TC_ID = iterator_Active_Test_Cases_List.next().toString();

				boolean TC_IS_DATA_DRIVEN = DataDriven.isDataDriven();

				if (TC_IS_DATA_DRIVEN) {

					if (KeyWordDrivenConstants.debug)
					{

						System.out.println("invokeDataDrivenExecution method will be called.");

					}
					
					invokeDataDrivenExecution();

				} 
				else
				{

					if (KeyWordDrivenConstants.debug)
					{

						System.out.println("invokeSimplexExecution method will be called.");

					}

					invokeSimplexExecution();

				}

			}

		} 
		catch (Exception e) 
		{

			//logError("Exception from test main block.");

			try {
				if (KeyWordDrivenConstants.webDriver != null)
				{

					// KeyWordDrivenConstants.webDriver.quit();

					HtmlBrowser.killIEDriverServer();

				}
			} 
			catch (Exception e1) 
			{
				// TODO: handle exception
			}

			throw new BSROException(e);
		}

		try
		{
			if (KeyWordDrivenConstants.webDriver != null)
			{

				// KeyWordDrivenConstants.webDriver.quit();

				HtmlBrowser.killIEDriverServer();

			}
		} 
		catch (Exception e1) 
		{
			// TODO: handle exception
		}

	}

	/**
	 * @throws Exception 
	 * 
	 */
	@SuppressWarnings("unused")
	public void invokeSimplexExecution() throws Exception {

		Connection connection = DBConnection.getConnection();

		try {

			Statement statement = connection.createStatement();

			String Query = "SELECT * FROM TESTCASE_DESIGN_STEPS WHERE TC_ID = '"
					+ KeyWordDrivenConstants.TC_ID
					+ "' AND PROJECT_NAME = '"
					+ KeyWordDrivenConstants.ACTIVE_PROJECT_NAME
					+ "' AND ACTIVITY_STATE='ACTIVE' ORDER BY EXECUTION_SEQUENCE_IDENTIFIER ASC";

			if (KeyWordDrivenConstants.debug) {

				System.out.println("Query executing = " + Query);

			}

			ResultSet resultSet = statement.executeQuery(Query);

			while (resultSet.next()) {

				String TC_HTML_ELEMENT_TYPE = resultSet
						.getString("html_element_type");

				String TC_ACTION_TYPE = resultSet.getString("action_type");

				String TC_MODE_OF_OPERATION = resultSet
						.getString("mode_of_operation");

				String TC_ELEMENT_ID = "" + resultSet.getString("element_id");

				String TC_ELEMENT_CLASS_NAME = ""
						+ resultSet.getString("element_class");

				String TC_ELEMENT_CSS_CLASS_NAME = ""
						+ resultSet.getString("css_class");

				String TC_ELEMENT_CONTENT_TEXT = ""
						+ resultSet.getString("element_content_text");

				String TC_XPATH = "" + resultSet.getString("xpath");

				String TC_EXPECTED = "" + resultSet.getString("expected");

				// //////////////////////////////////////////////////////////

				KeyWordDrivenConstants.TC_EXPECTED = TC_EXPECTED;

				KeyWordDrivenConstants.TC_ACTION_TYPE = TC_ACTION_TYPE;

				KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE = TC_HTML_ELEMENT_TYPE;

				KeyWordDrivenConstants.TC_HTML_ELEMENT_ID = TC_ELEMENT_ID;

				KeyWordDrivenConstants.TC_HTML_ELEMENT_CLASS_NAME = TC_ELEMENT_CLASS_NAME;

				KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME = TC_ELEMENT_CSS_CLASS_NAME;

				KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT = TC_ELEMENT_CONTENT_TEXT;

				KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH = TC_XPATH;

				// ////////////////////////////////////////////////////////////

				// String TC_RFT_HTML_CLASS = RFT
				// .getHtmlElementClass(TC_HTML_ELEMENT_TYPE);

				System.out.println("Executing step = " + UserConfig.stepCount);

				//logInfo("Executing step = " + UserConfig.stepCount);

				if (UserConfig.showTrayNotifications) {

					try {

						String trayMessagerPath = "D:\\MICHAEL\\SampleApp\\src\\ThirdParty\\Utils\\";

						Runtime.getRuntime().exec(trayMessagerPath + "\\"
										+ "TrayMessanger.exe 7 \""
										+ KeyWordDrivenConstants.TC_ID + "\" "
										+ UserConfig.stepCount + " \""
										+ TC_ACTION_TYPE + "\"");

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}

				ActionType.doAction(TC_ACTION_TYPE);

				Framework.UserConfig.stepCount += 1;

			}

			//logInfo("TestCase Design Steps Execution Completed In Simple Execution Mode.");

			resultSet.close();

			statement.close();

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace(); // To change body of catch statement use File |
			// Settings | File Templates.

		}

	}

	public static void invokeDataDrivenExecution() throws Exception {

		// STEP :0 Identify Data Driven ID that is attached to TestCase.

		if (ActiveTestCases.getActiveTestCaseDataDrivenID()) {

			System.out
			.println("Data Driven ID that is mapped to TestCase is identified.");

		} else {

			throw new BSROException(
					"Data Driven ID that is mapped to TestCase is not identified.");

		}

		// STEP : 1 - Identify the data sets that are supplying to the test

		ArrayList<String> arrayList_DATA_DRIVEN_SETS = ActiveTestCases
				.getActiveTestCaseDataSets();

		if (arrayList_DATA_DRIVEN_SETS.size() == 0) {

			System.out
			.println("Data Driven Sets that are mapped to Active Test Case is 0.");

		}

		int data_Driven_Sets_Count = arrayList_DATA_DRIVEN_SETS.size();

		for (int data_Driven_Set_Loop_Count = 0; data_Driven_Set_Loop_Count < data_Driven_Sets_Count; data_Driven_Set_Loop_Count++) {

			Framework.UserConfig.stepCount = 1;

			String current_DATA_SET_NAME = arrayList_DATA_DRIVEN_SETS
					.get(data_Driven_Set_Loop_Count);

			//logInfo("DataSet processing = " + current_DATA_SET_NAME);

			KeyWordDrivenConstants.TC_DATA_DRIVEN_SET_NAME = current_DATA_SET_NAME;

			Connection connection = DBConnection.getConnection();

			try {

				Statement statement = connection.createStatement();

				// String Query = ""
				// + "SELECT * FROM TABLE_TESTCASE_DESIGN_STEPS WHERE TC_ID = '"
				// + "" + KeyWordDrivenConstants.TC_ID
				// + "' ORDER BY EXECUTION_SEQUENCE_IDENTIFIER ASC";

				String Query = ""
						+ "SELECT * FROM TESTCASE_DESIGN_STEPS WHERE TC_ID = '"
						+ KeyWordDrivenConstants.TC_ID
						+ "' AND PROJECT_NAME = '"
						+ KeyWordDrivenConstants.ACTIVE_PROJECT_NAME
						+ "' AND ACTIVITY_STATE='ACTIVE' ORDER BY EXECUTION_SEQUENCE_IDENTIFIER ASC";

				if (KeyWordDrivenConstants.debug) {

					System.out.println("Query executing = " + Query);

				}

				ResultSet resultSet = statement.executeQuery(Query);

				while (resultSet.next()) {

					// String TC_HTML_ELEMENT_TYPE = resultSet
					// .getString("html_element_type");
					//
					// String TC_ACTION_TYPE =
					// resultSet.getString("action_type");
					//
					// String TC_MODE_OF_OPERATION = resultSet
					// .getString("mode_of_operation");
					//
					// String TC_ELEMENT_ID = ""
					// + resultSet.getString("element_id");
					//
					// String TC_ELEMENT_CLASS_NAME = ""
					// + resultSet.getString("element_class");
					//
					// String TC_XPATH = "" + resultSet.getString("xpath");
					//
					// String TC_EXPECTED = "" +
					// resultSet.getString("expected");

					String TC_HTML_ELEMENT_TYPE = resultSet
							.getString("html_element_type");

					String TC_ACTION_TYPE = resultSet.getString("action_type");

					String TC_MODE_OF_OPERATION = resultSet
							.getString("mode_of_operation");

					String TC_ELEMENT_ID = ""
							+ resultSet.getString("element_id");

					String TC_ELEMENT_CLASS_NAME = ""
							+ resultSet.getString("element_class");

					String TC_ELEMENT_CSS_CLASS_NAME = ""
							+ resultSet.getString("css_class");

					String TC_ELEMENT_CONTENT_TEXT = ""
							+ resultSet.getString("element_content_text");

					String TC_XPATH = "" + resultSet.getString("xpath");

					String TC_EXPECTED = "" + resultSet.getString("expected");

					String TC_IS_DATA_DRIVEN_FIELD = resultSet
							.getString("data_driven_field");

					String TC_DATA_DRIVEN_VARIABLE = resultSet
							.getString("data_driven_variable");

					KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE = TC_HTML_ELEMENT_TYPE;

					KeyWordDrivenConstants.TC_HTML_ELEMENT_ID = TC_ELEMENT_ID;

					KeyWordDrivenConstants.TC_HTML_ELEMENT_CLASS_NAME = TC_ELEMENT_CLASS_NAME;

					KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME = TC_ELEMENT_CSS_CLASS_NAME;

					KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT = TC_ELEMENT_CONTENT_TEXT;

					KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH = TC_XPATH;

					KeyWordDrivenConstants.TC_EXPECTED = TC_EXPECTED;

					KeyWordDrivenConstants.TC_ACTION_TYPE = TC_ACTION_TYPE;

					KeyWordDrivenConstants.TC_DATA_DRIVEN_FIELD = TC_IS_DATA_DRIVEN_FIELD;

					KeyWordDrivenConstants.TC_DATA_DRIVEN_KEY = TC_DATA_DRIVEN_VARIABLE;

					if (KeyWordDrivenConstants.TC_DATA_DRIVEN_FIELD
							.equals("YES")) {

						if (false == ActiveTestCases.getDataDrivenValue()) {

							throw new BSROException(
									"Unable to retrieve key value for current step execution.");

						}

						if (false == ActiveTestCases
								.getDataDrivenExpectedResult()) {

							throw new BSROException(
									"Unable to retrieve expected result for current step execution.");

						}

					}

					// String TC_RFT_HTML_CLASS = RFT
					// .getHtmlElementClass(TC_HTML_ELEMENT_TYPE);

					System.out.println("Executing step = "
							+ UserConfig.stepCount);

					//logInfo("Executing step = " + UserConfig.stepCount);

					if (UserConfig.showTrayNotifications) {

						try {

							String trayMessagerPath = new File(".")
							.getCanonicalPath() + "\\ThirdParty\\Utils";

							Runtime.getRuntime().exec(
									trayMessagerPath + "\\"
											+ "TrayMessanger.exe 7 \""
											+ KeyWordDrivenConstants.TC_ID
											+ "\" " + UserConfig.stepCount
											+ " \"" + TC_ACTION_TYPE + "\"");

						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}

					}

					ActionType.doAction(TC_ACTION_TYPE);

					Framework.UserConfig.stepCount += 1;

				}

				connection.close();

			} catch (SQLException e) {

				e.printStackTrace(); // To change body of catch statement use
				// File |
				// Settings | File Templates.
			}

		}

		//logInfo("TestCase Design Steps Execution Completed In Data Driven Execution Mode.");

	}
}
