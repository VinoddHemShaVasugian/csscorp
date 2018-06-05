package BLFunctions.BLVerification;

import org.openqa.selenium.By;

import resources.BLFunctions.BLVerification.TPMSHelper;
import Framework.BSROException;
import Framework.CoreUtils;
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
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;

/**
 * Description : Functional Test Script
 * 
 * @author css89714
 */
public class TPMS extends TPMSHelper {
	/**
	 * Script Name : <b>TPMS</b> Generated : <b>Jul 12, 2013 5:19:54 PM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7601 (S)
	 * 
	 * @since 2013/07/12
	 * @author css89714
	 * @throws BSROException
	 */

	public static void verify_TPMS_BL_On_Tires_By_Vehicle_Widget()
			throws BSROException {

		try {

			int vehicleYear = -1;

			String vehicleMake = "";

			String vehicleModel = "";

			String vehicleSubModel = "";

			String argPassed = KeyWordDrivenConstants.TC_EXPECTED.trim();

			String args[] = argPassed.split(";");

			if (4 != args.length) {

				throw new BSROException(
						"verify_TPMS_BL_On_Tires_By_Vehicle_Widget : All required args not supplied.");

			}

			for (int loopCount = 0; loopCount < args.length; loopCount++) {

				String valueFormatted = args[loopCount].replaceAll(";", "");

				String value = valueFormatted.substring(
						valueFormatted.indexOf("=") + 1,
						valueFormatted.length());

				if (args[loopCount].toLowerCase().startsWith("vehicleyear")) {

					vehicleYear = Integer.parseInt(value);

				} else if (args[loopCount].toLowerCase().startsWith(
						"vehiclemake")) {

					vehicleMake = value;

				} else if (args[loopCount].toLowerCase().startsWith(
						"vehiclemodel")) {

					vehicleModel = value;

				} else if (args[loopCount].toLowerCase().startsWith(
						"vehiclesubmodel")) {

					vehicleSubModel = value;

				}

			}

			Framework.HtmlSelect.selectItemByID_Selenium("universal-year", ""
					+ vehicleYear);

			Framework.HtmlSelect.selectItemByID_Selenium("universal-make",
					vehicleMake);

			Framework.HtmlSelect.selectItemByID_Selenium("universal-model",
					vehicleModel);

			Framework.HtmlSelect.selectItemByID_Selenium("universal-submodel",
					vehicleSubModel);

			String actual_tpmsValue = BLFunctions.ActualData.TPMS
					.tpmsComboValue(KeyWordDrivenConstants.TC_ACTION_TYPE);

			boolean actual_tpmsComboStateEnabled = BLFunctions.ActualData.TPMS
					.isTPMSEnabled(KeyWordDrivenConstants.TC_ACTION_TYPE);

			int standardTPMSValue = BLFunctions.ExpectedData.TPMS
					.getStandardTPMSValue(vehicleYear, vehicleMake,
							vehicleModel, vehicleSubModel);

			String expected_tpmsValue = BLFunctions.ExpectedData.TPMS
					.tpmsComboValue(standardTPMSValue);

			boolean expected_tpmsComboStateEnabled = false;

			if (vehicleYear > BLFunctions.BLRulesData.TPMS.tpmsYearDefault) {

				expected_tpmsComboStateEnabled = false;

			} else {

				expected_tpmsComboStateEnabled = BLFunctions.ExpectedData.TPMS
						.isTPMSEnabled("" + vehicleYear, vehicleMake,
								vehicleModel, vehicleSubModel);

			}

			logInfo("actual_tpmsComboStateEnabled = "
					+ actual_tpmsComboStateEnabled);

			logInfo("expected_tpmsComboStateEnabled = "
					+ expected_tpmsComboStateEnabled);

			logInfo("actual_tpmsValue = " + actual_tpmsValue);

			logInfo("expected_tpmsValue = " + expected_tpmsValue);

			if (actual_tpmsComboStateEnabled != expected_tpmsComboStateEnabled) {

				throw new BSROException(
						"TPMS Combo Enabled State Validation Failed.");

			}

			if (false == expected_tpmsValue.equals(actual_tpmsValue)) {

				throw new BSROException("TPMS Combo Value Validation Failed.");

			}

			logInfo("BLFunctions.BLVerification.TPMS.verify_TPMS_BL_On_Tires_By_Vehicle_Widget() success.");

		} catch (Exception e) {
			// TODO: handle exception

			logError("TPMS.verify_TPMS_BL_On_Tires_By_Vehicle_Widget() function failed.");

			throw new BSROException(e);

		}

	}
}
