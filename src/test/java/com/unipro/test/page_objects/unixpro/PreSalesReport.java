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

public class PreSalesReport extends PageObject {
	PreSalesReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public PreSalesReport(PreSalesReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the PreSalesReport sheet data to map")
	public void i_load_the_PreSalesReport_sheet_data_to_map() {
		Globals.Inventory.PreSalesReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME125);
	}

	@Then("I load the rowise PreSalesReport data for {string} rowname")
	public void i_load_the_rowise_PreSalesReport_data_for_rowname(String row_name) {
		Globals.Inventory.PreSalesReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PreSalesReportSheetData, row_name);

		System.out.println(Globals.Inventory.PreSalesReportrowwiseData);
	}

	@Then("I update value to the PreSalesReport page global Variables")
	public void i_update_value_to_the_PreSalesReport_page_global_Variables() {
		Globals.Inventory.Customer = Globals.Inventory.PreSalesReportrowwiseData.get("Customer");
		Globals.Inventory.Location = Globals.Inventory.PreSalesReportrowwiseData.get("Location");
		Globals.Inventory.Cashier = Globals.Inventory.PreSalesReportrowwiseData.get("Cashier");
		Globals.Inventory.Terminal = Globals.Inventory.PreSalesReportrowwiseData.get("Terminal");
		Globals.Inventory.Batch1 = Globals.Inventory.PreSalesReportrowwiseData.get("SalesEstimationClosed");
		Globals.Inventory.Batch2 = Globals.Inventory.PreSalesReportrowwiseData.get("SalesEstimationCancel");
		Globals.Inventory.Batch3 = Globals.Inventory.PreSalesReportrowwiseData.get("SalesOrderPending");
		Globals.Inventory.Batch4 = Globals.Inventory.PreSalesReportrowwiseData.get("SalesOrderClosed");
		Globals.Inventory.Batch5 = Globals.Inventory.PreSalesReportrowwiseData.get("SalesorderCancel");
		Globals.Inventory.Batch6 = Globals.Inventory.PreSalesReportrowwiseData.get("MobileOrderPending");
		Globals.Inventory.Batch7 = Globals.Inventory.PreSalesReportrowwiseData.get("MobileOrderClosed");
		Globals.Inventory.Batch8 = Globals.Inventory.PreSalesReportrowwiseData.get("MobileOrderCancel");
		Globals.Inventory.Batch9 = Globals.Inventory.PreSalesReportrowwiseData.get("Summary");
		Globals.Inventory.Batch10 = Globals.Inventory.PreSalesReportrowwiseData.get("Detail");
		Globals.Inventory.Batch = Globals.Inventory.PreSalesReportrowwiseData.get("ByDate");
		
	    Globals.Inventory.FromDate = Globals.Inventory.PreSalesReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.PreSalesReportrowwiseData.get("ToDate");
	}

	@Then("I fill new PreSalesReport data page using excel data")
	public void i_fill_new_PreSalesReport_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.SalesEstimationClosed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.SalesEstimationCancel_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.SalesOrderPending_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.SalesOrderClosed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.SalesorderCancel_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.MobileOrderPending_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.MobileOrderClosed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.MobileOrderCancel_String).click();
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
			//webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtMobileNo\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
			terpage.terminal_waitClearEnterText_css(icp.Terminal_String, Globals.Inventory.Terminal);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Terminal).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Customer)) {
			terpage.terminal_waitClearEnterText_css(icp.Customer_String, Globals.Inventory.Customer);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Customer, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Customer).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDatePre\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDatePre\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_checkBox_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.Detail_String).click();
		}
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
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
