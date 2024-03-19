package com.ravi;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario4 {

	static WebDriver driver;
	static Map<String, String> excelValues = new HashMap<>();
	static DriverUtils util;
	
	@Test
	public void test() throws Exception {
		readExcelValues();
		CompareBothValues();
	}
	
	@AfterTest
	public void quitWindow() {
		util.quitWIndow();
	}
	
	@BeforeTest
	public void openApp() {
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		util.openApp("https://practice.expandtesting.com/dynamic-table");
	}
	
	public static void CompareBothValues() {
		String text1 = util.GetText(excelValues.get("text1"));
		String num = text1.replace("Chrome CPU: ", "").trim();
		String text2 = util.GetText(excelValues.get("text2"));
		Assert.assertEquals(num, text2);
	}
	
	public static void readExcelValues() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\RNALAM\\Downloads\\MiniProject\\Age_Validation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet shett = workbook.getSheetAt(2);

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
