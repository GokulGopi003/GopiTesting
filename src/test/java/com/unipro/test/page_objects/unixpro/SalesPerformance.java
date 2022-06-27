package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class SalesPerformance extends PageObject {
	SalesPerformanceTypeField icp;
	TerminalPage terpage;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	WebDriver driver = new ChromeDriver();

	public SalesPerformance(SalesPerformanceTypeField icp) {
		this.icp = icp;
		terpage = new TerminalPage();
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	}
	@Then("I load the SalesPerformance sheet data to map")
	public void i_load_the_SalesPerformance_sheet_data_to_map() {
		Globals.Inventory.SalesPerformanceSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME96);
	}

	@Then("I load the SalesPerformance rowise  data for {string} rowname")
	public void i_load_the_SalesPerformance_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.SalesPerformancerowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SalesPerformanceSheetData, row_name);

		System.out.println(Globals.Inventory.SalesPerformancerowwiseData);
	}

	@Then("I update value to the SalesPerformance page global Variables")
	public void i_update_value_to_the_SalesPerformance_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.SalesPerformancerowwiseData.get("Vendor");
		Globals.Inventory.Location = Globals.Inventory.SalesPerformancerowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.SalesPerformancerowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.SalesPerformancerowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.SalesPerformancerowwiseData.get("Brand");
		Globals.Inventory.SubCategory = Globals.Inventory.SalesPerformancerowwiseData.get("SubCategory");
		Globals.Inventory.Merchandise = Globals.Inventory.SalesPerformancerowwiseData.get("Merchandise");
		Globals.Inventory.Manufacture = Globals.Inventory.SalesPerformancerowwiseData.get("Manufacture");
		Globals.Inventory.Floorcode = Globals.Inventory.SalesPerformancerowwiseData.get("Floorcode");
		Globals.Inventory.Section = Globals.Inventory.SalesPerformancerowwiseData.get("Section");
		Globals.Inventory.Bin = Globals.Inventory.SalesPerformancerowwiseData.get("Bin");
		Globals.Inventory.ShelfCode = Globals.Inventory.SalesPerformancerowwiseData.get("ShelfCode");
		Globals.Inventory.WareHouse = Globals.Inventory.SalesPerformancerowwiseData.get("WareHouse");
		Globals.Inventory.ItemCode = Globals.Inventory.SalesPerformancerowwiseData.get("ItemCode");
		Globals.Inventory.ItemName = Globals.Inventory.SalesPerformancerowwiseData.get("ItemName");
		Globals.Inventory.Customer = Globals.Inventory.SalesPerformancerowwiseData.get("Customer");
		Globals.Inventory.SalesMan = Globals.Inventory.SalesPerformancerowwiseData.get("SalesMan");
		Globals.Inventory.BatchNo = Globals.Inventory.SalesPerformancerowwiseData.get("BatchNo");
		Globals.Inventory.FromDate = Globals.Inventory.SalesPerformancerowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.SalesPerformancerowwiseData.get("ToDate");
		Globals.Inventory.IsPrePrint = Globals.Inventory.SalesPerformancerowwiseData.get("IsPrePrint");
		Globals.Inventory.Batch = Globals.Inventory.SalesPerformancerowwiseData.get("Batch");
		Globals.Inventory.Batch1 = Globals.Inventory.SalesPerformancerowwiseData.get("Batch1");
	}

	@Then("I fill new SalesPerformance data page using excel data")
	public void i_fill_new_SalesPerformance_data_page_using_excel_data() throws Exception {
     try {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
				terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
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
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
				terpage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
				terpage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
				terpage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Merchandise);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Merchandise, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Merchandise).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
				terpage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Manufacture).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
				terpage.terminal_waitClearEnterText_css(icp.Floor_String, Globals.Inventory.Floorcode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terpage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Section).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
				terpage.terminal_waitClearEnterText_css(icp.Bin_String, Globals.Inventory.Bin);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Bin, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Bin).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
				terpage.terminal_waitClearEnterText_css(icp.Shelf_String, Globals.Inventory.ShelfCode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
				terpage.terminal_waitClearEnterText_css(icp.WareHouse_String, Globals.Inventory.WareHouse);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Customer)) {
				terpage.terminal_waitClearEnterText_css(icp.Customer_String, Globals.Inventory.Customer);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Customer, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Customer).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesMan)) {
				terpage.terminal_waitClearEnterText_css(icp.SalesMan_String, Globals.Inventory.SalesMan);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.SalesMan, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.SalesMan).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCode")).sendKeys(Keys.RETURN);
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtItemName\"]")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.BatchNo)) {
				terpage.terminal_waitClearEnterText_css(icp.BatchNo_String, Globals.Inventory.BatchNo);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.BatchNo, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.BatchNo).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
				terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
				//Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromDate, "input#txtSearch");
				//Inventorychange.return_td_invoke_element(Globals.Inventory.FromDate).click();
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
				terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
				//Inventorychange.clearAndTypeSlowly(Globals.Inventory.ToDate, "input#txtSearch");
				//Inventorychange.return_td_invoke_element(Globals.Inventory.ToDate).click();
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
				terPage.get_checkBox_element_Xpath(icp.History_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
				terPage.get_checkBox_element_Xpath(icp.Consolidated_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
				terPage.get_radioButton_element(icp.SlowMoving_String).click();
			}
			/*if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
				terPage.get_checkBox_element_Xpath(icp.Ispreprint7_String).click();
			}*/
			pass.ExcelFourData("SalesPerformance","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("SalesPerformance", "Filters", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e)
			{
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("SalesPerformance","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("SalesPerformance", "Filters", "FAIL", 1, 0, 1, 3);
			}

	}
}
	
	
	