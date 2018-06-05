package ProductSpecificFunctions.Tires.Search.Verify.Compare;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Tires.Search.Verify.Compare.verifyTireComparisionResultHelper;
import Framework.BSROException;
import Framework.CoreUtils;
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
public class verifyTireComparisionResult extends
		verifyTireComparisionResultHelper {
	/**
	 * Script Name : <b>verifyTireComparisionResult</b> Generated : <b>Jul 22,
	 * 2013 8:28:52 PM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/22
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

			Iterator<WebElement> iterator = eachTireSearchResultContainer
					.iterator();

			int compareSelectionLoopCount = 0;

			while (iterator.hasNext()) {

				WebElement eachTireSearchResult = (WebElement) iterator.next();

				if (eachTireSearchResult.isDisplayed()) {

					eachTireSearchResult.click();

					WebElement checkBox = eachTireSearchResult.findElement(By
							.className("form-checkbox"));

					checkBox.click();

					compareSelectionLoopCount += 1;

					if (compareSelectionLoopCount == 2) {

						break;

					}

				}

			}

			CoreUtils.elementClickByXPath("//input[@value='Compare']");

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.TC_EXPECTED = "YES";

			HtmlBrowser.waitForElementVisible(By
					.xpath("//iframe[contains(@id,'fancybox-frame')]"));

			HtmlBrowser.switchToIFrame(By
					.xpath("//iframe[contains(@id,'fancybox-frame')]"));

			String pageTitle_TireCompare = KeyWordDrivenConstants.webDriver
					.findElement(By.id("page-title")).getText();

			if (false == pageTitle_TireCompare.equals("Tire Compare")) {

				throw new BSROException(
						" Tire compare popup page title comparision failed.");

			}

			if (false == CoreUtils
					.isElementVisible(By.id("table-tire-compare"))) {

				throw new BSROException(
						"Tire comparision result report table not shown.");

			}

			HtmlBrowser.switchToDefaultFrame();

			CoreUtils.elementClickByCssPath("a.fancybox-item.fancybox-close");

			KeyWordDrivenConstants.TC_EXPECTED = "NO";

			HtmlBrowser.waitForElementVisible(By
					.xpath("//iframe[contains(@id,'fancybox-frame')]"));

			if (true == CoreUtils.isElementVisible(By
					.id("//iframe[contains(@id,'fancybox-frame')]"))) {

				throw new BSROException(
						"Tire comparision result popup is not closed as expected after click on close icon.");

			}

			logInfo("Tire search result comparision success.");

		} catch (Exception e) {
			// TODO: handle exception

			logError("verifyTireComparisionResult.verify() function failed.");

			throw new BSROException(e);

		}

	}

}
