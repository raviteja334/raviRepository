package com.ravi;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.replicon.driverUtils;

public class Testtt {

	static WebDriver driver;
	static driverUtils util;

	@BeforeTest
	public static void openApp() {
		driver = new ChromeDriver();
		util = new driverUtils(driver);
		util.openApp("https://talent.capgemini.com/in");
	}

	@Test
	public static void printCompanyHolidays() {
		String mainWindow = driver.getWindowHandle();
		util.Click("//a[@title='Replicon']");
		Set<String> windows = driver.getWindowHandles();
		
		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
		
		util.Click("//a[@href='#' and @class='fakeButtonBase showMore']");
		List<WebElement> holidayNames = driver.findElements(By.xpath("//span[@class='timeOffType']"));
		System.out.println(holidayNames.size());
		List<WebElement> holidayDates = driver.findElements(By.xpath("//span[@class='balanceAmount']//strong"));
		System.out.println(holidayDates.size());
		Map<String, String> map = new LinkedHashMap<>();

		for (int i = 0; i < holidayNames.size() - 1; i++) {
			String holidayName = holidayNames.get(i + 1).getText();
			String holidayDate = holidayDates.get(i).getText();
			map.put(holidayName, holidayDate);
		}

		for (Map.Entry<String, String> entry : map.entrySet())
			System.out.println(entry.getKey() + " - " + entry.getValue());
	}
	
	//@AfterTest
	public static void quitWindow() {
		util.quitWIndow();
	}
}
