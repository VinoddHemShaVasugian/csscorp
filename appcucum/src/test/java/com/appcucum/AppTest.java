package com.appcucum;

import java.util.Set;

import javax.servlet.http.Cookie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AppTest{
	
public static void main(String[] args){
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.firestonecompleteautocare.com");
	Set<org.openqa.selenium.Cookie> allCookies = driver.manage().getCookies();
	for(org.openqa.selenium.Cookie c:allCookies){
		System.out.println(c);
	}
	driver.manage().deleteAllCookies();
	System.out.println("Getting cookies again");
	Set<org.openqa.selenium.Cookie> againAllCookies = driver.manage().getCookies();
	for(org.openqa.selenium.Cookie d:againAllCookies){
		System.out.println("Retry cookies"+d);
	}
	System.out.println("Program End");
	driver.quit();
	}
}
