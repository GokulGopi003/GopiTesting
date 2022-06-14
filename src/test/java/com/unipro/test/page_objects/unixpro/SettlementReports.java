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

public class SettlementReports extends PageObject {
	SettlementReportstypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public SettlementReports(SettlementReportstypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the SettlementReports sheet data to map")
	public void i_load_the_SettlementReports_sheet_data_to_map() {
		Globals.Inventory.SettlementReportsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME129);
	}

	@Then("I load the rowise SettlementReports data for {string} rowname")
	public void i_load_the_rowise_SettlementReports_data_for_rowname(String row_name) {
		Globals.Inventory.SettlementReportsrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SettlementReportsSheetData, row_name);

		System.out.println(Globals.Inventory.SettlementReportsrowwiseData);
	    	}

	@Then("I update value to the SettlementReports page global Variables")
	public void i_update_value_to_the_SettlementReports_page_global_Variables() {
		Globals.Inventory.Cashier = Globals.Inventory.SettlementReportsrowwiseData.get("Cashier");
		Globals.Inventory.Terminal = Globals.Inventory.SettlementReportsrowwiseData.get("Terminal");
		//Globals.Inventory.Paymode = Globals.Inventory.SettlementReportsrowwiseData.get("Paymode");
		//Globals.Inventory.GidNo = Globals.Inventory.SettlementReportsrowwiseData.get("GidNo");
		
		
		Globals.Inventory.FromDate = Globals.Inventory.SettlementReportsrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.SettlementReportsrowwiseData.get("ToDate");
		Globals.Inventory.Batch1 = Globals.Inventory.SettlementReportsrowwiseData.get("CashierWise");
		Globals.Inventory.Batch2 = Globals.Inventory.SettlementReportsrowwiseData.get("DenominationWise");
		Globals.Inventory.Batch3 = Globals.Inventory.SettlementReportsrowwiseData.get("TerminalandCashierWise");
		Globals.Inventory.Batch4 = Globals.Inventory.SettlementReportsrowwiseData.get("ByDate");
		//Globals.Inventory.Batch5 = Globals.Inventory.SettlementReportsrowwiseData.get("VendorWiseSale");

	    	}

	@Then("I fill new SettlementReports data page using excel data")
	public void i_fill_new_SettlementReports_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.CashierWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.DenominationWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.TerminalandCashierWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Cashier)) {
			terpage.terminal_waitClearEnterText_css(icp.Cashier_String, Globals.Inventory.Cashier);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Cashier, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Cashier).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
			terpage.terminal_waitClearEnterText_css(icp.Terminal_String, Globals.Inventory.Terminal);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Terminal).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.ByDate_String).click();
		}
	}


}
