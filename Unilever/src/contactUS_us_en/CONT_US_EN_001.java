package contactUS_us_en;

import org.testng.annotations.Test;

import com.hybird.SuperTestNG;

public class CONT_US_EN_001 extends SuperTestNG {
  @Test
  public void Verify_Static_Content() throws Exception {
//	  String expectedvalue = "CONTACT US\n"
//	  		+ "Thank you for visiting the Breyers  ® , web site.\n"
//	  		+ "If you would like to speak to a consumer advisor please call us at:\n"
//	  		+ "1-800-931-2826  Monday-Friday 8:30 AM-9:00 PM Eastern Time.\n"
//	  		+ "IF THIS IS A MEDICAL OR PRODUCT SAFETY EMERGENCY, PLEASE CALL 1-800-745-9269. This number is available 24 hours a day / 7 days a week.\n"
//	  		+ "If you are reporting a problem with one of our products, please be sure to include your address and a telephone number where you can be reached during the day so we can contact you for further information.\n"
//	  		+ "Unilever does not collect personal information from children under 13.\n"
//	  		+ "* indicates required information";
//	  	  step.verifyText("className", "bws-form-module-header", expectedvalue);
	  String expectedvalue = "CONTACT US";
	  step.verifyText("className", "bws-form-heading", expectedvalue); //Working for Desktop and Android --> For IOS //*[@text='Contact Us']
//	  step.verifyText("xpath", "//*[@text='Contact Us']", expectedvalue);
	
	  }
}
