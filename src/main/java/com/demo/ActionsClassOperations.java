package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");

		Actions actions = new Actions(driver);
		actions
		.moveToElement(driver.findElement(By.xpath("//div[@class='OfferCard__OfferTitle-sc-1f27jzb-6 vOLKx'][text()='Save up to Rs 300 on AP, TS routes']")))
		.click()
		.perform();// moveToElement or mouseHover
						
		//driver.findElement(By.id("src")).sendKeys("Chennai");
		
		//actions.doubleClick(driver.findElement(By.id("src"))).perform();

		//actions.doubleClick();// double click operation
		//actions.doubleClick(driver.findElement(By.xpath("//a[text()='Tools and supplies']")));//double click operation on web element
		
		
	}

}
