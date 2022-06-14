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

public class QuickSalesReport  extends PageObject {
	QiuckSalesReportfield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public QuickSalesReport(QiuckSalesReportfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the QuickSalesReport sheet data to map")
	public void i_load_the_QuickSalesReport_sheet_data_to_map() {
		Globals.Inventory.QuickSalesReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME118);
	}

	@Then("I load the rowise QuickSalesReport data for {string} rowname")
	public void i_load_the_rowise_QuickSalesReport_data_for_rowname(String row_name) {
		Globals.Inventory.QuickSalesReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.QuickSalesReportSheetData, row_name);

		System.out.println(Globals.Inventory.QuickSalesReportrowwiseData);
	}

	@Then("I update value to the QuickSalesReport page global Variables")
	public void i_update_value_to_the_QuickSalesReport_page_global_Variables() {
		Globals.Inventory.ItemCode = Globals.Inventory.QuickSalesReportrowwiseData.get("Inventory");
		Globals.Inventory.Location = Globals.Inventory.QuickSalesReportrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.QuickSalesReportrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.QuickSalesReportrowwiseData.get("Category");
		Globals.Inventory.SubCategory = Globals.Inventory.QuickSalesReportrowwiseData.get("SubCategory");
		Globals.Inventory.Brand = Globals.Inventory.QuickSalesReportrowwiseData.get("Brand");
		Globals.Inventory.Vendor = Globals.Inventory.QuickSalesReportrowwiseData.get("Vendor");
		Globals.Inventory.Class = Globals.Inventory.QuickSalesReportrowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.QuickSalesReportrowwiseData.get("SubClass");
		Globals.Inventory.Floorcode = Globals.Inventory.QuickSalesReportrowwiseData.get("Floorcode");
		Globals.Inventory.Manufacture = Globals.Inventory.QuickSalesReportrowwiseData.get("Manufacture");
		Globals.Inventory.Origin = Globals.Inventory.QuickSalesReportrowwiseData.get("Origin");
		Globals.Inventory.BatchNo = Globals.Inventory.QuickSalesReportrowwiseData.get("BatchNo");
		Globals.Inventory.Cashier = Globals.Inventory.QuickSalesReportrowwiseData.get("Cashier");
		Globals.Inventory.Terminal = Globals.Inventory.QuickSalesReportrowwiseData.get("Terminal");
		Globals.Inventory.Paymode = Globals.Inventory.QuickSalesReportrowwiseData.get("Paymode");
		//Globals.Inventory.GidNo = Globals.Inventory.QuickSalesReportrowwiseData.get("GidNo");
		
		
		
		

		Globals.Inventory.Batch1 = Globals.Inventory.QuickSalesReportrowwiseData.get("CategoryWiseSales");
		Globals.Inventory.Batch2 = Globals.Inventory.QuickSalesReportrowwiseData.get("BrandWiseSales");
		Globals.Inventory.Batch3 = Globals.Inventory.QuickSalesReportrowwiseData.get("ClassWiseSales");
		Globals.Inventory.Batch4 = Globals.Inventory.QuickSalesReportrowwiseData.get("ShelfWiseSale");
		Globals.Inventory.Batch5 = Globals.Inventory.QuickSalesReportrowwiseData.get("VendorWiseSale");
		Globals.Inventory.Batch6 = Globals.Inventory.QuickSalesReportrowwiseData.get("ItemWiseSale");
		Globals.Inventory.Batch7 = Globals.Inventory.QuickSalesReportrowwiseData.get("InvoiceWiseSalesSummary");
		Globals.Inventory.Batch8 = Globals.Inventory.QuickSalesReportrowwiseData.get("InvoiceWiseSalesDetail");
		Globals.Inventory.Batch9 = Globals.Inventory.QuickSalesReportrowwiseData.get("PaymodeWiseSales");
		Globals.Inventory.Batch10 = Globals.Inventory.QuickSalesReportrowwiseData.get("InvoiceWisePaymodeWiseSales");
		Globals.Inventory.Batch11 = Globals.Inventory.QuickSalesReportrowwiseData.get("TotalSales");
		Globals.Inventory.Batch12 = Globals.Inventory.QuickSalesReportrowwiseData.get("HourlySales");
		Globals.Inventory.Batch13 = Globals.Inventory.QuickSalesReportrowwiseData.get("SessionReportOn");
		Globals.Inventory.Batch14 = Globals.Inventory.QuickSalesReportrowwiseData.get("TerminalWiseSalesDetail");
		Globals.Inventory.Batch15 = Globals.Inventory.QuickSalesReportrowwiseData.get("CashierandPaymodeWiseSales");
		Globals.Inventory.Batch16 = Globals.Inventory.QuickSalesReportrowwiseData.get("SellingPriceWiseNonBatchSales");
		Globals.Inventory.Batch17 = Globals.Inventory.QuickSalesReportrowwiseData.get("BatchWiseSales");
		Globals.Inventory.Batch18 = Globals.Inventory.QuickSalesReportrowwiseData.get("NonBatchWiseSales");
		Globals.Inventory.Batch19 = Globals.Inventory.QuickSalesReportrowwiseData.get("TerminalandPaymodeWiseSales");
		Globals.Inventory.Batch20 = Globals.Inventory.QuickSalesReportrowwiseData.get("CashCounterandPaymodeSales");
		Globals.Inventory.Batch21 = Globals.Inventory.QuickSalesReportrowwiseData.get("InvoiceWisePaymodeWiseSalesView");
	    Globals.Inventory.Batch22 = Globals.Inventory.QuickSalesReportrowwiseData.get("WeightScaleBalanceQty");
	    Globals.Inventory.Batch23 = Globals.Inventory.QuickSalesReportrowwiseData.get("Summary");
	    Globals.Inventory.Batch24 = Globals.Inventory.QuickSalesReportrowwiseData.get("Detail");
		Globals.Inventory.Date = Globals.Inventory.QuickSalesReportrowwiseData.get("Date");
		Globals.Inventory.Batch26 = Globals.Inventory.QuickSalesReportrowwiseData.get("Month");
		Globals.Inventory.Batch = Globals.Inventory.QuickSalesReportrowwiseData.get("ByDate");
		Globals.Inventory.Batch25 = Globals.Inventory.QuickSalesReportrowwiseData.get("None");
	    Globals.Inventory.FromDate = Globals.Inventory.QuickSalesReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.QuickSalesReportrowwiseData.get("ToDate");
	}

	@Then("I fill new QuickSalesReport data page using excel data")
	public void i_fill_new_QuickSalesReport_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.CategoryWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.BrandWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.ClassWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.ShelfWiseSale_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.VendorWiseSale_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.ItemWiseSale_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.InvoiceWiseSalesSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.InvoiceWiseSalesDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.PaymodeWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.InvoiceWisePaymodeWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.TotalSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_radioButton_element(icp.HourlySales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			terPage.get_radioButton_element(icp.SessionReportOn_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
			terPage.get_radioButton_element(icp.TerminalWiseSalesDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
			terPage.get_radioButton_element(icp.CashierandPaymodeWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
			terPage.get_radioButton_element(icp.SellingPriceWiseNonBatchSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch17)) {
			terPage.get_radioButton_element(icp.BatchWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch18)) {
			terPage.get_radioButton_element(icp.NonBatchWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch19)) {
			terPage.get_radioButton_element(icp.TerminalandPaymodeWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch20)) {
			terPage.get_radioButton_element(icp.CashCounterandPaymodeSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch21)) {
			terPage.get_radioButton_element(icp.InvoiceWisePaymodeWiseSalesView1_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch22)) {
			terPage.get_radioButton_element(icp.WeightScaleBalanceQty_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terpage.terminal_waitClearEnterText_css(icp.Inventory_String, Globals.Inventory.ItemCode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
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
			terpage.terminal_waitClearEnterText_css(icp.Class_String, Globals.Inventory.Class);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Class).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubClass)) {
			terpage.terminal_waitClearEnterText_css(icp.SubClass_String, Globals.Inventory.SubClass);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubClass, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.SubClass).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
			terpage.terminal_waitClearEnterText_css(icp.Floor_String, Globals.Inventory.Floorcode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
			terpage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Manufacture).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Origin)) {
			terpage.terminal_waitClearEnterText_css(icp.Origin_String, Globals.Inventory.Origin);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Origin, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Origin).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BatchNo)) {
			terpage.terminal_waitClearEnterText_css(icp.BatchNo_String, Globals.Inventory.BatchNo);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.BatchNo, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.BatchNo).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Paymode)) {
			terpage.terminal_waitClearEnterText_css(icp.Paymode_String, Globals.Inventory.Paymode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Paymode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Paymode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.get_radioButton_element(icp.Date_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch26)) {
			terPage.get_checkBox_element(icp.Month_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch25)) {
			terPage.get_checkBox_element(icp.None_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch23)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch24)) {
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
