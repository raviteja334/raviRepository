package com.ravi;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class Ravi {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RNALAM\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Index.html");
		
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.id("btn2")).click();
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']")))
		.moveToElement(driver.findElement(By.xpath("//a[text()='Windows']")))
		.click()
		.build().perform();
		
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		
		Set<String> windows = driver.getWindowHandles();
		
		for (String window : windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				
			}
		}
		actions.moveToElement(driver.findElement(By.xpath("//h2[@class='selenium text-center']"))).perform();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File ("C:\\Users\\RNALAM\\OneDrive - Capgemini\\Desktop\\screenShot.png"));
		
		
		
	}

}
