package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.flipkart.com/");
//		driver.findElement(By.)
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.id("email")).sendKeys("abc@gamil.com");
		
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		for(WebElement l : list) {
			System.out.println(l.getText());
		}
		
		//WebElement search = driver.findElement(By.id("email"));
		//search.sendKeys("asdfg");
		//driver.close();
	}

}
