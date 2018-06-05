package BLFunctions.BLVerification;

import java.util.ArrayList;

import org.openqa.selenium.By;

import resources.BLFunctions.BLVerification.ScheduleAppointmentTimeFieldHelper;
import Framework.BSROException;
import Framework.HtmlText;
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
public class ScheduleAppointmentTimeField extends
		ScheduleAppointmentTimeFieldHelper {
	/**
	 * Script Name : <b>ScheduleAppointmentTimeField</b> Generated : <b>Jun 27,
	 * 2013 4:20:36 AM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/06/27
	 * @author css89714
	 * @throws BSROException
	 */
	public static void verify() throws BSROException {

		String datePickerID = "";

		ArrayList<String> actualListItems = new ArrayList<String>();

		ArrayList<String> expectedListItems = new ArrayList<String>();

		if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase().equals(
				"BLANK")) {

			if (KeyWordDrivenConstants.TC_HTML_ELEMENT_ID
					.equals("choice1-time")) {

				datePickerID = "choice1-date";

			} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_ID
					.equals("choice2-time")) {

				datePickerID = "choice2-date";

			} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_ID
					.equals("choice3-time")) {

				datePickerID = "choice3-date";

			}

			String storeTimingsOnWeekDays = KeyWordDrivenConstants.webDriver
					.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/ul/li[1]")).getText();

			String storeTimingsOnSaturday = KeyWordDrivenConstants.webDriver
					.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/ul/li[2]")).getText();

			String storeTimingsOnSunday = KeyWordDrivenConstants.webDriver
					.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/ul/li[3]")).getText();

			String userSelectedDate = KeyWordDrivenConstants.webDriver
					.findElement(By.id(datePickerID)).getText();

			expectedListItems = BLFunctions.ExpectedData.ScheduleAppointmentTimeField
					.getTimeSlotsList(userSelectedDate,storeTimingsOnWeekDays,storeTimingsOnSaturday,storeTimingsOnSunday);

		} else {

			throw new BSROException("Element identifier is not defined.");

		}

	}
}
