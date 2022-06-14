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

public class CreditandDueSaleReport extends PageObject {
	CreditandDueSaleReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public CreditandDueSaleReport(CreditandDueSaleReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the CreditandDueSaleReport sheet data to map")
	public void i_load_the_CreditandDueSaleReport_sheet_data_to_map() {
		Globals.Inventory.CreditandDueSaleReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME121);
	}

	@Then("I load the rowise CreditandDueSaleReport data for {string} rowname")
	public void i_load_the_rowise_CreditandDueSaleReport_data_for_rowname(String row_name) {
		Globals.Inventory.CreditandDueSaleReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.CreditandDueSaleReportSheetData, row_name);

		System.out.println(Globals.Inventory.CreditandDueSaleReportrowwiseData);
	}

	@Then("I update value to the CreditandDueSaleReport page global Variables")
	public void i_update_value_to_the_CreditandDueSaleReport_page_global_Variables() {
		Globals.Inventory.Batch1 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("CustomerOutstanding");
		Globals.Inventory.Batch2 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("CreditLimitExceed");
		Globals.Inventory.Batch3 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("CreditDaysExceed");
		Globals.Inventory.Batch4 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("CustomerReceipt");
		Globals.Inventory.Batch5 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("CustomerReceiptDelete");
		Globals.Inventory.Batch6 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("CustomerWiseDueSales");
		Globals.Inventory.Batch7 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("DueSalesPending");
		Globals.Inventory.Batch8 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("DueSalesPartiallyPending");
		Globals.Inventory.Batch9 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("DueSalesClosed");
		Globals.Inventory.Batch10 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("DueReceipt");
		Globals.Inventory.Batch11 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("CreditSalesZone");
		
		Globals.Inventory.Customer = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("Member");
		Globals.Inventory.Department = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("InvoiceNo");
		Globals.Inventory.Category = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("ReceiptNo");
		Globals.Inventory.Zone = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("Zone");
		 Globals.Inventory.FromDate = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("ToDate");
		Globals.Inventory.Batch16 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("Summary");
		Globals.Inventory.Batch17 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("Detail");
		Globals.Inventory.Batch18 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("Paid");
		Globals.Inventory.Batch19 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("UnPaid");
		Globals.Inventory.Batch20 = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("All");
		Globals.Inventory.Batch = Globals.Inventory.CreditandDueSaleReportrowwiseData.get("ByDate");
	}

	@Then("I fill new CreditandDueSaleReport data page using excel data")
	public void i_fill_new_CreditandDueSaleReport_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.CustomerOutstanding_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.CreditLimitExceed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.CreditDaysExceed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.CustomerReceipt_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.CustomerReceiptDelete_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.CustomerWiseDueSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.DueSalesPending_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.DueSalesPartiallyPending_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.DueSalesClosed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.DueReceipt_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.CreditSalesZone_String).click();
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Customer)) {
			terpage.terminal_waitClearEnterText_css(icp.Member_String, Globals.Inventory.Customer);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Customer, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Customer).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.InvoiceNo_String, Globals.Inventory.Department);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terpage.terminal_waitClearEnterText_css(icp.ReceiptNo_String, Globals.Inventory.Category);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Zone)) {
			terpage.terminal_waitClearEnterText_css(icp.Zone_String, Globals.Inventory.Zone);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Zone, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Zone).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDateCredit\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDateCredit\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch17)) {
			terPage.get_checkBox_element(icp.Detail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch18)) {
			terPage.get_radioButton_element(icp.Paid_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch19)) {
			terPage.get_checkBox_element(icp.Unpaid_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch20)) {
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
