package com.hybird;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperTestNG {
	public static WebDriver driver;
//	public static AppiumDriver AppDriver;
//	public static String browserType;
	public static Keywords step;
	public static String sConfigFile = "./Files/Configuration.xlsx";
	public static String stestDataFile = "./TestData/TestData.xlsx";
	
	@BeforeMethod
	public void preConditions() {
//		String browserType = Keywords.getData(sConfigFile, "LAUNCH", 0, 2);
		String browserType = "Chrome";  // Firefox, Chrome or IE
		step = new Keywords(browserType);
		driver = step.getDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
//		String url = Keywords.getData(sConfigFile, "LAUNCH", 1, 2);
//		String url = "https://www.stives.com/contact-us";
//		String url = "https://www.popsicle.com/contact-us";
//		String url = "https://www.axe.com/us/en/secure/helpcenter/contact-us.html";
//		String url = "https://www.degreedeodorant.com/us/en/secure/contactus.html";
//		String url = "https://www.talentigelato.com/contact-us";
		String url = "https://secure.breyers.com/contact-us";
		driver.get(url);

		// ((JavascriptExecutor)
		// driver).executeScript("return document.readyState").equals("complete");

	}

	@AfterMethod
	public void postConditions() throws IOException {

		try {
			if (driver != null) {
//				driver.close();
				driver.quit();
//				 Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				// Runtime.getRuntime().exec("taskkill /IM chromedriver.exe*32 /F");
			}
		} catch (Exception ex) {
			// driver.close();
//			 Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
//			 Runtime.getRuntime().exec("taskkill /IM chromedriver.exe /F");
		}
	}
}