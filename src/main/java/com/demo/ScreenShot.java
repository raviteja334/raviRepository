package com.demo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("C:\\Users\\RNALAM\\OneDrive - Capgemini\\Desktop\\homepage.png"));
		
//		WebElement section = driver.findElement(By.xpath("//div[@id='mainContent']//div[5]"));
//		File sectionFile = section.getScreenshotAs(OutputType.FILE);
//		Files.copy(sectionFile, new File(".\\screenshots\\homepage.png"));

//		WebElement section = driver.findElement(By.id("gh-logo"));
//		File sectionFile = section.getScreenshotAs(OutputType.FILE);
//		Files.copy(sectionFile, new File(".\\screenshots\\homepage.png"));
		
		
		
	}

}
