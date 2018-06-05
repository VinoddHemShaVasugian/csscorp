package Framework;

import resources.Framework.VerificationPointHelper;
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
 * @author admin
 */
public class VerificationPoint extends VerificationPointHelper {
	/**
	 * Script Name : <b>VerificationPoint</b> Generated : <b>Apr 15, 2013
	 * 4:23:20 PM</b> Description : Functional Test Script Original Host : WinNT
	 * Version 6.1 Build 7600 ()
	 * 
	 * @since 2013/04/15
	 * @author admin
	 * @throws BSROException
	 */
	public void verify(int verificationPointType, String verificationPointName,
			Object actualObject, Object expecObject) throws BSROException {

		if (verificationPointType == 1) {

			vpManual(verificationPointName, actualObject, expecObject)
					.performTest();

			if (actualObject.equals(expecObject)) {

				logInfo("Page title verification success.");

			} else {

				logError("Page title verification failed.");

				throw new BSROException("Page title verification failed.");

			}

		}

	}

}
