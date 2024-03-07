package com.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RaviTest {

	@Test
	public void TestGoogle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("facebook", Keys.ENTER);
		String exepetedTitle = "facebook - Google Search";
		String actualTitle = driver.getTitle();
		//Assert.assertEquals(actualTitle,exepetedTitle);
		Assert.assertEquals(actualTitle,exepetedTitle, "Title is mismatched" );
		driver.quit();
	}
	
	@Test
	public void TestFacebook() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("email");
		System.out.println(driver.getTitle());
	}
	

	@Test
	public void Testtt() {
		Assert.assertTrue(true);
	}
		
}
