package com.replicon;

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

public class companyHolidays {

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
		
		util.Click("(//button[@class='mdc-button headerButton'])[2]");
		util.Click("//div[@class='company-holiday']");
		List<WebElement> holidayNames = driver.findElements(By.xpath("//td[@role='rowheader']"));
		List<WebElement> holidayDates = driver.findElements(By.xpath("//td[@aria-describedby='grid_urn:replicon:holiday-list-column:date']"));
		Map<String, String> map = new LinkedHashMap<>();

		for (int i = 0; i < holidayNames.size() - 1; i++) {
			String holidayName = holidayNames.get(i + 1).getText();
			String holidayDate = holidayDates.get(i).getText();
			map.put(holidayName, holidayDate);
		}

		for (Map.Entry<String, String> entry : map.entrySet())
			System.out.println(entry.getKey() + " - " + entry.getValue());
	}
	
	@AfterTest
	public static void quitWindow() {
		util.quitWIndow();
	}
}
