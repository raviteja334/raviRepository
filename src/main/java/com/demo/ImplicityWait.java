package com.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicityWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//5min
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Actions actions = new Actions(driver);
//		actions
//		.moveToElement(driver.findElement(By.xpath("")))
//		.click()
//		.perform();// moveToElement or mouseHover
		
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("txt1")).sendKeys("Ravi");
		
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("txt2")).sendKeys("Teja");
		
	}

}
