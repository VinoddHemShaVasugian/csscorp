package ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.StandardOptional;

import java.util.ArrayList;

import resources.ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.StandardOptional.VerifySOFilterTireSearchResultsHelper;
import Framework.BSROException;

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
public class VerifySOFilterTireSearchResults extends
		VerifySOFilterTireSearchResultsHelper {
	/**
	 * Script Name : <b>VerifySoFilterTireSearchResults</b> Generated : <b>Jul
	 * 23, 2013 8:50:17 PM</b> Description : Functional Test Script Original
	 * Host : WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/23
	 * @author css89714
	 */

	public static void verify() throws BSROException {

		try {

			ArrayList<String> tiresListFromWebByTireName = ProductSpecificFunctions.Tires.Search.ByVehicle.TireSearchWebResults
					.getTireResultsListByTireName();

			ArrayList<String> tiresListFromDBByTireNames = ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
					.getAllTiresOfSpecificTypeByName();

			logInfo("tiresListFromWebByTireName = "
					+ tiresListFromWebByTireName);

			logInfo("tiresListFromDBByArticleNuber = "
					+ tiresListFromDBByTireNames);

			logInfo("tiresListFromDBByTireNames size = "
					+ tiresListFromDBByTireNames.size());

			logInfo("tiresListFromWebByTireName size = "
					+ tiresListFromWebByTireName.size());

			if (tiresListFromDBByTireNames.size() != tiresListFromWebByTireName
					.size()) {

				throw new BSROException(
						"Tires List count did not match from web and database.");

			}

			for (int loopCount = 0; loopCount < tiresListFromWebByTireName
					.size(); loopCount++) {

				String tireNameFromWeb = tiresListFromWebByTireName
						.get(loopCount);

				String tireNameFromDB = tiresListFromDBByTireNames
						.get(loopCount);

				logInfo("tireNameFromWeb = " + tireNameFromWeb);

				logInfo("tireNameFromDB = " + tireNameFromDB);

				if (false == tiresListFromWebByTireName
						.contains(tireNameFromDB)) {

					throw new BSROException(
							"Web results dont have tire list given by db = "
									+ tireNameFromDB);

				}

			}

			logInfo("Tire Search Results sorted by lowest price verified successfully.");

		} catch (Exception e) {
			// TODO: handle exception

			logError("VerifyStandardTireSearchResultsSortByLowestPrice.verify() function failed.");

			throw new BSROException(e);
		}

	}

}
