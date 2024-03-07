package com.demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsHandle1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		String mainWindow = driver.getWindowHandle();

		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String windowHandle : windows) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("Ravi");
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("name")).sendKeys("RaviTeja");
		Thread.sleep(5000);

		driver.findElement(By.id("newTabBtn")).click();

		Set<String> windows2 = driver.getWindowHandles();

		for (String windowHandle : windows2) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				driver.findElement(By.id("alertBox")).click();
				driver.switchTo().alert().accept();
				Thread.sleep(5000);
				driver.close();
			}
		}

		driver.switchTo().window(mainWindow);
		driver.close();

	}

}
