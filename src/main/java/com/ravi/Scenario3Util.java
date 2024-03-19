package com.ravi;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.driver.util.readExcel;
import com.google.common.io.Files;

public class Scenario3Util {

	static DriverUtils util;
	static readExcel readexcel;
	static WebDriver driver;
	static Actions actions;
	static Map<String, String> excelValues = new HashMap<>();

	@Test
	public static void test() throws Exception {
		readExcelValues();
		takeScreenShot();
	}

	@AfterTest
	public static void driverQuit() {
		driver.quit();
	}

	@BeforeTest
	public static void openApplication() {
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		util.openApp("https://demo.automationtesting.in/Index.html");
	}

	public static void readExcelValues() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\RNALAM\\Downloads\\MiniProject\\Age_Validation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet shett = workbook.getSheetAt(1);

		for (Row row : shett) {
			String element = row.getCell(0).getStringCellValue();
			Cell value = row.getCell(1);
			excelValues.put(element, getStringValue(value));
		}
		
		workbook.close();
	}

	public static String getStringValue(Cell cell) {
		if (cell == null) {
			return null;
		} else if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return null;
		}
	}

	public static void takeScreenShot() throws Exception {
		util.Click(excelValues.get("skipSignInButton"));
		util.Actions(excelValues.get("switchTo"));
		util.Click(excelValues.get("windowsPage"));
		util.Click(excelValues.get("openNewSepWindows"));
		windowHandle();
	}

	public static void windowHandle() throws Exception {
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

	public static void scrollWindow() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000);", "");
	}

	public static void takingScreenShot() throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("C:\\Users\\RNALAM\\OneDrive - Capgemini\\Desktop\\screenshot.png"));
	}

}
