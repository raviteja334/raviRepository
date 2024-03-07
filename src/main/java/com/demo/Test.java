package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RNALAM\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		WebElement  ele = driver.findElement(By.id("chrome-cpu"));
		String text1 = ele.getText();
		System.out.println(text1);
		
		String newText = text1.replace("[^0-9]", "");
		
		System.out.println(newText);
		
		
//		driver.get("https://demo.automationtesting.in/Index.html");
//		
//		driver.findElement(By.id("btn2")).click();
//		
//		WebElement ele = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
//		ele.sendKeys("Ravi");
//		
//		
//		
//		
//		driver.findElement(By.xpath("(//input[@ng-model='radiovalue'])[1]")).click();
//		
//		WebElement ele1 =driver.findElement(By.id("checkbox1"));
//		ele1.click();
//		WebElement ele2 =driver.findElement(By.id("checkbox2"));
//		ele2.click();
//		
//		Select select = new Select(driver.findElement(By.id("yearbox")));
//		
//		//select.selectByValue("2000");
//		Thread.sleep(1000);
//		
//		Boolean isSelected1 = ele1.isSelected();
//		Boolean isSelected2 = ele2.isSelected();
//		
//		List<WebElement> list = select.getAllSelectedOptions();
//		
//		
//		System.out.println(isSelected1);
//		System.out.println(isSelected2);
//		
//		String fName  = "";
//		System.out.println(fName);
//			if(fName.equals("Ravi")) {
//				System.out.println("The first is displaying correctly "+fName);
//			}
//			
//			
//		
//		driver.quit();
	}

}
