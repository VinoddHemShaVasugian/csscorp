package contactUS_us_en;

import org.testng.annotations.Test;

import com.hybird.SuperTestNG;

public class ContactUs extends SuperTestNG {
  @Test
  public void Verify_Static_Content() throws Exception {

	  String expectedvalue = "CONTACT US";
//	  step.verifyText("className", "bws-form-heading", expectedvalue);
	  step.clickElm("id", "submit");
	  step.verifyText("xpath", "//div[@for='idInquiryType']", "Please fill out this field.");
	  step.selectItem("xpath", "//*[@id='idInquiryType']", "Product Concern");
	  step.verifyText("xpath", "//label[@for='idUPCDetails']", "UPC Details: *"); // Desktop and Android
	  step.verifyText("xpath", "//label[@for='idManufacturingCodeDetails']", "Manufacturing Code Details: *");
	  step.chkElmPresent("id", "emailId", "EmailId");
//	  step.chkElmPresent("xpath", "//*[@id='emailId']");
	  step.chkElmPresent("id", "prefix", "Prefix");
	  step.chkElmPresent("id", "firstName", "FirstName");
	  step.chkElmPresent("id", "lastName", "lastName");
	  step.chkElmPresent("id", "address1", "Address 1");
	  step.chkElmPresent("id", "address2", "Address 2");
	  step.chkElmPresent("id", "city", "City");
	  step.chkElmPresent("id", "state", "State");
	  step.chkElmPresent("id", "zip", "Zip");
	  step.chkElmPresent("id", "primePhone", "PrimePhone");
	  step.chkElmPresent("id", "primePhoneExt", "PrimePhone Ext");
	  step.chkElmPresent("id", "secPhone", "SecPhone");
	  step.chkElmPresent("id", "secPhoneExt", "SecPhone Ext");
	  step.chkElmPresent("className", "form-group", "Language Preference");
	  String emailWarningMsg = "E-mail should include an @, (.) period,( _) underscore, (–) hyphen and allow for hyphenated names";
	  //Invalid cases
	  step.enterText("id", "emailId", "1234567890onetwothre1234567890twentythre1234567890thirtythre@csscor@in");
	  step.verifyText("xpath", "//div[@for='emailId']", emailWarningMsg);
	  step.enterText("id", "emailId", "1234567890onetwothre1234567890twentythre1234567890thirtythreecsscorpin");
	  step.verifyText("xpath", "//div[@for='emailId']", emailWarningMsg);
	//valid case
	  step.enterText("id", "emailId", "testing@csscorp.com");
	  step.chkElmPresent("className", "bws-check", "Email validation success notification");
  }
}
