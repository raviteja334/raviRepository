package com.ravi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario3Test {

	@Test
	public void ExecutingTheFlow() throws Exception {
		Scenario3Util.openApplication();
		Scenario3Util.takeScreenShot();
	}
	
	@BeforeMethod
	public static void readExcelValuess() throws Exception {
		Scenario3Util.readExcelValues();
	}
	
	@AfterClass
	public static void closeDriver() {
		Scenario3Util.driverQuit();
	}
}