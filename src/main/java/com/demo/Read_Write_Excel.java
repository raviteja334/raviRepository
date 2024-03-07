package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Write_Excel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fileInput = new FileInputStream("C:/Users/RNALAM/Downloads/Age_Validation.xlsx");
		
		//use XSSF for .xlsx file and HSSF for .xls file
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		
		XSSFSheet sheet = workbook.getSheet("Age");
		
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(1).getLastCellNum();
		System.out.println("rows : "+rowCount+"   coloumns: "+colCount);
		
		for(int i=1; i<=rowCount; i++) {
			XSSFCell cell = sheet.getRow(i).getCell(1);
			String cellText ="";
			
			if(cell.getCellType()==CellType.STRING) {
				cellText = cell.getStringCellValue();
			}else if(cell.getCellType()==CellType.NUMERIC) {
				cellText = String.valueOf(cell.getNumericCellValue());
			}else if(cell.getCellType()==CellType.BLANK) {
				cellText = "";
			}
			if(Double.parseDouble(cellText)>=18) {
				//sheet.getRow(i).getCell(2).setCellValue("Major");
				sheet.getRow(i).createCell(2).setCellValue("Major");
			}else {
				//sheet.getRow(i).getCell(2).setCellValue("Minor");
				sheet.getRow(i).createCell(2).setCellValue("Minor");
			}
		}
		
		fileInput.close();
		
		FileOutputStream fileOutput = new FileOutputStream("C:/Users/RNALAM/Downloads/Age_Validation.xlsx");
		
		workbook.write(fileOutput);
		
		fileOutput.close();
		
	}

}
