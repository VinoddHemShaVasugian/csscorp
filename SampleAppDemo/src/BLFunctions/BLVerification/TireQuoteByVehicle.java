package BLFunctions.BLVerification;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.BLFunctions.BLVerification.TireQuoteByVehicleHelper;
import Framework.BSROException;
import Framework.HtmlBrowser;
import KeyWordDriven.KeyWordDrivenConstants;
import ProductSpecificFunctions.Tires.Search.ByVehicle.TiresSearchDBResults;

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
public class TireQuoteByVehicle extends TireQuoteByVehicleHelper {
	/**
	 * Script Name : <b>TireQuote</b> Generated : <b>Jul 24, 2013 1:29:43 AM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7601 (S)
	 * 
	 * @since 2013/07/24
	 * @author css89714
	 */

	public static void verify() throws BSROException {

		try {

			HtmlBrowser.waitForLoad();

			java.util.List<WebElement> eachTireSearchResultContainer = KeyWordDrivenConstants.webDriver
					.findElements(By
							.xpath("//div[@id='tire-selector-results']/div"));

			int searchResultsCount = eachTireSearchResultContainer.size();

			logInfo("TiresSearchResultsCountFromWeb = " + searchResultsCount);

			for (int outerLoopIndex = 0; outerLoopIndex < eachTireSearchResultContainer
					.size(); outerLoopIndex++) {

				WebElement specificTireResultContainer = eachTireSearchResultContainer
						.get(outerLoopIndex);

				String tireFullName_Web = specificTireResultContainer
						.findElement(
								By.id("tire-pricing-tire-selector-result-tirecatalog"))
						.getText();

				String tireSalesLine = tireFullName_Web.substring(
						tireFullName_Web.indexOf(" ")).trim();

				String tireItemsCount = KeyWordDrivenConstants.webDriver
						.findElement(By.id("form-filter-quantity"))
						.getAttribute("value");

				String tires_original_price = specificTireResultContainer
						.findElement(By.className("price-large")).getText()
						.replace("$", "").replaceAll("\\r\\n|\\r|\\n", "")
						.trim();

				String price_main = tires_original_price.substring(0,
						tires_original_price.length() - 2);

				String price_sub = tires_original_price
						.substring(tires_original_price.length() - 2);

				tires_original_price = price_main + "." + price_sub;

				specificTireResultContainer.findElement(
						By.id("tire-pricing-tire-selector-result-get-quote"))
						.click();

				HtmlBrowser.waitForLoad();

				String tireQuote_Page_Title = HtmlBrowser.getCurrentPageTitle();

				if (tireQuote_Page_Title.contains("Tire Quote:")
						&& tireQuote_Page_Title
								.contains("Firestone Complete Auto Care")) {

					logInfo("Tire quote page title verification success.");

				} else {

					throw new BSROException(
							"Tire quote page title verification failed.");

				}

				String tireQuote_ItemHeader = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("div.details.left > h2"))
						.getText();

				if (tireQuote_ItemHeader.equals(tireFullName_Web)) {

					logInfo("Slected tire shown exactly in tire quote page.");

				} else {

					throw new BSROException(
							"Slected tire did not shown exactly in tire quote page.");

				}

				String tireQuote_Additional_Items_Actual = KeyWordDrivenConstants.webDriver
						.findElement(By.cssSelector("td.additional-items"))
						.getText().replaceAll(",", "");

				String tireQuote_Additional_Items_Expected = tireItemsCount
						+ " Tires @ $" + tires_original_price;

				logInfo("tireQuote_Additional_Items_Expected = "
						+ tireQuote_Additional_Items_Expected);

				logInfo("tireQuote_Additional_Items = "
						+ tireQuote_Additional_Items_Actual);

				if (tireQuote_Additional_Items_Actual
						.equals(tireQuote_Additional_Items_Expected)) {

					logInfo("tireQuote_Additional verification success.");

				} else {

					throw new BSROException(
							"tireQuote_Additional verification failed.");

				}

				String tireQuote_Price_Actual = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[2]/td[2]"))
						.getText().replaceAll(",", "");

				String tireQuote_Price_Expected = String.valueOf((Float
						.parseFloat(tires_original_price) * Float
						.parseFloat(tireItemsCount)));

				tireQuote_Price_Expected = tireQuote_Price_Expected.substring(
						0, tireQuote_Price_Expected.indexOf(".") + 3);

				logInfo("tireQuote_Price_Actual = " + tireQuote_Price_Actual);

				logInfo("tireQuote_Price_Expected = $"
						+ tireQuote_Price_Expected);

				if (tireQuote_Price_Actual.equals("$"
						+ tireQuote_Price_Expected)) {

					logInfo("Multiple tired price verified successfully.");

				} else {

					throw new BSROException(
							"Multiple tired price verification failed.");

				}

				String tireQuote_Installtion = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[4]/td"))
						.getText().replaceAll("$", "").replaceAll(",", "");

				if (false == tireQuote_Installtion.equals("Installation")) {

					throw new BSROException(
							"Installation text verification failed.");

				}

				String tireQuote_Installtion_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[4]/td[2]"))
						.getText().replaceAll(",", "");

				if (tireQuote_Installtion_Charges.contains("FREE")) {

					tireQuote_Installtion_Charges = "$0";

				}

				String tireQuote_Alignment = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[5]/td"))
						.getText().replaceAll(",", "");

				if (false == tireQuote_Alignment
						.contains("Tire/Wheel Alignment Check")) {

					throw new BSROException(
							"tireQuote_Alignment text verification failed.");

				}

				String tireQuote_Alignment_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[5]/td[2]"))
						.getText().replaceAll(",", "");

				if (tireQuote_Alignment_Charges.equals("FREE")) {

					tireQuote_Alignment_Charges = "$0";

				}

				String tireQuote_Tire_Rotation = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[6]/td"))
						.getText().replaceAll(",", "");

				if (false == tireQuote_Tire_Rotation
						.contains("Lifetime Free Tire Rotation")) {

					throw new BSROException(
							"Lifetime Free Tire Rotation text verification failed.");

				}

				String tireQuote_Tire_Rotation_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[6]/td[2]"))
						.getText().replaceAll(",", "");

				if (tireQuote_Tire_Rotation_Charges.equals("FREE")) {

					tireQuote_Tire_Rotation_Charges = "$0";

				}

				String tireQuote_Wheel_Balancing = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[7]/td"))
						.getText().replaceAll(",", "");

				if (false == tireQuote_Wheel_Balancing
						.contains("Computerized Wheel Balance")) {

					throw new BSROException(
							"Computerized Wheel Balance text verification failed.");

				}

				String tireQuote_Wheel_Balancing_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[7]/td[2]"))
						.getText().replaceAll(",", "");

				if (tireQuote_Wheel_Balancing_Charges.equals("FREE")) {

					tireQuote_Wheel_Balancing_Charges = "$0";

				}

				String tireQuote_TPMS = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[8]/td"))
						.getText().replaceAll(",", "");

				if (false == tireQuote_TPMS.contains("TPMS Valve Service Kit")) {

					throw new BSROException(
							"TPMS Valve Service Kit text verification failed.");

				}

				String tireQuote_TPMS_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[8]/td[2]"))
						.getText().replaceAll(",", "");

				if (tireQuote_TPMS_Charges.equals("FREE")) {

					tireQuote_TPMS_Charges = "$0";

				}

				String tireQuote_TPMS_Labour = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[9]/td"))
						.getText().replaceAll(",", "");

				if (false == tireQuote_TPMS_Labour
						.contains("TPMS Valve Service Kit Labor")) {

					throw new BSROException(
							"TPMS Valve Service Kit Labor text verification failed.");

				}

				String tireQuote_TPMS_Labour_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[9]/td[2]"))
						.getText().replaceAll(",", "");

				if (tireQuote_TPMS_Labour_Charges.equals("FREE")) {

					tireQuote_TPMS_Labour_Charges = "$0";

				}

				String tireQuote_State_ENV = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[10]/td"))
						.getText().replaceAll(",", "");

				if (false == tireQuote_State_ENV
						.contains("State Environmental Fee")) {

					throw new BSROException(
							"State Environmental Fee text verification failed.");

				}

				String tireQuote_State_ENV_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[10]/td[2]"))
						.getText().replaceAll(",", "");

				if (tireQuote_State_ENV_Charges.equals("FREE")) {

					tireQuote_State_ENV_Charges = "$0";

				}

				String tireQuote_Tyre_Recycling = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[11]/td"))
						.getText().replaceAll(",", "");

				if (false == tireQuote_Tyre_Recycling
						.contains("Scrap Tire Recycling Charge")) {

					throw new BSROException(
							"State Environmental Fee text verification failed.");

				}

				String tireQuote_Tyre_Recycling_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[11]/td[2]"))
						.getText().replaceAll(",", "");

				if (tireQuote_Tyre_Recycling_Charges.equals("FREE")) {

					tireQuote_Tyre_Recycling_Charges = "$0";

				}

				String tireQuote_Grand_Total = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[12]/td"))
						.getText().replaceAll(",", "");

				logInfo("tireQuote_Grand_Total text = " + tireQuote_Grand_Total);

				if (false == tireQuote_Grand_Total.contains("TOTAL")) {

					throw new BSROException("Total text verification failed.");

				}

				String tireQuote_Grand_Total_Charges = KeyWordDrivenConstants.webDriver
						.findElement(
								By.xpath("//div[@id='content']/div[2]/div[2]/table/tbody/tr[12]/td[2]"))
						.getText().replaceAll("\\$", "").replaceAll("\\*", "")
						.replaceAll(",", "");

				if (tireQuote_Grand_Total_Charges.equals("FREE")) {

					tireQuote_Grand_Total_Charges = "$0";

				}

				float bill_tiresPrice = 0;

				float bill_installation = 0;

				float bill_wheel_alignment = 0;

				float bill_tire_rotation = 0;

				float bill_wheel_balance = 0;

				float bill_tpms_value_kit = 0;

				float bill_tpms_value_kit_labour = 0;

				float bill_env_fee = 0;

				float bill_recycle_charge = 0;

				DecimalFormat df = new DecimalFormat();

				df.setMaximumFractionDigits(2);

				if (!tireQuote_Price_Expected.contains("FREE")
						|| !tireQuote_Price_Expected.contains("$0")) {

					tireQuote_Price_Expected = tireQuote_Price_Expected
							.replaceAll("\\$", "").trim();

					bill_tiresPrice = Float
							.parseFloat(tireQuote_Price_Expected);

				} else {

					bill_tiresPrice = 0;

				}

				if (!tireQuote_Alignment_Charges.contains("FREE")
						&& !tireQuote_Alignment_Charges.contains("$0")) {

					tireQuote_Alignment_Charges = tireQuote_Alignment_Charges
							.replaceAll("\\$", "").trim();

					bill_installation = Float
							.parseFloat(tireQuote_Alignment_Charges);

				} else {

					bill_installation = 0;
				}

				if (!tireQuote_Alignment_Charges.contains("FREE")
						&& !tireQuote_Alignment_Charges.contains("$0")) {

					tireQuote_Alignment_Charges = tireQuote_Alignment_Charges
							.replaceAll("\\$", "").trim();

					bill_wheel_alignment = Float
							.parseFloat(tireQuote_Alignment_Charges);

				} else {

					bill_wheel_alignment = 0;

				}

				if (!tireQuote_Tire_Rotation_Charges.contains("FREE")
						&& !tireQuote_Tire_Rotation_Charges.contains("$0")) {

					tireQuote_Alignment_Charges = tireQuote_Alignment_Charges
							.replaceAll("\\$", "").trim();

					bill_tire_rotation = Float
							.parseFloat(tireQuote_Alignment_Charges);

				} else {

					bill_tire_rotation = 0;

				}

				if (!tireQuote_Wheel_Balancing_Charges.contains("FREE")
						&& !tireQuote_Wheel_Balancing_Charges.contains("$0")) {

					tireQuote_Wheel_Balancing_Charges = tireQuote_Wheel_Balancing_Charges
							.replaceAll("\\$", "").trim();

					bill_wheel_balance = Float
							.parseFloat(tireQuote_Wheel_Balancing_Charges);

				} else {

					bill_wheel_balance = 0;

				}

				if (!tireQuote_TPMS_Charges.contains("FREE")
						&& !tireQuote_TPMS_Charges.contains("$0")) {

					tireQuote_TPMS_Charges = tireQuote_TPMS_Charges.replaceAll(
							"\\$", "").trim();

					bill_tpms_value_kit = Float
							.parseFloat(tireQuote_TPMS_Charges);

				} else {

					bill_tpms_value_kit = 0;

				}

				if (!tireQuote_TPMS_Labour_Charges.contains("FREE")
						&& !tireQuote_TPMS_Labour_Charges.contains("$0")) {

					tireQuote_TPMS_Labour_Charges = tireQuote_TPMS_Labour_Charges
							.replaceAll("\\$", "").trim();

					bill_tpms_value_kit_labour = Float
							.parseFloat(tireQuote_TPMS_Labour_Charges);

				} else {

					bill_tpms_value_kit_labour = 0;

				}

				if (!tireQuote_State_ENV_Charges.contains("FREE")
						&& !tireQuote_State_ENV_Charges.contains("$0")) {

					tireQuote_State_ENV_Charges = tireQuote_State_ENV_Charges
							.replaceAll("\\$", "").trim();

					bill_env_fee = Float
							.parseFloat(tireQuote_State_ENV_Charges);

				} else {

					bill_env_fee = 0;

				}

				if (!tireQuote_Tyre_Recycling_Charges.contains("FREE")
						&& !tireQuote_Tyre_Recycling_Charges.contains("$0")) {

					tireQuote_Tyre_Recycling_Charges = tireQuote_Tyre_Recycling_Charges
							.replaceAll("\\$", "").trim();

					bill_recycle_charge = Float
							.parseFloat(tireQuote_Tyre_Recycling_Charges);

				} else {

					bill_recycle_charge = 0;

				}

				logInfo("bill_tiresPrice = " + bill_tiresPrice);

				logInfo("bill_installation = " + bill_installation);

				logInfo("bill_wheel_alignment = " + bill_wheel_alignment);

				logInfo("bill_tire_rotation = " + bill_tire_rotation);

				logInfo("bill_wheel_balance = " + bill_wheel_balance);

				logInfo("bill_tpms_value_kit = " + bill_tpms_value_kit);

				logInfo("bill_tpms_value_kit_labour = "
						+ bill_tpms_value_kit_labour);

				logInfo("bill_env_fee = " + bill_env_fee);

				logInfo("bill_recycle_charge = " + bill_recycle_charge);

				float bill_total_expected = (bill_env_fee + bill_installation
						+ bill_recycle_charge + bill_tire_rotation
						+ bill_tiresPrice + bill_tpms_value_kit
						+ bill_tpms_value_kit_labour + bill_wheel_alignment + bill_wheel_balance);

				String bill_total_expected_formatted = "" + bill_total_expected;

				bill_total_expected_formatted = bill_total_expected_formatted
						.substring(0,
								bill_total_expected_formatted.indexOf(".") + 3);

				bill_total_expected = Float
						.parseFloat(bill_total_expected_formatted);

				float bill_total_actual = Float
						.parseFloat(tireQuote_Grand_Total_Charges);

				logInfo("bill_total_actual = " + bill_total_actual);

				logInfo("bill_total_expected = " + bill_total_expected);

				if (bill_total_actual == bill_total_expected) {

					logInfo("Tire quote bill verification success.");

				} else {

					logInfo("bill_total_actual = " + bill_total_actual);

					logInfo("bill_total_expected = "
							+ (bill_total_expected + 0.01));

					if (bill_total_actual == (bill_total_expected + 0.01)) {

						logInfo("Tire quote bill verification success.");

					} else {

						throw new BSROException(
								"Tire quote bill verification failed.");
					}

				}

				// Verifying only for first tyre.

				break;

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("TireQuote.verify() function failed.");

			throw new BSROException(e);

		}

	}

}
