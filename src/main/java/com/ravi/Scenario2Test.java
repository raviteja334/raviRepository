package com.ravi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario2Test{

	@Test
	public void ExecutingTheFlow() {
		Scenario2Util.openApp();
		Scenario2Util.enterTextInTextbox();
		Scenario2Util.dateSlecting();
	}
	@BeforeMethod
	public static void readExcelValuess() throws Exception {
		Scenario2Util.readExcelValues();
	}
	
	@AfterClass
	public static void closeDriver() {
		Scenario2Util.driverQuit();
	}
	
	
}
