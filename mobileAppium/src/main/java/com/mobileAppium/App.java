package com.mobileAppium;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Hello world!
 *
 */
public class App 
{
	public static DesiredCapabilities capabilities=null;
	public static WebDriver driver;
	public static AppiumDriver AppDriver;
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        capabilities= new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability("deviceName", "ZX1G428WR9");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("platformName", "Android");
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		AppDriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver=AppDriver;
		System.out.println("Given Result: User is on Home Page");
    }
}
