package com.HybridDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadTestDataFromExcel {

	@DataProvider
	public static String[][] readExcel() throws IOException {

		String filePath = System.getProperty("user.dir") + "/src/test/resources/";
		String fileName = "testData_Amazon.xls";
		String sheetName = "Sheet1";
		// Create an object of File class to open xlsx file
		File fileLocation = new File(filePath + "/" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(fileLocation);
		Workbook workbook = null;

		// Find the file extension by splitting file name in substring and
		// getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {
			// If it is xlsx file then create object of XSSFWorkbook class
			workbook = new XSSFWorkbook(inputStream);
		}

		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of HSSFWorkbook class
			workbook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet sheet = workbook.getSheet(sheetName);

		// Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int numCols = sheet.getRow(0).getLastCellNum();

		// Create a loop over all the rows of excel file to read it
		String dataTable[][] = new String[rowCount][numCols];
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Print Excel data in console
				dataTable[i - 1][j] = row.getCell(j).getStringCellValue();
			}
		}
		return dataTable;
	}
}
