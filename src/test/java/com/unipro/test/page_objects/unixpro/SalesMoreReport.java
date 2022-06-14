package com.unipro.test.page_objects.unixpro;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class SalesMoreReport extends PageObject {
	SalesMoreReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public SalesMoreReport(SalesMoreReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the SalesMoreReport sheet data to map")
	public void i_load_the_SalesMoreReport_sheet_data_to_map() {
		Globals.Inventory.SalesMoreReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME119);
	}

	@Then("I load the rowise SalesMoreReport data for {string} rowname")
	public void i_load_the_rowise_SalesMoreReport_data_for_rowname(String row_name) {
		Globals.Inventory.SalesMoreReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SalesMoreReportSheetData, row_name);

		System.out.println(Globals.Inventory.SalesMoreReportrowwiseData);
	}

	@Then("I update value to the SalesMoreReport page global Variables")
	public void i_update_value_to_the_SalesMoreReport_page_global_Variables() {
		Globals.Inventory.ItemCode = Globals.Inventory.SalesMoreReportrowwiseData.get("Inventory");
		Globals.Inventory.Location = Globals.Inventory.SalesMoreReportrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.SalesMoreReportrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.SalesMoreReportrowwiseData.get("Category");
		Globals.Inventory.SubCategory = Globals.Inventory.SalesMoreReportrowwiseData.get("SubCategory");
		Globals.Inventory.Brand = Globals.Inventory.SalesMoreReportrowwiseData.get("Brand");
		Globals.Inventory.Vendor = Globals.Inventory.SalesMoreReportrowwiseData.get("Vendor");
		Globals.Inventory.Cashier = Globals.Inventory.SalesMoreReportrowwiseData.get("Cashier");
		Globals.Inventory.Class = Globals.Inventory.SalesMoreReportrowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.SalesMoreReportrowwiseData.get("SubClass");
		Globals.Inventory.Floorcode = Globals.Inventory.SalesMoreReportrowwiseData.get("Floorcode");
		Globals.Inventory.Terminal = Globals.Inventory.SalesMoreReportrowwiseData.get("Terminal");
		Globals.Inventory.Customer = Globals.Inventory.SalesMoreReportrowwiseData.get("Customer");
		Globals.Inventory.SalesMan = Globals.Inventory.SalesMoreReportrowwiseData.get("SalesMan");
		
		Globals.Inventory.Batch1 = Globals.Inventory.SalesMoreReportrowwiseData.get("HomeDeliverySalesPending");
		Globals.Inventory.Batch2 = Globals.Inventory.SalesMoreReportrowwiseData.get("HomeDeliverySalesClosed");
		Globals.Inventory.Batch3 = Globals.Inventory.SalesMoreReportrowwiseData.get("HomeDeliveryProcessDetail");
		Globals.Inventory.Batch4 = Globals.Inventory.SalesMoreReportrowwiseData.get("PackageInventorySales");
		Globals.Inventory.Batch5 = Globals.Inventory.SalesMoreReportrowwiseData.get("CashierWiseSales");
		Globals.Inventory.Batch6 = Globals.Inventory.SalesMoreReportrowwiseData.get("SalesManWiseSales");
		Globals.Inventory.Batch7 = Globals.Inventory.SalesMoreReportrowwiseData.get("SalesManCommission");
		Globals.Inventory.Batch8 = Globals.Inventory.SalesMoreReportrowwiseData.get("FloorWiseSales");
		Globals.Inventory.Batch9 = Globals.Inventory.SalesMoreReportrowwiseData.get("ChequeSales");
		Globals.Inventory.Batch10 = Globals.Inventory.SalesMoreReportrowwiseData.get("SalesHoldBillCount");
		Globals.Inventory.Batch11 = Globals.Inventory.SalesMoreReportrowwiseData.get("SalesPromotionItemList");
		Globals.Inventory.Batch12 = Globals.Inventory.SalesMoreReportrowwiseData.get("TransferInandSoldQty");
		Globals.Inventory.Batch13 = Globals.Inventory.SalesMoreReportrowwiseData.get("ParentChildSales");
		Globals.Inventory.Batch14 = Globals.Inventory.SalesMoreReportrowwiseData.get("BillRange");
		
		Globals.Inventory.Batch15 = Globals.Inventory.SalesMoreReportrowwiseData.get("PurFromDate");
		Globals.Inventory.Batch16 = Globals.Inventory.SalesMoreReportrowwiseData.get("PurToDate");
		Globals.Inventory.Batch17 = Globals.Inventory.SalesMoreReportrowwiseData.get("SalFromDate");
		Globals.Inventory.Batch18 = Globals.Inventory.SalesMoreReportrowwiseData.get("SalToDate");
		 Globals.Inventory.Batch23 = Globals.Inventory.SalesMoreReportrowwiseData.get("Summary");
		    Globals.Inventory.Batch24 = Globals.Inventory.SalesMoreReportrowwiseData.get("Detail");
			Globals.Inventory.Date = Globals.Inventory.SalesMoreReportrowwiseData.get("Date");
			Globals.Inventory.Batch25 = Globals.Inventory.SalesMoreReportrowwiseData.get("Month");
			Globals.Inventory.Batch = Globals.Inventory.SalesMoreReportrowwiseData.get("ByDate");
			Globals.Inventory.Batch26 = Globals.Inventory.SalesMoreReportrowwiseData.get("None");
		    Globals.Inventory.FromDate = Globals.Inventory.SalesMoreReportrowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.SalesMoreReportrowwiseData.get("ToDate");
	}

	@Then("I fill new SalesMoreReport data page using excel data")
	public void i_fill_new_SalesMoreReport_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.HomeDeliverySalesPending_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.HomeDeliverySalesClosed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.HomeDeliveryProcessDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.PackageInventorySales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.CashierWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.SalesManWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.SalesManCommission_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.FloorWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.ChequeSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.SalesHoldBillCount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.SalesPromotionItemList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_radioButton_element(icp.TransferInandSoldQty_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			terPage.get_radioButton_element(icp.ParentChildSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
			terPage.get_radioButton_element(icp.BillRange_String).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Cashier)) {
			terpage.terminal_waitClearEnterText_css(icp.Cashier_String, Globals.Inventory.Cashier);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Cashier, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Cashier).click();
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
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesMan)) {
			terpage.terminal_waitClearEnterText_css(icp.SalesMan_String, Globals.Inventory.SalesMan);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.SalesMan, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.SalesMan).click();
		}
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDateMore\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDateMore\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch23)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch24)) {
			terPage.get_radioButton_element(icp.Detail_String).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.get_radioButton_element(icp.Date_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch25)) {
			terPage.get_radioButton_element(icp.Month_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch26)) {
			terPage.get_radioButton_element(icp.None_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_checkBox_element(icp.ByDate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
			terpage.terminal_waitClearEnterText_css(icp.PurFromDate_String, Globals.Inventory.Batch15);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtPurchaseFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
			terpage.terminal_waitClearEnterText_css(icp.PurToDate_String, Globals.Inventory.Batch16);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtPurchaseToDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch17)) {
			terpage.terminal_waitClearEnterText_css(icp.SalFromDate_String, Globals.Inventory.Batch17);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtSalFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch18)) {
			terpage.terminal_waitClearEnterText_css(icp.SaleToDate_String, Globals.Inventory.Batch18);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtSalToDate\"]")).sendKeys(Keys.TAB);
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
