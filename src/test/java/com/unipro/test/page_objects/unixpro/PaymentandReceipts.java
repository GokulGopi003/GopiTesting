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

public class PaymentandReceipts extends PageObject {
	PaymentandReceiptstypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public PaymentandReceipts(PaymentandReceiptstypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the PaymentandReceipts sheet data to map")
	public void i_load_the_PaymentandReceipts_sheet_data_to_map() {
		Globals.Inventory.PaymentandReceiptsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME113);
	}

	@Then("I load the rowise PaymentandReceipts data for {string} rowname")
	public void i_load_the_rowise_PaymentandReceipts_data_for_rowname(String row_name) {
		Globals.Inventory.PaymentandReceiptsrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PaymentandReceiptsSheetData, row_name);

		System.out.println(Globals.Inventory.PaymentandReceiptsrowwiseData);
	}

	@Then("I update value to the PaymentandReceipts page global Variables")
	public void i_update_value_to_the_PaymentandReceipts_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.PaymentandReceiptsrowwiseData.get("Vendor");
		Globals.Inventory.Location = Globals.Inventory.PaymentandReceiptsrowwiseData.get("Location");
		Globals.Inventory.Category = Globals.Inventory.PaymentandReceiptsrowwiseData.get("PaymentType");
		Globals.Inventory.Brand = Globals.Inventory.PaymentandReceiptsrowwiseData.get("PaymentSubType");
		
		Globals.Inventory.Department = Globals.Inventory.PaymentandReceiptsrowwiseData.get("Terminal");
		Globals.Inventory.Batch1 = Globals.Inventory.PaymentandReceiptsrowwiseData.get("Receipts");
		Globals.Inventory.Batch2 = Globals.Inventory.PaymentandReceiptsrowwiseData.get("PaymentandReceipts");
		Globals.Inventory.Batch3 = Globals.Inventory.PaymentandReceiptsrowwiseData.get("ByDate");
		
		Globals.Inventory.FromDate = Globals.Inventory.PaymentandReceiptsrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.PaymentandReceiptsrowwiseData.get("ToDate");
	}

	@Then("I fill new PaymentandReceipts data page using excel data")
	public void i_fill_new_PaymentandReceipts_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.Receipts_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.PaymentandReceipts_String).click();
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
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.Terminal_String, Globals.Inventory.Department);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terpage.terminal_waitClearEnterText_css(icp.PaymentType_String, Globals.Inventory.Category);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terpage.terminal_waitClearEnterText_css(icp.PaymentSubType_String, Globals.Inventory.Brand);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDatePayment\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDatePayment\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
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
