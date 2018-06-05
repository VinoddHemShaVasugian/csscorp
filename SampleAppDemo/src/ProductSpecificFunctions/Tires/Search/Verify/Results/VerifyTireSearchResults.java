package ProductSpecificFunctions.Tires.Search.Verify.Results;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Tires.Search.Verify.Results.VerifyTireSearchResultsHelper;
import Framework.BSROException;
import Framework.HtmlBrowser;
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
public class VerifyTireSearchResults extends VerifyTireSearchResultsHelper {
	/**
	 * Script Name : <b>VerifyTireSearchResults</b> Generated : <b>Jul 23, 2013
	 * 8:54:57 PM</b> Description : Functional Test Script Original Host : WinNT
	 * Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/23
	 * @author css89714
	 * @throws BSROException
	 */

	public static void verify() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			java.util.List<WebElement> eachTireSearchResultContainer = KeyWordDrivenConstants.webDriver
					.findElements(By
							.xpath("//div[@id='tire-selector-results']/div"));

			int searchResultsCount = eachTireSearchResultContainer.size();

			logInfo("TiresSearchResultsCountFromWeb = " + searchResultsCount);

			for (int loopIndex = 0; loopIndex < searchResultsCount; loopIndex++) {

				WebElement eachTireSearchResult = eachTireSearchResultContainer
						.get(loopIndex);

				if (eachTireSearchResult.isDisplayed()) {

					eachTireSearchResult.click();

					// Verify header link.

					try {

						String tireName = eachTireSearchResult
								.findElement(
										By.id("tire-pricing-tire-selector-result-tirecatalog"))
								.getText().trim();

						eachTireSearchResult
								.findElement(
										By.id("tire-pricing-tire-selector-result-tirecatalog"))
								.click();

						HtmlBrowser.waitForLoad();

						String pageTitle = HtmlBrowser.getCurrentPageTitle();

						if (false == pageTitle
								.contains("Firestone Complete Auto Care")) {

							throw new BSROException(
									"Failed to load tire details link when click on header link of specifc tire result");

						}

						String pageTireInfo = KeyWordDrivenConstants.webDriver
								.findElement(By.id("page-title")).getText()
								.trim();

						logInfo("tireName = " + tireName);

						logInfo("pageTireInfo = " + pageTireInfo);

						if (false == tireName.equals(pageTireInfo)) {

							throw new BSROException(
									"Tire info page header text verifiction failed.");

						}

						HtmlBrowser.backButton();

						HtmlBrowser.waitForLoad();

						eachTireSearchResultContainer = KeyWordDrivenConstants.webDriver
								.findElements(By
										.xpath("//div[@id='tire-selector-results']/div"));

					} catch (NoSuchElementException e) {
						// TODO: handle exception

						logError("Link does not found for specific tire result header.");

						continue;

					}

					// Verifying price area.

					eachTireSearchResult = eachTireSearchResultContainer
							.get(loopIndex);

					try {

						if (false == eachTireSearchResult.findElement(
								By.className("price-large")).isDisplayed()) {

							throw new BSROException(
									"Tire price area not shown.");

						}

					} catch (Exception e) {
						// TODO: handle exception

						throw new BSROException("Tire price area not exist.");

					}

					eachTireSearchResult = eachTireSearchResultContainer
							.get(loopIndex);

					try {

						if (false == eachTireSearchResult
								.findElement(
										By.id("tire-pricing-tire-selector-result-get-quote"))
								.isDisplayed()) {

							throw new BSROException(
									"Get Quote button not shown.");

						} else {

							eachTireSearchResult
									.findElement(
											By.id("tire-pricing-tire-selector-result-get-quote"))
									.click();

							HtmlBrowser.waitForLoad();

							String pageTitle = HtmlBrowser
									.getCurrentPageTitle();

							if (false == pageTitle.contains("Tire Quote:")) {

								throw new BSROException(
										"Fail to load tire quote page after click on Get Quote Button.");

							}

							String tireQuotePageHeader = KeyWordDrivenConstants.webDriver
									.findElement(
											By.xpath("//div[@id='page-header']/h1"))
									.getText();

							if (false == tireQuotePageHeader
									.contains("Tire Quote:")) {

								throw new BSROException(
										"Tire quote page header text verification failed.");

							}

							HtmlBrowser.backButton();

							HtmlBrowser.backButton();

							HtmlBrowser.waitForLoad();

							eachTireSearchResultContainer = KeyWordDrivenConstants.webDriver
									.findElements(By
											.xpath("//div[@id='tire-selector-results']/div"));

						}

					} catch (Exception e) {
						// TODO: handle exception

						throw new BSROException("Get Quote button not exist.");

					}

					try {

						eachTireSearchResult = eachTireSearchResultContainer
								.get(loopIndex);

						if (false == eachTireSearchResult.findElement(
								By.name("article")).isDisplayed()) {

							throw new BSROException(
									"Check box compare not shown.");

						}

					} catch (Exception e) {
						// TODO: handle exception

						throw new BSROException("Compare check box not exist.");

					}

					try {

						eachTireSearchResult = eachTireSearchResultContainer
								.get(loopIndex);

						if (false == eachTireSearchResult.findElement(
								By.className("tire-image")).isDisplayed()) {

							throw new BSROException(
									"Tire image panel not shown.");

						}

					} catch (Exception e) {
						// TODO: handle exception

						throw new BSROException("Tire image panel not exist.");

					}

				}

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("VerifyTireSearchResults.verify() function failed.");

			throw new BSROException(e);

		}

	}
}
