package com.hellofresh.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author swajhamb
 * This class has methods to read from excel file
 */
public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {

		try {
			File src = new File("./TestData/TestDataSheet.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("Unable to read excel file : " + e.getMessage());
		}
	}

	
	public String getData(String sheetName, int rowNo, int colNo) {
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(wb.getSheet(sheetName).getRow(rowNo).getCell(colNo));
	}
}
