package funnels;

import org.testng.annotations.Test;

import com.hybird.Keywords;
import com.hybird.SuperTestNG;

public class Auto_FD_TireSearchFunnel extends SuperTestNG {
	@Test
	public void tireSearchFunnel() throws InterruptedException {
		Thread.sleep(5000);
		// Select "By Tire Size" widget
		step.clickElm("xpath", "//span[text()=\"By Tire Size\"]");
		// Select the value CrossSection drop down
		step.selectItem("name", "crossSection", "215");
		// Select the value AspectRatio drop down
		step.selectItem("name", "aspectRatio", "55");
		// Select the value RimSize drop down
		step.selectItem("name", "rimSize", "17");
		// Enter the Zip code in "Zip code" field
		step.enterText("className", "zip-by-tire-size", "10101");
		// Click the "Get Tire Pricing button
		step.clickElm("xpath", "//button[@data-model='byTire']");
		Thread.sleep(5000);
		// V1 - Verify the Tire size in Tire result page
		String tireSize = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 1, 5);
		step.verifyText("xpath", "//dd[text()='215-55-17']", tireSize);
		// Click the "Get Quote" button for required tire in result page
		step.clickElm(
				"xpath",
				"//div[@class='product Primewell price-0 Performance  215/55R17 Standard mileage-1']//a[@data-article='833']");
		Thread.sleep(10000);
		// Click "Reserve & Buy In Store" button
		step.clickElm("xpath", "//a[text()='Reserve & Buy In Store']");
		Thread.sleep(10000);
		// V2 - Check the default service selection.
		String selectedService = Keywords.getData(stestDataFile,
				"Auto_FD_TireSearchFunnel", 2, 5);
		step.chkElmSelected("xpath",
				"//label[contains(text(),'Tire Replacement')]", selectedService);
		// Select appointment date from calendar pop up.
		step.clickElm("xpath",
				"//table[@class='ui-datepicker-calendar']//a[text()='29']");
		// Select appointment timing from Select Time drop down.
		step.selectItem("xpath", "//select[@name='timeSelect']", "4:00pm");
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
		// step.clickElm("xpath", "//button[text()='Confirm Appointment']");
		// Thread.sleep(5000);
		//
		// // Verify the appointment information on appointment confirmation
		// page.
		// String dateScheduled = Keywords.getData(stestDataFile,
		// "Auto_FD_TireSearchFunnel", 3, 5);
		// step.verifyText("xpath", "//div[@class='dateScheduled']",
		// dateScheduled);
		// String servicesScheduled = Keywords.getData(stestDataFile,
		// "Auto_FD_TireSearchFunnel", 4, 5);
		// step.verifyText("xpath", "//div[@class='servicesScheduled']",
		// servicesScheduled);
		// String vehicleScheduled = Keywords.getData(stestDataFile,
		// "Auto_FD_TireSearchFunnel", 5, 5);
		// step.verifyText("xpath", "//div[@class='vehicleScheduled']",
		// vehicleScheduled);
		// String customerScheduled = Keywords.getData(stestDataFile,
		// "Auto_FD_TireSearchFunnel", 6, 5);
		// step.verifyText("xpath", "//div[@class='customerScheduled']",
		// customerScheduled);
		// String storeScheduled = Keywords.getData(stestDataFile,
		// "Auto_FD_TireSearchFunnel", 7, 5);
		// step.verifyText("xpath", "//div[@class='storeScheduled']",
		// storeScheduled);

		// Take screenshot
		Thread.sleep(10000);
		step.screenShot(getClass().getSimpleName());
	}
}