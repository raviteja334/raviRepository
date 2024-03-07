package com.demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandle2 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='user-anonymous tnb-certificates-btn w3-bar-item w3-button w3-right w3-white ga-top ga-top-certificates']")).click();

		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {

			System.out.println(window);
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				driver.findElement(By.xpath("//input[@class='form-field-input live-search-form-field']")).sendKeys("Learn Java");
				driver.findElement(By.xpath("//button[@class='live-search-button']")).click();
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("search2")).sendKeys("python tutorial");
		driver.findElement(By.id("learntocode_searchicon")).click();
		//driver.close();
		// driver.findElement(By.xpath("//a[@class='w3-bar-item w3-button acctop-link
		// ga-top-drop ga-top-drop-cert-excel'][1]")).click();

		// Set<String> windows2 = driver.getWindowHandles();
		/*
		 * for (String window : windows2) { System.out.println("--"+window);
		 * if(!window.equals(mainWindow)) { driver.switchTo().window(window);
		 * driver.close(); } }
		 */
	}

}
