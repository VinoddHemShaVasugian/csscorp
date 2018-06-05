package Framework;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Framework.CoreUtilsHelper;
import KeyWordDriven.KeyWordDrivenConstants;



import java.util.regex.*;;

/**
 * Description : Functional Test Script
 * 
 * @author admin
 */
public class CoreUtils  {
	/**
	 * Script Name : <b>CoreUtils</b> Generated : <b>Apr 11, 2013 5:56:39 PM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7600 ()
	 * 
	 * @since 2013/04/11
	 * @author admin
	 * @throws BSROException
	 * @throws InterruptedException 
	 */

	public static boolean isExists(String name) throws BSROException, InterruptedException {

		Framework.HtmlBrowser.getCurrentBrowserWindowObject();

		boolean isExists = false;

		try {


			isExists = true;


		} catch (Exception e) {

			// TODO: handle exception
		}

		return isExists;
	}


	public void clickReqDate(String date, String month, String year)
			throws BSROException {

		/*RegularExpression dateHrefReProp = new RegularExpression(
				"javascript:dateHandler\\(%20" + date + "," + month
						+ ",\\d+%20\\);", true);

		// Finding the object from the dialog which has properties of
		// class as Html.A and href as dateHrefProp
		TestObject[] dateObjs = find(atDescendant(".class", "Html.A", ".href",
				dateHrefReProp));

		System.out.println(dateObjs.length);

		// converting the testObject to GuiTestObject
		GuiTestObject dateObj = (GuiTestObject) dateObjs[0];
		dateObj.waitForExistence();
		 */
		// getting the text property of the date at runtime.
		/*String runtimeDate = (String) dateObj.getProperty(".text");
		System.out.println("Date: " + runtimeDate);*/

		// Comparing the String that is passed through the method with that of
		// the
		// date String that we got at runtime.
		/*
		if (runtimeDate.equalsIgnoreCase(date)) {
			dateObj.click();
		}

		// unregistering of the object.
		dateObj.unregister();*/

	}

	// public void closeAllIEBrowserWindows() {
	//
	// IWindow[] winsobj = getTopWindows();
	//
	// for (int idx = 0; idx < winsobj.length; ++idx) {
	//
	// if (winsobj[idx].getWindowClassName().equals("IEFrame")) {
	//
	// winsobj[idx].close();
	//
	// }
	//
	// }
	//
	// }
	//
	// public void closeAllFirefoxBrowserWindows() {
	//
	// IWindow[] winsobj = getTopWindows();
	//
	// for (int idx = 0; idx < winsobj.length; ++idx) {
	//
	// if (winsobj[idx].getWindowClassName()
	// .equals("MozillaUIWindowClass")) {
	//
	// winsobj[idx].close();
	//
	// }
	//
	// }
	//
	// }

	// public void captureScreenShot(String Screenshotname) {
	//
	// try {
	//
	// Toolkit toolkit = Toolkit.getDefaultToolkit();
	//
	// Dimension screenSize = toolkit.getScreenSize();
	//
	// Rectangle screenRect = new Rectangle(screenSize);
	//
	// Robot robot = new Robot();
	//
	// // Capture the screen shot of the area of the screen defined by the
	// // rectangle
	// // BufferedImage bi=bc.getScreenSnapshot(new Rectangle(100,100));
	//
	// BufferedImage bi = robot.createScreenCapture(screenRect);
	//
	// // ImageIO.write(bi, "jpg", new File("C:/SRM5510/" + Screenshotname
	// // + ".jpg"));
	//
	// } catch (AWTException e) {
	//
	// e.printStackTrace();
	//
	// }
	//
	// }

	public static String getTextByID(String id) {

		String text = "";

		WebElement TxtBoxContent = KeyWordDrivenConstants.webDriver.findElement(By.id(id));

		System.out.println("Printing "+TxtBoxContent);

		//logInfo("Text identified is " + text);

		return 	TxtBoxContent.getText();

	}

	public static Object getObjectByID(String className, String id) {

		Object[] properties = { 1,5};



		return properties[0];

	}
	/*
	public static void elementClick(Property[] properties) throws BSROException {

		try {

			Thread.sleep(3 * 1000);

			if (KeyWordDrivenConstants.debug) {

				System.out.println("Control received at elementClick method.");

				System.out.println("Property array received with size of "
						+ properties.length);

				for (int index = 0; index < properties.length; index++) {

					System.out.println(properties[index].getPropertyName()
							+ " = " + properties[index].getPropertyValue());

				}

			}

			HtmlBrowser.getCurrentBrowserWindowObject();

			TestObject[] links = FrameWorkObjects.browserObject
					.find(atDescendant(properties));

			// WebDriverWait wait = new WebDriverWait(
			// KeyWordDrivenConstants.webDriver, 30);
			//
			// wait.until(ExpectedConditions.presenceOfElementLocated(By
			// .xpath("//*[not (.='')]")));

			((GuiTestObject) links[0]).click();

			HtmlBrowser.waitForLoad();

		} catch (Exception ex) {

			ex.printStackTrace();

			throw new BSROException(ex);

		}

	}
	 */
	public static void elementClickByXPath(String xpathExpression) throws BSROException
	{

		try
		{

			System.out.println("xpathExpression = " + xpathExpression);

			HtmlBrowser.getCurrentBrowserWindowObject();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(
					By.xpath(xpathExpression)).click();

			HtmlBrowser.waitForLoad();

		} 
		catch (Exception e)
		{
			throw new BSROException("Failed To Perform elementClickByXPath() function.");
		}

	}

	public static void elementClickByID(String argElementID) throws BSROException 
	{
		try 
		{

			HtmlBrowser.getCurrentBrowserWindowObject();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(By.id(argElementID))
			.click();

			if (KeyWordDrivenConstants.TC_EXPECTED.toLowerCase().equals("pw")) 
			{

				Thread.sleep(7000);

			} 
			else
			{

				HtmlBrowser.waitForLoad();

			}

		}
		catch (Exception e) 
		{
			throw new BSROException("Failed To Perform elementClickByID() function , id = "	+ argElementID);
		}

	}

	public static void elementClickByClass(String argElementClass) throws BSROException
	{

		try {
			HtmlBrowser.getCurrentBrowserWindowObject();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(By.className(argElementClass)).click();

			HtmlBrowser.waitForLoad();

		}
		catch (Exception e)
		{
			throw new BSROException("Failed To Perform elementClickByClass() function.");
		}

	}

	public static void elementClickByCssPath(String argCssPath) throws BSROException 
	{

		try
		{
			HtmlBrowser.getCurrentBrowserWindowObject();

			HtmlBrowser.waitForLoad();

			KeyWordDrivenConstants.webDriver.findElement(By.cssSelector(argCssPath)).click();

			HtmlBrowser.waitForLoad();

		} 
		catch (Exception e)
		{
			throw new BSROException("Failed To Perform elementClickByCssPath() function.");
		}

	}

	public static boolean isElementPresent(By by) throws BSROException 
	{

		HtmlBrowser.waitForLoad();

		try 
		{

			KeyWordDrivenConstants.webDriver.findElement(by);

			return true;

		}
		catch (NoSuchElementException e)
		{

			return false;

		}
	}

	public static boolean isElementVisible(By by) throws BSROException 
	{

		HtmlBrowser.waitForLoad();

		try
		{

			if (KeyWordDrivenConstants.webDriver.findElement(by).isDisplayed())
			{

				return true;

			} 
			else 
			{

				return false;

			}

		} 
		catch (NoSuchElementException e)
		{

			return false;

		}
	}

	public static boolean isElementEnabled(By by) throws BSROException 
	{

		HtmlBrowser.waitForLoad();

		try
		{

			if (KeyWordDrivenConstants.webDriver.findElement(by).isEnabled()) 
			{

				return true;

			}
			else
			{

				return false;

			}

		}
		catch (NoSuchElementException e) 
		{

			return false;

		}
	}

	public static void mouseOver(By by) throws BSROException {

		try {

			// Point coordinates = KeyWordDrivenConstants.webDriver
			// .findElement(by).getLocation();
			//
			// Robot robot;
			//
			// robot = new Robot();
			//
			// robot.mouseMove(coordinates.getX() + 7, coordinates.getY() + 80);

			// JavascriptExecutor js = (JavascriptExecutor)
			// KeyWordDrivenConstants.webDriver;
			//
			// js.executeScript("document.getElementById(\"" + ""
			// + KeyWordDrivenConstants.TC_HTML_ELEMENT_ID
			// + "\").focus();");

			WebElement element = KeyWordDrivenConstants.webDriver.findElement(by);

			Robot robot = new Robot();

			// SET THE MOUSE X Y POSITION
			robot.mouseMove(element.getLocation().x + 7,element.getLocation().y + 120);

			Actions actions = new Actions(KeyWordDrivenConstants.webDriver);

			actions.build();

			Actions rClick = actions.contextClick(element);

			rClick.perform();

			// Thread.sleep(1000);

			// rClick.sendKeys(Keys.ESCAPE);

			element.sendKeys(Keys.ESCAPE);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();

			//logError("mouseOver() function failed");

			throw new BSROException(e);
		}

	}

	public static void setMouseCursorPositionOutOfScreen() throws BSROException
	{

		try
		{

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			int width = (int) screenSize.getWidth();

			int height = (int) screenSize.getHeight();

			Robot robot = new Robot();

			// SET THE MOUSE X Y POSITION
			robot.mouseMove(0, height);

		}
		catch (Exception e)
		{
			throw new BSROException("failed to execute setMouseCursorPosition() function.");
		}
	}

	public static void closePrintWindow() throws BSROException {

		try {

			String exePath = new File(".").getCanonicalPath()+ "\\ThirdParty\\Utils\\ClosePrintWindow.exe";

			Runtime.getRuntime().exec("CMD /C " + exePath);

			//logInfo("closePrintWindow() success.");

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException("closePrintWindow() function failed.");
		}

	}

	public static void verifyPrintWindowExists() throws BSROException {

		try {

			Thread.sleep(3000);

			String exePath = new File(".").getCanonicalPath()+ "\\ThirdParty\\Utils\\PrintWindowExist.exe";

			Process proc = Runtime.getRuntime().exec("CMD /C " + exePath);

			proc.waitFor();

			String actualResult = "NO";

			int returnCode = proc.exitValue();

			if (0 == returnCode) {

				actualResult = "YES";

			}

			//logInfo("actualResult = " + actualResult);

			//logInfo("expectedResult = "	+ KeyWordDrivenConstants.TC_EXPECTED.toUpperCase());

			if (false == KeyWordDrivenConstants.TC_EXPECTED.toUpperCase().contains(actualResult))
			{

				throw new BSROException("verifyPrintWindowExists() function failed.");

			}

			//logInfo("verifyPrintWindowExists() success.");

		} 
		catch (Exception e) 
		{
			//logError("verifyPrintWindowExists() function failed.");
			throw new BSROException(e);
		}

	}

	public static void mouseLeftClick(By by) throws BSROException {

		try {

			// Thread.sleep(3000);

			WebElement element = KeyWordDrivenConstants.webDriver.findElement(by);

			for (int loopCount = 1; loopCount <= 30; loopCount++)
			{

				if (element.isEnabled()) 
				{

					// Robot robot = new Robot();

					// SET THE MOUSE X Y POSITION

					int width = element.getSize().width / 2;

					int height = element.getSize().height / 2;

					int x = element.getLocation().x + width;

					int y = element.getLocation().y + height;

					// robot.mouseMove(x, y);

					String exePath = new File(".").getCanonicalPath()
							+ "\\ThirdParty\\Utils\\MouseClick.exe";

					Process process = Runtime.getRuntime().exec(
							"CMD /C \"" + exePath + "\" LC " + x + " " + y);

					process.waitFor();

					Thread.sleep(300);

					break;

				} 
				else
				{

					if (loopCount >= 30)
					{

						throw new BSROException("Select element did not get enabled.");

					} 
					else
					{

						Thread.sleep(1000);

					}

				}

			}

			// KeyWordDrivenConstants.webDriver.findElement(By.id(argElementID))
			// .click();

			HtmlBrowser.waitForLoad();

		} 
		catch (Exception e) 
		{
			//logError("mouseLeftClick() function failed.");
			throw new BSROException(e);

		}

	}

	public static boolean isImageVisible(WebDriver driver, WebElement image)
	{
		Boolean result = null;

		if (1 == UserConfig.browserTypeToTest)
		{
			result = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete;", image);
		}
		else
		{ // other browser types use diff method to check

			result = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth!=\"undefined\" && arguments[0].naturalWidth>0);",image);
		}

		return result.booleanValue();
	}

	public static BufferedImage getScreenCapture() throws BSROException 
	{

		BufferedImage capture = null;

		try 
		{

			Robot robot = new Robot();

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			Rectangle area = new Rectangle(0, 0, screenSize.width,screenSize.height);

			capture = robot.createScreenCapture(area);

		} 
		catch (Exception e)
		{
			// TODO: handle exception

			//logError("getScreenCapture() function failed.");
			throw new BSROException(e);
		}

		return capture;

	}

	public static void closePrintWindow_RFT_Script() throws BSROException {

		boolean matched = true;

		int waitTime = 0;

		try {

			/*	Regex searchRegex = new Regex("Print");

			RootTestObject root = null;

			IWindow[] windows = null;

			IWindow foundWindow = null;

			for (;;) {

				// Get the root test object
				root = getRootTestObject();

				// Find all open windows and put them in an array called windows
				windows = root.getTopWindows();

				// Perform the following for each window found
				for (int i = 0; i < windows.length; i++) {
					// Gets the text of the window (which happens to be the
					// window title)
					String windowTitle = windows[i].getText();

					// Print out the found window titles for debugging
					System.out.println("Found " + windowTitle + " -- " + i
							+ " of " + windows.length + " windows.");

					// See if a window title matches the title here, then create
					// the foundWindow object
					// Input text into the window, then close the window
					// Catch exceptions as well (code can be added if an
					// exception is caught)
					try {

						matched = searchRegex.matches(windowTitle);

						if (matched) {

							foundWindow = windows[i];

							foundWindow.close();

							break;

						}

					} catch (Exception e) {

						throw new BSROException(e);

					}

				}

				if (matched) {

					break;

				} else if (waitTime >= 30) {

					break;

				} else {

					sleep(1);

					waitTime += 1;

				}

			}
			 */
			if (matched)
			{

				//logInfo("Print window identified and closed");

			} 
			else
			{

				throw new BSROException("Print window is not identidfied.");

			}

		} 
		catch (Exception e) 
		{

			throw new BSROException(e);

		}

	}

}
