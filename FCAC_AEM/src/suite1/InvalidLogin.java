package suite1;

import org.testng.annotations.Test;

import com.hybird.Keywords;
import com.hybird.SuperTestNG;

public class InvalidLogin extends SuperTestNG {
	@Test
	public void testInvalidLogin() {
		for (int i = 3; i <= 7; i++) {
			String sUserName = Keywords.getData(stestDataFile, "Login", i, 3);
			step.enterText("name", "username", sUserName);
			String sPassword = Keywords.getData(stestDataFile, "Login", i, 4);
			step.enterText("name", "password", sPassword);
			step.clickElm("className", "submitbtn");
			String expectedResult = Keywords.getData(stestDataFile, "Login", i,
					5);
			step.verifyText("xpath",
					"//label[contains(text(),'User Authentication Failed')]",
					expectedResult);
			step.screenShot(getClass().getSimpleName() + " input_" + i);
		}
	}
}
