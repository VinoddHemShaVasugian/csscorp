package com.cucumberTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCSSValue 
{
//	public static WebDriver driver;	
    public static void main( String[] args )
    {
    
    	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        driver.get("https://www.linkedin.com/");
        String buttonColor = driver.findElement(By.xpath("//input[@id='registration-submit']")).getCssValue("background-color");
        String buttonTextColor = driver.findElement(By.xpath("//input[@id='registration-submit']")).getCssValue("color");
        System.out.println("Button color: " + buttonColor);
        System.out.println("Text color " + buttonTextColor);
        
    }
}