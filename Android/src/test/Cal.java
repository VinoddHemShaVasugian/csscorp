package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class Cal {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {

//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "/Apps/bsro/");
//		File app = new File(appDir, "dev_fcac_1st_Feb_2017.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("VERSION", "6.0.1");
//		capabilities.setCapability("deviceName", "0123456789ABCDEF");
		capabilities.setCapability("deviceName", "CC555YG05626");
		
		
		
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		System.out.println("test1");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		System.out.println("test2");
	}

	@Test
	public void appointment() throws Exception {
		System.out.println("Test case executed");
	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}