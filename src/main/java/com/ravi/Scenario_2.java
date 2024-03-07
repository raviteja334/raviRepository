package com.ravi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RNALAM\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Index.html");
		driver.findElement(By.xpath("//button[text()='Skip Sign In']")).click();

		Actions actions = new Actions(driver);

		actions.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']")))
				.moveToElement(driver.findElement(By.xpath("//a[text()='Frames']")))
				.click().build().perform();
		
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sdfg");
		
	}

}
