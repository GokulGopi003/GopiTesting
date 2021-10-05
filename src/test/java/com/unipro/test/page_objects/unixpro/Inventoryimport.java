package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;

import cucumber.api.java.en.Then;

public class Inventoryimport extends PageObject{
	@Then("I Browse the Excelsheetdata")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		
		String filepath="/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample mrp.xlsx";
		WebElement choosefile=webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnBrowse\"]"));
		GenericWrappers.sleepInSeconds(1);
		choosefile.sendKeys(filepath);
		//webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnBrowse\"]")).sendKeys("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample mrp.xlsx");
		//String expectedfile= webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnBrowse\"]")).getAttribute("value");
		//GenericWrappers.sleepInSeconds(1);
		//if(expectedfile.equalsIgnoreCase("sample mrp.xlsx"))
		//{
			//System.out.println("Browse Sucessfull");
		//}
	}

	

}
