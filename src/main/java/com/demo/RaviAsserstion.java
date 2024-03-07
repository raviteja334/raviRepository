package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RaviAsserstion {

	@Test
	public void TestGoogle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("facebook", Keys.ENTER);
		String exepetedTitle = "facebook - Google Search";
		String actualTitle = driver.getTitle();
		//Assert.assertEquals(actualTitle,exepetedTitle);
		Assert.assertEquals(actualTitle,exepetedTitle, "Title is mismatched" );
		driver.quit();
	}
	
	@Test
	public void TestFacebook() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("email");
		System.out.println(driver.getTitle());
	}
	

	@Test
	public void Testtt() {
		Assert.assertTrue(true);
	}
	
	//soft assertion
	@Test
	public void testHardAssertion() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("email", Keys.ENTER);
		
		//Title assertion
		String exepetedTitle = "Log in to Facebook";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,exepetedTitle, "Title is mismatched" );
		
		//url assertion
		String exepetedUrl = "https://www.facebook.com/nkjbh";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,exepetedUrl, "URL is mismatched" );
		
		//Text assertion
		String exepetedText = "";
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		Assert.assertEquals(actualText,exepetedText, "username Text is mismatched" );
				
		//errorMsg assertion
		String exepetedErrorMsg = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String actualErroMsg = driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		Assert.assertEquals(actualErroMsg,exepetedErrorMsg, "error message is mismatched");
						
	}
	@Test
	public void testSoftAssertion() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("fsergthr", Keys.ENTER);
		
		SoftAssert softAssert = new SoftAssert();
		
		//Title assertion
		String exepetedTitle = "Log in to Facebook";
		String actualTitle = driver.getTitle();
		softAssert.assertEquals(actualTitle,exepetedTitle, "Title is mismatched" );
		
		//url assertion
		String exepetedUrl = "https://www.facebook.com/nkjbh";
		String actualUrl = driver.getCurrentUrl();
		softAssert.assertNotEquals(actualUrl,exepetedUrl, "URL is mismatched" );
		//softAssert.assertEquals(actualUrl,exepetedUrl, "URL is mismatched" );
		
		//Text assertion
		String exepetedText = "";
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		softAssert.assertEquals(actualText,exepetedText, "username Text is mismatched" );
				
		//errorMsg assertion
		String exepetedErrorMsg = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String actualErroMsg = driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		softAssert.assertEquals(actualErroMsg,exepetedErrorMsg, "error message is mismatched");
				
		softAssert.assertAll();
		driver.quit();
	}
}
