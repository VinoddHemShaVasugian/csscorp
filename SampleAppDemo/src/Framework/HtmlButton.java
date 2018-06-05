package Framework;

import resources.Framework.HtmlButtonHelper;
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
public class HtmlButton extends HtmlButtonHelper {
	/**
	 * Script Name : <b>HtmlButton</b> Generated : <b>Apr 12, 2013 10:43:03
	 * AM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7600 ()
	 * 
	 * @since 2013/04/12
	 * @author admin
	 * @throws BSROException
	 */
	public static void clickByID(String buttonID)throws BSROException {

		Framework.HtmlBrowser.getCurrentBrowserWindowObject();

		try {

			TestObject[] objects = FrameWorkObjects.browserObject
					.find(atDescendant(".class", "Html.BUTTON", ".id", buttonID));

			// while (objects != null && objects.length <= 0) {
			//
			// objects =
			// FrameWorkObjects.browserObject.find(atDescendant(".class",
			// "Html.BUTTON", ".id", buttonID));
			//
			// }

			if (objects[0].exists()) {

				((GuiTestObject) objects[0]).click();

				sleep(3);

				logInfo(buttonID + " button is found.");

			} else {

				logError(buttonID + " button is not found.");

			}

		} catch (Exception ex) {

			logError(buttonID + " button is not found.");

		}

		Framework.HtmlBrowser.waitForLoad();

	}

	public static void isExistByID(String buttonID) {

		try {

			TestObject[] links = FrameWorkObjects.browserObject
					.find(atDescendant(".class", "Html.BUTTON", ".id", buttonID));

			while (links != null && links.length <= 0) {

				links = FrameWorkObjects.browserObject.find(atDescendant(
						".class", "Html.A", ".text", buttonID));

			}

			if (links[0].exists()) {

				// ((GuiTestObject) links[0]).click();

				logInfo(buttonID + " button is found.");

			} else {

				logError(buttonID + " button is not found.");

			}

			// waitForLoad(FrameWorkObjects.browserObject, 60);

			Framework.HtmlBrowser.waitForLoad();

		} catch (Exception ex) {

			logError(buttonID + " link is not found.");

		}

	}

}
