package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class StockAgingReport extends PageObject {
	StockAgingReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public StockAgingReport(StockAgingReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the StockAgingReport sheet data to map")
	public void i_load_the_StockAgingReport_sheet_data_to_map() {
		Globals.Inventory.StockAgingReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME134);
	}

	@Then("I load the rowise StockAgingReport data for {string} rowname")
	public void i_load_the_rowise_StockAgingReport_data_for_rowname(String row_name) {
		Globals.Inventory.StockAgingReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.StockAgingReportSheetData, row_name);

		System.out.println(Globals.Inventory.StockAgingReportrowwiseData);
	}

	@Then("I update value to the StockAgingReport page global Variables")
	public void i_update_value_to_the_StockAgingReport_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.StockAgingReportrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.StockAgingReportrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.StockAgingReportrowwiseData.get("Category");
		Globals.Inventory.Class = Globals.Inventory.StockAgingReportrowwiseData.get("Class");
		Globals.Inventory.Brand = Globals.Inventory.StockAgingReportrowwiseData.get("Brand");
		Globals.Inventory.ItemCode = Globals.Inventory.StockAgingReportrowwiseData.get("ItemCode");
		Globals.Inventory.Style = Globals.Inventory.StockAgingReportrowwiseData.get("Style");
		Globals.Inventory.Location = Globals.Inventory.StockAgingReportrowwiseData.get("Location");		
		Globals.Inventory.StockType = Globals.Inventory.StockAgingReportrowwiseData.get("GroupBy");
		Globals.Inventory.Cloth = Globals.Inventory.StockAgingReportrowwiseData.get("Cloth");
		Globals.Inventory.Color = Globals.Inventory.StockAgingReportrowwiseData.get("Color");
		Globals.Inventory.Design = Globals.Inventory.StockAgingReportrowwiseData.get("Design");
		Globals.Inventory.Fit = Globals.Inventory.StockAgingReportrowwiseData.get("Fit");
		Globals.Inventory.Neck = Globals.Inventory.StockAgingReportrowwiseData.get("Neck");
		Globals.Inventory.Size = Globals.Inventory.StockAgingReportrowwiseData.get("Size");
		Globals.Inventory.Sleeve = Globals.Inventory.StockAgingReportrowwiseData.get("Sleeve");
		Globals.Inventory.SubCategory = Globals.Inventory.StockAgingReportrowwiseData.get("Styles");
	    	}

	@Then("I fill new StockAgingReport data page using excel data")
	public void i_fill_new_StockAgingReport_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terpage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
			terpage.terminal_waitClearEnterText_css(icp.Class_String, Globals.Inventory.Class);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Class).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terpage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Style)) {
			terpage.terminal_waitClearEnterText_css(icp.Style_String, Globals.Inventory.Style);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Style, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Style).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
		
		
          if (GenericWrappers.isNotEmpty(Globals.Inventory.StockType)) {
        	  terpage.terminal_waitClearEnterText_css(icp.StockType_String, Globals.Inventory.StockType);
  			Inventorychange.clearAndTypeSlowly(Globals.Inventory.StockType, "input#txtSearch");
  			Inventorychange.return_td_invoke_element(Globals.Inventory.StockType).click();
			
          }
	
			
		
		  
	
		
		
if (GenericWrappers.isNotEmpty(Globals.Inventory.Cloth)) {
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_CLOTH_0_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			terpage.terminal_waitClearEnterText_css(icp.Cloth_String, Globals.Inventory.Cloth);
			
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_CLOTH_0_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
		}

if (GenericWrappers.isNotEmpty(Globals.Inventory.Color)) {
	
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_COLOR_0_chzn\"]")).click();
	GenericWrappers.sleepInSeconds(1);
	
	terpage.terminal_waitClearEnterText_css(icp.Color_String, Globals.Inventory.Color);
	
	GenericWrappers.sleepInSeconds(1);
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_COLOR_0_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
}
if (GenericWrappers.isNotEmpty(Globals.Inventory.Design)) {
	
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_DESIGN_0_chzn\"]")).click();
	GenericWrappers.sleepInSeconds(1);
	
terpage.terminal_waitClearEnterText_css(icp.Design_String, Globals.Inventory.Design);
	
	GenericWrappers.sleepInSeconds(1);
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_DESIGN_0_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
}
if (GenericWrappers.isNotEmpty(Globals.Inventory.Fit)) {
	
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_FIT_0_chzn\"]")).click();
	GenericWrappers.sleepInSeconds(1);
	
terpage.terminal_waitClearEnterText_css(icp.Fit_String, Globals.Inventory.Fit);
	
	GenericWrappers.sleepInSeconds(1);
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_FIT_0_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
}
if (GenericWrappers.isNotEmpty(Globals.Inventory.Neck)) {
	
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_NECK_0_chzn\"]")).click();
	GenericWrappers.sleepInSeconds(1);
	
terpage.terminal_waitClearEnterText_css(icp.Neck_String, Globals.Inventory.Neck);
	
	GenericWrappers.sleepInSeconds(1);
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_NECK_0_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
}
if (GenericWrappers.isNotEmpty(Globals.Inventory.Size)) {
	
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_SIZE_0_chzn\"]")).click();
	GenericWrappers.sleepInSeconds(1);
	
terpage.terminal_waitClearEnterText_css(icp.Size_String, Globals.Inventory.Size);
	
	GenericWrappers.sleepInSeconds(1);
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_SIZE_0_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
}

if (GenericWrappers.isNotEmpty(Globals.Inventory.Sleeve)) {
	
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_SLEEVE_0_chzn\"]")).click();
	GenericWrappers.sleepInSeconds(1);
	
terpage.terminal_waitClearEnterText_css(icp.Sleeve_String, Globals.Inventory.Sleeve);
	
	GenericWrappers.sleepInSeconds(1);
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_SLEEVE_0_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
}
if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
	
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_STYLE_0_chzn\"]")).click();
	GenericWrappers.sleepInSeconds(1);
	
terpage.terminal_waitClearEnterText_css(icp.Styles_String, Globals.Inventory.SubCategory);
	
	GenericWrappers.sleepInSeconds(1);
	webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdAttribute_STYLE_0_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
}
	}


}
