package stepDefinition;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	public static DesiredCapabilities capabilities=null;
	public static WebDriver driver;
	public static AppiumDriver AppDriver;

	@Given("^User is on Home Page$")
	public void User_is_on_Home_Page() throws Throwable {
        capabilities= new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability("deviceName", "ZX1G428WR9");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("platformName", "Android");
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		AppDriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver=AppDriver;
		System.out.println("Browser opened");
		driver.get("https://www.gmail.com");
		System.out.println("URL Launched");
		
		System.out.println("Given Result: User is on Home Page");
	}

	@When("^User Navigate to LogIn Page$")
	public void User_Navigate_to_LogIn_Page() throws Throwable {
		System.out.println("When Result: User Navigate to LogIn Page");
	}

	@When("^User enters UserName and Password$")
	public void User_enters_UserName_and_Password() throws Throwable {
		System.out.println("When Result: User enters UserName and Password");
	}

	@Then("^Message displayed Login Successfully$")
	public void Message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Then Result: Message displayed Login Successfully");
	}
	

}
