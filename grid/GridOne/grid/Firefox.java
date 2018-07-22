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

public class Firefox {
	public static WebDriver driver;
	public static String URL = "https://www.google.co.in/";
	public static String Node1 = "http://10.50.35.8:4444/wd/hub";
	@Test
	public void firefoxExecution() throws MalformedURLException {
//		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		System.out.println("FF - DesiredCapabilities done");

		driver = new RemoteWebDriver(new URL(Node1), cap);
		System.out.println("FF - Connection established");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		System.out.println("FF - URL launched");
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		System.out.println("FF - Element clicked");
//		 driver.close();
		System.out.println("FF - browser quit");
	}
}
