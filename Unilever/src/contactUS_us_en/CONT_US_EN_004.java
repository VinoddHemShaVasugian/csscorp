package contactUS_us_en;

import org.testng.annotations.Test;

import com.hybird.SuperTestNG;

public class CONT_US_EN_004 extends SuperTestNG {
  @Test
  public void Type_of_Inquiry_Product_Concern() throws Exception {
	  step.selectItem("xpath", "//*[@id='idInquiryType']", "Product Concern");
	  step.verifyText("xpath", "//label[@for='idUPCDetails']", "UPC Details: *"); // Desktop and Android
	  step.verifyText("xpath", "//label[@for='idManufacturingCodeDetails']", "Manufacturing Code Details: *");
	 }
}