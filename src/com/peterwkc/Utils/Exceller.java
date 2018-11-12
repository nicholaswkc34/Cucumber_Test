package com.peterwkc.Utils;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.logging.Level;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.peterwkc.Manager.LogManager;


public class Exceller {

	public Exceller() {
	}
	
	@SuppressWarnings("deprecation")
	public static Object[][] getExcelData(String filePath, String sheetName) {
		
		try {
			FileInputStream dataFile = new FileInputStream(filePath);
			XSSFWorkbook wb = new XSSFWorkbook(dataFile);
			XSSFSheet sheet = wb.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum(), rowLoop = 0, columnLoop = 0;
			String[][] arrayStr = new String[totalRow][5];
			
			Iterator<Row> rowIte = sheet.iterator();
			while (rowIte.hasNext()) {
				Row aRow = rowIte.next();	
				Iterator<Cell> cellIterator = aRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING: 
							arrayStr[rowLoop][columnLoop] = cell.getStringCellValue();
					}
					
					columnLoop++;
				}
				
				rowLoop++;
				
			}
			
			return arrayStr;
			
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
		
		return null;
		
	}

}
