package com.demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsHandle3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'Credit Card only? Login here')]")).click();
		Set<String> windows = driver.getWindowHandles();
		
		for (String windowHandle : windows) {
			driver.switchTo().window(windowHandle);
			driver.findElement(By.id("openMarketUID")).sendKeys("Ravi");
			driver.close();
		}
		driver.switchTo().window(mainWindow);
		driver.close();
		
		
		
		
	}

}
