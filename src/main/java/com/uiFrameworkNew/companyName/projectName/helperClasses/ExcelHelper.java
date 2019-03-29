package com.uiFrameworkNew.companyName.projectName.helperClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	Logger log = LoggerHelper.getLogger(ExcelHelper.class);
	
	public Object[][] getExcelData(String excelLocation,String sheetName)
	{
		try
		{
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int totalRow = sheet.getLastRowNum();
			int totalColumn = sheet.getRow(0).getLastCellNum();
			
			dataSets = new String[totalRow+1][totalColumn+1];
			Iterator<Row> rowIterator = sheet.iterator();
			int i=0;
			while(rowIterator.hasNext())
			{
				i++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j=0;
				
				while(cellIterator.hasNext())
				{
					j++;
					Cell cell = cellIterator.next();
					switch(cell.getCellTypeEnum())
					{
					case STRING:
						dataSets[i-1][j-1]= cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i-1][j-1] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i-1][j-1] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataSets[i-1][j-1] = cell.getCellFormula();
						default:
							System.out.println("No matching enum type found");
							break;
						
					}
					
				}
			}
			return dataSets;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void updateResult(String excelLocation, String sheetName, String testcaseName,String testStatus)
	{
		try
		{
			FileInputStream file = new FileInputStream(new File(excelLocation));
			XSSFWorkbook workbook  = new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			
			int totalRow = sheet.getLastRowNum() +1;
			Iterator<Row> rows = sheet.iterator();
			for(int i=1;i<totalRow;i++)
			{
				XSSFRow row = sheet.getRow(i);
				if(row.getCell(0).getStringCellValue().equals(testcaseName))
				{
					row.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("result updated..");
					
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					
				}
				
			}
			
		}
		catch(Exception e)
		{
			
		}
		
	}
	public static void main(String[] args)
	{
		ExcelHelper excelHelper  = new ExcelHelper();
		String excelLocation = ResourceHelper.getResoucePath("src/main/resources/configfile/testData.xlsx");
		//Object[][] data = excelHelper.getExcelData(excelLocation, "Login");
		excelHelper.updateResult(excelLocation,"TestScripts","Login","Pass");
		excelHelper.updateResult(excelLocation,"TestScripts","Registration","Fail");
		excelHelper.updateResult(excelLocation,"TestScripts","AddToCart","Pass");
		
		
	}

}
