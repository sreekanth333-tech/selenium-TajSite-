package com.sreekanth.selenium_TajSite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityClass {
	
	private   Workbook workbook;
	
	private org.apache.poi.ss.usermodel.Sheet sheet;
	private final DataFormatter df= new DataFormatter();
	
	
	public  UtilityClass(String filepath, String sheetName)
	{
	
	
		try {
			
			  FileInputStream fis= new FileInputStream(filepath);
			  
			  workbook= new XSSFWorkbook(fis);
			  
			  sheet= workbook.getSheet(sheetName);
			  
			  fis.close();
			
		}
		
		catch(IOException e)
		{
			
			
			throw new RuntimeException(" unable to open path  " + filepath);
		}
			
	}	
		
		public int getRowCount()
		{
			
			
			 return sheet.getLastRowNum();
		}
		
	
		public int getColumnCount()
		{
			
			
			Row headerRow= sheet.getRow(0);
			
			if(headerRow==null)
			{
				return 0;
			}
			return headerRow.getLastCellNum();
			
		}
	
		
		// Get cell data using row number and column number
		
		public String getCellData(int rowNumber, int ColumnNumber)
		{
			
		Row	row= sheet.getRow(rowNumber);
		if (row==null)
		{
			return "";
		}
			
		
		Cell cell=row.getCell(ColumnNumber);
		
		if (cell==null)
		{
			return "";
		}
		
		return df.formatCellValue(cell);
			
		
		}
		
		
		
		public List<String> getcolumnData(int colomnNum)
		{
			
			
			List<String> data = new ArrayList<String>();
			
			int totlaRows= sheet.getLastRowNum();
			
			for(int i=1; i<=totlaRows; i++)
			{
			
			String value= getCellData(i,colomnNum);
			
			
			if(!value.trim().isEmpty())
			{
				
				data.add(value.trim());
				
				
				
			}
			
			
			
			}
			return data;
		}
		
		
		
		
		
		
		
		
		
		
		// Close workbook
	    public void closeWorkbook() {

	        try {

	            if (workbook != null) {

	                workbook.close();
	            }

	        } catch (IOException e) {

	            throw new RuntimeException(
	                    "Unable to close Excel workbook",
	                    e);
	        }
		
		
		
		
		
		
		
		
		
		
		
		
		
	    }		

}
