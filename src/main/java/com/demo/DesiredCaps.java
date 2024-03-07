package com.demo;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCaps {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		
		DesiredCapabilities desCaps = new DesiredCapabilities();
		desCaps.setBrowserName("chrome");
		desCaps.setPlatform(Platform.WINDOWS);
		desCaps.acceptInsecureCerts();
		desCaps.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		
		options.merge(desCaps);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
	}

}
