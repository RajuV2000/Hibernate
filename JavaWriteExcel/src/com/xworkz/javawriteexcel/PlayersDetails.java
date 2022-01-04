package com.xworkz.javawriteexcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PlayersDetails {

	public static void main(String[] args) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Players details");
		
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		
		data.put("1", new Object[] {"id", "Sports", "Player", "Country", "Age"});
		data.put("2", new Object[] {1, "Cricket", "Dhoni", "Ind", 40});
		data.put("3", new Object[] {2, "Football", "Ronaldo", "Portugal", 36});
		data.put("4", new Object[] {3, "Hockey", "Raghunath", "Ind", 33});
		data.put("5", new Object[] {4, "Badminton", "Saina Nehwal", "Ind", 31});
		data.put("6", new Object[] {5, "Football", "Chettri", "Ind", 36});
		data.put("7", new Object[] {6, "Kabaddi", "Anup Kumar", "Ind", 38});
		data.put("8", new Object[] {7, "Chess", "V Anand", "Ind", 52});
		data.put("9", new Object[] {8, "Basketball", "Kobe Bryant", "USA", 41});

		Set<String> keyset = data.keySet();
		
		int rownum = 0;
		
		for(String key : keyset)
		{
			Row row = sheet.createRow(rownum++);
			
			Object[] objArr = data.get(key);
			
			int cellNum = 0;
			for(Object obj : objArr)
			{
				Cell cell = row.createCell(cellNum++);
				
				if(obj instanceof String)
				{
					cell.setCellValue((String)obj);
				}
				else if(obj instanceof Integer)
				{
					cell.setCellValue((Integer)obj);
				}
			}
			
			try {
				FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Raju\\OneDrive\\Documents\\player_det.xlsx"));
				workbook.write(out);
				out.close();
				System.out.println("players_det.xlsx written successfully...");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
