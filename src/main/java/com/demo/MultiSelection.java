package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		WebElement webElement = driver.findElement(By.id("ide"));
		
		Select select = new Select(webElement);
		
		List<WebElement> list =  select.getOptions();
		for (WebElement lists : list) {
			System.out.println(lists.getText());
		}
		select.selectByValue("ij");//Intellij IDEA
		Thread.sleep(5000);
		select.selectByIndex(0);
		Thread.sleep(3000);
		select.selectByVisibleText("NetBeans");
		
		select.deselectByVisibleText("IntelliJ IDEA");
		
		List<WebElement> selected = select.getAllSelectedOptions();
		for (WebElement webElement2 : selected) {
			System.out.println("selected visible text "+webElement2.getText());
		}
		Thread.sleep(5000);
		select.deselectAll();
		
		
		
	}

}
