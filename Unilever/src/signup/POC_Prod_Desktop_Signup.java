package signup;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.hybird.SuperTestNG;

public class POC_Prod_Desktop_Signup extends SuperTestNG {
  @Test
  public void signup() throws Exception {
	  	step.clickElm("className", "bws-signup");
	  	step.verifyText("className", "bws-form-heading", "SIGN UP");
	  	step.verifyText("tagname", "small", "* indicates required information");
	  	step.chkElmPresent("id", "emailId", "E-mail Address");
	  	step.chkElmPresent("id", "firstName", "firstName");
	  	step.chkElmPresent("id", "lastName", "lastName");
	  	step.chkElmPresent("id", "address1", "address1");
	  	step.chkElmPresent("id", "address2", "address2");
	  	step.chkElmPresent("id", "city", "city");
	  	step.chkElmPresent("id", "state", "state");
	  	step.chkElmPresent("id", "zip", "zip");
	  	step.chkElmPresent("id", "dob", "dob");
	  	step.chkElmPresent("id", "OptInHeading", "OptInHeading");
	  	step.chkElmPresent("id", "capture-container", "recaptcha_challenge_image");
	  	step.chkElmPresent("id", "submit", "submit");
		String emailWarningMsg = "E-mail should include an @, (.) period,( _) underscore, (–) hyphen and allow for hyphenated names";
	  	//Invalid cases 
	  	step.clear("id", "emailId");
	  	step.clickElm("id", "submit");
		step.verifyText("xpath", "//div[@for='emailId']", "Please fill out this field.");
		step.enterText("id", "emailId", "1234567890onetwothre1234567890twentythre1234567890thirtythre@csscor@in");
		step.verifyText("xpath", "//div[@for='emailId']", emailWarningMsg);
		step.enterText("id", "emailId", "1234567890onetwothre1234567890twentythre1234567890thirtythreecsscorpin");
		step.verifyText("xpath", "//div[@for='emailId']", emailWarningMsg);
//		//valid case
		step.enterText("id", "emailId", "testing@unilever.com");
		step.chkElmPresent("className", "bws-check", "Email validation success notification");
	  	step.enterText("id", "firstName", "firstname@123");
	  	step.getElement("id", "firstName").sendKeys(Keys.TAB);
	  	step.verifyText("xpath", "//div[@for='firstName']", "Letters or punctuation only please");
	  	step.enterText("id", "firstName", "John");		
		step.enterText("id", "lastName", "lastname@123");
	  	step.getElement("id", "lastName").sendKeys(Keys.TAB);
	  	step.verifyText("xpath", "//div[@for='lastName']", "Letters or punctuation only please");
	  	step.enterText("id", "lastName", "Mircovich");
	  	step.enterText("id", "address1", "850 Coddingtown Ctr");
	  	step.enterText("id", "address2", "Travis Blvd");
	  	step.enterText("id", "city", "Fairfield");
	  	step.selectItem("id", "state", "California");
	  	step.clear("id", "zip");
	  	step.clickElm("id", "submit");
	  	step.verifyText("xpath", "//div[@for='zip']", "Please fill out this field.");
	  	step.enterText("id", "zip", "5265");
	  	step.getElement("id", "zip").sendKeys(Keys.TAB);
	  	step.enterText("id", "zip", "test");
	  	step.verifyText("xpath", "//div[@for='zip']", "Please enter valid Zip Code.");
	  	step.enterText("id", "zip", "95401");
	  	step.clickElm("id", "submit");
	  	step.verifyText("xpath", "//div[@for='dob']", "Please fill out this field.");
//	  	step.clickElm("id", "dob");
//	  	step.selectItem("className", "ui-datepicker-year", "2015");
//	  	step.selectItem("className", "ui-datepicker-month", "Feb");
//	  	step.clickElm("xpath", "//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[5]/a");
	  	step.enterTextInCalendar("id", "dob", "02/08/2016");
	  	step.clickElm("id", "submit");
//	  	step.verifyText("xpath", "//div[@for='dob']", "Based on your calculated age and data collection restrictions for children online we can not accept your inquiry.");
//	  	step.enterTextInCalendar("id", "dob", "02/08/1998");
//	  	Thread.sleep(5000);
//	  	step.clickElm("id", "submit");
//	  	step.verifyText("xpath", "//h1", "THANK YOU FOR SIGNING UP");
  }
}
