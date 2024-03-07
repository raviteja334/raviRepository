package com.demo;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluientWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.manage().window().maximize();
	
		driver.findElement(By.id("btn1")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(5))
				  .pollingEvery(Duration.ofSeconds(1))
				  .withMessage("Hi This test message")
				  .ignoring(NoSuchElementException.class);
		
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver webdriver) {
				return webdriver.findElement(By.xpath("(//input[@id='txt1'])[1]")).isDisplayed();
			}
		};
		
		wait.until(function);
		driver.findElement(By.xpath("(//input[@id='txt1'])[1]")).sendKeys("cvbnk");
		
	}

}
