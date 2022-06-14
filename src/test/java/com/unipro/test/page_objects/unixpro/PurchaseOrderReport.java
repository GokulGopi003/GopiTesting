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

public class PurchaseOrderReport extends PageObject {
	PurchaseOrderReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public PurchaseOrderReport(PurchaseOrderReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the PurchaseOrderReport sheet data to map")
	public void i_load_the_PurchaseOrderReport_sheet_data_to_map() {
		Globals.Inventory.PurchaseOrderReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME115);
	}

	@Then("I load the rowise PurchaseOrderReport data for {string} rowname")
	public void i_load_the_rowise_PurchaseOrderReport_data_for_rowname(String row_name) {
		Globals.Inventory.PurchaseOrderReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PurchaseOrderReportSheetData, row_name);

		System.out.println(Globals.Inventory.PurchaseOrderReportrowwiseData);
	}

	@Then("I update value to the PurchaseOrderReport page global Variables")
	public void i_update_value_to_the_PurchaseOrderReport_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.PurchaseOrderReportrowwiseData.get("Vendor");
		Globals.Inventory.PoNo = Globals.Inventory.PurchaseOrderReportrowwiseData.get("PoNo");
		
		Globals.Inventory.Category = Globals.Inventory.PurchaseOrderReportrowwiseData.get("UserPo");
		Globals.Inventory.Date = Globals.Inventory.PurchaseOrderReportrowwiseData.get("ByDate");
		
		Globals.Inventory.FromDate = Globals.Inventory.PurchaseOrderReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.PurchaseOrderReportrowwiseData.get("ToDate");
		Globals.Inventory.Batch = Globals.Inventory.PurchaseOrderReportrowwiseData.get("PoPendiglist");
		Globals.Inventory.Batch1 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("PoClosed");
		Globals.Inventory.Batch2 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("PoCancelled");
		Globals.Inventory.Batch3 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("UserWisePoCount");
	//	Globals.Inventory.Batch4 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("UserWisePoCount");
		Globals.Inventory.Batch5 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("Approved");
		Globals.Inventory.Batch6 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("UnApproved");
		Globals.Inventory.Batch7 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("Both");
		Globals.Inventory.Batch8 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("Completepending");
		Globals.Inventory.Batch9 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("PartialPending");
		Globals.Inventory.Batch10 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("Summary");
		Globals.Inventory.Batch11 = Globals.Inventory.PurchaseOrderReportrowwiseData.get("Detail");
	}

	@Then("I fill new PurchaseOrderReport data page using excel data")
	public void i_fill_new_PurchaseOrderReport_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_radioButton_element(icp.PoPendingList_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_radioButton_element(icp.PoClosed_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_radioButton_element(icp.PoCancelled_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
				terPage.get_radioButton_element(icp.UserWisePoCount_String).click();
			}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PoNo)) {
			terpage.terminal_waitClearEnterText_css(icp.PoNo_String, Globals.Inventory.PoNo);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.PoNo, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.PoNo).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terpage.terminal_waitClearEnterText_css(icp.UserPo_String, Globals.Inventory.Category);
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
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.Approved_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.UnApproved_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.Both_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.CompletePending_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.PartialPending_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.get_radioButton_element(icp.ByDate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
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
