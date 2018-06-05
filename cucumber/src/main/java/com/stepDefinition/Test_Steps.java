package com.stepDefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	public WebDriver driver;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//    	WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
//		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//    	WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("http://www.rediff.com/");
        driver.get("https://ghrms.csscorp.com/HRMS/");
//	    throw new PendingException();
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() {
//		driver.findElement(By.xpath("//u[text()='rediffmail']")).click();
		System.out.println("Test");
//	    throw new PendingException();
	}

/*	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() {
        driver.findElement(By.id("login1")).sendKeys("testuser_1"); 
        driver.findElement(By.id("password")).sendKeys("Test@123");
//        throw new PendingException();
	}*/
	
/*	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_UserName_and_Password(String username, String password) {
        driver.findElement(By.id("login1")).sendKeys(username); 
        driver.findElement(By.id("password")).sendKeys(password);
	}*/
	
/*	@When("^User enters username and password$")
	public void user_enters_username_and_password(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		int i=data.size();
		System.out.println("Test datas: "+i);
	    // Write code here that turns the phrase above into concrete actions
		for(int j=0;j<=3;j++){
		driver.findElement(By.id("login1")).clear();
        driver.findElement(By.id("login1")).sendKeys(data.get(0).get(0));
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
		}
	    // For automatic transformation, change DataTable to one of
//	     List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
//	    throw new PendingException();
	}*/
	
	@When("^User enters username and password$")
	public void user_enters_UserName_and_Password(DataTable usercredentials) {
		for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)) {
	        driver.findElement(By.id("ssoid")).sendKeys(data.get("Username")); 
	        driver.findElement(By.id("ssopass")).sendKeys(data.get("Password"));
		    driver.findElement(By.xpath("//button[@type='sbumit']")).click();
		    }
	}

	@Then("^Error Message displayed$")
	public void error_message_displayed() {
//	    driver.findElement(By.name("proceed")).click();
//	    String errorMessage = driver.findElement(By.xpath("//div[@class='heading']")).getText();
//	    System.out.println("Warning messages: "+errorMessage);
		System.out.println("Finished");
		driver.quit();
//	    throw new PendingException();
	}

}
