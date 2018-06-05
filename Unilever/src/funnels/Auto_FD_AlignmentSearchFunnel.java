package funnels;

import object.Repo.read_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hybird.Keywords;
import com.hybird.SuperTestNG;

public class Auto_FD_AlignmentSearchFunnel extends SuperTestNG {
	@Test
	public void alignment_funnel() throws Exception {
		Thread.sleep(5000);
		try{
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties", "select_alignment_widget"));
		Thread.sleep(10000);
		step.selectItem("xpath", read_locators.get_property(
				"alignment.funnel.properties", "d_widget_select_year"), "2007");
		step.selectItem("xpath", read_locators.get_property(
				"alignment.funnel.properties", "d_widget_select_make"),
				"Hyundai");
		step.selectItem("xpath", read_locators.get_property(
				"alignment.funnel.properties", "d_widget_select_model"),
				"Accent");
		step.selectItem("xpath", read_locators.get_property(
				"alignment.funnel.properties", "d_widget_select_submodel"),
				"SE");
		Thread.sleep(2000);
		step.enterText("xpath", read_locators.get_property(
				"alignment.funnel.properties", "t_enter_zip_code"), "10101");
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties", "b_click_get_alignment_pricing"));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(read_locators.get_property(
						"alignment.funnel.properties",
						"verify_standard_alignment"))));

		step.verifyText("xpath", read_locators.get_property(
				"alignment.funnel.properties", "verify_standard_alignment"),
				"STANDARD ALIGNMENT");
		step.verifyText("xpath", read_locators.get_property(
				"alignment.funnel.properties", "verify_lifetime_alignment"),
				"LIFETIME ALIGNMENT");
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties", "b_select_lifetime_alignment"));

		// V1
		/*String expectedResult = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 1, 5);
		 step.verifyText("xpath",read_locators.get_property("alignment.funnel.properties",
		 "verify_vehicle_information"), expectedResult);
		 */
		step.enterText("name", read_locators.get_property(
				"alignment.funnel.properties", "t_quote_enter_firstname"),
				"Vinoth");
		step.enterText("name", read_locators.get_property(
				"alignment.funnel.properties", "t_quote_enter_lastname"),
				"Kumar");
		step.enterText("name", read_locators.get_property(
				"alignment.funnel.properties", "t_quote_enter_email"),
				"sathish.muthukrishnan@csscorp.com");
		Thread.sleep(3000);
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties", "b_click_email_quote"));
		Thread.sleep(3000);
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties", "b_proceed_appoitment"));
		Thread.sleep(5000);
//		if(step.chkElmPresent("xpath", read_locators.get_property(
//				"alignment.funnel.properties", "verify_heading"))){
//		step.clickElm("xpath", read_locators.get_property(
//					"alignment.funnel.properties", "b_select_store"));
//		}
		
		// V2 - Check the default service selection.
		String selectedService = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 2, 5);
		step.chkElmSelected("xpath", read_locators.get_property(
				"alignment.funnel.properties", "verify_selected_service"),
				selectedService);

		// Select appointment date from calendar pop up.
		Thread.sleep(5000);
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties", "navigate_to_next_month"));
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties", "select_Calendar_popup"));
		// Select appointment timing from Select Time drop down.
		step.selectItem("xpath", read_locators.get_property(
				"alignment.funnel.properties", "d_select_appointment_time"),
				"9:00am");
		// Click Next step button.
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties", "b_click_next"));

		// Select vehicle from vehicle information fields
		step.selectItem("name", read_locators.get_property(
				"alignment.funnel.properties", "d_select_year"), "2007");
		step.selectItem("name", read_locators.get_property(
				"alignment.funnel.properties", "d_select_make"), "Hyundai");
		step.selectItem("name", read_locators.get_property(
				"alignment.funnel.properties", "d_select_model"), "Accent");
		step.selectItem("name", read_locators.get_property(
				"alignment.funnel.properties", "d_select_submodel"), "SE");

		// Providing contact information for appointment
		step.enterText("name", read_locators.get_property(
				"alignment.funnel.properties", "t_enter_first_name"), "Vinoth");
		step.enterText("name", read_locators.get_property(
				"alignment.funnel.properties", "t_enter_last_name"),
				"Kumar");
		step.enterText("name", read_locators.get_property(
				"alignment.funnel.properties", "t_enter_email"),
				"sathish.muthukrishnan@csscorp.com");
		step.enterText("name", read_locators.get_property(
				"alignment.funnel.properties", "t_enter_phone_number"),
				"9876543216");
		// Book the appointment
		step.clickElm("xpath", read_locators.get_property(
				"alignment.funnel.properties",
				"b_click_appointment_confirmation"));
		Thread.sleep(2000);
		// Verify the appointment information on appointment confirmation page.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//h2[text()='Thank You. Your Appointment Is Scheduled']")));

//		String dateScheduled = Keywords.getData(stestDataFile,
//				"Auto_FD_AlignmentSearchFunnel", 3, 5);
//		step.verifyText("xpath", read_locators.get_property(
//				"alignment.funnel.properties", "verify_appointment_date&time"),
//				dateScheduled);
		String servicesScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 4, 5);
		step.verifyText("xpath", read_locators.get_property(
				"alignment.funnel.properties", "verify_appointment_service"),
				servicesScheduled);
		String vehicleScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 5, 5);
		step.verifyText("xpath", read_locators.get_property(
				"alignment.funnel.properties", "verify_appointment_vehicle"),
				vehicleScheduled);
		String customerScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 6, 5);
		step.verifyText("xpath", read_locators.get_property(
				"alignment.funnel.properties",
				"verify_appointment_Customername"), customerScheduled);
		String storeScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 7, 5);
		step.verifyText("xpath", read_locators.get_property(
				"alignment.funnel.properties", "verify_appointment_store"),
				storeScheduled);
		
		}catch (Exception e) {
			step.clickElm("xpath", read_locators.get_property(
					"alignment.funnel.properties", "feedback_popup"));
		}
		
		Thread.sleep(5000);
		step.screenShot(getClass().getSimpleName());
	}
}