package com.ravi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Index.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@type='button' and text()='Skip Sign In']")).click();
		
		Actions actions=new Actions(driver);
		
		actions
		.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']")))
		.moveToElement(driver.findElement(By.xpath("//a[text()='Frames']"))).click().build().perform();
		
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("adsfgh");
	
		driver.switchTo().defaultContent();
		
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Widgets']")))
		.moveToElement(driver.findElement(By.xpath("//a[text()=' Datepicker ']"))).click().build().perform();
		
		WebElement datePicker1 = driver.findElement(By.xpath("//input[@id='datepicker1']"));
		datePicker1.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='8']")).click();
		
		WebElement datePicker2 = driver.findElement(By.xpath("//input[@id='datepicker2']"));
		datePicker2.click();
		
		Select select1 = new Select(driver.findElement(By.xpath("//select[@title='Change the month']")));
		select1.selectByVisibleText("March");
		
		Select select2 = new Select(driver.findElement(By.xpath("//select[@title='Change the year']")));
		select2.selectByVisibleText("2024");
		
		driver.findElement(By.xpath("//a[@title='Select Friday, Mar 8, 2024']")).click();
		
		driver.quit();
	}
}