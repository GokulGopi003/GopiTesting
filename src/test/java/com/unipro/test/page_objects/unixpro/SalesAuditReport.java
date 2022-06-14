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

public class SalesAuditReport extends PageObject {
	SalesAuditReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public SalesAuditReport(SalesAuditReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the SalesAuditReport sheet data to map")
	public void i_load_the_SalesAuditReport_sheet_data_to_map() {
		Globals.Inventory.SalesAuditReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME120);
	}

	@Then("I load the rowise SalesAuditReport data for {string} rowname")
	public void i_load_the_rowise_SalesAuditReport_data_for_rowname(String row_name) {
		Globals.Inventory.SalesAuditReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SalesAuditReportSheetData, row_name);

		System.out.println(Globals.Inventory.SalesAuditReportrowwiseData);
	}

	@Then("I update value to the SalesAuditReport page global Variables")
	public void i_update_value_to_the_SalesAuditReport_page_global_Variables() {
		Globals.Inventory.Batch1 = Globals.Inventory.SalesAuditReportrowwiseData.get("BillDiscountLog");
		Globals.Inventory.Batch2 = Globals.Inventory.SalesAuditReportrowwiseData.get("PriceChangeLog");
		Globals.Inventory.Batch3 = Globals.Inventory.SalesAuditReportrowwiseData.get("BillClearLog");
		Globals.Inventory.Batch4 = Globals.Inventory.SalesAuditReportrowwiseData.get("PaymodeChangeLog");
		Globals.Inventory.Batch5 = Globals.Inventory.SalesAuditReportrowwiseData.get("ItemCancelLog");
		Globals.Inventory.Batch6 = Globals.Inventory.SalesAuditReportrowwiseData.get("ModuleWiseReports");
		Globals.Inventory.Batch7 = Globals.Inventory.SalesAuditReportrowwiseData.get("BrandWiseSalesDiscount");
		Globals.Inventory.Batch8 = Globals.Inventory.SalesAuditReportrowwiseData.get("DepartmentWiseSalesDiscount");
		Globals.Inventory.Batch9 = Globals.Inventory.SalesAuditReportrowwiseData.get("CategoryWiseSalesDiscount");
		Globals.Inventory.Batch10 = Globals.Inventory.SalesAuditReportrowwiseData.get("BreakPriceSalesDiscount");
		Globals.Inventory.Batch11 = Globals.Inventory.SalesAuditReportrowwiseData.get("PriceChangeSalesDiscount");
		Globals.Inventory.Batch12 = Globals.Inventory.SalesAuditReportrowwiseData.get("PromotionWiseDiscount");
		Globals.Inventory.Batch13 = Globals.Inventory.SalesAuditReportrowwiseData.get("HoldBills");
		Globals.Inventory.Batch14 = Globals.Inventory.SalesAuditReportrowwiseData.get("PosActivityLog");
		Globals.Inventory.Batch15 = Globals.Inventory.SalesAuditReportrowwiseData.get("Summary");
		Globals.Inventory.Batch16 = Globals.Inventory.SalesAuditReportrowwiseData.get("Detail");
		Globals.Inventory.Batch = Globals.Inventory.SalesAuditReportrowwiseData.get("ByDate");
		Globals.Inventory.FromDate = Globals.Inventory.SalesAuditReportrowwiseData.get("FromDate");
	    Globals.Inventory.ToDate = Globals.Inventory.SalesAuditReportrowwiseData.get("ToDate");
	}

	@Then("I fill new SalesAuditReport data page using excel data")
	public void i_fill_new_SalesAuditReport_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.BillDiscountLog_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.PriceChangeLog_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.BillClearLog_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.PaymodeChangeLog_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.ItemCancelLog_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.ModuleWiseReports_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.BrandWiseSalesDiscount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.DepartmentWiseSalesDiscount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.CategoryWiseSalesDiscount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.BreakPriceSalesDiscount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.PriceChangeSalesDiscount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_radioButton_element(icp.PromotionWiseDiscount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			terPage.get_radioButton_element(icp.HoldBills_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
			terPage.get_radioButton_element(icp.PosActivityLog_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDateAudit\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDateAudit\"]")).sendKeys(Keys.TAB);
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
			terPage.get_checkBox_element(icp.Detail_String).click();
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
