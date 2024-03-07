package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		driver.get("https://www.ebay.com/");
		
		WebElement element =driver.findElement(By.xpath("//input[contains(@id,'gh')]"));
		WebElement element1 =driver.findElement(By.xpath("//input[@id='gh-btn']"));
		element.sendKeys("shirts for men");
		String ariaRole = element1.getAriaRole();// it will returns value of the role attribute
		String accName = element1.getAccessibleName();// it will return accessible name of the element
		String attribute = element.getAttribute(ariaRole);// it will return the attribute of the element
		System.out.println(element.getSize());// it will return size of the element
		System.out.println(element.isDisplayed());// it will return boolean value for the object is displaying or not
		System.out.println(element.isEnabled());// it will return boolean value for the object is enable or not
		System.out.println(element.isSelected());// it will return boolean value for the object is selected or not
		System.out.println(element.getTagName());
		System.out.println(element.getText());
		System.out.println(element.hashCode());
		System.out.println(accName);
		System.out.println(ariaRole);
		System.out.println(attribute);
		//element.clear();
		element1.click();
		
	}

}
