package com.automationpractice.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class excelTest {
	public static void main (String [] args) throws IOException{
		DataFormatter dataFormatter = new DataFormatter();
		
		//Path of the excel file
		FileInputStream fs = new FileInputStream("exceltest.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(1);
		
//		System.out.println(sheet.getSheetName());
		
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		
//		Row row1 = sheet.getRow(1);
//		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		
//		Row row2 = sheet.getRow(1);
//		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		
//		Row row3 = sheet.getRow(1);
//		Cell cell3 = row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
		//String cellval = cell.getStringCellValue();
		//System.out.println(cellval);
		System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
		for (Row row: sheet) {
			for(Cell cell: row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.print(cellValue + "\t");
			}
			System.out.println();
		}
	}	
}
