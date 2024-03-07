package com.demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.math3.analysis.function.Max;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Practice {

	public static void main(String[] args) throws Exception {
		
//		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.apsrtconline.in/oprs-web/guest/home.do?h=1");
		
		
//		driver.get("https://www.google.com/");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File file = ts.getScreenshotAs(OutputType.FILE);
//		Files.copy(file, new File("C:\\Users\\RNALAM\\OneDrive - Capgemini\\Desktop\\homepage.png"));
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		String parentWindow = driver.getWindowHandle();
//		driver.switchTo().window(parentWindow);
//		driver.switchTo().frame("frm1");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Function<WebDriver, Boolean> fun = new Function<WebDriver, Boolean>() {
//			
//			
//			public Boolean apply(WebDriver t) {
//				
//				return t.findElement(By.id("")).isDisplayed();
//			}
//		};
//		
//		wait.until(fun);
//		
//		Actions action = new Actions(driver);
//		
//		action.clickAndHold(driver.findElement(By.id(""))).moveToElement(driver.findElement(By.id(""))).release(driver.findElement(By.id(""))).build().perform();
//		
//		action.dragAndDrop(driver.findElement(By.id("")), driver.findElement(By.id("")));
		
//		driver.findElement(By.id("txtReturnJourneyDate")).click();
//		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='20']")).click();
//        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
//        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
//        driver.navigate().back();
//        System.out.println(driver.getTitle());
//
//		//driver.findElement(By.xpath("//a[text()='Flights']")).click();
//		
//		Select select1 = new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
//		select1.selectByVisibleText("2");
//		
//		Select select2 = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
//		select2.selectByValue("Frankfurt");
//		
//		Select select3 = new Select(driver.findElement(By.xpath("//select[@name='fromMonth']")));
//		select3.selectByIndex(3);
//		
//		Select select4 = new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
//		select4.selectByValue("28");
//		
//		Select select5 = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
//		select5.selectByVisibleText("London");
//		
//		Select select6 = new Select(driver.findElement(By.xpath("//select[@name='toMonth']")));
//		select6.selectByValue("1");
//		
//		Select select7 = new Select(driver.findElement(By.xpath("//select[@name='toDay']")));
//		select7.selectByVisibleText("1");
//		
//		driver.findElement(By.xpath("(//input[@name='servClass'])[last()]")).click();
//		
//		Select select8 = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
//		select8.selectByVisibleText("Pangea Airlines");
//		
//		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
//		
//		//driver.close();
//		driver.quit();
//		Boolean b = driver.getPageSource().contains("Jul 6, 2017");
//		System.out.println(b);
//		String checkText = "Jul 6, 2017";
//		String ele = driver.findElement(By.xpath("//b[text()='Jul 6, 2017']")).getText();
//		
//		if(checkText.equals(ele)) {
//			System.out.println("True");
//		}
		
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("//a[text()='Hotels']"))).perform();

//		List<WebElement> list = driver.findElements(By.xpath("//b[contains(text(),'$')]"));
//		int maxPrice = 0,count=0;
//		for (WebElement lists : list) {
//			String sPrice = lists.getText().replace("$", "");
//			int price = Integer.parseInt(sPrice);
//			//maxPrice = Math.max(maxPrice, price);
//			if(price>maxPrice) {
//				maxPrice=price;
//			}
//		}
//		
//		System.out.println(maxPrice);

	}
}
