package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Frames3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.findElement(By.id("name")).sendKeys("text");
		
		driver.switchTo().frame("frm3");
		driver.findElement(By.id("name")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("name")).sendKeys("text inside frame");
		
		driver.switchTo().frame("frm1");
		Select courseName = new Select(driver.findElement(By.id("course")));
		courseName.selectByVisibleText("Java");
		
				
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("name")).sendKeys("text in parent frmae");
		
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("name")).sendKeys("text in main frmae or main web application");
		
	}

}
