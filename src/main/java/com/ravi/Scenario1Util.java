package com.ravi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Scenario1Util {

	static WebDriver driver;
	static DriverUtils util;
	
	public void ValidateValues() {
		
	}
	
	@BeforeTest
	public void openApplication() {
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		util.openApp("https://demo.automationtesting.in/Index.html");
	}
}
