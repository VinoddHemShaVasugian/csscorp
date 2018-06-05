package Framework;
import resources.Framework.HtmlTextAreaHelper;
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
 * @author admin
 */
public class HtmlTextArea extends HtmlTextAreaHelper
{
	/**
	 * Script Name   : <b>HtmlTextArea</b>
	 * Generated     : <b>Apr 15, 2013 7:56:17 PM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 6.1  Build 7600 ()
	 * 
	 * @since  2013/04/15
	 * @author admin
	 */
	
	public static void setTextByName(String name, String inputText,
			boolean hitEnter) {

		TestObject[] links = FrameWorkObjects.browserObject.find(atDescendant(
				".name", name));

		while (links != null && links.length <= 0) {

			links = FrameWorkObjects.browserObject
					.find(atDescendant(".name", name));

		}

		while (!((GuiTestObject) links[0]).exists()) {

			sleep(1);

		}

		((GuiTestObject) links[0]).click();

		TopLevelTestObject textBox = new TopLevelTestObject(
				links[0].getTopParent());

		((TextGuiTestObject) links[0]).setText("");

		((TextGuiTestObject) links[0]).setText(inputText);

		// textBox.inputChars("{ExtHome}+{ExtEnd}" + inputText);

		if (hitEnter) {

			textBox.inputKeys("~");

		}

	}

	public static void setTextByID(String name, String inputText,
			boolean hitEnter) {

		TestObject[] links = FrameWorkObjects.browserObject.find(atDescendant(
				".id", name));

		while (links != null && links.length <= 0) {

			links = FrameWorkObjects.browserObject.find(atDescendant(".id", name));

		}

		while (!((GuiTestObject) links[0]).exists()) {

			sleep(1);

		}

		((GuiTestObject) links[0]).click();

		TopLevelTestObject textBox = new TopLevelTestObject(
				links[0].getTopParent());

		// textBox.inputChars(inputText);

		((TextGuiTestObject) links[0]).setText("");

		((TextGuiTestObject) links[0]).setText(inputText);

		if (hitEnter) {

			textBox.inputKeys("~");

		}

	}
	
}

