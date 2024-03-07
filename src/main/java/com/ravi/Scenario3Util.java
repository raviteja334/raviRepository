package com.ravi;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.driver.util.DriverUtils;
import com.driver.util.readExcel;
import com.google.common.io.Files;

public class Scenario3Util {

	static DriverUtils util;
	static readExcel readexcel;
	static WebDriver driver;
	static Actions actions;
	static Map<String, String> excelValues = new HashMap<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		readExcel.readExcelValues(excelValues);
		System.out.println(excelValues);
		openApplication();
		takeScreenShot();
		driver.quit();
	}

	private static void openApplication() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void takeScreenShot() throws Exception {
		util.Click(excelValues.get("skipSignInButton"));
		util.Actions(excelValues.get("switchTo"));
		util.Click(excelValues.get("windowsPage"));
		util.Click(excelValues.get("openNewSepWindows"));
		windowHandle();
	}

	private static void windowHandle() throws Exception {
		String parentWindow = driver.getWindowHandle();
		util.Click(excelValues.get("newWindowButton"));
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}
		}
		scrollWindow();
		Thread.sleep(1000);
		takingScreenShot();
	}

	private static void scrollWindow() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		// WebElement text=driver.findElement(By.xpath(excelValues.get("elementForSS")));
		// jse.executeScript("arguments[0].scrollIntoView()", text);
	}

	private static void takingScreenShot() throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("C:\\Users\\RNALAM\\OneDrive - Capgemini\\Desktop\\screenshot.png"));
	}

}
