package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Frames2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.findElement(By.id("name")).sendKeys("text");
		driver.switchTo().frame("frm1");
		Select courseName = new Select(driver.findElement(By.id("course")));
		courseName.selectByVisibleText("Java");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frm2");
		driver.findElement(By.id("firstName")).sendKeys("Ravi name in frame 2");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frm1");
		Select courseName1 = new Select(driver.findElement(By.id("course")));
		courseName1.selectByVisibleText("Dot Net");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("updated text in parent frame");
	}

}
