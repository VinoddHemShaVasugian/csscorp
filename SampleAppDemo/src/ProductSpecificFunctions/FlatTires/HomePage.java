package ProductSpecificFunctions.FlatTires;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.ProductSpecificFunctions.FlatTires.HomePageHelper;
import Framework.BSROException;
import Framework.HtmlBrowser;
import KeyWordDriven.KeyWordDrivenConstants;

import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;

/**
 * Description : Functional Test Script
 * 
 * @author css89714
 */
public class HomePage extends HomePageHelper {
	/**
	 * Script Name : <b>HomePage</b> Generated : <b>Jul 11, 2013 12:11:09 AM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7601 (S)
	 * 
	 * @since 2013/07/11
	 * @author css89714
	 * @throws BSROException
	 */

	private static int tireNumberToTest = 0;

	private static void verifyLeftPanelTiresListContents() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			WebElement faltTiresListinLeftPanel = KeyWordDrivenConstants.webDriver
					.findElement(By.id("run-flat-tire-list"));

			List<WebElement> faltTiresWidgets = faltTiresListinLeftPanel
					.findElements(By.tagName("li"));

			Iterator<WebElement> iterator = faltTiresWidgets.iterator();

			int loopCount = 1;

			while (iterator.hasNext()) {

				if (tireNumberToTest == loopCount) {

					WebElement flatTireWidget = (WebElement) iterator.next();

					String vehicleType = flatTireWidget.findElement(
							By.className("runflath1")).getText();

					String tyreModel = flatTireWidget.findElement(
							By.className("hidingdata")).getText();

					WebElement tyreDetailsPageLink = flatTireWidget
							.findElement(By.tagName("a"));

					tyreDetailsPageLink.click();

					HtmlBrowser.waitForLoad();

					String typeDetailsPage_PageTitle = KeyWordDrivenConstants.webDriver
							.findElement(By.id("page-title")).getText();

					logInfo("typeDetailsPage_PageTitle = "
							+ typeDetailsPage_PageTitle);

					logInfo("tyreModel = " + tyreModel);

					if (tyreModel.contains(typeDetailsPage_PageTitle)
							|| typeDetailsPage_PageTitle.contains(tyreModel)) {

						logInfo("typeDetailsPage_PageTitle verification completed.");

					} else {

						logError("typeDetailsPage_PageTitle and tyreModel are not matched.");

					}

					String typeDetailsPage_PageSubTitle = KeyWordDrivenConstants.webDriver
							.findElement(
									By.xpath("//div[@id='primary']/div/h2"))
							.getText();

					if (tyreModel.contains(typeDetailsPage_PageSubTitle)
							|| typeDetailsPage_PageSubTitle.contains(tyreModel)) {

						logInfo("typeDetailsPage_PageSubTitle verification completed.");

					} else {

						logError("typeDetailsPage_PageSubTitle and tyreModel are not matched.");

					}

					HtmlBrowser.backButton();

					loopCount += 1;

					break;

				} else {

					WebElement flatTireWidget = (WebElement) iterator.next();

					loopCount += 1;

				}

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("FlatTires.HomePage.FlatTires.verifyLeftPanelTiresListContents() function failed.");

			e.printStackTrace();

			throw new BSROException(e);

		}

	}

	public static void verifyLeftPanelTiresList() throws BSROException {

		try {

			WebElement faltTiresListinLeftPanel = KeyWordDrivenConstants.webDriver
					.findElement(By.id("run-flat-tire-list"));

			List<WebElement> faltTiresWidgets = faltTiresListinLeftPanel
					.findElements(By.tagName("li"));

			Iterator<WebElement> iterator = faltTiresWidgets.iterator();

			System.out.println("Main iterator loop started.");

			while (iterator.hasNext()) {

				tireNumberToTest += 1;

				verifyLeftPanelTiresListContents();

				iterator.next();

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			logError("FlatTires.HomePage.FlatTires.verifyLeftPanelTiresList() function failed.");

			throw new BSROException(e);

		}

	}

}
