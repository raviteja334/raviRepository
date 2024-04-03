package com.replicon;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class companyHolidays {

	static WebDriver driver;
	static Map<String, String> excelValues = new HashMap<>();
	static driverUtils util;

	@BeforeTest
	public static void openApp() {
		driver = new ChromeDriver();
		util = new driverUtils(driver);
		util.openApp("https://talent.capgemini.com/in");
	}

	@Test
	public static void printCompanyHolidays() throws Exception {
		readExcelValues();
		String mainWindow = driver.getWindowHandle();
		util.Click(excelValues.get("Replicon"));
		Set<String> windows = driver.getWindowHandles();
		
		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
		
		util.Click(excelValues.get("AllTimeOffBookings"));
		util.Click(excelValues.get("CompanyHolidays"));
		List<WebElement> holidayNames = driver.findElements(By.xpath(excelValues.get("HolidayName")));
		List<WebElement> holidayDates = driver.findElements(By.xpath(excelValues.get("HolidayDate")));
		Map<String, String> map = new LinkedHashMap<>();

		for (int i = 0; i < holidayNames.size() - 1; i++) {
			String holidayName = holidayNames.get(i + 1).getText();
			String holidayDate = holidayDates.get(i).getText();
			map.put(holidayName, holidayDate);
		}

		for (Map.Entry<String, String> entry : map.entrySet())
			System.out.println(entry.getKey() + " - " + entry.getValue());
	}
	
	@AfterTest
	public static void quitWindow() {
		util.quitWIndow();
	}
	
	public static void readExcelValues() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\RNALAM\\Downloads\\MiniProject\\Age_Validation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet shett = workbook.getSheetAt(3);

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
}
