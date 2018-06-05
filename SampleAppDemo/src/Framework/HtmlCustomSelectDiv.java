package Framework;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Framework.HtmlCustomSelectDivHelper;
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
 * Description   : Functional Test Script
 * @author css89714
 */
public class HtmlCustomSelectDiv extends HtmlCustomSelectDivHelper
{
	/**
	 * Script Name   : <b>HtmlCustomSelectDiv</b>
	 * Generated     : <b>Jul 8, 2013 3:19:50 PM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 6.1  Build 7601 (S)
	 * 
	 * @since  2013/07/08
	 * @author css89714
	 */
	
	public static void select(By by, String argData) throws BSROException {

		HtmlBrowser.waitForLoad();

		String[] arguments = argData.split(";");

		if (arguments.length != 2) {

			throw new BSROException(
					"Invalid expected data passed to customSelect component.");

		}

		String textComponentIdentifier = arguments[0];

		String customSelectValueIdentifier = arguments[1];

		String textComponent = "";

		String customSelectValue = "";

		if (textComponentIdentifier.toLowerCase().startsWith("textcomponentid")) {

			textComponent = textComponentIdentifier.substring(
					textComponentIdentifier.indexOf("=") + 1,
					textComponentIdentifier.length());

		} else {

			throw new BSROException(
					"textcomponentid is not identified for custom select component");
		}

		if (customSelectValueIdentifier.toLowerCase().startsWith("value")) {

			customSelectValue = customSelectValueIdentifier.substring(
					customSelectValueIdentifier.indexOf("=") + 1,
					customSelectValueIdentifier.length());

		} else {

			throw new BSROException(
					"customSelectValue is not identified for custom select component");

		}

		logInfo("textComponent = " + textComponent);

		logInfo("customSelectValue = " + customSelectValue);

		KeyWordDrivenConstants.webDriver.findElement(By.id(textComponent))
				.click();

		// new Actions(KeyWordDrivenConstants.webDriver)
		// .moveToElement(
		// KeyWordDrivenConstants.webDriver.findElement(By
		// .id(textComponent))).click().perform();

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		WebElement customSelectDiv = KeyWordDrivenConstants.webDriver
				.findElement(by);

		if (customSelectDiv.isDisplayed()) {

			WebElement selectListItemsDiv = KeyWordDrivenConstants.webDriver
					.findElement(by);

			java.util.List<WebElement> webElements = selectListItemsDiv
					.findElements(By.tagName("div"));

			Iterator<WebElement> iterator = webElements.iterator();

			// int downArrowPressCount = 0;

			while (iterator.hasNext()) {

				WebElement webElement2 = (WebElement) iterator.next();

				String listItem = webElement2.getText();

				System.out.println("listItem = " + listItem);

				if (listItem.equals(customSelectValue)) {

					webElement2.click();

					break;
				}

			}

		} else {

			throw new BSROException("customSelectDiv is not displayed.");
		}

	}
	
}

