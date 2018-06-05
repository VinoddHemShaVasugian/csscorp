package ProductSpecificFunctions.Store.GetDirections;

import java.util.Iterator;
import java.util.List;

import org.bouncycastle.math.ec.ECAlgorithms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Store.GetDirections.DirectionsForSpecificStoreHelper;
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
public class DirectionsForSpecificStore extends
		DirectionsForSpecificStoreHelper {
	/**
	 * Script Name : <b>GetDirectionsForSpecificStore</b> Generated : <b>Jul 17,
	 * 2013 5:38:24 PM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/17
	 * @author css89714
	 * @throws BSROException
	 */

	public static void gotoDirectionsPage(String argStoreInfo)
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

			if (totalStoresReturnedBySearchResults == 0) {

				throw new BSROException("No Search Results Identified.");
			}

			Iterator<WebElement> iterator = eachStoreContainer.iterator();

			boolean isStoreSelectionCompleted = false;

			boolean isStoreIdentifiedByStoreNumber = false;

			int iGetDirectionsPosition = 0;

			WebElement storeContainerObject = null;

			while (iterator.hasNext()) {

				storeContainerObject = (WebElement) iterator.next();

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

						// loopCount += 1;
						iGetDirectionsPosition = iGetDirectionsPosition + 1;

						System.out.println("first loop break;"
								+ iGetDirectionsPosition);

						break;

					} else {

						// loopCount += 1;

					}

					loopCount++;

				}

				logInfo("Store Position :" + iGetDirectionsPosition);

				if (isStoreIdentifiedByStoreNumber
						&& iGetDirectionsPosition > 0) {

					logInfo("Specific store with given store number is identified.");

					WebElement exactStoreContainer = storeContainerObject;

					exactStoreContainer.findElement(
							By.xpath("//a[@id='locate-map-get-directions-"
									+ (iGetDirectionsPosition + 1) + "']"))
							.click();

					HtmlBrowser.waitForLoad();

					String currentPageTitle = HtmlBrowser.getCurrentPageTitle();

					logInfo("Current page title displayed as " +currentPageTitle);
					
					logInfo("Store Locator | " 
							+ store_number + " | Firestone Complete Auto Care");
					
					if (false == currentPageTitle.equals("Store Locator | " 
							+ store_number + " | Firestone Complete Auto Care")) {
						
						//Store Locator | Store # 930 | Firestone Complete Auto Care
						throw new BSROException(
								"Get Directions page title verification failed.");
						

					} else {

						logInfo("Store Locator page loaded successfully.");

						break;

					}

				}

			}

			if (false == isStoreIdentifiedByStoreNumber) {

				throw new BSROException(
						"Store with given store number is not identified.");

			}

			HtmlBrowser.waitForLoad();

			String storeNumber_locator_page = KeyWordDrivenConstants.webDriver
					.findElement(By.cssSelector("span.adr > span.store-number"))
					.getText();

			logInfo("store_number = " + store_number);

			logInfo("storeNumber_locator_page = " + storeNumber_locator_page);

			if (false == storeNumber_locator_page.equals(store_number)) {

				throw new BSROException(
						"Selected store from find store funnel is not choosen by store selector.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("gotoDirectionsPage() function failed.");

			throw new BSROException(e);

		}

	}
}
