package com.driver.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	private WebDriver driver;
	
	public DriverUtils(WebDriver driver) {
		this.driver=driver;
	}

	public void Click(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By by = By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	
	public void Select(String xpath, String option) {
		By by = By.xpath(xpath);
		new Select(driver.findElement(by)).selectByVisibleText(option);;
	}
	
	public void Sendkeys(String xpath, String input) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By by = By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(input);
	}
	
	public String GetText(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By by = By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		return driver.findElement(by).getText();
	}
	public void Actions(String xpath) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		By by=By.xpath(xpath);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(by)).perform();
	}
	
	public void SwitchToFrame(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.switchTo().frame(element);
	}
}
