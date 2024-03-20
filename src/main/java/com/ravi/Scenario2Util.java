package com.ravi;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario2Util {

	static WebDriver driver;
	static Map<String, String> excelValues = new HashMap<>();
	static DriverUtils util;

	@Test
	public static void test() throws Exception {
		readExcelValues();
		enterTextInTextbox();
		dateSlecting();
	}

	@AfterTest
	public static void driverQuit() {
		util.quitWIndow();
	}

	@BeforeTest
	public static void openApp() {
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		util.openApp("https://demo.automationtesting.in/Index.html");
	}

	public static void enterTextInTextbox() {
		util.Click(excelValues.get("skipSignInButton"));
		util.Actions(excelValues.get("switchTo"));
		util.Click(excelValues.get("framesPage"));
		util.Click(excelValues.get("buttonForMultiFrames"));
		util.SwitchToFrame(driver.findElement(By.xpath(excelValues.get("ParentFrame"))));
		util.SwitchToFrame(driver.findElement(By.xpath(excelValues.get("ChildFrame"))));
		util.Sendkeys(excelValues.get("textBox"), "Ravi");
		driver.switchTo().defaultContent();
	}

	public static void dateSlecting() {
		util.Actions(excelValues.get("widgets"));
		util.Click(excelValues.get("datePicker"));
		util.Click(excelValues.get("datePicker1"));
		util.Click(excelValues.get("selectDate1"));
		util.Click(excelValues.get("datePicker2"));
		util.Select(excelValues.get("changeMonth"), excelValues.get("selectMonth"));
		util.Select(excelValues.get("changeYear"), "2024");
		util.Click(excelValues.get("selectDate2"));
	}

	public static void readExcelValues() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\RNALAM\\Downloads\\MiniProject\\Age_Validation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet shett = workbook.getSheetAt(0);

		for (Row row : shett) {
			String element = row.getCell(0).getStringCellValue();
			Cell value = row.getCell(1);
			excelValues.put(element, getStringValue(value));
		}

		workbook.close();
	}

	private static String getStringValue(Cell cell) {

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
