package Framework;

import org.openqa.selenium.By;

import resources.Framework.HtmlCheckBoxHelper;
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
public class HtmlCheckBox extends HtmlCheckBoxHelper {
	/**
	 * Script Name : <b>HtmlCheckBox</b> Generated : <b>Apr 15, 2013 7:46:04
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7600 ()
	 * 
	 * @since 2013/04/15
	 * @author admin
	 */
	public static void checkByName(String name) {
		// TODO Insert code here

		TestObject[] objects = FrameWorkObjects.browserObject
				.find(atDescendant(".class", "Html.INPUT.checkbox", ".name",
						name));

		while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject
					.find(atDescendant(".class",
							"checkBox_maintenanceChoices12().", ".name", name));

		}

		((ToggleGUITestObject) objects[0]).select();

		unregister(objects);

	}

	public static void unCheckByName(String name) {
		// TODO Insert code here

		TestObject[] objects = FrameWorkObjects.browserObject
				.find(atDescendant(".class", "Html.INPUT.checkbox", ".name",
						name));

		while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject
					.find(atDescendant(".class",
							"checkBox_maintenanceChoices12().", ".name", name));

		}

		((ToggleGUITestObject) objects[0]).deselect();

		unregister(objects);

	}

	public static void checkByID(String id) {
		// TODO Insert code here

		TestObject[] objects = FrameWorkObjects.browserObject
				.find(atDescendant(".class", "Html.INPUT.checkbox", ".id", id));

		while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject.find(atDescendant(
					".class", "checkBox_maintenanceChoices12().", ".id", id));

		}

		((ToggleGUITestObject) objects[0]).select();

		unregister(objects);

	}

	public static void unCheckByID(String id) {
		// TODO Insert code here

		TestObject[] objects = FrameWorkObjects.browserObject
				.find(atDescendant(".class", "Html.INPUT.checkbox", ".id", id));

		while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject.find(atDescendant(
					".class", "checkBox_maintenanceChoices12().", ".id", id));

		}

		((ToggleGUITestObject) objects[0]).deselect();

		unregister(objects);

	}

	public static void check(Property[] properties)throws BSROException {
		// TODO Insert code here

		try {
			TestObject[] objects = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			// while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			// }

			((ToggleGUITestObject) objects[0]).select();

			unregister(objects);

		} catch (Exception e) {
			// TODO: handle exception

			logError("Fail to perform check operation.");

			e.printStackTrace();

			throw new BSROException(e);

		}

	}

	public static String getCheckedState(Property[] properties)
			throws BSROException {
		// TODO Insert code here

		String checkedState = "";

		try {
			TestObject[] objects = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			// while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			// }

			checkedState = ((ToggleGUITestObject) objects[0]).getState()
					.toString();

			unregister(objects);

		} catch (Exception e) {
			// TODO: handle exception

			logError("Fail to perform check operation.");

			e.printStackTrace();

			throw new BSROException(e);

		}

		return checkedState;

	}

	public static void check(By by) throws BSROException {

		if (CoreUtils.isElementPresent(by)) {

			if (KeyWordDrivenConstants.webDriver.findElement(by).isSelected()) {

				logInfo("Check box is alreay selected.");

			} else {

				KeyWordDrivenConstants.webDriver.findElement(by).click();
			}

		} else {

			throw new BSROException("check() function processing failed.");

		}
	}

	public static void unCheck(By by) throws BSROException {

		if (CoreUtils.isElementPresent(by)) {

			if (false == KeyWordDrivenConstants.webDriver.findElement(by)
					.isSelected()) {

				KeyWordDrivenConstants.webDriver.findElement(by).click();

			} else {

				logInfo("Check box is alreay un-checked.");

			}

		} else {

			throw new BSROException("unCheck() function processing failed.");

		}
	}

	public static boolean getCheckedState(By by) throws BSROException {

		boolean isChecked = false;

		if (CoreUtils.isElementPresent(by)) {

			if (false == KeyWordDrivenConstants.webDriver.findElement(by)
					.isSelected()) {

			} else {

				isChecked = true;

			}

		} else {

			throw new BSROException(
					"getCheckedState() function processing failed.");

		}

		return isChecked;
	}

}
