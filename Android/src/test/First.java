package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class First {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and
		// app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// File classpathRoot = new File(System.getProperty("user.dir"));
		// File appDir = new File(classpathRoot, "/Apps/bsro/");
		// File app = new File(appDir, "dev_fcac_1st_Feb_2017.apk");
		capabilities.setCapability("BROWSER_NAME", "Android");
//		capabilities.setCapability("VERSION", "5.1");
//		capabilities.setCapability("deviceName", "IrisX8415E0002067");
//		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("VERSION", "6.0.1");
		capabilities.setCapability("deviceName", "CC555YG05626");
		capabilities.setCapability("platformName", "Android");
		String browser = capabilities.getBrowserName();
		System.out.println(browser);
		// capabilities.setCapability("app", app.getAbsolutePath());
		// capabilities.setCapability("appPackage", "com.bsro.fcac");
		// This package name of your app (you can get it from apk info app)

		// capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
//		 configurations specified in Desired Capabilities..
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@Test
	public void testCal() throws Exception {
		driver.get("https://www.tiresplus.com");
		System.out.println("test");
		// locate the Text on the calculator by using By.name()
		/*
		 * WebElement two=driver.findElement(By.name("2")); two.click();
		 * WebElement plus=driver.findElement(By.name("+")); plus.click();
		 * WebElement four=driver.findElement(By.name("4")); four.click();
		 * WebElement equalTo=driver.findElement(By.name("=")); equalTo.click();
		 * //locate the edit box of the calculator by using By.tagName()
		 * WebElement results=driver.findElement(By.tagName("EditText")); //
		 * Check the calculated value on the edit box assert
		 * results.getText().equals("6"):"Actual value is : "+results.getText()+
		 * " did not match with expected value: 6";
		 */
	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}