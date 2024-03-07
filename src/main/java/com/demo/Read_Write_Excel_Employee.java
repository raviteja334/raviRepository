package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Write_Excel_Employee {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fileInput = new FileInputStream("C:/Users/RNALAM/Downloads/Age_Validation.xlsx");

		// use XSSF for .xlsx file and HSSF for .xls file
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);

		XSSFSheet sheet = workbook.getSheet("Employee");
		Scanner sc = new Scanner(System.in);
		Double empId = sc.nextDouble();
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(1).getLastCellNum();
		System.out.println("rows : " + rowCount + "   coloumns: " + colCount);

		for (int i = 1; i <= rowCount; i++) {

			String cell = sheet.getRow(i).getCell(0).toString();
			Double dCell = Double.parseDouble(cell);
			// System.out.println(cell);
			if (empId.equals(dCell)) {
				for (int j = 0; j < colCount; j++) {
					System.out.print(sheet.getRow(i).getCell(j) + " ");
				}
			}
		}
		sc.close();
		workbook.close();
	}

}
