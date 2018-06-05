package ProductSpecificFunctions.Tires.Search.Verify.PerformanceRatings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Tires.Search.Verify.PerformanceRatings.VerifyPerformanceRatingsHelper;
import Framework.BSROException;
import Framework.CoreUtils;
import Framework.HtmlBrowser;
import KeyWordDriven.KeyWordDrivenConstants;
import ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults;

import com.opera.core.systems.scope.services.Core;
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
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;

/**
 * Description : Functional Test Script
 * 
 * @author css89714
 */
public class VerifyPerformanceRatings extends VerifyPerformanceRatingsHelper {
	/**
	 * Script Name : <b>VerifyPerformanceRatings</b> Generated : <b>Jul 22, 2013
	 * 9:43:08 PM</b> Description : Functional Test Script Original Host : WinNT
	 * Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/22
	 * @author css89714
	 */

	public static void verify() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			java.util.List<WebElement> eachTireSearchResultContainer = KeyWordDrivenConstants.webDriver
					.findElements(By
							.xpath("//div[@id='tire-selector-results']/div"));

			int searchResultsCount = eachTireSearchResultContainer.size();

			logInfo("TiresSearchResultsCountFromWeb = " + searchResultsCount);

			Iterator<WebElement> iterator = eachTireSearchResultContainer
					.iterator();

			while (iterator.hasNext()) {

				WebElement eachTireSearchResult = (WebElement) iterator.next();

				if (eachTireSearchResult.isDisplayed()) {

					eachTireSearchResult.click();

					String tireNameFromWeb = eachTireSearchResult
							.findElement(
									By.id("tire-pricing-tire-selector-result-tirecatalog"))
							.getText();

					String tireSalesLine = tireNameFromWeb.substring(
							tireNameFromWeb.indexOf(" ")).trim();

					boolean hasTireRatings = false;

					WebElement tirePerformanceRatingWidget = null;

					try {

						tirePerformanceRatingWidget = eachTireSearchResult
								.findElement(By.className("tire-ratings"));

						hasTireRatings = true;

					} catch (Exception e) {
						// TODO: handle exception
					}

					HashMap<String, String> performanceRatingsDB = TiresSearchDBResults
							.getTirePerformanceResultsByName(tireSalesLine);

					boolean hasPerformceRatingsInDB = false;

					if (performanceRatingsDB != null) {

						hasPerformceRatingsInDB = true;
					}

					if (hasPerformceRatingsInDB != hasTireRatings) {

						throw new BSROException(
								"Tire performance ratings not shown for tire even when they are in database.");

					}

					if (hasTireRatings) {

						tirePerformanceRatingWidget.click();

						List<WebElement> listElements = tirePerformanceRatingWidget
								.findElements(By.tagName("li"));

						Iterator<WebElement> iterator_List_Element = listElements
								.iterator();

						String wetRating = "";

						String dryRating = "";

						String winterRating = "";

						String comfortRating = "";

						String treadWearRating = "";

						while (iterator_List_Element.hasNext()) {

							WebElement liWebElement = (WebElement) iterator_List_Element
									.next();

							String elementText = liWebElement.getText()
									.replaceAll("\\r\\n|\\r|\\n", " ");

							logInfo("liWebElement content = " + elementText);

							if (elementText.contains("Wet")) {

								wetRating = elementText.replaceAll("Wet", "")
										.trim();

							} else if (elementText.contains("Dry")) {

								dryRating = elementText.replaceAll("Dry", "")
										.trim();

							} else if (elementText.contains("Comfort")) {

								comfortRating = elementText.replaceAll(
										"Comfort", "").trim();

							} else if (elementText.contains("Winter/Snow")) {

								winterRating = elementText.replaceAll(
										"Winter/Snow", "").trim();

							} else if (elementText.contains("Treadwear")) {

								treadWearRating = elementText.replaceAll(
										"Treadwear", "").trim();

							}

							String performanceKey = "";

							if (elementText.toLowerCase().contains("wet")) {

								performanceKey = "wet";

							} else if (elementText.toLowerCase()
									.contains("dry")) {

								performanceKey = "dry";

							} else if (elementText.toLowerCase().contains(
									"comfort")) {

								performanceKey = "comfort";

							} else if (elementText.toLowerCase().contains(
									"winter")) {

								performanceKey = "winter";

							} else if (elementText.toLowerCase().contains(
									"treadwear")) {

								performanceKey = "treadwear";

							}

							if (performanceKey.equals("wet")) {

								logInfo("Wet-DB = "
										+ performanceRatingsDB
												.get(performanceKey));

								logInfo("Wet-Web = " + wetRating);

								if (false == performanceRatingsDB.get(
										performanceKey).equals(wetRating)) {

									logError("Wet rating comparision failed.");

								}

							} else if (performanceKey.equals("dry")) {

								logInfo("Dry-DB = "
										+ performanceRatingsDB
												.get(performanceKey));

								logInfo("Dry-Web = " + dryRating);

								if (false == performanceRatingsDB.get(
										performanceKey).equals(dryRating)) {

									logError("Dry rating comparision failed.");

								}

							} else if (performanceKey.equals("comfort")) {

								logInfo("Comfort-DB = "
										+ performanceRatingsDB
												.get(performanceKey));

								logInfo("Comfort-Web = " + comfortRating);

								if (false == performanceRatingsDB.get(
										performanceKey).equals(comfortRating)) {

									logError("Comfort rating comparision failed.");

								}

							} else if (performanceKey.equals("winter")) {

								logInfo("Winter-DB = "
										+ performanceRatingsDB
												.get(performanceKey));

								logInfo("Winter-Web = " + winterRating);

								if (false == performanceRatingsDB.get(
										performanceKey).equals(winterRating)) {

									logError("Winter rating comparision failed.");

								}

							} else if (performanceKey.equals("treadwear")) {

								logInfo("TreadWear-DB = "
										+ performanceRatingsDB
												.get(performanceKey));

								logInfo("TreadWear-Web = " + treadWearRating);

								if (false == performanceRatingsDB.get(
										performanceKey).equals(treadWearRating)) {

									logError("Winter rating comparision failed.");

								}

							}

						}

					} else {

						logInfo(tireSalesLine + " has no performance ratings.");

					}

				}

			}

			logInfo("Tire performace rating results verification success.");

		} catch (Exception e) {
			// TODO: handle exception

			logError("VerifyPerformanceRatings.verify() function failed.");

			throw new BSROException(e);

		}

	}

}
