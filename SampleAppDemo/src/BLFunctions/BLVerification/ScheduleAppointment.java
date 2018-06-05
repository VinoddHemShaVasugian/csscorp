package BLFunctions.BLVerification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import resources.BLFunctions.BLVerification.ScheduleAppointmentHelper;
import Framework.BSROException;
import Framework.CoreUtils;
import Framework.HtmlBrowser;
import Framework.HtmlSelect;
import KeyWordDriven.KeyWordDrivenConstants;


/**
 * Description : Functional Test Script
 * 
 * @author css89714
 */
public class ScheduleAppointment extends ScheduleAppointmentHelper {
	/**
	 * Script Name : <b>ScheduleAppointmentDateField</b> Generated : <b>Jun 27,
	 * 2013 3:38:29 AM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/06/27
	 * @author css89714
	 * @throws BSROException
	 */

	public static void verifyActiveDaysInCalendar() throws BSROException {

		try {

			String argData = KeyWordDrivenConstants.TC_EXPECTED;

			String args[] = argData.split(";");

			String appointmentChoice = "";

			for (int loopIndex = 0; loopIndex < args.length; loopIndex++) {

				String currentArg = args[loopIndex].toLowerCase();

				if (currentArg.startsWith("appointmentchoice")) {

					appointmentChoice = currentArg.substring(
							currentArg.indexOf("=") + 1).replaceAll(";", "");

				}

			}

			if (appointmentChoice.equals("1")) {

				CoreUtils.elementClickByID("choice1-date");

				resetDatePicker();

				HtmlBrowser.waitForLoad();

			} else if (appointmentChoice.equals("2")) {

				CoreUtils.elementClickByID("choice2-date");

				resetDatePicker();

				HtmlBrowser.waitForLoad();

			}

			int dayOfMonth = BLFunctions.Utils.DataTime.getCurrentDayOfMonth();

			int totalDaysOfCurrentMonth = BLFunctions.Utils.DataTime
					.getTotalDaysOfCurrentMonth();

			int daysLeftInCurrentMonth = (totalDaysOfCurrentMonth - dayOfMonth);

			int daysNeedToEnabledTobeInNextMonth = (BLFunctions.BLRulesData.ScheduleAppointment.nextActiveDaysInCalendar
					- daysLeftInCurrentMonth - 2);

			System.out.println("daysNeedToEnabledTobeInNextMonth = "
					+ daysNeedToEnabledTobeInNextMonth);

			WebElement datePicker_Prev_Arrow = KeyWordDrivenConstants.webDriver
					.findElement(By
							.xpath("//div[@id='ui-datepicker-div']/div/a/span"));

			WebElement datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
					.findElement(By
							.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

			String beforeClick_Prev_MonthName = KeyWordDrivenConstants.webDriver
					.findElement(By.cssSelector("span.ui-datepicker-month"))
					.getText().trim();

			if (datePicker_Prev_Arrow.isDisplayed()) {

				datePicker_Prev_Arrow.click();

			}

			String afterClick_Prev_MonthName = KeyWordDrivenConstants.webDriver
					.findElement(By.cssSelector("span.ui-datepicker-month"))
					.getText().trim();

			//logInfo("beforeClick_Prev_MonthName = "	+ beforeClick_Prev_MonthName);

		//	logInfo("afterClick_Prev_MonthName = " + afterClick_Prev_MonthName);

			if (false == beforeClick_Prev_MonthName
					.equals(afterClick_Prev_MonthName)) {

				throw new BSROException(
						"Previous month arrow of calendar should not get enabled when user is in current month calendar.");

			}

			System.out.println("daysNeedToEnabledTobeInNextMonth = "
					+ daysNeedToEnabledTobeInNextMonth);

			if (daysNeedToEnabledTobeInNextMonth <= 0) {

				String monthNameBeforeNext = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.ui-datepicker-month"))
						.getText();

				datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
						.findElement(By
								.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

				String monthNameAfterNext = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.ui-datepicker-month"))
						.getText();

				//logInfo("monthNameBeforeNext = " + monthNameBeforeNext);

				//logInfo("monthNameAfterNext = " + monthNameAfterNext);

				if (false == monthNameBeforeNext.equals(monthNameAfterNext)) {

					throw new BSROException(
							"Next month arrow of calendar should not get enabled.");

				}

				int daysOfCurrentMonth = BLFunctions.Utils.DataTime
						.getTotalDaysOfCurrentMonth();

				int lastDateToEnableInCalendar = (daysOfCurrentMonth
						+ daysNeedToEnabledTobeInNextMonth + 1);

				System.out.println("lastDateToEnableInCalendar = "
						+ lastDateToEnableInCalendar);

				boolean isInvalidDateEnabled = false;

				try {

					KeyWordDrivenConstants.webDriver.findElement(
							By.linkText("" + lastDateToEnableInCalendar + 1))
							.click();

					isInvalidDateEnabled = true;

				} catch (Exception e) {
					// TODO: handle exception

				}

				if (isInvalidDateEnabled) {

				//	logError("verifyLastDate that is enabled in calendar is "+ lastDateToEnableInCalendar	+ " , but it should not.");

					throw new BSROException(
							"verifyLastDate that is enabled in calendar is "
									+ lastDateToEnableInCalendar
									+ " , but it should not.");

				}

			} else if (daysNeedToEnabledTobeInNextMonth > 0) {

				String monthNameBeforeNext = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.ui-datepicker-month"))
						.getText();

				datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
						.findElement(By
								.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

				datePicker_Next_Arrow.click();

				HtmlBrowser.waitForLoad();

				String monthNameAfterNext = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.ui-datepicker-month"))
						.getText();

				if (monthNameBeforeNext.equals(monthNameAfterNext)) {

					throw new BSROException(
							"Next month arrow of calendar should get enabled.");

				}

			} else if (false == datePicker_Next_Arrow.isEnabled()) {

				throw new BSROException(
						"Next month arrow of calendar should get enabled.");

			}

			if (daysNeedToEnabledTobeInNextMonth < totalDaysOfCurrentMonth) {

				int currentYear = BLFunctions.Utils.DataTime.getCurrentYear();

				int currentMonth = BLFunctions.Utils.DataTime
						.getCurrentMonthOfYear();

				int nextMonth = currentMonth + 1;

				int totalDaysOfNextMonth = BLFunctions.Utils.DataTime
						.getTotalDaysOfSpecificMonth(nextMonth, currentYear);

				//logInfo("totalDaysOfNextMonth = " + totalDaysOfNextMonth);

			//	logInfo("daysNeedToEnabledTobeInNextMonth = "+ daysNeedToEnabledTobeInNextMonth);

				String dateLinkToClick = "";

				while (daysNeedToEnabledTobeInNextMonth > 0) {

					datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
							.findElement(By
									.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

					if (datePicker_Next_Arrow.isDisplayed()) {

						datePicker_Next_Arrow.click();

					}

					HtmlBrowser.waitForLoad();

					if (daysNeedToEnabledTobeInNextMonth > 0) {

						dateLinkToClick = ""
								+ (daysNeedToEnabledTobeInNextMonth);

					}

					daysNeedToEnabledTobeInNextMonth -= totalDaysOfNextMonth;

				//	logInfo("totalDaysOfNextMonth = " + totalDaysOfNextMonth);

				//	logInfo("daysNeedToEnabledTobeInNextMonth = "+ daysNeedToEnabledTobeInNextMonth);

					nextMonth = nextMonth + 1;

					totalDaysOfNextMonth = BLFunctions.Utils.DataTime
							.getTotalDaysOfSpecificMonth(nextMonth, currentYear);

				}

				try {

					KeyWordDrivenConstants.webDriver.findElement(By.linkText(""
							+ (dateLinkToClick)));

					throw new BSROException(dateLinkToClick
							+ " upcoming date is in enabled state in calendar.");

				} catch (Exception e) {
					// TODO: handle exception

					//logInfo("Active Days verification in date picker success.");

				}

				datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
						.findElement(By
								.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

				String beforeClick_Next_MonthName = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.ui-datepicker-month"))
						.getText().trim();

				if (datePicker_Next_Arrow.isDisplayed()) {

					datePicker_Next_Arrow.click();

				}

				String afterClick_Next_MonthName = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.ui-datepicker-month"))
						.getText().trim();

				//logInfo("beforeClick_Next_MonthName = "+ beforeClick_Next_MonthName);

				//logInfo("afterClick_Next_MonthName = "+ afterClick_Next_MonthName);

				if (false == beforeClick_Next_MonthName
						.equals(afterClick_Next_MonthName)) {

					throw new BSROException(
							"Next link enabled in calendar , may allow user to choose date than limit.");
				}

				CoreUtils.elementClickByID("appt-choice-1");

				//logInfo("verifyActiveDaysInCalendar() function success.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			//logError("verifyActiveDaysInCalendar() function failed.");

			throw new BSROException(e);

		}

	}

	public static void verifySameDayAndTimeAppointment() throws BSROException {

		try {

			CoreUtils.elementClickByID("choice1-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			int currentDate = BLFunctions.Utils.DataTime.getCurrentDayOfMonth();

			int dateIndex = 0;

			for (;;) {

				try {

					KeyWordDrivenConstants.webDriver.findElement(
							By.linkText("" + (currentDate + dateIndex)))
							.click();

					break;

				} catch (Exception e) {

					dateIndex += 1;

					try {

						List<WebElement> webElements = KeyWordDrivenConstants.webDriver
								.findElements(By
										.cssSelector("span.ui-state-default"));

						Iterator<WebElement> iterator = webElements.iterator();

						while (iterator.hasNext()) {

							WebElement webElement = (WebElement) iterator
									.next();

							if (false == webElement.getAttribute("value")
									.trim().equals(currentDate + dateIndex)) {

								WebElement datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
										.findElement(By
												.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

								datePicker_Next_Arrow.click();

								dateIndex = 0;

								HtmlBrowser.waitForLoad();

							}

						}

					} catch (Exception ex) {
						// TODO: handle exception
					}

				}
			}

			HtmlSelect.selectItemByIndex("choice1-time", 1);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("choice2-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			dateIndex = 0;

			for (;;) {

				try {

					KeyWordDrivenConstants.webDriver.findElement(
							By.linkText("" + (currentDate + dateIndex)))
							.click();

					break;

				} catch (Exception e) {

					dateIndex += 1;

					try {

						List<WebElement> webElements = KeyWordDrivenConstants.webDriver
								.findElements(By
										.cssSelector("span.ui-state-default"));

						Iterator<WebElement> iterator = webElements.iterator();

						while (iterator.hasNext()) {

							WebElement webElement = (WebElement) iterator
									.next();

							if (false == webElement.getAttribute("value")
									.trim().equals(currentDate + dateIndex)) {

								WebElement datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
										.findElement(By
												.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

								datePicker_Next_Arrow.click();

								dateIndex = 0;

								HtmlBrowser.waitForLoad();

							}

						}

					} catch (Exception ex) {
						// TODO: handle exception
					}

				}
			}

			HtmlSelect.selectItemByIndex("choice2-time", 1);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("continueButton");

			HtmlBrowser.waitForLoad();

			String errors = KeyWordDrivenConstants.webDriver.findElement(
					By.id("choice1Date.errors")).getText();

			//logInfo("errors = " + errors);

			if (false == errors
					.contains("You cannot create 2 appointments for the same time.")) {

				throw new BSROException(
						"Can not create appointment on same error not shown.");

			}

			String selected_Date_Choice1 = KeyWordDrivenConstants.webDriver
					.findElement(By.id("choice1-date")).getText();

			String selected_Time_Choice1 = KeyWordDrivenConstants.webDriver
					.findElement(By.id("choice1-time")).getAttribute("value");

			String selected_Date_Choice2 = KeyWordDrivenConstants.webDriver
					.findElement(By.id("choice2-date")).getText();

			String selected_Time_Choice2 = KeyWordDrivenConstants.webDriver
					.findElement(By.id("choice2-time")).getAttribute("value");

			if (selected_Date_Choice1.equals(selected_Date_Choice2)
					&& selected_Time_Choice1.equals(selected_Time_Choice2)) {

				//logInfo("verifySameDayAndTimeAppointment() success.");

			} else {

				throw new BSROException(
						"Same date time values not selected for appointments.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			//logError("verifySameDayAndTimeAppointment() function failed.");

			throw new BSROException(e);

		}

	}

	public static void verifySameDayAndDiffrentTimeAppointment()
			throws BSROException {

		try {

			String storeTimingsDetailsOnWeekDays = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("M-F: ", "").trim();

			String storeTimingsDetailsOnSaturDay = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[2]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Sa: ", "").trim();

			String storeTimingsDetailsOnSunday = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[3]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Su: ", "").trim();

			String storeOpeningTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(0, storeTimingsDetailsOnWeekDays.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(storeTimingsDetailsOnWeekDays.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(0, storeTimingsDetailsOnSaturDay.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(storeTimingsDetailsOnSaturDay.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(0, storeTimingsDetailsOnSunday.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(storeTimingsDetailsOnSunday.indexOf("-") + 1)
					.toUpperCase();

		//	logInfo("storeOpeningTimeOnWeekDays = "		+ storeOpeningTimeOnWeekDays);

		//	logInfo("storeClosingTimeOnWeekDays = "+ storeClosingTimeOnWeekDays);

		//	logInfo("storeOpeningTimeOnSaturDay = "	+ storeOpeningTimeOnSaturDay);

		//	logInfo("storeClosingTimeOnSaturDay = "		+ storeClosingTimeOnSaturDay);

		//	logInfo("storeOpeningTimeOnSunday = " + storeOpeningTimeOnSunday);

		//	logInfo("storeClosingTimeOnSunday = " + storeClosingTimeOnSunday);

			int currentDayOfWeek = BLFunctions.Utils.DataTime
					.getCurrentDayOfWeek() + 1;

			//logInfo("currentDayOfWeek = " + currentDayOfWeek);

			String choice1Time = "";

			String choice2Time = "";

			if (currentDayOfWeek <= 5) {

				choice1Time = "1:00pm";

				choice2Time = "2:00pm";

			} else if (currentDayOfWeek == 6) {

				choice1Time = "1:00pm";

				choice2Time = "2:00pm";

			} else if (currentDayOfWeek == 7) {

				choice1Time = "1:00pm";

				choice2Time = "2:00pm";

			} else {

				choice1Time = "1:00pm";

				choice2Time = "2:00pm";

			}

			CoreUtils.elementClickByID("choice1-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			int currentDate = BLFunctions.Utils.DataTime.getCurrentDayOfMonth();

			int dateIndex = 0;

			for (;;) {

				try {

					KeyWordDrivenConstants.webDriver.findElement(
							By.linkText("" + (currentDate + dateIndex)))
							.click();

					break;

				} catch (Exception e) {

					dateIndex += 1;

					try {

						List<WebElement> webElements = KeyWordDrivenConstants.webDriver
								.findElements(By
										.cssSelector("span.ui-state-default"));

						Iterator<WebElement> iterator = webElements.iterator();

						while (iterator.hasNext()) {

							WebElement webElement = (WebElement) iterator
									.next();

							if (false == webElement.getAttribute("value")
									.trim().equals(currentDate + dateIndex)) {

								WebElement datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
										.findElement(By
												.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

								datePicker_Next_Arrow.click();

								dateIndex = 0;

								HtmlBrowser.waitForLoad();

							}

						}

					} catch (Exception ex) {
						// TODO: handle exception
					}

				}
			}

			// HtmlSelect.selectItemByID_Selenium("choice1-time", choice1Time);

			HtmlSelect.selectItemByIndex("choice1-time", 1);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("choice2-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			dateIndex = 0;

			for (;;) {

				try {

					KeyWordDrivenConstants.webDriver.findElement(
							By.linkText("" + (currentDate + dateIndex)))
							.click();

					break;

				} catch (Exception e) {

					dateIndex += 1;

					try {

						List<WebElement> webElements = KeyWordDrivenConstants.webDriver
								.findElements(By
										.cssSelector("span.ui-state-default"));

						Iterator<WebElement> iterator = webElements.iterator();

						while (iterator.hasNext()) {

							WebElement webElement = (WebElement) iterator
									.next();

							if (false == webElement.getAttribute("value")
									.trim().equals(currentDate + dateIndex)) {

								WebElement datePicker_Next_Arrow = KeyWordDrivenConstants.webDriver
										.findElement(By
												.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span"));

								datePicker_Next_Arrow.click();

								dateIndex = 0;

								HtmlBrowser.waitForLoad();

							}

						}

					} catch (Exception ex) {
						// TODO: handle exception
					}

				}

			}

			HtmlSelect.selectItemByIndex("choice2-time", 5);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("continueButton");

			HtmlBrowser.waitForLoad();

			String pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.cssSelector("h2.step-title")).getText();

			if (pageHeader.contains("Provide Contact Information")) {

				//logInfo("verifySameDayAndDiffrentTimeAppointment() success.");

			} else {

				throw new BSROException(
						"verifySameDayAndDiffrentTimeAppointment() function failed.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			//logError("verifySameDayAndTimeAppointment() function failed.");

			throw new BSROException(e);

		}

	}

	public static void verifySameDayAndDiffrentTimeAppointmentMinTimeDiff()
			throws BSROException {

		try {

			String storeTimingsDetailsOnWeekDays = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("M-F: ", "").trim();

			String storeTimingsDetailsOnSaturDay = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[2]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Sa: ", "").trim();

			String storeTimingsDetailsOnSunday = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[3]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Su: ", "").trim();

			String storeOpeningTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(0, storeTimingsDetailsOnWeekDays.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(storeTimingsDetailsOnWeekDays.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(0, storeTimingsDetailsOnSaturDay.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(storeTimingsDetailsOnSaturDay.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(0, storeTimingsDetailsOnSunday.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(storeTimingsDetailsOnSunday.indexOf("-") + 1)
					.toUpperCase();

		//	logInfo("storeOpeningTimeOnWeekDays = "	+ storeOpeningTimeOnWeekDays);

		//	logInfo("storeClosingTimeOnWeekDays = "	+ storeClosingTimeOnWeekDays);

		//	logInfo("storeOpeningTimeOnSaturDay = "		+ storeOpeningTimeOnSaturDay);

		//	logInfo("storeClosingTimeOnSaturDay = "	+ storeClosingTimeOnSaturDay);

		//	logInfo("storeOpeningTimeOnSunday = " + storeOpeningTimeOnSunday);

		//	logInfo("storeClosingTimeOnSunday = " + storeClosingTimeOnSunday);

			int currentDayOfWeek = BLFunctions.Utils.DataTime
					.getCurrentDayOfWeek() + 1;

		//	logInfo("currentDayOfWeek = " + currentDayOfWeek);

			String choice1Time = "";

			String choice2Time = "";

			if (currentDayOfWeek <= 5) {

				choice1Time = "11:00am";

				choice2Time = "11:15am";

			} else if (currentDayOfWeek == 6) {

				choice1Time = "11:00am";

				choice2Time = "11:15am";

			} else if (currentDayOfWeek == 7) {

				choice1Time = "11:00am";

				choice2Time = "11:15am";

			} else {

				choice1Time = "11:00am";

				choice2Time = "11:15am";

			}

			CoreUtils.elementClickByID("choice1-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			int currentDate = BLFunctions.Utils.DataTime.getCurrentDayOfMonth();

			KeyWordDrivenConstants.webDriver.findElement(
					By.linkText("" + (currentDate + 1))).click();

			HtmlSelect.selectItemByIndex("choice1-time", 1);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("choice2-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(
					By.linkText("" + (currentDate + 1))).click();

			HtmlSelect.selectItemByIndex("choice2-time", 2);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("continueButton");

			HtmlBrowser.waitForLoad();

			String pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.cssSelector("h2.step-title")).getText();

		//	logInfo("pageHeader = " + pageHeader);

			if (pageHeader.contains("Provide Contact Information")) {

		//		logInfo("verifySameDayAndDiffrentTimeAppointmentMinHoursDiff() success.");

			} else {

				throw new BSROException(
						"verifySameDayAndDiffrentTimeAppointmentMinHoursDiff() function failed.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			//logError("verifySameDayAndDiffrentTimeAppointmentMinHoursDiff() function failed.");

			throw new BSROException(e);

		}

	}

	public static void verifySameDayAndDiffrentTimeAppointmentsBeforeNoonOnWeekEnds()
			throws BSROException {

		try {

			String storeTimingsDetailsOnWeekDays = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("M-F: ", "").trim();

			String storeTimingsDetailsOnSaturDay = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[2]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Sa: ", "").trim();

			String storeTimingsDetailsOnSunday = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[3]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Su: ", "").trim();

			String storeOpeningTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(0, storeTimingsDetailsOnWeekDays.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(storeTimingsDetailsOnWeekDays.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(0, storeTimingsDetailsOnSaturDay.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(storeTimingsDetailsOnSaturDay.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(0, storeTimingsDetailsOnSunday.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(storeTimingsDetailsOnSunday.indexOf("-") + 1)
					.toUpperCase();

		//	logInfo("storeOpeningTimeOnWeekDays = "	+ storeOpeningTimeOnWeekDays);

		//	logInfo("storeClosingTimeOnWeekDays = "	+ storeClosingTimeOnWeekDays);

		//	logInfo("storeOpeningTimeOnSaturDay = "			+ storeOpeningTimeOnSaturDay);

		//	logInfo("storeClosingTimeOnSaturDay = "		+ storeClosingTimeOnSaturDay);

			//logInfo("storeOpeningTimeOnSunday = " + storeOpeningTimeOnSunday);

		//	logInfo("storeClosingTimeOnSunday = " + storeClosingTimeOnSunday);

			int currentDayOfTheWeek = BLFunctions.Utils.DataTime
					.getCurrentDayOfWeek();

			int daysLeftForNextWeekEnd = -1;

			if (currentDayOfTheWeek <= 5) {

				daysLeftForNextWeekEnd = (6 - currentDayOfTheWeek);
			}

			if (daysLeftForNextWeekEnd == 0) {

				daysLeftForNextWeekEnd += 1;

			}

			int nextDayOfWeek = BLFunctions.Utils.DataTime
					.getCurrentDayOfWeek() + 1;

			//logInfo("nextDayOfWeek = " + nextDayOfWeek);

			String choice1Time = "";

			String choice2Time = "";

			if (nextDayOfWeek <= 5) {

				choice1Time = "10:30am";

				choice2Time = "11:30am";

			} else if (nextDayOfWeek == 6) {

				choice1Time = "10:30am";

				choice2Time = "11:30am";

			} else if (nextDayOfWeek == 7) {

				choice1Time = "10:30am";

				choice2Time = "11:30am";

			} else {

				choice1Time = "10:30am";

				choice2Time = "11:30am";
			}

			CoreUtils.elementClickByID("choice1-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			int currentDate = BLFunctions.Utils.DataTime.getCurrentDayOfMonth();

			KeyWordDrivenConstants.webDriver.findElement(
					By.linkText("" + (currentDate + daysLeftForNextWeekEnd)))
					.click();

			HtmlSelect.selectItemByIndex("choice1-time", 1);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("choice2-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(
					By.linkText("" + (currentDate + daysLeftForNextWeekEnd)))
					.click();

			HtmlSelect.selectItemByIndex("choice2-time", 2);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("continueButton");

			HtmlBrowser.waitForLoad();

			String pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.cssSelector("h2.step-title")).getText();

		//	logInfo("pageHeader = " + pageHeader);

			if (pageHeader.contains("Provide Contact Information")) {

				throw new BSROException(
						"verifySameDayAndDiffrentTimeAppointmentBeforeNoonOnWeekEnds() BL verification failed..");

			} else {

			//	logInfo("verifySameDayAndDiffrentTimeAppointmentBeforeNoonOnWeekEnds() function success.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			//logError("verifySameDayAndDiffrentTimeAppointmentBeforeNoonOnWeekEnds() function failed.");

			throw new BSROException(e);

		}

	}

	public static void verifySameDayAndDiffrentTimeAppointmentsAfterNoonOnWeekEnds()
			throws BSROException {

		try {

			String storeTimingsDetailsOnWeekDays = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("M-F: ", "").trim();

			String storeTimingsDetailsOnSaturDay = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[2]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Sa: ", "").trim();

			String storeTimingsDetailsOnSunday = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[3]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Su: ", "").trim();

			String storeOpeningTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(0, storeTimingsDetailsOnWeekDays.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(storeTimingsDetailsOnWeekDays.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(0, storeTimingsDetailsOnSaturDay.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(storeTimingsDetailsOnSaturDay.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(0, storeTimingsDetailsOnSunday.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(storeTimingsDetailsOnSunday.indexOf("-") + 1)
					.toUpperCase();

			//logInfo("storeOpeningTimeOnWeekDays = "		+ storeOpeningTimeOnWeekDays);

			//logInfo("storeClosingTimeOnWeekDays = "	+ storeClosingTimeOnWeekDays);

		//	logInfo("storeOpeningTimeOnSaturDay = "			+ storeOpeningTimeOnSaturDay);

		//	logInfo("storeClosingTimeOnSaturDay = "		+ storeClosingTimeOnSaturDay);

			//logInfo("storeOpeningTimeOnSunday = " + storeOpeningTimeOnSunday);

			//logInfo("storeClosingTimeOnSunday = " + storeClosingTimeOnSunday);

			int currentDayOfTheWeek = BLFunctions.Utils.DataTime
					.getCurrentDayOfWeek();

			int daysLeftForNextWeekEnd = -1;

			if (currentDayOfTheWeek <= 5) {

				daysLeftForNextWeekEnd = (6 - currentDayOfTheWeek);
			}

			if (daysLeftForNextWeekEnd == 0) {

				daysLeftForNextWeekEnd += 1;

			}

			int nextDayOfWeek = BLFunctions.Utils.DataTime
					.getCurrentDayOfWeek() + 1;

			//logInfo("nextDayOfWeek = " + nextDayOfWeek);

			String choice1Time = "";

			String choice2Time = "";

			if (nextDayOfWeek <= 5) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else if (nextDayOfWeek == 6) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else if (nextDayOfWeek == 7) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else {

				choice1Time = "10:30am";

				choice2Time = "11:30am";

			}

			CoreUtils.elementClickByID("choice1-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			int currentDate = BLFunctions.Utils.DataTime.getCurrentDayOfMonth();

			KeyWordDrivenConstants.webDriver.findElement(
					By.linkText("" + (currentDate + daysLeftForNextWeekEnd)))
					.click();

			HtmlSelect.selectItemByIndex("choice1-time", 1);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("choice2-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(
					By.linkText("" + (currentDate + daysLeftForNextWeekEnd)))
					.click();

			HtmlSelect.selectItemByIndex("choice2-time", 2);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("continueButton");

			HtmlBrowser.waitForLoad();

			String pageHeader = KeyWordDrivenConstants.webDriver.findElement(
					By.cssSelector("h2.step-title")).getText();

		//	logInfo("pageHeader = " + pageHeader);

			if (false == pageHeader.contains("Provide Contact Information")) {

				throw new BSROException(
						"verifySameDayAndDiffrentTimeAppointmentAfterNoonOnWeekEnds() BL verification failed..");

			} else {

			//	logInfo("verifySameDayAndDiffrentTimeAppointmentAfterNoonOnWeekEnds() function success.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			//logError("verifySameDayAndDiffrentTimeAppointmentAfterNoonOnWeekEnds() function failed.");

			throw new BSROException(e);

		}

	}

	public static void verifyEligibleTimeIntervalsOnWeekDays()
			throws BSROException {

		try {

			String storeTimingsDetailsOnWeekDays = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("M-F: ", "").trim();

			String storeTimingsDetailsOnSaturDay = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[2]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Sa: ", "").trim();

			String storeTimingsDetailsOnSunday = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[3]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Su: ", "").trim();

			String storeOpeningTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(0, storeTimingsDetailsOnWeekDays.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(storeTimingsDetailsOnWeekDays.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(0, storeTimingsDetailsOnSaturDay.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(storeTimingsDetailsOnSaturDay.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(0, storeTimingsDetailsOnSunday.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(storeTimingsDetailsOnSunday.indexOf("-") + 1)
					.toUpperCase();

			//logInfo("storeOpeningTimeOnWeekDays = "+ storeOpeningTimeOnWeekDays);

			//logInfo("storeClosingTimeOnWeekDays = "	+ storeClosingTimeOnWeekDays);

		//	logInfo("storeOpeningTimeOnSaturDay = "				+ storeOpeningTimeOnSaturDay);

		//	logInfo("storeClosingTimeOnSaturDay = "		+ storeClosingTimeOnSaturDay);

		//	logInfo("storeOpeningTimeOnSunday = " + storeOpeningTimeOnSunday);

		//	logInfo("storeClosingTimeOnSunday = " + storeClosingTimeOnSunday);

			int currentDayOfTheWeek = BLFunctions.Utils.DataTime
					.getCurrentDayOfWeek();

		//	logInfo("currentDayOfTheWeek = " + currentDayOfTheWeek);

			int nextDateAdd = 0;

			int nextDayOfWeek = currentDayOfTheWeek + 1;

			if (currentDayOfTheWeek == 6) {

				nextDateAdd = 3;

			} else if (currentDayOfTheWeek == 7) {

				nextDateAdd = 2;

			} else {

				nextDateAdd = 1;

			}

		//	logInfo("nextDayOfWeek = " + nextDayOfWeek);

			String choice1Time = "";

			String choice2Time = "";

			if (nextDayOfWeek <= 5) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else if (nextDayOfWeek == 6) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else if (nextDayOfWeek == 7) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			}

			CoreUtils.elementClickByID("choice1-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			int currentDate = BLFunctions.Utils.DataTime.getCurrentDayOfMonth();

			KeyWordDrivenConstants.webDriver.findElement(
					By.linkText("" + (currentDate + nextDateAdd))).click();

			HtmlSelect.selectItemByIndex("choice1-time", 1);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("choice2-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(
					By.linkText("" + (currentDate + nextDateAdd))).click();

			HtmlSelect.selectItemByIndex("choice2-time", 2);

			HtmlBrowser.waitForLoad();

			ArrayList<String> expectedIntervals = BLFunctions.Utils.DataTime
					.dateSplit(
							storeOpeningTimeOnWeekDays,
							storeClosingTimeOnWeekDays,
							BLFunctions.BLRulesData.ScheduleAppointment.eligibleStartTimeDeviationOnWeekDaysAfterStoreOpenTime,
							BLFunctions.BLRulesData.ScheduleAppointment.eligibleEndTimeDeviationOnWeekDaysBeforeStoreCloseTime);

			ArrayList<String> choice1Intervals = HtmlSelect
					.getAllListItemsByID("choice1-time");

			choice1Intervals.remove(0);

			ArrayList<String> choice2Intervals = HtmlSelect
					.getAllListItemsByID("choice2-time");

			choice2Intervals.remove(0);

			//logInfo("expectedIntervals = " + expectedIntervals);

			//logInfo("choice1Intervals = " + choice1Intervals);

			//logInfo("choice2Intervals = " + choice2Intervals);

			if (expectedIntervals.size() != choice1Intervals.size()) {

				throw new BSROException(
						"Choice1-Time intervals combo data validation failed.");
			}

			if (expectedIntervals.size() != choice2Intervals.size()) {

				throw new BSROException(
						"Choice2-Time intervals combo data validation failed , verifyEligibleTimeIntervalsOnWeekDays() failed.");
			}

			//logInfo("verifyEligibleTimeIntervalsOnWeekDays() BL validation success");

		} catch (Exception e) {
			// TODO: handle exception

		//	logError("verifyEligibleTimeIntervalsOnWeekDays() function failed.");

			throw new BSROException(e);

		}

	}

	public static void verifyEligibleTimeIntervalsOnWeekEndDays()
			throws BSROException {

		try {

			String storeTimingsDetailsOnWeekDays = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("M-F: ", "").trim();

			String storeTimingsDetailsOnSaturDay = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[2]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Sa: ", "").trim();

			String storeTimingsDetailsOnSunday = KeyWordDrivenConstants.webDriver
					.findElement(
							By.xpath("//div[@id='content']/div[2]/div/ul/li[3]"))
					.getText().replaceAll("\\r\\n|\\r|\\n", " ")
					.replaceAll("am", " am").replaceAll("pm", " pm")
					.replaceAll("	", "").replaceAll("Su: ", "").trim();

			String storeOpeningTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(0, storeTimingsDetailsOnWeekDays.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnWeekDays = storeTimingsDetailsOnWeekDays
					.substring(storeTimingsDetailsOnWeekDays.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(0, storeTimingsDetailsOnSaturDay.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSaturDay = storeTimingsDetailsOnSaturDay
					.substring(storeTimingsDetailsOnSaturDay.indexOf("-") + 1)
					.toUpperCase();

			String storeOpeningTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(0, storeTimingsDetailsOnSunday.indexOf("-"))
					.toUpperCase();

			String storeClosingTimeOnSunday = storeTimingsDetailsOnSunday
					.substring(storeTimingsDetailsOnSunday.indexOf("-") + 1)
					.toUpperCase();

		//	logInfo("storeOpeningTimeOnWeekDays = "			+ storeOpeningTimeOnWeekDays);

		//	logInfo("storeClosingTimeOnWeekDays = "		+ storeClosingTimeOnWeekDays);

		//	logInfo("storeOpeningTimeOnSaturDay = "	+ storeOpeningTimeOnSaturDay);

		//	logInfo("storeClosingTimeOnSaturDay = "		+ storeClosingTimeOnSaturDay);

		//	logInfo("storeOpeningTimeOnSunday = " + storeOpeningTimeOnSunday);

		//	logInfo("storeClosingTimeOnSunday = " + storeClosingTimeOnSunday);

			int currentDayOfTheWeek = BLFunctions.Utils.DataTime
					.getCurrentDayOfWeek();

		//	logInfo("currentDayOfTheWeek = " + currentDayOfTheWeek);

			int nextDateAdd = 0;

			int nextDayOfWeek = currentDayOfTheWeek + 1;

			if (currentDayOfTheWeek == 7) {

				nextDateAdd = 0;

			} else if (currentDayOfTheWeek != 7) {

				nextDateAdd = (7 - currentDayOfTheWeek);

			}

		//	logInfo("nextDayOfWeek = " + nextDayOfWeek);

			String choice1Time = "";

			String choice2Time = "";

			if (nextDayOfWeek <= 5) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else if (nextDayOfWeek == 6) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else if (nextDayOfWeek == 7) {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";

			} else {

				choice1Time = "1:30pm";

				choice2Time = "2:30pm";
			}

			CoreUtils.elementClickByID("choice1-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			int currentDate = BLFunctions.Utils.DataTime.getCurrentDayOfMonth();

			int dateIndex1 = nextDateAdd;

			for (;;) {

				try {

					System.out.println("Yet to click = "
							+ (currentDate + dateIndex1));

					KeyWordDrivenConstants.webDriver.findElement(
							By.linkText("" + (currentDate + dateIndex1)))
							.click();

					break;

				} catch (Exception e) {
					// TODO: handle exception

					dateIndex1 += 7;

					System.out.println("dateIndex = " + dateIndex1);

				}

			}

			HtmlSelect.selectItemByIndex("choice1-time", 1);

			HtmlBrowser.waitForLoad();

			CoreUtils.elementClickByID("choice2-date");

			resetDatePicker();

			HtmlBrowser.waitForLoad();

			int dateIndex2 = nextDateAdd;

			for (;;) {

				try {

					System.out.println("Yet to click = "
							+ (currentDate + dateIndex2));

					KeyWordDrivenConstants.webDriver.findElement(
							By.linkText("" + (currentDate + dateIndex2)))
							.click();

					break;

				} catch (Exception e) {
					// TODO: handle exception

					dateIndex2 += 7;

					System.out.println("dateIndex = " + dateIndex2);

				}

			}

			HtmlSelect.selectItemByIndex("choice2-time", 2);

			HtmlBrowser.waitForLoad();

			@SuppressWarnings("unchecked")
			ArrayList<String> expectedIntervals = BLFunctions.Utils.DataTime
					.dateSplit(
							storeOpeningTimeOnSaturDay,
							storeClosingTimeOnSaturDay,
							BLFunctions.BLRulesData.ScheduleAppointment.eligibleStartTimeDeviationOnWeekEndsAfterStoreOpenTime,
							BLFunctions.BLRulesData.ScheduleAppointment.eligibleEndTimeDeviationOnWeekEndsBeforeStoreCloseTime);

			ArrayList<String> choice1Intervals = HtmlSelect
					.getAllListItemsByID("choice1-time");

			choice1Intervals.remove(0);

			ArrayList<String> choice2Intervals = HtmlSelect
					.getAllListItemsByID("choice2-time");

			choice2Intervals.remove(0);

			//logInfo("expectedIntervals = " + expectedIntervals);

		//	logInfo("choice1Intervals = " + choice1Intervals);

		//	logInfo("choice2Intervals = " + choice2Intervals);

			if (expectedIntervals.size() != choice1Intervals.size()) {

				throw new BSROException(
						"Choice1-Time intervals combo data validation failed.");
			}

			if (expectedIntervals.size() != choice2Intervals.size()) {

				throw new BSROException(
						"Choice2-Time intervals combo data validation failed , verifyEligibleTimeIntervalsOnWeekDays() failed.");
			}

		//	logInfo("verifyEligibleTimeIntervalsOnWeekDays() BL validation success");

		} catch (Exception e) {
			// TODO: handle exception

		//	logError("verifyEligibleTimeIntervalsOnWeekDays() function failed.");

			throw new BSROException(e);

		}

	}

	private static void resetDatePicker() throws BSROException {

		try {

			for (;;) {

				String monthBeforeClick = "";

				String monthAfterClick = "";

				monthBeforeClick = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.ui-datepicker-month"))
						.getText().trim();

				try {

					KeyWordDrivenConstants.webDriver
							.findElement(
									By.xpath("//div[@id='ui-datepicker-div']/div/a/span"))
							.click();

				} catch (Exception e) {
					// TODO: handle exception
				}

				HtmlBrowser.waitForLoad();

				monthAfterClick = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("span.ui-datepicker-month"))
						.getText().trim();

			//	logInfo("monthBeforeClick = " + monthBeforeClick);

			//	logInfo("monthAfterClick = " + monthAfterClick);

				if (monthBeforeClick.equals(monthAfterClick)) {

					break;

				}

			}

		} catch (Exception e) {
			// TODO: handle exception

	//		logError("resetDatePicker() function failed.");

			throw new BSROException(e);

		}

	}

}
