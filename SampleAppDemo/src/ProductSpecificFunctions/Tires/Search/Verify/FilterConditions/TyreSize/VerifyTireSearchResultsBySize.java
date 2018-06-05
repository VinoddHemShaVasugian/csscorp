package ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.TyreSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.TyreSize.VerifyTireSearchResultsBySizeHelper;
import Framework.BSROException;
import Framework.HtmlBrowser;
import KeyWordDriven.KeyWordDrivenConstants;
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
public class VerifyTireSearchResultsBySize extends
		VerifyTireSearchResultsBySizeHelper {
	/**
	 * Script Name : <b>VerifyTireSearchResultsBySize</b> Generated : <b>Jul 22,
	 * 2013 5:59:04 PM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/22
	 * @author css89714
	 */

	public static void verify() throws BSROException {

		try {

			Framework.HtmlSelect.selectItemByID_Selenium("form-filter-sort",
					"Lowest Price");

			HtmlBrowser.waitForLoad();

			ArrayList<String> tiresListFromDBByArticleNumber = ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
					.getStandardTiresArticleListSortByPriceAsc();

			logInfo("tiresListFromDBByArticleNumber = "
					+ tiresListFromDBByArticleNumber);

			HashMap<String, String> hashMapTyreSizeOptionsList = new HashMap<String, String>();

			for (int loopCount = 0; loopCount < tiresListFromDBByArticleNumber
					.size(); loopCount++) {

				String brandName = TiresSearchDBResults
						.getStandardTireResultantTyreSizeByArticleNumber(tiresListFromDBByArticleNumber
								.get(loopCount));

				hashMapTyreSizeOptionsList.put(brandName, brandName);

			}

			List<WebElement> filterByTyreSizeCheckBoxList = KeyWordDrivenConstants.webDriver
					.findElements(By
							.xpath("//*[@id=\"tire-selector-filters\"]/ul[4]/li"));

			logInfo("brandOptions size  = "
					+ filterByTyreSizeCheckBoxList.size());

			logInfo("hashMapBrandNameList size = "
					+ hashMapTyreSizeOptionsList.size());

			logInfo("hashMapTyreSizeOptionsList contents = "
					+ hashMapTyreSizeOptionsList);

			if (filterByTyreSizeCheckBoxList.size() != hashMapTyreSizeOptionsList
					.size()) {

				throw new BSROException("Check tyre size filter options.");

			}

			Iterator<WebElement> brandOptionsIterator = filterByTyreSizeCheckBoxList
					.iterator();

			while (brandOptionsIterator.hasNext()) {

				boolean isStandardTyres = false;

				boolean isOptionalTyres = false;

				WebElement tyreSizeOption = (WebElement) brandOptionsIterator
						.next();

				String tyreSizeOptionName = tyreSizeOption.findElement(
						By.tagName("input")).getAttribute("value");
				//
				// if (tyreSizeOptionName.toLowerCase().endsWith("xl")) {
				//
				// tyreSizeOptionName = tyreSizeOptionName.replaceAll("XL",
				// " XL");
				//
				// } else if (tyreSizeOptionName.toLowerCase().endsWith("l")) {
				//
				// tyreSizeOptionName = tyreSizeOptionName.replaceAll("L",
				// " L");
				//
				// } else if (tyreSizeOptionName.toLowerCase().endsWith("s")) {
				//
				// tyreSizeOptionName = tyreSizeOptionName.replaceAll("S",
				// " S");
				//
				// } else if (tyreSizeOptionName.toLowerCase().endsWith("m")) {
				//
				// tyreSizeOptionName = tyreSizeOptionName.replaceAll("M",
				// " M");
				//
				// } else

				logInfo("Filter option name = " + tyreSizeOptionName);

				if (tyreSizeOptionName.toLowerCase().equals("s")) {

					isStandardTyres = true;

				} else if (tyreSizeOptionName.toLowerCase().contains("o")) {

					isOptionalTyres = true;

				} else {

					throw new BSROException("UnKnown size option = "
							+ tyreSizeOptionName);

				}

				if (false == tyreSizeOption.findElement(By.tagName("input"))
						.isSelected()) {

					tyreSizeOption.findElement(By.tagName("input")).click();

				}

				HtmlBrowser.waitForLoad();

				ArrayList<String> tiresListFromFilterByTireNameFromWeb = ProductSpecificFunctions.Tires.Search.ByVehicle.TireSearchWebResults
						.getTireResultsListByTireName();

				ArrayList<String> tiresArticlesListFromDBFilterByTyreSize = null;

				if (isStandardTyres) {

					logInfo("Filter detected as standard tyres.");

					tiresArticlesListFromDBFilterByTyreSize = ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
							.getStandardTiresArticleListAvailableInStore();

				} else if (isOptionalTyres) {

					// logInfo("Filter detected as optional tyres.");
					//
					// tiresArticlesListFromDBFilterByTyreSize =
					// ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
					// .getOptionalTiresArticleListAvailableInStore();

					break;

				} else {

					logInfo("Filter detected as size based result of tyres.");

					tiresArticlesListFromDBFilterByTyreSize = ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
							.getStandardTiresArticleListFilterByTyreSize(tyreSizeOptionName);

					tiresArticlesListFromDBFilterByTyreSize
							.addAll(ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
									.getOptionalTiresArticleListFilterByTyreSize(tyreSizeOptionName));

				}

				logInfo("tiresListFromFilterByTireNameFromWeb = "
						+ tiresListFromFilterByTireNameFromWeb);

				logInfo("tiresListFromFilterByTireNameFromWeb count = "
						+ tiresListFromFilterByTireNameFromWeb.size());

				logInfo("tiresArticlesListFromDBFilterByBrandName = "
						+ tiresArticlesListFromDBFilterByTyreSize);

				logInfo("tiresArticlesListFromDBFilterByBrandName count = "
						+ tiresArticlesListFromDBFilterByTyreSize.size());

				if (tiresListFromFilterByTireNameFromWeb.size() != tiresArticlesListFromDBFilterByTyreSize
						.size()) {

					throw new BSROException(
							"Check filter output resultant list.");

				}

				for (int loopIndex = 0; loopIndex < tiresArticlesListFromDBFilterByTyreSize
						.size(); loopIndex++) {

					String tireArticleNumber = tiresArticlesListFromDBFilterByTyreSize
							.get(loopIndex);

					String tireFullName = TiresSearchDBResults
							.getStandardTireResultantNameByArticleNumber(
									tireArticleNumber).trim();

					logInfo("Verifying tire result name  = " + tireFullName);

					logInfo("tiresListFromFilterByTireNameFromWeb  = "
							+ tiresListFromFilterByTireNameFromWeb);

					if (false == tiresListFromFilterByTireNameFromWeb
							.contains(tireFullName)) {

						throw new BSROException(tireFullName
								+ " is not identified in filter result");

					}

				}

				tyreSizeOption.findElement(By.tagName("input")).click();

				isStandardTyres = false;

				isOptionalTyres = false;

				HtmlBrowser.waitForLoad();

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("VerifyTireSearchResultsByBrandName.verify() failed.");

			throw new BSROException(e);
		}

	}
}
