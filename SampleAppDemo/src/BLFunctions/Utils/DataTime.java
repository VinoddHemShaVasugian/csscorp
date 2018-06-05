package BLFunctions.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import Framework.BSROException;
import resources.BLFunctions.Utils.DataTimeHelper;


public class DataTime extends DataTimeHelper {
	/**
	 * Script Name : <b>DataTime</b> Generated : <b>Jun 26, 2013 9:46:58 PM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7601 (S)
	 * 
	 * @since 2013/06/26
	 * @author css89714
	 * @throws BSROException
	 */
	@SuppressWarnings("deprecation")
	public static int getCurrentYearByTimeZone(String argTimeZone,
			String argFormat) throws BSROException {

		int currentYear = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			String strdate = null;

			DateFormat formatter = new SimpleDateFormat("dd-MM-" + ""+ argFormat + " HH:mm:ss");

			strdate = formatter.format(currentdate.getTime());

			TimeZone obj = TimeZone.getTimeZone(argTimeZone.toUpperCase());

			formatter.setTimeZone(obj);

			java.util.Date resultFormattedByTimeZone = formatter.parse(strdate);

			currentYear = resultFormattedByTimeZone.getYear();

		} catch (Exception e) {

			//logError("Unable to DateTime.perform getCurrentDateByTimeZone() function.");

			throw new BSROException(e);

		}

		if (currentYear == -1) {

			//logError("Unable to DateTime.perform getCurrentDateByTimeZone() function.");

			throw new BSROException(
					"Unable to DateTime.perform getCurrentDateByTimeZone() function.");

		}

		return (1900 + currentYear);

	}

	@SuppressWarnings("deprecation")
	public static int getCurrentMonthByTimeZone(String argTimeZone,
			String argFormat) throws BSROException {

		int currentMonth = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			String strdate = null;

			DateFormat formatter = new SimpleDateFormat("dd-" + "" + argFormat
					+ "-YYYY HH:mm:ss");

			strdate = formatter.format(currentdate.getTime());

			TimeZone obj = TimeZone.getTimeZone(argTimeZone.toUpperCase());

			formatter.setTimeZone(obj);

			java.util.Date resultFormattedByTimeZone = formatter.parse(strdate);

			currentMonth = resultFormattedByTimeZone.getMonth();

		} catch (Exception e) {

			//logError("Unable to DateTime.perform getCurrentMonthByTimeZone() function.");

			throw new BSROException(e);

		}

		if (currentMonth == -1) {

			//logError("Unable to DateTime.perform getCurrentMonthByTimeZone() function.");

			throw new BSROException(
					"Unable to DateTime.perform getCurrentMonthByTimeZone() function.");

		}

		return (currentMonth);

	}

	@SuppressWarnings("deprecation")
	public static int getCurrentDayByTimeZone(String argTimeZone,
			String argFormat) throws BSROException {

		int currentDay = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			currentDay = currentdate.get(Calendar.DAY_OF_MONTH);

		} catch (Exception e) {

			//logError("Unable to DateTime.perform getCurrentDayByTimeZone() function.");

			throw new BSROException(e);

		}

		if (currentDay == -1) {

			//logError("Unable to DateTime.perform getCurrentMonthByTimeZone() function.");

			throw new BSROException(
					"Unable to DateTime.perform getCurrentMonthByTimeZone() function.");

		}

		return (currentDay);

	}

	public static int getCurrentYear() throws BSROException {

		int currentYear = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			currentYear = currentdate.get(Calendar.YEAR);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

		return currentYear;
	}

	public static int getCurrentDayOfMonth() throws BSROException {

		int currentDayOfMonth = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			currentDayOfMonth = currentdate.get(Calendar.DAY_OF_MONTH);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

		return currentDayOfMonth;
	}

	public static int getCurrentDayOfWeek() throws BSROException {

		int currentDayOfWeek = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			currentDayOfWeek = currentdate.get(Calendar.DAY_OF_WEEK);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

		return currentDayOfWeek;
	}

	public static int getCurrentMonthOfYear() throws BSROException {

		int currentMonthOfYear = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			currentMonthOfYear = currentdate.get(Calendar.MONTH);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

		return currentMonthOfYear;
	}

	public static int getCurrentHourOfDay() throws BSROException {

		int currentHourOfDay = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			currentHourOfDay = currentdate.get(Calendar.HOUR_OF_DAY);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

		return currentHourOfDay;
	}

	public static int getCurrentMinuteOfHour() throws BSROException {

		int currentMinuteOfHour = -1;

		try {

			Calendar currentdate = Calendar.getInstance();

			currentMinuteOfHour = currentdate.get(Calendar.MINUTE);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

		return currentMinuteOfHour;
	}

	public static int getTotalDaysOfCurrentMonth() throws BSROException {

		int lastDayOfMonth = -1;

		try {

			lastDayOfMonth = Calendar.getInstance().getActualMaximum(
					Calendar.DAY_OF_MONTH);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

		return lastDayOfMonth;
	}

	public static int getTotalDaysOfSpecificMonth(int monthNumber, int year)
			throws BSROException {

		int lastDayOfMonth = -1;

		try {

			Calendar calendar = Calendar.getInstance();

			calendar.set(Calendar.YEAR, year);

			calendar.set(Calendar.MONTH, monthNumber);

			lastDayOfMonth = calendar.getActualMaximum(Calendar.DATE);

		} catch (Exception e) {
			// TODO: handle exception

			throw new BSROException(e);
		}

		return lastDayOfMonth;
	}

	public static ArrayList dateSplit(String startFormat, String endFormat,
			int startInterval, int endInterval) {

		ArrayList sl = new ArrayList();

		String am_pm[] = { "am", "pm" };

		// int startInterval = 1;
		// int endInterval = -2;

		java.util.Date startDate = new java.util.Date("01/01/2012 "
				+ startFormat);

		java.util.Date endDate = new java.util.Date("01/01/2012 " + endFormat);

		Calendar cc1 = Calendar.getInstance();
		Calendar cc2 = Calendar.getInstance();

		cc1.setTime(startDate);
		cc1.add(Calendar.HOUR, startInterval);

		cc2.setTime(endDate);
		cc2.add(Calendar.HOUR, (-endInterval));

		if (cc2.compareTo(cc2) == 0) {

			while ((cc1.getTime().getHours()) < cc2.getTime().getHours()) {

				if ((cc1.getTime().getHours()) <= cc2.getTime().getHours()) {

					sl.add((cc1.get(Calendar.HOUR) == 0 ? cc1
							.get(Calendar.HOUR_OF_DAY) : cc1.get(Calendar.HOUR))
							+ ":"
							+ minutesFormat(cc1.get(Calendar.MINUTE))
							+ " " + am_pm[cc1.get(Calendar.AM_PM)]);

					cc1.add(Calendar.MINUTE, 15);

					if (cc1.getTime().getHours() == cc2.getTime().getHours()
							&& cc1.get(Calendar.MINUTE) == cc2
									.get(Calendar.MINUTE)) {

						sl.add((cc1.get(Calendar.HOUR) == 0 ? cc1
								.get(Calendar.HOUR_OF_DAY) : cc1
								.get(Calendar.HOUR))
								+ ":"
								+ minutesFormat(cc1.get(Calendar.MINUTE))
								+ " " + am_pm[cc1.get(Calendar.AM_PM)]);

					}

				}
			}
		}

		return sl;

	}

	public static String minutesFormat(int mi) {
		if (mi < 10)
			return "0" + mi;
		else
			return "" + mi;
	}

}
