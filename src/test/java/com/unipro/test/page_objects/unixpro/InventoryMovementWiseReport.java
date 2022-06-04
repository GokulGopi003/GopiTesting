package com.unipro.test.page_objects.unixpro;

import java.io.IOException;

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

public class InventoryMovementWiseReport extends PageObject {
	InventoryMovementWiseReportTypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public InventoryMovementWiseReport(InventoryMovementWiseReportTypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}

	@Then("I load the InventoryMovementWiseReport sheet data to map")
	public void i_load_the_InventoryMovementWiseReport_sheet_data_to_map() {
		Globals.Inventory.InventoryMovementWiseReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME111);
	}

	@Then("I load the rowise InventoryMovementWiseReport data for {string} rowname")
	public void i_load_the_rowise_InventoryMovementWiseReport_data_for_rowname(String row_name) {
		Globals.Inventory.InventoryMovementWiseReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.InventoryMovementWiseReportSheetData, row_name);

		System.out.println(Globals.Inventory.InventoryMovementWiseReportrowwiseData);
	}

	@Then("I update value to the InventoryMovementWiseReport page global Variables")
	public void i_update_value_to_the_InventoryMovementWiseReport_page_global_Variables() {
		
		Globals.Inventory.Vendor = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("Vendor");
		Globals.Inventory.Location = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("Brand");
		Globals.Inventory.SubCategory = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("SubCategory");
		Globals.Inventory.Floor = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("Floor");
		Globals.Inventory.FromDate = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("ToDate");
		Globals.Inventory.Email = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("Email");
		Globals.Inventory.URL = Globals.Inventory.InventoryMovementWiseReportrowwiseData.get("URL");
	   	}

	@Then("I fill new InventoryMovementWiseReport data page using excel data")
	public void i_fill_new_InventoryMovementWiseReport_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlLocation_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlLocation_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlLocation_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Location);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.ENTER);

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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floor)) {
			terpage.terminal_waitClearEnterText_css(icp.Floor_String, Globals.Inventory.Floor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Floor).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromDate, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.FromDate).sendKeys(Keys.TAB);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.ToDate, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.ToDate).sendKeys(Keys.TAB);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		pass.ExcelFourData("terminalnew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("terminalnew", "TerminalNew", "Pass", 1, 0, 1, 3);
		}
       catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("terminalnew","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("terminalnew", "TerminalNew", "FAIL", 1, 0, 1, 3);
}
	}


}
