package Framework;

import org.openqa.selenium.By;

import resources.Framework.HtmlTelephoneHelper;
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
public class HtmlTelephone extends HtmlTelephoneHelper {
	/**
	 * Script Name : <b>HtmlTelephone</b> Generated : <b>Jun 21, 2013 4:50:13
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/06/21
	 * @author css89714
	 */
	public static void setText(Property[] properties, String argInputText)
			throws BSROException {

		try {

			TestObject[] links = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			links = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			// ((GuiTestObject) links[0]).hover();
			//
			// ((GuiTestObject) links[0]).click();
			//
			// ((TextGuiTestObject) links[0]).setText("");
			//
			// ((TextGuiTestObject) links[0]).setText(argInputText);

			TopLevelTestObject textBox = new TopLevelTestObject(
					links[0].getTopParent());

			textBox.click();

			textBox.inputChars("");

			textBox.inputChars(argInputText);

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			throw new BSROException("Failed to perform setText() operation.");
		}

	}

	public static void setTextByID(String argID, String argInputText)
			throws BSROException {

		try {

			KeyWordDrivenConstants.webDriver.findElement(By.id(argID)).click();

			KeyWordDrivenConstants.webDriver.findElement(By.id(argID))
					.sendKeys(argInputText);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

	}

}
