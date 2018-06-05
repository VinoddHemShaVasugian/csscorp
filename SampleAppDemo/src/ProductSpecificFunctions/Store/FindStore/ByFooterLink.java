package ProductSpecificFunctions.Store.FindStore;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.Store.FindStore.ByFooterLinkHelper;
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
public class ByFooterLink extends ByFooterLinkHelper {
	/**
	 * Script Name : <b>ByFooterLink</b> Generated : <b>Jul 17, 2013 3:05:01
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/17
	 * @author css89714
	 */

	public static void findSpecificStore(String argStoreSearchInfo)
			throws BSROException {

		String zip_state = "";

		String store_number = "";

		boolean forceSelect = false;

		int totalStoresReturnedBySearchResults = 0;

		try {

			String storeSelectionInfo = argStoreSearchInfo;

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

			//logInfo("zip_state = " + zip_state);

			//logInfo("store_number = " + store_number);

			CoreUtils.elementClickByID("footer-find-store");

			By addressElement = By.id("address");

			HtmlText.setText(addressElement, zip_state);

			CoreUtils.elementClickByID("address");

			try {

				CoreUtils.elementClickByID("locate-find-store");

			} catch (Exception e) {
				// TODO: handle exception

				CoreUtils.elementClickByID("locate-map-find-store-2");

			}

			// WebElement storeListContainer = KeyWordDrivenConstants.webDriver
			// .findElement(By.id("store-list"));

			List<WebElement> eachStoreContainer = KeyWordDrivenConstants.webDriver
					.findElements(By.xpath("//*[@id=\"store-list\"]/ul/li"));

			totalStoresReturnedBySearchResults = eachStoreContainer.size();

			//logInfo("Number Of Stores Identified = "	+ totalStoresReturnedBySearchResults);

			Iterator<WebElement> iterator = eachStoreContainer.iterator();

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

				//	logInfo("Specific store with given store number is identified.");

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

		//	logError("ByFooterLink.selectStore() function failed.");

			throw new BSROException(e);

		}

	}
	
static int loopCount = 0;
	
	public static void verifyAllLinksInAPage(){
		try{
			
			List<WebElement> getAllLinks = KeyWordDrivenConstants.webDriver.findElements(By.xpath("//div[contains(@id,'content') and contains(@role,'main')]/table/tbody/tr/td"));

			Iterator<WebElement> iterator2 = getAllLinks.iterator();

			

			boolean isLinkIdentified = false;

			while (iterator2.hasNext()) {
				
				iterator2.next();
				
				List<WebElement> storeLinkInAColumn = KeyWordDrivenConstants.webDriver.findElements(By.xpath("//div[contains(@id,'content') and contains(@role,'main')]/table/tbody/tr/td["+(loopCount+1)+"]/ul/li"));

				Iterator<WebElement> iteratorInAColumn = storeLinkInAColumn.iterator();

				int loopCountForColumn = 0;

				boolean isLinkIdentifiedForColumn = false;

				while (iteratorInAColumn.hasNext()) {
					
					iteratorInAColumn.next();
					
					WebElement getLinkDetails = KeyWordDrivenConstants.webDriver.findElement(By.xpath("//div[contains(@id,'content') and contains(@role,'main')]/table/tbody/tr/td["+(loopCount+1)+"]/ul/li["+(loopCountForColumn+1)+"]/a"));
					
					String storeLinkTextName = getLinkDetails.getText();

				//	logInfo("Current Navigation for Link "+storeLinkTextName);
					
					if(getLinkDetails.isDisplayed()){
						
						getLinkDetails.click();
						
						String current_Page_Title = HtmlBrowser.getCurrentPageTitle();
						
						if(current_Page_Title.toLowerCase().trim().contains(storeLinkTextName.trim().toLowerCase())){
							
						//	logInfo("Page title verification success");
							
						}else{
							
						//	logError("Page title verification failed");
							
						}
						
						HtmlBrowser.backButton();
						
					}
					
					loopCountForColumn++;
					
				}
				
			}
			
		}catch(Exception e){
			//logInfo("Exception Observer => "+e.getMessage());
		}
	}
}
