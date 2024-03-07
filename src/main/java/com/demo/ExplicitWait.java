package com.demo;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// webDriverWait extends FluentWait
public class ExplicitWait {

	public static void main(String[] args) {

		// VisibilityElementLocated();
		manualMethod();

	}

	public static void manualMethod() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//WebDriverWait wait1 = new WebDriverWait(driver, null, null)

		driver.findElement(By.id("btn2")).click();

		Function<WebDriver, Boolean> fun = new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver webdriver) {
				return webdriver.findElement(By.xpath("(//input[@id='txt2'])[1]")).isDisplayed();
			}
		};
		wait.until(fun);
		driver.findElement(By.xpath("(//input[@id='txt2'])[1]")).sendKeys("Ravi");

	}

	public static void VisibilityElementLocated() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String parent = driver.getWindowHandle();
		driver.findElement(By.id("newWindowBtn")).click();

		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parent)) {
				driver.manage().window().maximize();
				driver.switchTo().window(window);

//				Function<WebDriver, Boolean> fun = new Function<WebDriver, Boolean>() {
//
//					public Boolean apply(WebDriver webDriver) {
//						return webDriver.findElement(By.id("firstName")).isDisplayed();
//					}
//				};
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

				// wait.until(fun);
				driver.findElement(By.id("firstName")).sendKeys("Ravi");
			}
		}
	}

}
