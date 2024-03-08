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

import com.driver.util.readExcel;
import com.google.common.io.Files;

public class Scenario3Util {

	static DriverUtils util;
	static readExcel readexcel;
	static WebDriver driver;
	static Actions actions;
	static Map<String, String> excelValues = new HashMap<>();

//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//
//		readExcelValues();
//		openApplication();
//		takeScreenShot();
//		driverQuit();
//	}

	public static void driverQuit() {
		driver.quit();
	}

	public static void openApplication() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/RNALAM/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void readExcelValues() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\RNALAM\\Downloads\\Age_Validation.xlsx");
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
		// WebElement
		// text=driver.findElement(By.xpath(excelValues.get("elementForSS")));
		// jse.executeScript("arguments[0].scrollIntoView()", text);
	}

	public static void takingScreenShot() throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("C:\\Users\\RNALAM\\OneDrive - Capgemini\\Desktop\\screenshot.png"));
	}

}
