package ProductSpecificFunctions.Store.StoreDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Vector;

import resources.ProductSpecificFunctions.Store.StoreDetails.VerifyHolidayHelper;
import Framework.BSROException;

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
public class VerifyHoliday extends VerifyHolidayHelper {
	/**
	 * Script Name : <b>VerifyHoliday</b> Generated : <b>Aug 1, 2013 6:13:35
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/08/01
	 * @author css89714
	 */

	public static String nextBussinessDate = "";

	public static String nextWeekEndDate = "";

	public static String weekDay[] = { "SUN", "MON", "TUE", "WED", "THU",
			"FRI", "SAT" };

	public static Calendar calendar = Calendar.getInstance();

	public static Calendar localTime = new GregorianCalendar(
			TimeZone.getTimeZone("CST"));

	public static ArrayList<String> holidays = new ArrayList<String>();

	public static String months[] = { "January", "February", "March", "April",
			"May", "Jun", "July", "August", "September", "October", "November",
			"December" };

	public static boolean isHoliday(String argDate) throws BSROException {

		logInfo("argDate = " + argDate);

		holidays.clear();

		boolean isHoliday = false;

		try {

			Connection connection = Database.ProductDBConnection.getConnection(
					"RTMS_WEBDB", "RTMS_WEBDB");

			Statement statement = connection.createStatement();
			String query = "select '' || Month || '/'|| Day || '/'|| Year as \"Date\" from RTMS_WEBDB.STORE_HOLIDAY order by Year,Month,Day asc";
			ResultSet rsQry = statement
					.executeQuery(query);

			logInfo("Database Connection \n Query => "+query);
			while (rsQry.next()) {

				holidays.add(rsQry.getString("Date"));

			}

			if (holidays.contains(argDate)) {

				isHoliday = true;

			}
			
			logInfo("Database connection done successfully without issues");

			logInfo("List of Holidays :" + holidays.toString());

		} catch (Exception e) {

			logInfo("Exception Observed Please Refer :=> "+e.getMessage());
			logError("Failed to get Holiday's list in GetHoliday() function");
			
			throw new BSROException(e);
		}

		return isHoliday;

	}

}
