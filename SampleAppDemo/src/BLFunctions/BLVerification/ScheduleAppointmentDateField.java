package BLFunctions.BLVerification;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import resources.BLFunctions.BLVerification.ScheduleAppointmentDateFieldHelper;
import Framework.BSROException;
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
public class ScheduleAppointmentDateField extends
		ScheduleAppointmentDateFieldHelper {
	/**
	 * Script Name : <b>ScheduleAppointmentDateField</b> Generated : <b>Jun 27,
	 * 2013 3:38:29 AM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/06/27
	 * @author css89714
	 * @throws BSROException
	 */
	public static void verify() throws BSROException {

		try {

			String xpath_Next = "//div[@id='ui-datepicker-div']/div/a[2]/span";

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				WebElement dateChoice = KeyWordDrivenConstants.webDriver
						.findElement(By
								.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID));

				dateChoice.click();

				Thread.sleep(2 * 1000);

				WebElement datePicker = KeyWordDrivenConstants.webDriver
						.findElement(By.id("ui-datepicker-div"));

				WebElement prev = datePicker.findElement(By
						.xpath("//div[@id='ui-datepicker-div']/div/a/span"));

				WebElement next = datePicker.findElement(By.xpath(xpath_Next));

				String currentMonthInDatePicker = datePicker
						.findElement(
								By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"))
						.getText();

				prev.click();

				Thread.sleep(2 * 1000);

				String currentMonthInDatePicker_After_Click_Prev = datePicker
						.findElement(
								By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"))
						.getText();

				if (currentMonthInDatePicker
						.equals(currentMonthInDatePicker_After_Click_Prev)) {

					logInfo("Previous month of data picker is disabled.");

				} else {

					throw new BSROException(
							"Previous month of data picker is enabled.");

				}

				next.click();

				Thread.sleep(2 * 1000);

				String currentMonthInDatePicker_After_Click_Next = datePicker
						.findElement(
								By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"))
						.getText();

				System.out.println("currentMonthInDatePicker = "
						+ currentMonthInDatePicker);

				System.out
						.println("currentMonthInDatePicker_After_Click_Prev = "
								+ currentMonthInDatePicker_After_Click_Prev);

				System.out
						.println("currentMonthInDatePicker_After_Click_Next = "
								+ currentMonthInDatePicker_After_Click_Next);

				if (currentMonthInDatePicker
						.equals(currentMonthInDatePicker_After_Click_Next)) {

					throw new BSROException(
							"Next month of data picker is disabled.");

				} else {

					logInfo("Previous month of data picker is enabled.");

				}

				// Trying to click previous arrow once calendar moved to next
				// month.

				prev = datePicker.findElement(By
						.xpath("//div[@id='ui-datepicker-div']/div/a/span"));

				prev.click();

				Thread.sleep(2 * 1000);

				String currentMonthInDatePicker_Before_Click_Next = "";

				for (int loopCount = 1; loopCount < BLFunctions.BLRulesData.ScheduleAppointmentDateField.nextMonthsAllowedForScheduling; loopCount++) {

					currentMonthInDatePicker_Before_Click_Next = datePicker
							.findElement(
									By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"))
							.getText();

					next = datePicker
							.findElement(By
									.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

					next.click();

					Thread.sleep(2 * 1000);

					currentMonthInDatePicker_After_Click_Next = datePicker
							.findElement(
									By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"))
							.getText();

					if (currentMonthInDatePicker_Before_Click_Next
							.equals(currentMonthInDatePicker_After_Click_Next)) {

						throw new BSROException(
								"Business rule validation failed for no.of months that a calendar need to enable.");

					}

				}

				currentMonthInDatePicker_Before_Click_Next = datePicker
						.findElement(
								By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"))
						.getText();

				next = datePicker.findElement(By
						.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

				next.click();

				Thread.sleep(2 * 1000);

				currentMonthInDatePicker_After_Click_Next = datePicker
						.findElement(
								By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"))
						.getText();

				if (currentMonthInDatePicker_Before_Click_Next
						.equals(currentMonthInDatePicker_After_Click_Next)) {

					logInfo("Only specific no.of months are enabled in calendar for scheduling.");

				} else {

					throw new BSROException(
							"Critical : No.Of months enabled in calendar are more than business rule limit.");
				}

				for (int loopCount = 1; loopCount < BLFunctions.BLRulesData.ScheduleAppointmentDateField.nextMonthsAllowedForScheduling; loopCount++) {

					prev = datePicker
							.findElement(By
									.xpath("//div[@id='ui-datepicker-div']/div/a/span"));

					prev.click();

					Thread.sleep(2 * 1000);

				}

			} else {

				throw new BSROException("Element identification required.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			throw new BSROException(e);
		}

	}
}
