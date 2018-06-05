package ProductSpecificFunctions.SiteMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.SiteMap.VerifyTiresLinksHelper;
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
public class VerifyTiresLinks extends VerifyTiresLinksHelper {
	/**
	 * Script Name : <b>VerifyTiresLinks</b> Generated : <b>Aug 6, 2013 3:22:16
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/08/06
	 * @author css89714
	 */

	public static void verify() throws BSROException {

		try {

			String tireTypes[] = { "site-map-vehicles-and-tires",
					"site-map-vehicles-all-season-tires",
					"site-map-car-minivan-tires",
					"site-map-vehicles-light-truck-tires",
					"site-map-vehicles-preformance-tires",
					"site-map-vehicles-summer-tires",
					"site-map-vehicles-suv-cuv-tires",
					"site-map-vehicles-winter-tires" };

			String tiresSubstrings[] = { "Tires for", "All-Season Tires for",
					"Car & Minivan Tires for", "Light Truck Tires for",
					"Performance Tires for", "Summer Tires for",
					"SUV/CUV Tires for", "Winter Tires for" };

			HtmlBrowser.waitForLoad();

			for (int j = 0; j < tireTypes.length; j++) {

				System.out.println("Base URL :"
						+ KeyWordDrivenConstants.siteURL);

				KeyWordDrivenConstants.webDriver.findElement(
						By.id(tireTypes[j])).click();

				HtmlBrowser.waitForLoad();

				String elementText = "";

				java.util.List<WebElement> elementList = KeyWordDrivenConstants.webDriver
						.findElements(By.id("vehicle-tires-list-tires-for"));

				System.out.println("Size of Links :" + elementList.size());

				// for (int i = 0; i < elementList.size(); i++) {

				for (int i = 0; i < 2; i++) {

					elementList = KeyWordDrivenConstants.webDriver
							.findElements(By.id("vehicle-tires-list-tires-for"));

					WebElement element = elementList.get(i);

					elementText = elementList.get(i).getText();

					elementText = elementText.substring(
							tiresSubstrings[j].length()).trim();

					System.out.println("Link Text " + elementText);

					element.click();

					HtmlBrowser.waitForLoad();

					KeyWordDrivenConstants.webDriver.getTitle().contains(
							elementText);

					KeyWordDrivenConstants.webDriver
							.findElement(
									By.xpath("//div[@id='page-header']/h1"))
							.getText().contains(elementText);

					HtmlBrowser.backButton();

					HtmlBrowser.waitForLoad();

				}

				KeyWordDrivenConstants.webDriver.findElement(
						By.id("footer-site-map")).click();

				HtmlBrowser.waitForLoad();
			}
		} catch (Exception e1) {

			logError("VerifyTiresLinks.verify() function failed");

			throw new BSROException(e1);
		}

	}

}
