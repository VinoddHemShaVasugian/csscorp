package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import resources.Framework.jQueryCalendarHelper;
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
public class jQueryCalendar extends jQueryCalendarHelper {
	/**
	 * Script Name : <b>jQueryCalendar</b> Generated : <b>Jul 8, 2013 3:20:31
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/07/08
	 * @author css89714
	 */

	public static void setDate(By by, String argDate) throws BSROException {

		HtmlBrowser.waitForLoad();

		try {

			WebElement element = KeyWordDrivenConstants.webDriver
					.findElement(by);

			logInfo("date picker identified.");

			String datePickerID = "";

			if (KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase().equals(
					"YES")) {

				datePickerID = KeyWordDrivenConstants.TC_HTML_ELEMENT_ID;

			} else {

				throw new BSROException(
						"jQueryCalendar component needs id must.");

			}

			JavascriptExecutor js = (JavascriptExecutor) KeyWordDrivenConstants.webDriver;

			js.executeScript("$(\"#" + "" + datePickerID
					+ "\").datepicker(\"setDate\", new Date(2013,06,01));");

			element.click();

			Thread.sleep(2 * 1000);

			element.sendKeys(Keys.ENTER);

			Thread.sleep(2 * 1000);

			element.sendKeys(Keys.ESCAPE);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException("setDate() function failed.");
		}

	}

}
