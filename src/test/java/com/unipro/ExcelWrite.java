package com.unipro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWrite {
	
@Test
	public void Write(){
	 
	File file=new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample1.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sh1=wb.createSheet();
	sh1.createRow(1).createCell(0).setCellValue("gopi");
	try
	{
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		
	}
		catch(Exception e){
		
			e.printStackTrace();
		}
	}
	public void Excelcreate(String sheet,String cellValue1,String cellValue,int Row,int Cell,int Row1,int Cell1) throws IOException {
		File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/Result.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		
		XSSFSheet sh = xs.getSheet(sheet);
		sh.createRow(Row).createCell(Cell).setCellValue(cellValue1);
		sh.getRow(Row1).createCell(Cell1).setCellValue(cellValue);
		FileOutputStream fos = new FileOutputStream(file);
		xs.write(fos);
		
	}
	


	public void ExcelFourData(String sheet,String cellValue1,String cellValue,String cellValue2,String cellValue3,int Row,int Cell,int Row1,int Cell1,int Row2,int Cell2,int Row3,int Cell3) throws IOException {
		File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/Result.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		
		XSSFSheet sh = xs.getSheet(sheet);
		sh.createRow(Row).createCell(Cell).setCellValue(cellValue1);
		sh.getRow(Row1).createCell(Cell1).setCellValue(cellValue);
		sh.getRow(Row2).createCell(Cell2).setCellValue(cellValue2);
		sh.getRow(Row3).createCell(Cell3).setCellValue(cellValue3);
		FileOutputStream fos = new FileOutputStream(file);
		xs.write(fos);
		
	}
	public void ExcelFiveData(String sheet,String cellValue1,String cellValue,String cellValue2,String cellValue3,String cellValue4,int Row,int Cell,int Row1,int Cell1,int Row2,int Cell2,int Row3,int Cell3,int Row4,int Cell4) throws IOException {
		File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/Result.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		
		XSSFSheet sh = xs.getSheet(sheet);
		sh.createRow(Row).createCell(Cell).setCellValue(cellValue1);
		sh.getRow(Row1).createCell(Cell1).setCellValue(cellValue);
		sh.getRow(Row2).createCell(Cell2).setCellValue(cellValue2);
		sh.getRow(Row3).createCell(Cell3).setCellValue(cellValue3);
		sh.getRow(Row4).createCell(Cell4).setCellValue(cellValue4);
		FileOutputStream fos = new FileOutputStream(file);
		xs.write(fos);
		
	}
	public void ExcelDouble(String sheet,String cellValue1,String cellValue,double netSellingPrice,String cellValue3,int Row,int Cell,int Row1,int Cell1,int Row2,int Cell2,int Row3,int Cell3) throws IOException {
		File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/Result.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		
		XSSFSheet sh = xs.getSheet(sheet);
		sh.createRow(Row).createCell(Cell).setCellValue(cellValue1);
		sh.getRow(Row1).createCell(Cell1).setCellValue(cellValue);
		sh.getRow(Row2).createCell(Cell2).setCellValue(netSellingPrice);
		sh.getRow(Row3).createCell(Cell3).setCellValue(cellValue3);
		FileOutputStream fos = new FileOutputStream(file);
		xs.write(fos);
		
	}
	
		
	
	


}
