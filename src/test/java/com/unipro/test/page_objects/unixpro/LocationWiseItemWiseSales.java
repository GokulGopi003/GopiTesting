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

public class LocationWiseItemWiseSales extends PageObject {
	LocationWiseItemfield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public LocationWiseItemWiseSales(LocationWiseItemfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the LocationWiseItemWiseSales sheet data to map")
	public void i_load_the_LocationWiseItemWiseSales_sheet_data_to_map() {
		Globals.Inventory.LocationWiseItemWiseSalesSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME124);
	}

	@Then("I load the rowise LocationWiseItemWiseSales data for {string} rowname")
	public void i_load_the_rowise_LocationWiseItemWiseSales_data_for_rowname(String row_name) {
		Globals.Inventory.LocationWiseItemWiseSalesrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.LocationWiseItemWiseSalesSheetData, row_name);

		System.out.println(Globals.Inventory.LocationWiseItemWiseSalesrowwiseData);
	}

	@Then("I update value to the LocationWiseItemWiseSales page global Variables")
	public void i_update_value_to_the_LocationWiseItemWiseSales_page_global_Variables() {
		Globals.Inventory.ItemCode = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("ItemCode");
		Globals.Inventory.Location = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("Category");
		Globals.Inventory.SubCategory = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("SubCategory");
		Globals.Inventory.Brand = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("Brand");
		Globals.Inventory.Vendor = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("Vendor");
		Globals.Inventory.FromDate = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.LocationWiseItemWiseSalesrowwiseData.get("ToDate");
	}

	@Then("I fill new LocationWiseItemWiseSales data page using excel data")
	public void i_fill_new_LocationWiseItemWiseSales_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terpage.terminal_waitClearEnterText_css(icp.Inventory_String, Globals.Inventory.ItemCode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
		}
	}


}
