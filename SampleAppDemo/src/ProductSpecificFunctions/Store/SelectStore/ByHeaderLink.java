package ProductSpecificFunctions.Store.SelectStore;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Store.SelectStore.ByHeaderLinkHelper;
import Framework.BSROException;
import Framework.CoreUtils;
import Framework.HtmlBrowser;
import Framework.HtmlText;
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
public class ByHeaderLink extends ByHeaderLinkHelper {
	/**
	 * Script Name : <b>ByHeaderLink</b> Generated : <b>Jul 17, 2013 3:09:14
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/17
	 * @author css89714
	 */

	public static void selectStore(String argStoreSelectionInfo)
			throws BSROException {

		String zip_state = "";

		String store_number = "";

		boolean forceSelect = false;

		int totalStoresReturnedBySearchResults = 0;

		try {

			String storeSelectionInfo = argStoreSelectionInfo;

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

				} else if (currentParam.toLowerCase().contains("forceselect")) {

					forceSelect = true;

				} else {

					throw new BSROException(
							"Invalid parameter supplied to selectStore() function.");

				}

			}

			if (false == CoreUtils.isElementPresent(By.id("header-find-store"))) {

				throw new BSROException(
						"Find a Store link will appear in header portion only when default store selecetd.");

			}

			CoreUtils.elementClickByID("header-find-store");

			HtmlBrowser.waitForLoad();

			String pageTitle = HtmlBrowser.getCurrentPageTitle();

			if (false == pageTitle
					.equals("Store Locator | Firestone Complete Auto Care")) {

				throw new Exception(
						"Store Locator page title verification failed.");

			}

			String pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.id("page-title")).getText();

			if (false == pageHeader.equals("Store Locator")) {

				throw new BSROException(
						"Store Locator page header verfication failed");

			}

			String stepTitle = KeyWordDrivenConstants.webDriver.findElement(
					By.cssSelector("#content > h2")).getText();

			if (false == stepTitle.equals("Find a Store Near You")) {

				throw new BSROException(
						"Store Locator step title verfication failed");

			}

			By address = By.id("address");

			HtmlText.setText(address, zip_state);

			CoreUtils.elementClickByID("address");

			CoreUtils.elementClickByID("locate-map-find-store-2");

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

						break;

					} else {

						loopCount += 1;

					}

				}

				if (isStoreIdentifiedByStoreNumber) {

					boolean isSetAsMyStoreButtonExist = false;

					boolean isMyStoreGreenLogoExist = false;

					boolean isTemporarlyClosedLogoExist = false;

					try {
						eachStoreContainer.get(loopCount).findElement(
								By.className("btn"));

						isSetAsMyStoreButtonExist = true;

					} catch (Exception e) {
						// TODO: handle exception

						isSetAsMyStoreButtonExist = false;
					}

					try {
						eachStoreContainer.get(loopCount).findElement(
								By.className("temporaryClosed"));

						isTemporarlyClosedLogoExist = true;

					} catch (Exception e) {
						// TODO: handle exception

						isTemporarlyClosedLogoExist = false;
					}

					try {
						eachStoreContainer.get(loopCount).findElement(
								By.className("my-store"));

						isMyStoreGreenLogoExist = true;

					} catch (Exception e) {
						// TODO: handle exception

						isMyStoreGreenLogoExist = false;
					}

					if (isSetAsMyStoreButtonExist) {

						if (eachStoreContainer.get(loopCount)
								.findElement(By.className("btn")).isDisplayed()) {

							eachStoreContainer.get(loopCount)
									.findElement(By.className("btn")).click();

							HtmlBrowser.waitForLoad();

						} else {

							throw new BSROException(
									"ByHeaderLink.selectStore() : SET AS MY STORE button is not shown for the store.");

						}

					} else if (isMyStoreGreenLogoExist) {

						if (eachStoreContainer.get(loopCount)
								.findElement(By.className("my-store"))
								.isDisplayed()) {

							logInfo("Specified store id is already set as preffered store.");

						} else {

							throw new BSROException(
									"Please check selectByStoreNumber() functionality.");

						}

					} else if (isTemporarlyClosedLogoExist) {

						throw new BSROException(
								"You cannot select temporarly closed store as default store.");

					} else {

						throw new BSROException(
								"Please check selectByStoreNumber() functionality.");
					}

					// isStoreSelectionCompleted = true;

					System.out.println("second loop break;");

					break;

				}

			}

			if (false == isStoreIdentifiedByStoreNumber) {

				throw new BSROException(
						"Store with given store number is not identified.");

			}

			HtmlBrowser.waitForLoad();

		} catch (Exception e) {
			// TODO: handle exception

			logError("ByHeaderLink.selectStore() function failed.");

			throw new BSROException(e);

		}

	}
}
