package ProductSpecificFunctions.Tires.Search.Verify.Sort;

import java.util.ArrayList;

import resources.ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsSortByLowestPriceHelper;
import Framework.BSROException;
import ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults;

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
public class VerifyTireSearchResultsSortByLowestPrice extends
		VerifyTireSearchResultsSortByLowestPriceHelper {
	/**
	 * Script Name : <b>VerifyTireSearchResultsSortByLowestPrice</b> Generated :
	 * <b>Jul 22, 2013 3:59:07 PM</b> Description : Functional Test Script
	 * Original Host : WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/22
	 * @author css89714
	 */

	public static void verify() throws BSROException {

		try {

			ArrayList<String> tiresListFromWebByTireName = ProductSpecificFunctions.Tires.Search.ByVehicle.TireSearchWebResults
					.getTireResultsListByTireName();

			ArrayList<String> tiresListFromDBByArticleNumber = ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
					.getStandardTiresArticleListSortByPriceAsc();

			logInfo("tiresListFromWebByTireName = "
					+ tiresListFromWebByTireName);

			logInfo("tiresListFromDBByArticleNuber = "
					+ tiresListFromDBByArticleNumber);

			if (tiresListFromDBByArticleNumber.size() != tiresListFromWebByTireName
					.size()) {

				throw new BSROException(
						"Tires List count did not match from web and database.");

			}

			for (int loopCount = 0; loopCount < tiresListFromWebByTireName
					.size(); loopCount++) {

				String tireNameFromWeb = tiresListFromWebByTireName
						.get(loopCount);

				String tireNameFromDB = tiresListFromDBByArticleNumber
						.get(loopCount);

				tireNameFromDB = TiresSearchDBResults
						.getStandardTireResultantNameByArticleNumber(
								tireNameFromDB).trim();

				logInfo("tireNameFromWeb = " + tireNameFromWeb);

				logInfo("tireNameFromDB = " + tireNameFromDB);

				if (false == tiresListFromWebByTireName.contains(tireNameFromDB)) {

					throw new BSROException(tireNameFromDB
							+ " is not displayed in web layer.");
				}

				if (false == tireNameFromWeb.equals(tireNameFromDB)) {

					throw new BSROException(
							"Tires Sorting List Sequence did not match.");

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
