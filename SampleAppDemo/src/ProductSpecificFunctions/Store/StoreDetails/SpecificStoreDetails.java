package ProductSpecificFunctions.Store.StoreDetails;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Store.StoreDetails.SpecificStoreDetailsHelper;
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
public class SpecificStoreDetails extends SpecificStoreDetailsHelper {
	/**
	 * Script Name : <b>GetSpecificStoreDetails</b> Generated : <b>Jul 17, 2013
	 * 5:38:33 PM</b> Description : Functional Test Script Original Host : WinNT
	 * Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/17
	 * @author css89714
	 * @throws BSROException
	 */

	public static void gotoStoreDetailsPage(String argStoreInfo)
			throws BSROException {

		String zip_state = "";

		String store_number = "";

		boolean forceSelect = false;

		int totalStoresReturnedBySearchResults = 0;

		try {

			String storeSelectionInfo = argStoreInfo;

			String[] storeSelectionParams = storeSelectionInfo.split(";");

			if (storeSelectionParams.length == 0) {

				throw new BSROException(
						"Required Input is provided to selectStore() function.");
			}

			for (int i = 0; i < storeSelectionParams.length; i++) {

				String currentParam = storeSelectionParams[i];

				if (currentParam.contains("Zip(or)State")) {

					zip_state = currentParam.substring(
							currentParam.indexOf("=") + 1,
							currentParam.length());
				} else if (currentParam.contains("StoreNumber")) {

					store_number = currentParam.substring(
							currentParam.indexOf("=") + 1,
							currentParam.length());

				} else {

					throw new BSROException(
							"Invalid parameter supplied to selectStore() function.");

				}

			}

			HtmlBrowser.waitForLoad();

			List<WebElement> eachStoreContainer = KeyWordDrivenConstants.webDriver
					.findElements(By.xpath("//*[@id=\"store-list\"]/ul/li"));

			totalStoresReturnedBySearchResults = eachStoreContainer.size();

			logInfo("Number Of Stores Identified = "
					+ totalStoresReturnedBySearchResults);

			Iterator<WebElement> iterator = eachStoreContainer.iterator();

			boolean isStoreSelectionCompleted = false;

			boolean isStoreIdentifiedByStoreNumber = false;

			while (iterator.hasNext()) {

				WebElement storeContainerObject = (WebElement) iterator.next();

				List<WebElement> storeNumbersList = storeContainerObject
						.findElements(By.className("store-number"));

				Iterator<WebElement> iterator2 = storeNumbersList.iterator();

				int loopCount = 0;

				isStoreIdentifiedByStoreNumber = false;

				while (iterator2.hasNext()) {

					WebElement storeNumberObject = (WebElement) iterator2
							.next();

					String storeNumber = storeNumberObject.getText();

					System.out.println(storeNumber);

					if (storeNumber.equals(store_number)) {

						isStoreIdentifiedByStoreNumber = true;

						System.out.println("first loop break;");

						loopCount += 1;

						break;

					} else {

						loopCount += 1;

					}

				}

				if (isStoreIdentifiedByStoreNumber) {

					logInfo("Specific store with given store number is identified.");

					WebElement exactStoreContainer = eachStoreContainer
							.get(loopCount);

					exactStoreContainer.findElement(
							By.linkText("Store Details & Offers")).click();

					HtmlBrowser.waitForLoad();

					String currentPageTitle = HtmlBrowser.getCurrentPageTitle();

					if (false == currentPageTitle
							.contains("Firestone Complete Auto Care")) {

						throw new BSROException(
								"Store Details page title verification failed.");

					} else {

						break;

					}

				}

			}

			if (false == isStoreIdentifiedByStoreNumber) {

				throw new BSROException(
						"Store with given store number is not identified.");

			}

			HtmlBrowser.waitForLoad();

			String storeNumber_StoreDetails_Page = KeyWordDrivenConstants.webDriver
					.findElement(By.cssSelector("div.store-number")).getText()
					.replaceAll("\\r\\n|\\r|\\n", " ");

			logInfo("store_number = " + store_number);

			logInfo("storeNumber_StoreDetails_Page = "
					+ storeNumber_StoreDetails_Page);

			if (false == storeNumber_StoreDetails_Page.equals(store_number)) {

				throw new BSROException(
						"Store Number selected in find a store funnel is not choosen by store details page.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("gotoStoreDetailsPage() function failed.");

			throw new BSROException(e);

		}
	}
}
