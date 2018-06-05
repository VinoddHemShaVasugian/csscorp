package contactUS_us_en;

import org.testng.annotations.Test;

import com.hybird.SuperTestNG;

public class CONT_US_EN_005 extends SuperTestNG {
  @Test
  public void Verify_elementPresent() throws Exception {
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
	  }
}