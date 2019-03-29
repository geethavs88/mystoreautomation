package com.uiFrameworkNew.companyName.projectName.helperClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExampleExcelData {


	
		@Test
		public void getExcelData() 
		{try
		{
			FileInputStream file = new FileInputStream("D:\\Eclipse\\DataDemo.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int sheets = workbook.getNumberOfSheets();
			for(int i=0;i<sheets;i++)
			{
				if(workbook.getSheetName(i).equalsIgnoreCase("Demo1"))
				{
					XSSFSheet sheet = workbook.getSheetAt(i);
					
					Iterator<Row> rows = sheet.iterator();
					Row firstRow = rows.next();
					Iterator<Cell> cells = firstRow.cellIterator();
					int k=0;
					int column =0;
					while(cells.hasNext())
					{
						if(cells.next().getStringCellValue().equalsIgnoreCase("Testcase"))
						{
							column=k;
						}
						k++;
						
					}
					
					System.out.println(column);
					
					while(rows.hasNext())
					{
						Row r=rows.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase"))
						{
							Iterator<Cell> cellDatas =r.cellIterator();
							while(cellDatas.hasNext())
							{
								System.out.println(cellDatas.next().getStringCellValue());
							}
						}
					}
					
					
				}
			}
			
		}
		catch(Exception e)
		{
			
		}
			
		}
		
		
	}



