package com.hybird;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperTestNG {
	public static WebDriver driver;
	public static Keywords step;
	public static String sConfigFile = "./Files/Configuration.xlsx";
	public static String stestDataFile = "./TestData/TestData.xlsx";

	@BeforeMethod
	public void preConditions() {
		String browserType = Keywords.getData(sConfigFile, "LAUNCH", 0, 2);
		step = new Keywords(browserType);
		// driver.manage().deleteAllCookies();
		driver = step.getDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		String url = Keywords.getData(sConfigFile, "LAUNCH", 1, 2);
		driver.get(url);
	}

	@AfterMethod
	public void postConditions() {
		// driver.quit();
		if (driver != null) {
			driver.close();
		}
	}
}