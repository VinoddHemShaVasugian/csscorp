package Framework;

import resources.Framework.HtmlRadioButtonHelper;
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
 * @author VenkataRaja
 */
public class HtmlRadioButton extends HtmlRadioButtonHelper {
	/**
	 * Script Name : <b>HtmlRadioButton</b> Generated : <b>May 29, 2013 6:27:25
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/05/29
	 * @author VenkataRaja
	 */

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

	public static void unCheck(Property[] properties)throws BSROException {
		// TODO Insert code here

		try {

			TestObject[] objects = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			// while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			// }

			((ToggleGUITestObject) objects[0]).deselect();

			unregister(objects);

		} catch (Exception e) {
			// TODO: handle exception

			logError("Fail to perform unCheck() operation.");

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

}
