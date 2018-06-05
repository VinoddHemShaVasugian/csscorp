package funnels;

import object.Repo.read_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hybird.Keywords;
import com.hybird.SuperTestNG;

public class Auto_FD_TireSearchFunnel extends SuperTestNG {
	@Test
	public void tire_funnel() throws Exception {
		Thread.sleep(5000);
		// Select "By Tire Size" widget
		// step.clickElm("xpath",
		// "//span[text()=\"By Tire Sizread_locatorse\"]");
		step.clickElm("xpath", read_locators.get_property(
				"tires.funnel.properties", "by_tire_size"));
		// Select the value CrossSection drop down
		step.selectItem("name", read_locators.get_property(
				"tires.funnel.properties", "d_select_crossSection"), "215");
		// Select the value AspectRatio drop down
		step.selectItem("name", read_locators.get_property(
				"tires.funnel.properties", "d_select_aspectRatio"), "55");
		// Select the value RimSize drop down
		step.selectItem("name", read_locators.get_property(
				"tires.funnel.properties", "d_select_rimSize"), "17");
		// Enter the Zip code in "Zip code" field
		step.enterText("className", read_locators.get_property(
				"tires.funnel.properties", "t_enter_zip_code"), "10101");
		// Click the "Get Tire Pricing button
		step.clickElm("xpath", read_locators.get_property(
				"tires.funnel.properties", "b_click_get_tire_pricing"));
		Thread.sleep(5000);
		// V1 - Verify the Tire size in Tire result page

		String tireSize = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 1, 5);
		step.verifyText("xpath", read_locators.get_property(
				"tires.funnel.properties", "verify_tire_size"), tireSize);

		// Click the "Get Quote" button for required tire in result page
		step.clickElm("xpath", read_locators.get_property(
				"tires.funnel.properties", "b_click_get_quote"));
		Thread.sleep(10000);

		// Click "Reserve & Buy In Store" button
		step.clickElm("xpath", read_locators.get_property(
				"tires.funnel.properties", "b_click_reserve_buy"));
		Thread.sleep(10000);

		// V2 - Check the default service selection.
		String selectedService = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 2, 5);
		step.chkElmSelected("xpath", read_locators.get_property(
				"tires.funnel.properties", "verify_selected_service"),
				selectedService);

		// Select appointment date from calendar pop up.
		step.clickElm("xpath", read_locators.get_property(
				"tires.funnel.properties", "navigate_to_next_month"));
		step.clickElm("xpath", read_locators.get_property(
				"tires.funnel.properties", "select_Calendar_popup"));

		// Select appointment timing from Select Time drop down.
		step.selectItem("xpath", read_locators.get_property(
				"tires.funnel.properties", "d_select_appointment_time"),
				"11:00am");

		// Click Next step button.
		step.clickElm("xpath", read_locators.get_property(
				"tires.funnel.properties", "b_click_next"));

		// Select vehicle from vehicle information fields
		step.selectItem("name", read_locators.get_property(
				"tires.funnel.properties", "d_select_year"), "2007");
		step.selectItem("name", read_locators.get_property(
				"tires.funnel.properties", "d_select_make"), "Hyundai");
		step.selectItem("name", read_locators.get_property(
				"tires.funnel.properties", "d_select_model"), "Accent");
		step.selectItem("name", read_locators.get_property(
				"tires.funnel.properties", "d_select_submodel"), "SE");

		// Providing contact information for appointment
		step.enterText("name", read_locators.get_property(
				"tires.funnel.properties", "t_enter_first_name"), "Sathish");
		step.enterText("name", read_locators.get_property(
				"tires.funnel.properties", "t_enter_last_name"),
				"Muthukrishnan");
		step.enterText("name", read_locators.get_property(
				"tires.funnel.properties", "t_enter_email"),
				"sathish.muthukrishnan@csscorp.com");
		step.enterText("name", read_locators.get_property(
				"tires.funnel.properties", "t_enter_phone_number"),
				"9876543216");
		// Book the appointment
		step.clickElm("xpath", read_locators.get_property(
				"tires.funnel.properties", "b_click_appointment_confirmation"));
		Thread.sleep(5000);
		// Verify the appointment information on appointment confirmation page.
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//h2[text()='Thank You. Your Appointment Is Scheduled']")));

		// Verify the appointment information on appointment confirmation page.
		String dateScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 3, 5);
		step.verifyText("xpath", read_locators.get_property(
				"tires.funnel.properties", "verify_appointment_date&time"),
				dateScheduled);
		String servicesScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 4, 5);
		step.verifyText("xpath", read_locators.get_property(
				"tires.funnel.properties", "verify_appointment_service"),
				servicesScheduled);
		String vehicleScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 5, 5);
		step.verifyText("xpath", read_locators.get_property(
				"tires.funnel.properties", "verify_appointment_vehicle"),
				vehicleScheduled);
		String customerScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 6, 5);
		step.verifyText("xpath", read_locators.get_property(
				"tires.funnel.properties", "verify_appointment_Customername"),
				customerScheduled);
		String storeScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 7, 5);
		step.verifyText("xpath", read_locators.get_property(
				"tires.funnel.properties", "verify_appointment_store"),
				storeScheduled);

		// Take screenshot
		Thread.sleep(10000);
		step.screenShot(getClass().getSimpleName());
	}
}