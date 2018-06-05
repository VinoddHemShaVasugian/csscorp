package BLFunctions.BLVerification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import resources.BLFunctions.BLVerification.StoreListHelper;
import sun.awt.SunHints.Key;
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
public class StoreList extends StoreListHelper {
	/**
	 * Script Name : <b>StoreList</b> Generated : <b>Jul 15, 2013 11:41:27
	 * AM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/15
	 * @author css89714
	 * @throws BSROException
	 */

	public static void setPreferedStoreFromPageHeader() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			String argData = KeyWordDrivenConstants.TC_EXPECTED;

			String[] args = argData.split(";");

			if (args.length != 1) {

				throw new BSROException(
						"Invalid arguments passed to setDefualtStoreFromPageHeader();");

			}

			String address = "";

			for (int loopCount = 0; loopCount < args.length; loopCount++) {

				if (args[loopCount].startsWith("address")) {

					address = args[loopCount].substring(args[loopCount]
							.indexOf("=") + 1);

				}

			}

			KeyWordDrivenConstants.webDriver.findElement(
					By.id("header-logo-home")).click();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(
					By.id("footer-find-store")).click();

			HtmlBrowser.waitForLoad();

			WebElement addressInputElement = KeyWordDrivenConstants.webDriver
					.findElement(By.id("navZip"));

			addressInputElement.sendKeys(address);

			WebElement submitButton = KeyWordDrivenConstants.webDriver
					.findElement(By.id("header-find-store-2"));

			submitButton.click();

			HtmlBrowser.waitForLoad();

			HashMap<String, String> storeDetails = BLFunctions.ExpectedData.StoreList
					.getNearestStoreDetails(address);

			logInfo("storeDetails = " + storeDetails);

			logInfo("storeDetails Size = " + storeDetails.size());

			if (storeDetails.size() == 0) {

				throw new BSROException("address= " + address
						+ " has no results . might be invalid input data");

			}

			// String actualStorePhoneNumber = BLFunctions.ActualData.StoreList
			// .getPrefferedStorePhoneFromHeader();
			//
			// String expectedStorePhoneNumber = storeDetails.get("PHONE");
			//
			// expectedStorePhoneNumber =
			// expectedStorePhoneNumber.replaceAll(" ",
			// "-");
			//
			// expectedStorePhoneNumber = expectedStorePhoneNumber.replaceAll(
			// "\\(", "");
			//
			// expectedStorePhoneNumber = expectedStorePhoneNumber.replaceAll(
			// "\\)", "");
			//
			// logInfo("actualStorePhoneNumber = " + actualStorePhoneNumber);
			//
			// logInfo("expectedStorePhoneNumber = " +
			// expectedStorePhoneNumber);
			//
			// if (actualStorePhoneNumber.equals(expectedStorePhoneNumber)) {
			//
			// logInfo("Phone number validation got success.");
			//
			// } else {
			//
			// throw new BSROException("Phone number validation got failed.");
			//
			// }

			CoreUtils.mouseOver(By.id("preferred-store"));

			String actualStoreNumber = KeyWordDrivenConstants.webDriver
					.findElement(By.className("store-number")).getText()
					.replaceAll("Store # ", "").replaceAll(" ", "");

			String expectedStoreNumber = storeDetails.get("STORE_NUMBER");

			logInfo("actualStoreNumber = " + actualStoreNumber);

			logInfo("expectedStoreNumber = " + expectedStoreNumber);

			if (actualStoreNumber.equals(expectedStoreNumber)) {

				logInfo("Nearest store got selected.");

			} else {

				throw new BSROException(
						"setPreferedStoreFromPageHeader() failed.");
			}

			WebElement storeLocationElement = KeyWordDrivenConstants.webDriver
					.findElement(By.id("preferred-store-location"));

			String actualStoreLocation = storeLocationElement.getText()
					.replaceAll("\\r\\n|\\r|\\n", " ");

			logInfo("actualStoreLocation = " + actualStoreLocation);

			String expectedStoreLocation = "YOUR STORE: "
					+ storeDetails.get("CITY") + ", "
					+ storeDetails.get("STATE");

			logInfo("expectedStoreLocation = " + expectedStoreLocation);

			if (actualStoreLocation.equals(expectedStoreLocation)) {

				logInfo("Store location verification success.");

			} else {

				throw new BSROException("Store location verification failed.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("setDefualtStoreFromPageHeader() function failed.");

			throw new BSROException(e);
		}

		CoreUtils.setMouseCursorPositionOutOfScreen();

	}

	public static void setPreferedStoreFromPageFooter() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			String argData = KeyWordDrivenConstants.TC_EXPECTED;

			String[] args = argData.split(";");

			if (args.length != 1) {

				throw new BSROException(
						"Invalid arguments passed to setDefualtStoreFromPageHeader();");

			}

			String address = "";

			for (int loopCount = 0; loopCount < args.length; loopCount++) {

				if (args[loopCount].startsWith("address")) {

					address = args[loopCount].substring(args[loopCount]
							.indexOf("=") + 1);

				}

			}

			boolean isValidZipCode = isValidZipCode(address);

			WebElement addressInputElement = KeyWordDrivenConstants.webDriver
					.findElement(By.id("address"));

			addressInputElement.clear();

			addressInputElement.sendKeys(address);

			try {

				KeyWordDrivenConstants.webDriver.findElement(
						By.id("locate-find-store")).click();

			} catch (NoSuchElementException e) {
				// TODO: handle exception

				KeyWordDrivenConstants.webDriver.findElement(
						By.id("locate-map-find-store-2")).click();

			}

			HtmlBrowser.waitForLoad();

			ArrayList<String> expcetedStoreList = BLFunctions.ExpectedData.StoreList
					.getStoreListProductFunnel(address);

			ArrayList<String> actualStoreList = BLFunctions.ActualData.StoreList
					.getStoreListFromStoreLocatorPage();

			logInfo("expcetedStoreList = " + expcetedStoreList);

			logInfo("actualStoreList = " + actualStoreList);

			if (isValidZipCode) {

				if (actualStoreList.size() > BLFunctions.BLRulesData.StoreList.storeListCount) {

					throw new BSROException(
							"actualStoreList count is more than "
									+ BLFunctions.BLRulesData.StoreList.storeListCount);

				}

				if (expcetedStoreList.size() > BLFunctions.BLRulesData.StoreList.storeListCount) {

					throw new BSROException(
							"expcetedStoreList count is more than "
									+ BLFunctions.BLRulesData.StoreList.storeListCount);

				}

			}

			if (actualStoreList.size() == expcetedStoreList.size()) {

				logInfo("actualStoreList and expcetedStoreList count are same.");

			} else {

				throw new BSROException(
						"actualStoreList and expcetedStoreList count are not same.");

			}

			for (int loopCount = 0; loopCount < actualStoreList.size(); loopCount++) {

				if (actualStoreList.get(loopCount).equals(
						expcetedStoreList.get(loopCount))) {

				} else {

					throw new BSROException(
							"actualStoreList and expcetedStoreList sequence did not get matched.");

				}

			}

			logInfo("setPreferedStoreFromPageFooter() function success.");

		} catch (Exception e) {
			// TODO: handle exception

			logError("setPreferedStoreFromPageFooter() function failed.");

			throw new BSROException(e);
		}

	}

	public static void verifyStoreListOnServiceFunnel() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			String argData = KeyWordDrivenConstants.TC_EXPECTED;

			String[] args = argData.split(";");

			String address = "";

			for (int loopCount = 0; loopCount < args.length; loopCount++) {

				if (args[loopCount].startsWith("address")) {

					address = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");

				} else if (args[loopCount].toLowerCase().startsWith(
						"zip(or)state")) {

					address = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");

				}

			}

			boolean isValidZipCode = isValidZipCode(address);

			ArrayList<String> expcetedStoreList = BLFunctions.ExpectedData.StoreList
					.getStoreListServiceFunnel(address);

			ArrayList<String> actualStoreList = BLFunctions.ActualData.StoreList
					.getStoreListFromStoreLocatorPage();

			logInfo("expcetedStoreList = " + expcetedStoreList);

			logInfo("actualStoreList = " + actualStoreList);

			if (isValidZipCode) {

				if (actualStoreList.size() > BLFunctions.BLRulesData.StoreList.storeListCountServiceFunnel) {

					throw new BSROException(
							"actualStoreList count is more than "
									+ BLFunctions.BLRulesData.StoreList.storeListCountServiceFunnel);

				}

				if (expcetedStoreList.size() > BLFunctions.BLRulesData.StoreList.storeListCountServiceFunnel) {

					throw new BSROException(
							"expcetedStoreList count is more than "
									+ BLFunctions.BLRulesData.StoreList.storeListCountServiceFunnel);

				}

			}

			if (actualStoreList.size() == expcetedStoreList.size()) {

				logInfo("actualStoreList and expcetedStoreList count are same.");

			} else {

				throw new BSROException(
						"actualStoreList and expcetedStoreList count are not same.");

			}

			for (int loopCount = 0; loopCount < actualStoreList.size(); loopCount++) {

				if (actualStoreList.get(loopCount).equals(
						expcetedStoreList.get(loopCount))) {

				} else {

					throw new BSROException(
							"actualStoreList and expcetedStoreList sequence did not get matched.");

				}

			}

			logInfo("verifyStoreListOnServiceFunnel() function success.");

		} catch (Exception e) {
			// TODO: handle exception

			logError("verifyStoreListOnServiceFunnel() function failed.");

			throw new BSROException(e);
		}

	}

	public static void verifyStoreListOnProductFunnel() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			String argData = KeyWordDrivenConstants.TC_EXPECTED;

			String[] args = argData.split(";");

			String address = "";

			for (int loopCount = 0; loopCount < args.length; loopCount++) {

				if (args[loopCount].toLowerCase().startsWith("address")) {

					address = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");

				} else if (args[loopCount].toLowerCase().startsWith(
						"zip(or)state")) {

					address = args[loopCount].substring(
							args[loopCount].indexOf("=") + 1).replaceAll(";",
							"");

				}

			}

			if (address.isEmpty() || null == address) {

				throw new BSROException("address or zip code is empty or null.");
			}

			boolean isValidZipCode = isValidZipCode(address);

			ArrayList<String> expcetedStoreList = BLFunctions.ExpectedData.StoreList
					.getStoreListProductFunnel(address);

			ArrayList<String> actualStoreList = BLFunctions.ActualData.StoreList
					.getStoreListFromStoreLocatorPage();

			logInfo("expcetedStoreList = " + expcetedStoreList);

			logInfo("actualStoreList = " + actualStoreList);

			if (isValidZipCode) {

				if (actualStoreList.size() > BLFunctions.BLRulesData.StoreList.storeListCount) {

					throw new BSROException(
							"actualStoreList count is more than "
									+ BLFunctions.BLRulesData.StoreList.storeListCount);

				}

				if (expcetedStoreList.size() > BLFunctions.BLRulesData.StoreList.storeListCount) {

					throw new BSROException(
							"expcetedStoreList count is more than "
									+ BLFunctions.BLRulesData.StoreList.storeListCount);

				}

			}

			if (actualStoreList.size() == expcetedStoreList.size()) {

				logInfo("actualStoreList and expcetedStoreList count are same.");

			} else {

				throw new BSROException(
						"actualStoreList and expcetedStoreList count are not same.");

			}

			for (int loopCount = 0; loopCount < actualStoreList.size(); loopCount++) {

				if (actualStoreList.get(loopCount).equals(
						expcetedStoreList.get(loopCount))) {

				} else {

					throw new BSROException(
							"actualStoreList and expcetedStoreList sequence did not get matched.");

				}

			}

			logInfo("verifyStoreListOnProductFunnel() function success.");

		} catch (Exception e) {
			// TODO: handle exception

			logError("verifyStoreListOnProductFunnel() function failed.");

			throw new BSROException(e);

		}

	}

	private static boolean isValidZipCode(String str) throws BSROException {

		if (str.isEmpty() || null == str) {

			throw new BSROException("Invalid zip code provided is " + str);

		}

		String zipCodePattern = "\\d{5}(-\\d{4})?";

		return str.matches(zipCodePattern);

	}

}
