package contactUS_us_en;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.hybird.SuperTestNG;
public class CONT_US_EN_005_EmailID_Field extends SuperTestNG {
  @Test
  public void Email_length() throws Exception {
	  String emailWarningMsg = "E-mail should include an @, (.) period,( _) underscore, (–) hyphen and allow for hyphenated names";
	  //Invalid cases
	  step.enterText("id", "emailId", "1234567890onetwothre1234567890twentythre1234567890thirtythre@csscor@in");
	  step.verifyText("xpath", "//div[@for='emailId']", emailWarningMsg);
	  step.enterText("id", "emailId", "1234567890onetwothre1234567890twentythre1234567890thirtythreecsscorpin");
	  step.verifyText("xpath", "//div[@for='emailId']", emailWarningMsg);
	//valid case
	  step.enterText("id", "emailId", "testing@csscorp.com");
	  step.chkElmPresent("className", "bws-check", "Email validation success notification");
	  
//	  step.verifyText("id", "emailid", "1234567890onetwothre1234567890twentythre1234567890thirtythre@csscorp.in");
//	  step.verifyText("xpath", "//div[@for='emailId']", emailWarningMsg);
//	  WebElement value = step.getElement("xpath", "//input[@placeholder='E-mail Address:']");
//	  placeholder="E-mail Address:"
//	  String input = value.getText();
//	  Actions a1=new Actions(step.getDriver());
//	  a1.contextClick(value).perform();
//	  a1.sendKeys(Keys.chord(Keys.CONTROL,"a")).perform();
//	  a1.sendKeys(Keys.chord(Keys.CONTROL,"c")).perform();
//	  String email = "testing@csscorp.com";
//	  
//	  String input = a1.sendKeys(Keys.chord(Keys.CONTROL,"v")).toString();
//	  String input = a1.sendKeys(Keys.chord(Keys.CONTROL,"v")).release().toString();
	  
//	  WebElement pastevalue = step.getElement("id", "address1");
//	  Actions a2=new Actions(step.getDriver());
//	  a2.contextClick(pastevalue).perform();
//	  a2.sendKeys(Keys.chord(Keys.CONTROL,"v")).perform();
	  
//	  step.enterText("id", "address1", a1.sendKeys(Keys.chord(Keys.CONTROL,"v")).perform());
//	  String input=a1.toString();
	  
//	  a1.sendKeys("Ctrl+A").perform();
//	  String input=a1.sendKeys("CTRL+C").toString();
//	  a1.moveToElement(value).doubleClick().build().perform();
//	  Actions input = a1.sendKeys(Keys.chord(Keys.CONTROL,"c"));
	  
//	  String input=a1.sendKeys(Keys.chord(Keys.CONTROL,"c")).toString();
//	  System.out.println("Input Value: "+input);	  
	  }
}