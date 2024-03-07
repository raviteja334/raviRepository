package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		driver.get("https://www.ebay.com/");
		
		System.out.println("using relative xpath");
		System.out.println("using or operator");
		//driver.findElement(By.xpath("//input[@id='gh-ac' or @name='_nkw']")).sendKeys("TShirts");
		System.out.println("using contains operator");
		//driver.findElement(By.xpath("//input[contains(@id,'gh')]")).sendKeys("shirts for men");
		System.out.println("using starts-with operator");
		//driver.findElement(By.xpath("//input[starts-with(@id,'gh')]")).sendKeys("shirts for men");
		System.out.println("using and operator");
		//driver.findElement(By.xpath("//input[@id='gh-btn' and @class='btn btn-prim gh-spr']")).click();
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]")).sendKeys("facebook.com");
		System.out.println("using text() function");
		driver.findElement(By.xpath("//a[text()=' Sell']")).click();
		
		driver.close();
	}

}
