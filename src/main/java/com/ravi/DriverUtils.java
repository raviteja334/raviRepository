package com.ravi;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	private WebDriver driver;
	static Map<String, String> excelValues = new HashMap<>();
	
	public DriverUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void openApp(String url) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
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
		By by=By.xpath(xpath);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(by)).perform();
	}
	
	public void SwitchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void quitWIndow() {
		driver.quit();
	}
}
