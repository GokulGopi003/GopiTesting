package com.unipro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.Globals;

public class ExcelSheetStatus {
	public void Excel(String Sheetname) throws IOException {

	File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample inventory all.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook xs = new XSSFWorkbook(fis);
	XSSFSheet sh = xs.getSheet(Sheetname);
	int row= sh.getLastRowNum()+1;
	sh.createRow(row).createCell(7).setCellValue("failed");
	FileOutputStream fos = new FileOutputStream(file);
	xs.write(fos);
	}
}
