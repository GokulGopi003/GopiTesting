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

public class PRReqeusts extends PageObject {
	PRRequestsfield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public PRReqeusts(PRRequestsfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the PurchaseReturnReqReports sheet data to map")
	public void i_load_the_PurchaseReturnReqReports_sheet_data_to_map() {
		Globals.Inventory.PurchaseReturnReqReportsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME116);
	}

	@Then("I load the rowise PurchaseReturnReqReports data for {string} rowname")
	public void i_load_the_rowise_PurchaseReturnReqReports_data_for_rowname(String row_name) {
		Globals.Inventory.PurchaseReturnReqReportsrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PurchaseReturnReqReportsSheetData, row_name);

		System.out.println(Globals.Inventory.PurchaseReturnReqReportsrowwiseData);
	}

	@Then("I update value to the PurchaseReturnReqReports page global Variables")
	public void i_update_value_to_the_PurchaseReturnReqReports_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("Location");
		Globals.Inventory.Vendor = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("Brand");
		Globals.Inventory.SubCategory = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("SubCategory");
		Globals.Inventory.Class = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("Agent");
		Globals.Inventory.SubClass = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("ReturnNo");
		Globals.Inventory.Tax = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("ReturnType");
		Globals.Inventory.Manufacture = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("TranType");
		Globals.Inventory.Floorcode = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("PaymentStatus");
		
		Globals.Inventory.Batch1 = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("DateWisePRDetail");
		Globals.Inventory.Batch2 = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("PRReqUnClaimed");
		Globals.Inventory.Batch3 = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("PRReqClaimed");
		Globals.Inventory.Batch4 = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("PRDeleteSummary");
		Globals.Inventory.Batch5 = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("PRDeleteDetail");
		Globals.Inventory.Batch6 = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("PRReqLogSummary");
		Globals.Inventory.Batch7 = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("PRReqLogDetail");
		Globals.Inventory.Batch8 = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("PRSalesDetail");
		Globals.Inventory.FromDate = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("ToDate");
		Globals.Inventory.Batch = Globals.Inventory.PurchaseReturnReqReportsrowwiseData.get("ByDate");
	}

	@Then("I fill new PurchaseReturnReqReports data page using excel data")
	public void i_fill_new_PurchaseReturnReqReports_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.DateWisePRDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.PRReqUnClaimed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.PRReqClaimed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.PRDeleteSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.PRDeleteDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.PRReqLogSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.PRReqLogDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.PRSalesDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
			terpage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
			terpage.terminal_waitClearEnterText_css(icp.Agent_String, Globals.Inventory.Class);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Class).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubClass)) {
			terpage.terminal_waitClearEnterText_css(icp.ReturnNo_String, Globals.Inventory.SubClass);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubClass, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.SubClass).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tax)) {
			terpage.terminal_waitClearEnterText_css(icp.ReturnType_String, Globals.Inventory.Tax);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Tax, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Tax).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
			terpage.terminal_waitClearEnterText_css(icp.TranType_String, Globals.Inventory.Manufacture);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Manufacture).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
			terpage.terminal_waitClearEnterText_css(icp.PaymentStatus_String, Globals.Inventory.Floorcode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
		}
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDatePRR\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDatePRR\"]")).sendKeys(Keys.TAB);
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
