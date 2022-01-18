package com.unipro.test.page_objects.unixpro;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;

import cucumber.api.java.en.Then;

public class Inventoryimport extends PageObject{
	@Then("I Browse the Excelsheetdata")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		
		//String filepath="/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample1.xlsx";
		WebElement choosefile=webDriver.findElement(By.id("ContentPlaceHolder1_txtExcelFilePath"));
		//GenericWrappers.sleepInSeconds(1);
		choosefile.sendKeys("/Users/macpc/Documents/GitHub/GopiTesting/testdata/Unipro_Master_Excel_web.xlsx");
		//webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnBrowse\"]")).sendKeys("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample mrp.xlsx");
		//String expectedfile= webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnBrowse\"]")).getAttribute("value");
		//GenericWrappers.sleepInSeconds(1);
		//if(expectedfile.equalsIgnoreCase("sample mrp.xlsx"))
		//{
			//System.out.println("Browse Sucessfull");
		//}
		
		
	
	}

	

}
