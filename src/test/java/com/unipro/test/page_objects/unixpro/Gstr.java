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

public class Gstr extends PageObject {
	GstrTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public Gstr(GstrTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();


}
	@Then("I load the GSTR sheet data to map")
	public void i_load_the_GSTR_sheet_data_to_map() {
		Globals.Inventory.GSTRSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME102);
	}

	@Then("I load the rowise GSTR data for {string} rowname")
	public void i_load_the_rowise_GSTR_data_for_rowname(String row_name) {
		Globals.Inventory.GSTRrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.GSTRSheetData, row_name);

		System.out.println(Globals.Inventory.GSTRrowwiseData);
	}

	@Then("I update value to the GSTR page global Variables")
	public void i_update_value_to_the_GSTR_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.GSTRrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.GSTRrowwiseData.get("Date");
		Globals.Inventory.FromDate = Globals.Inventory.GSTRrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.GSTRrowwiseData.get("ToDate");
		Globals.Inventory.Terminal = Globals.Inventory.GSTRrowwiseData.get("Month");
		Globals.Inventory.Brand = Globals.Inventory.GSTRrowwiseData.get("None");
		Globals.Inventory.Batch = Globals.Inventory.GSTRrowwiseData.get("Batch");
		Globals.Inventory.Batch1 = Globals.Inventory.GSTRrowwiseData.get("B2CSmallSale");
		Globals.Inventory.Batch2 = Globals.Inventory.GSTRrowwiseData.get("B2CLargeSale");
		Globals.Inventory.Batch3 = Globals.Inventory.GSTRrowwiseData.get("SRRegCustomer");
		Globals.Inventory.Batch4 = Globals.Inventory.GSTRrowwiseData.get("SRUnRegCustomer");
		Globals.Inventory.Batch5 = Globals.Inventory.GSTRrowwiseData.get("HsnSummary");
		Globals.Inventory.Batch6 = Globals.Inventory.GSTRrowwiseData.get("AnnualReturn");
		
	}

	@Then("I fill new GSTR data page using excel data")
	public void i_fill_new_GSTR_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_radioButton_element(icp.B2CSmallSales_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_radioButton_element(icp.B2CLargeSales_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
				terPage.get_radioButton_element(icp.SalesReturntoRegCustomer_String).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
				terPage.get_radioButton_element(icp.SalesReturntounRegCustomer_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
				terPage.get_radioButton_element(icp.HsnSummary_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
				terPage.get_radioButton_element(icp.AnnualReturn_String).click();
			}
			
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDateGstr\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDateGstr\"]")).sendKeys(Keys.TAB);
		}
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Batch_String, Globals.Inventory.Batch);

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




