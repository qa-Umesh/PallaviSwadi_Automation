package com.PS.Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	
	
	
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;


	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo)
	{
		try {
			inputStream = new FileInputStream(fileName);
			workBook= new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			cell= workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

			workBook.close();
			return cell.getStringCellValue();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
	}

	public static int getRowCount ( String fileName, String sheetName)
	{
		try {
			inputStream = new FileInputStream(fileName);
			// create XSSFWorkBook class object for excel file manipulation

			workBook  = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);

			// get total no of rows
			int ttRows = excelSheet.getLastRowNum() +1;

			workBook.close();
			return ttRows;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}

	public static int getCellCount (String fileName, String sheetName)
	{
		try {
			FileInputStream inputStream = new  FileInputStream(fileName);
			//  create xsssfWorkBook Class object for excel file manipulation
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet excelSheet = workBook.getSheet(sheetName);

			// get total no. of columns
			int ttlCells = excelSheet.getRow(0).getLastCellNum();

			workBook.close();
			return ttlCells;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}


	}


	
}
