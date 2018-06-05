package ProductSpecificFunctions.Store.SelectStore;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Store.SelectStore.ByScheduleAppointmentFunnelHelper;
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
public class ByScheduleAppointmentFunnel extends
		ByScheduleAppointmentFunnelHelper {
	/**
	 * Script Name : <b>ByScheduleAppointmentFunnel</b> Generated : <b>Jul 18,
	 * 2013 11:52:12 AM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/18
	 * @author css89714
	 */

	public static void selectStore(String argStoreSelectionInfo)
			throws BSROException {

		String zip_state = "";

		String store_number = "";

		int totalStoresReturnedBySearchResults = 0;

		boolean isStoreIdentifiedByStoreNumber = false;

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

				} else {

					throw new BSROException(
							"Invalid parameter supplied to selectStore() function.");

				}

			}

			if (true == CoreUtils.isElementPresent(By.id("header-find-store"))) {

				throw new BSROException(
						"You can select store via schedule an appointment funnel when default store is not selected.");

			}

			CoreUtils.elementClickByID("header-schedule-appointment");

			HtmlBrowser.waitForLoad();

			String pageTitle = HtmlBrowser.getCurrentPageTitle();

			if (false == pageTitle
					.equals("Schedule an Appointment | Firestone Complete Auto Care")) {

				throw new Exception(
						"Schedule an appointment page title verification failed.");

			}

			String pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.id("page-title")).getText();

			if (false == pageHeader.equals("Schedule an Appointment")) {

				throw new BSROException(
						"Store Locator page header verfication failed");

			}

			CoreUtils.elementClickByID("input-location");

			CoreUtils.elementClickByID("appointment-schedule-appointment-2");

			HtmlBrowser.waitForLoad();

			pageTitle = HtmlBrowser.getCurrentPageTitle();

			if (false == pageTitle
					.equals("Schedule an Appointment | Firestone Complete Auto Care")) {

				throw new Exception(
						"Schedule an appointment page title verification failed.");

			}

			pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.id("page-title")).getText();

			if (false == pageHeader.equals("Schedule an Appointment")) {

				throw new BSROException(
						"Store Locator page header verfication failed");

			}

			String stepTitle = KeyWordDrivenConstants.webDriver.findElement(
					By.cssSelector("h2.step-title")).getText();

			if (false == stepTitle
					.equals("What Store Location Do You Want to Visit?")) {

				throw new BSROException(
						"Store Locator step title verfication failed");

			}

			By address = By.id("input-location");

			HtmlText.setText(address, zip_state);

			CoreUtils.elementClickByID("input-location");

			CoreUtils.elementClickByID("store-selector-submit");

			HtmlBrowser.waitForLoad();

			pageTitle = HtmlBrowser.getCurrentPageTitle();

			if (false == pageTitle
					.equals("Schedule an Appointment | Firestone Complete Auto Care")) {

				throw new Exception(
						"Schedule an appointment page title verification failed.");

			}

			pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.id("page-title")).getText();

			if (false == pageHeader.equals("Schedule an Appointment")) {

				throw new BSROException(
						"Store Locator page header verfication failed");

			}

			stepTitle = KeyWordDrivenConstants.webDriver.findElement(
					By.cssSelector("h2.step-title")).getText();

			if (false == stepTitle
					.equals("What Store Location Do You Want to Visit?")) {

				throw new BSROException(
						"Store Locator step title verfication failed");

			}

			List<WebElement> eachStoreContainer = KeyWordDrivenConstants.webDriver
					.findElements(By.xpath("//*[@id=\"store-list\"]/ul/li"));

			totalStoresReturnedBySearchResults = eachStoreContainer.size();

			logInfo("Number Of Stores Identified = "
					+ totalStoresReturnedBySearchResults);

			if (totalStoresReturnedBySearchResults != BLFunctions.BLRulesData.StoreList.storeListCountServiceFunnel) {

				throw new BSROException(
						"totalStoresReturnedBySearchResults is not matched with BLRules Store list count.");

			}

			Iterator<WebElement> iterator = eachStoreContainer.iterator();

			while (iterator.hasNext()) {

				WebElement storeContainerObject = (WebElement) iterator.next();

				List<WebElement> storeNumbersList = storeContainerObject
						.findElements(By.className("store-number"));

				Iterator<WebElement> iterator2 = storeNumbersList.iterator();

				int loopCount = 0;

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
									"ByScheduleAppointmentFunnel.selectStore() : SET AS MY STORE button is not shown for the store.");

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

			pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.id("page-title")).getText();

			if (false == pageHeader.equals("Schedule an Appointment")) {

				throw new BSROException(
						"Schedule an Appointment page header verfication failed");

			}

			stepTitle = KeyWordDrivenConstants.webDriver.findElement(
					By.cssSelector("h2.step-title")).getText();

			logInfo("Actual Step Title = " + stepTitle);

			logInfo("Expected Step Title = Provide Contact Information");

			if (false == stepTitle.equals("Provide Contact Information")) {

				throw new BSROException(
						"Schedule an Appointment step title verfication failed");

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("ByScheduleAppointmentFunnel.selectStore() function failed.");

			throw new BSROException(e);

		}

	}

}
