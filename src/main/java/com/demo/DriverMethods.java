package com.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverMethods {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		
		
		//driver.wait(1000);
		
		System.out.println(driver.toString());
		System.out.println(driver.getTitle());
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url for the web page is: "+currentUrl);
		
		String text = driver.findElement(By.xpath("//a[text()=' Sell']")).getText();
		System.out.println(text);
		
		int list = driver.findElements(By.xpath("//a[text()=' Sell']")).size();
		System.out.println(list);
//		for(WebElement listt : list) {
//			System.out.println(listt);
//		}
		
		//System.out.println(driver.getPageSource());
		
		//driver.close();
	}

}
