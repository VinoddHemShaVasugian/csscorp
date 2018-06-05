package Framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import resources.Framework.HtmlBrowserHelper;
import KeyWordDriven.KeyWordDrivenConstants;


public class HtmlBrowser  {


	private static String getURL() {

		String URL = "";

		if (UserConfig.useSSL) {

			URL = "https://" + UserConfig.websiteHostName;

		} else {

			URL = "http://" + UserConfig.websiteHostName;

		}

		return URL;

	}

	public static void loadApplication(String URL) throws BSROException 
	{

		if (KeyWordDrivenConstants.webDriver!=null)
		{
			KeyWordDrivenConstants.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		} 
		else 
		{

			FrameWorkObjects.logger.errorMessage("Browser not opened as expected.", true);

		}

		KeyWordDrivenConstants.siteURL = getDomainURL(URL);

		KeyWordDrivenConstants.webDriver.navigate().to(URL);

		waitForLoad();

	}

	public static void loadSpecificPage(String URL) throws BSROException {

		// if (FrameWorkObjects.browserObject.loadUrl(URL)) {
		//
		// FrameWorkObjects.logger.infoMessage("Browser opened successfully.");
		//
		// FrameWorkObjects.browserObject.maximize();
		//
		// } else {
		//
		// FrameWorkObjects.logger.errorMessage(
		// "Browser not opened as expected.", true);
		//
		// }

		if (false == URL.startsWith("/")) {

			URL += "/";

		}

		KeyWordDrivenConstants.webDriver.navigate().to(
				KeyWordDrivenConstants.siteURL + URL);

		waitForLoad();

	}

	public static void openBrowserWindow() throws BSROException {

		try {

			if (KeyWordDrivenConstants.debug) {

				System.out.println("Invoking openBrowserWindow method.");

			}

		//	closeOpenedBrowserWindows();


			int timeLimit = 10;

			if (1 == UserConfig.browserTypeToTest) {

				if (UserConfig.deleteCookiesOnStartUp) {

					clearIECache();

				}

				// startBrowser("Internet Explorer", "about:blank");

				String seleniumDriversPath = new File(".").getCanonicalPath()
						+ "\\ThirdParty\\Selenium\\WebDrivers";

				System.out.println("seleniumDriversPath = "
						+ seleniumDriversPath);

				System.setProperty("webdriver.ie.driver", seleniumDriversPath
						+ "\\IEDriverServer.exe");

				DesiredCapabilities capabilities = DesiredCapabilities
						.internetExplorer();

				capabilities
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);

				WebDriver webDriver = new InternetExplorerDriver(capabilities);

				KeyWordDrivenConstants.webDriver = webDriver;

				while (true) {

					try {

						//logInfo("Browser Window Detected.");

						break;

					} catch (Exception e) {

						// TODO: handle exception

						timeLimit -= 1;

						if (timeLimit <= 0) {

							//logError("Browser window not detected.");

							break;

						}

						Thread.sleep(1000);

					}

				}

			} else if (3 == UserConfig.browserTypeToTest) {

				if (UserConfig.deleteCookiesOnStartUp) {

					clearIECache();

				}

				// startBrowser("Internet Explorer", "about:blank");

				System.setProperty("webdriver.chrome.driver","D:/MICHAEL/SampleApp/Drivers/chromedriver.exe");

				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setCapability("chrome.switches",
						Arrays.asList("--disable-extensions"));
				// capability
				// .setCapability("chrome.binary",
				// "C:/Users/css89714/AppData/Local/Google/Chrome/Application/chrome.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("user-data-dir=C:/Users/css89714/AppData/Local/Google/Chrome/User Data/Default");
				options.addArguments("--disable-extensions");
				options.addArguments("--test-type");
				options.addArguments("--start-maximized");
				WebDriver webDriver = new ChromeDriver(options);

				KeyWordDrivenConstants.webDriver = webDriver;

				while (true) {

					try {
						//logInfo("Browser Window Detected.");

						break;

					} catch (Exception e) {

						// TODO: handle exception

						timeLimit -= 1;

						if (timeLimit <= 0) {

							//logError("Browser window not detected.");

							break;

						}

						Thread.sleep(1000);

					}

				}

			}

			waitForLoad();

		} catch (Exception e) {
			// TODO: handle exception

			//logError("openBrowserWindow() function failed.");

			throw new BSROException(e);
		}

	}

	public static void closeOpenedBrowserWindows() throws BSROException {

		try {

			// find browsers
	

			if (UserConfig.browserTypeToTest == 1) {


				KeyWordDrivenConstants.webDriver.close();

			} else if (UserConfig.browserTypeToTest == 2) {

				KeyWordDrivenConstants.webDriver.close();

			} else if (UserConfig.browserTypeToTest == 3) {

				KeyWordDrivenConstants.webDriver.close();

			}

			// close one browser at a time
		//	unregister(browsers);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

	}

	public static void waitForLoad() throws BSROException
	{
		
		
		JavascriptExecutor jsExec = (JavascriptExecutor)KeyWordDrivenConstants.webDriver;
		
		while(false == jsExec.executeScript("return document.readyState;").toString().toUpperCase().contains("COMPLETE"))
		{
			try {
				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
			}
			
			//logInfo("waiting for page load complete.");
			
		}
		

//		sleep(1);
//
//		System.out.println("Waiting for page load.");
//
//		int timeLimit = (UserConfig.browserMaxWaitToLoadPage);
//
//		BrowserTestObject bto = FrameWorkObjects.browserObject;
//
//		boolean isPageLoadCompleted = false;
//
//		for (int loopIndex = 0; loopIndex <= timeLimit; loopIndex++) {
//
//			System.out.println("Browser Ready State = "
//					+ bto.getProperty(".readyState").toString());
//
//			if ((Integer.parseInt(bto.getProperty(".readyState").toString()) == 4)) {
//
//				isPageLoadCompleted = true;
//
//				loopIndex = timeLimit;
//
//				break;
//
//			} else {
//
//				sleep(1);
//
//			}
//
//		}
//
//		if (false == isPageLoadCompleted) {
//
//			logError(" Browser page load time out exception.");
//
//			throw new BSROException("Browser page load time out exception.");
//
//		}

		// sleep(3);

		// while (true) {
		//
		// if ((Integer.parseInt(bto.getProperty(".readyState").toString()) ==
		// 4)
		// && (waitingTime < timeLimit)) {
		//
		// break;
		//
		// }
		//
		// if ((waitingTime > timeLimit)
		// && (Integer.parseInt(bto.getProperty(".readyState")
		// .toString()) != 4)) {
		//
		// logWarning("Browser Loading Time Limit Exceeded Exception");
		//
		// KeyWordDrivenConstants.webDriver
		// .findElement(By.tagName("html")).sendKeys(Keys.ESCAPE);
		//
		// sleep(3);
		//
		// System.out.println("Coming out of wait loop.");
		//
		// return;
		//
		// }
		//
		// try {
		//
		// Thread.sleep(100);
		//
		// } catch (InterruptedException e) {
		//
		// e.printStackTrace();
		//
		// }
		//
		// waitingTime++;
		//
		// }

		System.out.println("Waiting for page load is completed.");

	}

	public static void getCurrentBrowserWindowObject() throws InterruptedException {

		System.out.println("Identifying current browser window object.");

		
		int timeLimit = 30;

		if (UserConfig.browserTypeToTest == 1) {

			while (true) {

				try {


					break;

				} catch (Exception e) {

					// TODO: handle exception

					timeLimit -= 1;

					if (timeLimit <= 0) {

						FrameWorkObjects.logger.errorMessage(
								"Browser window is not detected.", true);

					}

					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		} else if (UserConfig.browserTypeToTest == 2) {


		} else if (UserConfig.browserTypeToTest == 3) {

			

		} else if (UserConfig.browserTypeToTest == -1) {

			Thread.sleep(3000);

		} else {

			//logError("Please check browser type that you have defined.");
		}

		System.out
				.println("Returning control from identifying current browser window object.");

	}

	public static String getCurrentPageTitle() throws Exception {

		getCurrentBrowserWindowObject();
		String pageTitle = KeyWordDrivenConstants.webDriver.getTitle();

		//logInfo("Page title is identified as " + pageTitle);

		return pageTitle;

	}

	public static void clearIECache() throws BSROException {

		// String DOScmd = "C:/IE_Clear_All.bat";
		// String DOScmd =
		// "CMD /C \"del /q /s /f C:\\Users\\%USERNAME%\\AppData\\Roaming\\Microsoft\\Windows\\Cookies\"";
		String DOScmd = "CMD /C \"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255\"";
		// DOScmd = "ping localhost";

		try {

			Process p = Runtime.getRuntime().exec(DOScmd);

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			System.out.println("Here is the standard output of the command:\n");
			String s = "";
			while ((s = stdInput.readLine()) != null)
			{
				System.out.println(s);
			}

			System.out.println("Here is the standard error of the command (if any):\n");

			while ((s = stdError.readLine()) != null) 
			{
				System.out.println(s);
			}

			// System.exit(0);

		} 
		catch (IOException e)
		{

			System.out.println("Clear Cookies Task Failed.");
			throw new BSROException(e);

		}

	}

	public static void killIEDriverServer() throws IOException,InterruptedException
	{

		String DOScmd = "TASKKILL /F /IM chromedriver.exe";

		// DOScmd = "ping localhost";

		try {

			// run the Unix "ps -ef" command

			Process p = Runtime.getRuntime().exec(DOScmd);

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			// read the output from the command

			System.out.println("Here is the standard output of the command:\n");
			String s = "";
			while ((s = stdInput.readLine()) != null)
			{
				System.out.println(s);
			}

			// read any errors from the attempted command

			System.out
					.println("Here is the standard error of the command (if any):\n");

			while ((s = stdError.readLine()) != null)
			{
				System.out.println(s);
			}

			// System.exit(0);

		} 
		catch (IOException e)
		{
			System.out.println("[IOException]. Printing Stack Trace");
			e.printStackTrace();
			System.exit(-1);
		}

	}

	public static void verifyElementContentByXPath(String xpathExpression)
			throws BSROException, Exception {

		HtmlBrowser.getCurrentBrowserWindowObject();

		HtmlBrowser.waitForLoad();

		String elementContent = KeyWordDrivenConstants.webDriver.findElement(
				By.xpath(xpathExpression)).getText();

		//logInfo("elementContent => " + elementContent);

		System.out.println("elementContent => " + elementContent);

		if (KeyWordDrivenConstants.TC_EXPECTED.equals(elementContent)) {

			//logInfo("verifyElementContentByXPath success.");

		} else {

			throw new BSROException("verifyElementContentByXPath failed.");
		}

	}

	public static void verifyElementContent(By by) throws BSROException {

		HtmlBrowser.waitForLoad();

		String actulaContent = "";

		if (CoreUtils.isElementPresent(by)) {

			if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.toUpperCase().equals("TEXT")) {

				actulaContent = KeyWordDrivenConstants.webDriver
						.findElement(by).getAttribute("value");

			} else {

				actulaContent = KeyWordDrivenConstants.webDriver
						.findElement(by).getText()
						.replaceAll("\\r\\n|\\r|\\n", " ");

				// actulaContent = KeyWordDrivenConstants.webDriver
				// .findElement(by).getAttribute("innerHTML")
				// .replaceAll("\\<.*?\\>", "");

				actulaContent = actulaContent.replaceAll("	", "");

			}

		//	logInfo("actulaContent = " + actulaContent);

		//	logInfo("expectedContent = " + KeyWordDrivenConstants.TC_EXPECTED);

			if (actulaContent.contains(KeyWordDrivenConstants.TC_EXPECTED)) {

			//	logInfo("verifyElementContent() success");

			} else {

				//logError("verifyElementContent() failed.");

			}

		} else {

			throw new BSROException(
					"verifyElementContent() function falied , because element not found.");

		}

	}

	private static String getDomainURL(String url) throws BSROException {

		String url_formated = "";

		try {

			String protocalName = "";

			if (!url.startsWith("http") && !url.startsWith("https")) {

				url = "http://" + url;

			}

			if (url.toLowerCase().startsWith("http")) {

				protocalName = "http://";

			} else if (url.toLowerCase().startsWith("https")) {

				protocalName = "https://";

			}

			URL netUrl = new URL(url);

			String host = netUrl.getHost();

			int port = netUrl.getPort();

			if (host.startsWith("www")) {

				host = host.substring("www".length() + 1);

			}

			if (port != -1) {

				url_formated = protocalName + host + ":" + port + "";

			} else {

				url_formated = protocalName + host;

			}

		} catch (Exception e) {
			// TODO: handle exception

	//		logError("getDomainURL() function failed.");

			throw new BSROException(e);
		}

		return url_formated;

	}

	public static void switchToIFrame(By by) throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			if (CoreUtils.isElementPresent(by)) {

				WebElement iFrameObject = KeyWordDrivenConstants.webDriver
						.findElement(by);

				KeyWordDrivenConstants.webDriver.switchTo().frame(iFrameObject);

			} else {

				throw new BSROException(
						"switchToIFrame() failed , because element not found.");

			}

		} catch (Exception e) {

		//	logError("switchToIFrame() failed");

			throw new BSROException(e);
		}

	}

	public static void switchToDefaultFrame() throws BSROException {

		try {

			KeyWordDrivenConstants.webDriver.switchTo().defaultContent();

			//logInfo("WebDriver switched to default content.");

			HtmlBrowser.waitForLoad();

		} catch (Exception e) {

		//	logError("switchToDefaultFrame() failed");

			throw new BSROException(e);
		}

	}

	public static boolean waitForElementExist(By by) throws BSROException {

		HtmlBrowser.waitForLoad();

		boolean taskStatus = false;

		int waitTimeMax = 30;

		int waitTimeMin = 0;

		for (;;) {

			try {

				KeyWordDrivenConstants.webDriver.findElement(by);

				taskStatus = true;

				break;

			} catch (Exception e) {

				waitTimeMin += 1;

				try {

					Thread.sleep(1000);

				} catch (InterruptedException e1) {

					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (waitTimeMin >= waitTimeMax) {

					taskStatus = false;

					break;
				}

			}

		}

		return taskStatus;
	}

	public static boolean waitForElementVisible(By by) throws BSROException, Exception {

		HtmlBrowser.waitForLoad();

		boolean taskStatus = false;

		int waitTimeMax = 30;

		int waitTimeMin = 0;

		for (waitTimeMin = 0; waitTimeMin <= waitTimeMax; waitTimeMin++) {

			try {

				if (KeyWordDrivenConstants.TC_EXPECTED.toUpperCase().contains(
						"YES")) {

					if (KeyWordDrivenConstants.webDriver.findElement(by)
							.isDisplayed()) {

						taskStatus = true;

						waitTimeMin = waitTimeMax;

						break;

					} else {

						Thread.sleep(1000);

					}

				} else {

					if (false == KeyWordDrivenConstants.webDriver.findElement(
							by).isDisplayed()) {

						taskStatus = true;

						waitTimeMin = waitTimeMax;

						break;

					} else {

						Thread.sleep(1000);

					}

				}

			} catch (Exception e) {

				Thread.sleep(10000);
				// TODO: handle exception
			}

		}

		return taskStatus;

		// for (;;) {
		//
		// try {
		//
		// if (KeyWordDrivenConstants.webDriver.findElement(by)
		// .isDisplayed()) {
		//
		// taskStatus = true;
		//
		// return taskStatus;
		//
		// }
		//
		// } catch (Exception e) {
		//
		// waitTimeMin += 1;
		//
		// try {
		//
		// Thread.sleep(1000);
		//
		// } catch (InterruptedException e1) {
		//
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// if (waitTimeMin >= waitTimeMax) {
		//
		// taskStatus = false;
		//
		// return taskStatus;
		// }
		//
		// }
		//
		// }

	}

	public static void backButton() throws BSROException {

		try {

			KeyWordDrivenConstants.webDriver.navigate().back();

			HtmlBrowser.waitForLoad();

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException("Unable to simulate backButton() function.");
		}

	}

	public static void switchToSpecificWindow(String windowTitle)
			throws BSROException {

		boolean isPopupWindowIdentified = false;

		try {

			Set<String> windows = KeyWordDrivenConstants.webDriver
					.getWindowHandles();

			for (String window : windows) {

				KeyWordDrivenConstants.webDriver.switchTo().window(window);

				if (KeyWordDrivenConstants.webDriver.getTitle().contains(
						windowTitle)) {

					isPopupWindowIdentified = true;

					break;
				}

			}

			if (false == isPopupWindowIdentified) {

				throw new BSROException("Popup window is not identified.");

			}

		} catch (Exception e) {

			//logError("Failed to switch new child window.");

			throw new BSROException(e);
		}

	}

	public static void closeSpecificWindow(String windowTitle)
			throws BSROException {

		boolean isPopupWindowIdentified = false;

		try {

			Set<String> windows = KeyWordDrivenConstants.webDriver
					.getWindowHandles();

			for (String window : windows) {

				KeyWordDrivenConstants.webDriver.switchTo().window(window);

				if (KeyWordDrivenConstants.webDriver.getTitle().contains(
						windowTitle)) {

					KeyWordDrivenConstants.webDriver.switchTo().window(window)
							.close();

					isPopupWindowIdentified = true;

					break;
				}
			}

			if (false == isPopupWindowIdentified) {

				throw new BSROException("Popup window is not identified.");

			}

		} catch (Exception e) {

			//logError("Failed to switch new the window.");

			throw new BSROException(e);
		}

	}

	public static void switchToFullScreen() throws BSROException {

		try {

			String utilityPath = new File(".").getCanonicalPath()
					+ "\\ThirdParty\\Selenium\\Utils\\BrowserWindowFullScreen.exe";

			if (UserConfig.browserTypeToTest == 1) {

				Process process = Runtime.getRuntime().exec(
						"CMD /C " + utilityPath + " iexplore");

				process.waitFor();

			} else {

				throw new BSROException(
						"switchToFullScreen() : Unknown browser type to test.");

			}

		} catch (Exception e) {
			// TODO: handle exception

		//	logError("switchToFullScreen() failed.");

			throw new BSROException(e);

		}
	}

	public static void switchToNormalScreen() throws BSROException {

		try {

			String utilityPath = new File(".").getCanonicalPath()
					+ "\\ThirdParty\\Selenium\\Utils\\BrowserWindowFullScreen.exe";

			Process process = Runtime.getRuntime()
					.exec("CMD /C " + utilityPath);

			process.waitFor();

		} catch (Exception e) {
			// TODO: handle exception

			//logError("switchToFullScreen() failed.");

			throw new BSROException(e);

		}
	}

}
