package suite1;

import org.testng.annotations.Test;

import com.aem.library.ProjectSpecific;
import com.hybird.SuperTestNG;

public class ValidLogin extends SuperTestNG {
	@Test
	public void testValidLogin() {
		ProjectSpecific.login();
		String sExpectedResult = "You are logged in as Vinoth Kumar";
		step.verifyText("className", "welcomename", sExpectedResult);
		step.screenShot(getClass().getSimpleName());
	}
}
