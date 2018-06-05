package BLFunctions.BLRulesData;

import resources.BLFunctions.BLRulesData.ScheduleAppointmentHelper;
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
public class ScheduleAppointment extends ScheduleAppointmentHelper {
	/**
	 * Script Name : <b>ScheduleAppointmentDateField</b> Generated : <b>Jun 27,
	 * 2013 4:34:10 AM</b> Description : Functional Test Script Original Host :
	 * WinNT Version 6.1 Build 7601 (S)
	 * 
	 * @since 2013/06/27
	 * @author css89714
	 */

	public static int nextActiveDaysInCalendar = 180;

	public static int timeSlices = 15;

	public static int minimumTimeDiffBetween2Appointments = 15;

	public static int eligibleStartTimeDeviationOnWeekDaysAfterStoreOpenTime = 0;

	public static int eligibleEndTimeDeviationOnWeekDaysBeforeStoreCloseTime = 1;

	public static int eligibleStartTimeDeviationOnWeekEndsAfterStoreOpenTime = 0;

	public static int eligibleEndTimeDeviationOnWeekEndsBeforeStoreCloseTime = 1;

}
