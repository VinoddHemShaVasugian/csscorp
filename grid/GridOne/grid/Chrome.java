package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class Chrome {
	public static WebDriver driver;
	public static String URL = "https://www.facebook.com/";
	public static String Node1 = "http://10.50.35.8:4444/wd/hub";
	@Test
	public void chromeExecution() throws MalformedURLException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.VISTA);
/*		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);*/

		System.out.println("Chrome - DesiredCapabilities done");
		driver = new RemoteWebDriver(new URL(Node1), cap);
		System.out.println("Chrome - Connection established");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		System.out.println("Chrome - URL launched");
		driver.findElement(By.xpath("//a[text()='தமிழ்']")).click();
		System.out.println("Chrome - Element clicked");
//		 driver.close();
		System.out.println("Chrome - browser quit");
	}
}
