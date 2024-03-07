package com.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//locators in jse id,classname,name,tagname,css selector, xpath
public class JavaScriptExe {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement element = (WebElement) jse.executeScript("return document.getElementById('email').value='ravi@gamil.com';");
		//element.sendKeys("email");
		
		//WebElement element1 = (WebElement) jse.executeScript("document.getElementByName(‘email’)[0];");
		//element1.sendKeys("ravi@gamil");
		
		
	}

}
