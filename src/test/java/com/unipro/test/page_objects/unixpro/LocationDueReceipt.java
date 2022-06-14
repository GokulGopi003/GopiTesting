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

public class LocationDueReceipt extends PageObject {
	LocationDueReceipttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public LocationDueReceipt(LocationDueReceipttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the LocationDueReceipt sheet data to map")
	public void i_load_the_LocationDueReceipt_sheet_data_to_map() {
		Globals.Inventory.LocationDueReceiptSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME131);
	}

	@Then("I load the rowise LocationDueReceipt data for {string} rowname")
	public void i_load_the_rowise_LocationDueReceipt_data_for_rowname(String row_name) {
		Globals.Inventory.LocationDueReceiptrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.LocationDueReceiptSheetData, row_name);

		System.out.println(Globals.Inventory.LocationDueReceiptrowwiseData);
	}

	@Then("I update value to the LocationDueReceipt page global Variables")
	public void i_update_value_to_the_LocationDueReceipt_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.LocationDueReceiptrowwiseData.get("Location");
		Globals.Inventory.Vendor = Globals.Inventory.LocationDueReceiptrowwiseData.get("Vendor");
		
		Globals.Inventory.Terminal = Globals.Inventory.LocationDueReceiptrowwiseData.get("Terminal");
		Globals.Inventory.Payment = Globals.Inventory.LocationDueReceiptrowwiseData.get("PaymentType");
		
		
		Globals.Inventory.Batch1 = Globals.Inventory.LocationDueReceiptrowwiseData.get("ConsolidatedSettlemntLoc");
		Globals.Inventory.Batch2 = Globals.Inventory.LocationDueReceiptrowwiseData.get("CsettlementDate");
		Globals.Inventory.Batch3 = Globals.Inventory.LocationDueReceiptrowwiseData.get("PoandGidCostChange");
		Globals.Inventory.Batch4 = Globals.Inventory.LocationDueReceiptrowwiseData.get("DueReceipt");
		Globals.Inventory.Batch5 = Globals.Inventory.LocationDueReceiptrowwiseData.get("PriceChangeReportInPos");
		Globals.Inventory.Batch6 = Globals.Inventory.LocationDueReceiptrowwiseData.get("DiscountReportInPos");
		Globals.Inventory.Batch7 = Globals.Inventory.LocationDueReceiptrowwiseData.get("SettlementDiscrepencyPos");
		Globals.Inventory.Batch8 = Globals.Inventory.LocationDueReceiptrowwiseData.get("VoucherClaim");
		
		Globals.Inventory.Batch9 = Globals.Inventory.LocationDueReceiptrowwiseData.get("Payment");
		Globals.Inventory.Batch10 = Globals.Inventory.LocationDueReceiptrowwiseData.get("Receipt");
		Globals.Inventory.Batch11 = Globals.Inventory.LocationDueReceiptrowwiseData.get("PaymentandReceipt");
		Globals.Inventory.Batch12 = Globals.Inventory.LocationDueReceiptrowwiseData.get("vendors");
		Globals.Inventory.Batch13 = Globals.Inventory.LocationDueReceiptrowwiseData.get("Summary");
		Globals.Inventory.Batch14 = Globals.Inventory.LocationDueReceiptrowwiseData.get("Detail");
		Globals.Inventory.FromDate = Globals.Inventory.LocationDueReceiptrowwiseData.get("FromDate");
		
		Globals.Inventory.ToDate = Globals.Inventory.LocationDueReceiptrowwiseData.get("ToDate");
	}

	@Then("I fill new LocationDueReceipt data page using excel data")
	public void i_fill_new_LocationDueReceipt_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.ConsolidatedSettlemntLoc_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.CsettlementDate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.PoandGidCostChange_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.DueReceipt_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.PriceChangeReportInPos_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.DiscountReportInPos_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.SettlementDiscrepencyPos_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.VoucherClaim_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
			terpage.terminal_waitClearEnterText_css(icp.Terminal_String, Globals.Inventory.Terminal);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Terminal).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Payment)) {
			terpage.terminal_waitClearEnterText_css(icp.PaymentTybe_String, Globals.Inventory.Payment);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Payment, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Payment).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.Payment_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.Receipt_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.PaymentandReceipt_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_checkBox_element(icp.Vendors_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
			terPage.get_radioButton_element(icp.Detail_String).click();
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
