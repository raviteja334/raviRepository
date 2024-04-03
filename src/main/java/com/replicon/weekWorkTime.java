package com.replicon;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class weekWorkTime {

	static WebDriver driver;
	static driverUtils util;
	
	@BeforeTest
	public static void openApp() {
		driver = new ChromeDriver();
		util = new driverUtils(driver);
		util.openApp("https://talent.capgemini.com/in");
	}
	
	@Test
	public static void printWeekWorkTime() {
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
		util.Click("//a[text()='See all timesheets']");
		
		List<WebElement> timesheetPeriods = driver.findElements(By.xpath("//a[@class='displayName']"));
		//List<WebElement> weekWorkTime = driver.findElements(By.xpath("//a[@class='displayName']"));
	}
	
	@AfterTest
	public static void quitWindow() {
		util.quitWIndow();
	}
}
