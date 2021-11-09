package com.unipro;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWrite {
	
@Test
	public void Write(){
	 
	File file=new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample1.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sh=wb.createSheet();
	sh.createRow(1).createCell(0).setCellValue("gopi");
	try
	{
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		
	}
		catch(Exception e){
		
			e.printStackTrace();
		}
	}
}
