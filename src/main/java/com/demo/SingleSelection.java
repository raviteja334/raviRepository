package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleSelection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		
		
		WebElement webElement = driver.findElement(By.id("course"));
		
		Select select = new Select(webElement);
		
		List<WebElement> list =  select.getOptions();
		for (WebElement lists : list) {
			System.out.println(lists.getText());
		}
		
		select.selectByVisibleText("Java");
		Thread.sleep(5000);
		select.selectByValue("net");
		Thread.sleep(5000);
		select.selectByIndex(4);
		
		String selected = select.getFirstSelectedOption().getText();
		System.out.println("selected visible text"+selected);
		
		
		//select.deselectAll();
	}

}
