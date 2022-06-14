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

public class VendorOutstanding extends PageObject {
	VendorOutstandingtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public VendorOutstanding(VendorOutstandingtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the VendorOutstanding sheet data to map")
	public void i_load_the_VendorOutstanding_sheet_data_to_map() {
		Globals.Inventory.VendorOutstandingSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME117);
	}

	@Then("I load the rowise VendorOutstanding data for {string} rowname")
	public void i_load_the_rowise_VendorOutstanding_data_for_rowname(String row_name) {
		Globals.Inventory.VendorOutstandingrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.VendorOutstandingSheetData, row_name);

		System.out.println(Globals.Inventory.VendorOutstandingrowwiseData);
	}

	@Then("I update value to the VendorOutstanding page global Variables")
	public void i_update_value_to_the_VendorOutstanding_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.VendorOutstandingrowwiseData.get("Vendor");
		Globals.Inventory.Location = Globals.Inventory.VendorOutstandingrowwiseData.get("Location");
		Globals.Inventory.Category = Globals.Inventory.VendorOutstandingrowwiseData.get("PaymentType");
		Globals.Inventory.Brand = Globals.Inventory.VendorOutstandingrowwiseData.get("ReasonCode");
		Globals.Inventory.SubCategory = Globals.Inventory.VendorOutstandingrowwiseData.get("PaymentStatus");
		Globals.Inventory.Department = Globals.Inventory.VendorOutstandingrowwiseData.get("PaymentNo");
		
		Globals.Inventory.Batch1 = Globals.Inventory.VendorOutstandingrowwiseData.get("VendorOutstanding");
		Globals.Inventory.Batch2 = Globals.Inventory.VendorOutstandingrowwiseData.get("VendorPayments");
		Globals.Inventory.Batch3 = Globals.Inventory.VendorOutstandingrowwiseData.get("CashPayments");
		Globals.Inventory.Batch4 = Globals.Inventory.VendorOutstandingrowwiseData.get("ChequePaymentPrepared");
		Globals.Inventory.Batch5 = Globals.Inventory.VendorOutstandingrowwiseData.get("ChequePaymentDelivered");
		Globals.Inventory.Batch6 = Globals.Inventory.VendorOutstandingrowwiseData.get("CreditNoteList");
		Globals.Inventory.Batch7 = Globals.Inventory.VendorOutstandingrowwiseData.get("DebitNoteList");
		Globals.Inventory.Batch8 = Globals.Inventory.VendorOutstandingrowwiseData.get("DeletedPaymentsDetail");
		Globals.Inventory.Batch9 = Globals.Inventory.VendorOutstandingrowwiseData.get("DeletedPaymentsSummary");
		Globals.Inventory.Batch10 = Globals.Inventory.VendorOutstandingrowwiseData.get("DebitCreditDeleteLog");
		Globals.Inventory.FromDate = Globals.Inventory.VendorOutstandingrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.VendorOutstandingrowwiseData.get("ToDate");
		Globals.Inventory.Batch11 = Globals.Inventory.VendorOutstandingrowwiseData.get("Summary");
		Globals.Inventory.Batch12 = Globals.Inventory.VendorOutstandingrowwiseData.get("Detail");
		Globals.Inventory.Batch13 = Globals.Inventory.VendorOutstandingrowwiseData.get("BasedonCreditDays");
		Globals.Inventory.Batch14 = Globals.Inventory.VendorOutstandingrowwiseData.get("ByDate");
		Globals.Inventory.Batch15 = Globals.Inventory.VendorOutstandingrowwiseData.get("CheckDate");
	}

	@Then("I fill new VendorOutstanding data page using excel data")
	public void i_fill_new_VendorOutstanding_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.VendorOutstanding_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.VendorPayments_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.CashPayments_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.ChequePaymentPrepared_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.ChequePaymentDelivered_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.CreditNoteList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.DebitNoteList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.DeletedPaymentsDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.DeletedPaymentsSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.DebitCreditDeleteLog_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.PaymentNo_String, Globals.Inventory.Department);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terpage.terminal_waitClearEnterText_css(icp.PaymentType_String, Globals.Inventory.Category);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terpage.terminal_waitClearEnterText_css(icp.ReasonCode_String, Globals.Inventory.Brand);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
			terpage.terminal_waitClearEnterText_css(icp.PaymentStatus_String, Globals.Inventory.SubCategory);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDateVendor\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDateVendor\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_radioButton_element(icp.Detail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			terPage.get_checkBox_element(icp.BasedonCreditDays_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
			terPage.get_checkBox_element(icp.ByDate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
			terPage.get_checkBox_element(icp.CheckDate_String).click();
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
