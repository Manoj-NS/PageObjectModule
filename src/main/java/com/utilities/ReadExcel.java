package com.utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

public static String[][] getData (String excelFileName) throws IOException {
		
		XSSFWorkbook book = new XSSFWorkbook("./data/"+excelFileName+".xlsx");
		//XSSFWorkbook book = new XSSFWorkbook("D:\\Selenium\\Doc\\Apache Files\\Validation.xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String [rowCount][colCount];
		DataFormatter dataFormatter = new DataFormatter();

		
		for (int i=1; i<=rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			
			for(int j=0; j<colCount; j++) {
				XSSFCell eachCell=eachRow.getCell(j);
				
			//	data[i-1][j] = eachCell.getStringCellValue();
				
				if (eachCell.getCellType() == CellType.NUMERIC) {
                    // If the cell contains a numeric value
                  //  data[i - 1][j] = String.valueOf(eachCell.getNumericCellValue());
                    data[i - 1][j] = dataFormatter.formatCellValue(eachCell);

                } else {
                    // If the cell contains a string value
                    data[i - 1][j] = eachCell.getStringCellValue();
                }
				
				System.out.print(data[i-1][j]);
				System.out.print(" || ");
			}
			System.out.println();
		}
		
		book.close();
		return data;
	}

}
