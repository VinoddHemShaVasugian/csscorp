package Execution;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Constants.Constants;
import Framework.Browser;
import ResultLogs.ResultLogger;
import ResultLogs.ResultLogger.ISSTEPACTION;
import ResultLogs.ResultLogger.RESULT;
import Startup.EntryPoint;

public class ObjectHandler {

	public static void GetWebElement()
    {
        try
        {
        	splitTarget();
        	if(Constants.OSType.toUpperCase().equals("IOS")){
//        		String str = (String)EntryPoint.AppDriver.executeScript("seetest:client.elementGetText(\"NATIVE\", \"xpath=//*[@id='countryTextField']\", \"0\")");
//        		String str = (String)EntryPoint.AppDriver.executeScript("seetest:client.elementGetText(\"NATIVE\", \"xpath=//*[@id='countryTextField']\", \"0\));
        		Constants.webElement=EntryPoint.AppDriver.findElement(Constants.by);
                  	
        	}
        	  	
        	else if(Constants.OSType.toUpperCase().equals("WINDOWS")){
//        		Browser.untilAngularFinishHttpCalls();
            	
                
//                String s=EntryPoint.driver.getPageSource();
                //  System.out.println("");
                  Constants.webElement=EntryPoint.driver.findElement(Constants.by);
                  	
        	}
        	else{
        		
        		  Constants.webElement=EntryPoint.AppDriver.findElement(Constants.by);
        	}
        	
            ResultLogger.log("Element Found in the page", ISSTEPACTION.False, RESULT.PASS);

        }
        catch (Exception ex)
        {
           ResultLogger.log(ex.getMessage(),ISSTEPACTION.False,RESULT.EXCEPTION);
           //System.out.println("");
        }
        if(Constants.OSType.toUpperCase().equals("WINDOWS")){
        	
        try {
			HighlightMyElement(Constants.webElement);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to highlight the element");
		}
        }
    }
	public static void GetWebElements()
    {
        try
        {
            splitTarget();

            Constants.webElements=EntryPoint.driver.findElements(Constants.by);
            
            ResultLogger.log("Element Found in the page", ISSTEPACTION.False, RESULT.PASS);

        }
        catch (Exception ex)
        {
           ResultLogger.log(ex.getMessage(),ISSTEPACTION.False,RESULT.EXCEPTION);
        }
        if(Constants.OSType.toUpperCase().equals("WINDOWS")||Constants.OSType.toUpperCase().equals("ANDROID")){
        try {
			HighlightMyElement(Constants.webElement);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to highlight the element");
		}
        }
    }
	
	public static void HighlightMyElement(WebElement element)
			throws InterruptedException {
		JavascriptExecutor highlight = (JavascriptExecutor) EntryPoint.driver;
		// To highlight an Element
		highlight.executeScript(
				"arguments[0].setAttribute('style', arguments[1]);", element,
				"background: cyan; border: 5px solid yellow;");
//		Thread.sleep(2000);
		// To make the element default
		highlight.executeScript(
				"arguments[0].setAttribute('style', arguments[1]);", element,
				"");

	}
	
	public static void splitTarget()
	{	
		/* To Split and Store the Property type and Property Values from Target */
		 
          if (Constants.sTarget.toUpperCase().startsWith("ID"))
            {
                Constants.tPropValue = Constants.sTarget.split("=")[1];
 
                Constants.tPropType = "ID";
 
                Constants.by = By.id(Constants.tPropValue);
                
                
 
            }
            else if (Constants.sTarget.toUpperCase().startsWith("NAME"))
            {
                Constants.tPropValue = Constants.sTarget.split("=")[1];
 
                Constants.tPropType = "NAME";
 
                Constants.by = By.name(Constants.tPropValue);
 
            }
            else if (Constants.sTarget.toUpperCase().startsWith("CSS"))
            {
                Constants.tPropValue = Constants.sTarget.split("=")[1];
 
                Constants.tPropType = "CSS";
 
                Constants.by = By.cssSelector(Constants.tPropValue);
 
            }
            else if (Constants.sTarget.toUpperCase().startsWith("TAGNAME"))
            {
                Constants.tPropValue = Constants.sTarget.split("=")[1];
 
                Constants.tPropType = "TAGNAME";
 
                Constants.by = By.cssSelector(Constants.tPropValue);
 
            }
            else if (Constants.sTarget.toUpperCase().startsWith("CLASS"))
            {
                Constants.tPropValue = Constants.sTarget.split("=")[1];
 
                Constants.tPropType = "CLASS";
 
                Constants.by = By.className(Constants.tPropValue);
 
            }
            else if (Constants.sTarget.toUpperCase().startsWith("LINK"))
            {
                Constants.tPropValue = Constants.sTarget.split("=")[1];
 
                Constants.tPropType = "LINK";
 
                Constants.by = By.linkText(Constants.tPropValue);
 
            }
            else if (Constants.sTarget.toUpperCase().startsWith("XPATH"))
            {
//                Constants.tPropValue = Constants.sTarget.split("=")[1];
            	Constants.tPropValue = Constants.sTarget.substring(Constants.sTarget.indexOf("=")+1);
 
                Constants.tPropType = "XPATH";
 
                Constants.by = By.xpath(Constants.tPropValue);
 
            }
            else if (Constants.sTarget.toUpperCase().startsWith("//"))
            {
                Constants.tPropValue = Constants.sTarget;
 
                Constants.tPropType = "XPATH";
 
                Constants.by = By.xpath(Constants.tPropValue);
 
            }
            else if(Constants.sTarget.toUpperCase().startsWith(".//"))
            {
                Constants.tPropValue = Constants.sTarget;
 
                Constants.tPropType = "XPATH";
 
                Constants.by = By.xpath(Constants.tPropValue);
            }
            else if(Constants.sTarget.toUpperCase().startsWith("(//"))
            {
                Constants.tPropValue = Constants.sTarget;
 
                Constants.tPropType = "XPATH";
 
                Constants.by = By.xpath(Constants.tPropValue);
            }
            else
            {
                ResultLogger.log("Invalid Target Identified - "+Constants.sTarget, ISSTEPACTION.False,RESULT.FAIL);
            }
//          HighlightMyElement();
	}
    
	
}
