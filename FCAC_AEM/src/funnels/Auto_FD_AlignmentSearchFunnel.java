package funnels;

import org.testng.annotations.Test;

import com.hybird.Keywords;
import com.hybird.SuperTestNG;

public class Auto_FD_AlignmentSearchFunnel extends SuperTestNG {
	@Test
	public void brakeFunnel() throws InterruptedException {
		Thread.sleep(5000);
		//
		step.clickElm("xpath", "//i[@class='icon icon-alignment']");
		Thread.sleep(5000);
		step.selectItem(
				"xpath",
				"//form[@action='/repair/alignment/alignment-results']/div/div/select[@name='year']",
				"2007");
		step.selectItem(
				"xpath",
				"//form[@action='/repair/alignment/alignment-results']/div/div/select[@name='make']",
				"Hyundai");
		step.selectItem(
				"xpath",
				"//form[@action='/repair/alignment/alignment-results']/div/div/select[@name='model']",
				"Accent");
		step.selectItem(
				"xpath",
				"//form[@action='/repair/alignment/alignment-results']/div/div/select[@name='submodel']",
				"SE");
		Thread.sleep(2000);
		step.enterText(
				"xpath",
				"//form[@action='/repair/alignment/alignment-results']/div/fieldset/input[@name='zip']",
				"10101");
		step.clickElm("xpath", "//button[text()='Get Alignment Pricing']");
		step.verifyText("xpath",
				"//div[@class='column']/h2[text()='Standard Alignment']",
				"STANDARD ALIGNMENT");
		step.verifyText("xpath",
				"//div[@class='column']/h2[text()='Lifetime Alignment']",
				"LIFETIME ALIGNMENT");
		step.clickElm("xpath", "//button[@data-type='Lifetime']");

		// V1
		String expectedResult = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 1, 5);
		step.verifyText("xpath", "//dd[text()='2007 Hyundai Accent SE']",
				expectedResult);
		step.enterText("name", "firstName", "Vinoth");
		step.enterText("name", "lastName", "Kumar");
		step.enterText("name", "email", "sathh.muthukrishnan@csscorp.com");
		Thread.sleep(3000);
		// step.clickElm("id", "emailQuoteBtn");
		// step.clickElm("xpath", "//a[@id='emailQuoteBtn']");
		step.clickElm("xpath", "//a[text()='Email Quote']");
		System.out.println("test");
		Thread.sleep(3000);
		// a[@id='emailQuoteBtn']
		step.clickElm("xpath", "//a[text()='YES']");
		Thread.sleep(5000);
		step.clickElm("xpath", "//div[@class='cta']/button[text()='Continue']");

		// V2 - Check the default service selection.
		String selectedService = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 2, 5);
		step.chkElmSelected("xpath",
				"//label[contains(text(),'Wheel Alignment')]", selectedService);

		// Select appointment date from calendar pop up.
		step.clickElm("xpath",
				"//table[@class='ui-datepicker-calendar']//a[text()='29']");
		// Select appointment timing from Select Time drop down.
		step.selectItem("xpath", "//select[@name='timeSelect']", "2:00pm");
		// Click Next step button.
		step.clickElm("xpath", "//button[text()='Next Step']");
		// Select vehicle from vehicle information fields
		step.selectItem("xpath", "//select[@name='year']", "2007");
		step.selectItem("xpath", "//select[@name='make']", "Hyundai");
		step.selectItem("xpath", "//select[@name='model']", "Accent");
		step.selectItem("xpath", "//select[@name='submodel']", "SE");
		// Providing contact information for appointment
		step.enterText("name", "firstName", "Vinoth");
		step.enterText("name", "lastName", "Kumar");
		step.enterText("name", "email", "sathish.muthukrishnan@csscorp.com");
		step.enterText("name", "phoneNumber", "9876543216");
		// Book the appointment
		step.clickElm("xpath", "//button[text()='Confirm Appointment']");
		Thread.sleep(5000);

		// Verify the appointment information on appointment confirmation page.
		String dateScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 3, 5);
		step.verifyText("xpath", "//div[@class='dateScheduled']", dateScheduled);
		String servicesScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 4, 5);
		step.verifyText("xpath", "//div[@class='servicesScheduled']",
				servicesScheduled);
		String vehicleScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 5, 5);
		step.verifyText("xpath", "//div[@class='vehicleScheduled']",
				vehicleScheduled);
		String customerScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 6, 5);
		step.verifyText("xpath", "//div[@class='customerScheduled']",
				customerScheduled);
		String storeScheduled = Keywords.getData(stestDataFile,
				"Auto_FD_AlignmentSearchFunnel", 7, 5);
		step.verifyText("xpath", "//div[@class='storeScheduled']",
				storeScheduled);

		Thread.sleep(5000);
		step.screenShot(getClass().getSimpleName());
	}
}
