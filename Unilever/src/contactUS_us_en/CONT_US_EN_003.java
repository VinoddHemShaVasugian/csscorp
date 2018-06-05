package contactUS_us_en;

import org.testng.annotations.Test;

import com.hybird.SuperTestNG;
//Test Cases: Verify Error Message (validate copy) is displayed if no selection is made in Type of Inquiry field.
//Expected Result: Following error message should be displayed: Please select the Type of Inquiry.
public class CONT_US_EN_003 extends SuperTestNG {
  @Test
  public void Type_of_Inquiry_Error_Message() throws Exception {
	  step.clickElm("id", "submit");
	  step.verifyText("xpath", "//div[@for='idInquiryType']", "Please fill out this field.");
	  }
}
