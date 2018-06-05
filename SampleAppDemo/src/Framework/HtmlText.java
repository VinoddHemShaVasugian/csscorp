package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import resources.Framework.HtmlTextHelper;
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
public class HtmlText extends HtmlTextHelper {
	/**
	 * Script Name : <b>HtmlText</b> Generated : <b>Apr 12, 2013 10:50:16 AM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7600 ()
	 * 
	 * @since 2013/04/12
	 * @author admin
	 */

	// public static TextGuiTestObject getObjectByID(String id) {
	//
	// TextGuiTestObject returnObject = null;
	//
	// try {
	//
	// TestObject[] links = FrameWorkObjects.browserObject
	// .find(atDescendant(".id", id));
	//
	// // while (links != null && links.length <= 0) {
	// //
	// // links = FrameWorkObjects.browserObject.find(atDescendant(".id",
	// // id));
	// //
	// // }
	//
	// while (!((GuiTestObject) links[0]).exists()) {
	//
	// sleep(1);
	//
	// }
	//
	// ((GuiTestObject) links[0]).click();
	//
	// TopLevelTestObject textBox = new TopLevelTestObject(
	// links[0].getTopParent());
	//
	// returnObject = ((TextGuiTestObject) links[0]);
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	//
	// returnObject = null;
	// }
	//
	// return returnObject;
	//
	// }
	//
	// public static TextGuiTestObject getObjectByName(String argName) {
	//
	// TestObject[] links = FrameWorkObjects.browserObject.find(atDescendant(
	// ".name", argName));
	//
	// // while (links != null && links.length <= 0) {
	// //
	// // links = FrameWorkObjects.browserObject.find(atDescendant(".name",
	// // argName));
	// //
	// // }
	//
	// while (!((GuiTestObject) links[0]).exists()) {
	//
	// sleep(1);
	//
	// }
	//
	// ((GuiTestObject) links[0]).click();
	//
	// TopLevelTestObject textBox = new TopLevelTestObject(
	// links[0].getTopParent());
	//
	// return ((TextGuiTestObject) links[0]);
	//
	// }

	public static void setTextByName(String argName, String argInputText,
			boolean argHitEnter) {

		TestObject[] links = FrameWorkObjects.browserObject.find(atDescendant(
				".name", argName));

		while (links != null && links.length <= 0) {

			links = FrameWorkObjects.browserObject.find(atDescendant(".name",
					argName));

		}

		while (!((GuiTestObject) links[0]).exists()) {

			sleep(1);

		}

		((GuiTestObject) links[0]).click();

		TopLevelTestObject textBox = new TopLevelTestObject(
				links[0].getTopParent());

		((TextGuiTestObject) links[0]).setText("");

		((TextGuiTestObject) links[0]).setText(argInputText);

		// textBox.inputChars("{ExtHome}+{ExtEnd}" + inputText);

		if (argHitEnter) {

			textBox.inputKeys("~");

		}

	}

	public static void setTextByID(String argID, String argInputText,
			boolean argHitEnter) {

		TestObject[] links = FrameWorkObjects.browserObject.find(atDescendant(
				".id", argID));

		while (links != null && links.length <= 0) {

			links = FrameWorkObjects.browserObject.find(atDescendant(".id",
					argID));

		}

		while (!((GuiTestObject) links[0]).exists()) {

			sleep(1);

		}

		((GuiTestObject) links[0]).hover();

		((GuiTestObject) links[0]).click();

		TopLevelTestObject textBox = new TopLevelTestObject(
				links[0].getTopParent());

		// textBox.inputChars(inputText);

		((TextGuiTestObject) links[0]).setText("");

		((TextGuiTestObject) links[0]).setText(argInputText);

		if (argHitEnter) {

			textBox.inputKeys("~");

		}

	}

	public static void setText(Property[] properties, String argInputText)
			throws BSROException {

		try {

			TestObject[] links = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			links = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			((GuiTestObject) links[0]).hover();

			((GuiTestObject) links[0]).click();

			((TextGuiTestObject) links[0]).setText("");

			((TextGuiTestObject) links[0]).setText(argInputText);

			// TopLevelTestObject textBox = new TopLevelTestObject(
			// links[0].getTopParent());
			//
			// textBox.inputChars("" + argInputText);

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			throw new BSROException("Failed to perform setText() operation.");
		}

	}

	public static String getText(Property[] properties)throws BSROException {

		try {

			System.out.println("properties length = " + properties.length);

			TestObject[] links = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			links = FrameWorkObjects.browserObject
					.find(atDescendant(properties));
			//
			// while (!((GuiTestObject) links[0]).exists()) {
			//
			// sleep(1);
			//
			// }

			((GuiTestObject) links[0]).hover();

			// return ((TextGuiTestObject) links[0]).getText();
			return (((GuiTestObject) links[0]).getProperty(".value").toString());

		} catch (Exception e) {
			// TODO: handle exception

			logError("Fail to execute getText method.");

			throw new BSROException(e);
		}

	}

	public static void setTextByID(String argID, String argText)
			throws BSROException {

		try {

			// KeyWordDrivenConstants.webDriver.findElement(By.id(argID)).click();

			JavascriptExecutor jse = (JavascriptExecutor) KeyWordDrivenConstants.webDriver;

			jse.executeScript("document.getElementById('" + "" + argID
					+ "').focus();");

			KeyWordDrivenConstants.webDriver.findElement(By.id(argID))
					.sendKeys(argText);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(
					"Failed to perform setTextByID() operation.");
		}

	}

	public static String getTextByID(String argID) throws BSROException {

		String text = "";

		try {

			text = KeyWordDrivenConstants.webDriver.findElement(By.id(argID))
					.getText();

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(
					"Failed to perform setTextByID() operation.");
		}

		return text;

	}

	public static void setText(By by, String argText) throws BSROException {

		if (CoreUtils.isElementPresent(by)) {

			KeyWordDrivenConstants.webDriver.findElement(by).clear();

			if (false == argText.toLowerCase().equals("blank")) {

				KeyWordDrivenConstants.webDriver.findElement(by).sendKeys(
						argText);

			}

		} else {

			throw new BSROException("setText() function processing failed.");

		}

	}

	public static String getText(By by) throws BSROException {

		String text = "";

		if (CoreUtils.isElementPresent(by)) {

			text = KeyWordDrivenConstants.webDriver.findElement(by)
					.getAttribute("value");

			System.out.println("Element text identified = " + text);

		} else {

			throw new BSROException(
					"setText() function processing failed , because element is not present.");
		}

		return text;

	}

}
