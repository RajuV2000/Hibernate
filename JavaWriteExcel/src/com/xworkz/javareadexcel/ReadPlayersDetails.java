package com.xworkz.javareadexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadPlayersDetails {

	public static void main(String[] args) {

		try {
			FileInputStream file = new FileInputStream(new File("C:\\\\Users\\\\Raju\\\\OneDrive\\\\Documents\\\\player_det.xlsx"));

			XSSFWorkbook workbook;

			workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowItr = sheet.iterator();
			
			while(rowItr.hasNext())
			{
				Row row = rowItr.next();
				
				Iterator<Cell> cellItr = row.cellIterator();
				
				while(cellItr.hasNext())
				{
					Cell cell = cellItr.next();
					
					switch(cell.getCellType())
					{
					case NUMERIC:
						System.out.println(cell.getNumericCellValue() + "\t");
						break;
					case STRING:
						System.out.println(cell.getStringCellValue() + "\t");
						break;
					}
				}
				System.out.println(System.lineSeparator());
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
