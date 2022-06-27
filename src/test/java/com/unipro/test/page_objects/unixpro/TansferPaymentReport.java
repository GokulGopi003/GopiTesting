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

public class TansferPaymentReport extends PageObject {
	TransferPaymenttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public TansferPaymentReport(TransferPaymenttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();
	}
	@Then("I load the TansferPaymentReport sheet data to map")
	public void i_load_the_TansferPaymentReport_sheet_data_to_map() {
		Globals.Inventory.TansferPaymentReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME137);
	}

	@Then("I load the rowise TansferPaymentReport data for {string} rowname")
	public void i_load_the_rowise_TansferPaymentReport_data_for_rowname(String row_name) {
		Globals.Inventory.TansferPaymentReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.TansferPaymentReportSheetData, row_name);

		System.out.println(Globals.Inventory.TansferPaymentReportrowwiseData);
	    	}

	@Then("I update value to the TansferPaymentReport page global Variables")
	public void i_update_value_to_the_TansferPaymentReport_page_global_Variables() {
		Globals.Inventory.Batch = Globals.Inventory.TansferPaymentReportrowwiseData.get("GoodReceiveSummary");
		Globals.Inventory.Batch1 = Globals.Inventory.TansferPaymentReportrowwiseData.get("GoodReceiveSupplierWise");
		Globals.Inventory.Batch2 = Globals.Inventory.TansferPaymentReportrowwiseData.get("GoodReceivePackageWise");
		
		Globals.Inventory.Department = Globals.Inventory.TansferPaymentReportrowwiseData.get("Transport");
		Globals.Inventory.Vendor = Globals.Inventory.TansferPaymentReportrowwiseData.get("Supplier");
		Globals.Inventory.Payment = Globals.Inventory.TansferPaymentReportrowwiseData.get("PayType");
		Globals.Inventory.Brand = Globals.Inventory.TansferPaymentReportrowwiseData.get("LRNO");
		Globals.Inventory.SubCategory = Globals.Inventory.TansferPaymentReportrowwiseData.get("LRDATE");
		
		Globals.Inventory.FromDate = Globals.Inventory.TansferPaymentReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.TansferPaymentReportrowwiseData.get("ToDate");
		Globals.Inventory.Batch3 = Globals.Inventory.TansferPaymentReportrowwiseData.get("ByDate");
		Globals.Inventory.Batch4 = Globals.Inventory.TansferPaymentReportrowwiseData.get("LRDate");
	}

	@Then("I fill new TansferPaymentReport data page using excel data")
	public void i_fill_new_TansferPaymentReport_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.GoodReceiveSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.GoodReceiveSupplierWise).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.GoodReceivePackageWise).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.Transport_String, Globals.Inventory.Department);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Supplier_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Payment)) {
			terpage.terminal_waitClearEnterText_css(icp.Paytype_String, Globals.Inventory.Payment);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Payment, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Payment).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terpage.terminal_waitClearEnterText_css(icp.LRNo_String, Globals.Inventory.Brand);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtLRNo\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
			terpage.terminal_waitClearEnterText_css(icp.LRDate_String, Globals.Inventory.SubCategory);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtLRDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
						webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_checkBox_element(icp.ByDate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_checkBox_element(icp.Lrdate_String).click();
		}
	}



}
