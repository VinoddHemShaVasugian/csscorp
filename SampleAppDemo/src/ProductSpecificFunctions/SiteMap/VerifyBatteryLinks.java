package ProductSpecificFunctions.SiteMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.SiteMap.VerifyBatteryLinksHelper;
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
public class VerifyBatteryLinks extends VerifyBatteryLinksHelper {
	/**
	 * Script Name : <b>VerifyBatteryLinks</b> Generated : <b>Aug 6, 2013
	 * 3:22:07 PM</b> Description : Functional Test Script Original Host : WinNT
	 * Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/08/06
	 * @author css89714
	 */

	public static void verify() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			String elementText = "";

			String substringText = "Battery For";

			java.util.List<WebElement> elementList = KeyWordDrivenConstants.webDriver
					.findElements(By.id("vehicle-battery-list-battery-for"));

			System.out.println("Size of Links :" + elementList.size());

			for (int loopCount = 0; loopCount < elementList.size(); loopCount++) {

				elementList = KeyWordDrivenConstants.webDriver.findElements(By
						.id("vehicle-battery-list-battery-for"));

				WebElement element = elementList.get(loopCount);

				elementText = elementList.get(loopCount).getText();

				elementText = elementText.substring(substringText.length())
						.trim();

				System.out.println("Link Text " + elementText);

				element.click();

				HtmlBrowser.waitForLoad();

				KeyWordDrivenConstants.webDriver.getTitle().contains(
						elementText);

				KeyWordDrivenConstants.webDriver
						.findElement(By.xpath("//div[@id='page-header']/h1"))
						.getText().contains(elementText);

				HtmlBrowser.backButton();

				HtmlBrowser.waitForLoad();

				if (loopCount > 7) {

					break;

				}

			}

		} catch (Exception e1) {

			logError("VerifyBatteryLinks.verify() function failed");

			throw new BSROException(e1);
		}

	}

}
