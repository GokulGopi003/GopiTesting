package com.unipro.test.page_objects.unixpro;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class MasterReports extends PageObject {
	MasterReportstypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public MasterReports(MasterReportstypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();
	}
	@Then("I load the MasterReports sheet data to map")
	public void i_load_the_MasterReports_sheet_data_to_map() {
		Globals.Inventory.MasterReportsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME109);
	}

	@Then("I load the rowise MasterReports data for {string} rowname")
	public void i_load_the_rowise_MasterReports_data_for_rowname(String row_name) {
		Globals.Inventory.MasterReportsrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.MasterReportsSheetData, row_name);

		System.out.println(Globals.Inventory.MasterReportsrowwiseData);
	}

	@Then("I update value to the MasterReports page global Variables")
	public void i_update_value_to_the_MasterReports_page_global_Variables() {
		//Globals.Inventory.Vendor = Globals.Inventory.MasterReportsrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.MasterReportsrowwiseData.get("Department");
		Globals.Inventory.FromDate = Globals.Inventory.MasterReportsrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.MasterReportsrowwiseData.get("ToDate");
		//Globals.Inventory.Category = Globals.Inventory.MasterReportsrowwiseData.get("Category");
		//Globals.Inventory.Brand = Globals.Inventory.MasterReportsrowwiseData.get("Brand");
		Globals.Inventory.Batch = Globals.Inventory.MasterReportsrowwiseData.get("ByDate");
		Globals.Inventory.Batch1 = Globals.Inventory.MasterReportsrowwiseData.get("Category");
		Globals.Inventory.Batch2 = Globals.Inventory.MasterReportsrowwiseData.get("SubCategory");
		Globals.Inventory.Batch3 = Globals.Inventory.MasterReportsrowwiseData.get("Brand");
		Globals.Inventory.Batch4 = Globals.Inventory.MasterReportsrowwiseData.get("Floor");
		Globals.Inventory.Batch5 = Globals.Inventory.MasterReportsrowwiseData.get("Section");
		Globals.Inventory.Batch6 = Globals.Inventory.MasterReportsrowwiseData.get("Vendor");
		Globals.Inventory.Batch7 = Globals.Inventory.MasterReportsrowwiseData.get("Location");
		Globals.Inventory.Batch8 = Globals.Inventory.MasterReportsrowwiseData.get("WareHouse");
		Globals.Inventory.Batch9 = Globals.Inventory.MasterReportsrowwiseData.get("Terminal");
		Globals.Inventory.Batch10 = Globals.Inventory.MasterReportsrowwiseData.get("Class");
		Globals.Inventory.Batch11 = Globals.Inventory.MasterReportsrowwiseData.get("SubClass");
		Globals.Inventory.Batch12 = Globals.Inventory.MasterReportsrowwiseData.get("ProductGroup");
		Globals.Inventory.Batch13 = Globals.Inventory.MasterReportsrowwiseData.get("User");
	}

	@Then("I fill new MasterReports data page using excel data")
	public void i_fill_new_MasterReports_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_radioButton_element(icp.Category_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_radioButton_element(icp.SubCategory_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
				terPage.get_radioButton_element(icp.Brand_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
				terPage.get_radioButton_element(icp.Floor_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
				terPage.get_radioButton_element(icp.Section_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
				terPage.get_radioButton_element(icp.Vendor_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
				terPage.get_radioButton_element(icp.Location_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
				terPage.get_radioButton_element(icp.WareHouse_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
				terPage.get_radioButton_element(icp.Terminal_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
				terPage.get_radioButton_element(icp.Class_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
				terPage.get_radioButton_element(icp.SubClass_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
				terPage.get_radioButton_element(icp.ProductGroup_String).click();
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
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element_Xpath(icp.Batch_String).click();

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
				terPage.get_checkBox_element_Xpath(icp.User_string).click();
			}
			
		
			pass.ExcelFourData("SalesAnalysisReport","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("SalesAnalysisReport", "Filters", "Pass", 1, 0, 1, 3);
			
		}
			catch(Exception e)
			{
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("SalesAnalysisReport","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("SalesAnalysisReport", "Filters", "FAIL", 1, 0, 1, 3);
			}
	
		}
}


