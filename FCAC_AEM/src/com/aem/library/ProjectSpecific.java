package com.aem.library;

import com.hybird.Keywords;
import com.hybird.SuperTestNG;

public class ProjectSpecific extends SuperTestNG {
	public static void login() {
		String sUserName = Keywords.getData(stestDataFile, "Login", 1, 3);
		step.enterText("name", "username", sUserName);
		String sPassword = Keywords.getData(stestDataFile, "Login", 1, 4);
		step.enterText("name", "password", sPassword);
		step.clickElm("className", "submitbtn");
		// step.verifyPageTitle("Global HRMS");

	}
}