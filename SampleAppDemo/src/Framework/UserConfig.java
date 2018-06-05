package Framework;

import resources.Framework.UserConfigHelper;

/**
 * Description : Functional Test Script
 * 
 * @author admin
 */
public class UserConfig {

	/**
	 * Script Name : <b>Constants</b> Generated : <b>Apr 11, 2013 5:58:38 PM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7600 ()
	 * 
	 * @since 2013/04/11
	 * @author admin
	 */

	// Constants that are need to initialize by user before start of test
	// execution.

	public static boolean useSSL = false; // Define whether site which is going
											// to test
	// is HTTP or HTTPS based one.

	public static String websiteHostName = "www.firestonecompleteautocare.com"; // For
	// example
	// -
	// www.google.com

	public static String applicationURL = "";

	public static int browserTypeToTest = 1; // IE = 1 ; Firefox = 2 , Chrome =
												// 3

	public static boolean deleteCookiesOnStartUp = false; // By default cookies
															// will
	// not be cleared before
	// launching site.

	public static boolean maximizeBrowserWindowOnStartUp = true; // Whether
																	// browser
	// window needs to
	// be maximized or
	// continue is
	// default open
	// state.

	public static int browserMaxWaitToLoadPage = 60; // In seconds.

	public static boolean closeBrowserWindowsOnExecutionComple = false;

	public static int stepCount = 1;

	public static boolean showTrayNotifications = false;

}
