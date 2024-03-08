package com.demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Index.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@type='button' and text()='Skip Sign In']")).click();
		
		Actions actions=new Actions(driver);
		
		actions
		.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']")))
		.moveToElement(driver.findElement(By.xpath("//a[text()='Windows']"))).click().build().perform();
		
		driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		for (String window : windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				WebElement text =driver.findElement(By.xpath("//h2[text()='Selenium Level Sponsors']"));
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,1000)","");
				//jse.executeScript("arguments[0].scrollIntoView()", text);
			}
		}
	}

}
