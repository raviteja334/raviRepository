package com.demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		//driver.get("https://www.ebay.com/");
		
		String firstWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("")).click();//it will open new window
		
		Set<String> windows = driver.getWindowHandles();//we will get list of windows as string
		
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			
			String window = itr.next();// it will return window 
			driver.switchTo().window(window);
			
		}
		
		driver.switchTo().window(firstWindow);
		
	}

}
