// DO NOT EDIT: This file is automatically generated.
//
// Only the associated template file should be edited directly.
// Helper class files are automatically regenerated from the template
// files at various times, including record actions and test object
// insertion actions.  Any changes made directly to a helper class
// file will be lost when automatically updated.

package resources.Framework;

import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.vp.IFtVerificationPoint;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;
/**
 * Script Name   : <b>HtmlCheckBox</b><br>
 * Generated     : <b>2013/04/15 7:48:04 PM</b><br>
 * Description   : Helper class for script<br>
 * Original Host : Windows 7 x86 6.1 <br>
 * 
 * @since  April 15, 2013
 * @author admin
 */
public abstract class HtmlCheckBoxHelper extends RationalTestScript
{
	/**
	 * maintenanceChoices12: with default state.
	 *		.id : maintenanceChoices-Tire-Replacement
	 * 		.type : checkbox
	 * 		.value : 12
	 * 		.title : 
	 * 		.class : Html.INPUT.checkbox
	 * 		.name : maintenanceChoices
	 * 		.classIndex : 0
	 */
	protected ToggleGUITestObject checkBox_maintenanceChoices12() 
	{
		return new ToggleGUITestObject(
                        getMappedTestObject("checkBox_maintenanceChoices12"));
	}
	/**
	 * maintenanceChoices12: with specific test context and state.
	 *		.id : maintenanceChoices-Tire-Replacement
	 * 		.type : checkbox
	 * 		.value : 12
	 * 		.title : 
	 * 		.class : Html.INPUT.checkbox
	 * 		.name : maintenanceChoices
	 * 		.classIndex : 0
	 */
	protected ToggleGUITestObject checkBox_maintenanceChoices12(TestObject anchor, long flags) 
	{
		return new ToggleGUITestObject(
                        getMappedTestObject("checkBox_maintenanceChoices12"), anchor, flags);
	}
	
	

	protected HtmlCheckBoxHelper()
	{
		setScriptName("Framework.HtmlCheckBox");
	}
	
}

