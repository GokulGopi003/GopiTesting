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

public class SalesReturnReport extends PageObject {
	SalesReturnReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public SalesReturnReport(SalesReturnReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the SalesReturnReport sheet data to map")
	public void i_load_the_SalesReturnReport_sheet_data_to_map() {
		Globals.Inventory.SalesReturnReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME122);
	}

	@Then("I load the rowise SalesReturnReport data for {string} rowname")
	public void i_load_the_rowise_SalesReturnReport_data_for_rowname(String row_name) {
		Globals.Inventory.SalesReturnReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SalesReturnReportSheetData, row_name);

		System.out.println(Globals.Inventory.SalesReturnReportrowwiseData);
	}

	@Then("I update value to the SalesReturnReport page global Variables")
	public void i_update_value_to_the_SalesReturnReport_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.SalesReturnReportrowwiseData.get("Location");
		Globals.Inventory.Cashier = Globals.Inventory.SalesReturnReportrowwiseData.get("Cashier");
		Globals.Inventory.Terminal = Globals.Inventory.SalesReturnReportrowwiseData.get("Terminal");
		Globals.Inventory.Customer = Globals.Inventory.SalesReturnReportrowwiseData.get("Member");
		
		Globals.Inventory.Batch1 = Globals.Inventory.SalesReturnReportrowwiseData.get("SalesRefundCash");
		Globals.Inventory.Batch2 = Globals.Inventory.SalesReturnReportrowwiseData.get("SalesRefundExchangeVoucher");
		Globals.Inventory.Batch3 = Globals.Inventory.SalesReturnReportrowwiseData.get("ExchangeVoucherUnUsed");
		Globals.Inventory.Batch4 = Globals.Inventory.SalesReturnReportrowwiseData.get("ExchangeVoucherUsed");
		Globals.Inventory.Batch5 = Globals.Inventory.SalesReturnReportrowwiseData.get("ExchangeVoucherExpired");
		Globals.Inventory.Batch6 = Globals.Inventory.SalesReturnReportrowwiseData.get("TradeUnusedList");
		Globals.Inventory.Batch7 = Globals.Inventory.SalesReturnReportrowwiseData.get("TradeUsedList");
		Globals.Inventory.Batch8 = Globals.Inventory.SalesReturnReportrowwiseData.get("TradeDeletedlist");
		Globals.Inventory.Batch9 = Globals.Inventory.SalesReturnReportrowwiseData.get("ExchangeItems");
		
		Globals.Inventory.Batch10 = Globals.Inventory.SalesReturnReportrowwiseData.get("InvoiceWisePaymodeWiseSales");
		 Globals.Inventory.Batch22 = Globals.Inventory.SalesReturnReportrowwiseData.get("WeightScaleBalanceQty");
		 Globals.Inventory.Batch23 = Globals.Inventory.SalesReturnReportrowwiseData.get("Summary");
		  Globals.Inventory.Batch24 = Globals.Inventory.SalesReturnReportrowwiseData.get("Detail");
			Globals.Inventory.Date = Globals.Inventory.SalesReturnReportrowwiseData.get("CashSales");
			Globals.Inventory.Batch26 = Globals.Inventory.SalesReturnReportrowwiseData.get("All");
			Globals.Inventory.Batch = Globals.Inventory.SalesReturnReportrowwiseData.get("ByDate");
			Globals.Inventory.Batch25 = Globals.Inventory.SalesReturnReportrowwiseData.get("CreditSales");
		    Globals.Inventory.FromDate = Globals.Inventory.SalesReturnReportrowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.SalesReturnReportrowwiseData.get("ToDate");
	}

	@Then("I fill new SalesReturnReport data page using excel data")
	public void i_fill_new_SalesReturnReport_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.SalesRefundCash_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.SalesRefundExchangeVoucher_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.ExchangeVoucherUnUsed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.ExchangeVoucherUsed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.ExchangeVoucherExpired_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.TradeUnusedList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.TradeUsedList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.TradeDeletedlist_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.ExchangeItems_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Customer)) {
			terpage.terminal_waitClearEnterText_css(icp.Member_String, Globals.Inventory.Customer);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Customer, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Customer).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDateReturn\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDateReturn\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch23)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch24)) {
			terPage.get_checkBox_element(icp.Detail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.get_radioButton_element(icp.CashSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch25)) {
			terPage.get_checkBox_element(icp.CreditSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch26)) {
			terPage.get_checkBox_element(icp.All_String).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_checkBox_element(icp.ByDate_String).click();
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
