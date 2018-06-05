package productionLogs;

import java.util.ArrayList;
import java.util.Calendar;

public class GetDates {

	public static void main(String[] args) {
		String[] monthName = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		String invalidmonth = "";
		ArrayList dates = new ArrayList();

		ArrayList months = new ArrayList();

		Calendar now = Calendar.getInstance();

		System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1)
				+ "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));

		System.out.println(now.get(Calendar.MONTH) + 1);

		String month1 = monthName[now.get(Calendar.MONTH)];

		System.out.println(month1);

		dates.add(now.get(Calendar.DATE));

		for (int i = 0; i < 30; i++) {

			now.add(Calendar.DATE, 1);

			dates.add(now.get(Calendar.DATE));

			System.out.println(now.get(Calendar.DATE));
		}

		System.out.println(dates);

		String month2 = monthName[now.get(Calendar.MONTH)];

		System.out.println("month 2  :" + month2);

		if (month1.equals(month2)) {

			months.add(month1);
			System.out.println(months);
		} else {
			months.add(month1);
			months.add(month2);
			System.out.println(months);
		}

		invalidmonth = monthName[now.get(Calendar.MONTH) + 3];

		System.out.println(invalidmonth);

	}
}