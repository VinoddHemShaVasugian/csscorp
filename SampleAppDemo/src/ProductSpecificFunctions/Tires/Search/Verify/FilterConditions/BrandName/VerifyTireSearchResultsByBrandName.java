package ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.BrandName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.BrandName.VerifyTireSearchResultsByBrandNameHelper;
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
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;

/**
 * Description : Functional Test Script
 * 
 * @author css89714
 */
public class VerifyTireSearchResultsByBrandName extends
		VerifyTireSearchResultsByBrandNameHelper {
	/**
	 * Script Name : <b>VerifyTireSearchResultsByBrandName</b> Generated :
	 * <b>Jul 22, 2013 1:06:11 PM</b> Description : Functional Test Script
	 * Original Host : WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/22
	 * @author css89714
	 * @throws BSROException
	 */

	public static void verify() throws BSROException {

		try {

			Framework.HtmlSelect.selectItemByID_Selenium("form-filter-sort",
					"Lowest Price");

			HtmlBrowser.waitForLoad();

			ArrayList<String> tiresListFromDBByArticleNumber = ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
					.getStandardTiresArticleListSortByPriceAsc();

			HashMap<String, String> hashMapBrandNameOptionsList = new HashMap<String, String>();

			for (int loopCount = 0; loopCount < tiresListFromDBByArticleNumber
					.size(); loopCount++) {

				String brandName = TiresSearchDBResults
						.getStandardTireResultantBrandNameByArticleNumber(tiresListFromDBByArticleNumber
								.get(loopCount));

				hashMapBrandNameOptionsList.put(brandName, brandName);

			}

			List<WebElement> brandOptions = KeyWordDrivenConstants.webDriver
					.findElements(By
							.xpath("//*[@id=\"tire-selector-filters\"]/ul[1]/li"));

			logInfo("brandOptions size  = " + brandOptions.size());

			logInfo("hashMapBrandNameList size = "
					+ hashMapBrandNameOptionsList.size());

			if (brandOptions.size() != hashMapBrandNameOptionsList.size()) {

				throw new BSROException("Check brand list filter options.");

			}

			Iterator<WebElement> brandOptionsIterator = brandOptions.iterator();

			while (brandOptionsIterator.hasNext()) {

				WebElement brandOption = (WebElement) brandOptionsIterator
						.next();

				String brandOptionName = brandOption.findElement(
						By.tagName("input")).getAttribute("value");

				brandOption.findElement(By.tagName("input")).click();

				HtmlBrowser.waitForLoad();

				ArrayList<String> tiresListFromFilterByTireNameFromWeb = ProductSpecificFunctions.Tires.Search.ByVehicle.TireSearchWebResults
						.getTireResultsListByTireName();

				ArrayList<String> tiresArticlesListFromDBFilterByBrandName = ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults
						.getStandardTiresArticleListFilterByBrandName(brandOptionName);

				logInfo("tiresListFromFilterByTireNameFromWeb = "
						+ tiresListFromFilterByTireNameFromWeb);

				logInfo("tiresArticlesListFromDBFilterByBrandName = "
						+ tiresArticlesListFromDBFilterByBrandName);

				if (tiresListFromFilterByTireNameFromWeb.size() != tiresArticlesListFromDBFilterByBrandName
						.size()) {

					throw new BSROException(
							"Check filter output resultant list.");

				}

				for (int loopIndex = 0; loopIndex < tiresArticlesListFromDBFilterByBrandName
						.size(); loopIndex++) {

					String tireArticleNumber = tiresArticlesListFromDBFilterByBrandName
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

				brandOption.findElement(By.tagName("input")).click();

				HtmlBrowser.waitForLoad();

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("VerifyTireSearchResultsByBrandName.verify() failed.");

			throw new BSROException(e);

		}

	}
}
