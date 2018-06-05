package Framework;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import resources.Framework.HtmlLinkHelper;
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
 * @author admin
 */
public class HtmlLink extends HtmlLinkHelper {
	/**
	 * Script Name : <b>HtmlLink</b> Generated : <b>Apr 12, 2013 10:38:26 AM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7600 ()
	 * 
	 * @since 2013/04/12
	 * @author admin
	 * @throws BSROException
	 */
	// public static void clickByText(String title) {
	//
	// try {
	//
	// TestObject[] links = FrameWorkObjects.browserObject
	// .find(atDescendant(".class", "Html.A", ".text", title));
	//
	// // while (links != null && links.length <= 0) {
	//
	// // links = find(atDescendant(".class", "Html.A", ".text", title));
	// ``
	// // }
	//
	// if (links[0].exists()) {
	//
	// System.out.println("Working with Screen Points.");
	//
	// GuiTestObject guiTestObject = (GuiTestObject) links[0];
	//
	// guiTestObject.click();
	//
	// logInfo(title + " link is found.");
	//
	// } else {
	//
	// logError(title + " link is not found.");
	//
	// }
	//
	// Framework.HtmlBrowser.waitForLoad();
	//
	// } catch (Exception ex) {
	//
	// logError(title + " link is not found.");
	//
	// }
	//
	// }

	public static void clickByLinkText(String argText) throws BSROException {

		try {

			// WebElement element = KeyWordDrivenConstants.webDriver
			// .findElement(By.linkText(argText));
			//
			// int elementPosition = element.getLocation().getY();
			//
			// String js = String.format("window.scroll(0, %s)",
			// elementPosition);
			//
			// ((JavascriptExecutor) KeyWordDrivenConstants.webDriver)
			// .executeScript(js);
			//
			// element.click();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(By.linkText(argText))
					.click();

			HtmlBrowser.waitForLoad();

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);

		}

	}

	public static void clickByText(String argLinkText) {

		KeyWordDrivenConstants.webDriver.findElement(By.linkText(argLinkText))
				.click();
	}

	public static boolean isExistsByText(String title) {

		boolean isExist = false;

		try {

			TestObject[] links = FrameWorkObjects.browserObject
					.find(atDescendant(".class", "Html.A", ".text", title));

			// while (links != null && links.length <= 0) {

			// links = find(atDescendant(".class", "Html.A", ".text", title));

			// }

			if (links[0].exists()) {

				logInfo(title + " link is found.");

				isExist = true;

			} else {

				logError(title + " link is not found.");

			}

		} catch (Exception ex) {

			logError(title + " link is not found.");

		}

		return isExist;

	}
}
