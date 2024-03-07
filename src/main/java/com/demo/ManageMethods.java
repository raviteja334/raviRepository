package com.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
				
		//driver.manage().window().maximize();
		System.out.println(driver.manage().toString());
		driver.manage().deleteAllCookies();
		
		driver.manage().window().fullscreen();
		driver.manage().window().minimize();
	}

}
