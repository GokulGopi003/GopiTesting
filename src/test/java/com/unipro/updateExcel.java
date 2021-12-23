package com.unipro;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class updateExcel {
	
	XSSFWorkbook xs=null;
	XSSFSheet sh=null;

	
	@Test
	public void f()
	{
		File file=new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample1.xlsx");
		try {
			
			FileInputStream fis=new FileInputStream(file);
			xs=new XSSFWorkbook(fis);
			sh=xs.getSheetAt(0);
			sh.getRow(0).createCell(3).setCellValue(100);
			FileOutputStream fos=new FileOutputStream(file);
			xs.write(fos);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
