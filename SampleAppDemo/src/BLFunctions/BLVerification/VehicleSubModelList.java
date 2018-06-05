package BLFunctions.BLVerification;

import java.util.ArrayList;

import resources.BLFunctions.BLVerification.VehicleSubModelListHelper;
import Framework.BSROException;
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
public class VehicleSubModelList extends VehicleSubModelListHelper {
	/**
	 * Script Name : <b>VehicleSubModelList</b> Generated : <b>Jun 27, 2013
	 * 1:06:25 AM</b> Description : Functional Test Script Original Host : WinNT
	 * Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/06/27
	 * @author css89714
	 */

	public static void verify() throws BSROException {

		try {

			ArrayList<String> actualListItems = new ArrayList<String>();

			ArrayList<String> expectedListItems = new ArrayList<String>();

			actualListItems = BLFunctions.ActualData.VehicleSubModelList
					.getSubModelsList();

			int manufacturerYear = -1;

			String manufacturerName = "";

			String vehicleModel = "";

			String[] arguments = KeyWordDrivenConstants.TC_EXPECTED.split(";");

			for (String arg : arguments) {

				if (arg.toUpperCase().contains("YEAR")) {

					try {

						manufacturerYear = Integer.parseInt(arg.substring(
								arg.indexOf("=") + 1, arg.length()).trim());

					} catch (Exception e) {
						// TODO: handle exception

						throw new BSROException(
								"Invalid manufacturerYear specified as argument to VehicleSubModelList.verify() function.");

					}

				} else if (arg.toUpperCase().contains("MANUFACTURER")) {

					manufacturerName = arg.substring(arg.indexOf("=") + 1,
							arg.length());

				} else if (arg.toUpperCase().contains("MODEL")) {

					vehicleModel = arg.substring(arg.indexOf("=") + 1,
							arg.length());

				}

			}

			expectedListItems = BLFunctions.ExpectedData.VehicleSubModelList
					.getModelsListByYearAndManufacturerAndModel(
							manufacturerYear, manufacturerName, vehicleModel);

			System.out.println("actualListItems => " + actualListItems);

			System.out.println("expectedListItems => " + expectedListItems);

			for (String string : actualListItems) {

				try {

					expectedListItems.remove(string);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}

			if (expectedListItems.size() == 0) {

				logInfo("BLogic validation for VehicleSubModelList.verify() function is validated successfully.");

			} else {

				throw new BSROException(
						"Critical : VehicleSubModelList.verify() method failed during business logic validation.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("Unable to perform VehicleSubModelList.verify() function.");

			throw new BSROException(e);

		}

	}
}
