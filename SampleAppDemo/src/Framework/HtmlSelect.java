package Framework;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import resources.Framework.HtmlSelectHelper;
import KeyWordDriven.KeyWordDrivenConstants;

/**
 * Description : Functional Test Script
 * 
 * @author admin
 */
public class HtmlSelect extends HtmlSelectHelper {
	/**
	 * Script Name : <b>HtmlSelect</b> Generated : <b>Apr 12, 2013 10:47:46
	 * AM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7600 ()
	 * 
	 * @since 2013/04/12
	 * @author admin
	 */
	public static void selectItemByName(String name, String itemToSelect) 
	{

		//WebElement select=KeyWordDrivenConstants.webDriver.findElement(By.name(name));
		List<WebElement> options = KeyWordDrivenConstants.webDriver.findElements(By.name(name));
		for (WebElement option : options)
		{
			if(option.getText()==itemToSelect)
				option.click();   
		}
	}

	public static void selectItem(Property[] property, String itemToSelect)
			throws BSROException {

		try {

			/*	TestObject[] objects = FrameWorkObjects.browserObject
					.find(atDescendant(property));

			// while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject
					.find(atDescendant(property));

			// }

			// ((TextSelectGuiSubitemTestObject) objects[0]).click();

			((SelectGuiSubitemTestObject) objects[0]).select(itemToSelect);
			 */
		} catch (Exception e) {

			//	logError("Failed to operate selectItem method.");

			e.printStackTrace();

			throw new BSROException(e);

		}

	}

	public static String getSelectItem(Property[] property)throws BSROException {

		String selectedItemText = "";

		try {

			/*	TestObject[] objects = FrameWorkObjects.browserObject
					.find(atDescendant(property));

			// while (objects != null && objects.length <= 0) {

			objects = FrameWorkObjects.browserObject
					.find(atDescendant(property));

			// }

			// ((TextSelectGuiSubitemTestObject) objects[0]).click();

			selectedItemText = ((SelectGuiSubitemTestObject) objects[0])
					.getSelectedText();*/

		} catch (Exception e) {

			//logError("Failed to operate getSelectItem() method.");

			e.printStackTrace();

			throw new BSROException(e);

		}

		return selectedItemText;

	}

	public static void selectItemByID(String argID, String itemToSelect)
			throws BSROException {

		try {

			Framework.HtmlBrowser.getCurrentBrowserWindowObject();

			List<WebElement> options = KeyWordDrivenConstants.webDriver.findElements(By.id(argID));
			for (WebElement option : options)
			{
				if(option.getText()==itemToSelect)
					option.click();   

			}

			Point pt = new Point(-10, -10);
			Actions action = new Actions(KeyWordDrivenConstants.webDriver);
			action.moveByOffset(-10,-10);

		} catch (Exception e) {
			// TODO: handle exception

			FrameWorkObjects.logger.errorMessage(argID
					+ " combo box is not identified.", true);

			throw new BSROException(e);

		}

	}

	public static String getSelectedItemByID(String id) {

		WebElement text=KeyWordDrivenConstants.webDriver.findElement(By.id(id));

		// while (objects != null && objects.length <= 0) {
		//
		// objects = FrameWorkObjects.browserObject.find(atDescendant(".class",
		// "Html.SELECT", ".id", id));
		//
		// }

		// ((SelectGuiSubitemTestObject) objects[0]).click();

		return text.getText();

	}

	public static void selectItemByID_Selenium(String argID,
			String argElementToSelect) throws BSROException {

		HtmlBrowser.waitForLoad();

		try {

			for (;;) {

				try {

					KeyWordDrivenConstants.webDriver.findElement(By.id(argID));

					break;

				} catch (StaleElementReferenceException e) {

					Thread.sleep(300);

				}

			}

			WebElement webElement = KeyWordDrivenConstants.webDriver
					.findElement(By.id(argID));

			int limit = 0;
			int maxLimit = 3000;

			for (;;) {

				if (webElement.isEnabled()) {

					break;

				} else {

					limit += 1;

					Thread.sleep(10);

				}

				if (limit >= maxLimit) {

					throw new BSROException("Select element not get enabled.");

				}

			}

			KeyWordDrivenConstants.webDriver.findElement(By.id(argID))
			.sendKeys(Keys.ESCAPE);

			Thread.sleep(500);

			Select select = new Select(
					KeyWordDrivenConstants.webDriver.findElement(By.id(argID)));

			// Thread.sleep(3 * 1000);

			select.selectByVisibleText(argElementToSelect);

			HtmlBrowser.waitForLoad();

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}
	}

	public static ArrayList<String> getAllListItemsByID(String argID)
			throws BSROException {

		ArrayList<String> listItems = new ArrayList<String>();

		try {

			for (;;) {

				try {

					KeyWordDrivenConstants.webDriver.findElement(By.id(argID));

					break;

				} catch (StaleElementReferenceException e) {

					Thread.sleep(300);

				}

			}

			WebElement combobox = KeyWordDrivenConstants.webDriver
					.findElement(By.id(argID));

			ArrayList<WebElement> options = (ArrayList<WebElement>) combobox
					.findElements(By.tagName("option"));

			Iterator<WebElement> iterator = options.iterator();

			while (iterator.hasNext()) {

				WebElement webElement = (WebElement) iterator.next();

				listItems.add(webElement.getText());

			}

		} catch (Exception e) {
			// TODO: handle exception

		//	logError("Unable to process getAllListItemsByID() function.");

			e.printStackTrace();

			throw new BSROException(e);

		}

		return listItems;

	}

	public static ArrayList<String> getAllListItemsByXPath(String argXPath)
			throws BSROException {

		ArrayList<String> listItems = new ArrayList<String>();

		try {

			WebElement combobox = KeyWordDrivenConstants.webDriver
					.findElement(By.xpath(argXPath));

			ArrayList<WebElement> options = (ArrayList<WebElement>) combobox
					.findElements(By.tagName("option"));

			Iterator<WebElement> iterator = options.iterator();

			while (iterator.hasNext()) {

				WebElement webElement = (WebElement) iterator.next();

				listItems.add(webElement.getText());

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			throw new BSROException(
					"Unable to process getAllListItemsByID() function.");

		}

		return listItems;

	}

	public static void selectItemByIndex(String argID,
			int argElementIndexToSelect) throws BSROException {

		HtmlBrowser.waitForLoad();

		try {

			WebElement webElement = KeyWordDrivenConstants.webDriver
					.findElement(By.id(argID));

			int limit = 0;
			int maxLimit = 3000;

			for (;;) {

				if (webElement.isEnabled()) {

					break;

				} else {

					limit += 1;

					Thread.sleep(10);

				}

				if (limit >= maxLimit) {

					throw new BSROException("Select element not get enabled.");

				}

			}

			KeyWordDrivenConstants.webDriver.findElement(By.id(argID))
			.sendKeys(Keys.ESCAPE);

			Thread.sleep(500);

			Select select = new Select(
					KeyWordDrivenConstants.webDriver.findElement(By.id(argID)));

			// Thread.sleep(3 * 1000);

			select.selectByIndex(argElementIndexToSelect);

			HtmlBrowser.waitForLoad();

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

	}

}
