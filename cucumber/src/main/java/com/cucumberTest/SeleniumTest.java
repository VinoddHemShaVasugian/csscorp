package com.cucumberTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest 
{
//	public static WebDriver driver;	
    public static void main( String[] args )
    {
    
    	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/guru99home/");
        List<WebElement> sibling = driver.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[@class='rt-grid-2 rt-omega']"));
        
        System.out.println("Using Sibling");
        for(WebElement we:sibling){
        	String sib=we.getText();
        	System.out.println(sib);
        }
        
        System.out.println("Using Anscestor");
        List<WebElement> ancestorWB=driver.findElements(By.xpath("//div[.//a[text()='SELENIUM']]/ancestor::div[@class='rt-grid-2 rt-omega']/following-sibling::div"));
        for(WebElement we1:ancestorWB){
        	String ans=we1.getText();
        	System.out.println(ans);
        }
        System.out.println("Login Successfully");
        driver.quit();
    }
}