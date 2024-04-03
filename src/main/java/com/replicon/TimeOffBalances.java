package com.replicon;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TimeOffBalances {

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
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[@aria-label='My Replicon']"))).click().build().perform();
		util.Click("//a[text()='Time Off']");
		util.Click("//a[text()='All Balances']");
		List<WebElement> leaveType = driver.findElements(By.xpath("//a[@class='displayName']"));
		List<WebElement> days = driver.findElements(By.xpath("//td[@aria-describedby='grid_balance']"));
		Map<String, String> map = new LinkedHashMap<>();

		for (int i = 0; i < leaveType.size() - 1; i++) {
			String leavetype = leaveType.get(i + 1).getText();
			String leaveName = leavetype.replace("[IND] - ", "");
			String Days = days.get(i).getText();
			map.put(leaveName, Days);
		}

		for (Map.Entry<String, String> entry : map.entrySet())
			System.out.println(entry.getKey() + " - " + entry.getValue());
	}
	
	@AfterTest
	public static void quitWindow() {
		util.quitWIndow();
	}
}
