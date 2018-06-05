package BLFunctions.BLVerification;

import java.util.ArrayList;

import resources.BLFunctions.BLVerification.VehicleManufacturerListHelper;
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
public class VehicleManufacturerList extends VehicleManufacturerListHelper {
	/**
	 * Script Name : <b>VehicleManufacturerList</b> Generated : <b>Jun 26, 2013
	 * 11:14:46 PM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/06/26
	 * @author css89714
	 * @throws BSROException
	 */
	public static void verify() throws BSROException {
		try {

			ArrayList<String> actualListItems = new ArrayList<String>();

			ArrayList<String> expectedListItems = new ArrayList<String>();

			actualListItems = BLFunctions.ActualData.VehicleManufacturersList
					.getManufacturersList();

			int selectedYear = Integer
					.parseInt(KeyWordDrivenConstants.TC_EXPECTED);

			expectedListItems = BLFunctions.ExpectedData.VehicleManufacturerList
					.getManufacturersListByYear(selectedYear);

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

				logInfo("BLogic validation for VehicleManufacturerList.verify() function is validated successfully.");

			} else {

				throw new BSROException(
						"Critical : VehicleManufacturerList.verify() method failed during business logic validation.");

			}

		} catch (Exception e) {
			// TODO: handle exception

			logError("Critical : VehicleManufacturerList.verify() method failed during business logic validation.");

			throw new BSROException(e);
		}
	}
}
