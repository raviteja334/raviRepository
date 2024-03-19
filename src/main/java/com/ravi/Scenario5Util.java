package com.ravi;

import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Scenario5Util {

	static WebDriver driver;
	static Map<String, String> map = new HashMap<>();
	static DriverUtils util;
	
	@Test
	public void test() throws Exception {
		readJsonValues();
		searchAndSorting();
		firstProductPrice();
	}
	
	private void readJsonValues() throws Exception {
		FileReader file = new FileReader("C:\\Users\\RNALAM\\Downloads\\MiniProject\\data.json");
		ObjectMapper mapper = new ObjectMapper();
		map = mapper.readValue(file, Map.class);
	}

	public static void searchAndSorting() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		util.Sendkeys(map.get("searchBox"), map.get("item"));
		util.Click(map.get("searchButton"));
		util.Click(map.get("filterMen"));
		util.Click(map.get("sortBox"));
		util.Click(map.get("low-high"));
	}
	
	public static void firstProductPrice(){
		String price = util.GetText(map.get("productPrice"));
		int amount = Integer.parseInt(price.replace("[^0-9]", ""));
		
		if(amount<10000) {
			System.out.println("Price is less than 10000");
		}else {
			System.out.println("Price is more than 10000");
		}
	}
	
	@BeforeTest
	public void openApp() {
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		util.openApp("https://www.myntra.com/");
	}
	
	@AfterTest
	public void quitDriver() {
		util.quitWIndow();
	}
}
