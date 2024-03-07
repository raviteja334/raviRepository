package com.demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsHandle2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		String mainWindow = driver.getWindowHandle();

		driver.findElement(By.id("newWindowBtn")).click();
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		System.out.println(windows);
		for (String windowHandle : windows) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println(windowHandle+" "+driver.getTitle());
				if(driver.getTitle().equals("Basic Controls - H Y R Tutorials")) {
					//driver.switchTo().window(windowHandle);
					driver.manage().window().maximize();
					driver.findElement(By.id("firstName")).sendKeys("Basic Control window");
					Thread.sleep(5000);
					//driver.close();
				}
				//driver.switchTo().window(mainWindow);
				if(driver.getTitle().equals("AlertsDemo - H Y R Tutorials")) {
					driver.switchTo().window(windowHandle);
					driver.findElement(By.id("alertBox")).click();
					driver.switchTo().alert().accept();
					Thread.sleep(5000);
					driver.close();
				}
			}
		}
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("name")).sendKeys("Parent Window");
		
	}
	
	public static void switchToWindow(String windowTitle) {
		
	}

}
