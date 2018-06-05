package contactUS_us_en;

public class Test {

	public static void main(String[] args) {
//		String expectedvalue = "CONTACT US\n"
//		  		+ "Thank you for visiting the Breyers  ® , web site.\n"
//		  		+ "If you would like to speak to a consumer advisor please call us at: \n"
//		  		+ "1-800-931-2826  Monday-Friday 8:30 AM-9:00 PM Eastern Time. \n"
//		  		+ "IF THIS IS A MEDICAL OR PRODUCT SAFETY EMERGENCY, PLEASE CALL 1-800-745-9269. This number is available 24 hours a day / 7 days a week. \n"
//		  		+ "If you are reporting a problem with one of our products, please be sure to include your address and a telephone number where you can be reached during the day so we can contact you for further information. \n"
//		  		+ "Unilever does not collect personal information from children under 13. \n"
//		  		+ "* indicates required information";
//		System.out.println(expectedvalue);

		String test = "xpath=//div[@for='firstName']";
		test=test.substring(test.indexOf("=")+1);
		
		System.out.println(test);
		
	}

}
