package ProductSpecificFunctions.Store.SelectStore;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Store.SelectStore.ByFooterLinkHelper;
import Framework.BSROException;
import Framework.CoreUtils;
import Framework.HtmlBrowser;
import Framework.HtmlText;
import KeyWordDriven.KeyWordDrivenConstants;


/**
 * Description : Functional Test Script
 * 
 * @author css89714
 */
public class ByFooterLink  {
	/**
	 * Script Name : <b>ByFooterLink</b> Generated : <b>Jul 17, 2013 3:09:07
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

			HtmlBrowser.waitForLoad();

			if (CoreUtils.isElementPresent(By.id("preferred-store"))) {

				//logInfo("Default store is already selected , skipping function.");

				CoreUtils.mouseOver(By.id("preferred-store"));

				HtmlBrowser.waitForElementVisible(By
						.cssSelector("span.store-number"));

				String selectedStoreNumberOnWeb = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.store-number"))
						.getText();

				//logInfo("selectedStoreNumberOnWeb = "	+ selectedStoreNumberOnWeb);

				//logInfo("expectedStoreNumberOnWeb = " + store_number);

				if (selectedStoreNumberOnWeb.trim().toLowerCase()
						.equals(store_number.toLowerCase().trim())) {

					//logInfo("User requested store already got selected.");

				} else {

					forceSelect = true;
				}

				if (false == forceSelect) {

					return;

				}

			} else {

			//	logInfo("Default store is not selected , going forward to select a store.");

			}

			//logInfo("zip_state = " + zip_state);

			//logInfo("store_number = " + store_number);

			CoreUtils.setMouseCursorPositionOutOfScreen();

			CoreUtils.elementClickByID("footer-find-store");

			HtmlText.setText(By.id("address"), zip_state);

			CoreUtils.elementClickByID("address");

			try {

				KeyWordDrivenConstants.webDriver.findElement(
						By.id("locate-find-store")).click();

			} catch (NoSuchElementException e) {
				// TODO: handle exception

				KeyWordDrivenConstants.webDriver.findElement(
						By.id("locate-map-find-store-2")).click();

			}

			HtmlBrowser.waitForLoad();

			// WebElement storeListContainer = KeyWordDrivenConstants.webDriver
			// .findElement(By.id("store-list"));

			List<WebElement> eachStoreContainer = KeyWordDrivenConstants.webDriver
					.findElements(By.xpath("//*[@id=\"store-list\"]/ul/li"));

			totalStoresReturnedBySearchResults = eachStoreContainer.size();

			//logInfo("Number Of Stores Identified = "	+ totalStoresReturnedBySearchResults);

			Iterator<WebElement> iterator = eachStoreContainer.iterator();

			boolean isStoreSelectionCompleted = false;

			boolean isStoreIdentifiedByStoreNumber = false;

			WebElement storeContainerObject = null;

			while (iterator.hasNext()) {

				storeContainerObject = (WebElement) iterator.next();

				List<WebElement> storeNumbersList = storeContainerObject
						.findElements(By.className("store-number"));

				Iterator<WebElement> iterator2 = storeNumbersList.iterator();

				// int loopCount = 0;

				isStoreIdentifiedByStoreNumber = false;

				while (iterator2.hasNext()) {

					WebElement storeNumberObject = (WebElement) iterator2
							.next();

					String storeNumber = storeNumberObject.getText();

					System.out.println(storeNumber);

					if (storeNumber.equals(store_number)) {

						isStoreIdentifiedByStoreNumber = true;

						System.out.println("first loop break;");

						// loopCount += 1;

						break;

					} else {

						// loopCount += 1;

					}

				}

				if (isStoreIdentifiedByStoreNumber) {

					boolean isSetAsMyStoreButtonExist = false;

					boolean isMyStoreGreenLogoExist = false;

					boolean isTemporarlyClosedLogoExist = false;

					try {

						storeContainerObject.findElement(By.className("btn"));

						isSetAsMyStoreButtonExist = true;

					} catch (Exception e) {
						// TODO: handle exception

						isSetAsMyStoreButtonExist = false;
					}

					try {

						storeContainerObject.findElement(By
								.className("temporaryClosed"));

						isTemporarlyClosedLogoExist = true;

					} catch (Exception e) {
						// TODO: handle exception

						isTemporarlyClosedLogoExist = false;
					}

					try {

						storeContainerObject.findElement(By
								.className("my-store"));

						isMyStoreGreenLogoExist = true;

					} catch (Exception e) {
						// TODO: handle exception

						isMyStoreGreenLogoExist = false;
					}

					if (isSetAsMyStoreButtonExist) {

						if (storeContainerObject.findElement(
								By.className("btn")).isDisplayed()) {

							storeContainerObject.findElement(
									By.className("btn")).click();

							HtmlBrowser.waitForLoad();

						} else {

							throw new BSROException(
									"ByFooterLink.selectStore() : SET AS MY STORE button is not shown for the store.");

						}

					} else if (isMyStoreGreenLogoExist) {

						if (storeContainerObject.findElement(
								By.className("my-store")).isDisplayed()) {

							//logInfo("Specified store id is already set as preffered store.");

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

					if (isStoreIdentifiedByStoreNumber) {

						System.out.println("second loop break;");

						break;
					}

				}

			}

			if (false == isStoreIdentifiedByStoreNumber) {

				throw new BSROException(
						"Store with given store number is not identified.");

			}

			HtmlBrowser.waitForLoad();

			// afterStoreSelect();

		} catch (Exception e) {
			// TODO: handle exception

			//logError("ByFooterLink.selectStore() function failed.");

			throw new BSROException(e);

		}

	}

}
