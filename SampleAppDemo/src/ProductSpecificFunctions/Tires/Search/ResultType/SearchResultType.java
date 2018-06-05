package ProductSpecificFunctions.Tires.Search.ResultType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Tires.Search.ResultType.SearchResultTypeHelper;
import Framework.BSROException;
import Framework.CoreUtils;
import Framework.HtmlBrowser;
import Framework.HtmlCheckBox;
import KeyWordDriven.KeyWordDrivenConstants;

import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;

/**
 * Description : Functional Test Script
 * 
 * @author css89714
 */
public class SearchResultType extends SearchResultTypeHelper {

	private static String vehicleMake;

	private static String vehicleYear;

	private static String vehicleModel;

	private static String vehicleSubModel;

	private static String vehicleTyresType;

	/**
	 * Script Name : <b>SearchResultType</b> Generated : <b>Jul 22, 2013
	 * 11:08:54 AM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/22
	 * @author css89714
	 * @throws BSROException
	 */

	public static void selectResultType() throws BSROException {

		try {

			String resultType = "";

			String arg = KeyWordDrivenConstants.TC_EXPECTED;

			String args[] = arg.split(";");

			for (int loopCount = 0; loopCount < args.length; loopCount++) {

				String currentArg = args[loopCount].toLowerCase();

				if (currentArg.startsWith("year")) {

					vehicleYear = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");
				} else if (currentArg.startsWith("manufacturer")) {

					vehicleMake = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");
				} else if (currentArg.startsWith("model")) {

					vehicleModel = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");
				} else if (currentArg.startsWith("submodel")) {

					vehicleSubModel = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");
				} else if (currentArg.startsWith("tyrestype")) {

					vehicleTyresType = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");
				} else if (currentArg.startsWith("resulttype")) {

					resultType = currentArg.substring(
							currentArg.indexOf("=") + 1).replaceAll(";", "");

				}

			}

			if (resultType.isEmpty()) {

				throw new BSROException("selectResultType() has invalid input.");

			}

			Connection connection = Database.ProductDBConnection.getConnection(
					"BFS_TIRE_SELECTOR", "BFS_TIRE_SELECTOR");

			Statement statement = connection.createStatement();

			String Query = "select COUNT (STANDARD_IND) from BFS_TIRE_SELECTOR.FITMENT where model_year= '"
					+ ""
					+ vehicleYear
					+ "' and make_name = '"
					+ ""
					+ vehicleMake
					+ "' and model_name = '"
					+ ""
					+ vehicleModel
					+ "' and submodel = '" + "" + vehicleSubModel + "'";

			logInfo(Query);

			ResultSet resultSet = statement.executeQuery(Query);

			boolean hasOptionalTyres = false;

			while (resultSet.next()) {

				String rt = resultSet.getString("COUNT(STANDARD_IND)").trim();

				if (rt.equals("2")) {

					hasOptionalTyres = true;

				}

			}

			logInfo("hasOptionalTyres = " + hasOptionalTyres);

			if (false == hasOptionalTyres
					&& resultType.toUpperCase().equals("OPTIONAL")) {

				throw new BSROException("Search result has no optional tyres.");

			}

			if (hasOptionalTyres) {

				HtmlBrowser.waitForLoad();

				String pageTitle = HtmlBrowser.getCurrentPageTitle();

				if (false == pageTitle
						.equals("Standard or Optional Tire Sizes | Firestone Complete Auto Care")) {

					throw new BSROException(
							"Tire search result type select page not loaded.");

				}

				if (false == CoreUtils.isElementVisible(By
						.className("tire-size-list"))) {

					throw new BSROException(
							"Tire Search Result Type Selection Panel is not identified.");

				}

				logInfo("resultTypeSelectedByUser = " + resultType);

				if (resultType.toUpperCase().equals("STANDARD")) {

					CoreUtils.elementClickByID("standard-tires");

					HtmlBrowser.waitForLoad();

					pageTitle = HtmlBrowser.getCurrentPageTitle();

					if (false == pageTitle.contains("Tires:")) {

						throw new BSROException(
								"Standard Tyre Search Results Page Not Loaded.");

					}

					logInfo("Checkbox1 - "
							+ HtmlCheckBox.getCheckedState(By.id("STDOPT_0")));

					logInfo("Checkbox2 - "
							+ HtmlCheckBox.getCheckedState(By.id("STDOPT_1")));

					if (true == HtmlCheckBox.getCheckedState(By.id("STDOPT_0"))
							&& false == HtmlCheckBox.getCheckedState(By
									.id("STDOPT_1"))) {

					} else {

						throw new BSROException(
								"Verify checkbox states of standard tires search result types.");

					}

				} else if (resultType.toUpperCase().equals("OPTIONAL")) {

					CoreUtils.elementClickByID("optional-tires");

					HtmlBrowser.waitForLoad();

					pageTitle = HtmlBrowser.getCurrentPageTitle();

					if (false == pageTitle.contains("Tires for Your")) {

						throw new BSROException(
								"Optional Tyre Search Results Page Not Loaded.");

					}

					logInfo("Checkbox1 - "
							+ HtmlCheckBox.getCheckedState(By.id("STDOPT_0")));

					logInfo("Checkbox2 - "
							+ HtmlCheckBox.getCheckedState(By.id("STDOPT_1")));

					if (false == HtmlCheckBox
							.getCheckedState(By.id("STDOPT_0"))
							&& true == HtmlCheckBox.getCheckedState(By
									.id("STDOPT_1"))) {

					} else {

						throw new BSROException(
								"Verify checkbox states of search result types.");

					}

				} else {

					throw new BSROException("Invalid Search Result Type.");
				}

			} else {
				String currentPageTitle = HtmlBrowser.getCurrentPageTitle();

				if (false == currentPageTitle.startsWith("Tires:")) {

					logError("Tires Result Page Not Loaded.");

					throw new BSROException("Tires Result Page Not Loaded.");

				}
			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("selectResultType() function failed.");

			throw new BSROException(e);

		}

	}

}
