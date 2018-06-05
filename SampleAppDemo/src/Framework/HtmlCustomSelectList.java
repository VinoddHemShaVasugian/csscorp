package Framework;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Framework.HtmlCustomSelectListHelper;
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
public class HtmlCustomSelectList extends HtmlCustomSelectListHelper
{
	/**
	 * Script Name   : <b>HtmlCustomSelectList</b>
	 * Generated     : <b>Jul 8, 2013 3:18:59 PM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 6.1  Build 7601 (S)
	 * 
	 * @since  2013/07/08
	 * @author css89714
	 */
	
	public static void select(By by, String argData) throws BSROException {

		String[] arguments = argData.split(";");

		if (arguments.length != 2) {

			throw new BSROException(
					"Invalid expected data passed to customSelect component.");

		}

		WebElement customSelectDiv = KeyWordDrivenConstants.webDriver
				.findElement(by);

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

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		if (customSelectDiv.isDisplayed()) {

			WebElement selectListItemsDiv = KeyWordDrivenConstants.webDriver
					.findElement(by);

			java.util.List<WebElement> webElements = selectListItemsDiv
					.findElements(By.tagName("li"));

			Iterator<WebElement> iterator = webElements.iterator();

			while (iterator.hasNext()) {

				WebElement webElement2 = (WebElement) iterator.next();

				WebElement span = webElement2.findElement(By.tagName("span"));

				System.out.println("span.getText() = " + span.getText());

				if (span.getText().equals(customSelectValue)) {

					webElement2.click();

					break;
				}

			}

		} else {

			throw new BSROException("customSelectDiv is not displayed.");
		}

	}
	
}

