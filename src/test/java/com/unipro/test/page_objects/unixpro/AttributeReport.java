package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class AttributeReport extends PageObject {
	AttributeReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public AttributeReport(AttributeReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the AttributeReport sheet data to map")
	public void i_load_the_AttributeReport_sheet_data_to_map() {
		Globals.Inventory.AttributeReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME133);
	}

	@Then("I load the rowise AttributeReport data for {string} rowname")
	public void i_load_the_rowise_AttributeReport_data_for_rowname(String row_name) {
		Globals.Inventory.AttributeReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.AttributeReportSheetData, row_name);

		System.out.println(Globals.Inventory.AttributeReportrowwiseData);
	}

	@Then("I update value to the AttributeReport page global Variables")
	public void i_update_value_to_the_AttributeReport_page_global_Variables() {
		Globals.Inventory.Batch1 = Globals.Inventory.AttributeReportrowwiseData.get("InventoryList");
		Globals.Inventory.Batch2 = Globals.Inventory.AttributeReportrowwiseData.get("BatchWiseStock");
		Globals.Inventory.Batch3 = Globals.Inventory.AttributeReportrowwiseData.get("PurchaseReport");
		Globals.Inventory.Batch4 = Globals.Inventory.AttributeReportrowwiseData.get("ItemWisePurchaseReport");
		Globals.Inventory.Batch5 = Globals.Inventory.AttributeReportrowwiseData.get("SalesReport");
		Globals.Inventory.Batch6 = Globals.Inventory.AttributeReportrowwiseData.get("ItemWiseSalesReport");
		Globals.Inventory.Vendor = Globals.Inventory.AttributeReportrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.AttributeReportrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.AttributeReportrowwiseData.get("Category");
		Globals.Inventory.Class = Globals.Inventory.AttributeReportrowwiseData.get("Class");
		Globals.Inventory.Brand = Globals.Inventory.AttributeReportrowwiseData.get("Brand");
		Globals.Inventory.ItemCode = Globals.Inventory.AttributeReportrowwiseData.get("ItemCode");
		Globals.Inventory.Style = Globals.Inventory.AttributeReportrowwiseData.get("Style");
		
		Globals.Inventory.Location = Globals.Inventory.AttributeReportrowwiseData.get("Location");		
		Globals.Inventory.FromDate = Globals.Inventory.AttributeReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.AttributeReportrowwiseData.get("ToDate");
		
		Globals.Inventory.StockType = Globals.Inventory.AttributeReportrowwiseData.get("StockType");
		Globals.Inventory.Cloth = Globals.Inventory.AttributeReportrowwiseData.get("Cloth");
		Globals.Inventory.Color = Globals.Inventory.AttributeReportrowwiseData.get("Color");
		Globals.Inventory.Design = Globals.Inventory.AttributeReportrowwiseData.get("Design");
		Globals.Inventory.Fit = Globals.Inventory.AttributeReportrowwiseData.get("Fit");
		Globals.Inventory.Neck = Globals.Inventory.AttributeReportrowwiseData.get("Neck");
		Globals.Inventory.Size = Globals.Inventory.AttributeReportrowwiseData.get("Size");
		Globals.Inventory.Sleeve = Globals.Inventory.AttributeReportrowwiseData.get("Sleeve");
		Globals.Inventory.SubCategory = Globals.Inventory.AttributeReportrowwiseData.get("Styles");
		
	}

	@Then("I fill new AttributeReport data page using excel data")
	public void i_fill_new_AttributeReport_data_page_using_excel_data() {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.InventoryStockList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.BatchWiseStock_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
		terPage.elementToBeClickable(By.cssSelector("#liPurchaseReport > a")).click();
	}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.ItemWisePurchaseReport_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.elementToBeClickable(By.cssSelector("#liSalesReport > a")).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.ItemWiseSalesReport_String).click();
		}
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtfrmDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txttoDate\"]")).sendKeys(Keys.TAB);
			
		}
		
          if (GenericWrappers.isNotEmpty(Globals.Inventory.StockType)) {
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lstStocktype_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			terpage.terminal_waitClearEnterText_css(icp.StockType_String, Globals.Inventory.StockType);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.StockType, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.StockType).click();
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lstStocktype_chzn\"]/ul/li/input")).sendKeys(Keys.RETURN);
			//webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lstStocktype_chzn\"]/ul/li/input")).sendKeys(Keys.TAB);
          }
	
			
		
		  
	}
		@Then("I fill Attributes")
		public void i_fill_Attributes() {
		
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



