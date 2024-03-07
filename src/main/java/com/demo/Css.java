package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		//driver.findElement(By.cssSelector("//input[@id='email']")).sendKeys("ravi@gmail.com");
		
		driver.findElement(By.cssSelector("#pass")).sendKeys("ravi");
		
		//driver.findElement(By.cssSelector("")).click();
		
		
		
		
		//driver.findElement(By.cssSelector(".sign-up-link")).click();
		
		
		
		
		
		
		//driver.findElement(By.cssSelector("input[id*='password']")).sendKeys("Abbas@123123");
		
		//driver.findElement(By.cssSelector("select[aria-label^='Birth']")).click();
	}

}
