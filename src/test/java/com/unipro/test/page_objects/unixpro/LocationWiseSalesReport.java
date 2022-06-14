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

public class LocationWiseSalesReport extends PageObject {
	LocationWiseSalesReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public LocationWiseSalesReport(LocationWiseSalesReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the LocationWiseSalesReport sheet data to map")
	public void i_load_the_LocationWiseSalesReport_sheet_data_to_map() {
		Globals.Inventory.LocationWiseSalesReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME126);
	}

	@Then("I load the rowise LocationWiseSalesReport data for {string} rowname")
	public void i_load_the_rowise_LocationWiseSalesReport_data_for_rowname(String row_name) {
		Globals.Inventory.LocationWiseSalesReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.LocationWiseSalesReportSheetData, row_name);

		System.out.println(Globals.Inventory.LocationWiseSalesReportrowwiseData);
	}

	@Then("I update value to the LocationWiseSalesReport page global Variables")
	public void i_update_value_to_the_LocationWiseSalesReport_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("Location");
		Globals.Inventory.ItemCode = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("Inventory");
		Globals.Inventory.SubCategory = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("GroupBy");
		Globals.Inventory.Department = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("Department");
		
		Globals.Inventory.Category = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("Brand");
		Globals.Inventory.Vendor = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("Vendor");
		Globals.Inventory.BatchNo = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("BatchNo");
		Globals.Inventory.Batch1 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("DepartmentWiseSales");
		Globals.Inventory.Batch2 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("CategoryWiseSales");
		Globals.Inventory.Batch3 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("BrandWiseSales");
		Globals.Inventory.Batch4 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("ClassWiseSale");
		Globals.Inventory.Batch5 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("ItemWiseSales");
		Globals.Inventory.Batch6 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("LocationWisesalesAll");
		Globals.Inventory.Batch7 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("LocationWiseStock");
		Globals.Inventory.Batch8 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("DateWise");
		Globals.Inventory.Batch9 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("MonthWise");
		Globals.Inventory.Batch10 = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("None");
		Globals.Inventory.Batch = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("ByDate");
		
	    Globals.Inventory.FromDate = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.LocationWiseSalesReportrowwiseData.get("ToDate");
	}

	@Then("I fill new LocationWiseSalesReport data page using excel data")
	public void i_fill_new_LocationWiseSalesReport_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.DepartmentWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.CategoryWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.BrandWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.ClassWiseSale_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.ItemWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.LocationWisesalesAll_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.LocationWiseStock_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terpage.terminal_waitClearEnterText_css(icp.Inventory_String, Globals.Inventory.ItemCode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlReport_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlReport_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlReport_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.SubCategory);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.ENTER);

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
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BatchNo)) {
			terpage.terminal_waitClearEnterText_css(icp.BatchNo_String, Globals.Inventory.BatchNo);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.BatchNo, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.BatchNo).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.DateWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.Month_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.None_String).click();
		}
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_radioButton_element(icp.ByDate_String).click();
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
