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

public class CustomerReceiptReport extends PageObject {
	CustomerReceiptReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public CustomerReceiptReport(CustomerReceiptReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the CustomerReceiptReport sheet data to map")
	public void i_load_the_CustomerReceiptReport_sheet_data_to_map() {
		Globals.Inventory.CustomerReceiptReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME131);
	}

	@Then("I load the rowise CustomerReceiptReport data for {string} rowname")
	public void i_load_the_rowise_CustomerReceiptReport_data_for_rowname(String row_name) {
		Globals.Inventory.CustomerReceiptReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.CustomerReceiptReportSheetData, row_name);

		System.out.println(Globals.Inventory.CustomerReceiptReportrowwiseData);
	}

	@Then("I update value to the CustomerReceiptReport page global Variables")
	public void i_update_value_to_the_CustomerReceiptReport_page_global_Variables() {

		Globals.Inventory.Location = Globals.Inventory.CustomerReceiptReportrowwiseData.get("Location");
        Globals.Inventory.Department = Globals.Inventory.CustomerReceiptReportrowwiseData.get("MemberTybe");
		Globals.Inventory.Category = Globals.Inventory.CustomerReceiptReportrowwiseData.get("Customer");
		
	    Globals.Inventory.Vendor = Globals.Inventory.CustomerReceiptReportrowwiseData.get("Vendor");
		Globals.Inventory.Cashier = Globals.Inventory.CustomerReceiptReportrowwiseData.get("Cashier");
		Globals.Inventory.Terminal = Globals.Inventory.CustomerReceiptReportrowwiseData.get("Terminal");
		Globals.Inventory.Batch1 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("CreditCustomerOutstanding");
		Globals.Inventory.Batch2 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("CreditSales");
		Globals.Inventory.Batch3 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("CreditChequePayment");
		Globals.Inventory.Batch4 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("CustomerWiseAging");
		Globals.Inventory.Batch5 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("DueReceipt");
		Globals.Inventory.Batch6 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("ReceiptDelete");
		
		Globals.Inventory.Batch7 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("Summary");
		Globals.Inventory.Batch8 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("Detail");
		Globals.Inventory.Batch9 = Globals.Inventory.CustomerReceiptReportrowwiseData.get("ByDate");
		
		
	    Globals.Inventory.FromDate = Globals.Inventory.CustomerReceiptReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.CustomerReceiptReportrowwiseData.get("ToDate");
	}

	@Then("I fill new CustomerReceiptReport data page using excel data")
	public void i_fill_new_CustomerReceiptReport_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.CreditCustomerOutstanding_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.CreditSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.CreditChequePayment_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.CustomerWiseAging).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.DueReceipt_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.ReceiptDelete_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
						
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.MemberType_String, Globals.Inventory.Department);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terpage.terminal_waitClearEnterText_css(icp.Customer_String, Globals.Inventory.Category);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.Detail_String).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.ByDate_String).click();
		}
	}


}
