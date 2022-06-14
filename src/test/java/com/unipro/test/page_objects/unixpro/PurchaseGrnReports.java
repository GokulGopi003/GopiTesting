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

public class PurchaseGrnReports  extends PageObject {
	PurchaseGrnTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public PurchaseGrnReports(PurchaseGrnTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the PuchaseGRNReports sheet data to map")
	public void i_load_the_PuchaseGRNReports_sheet_data_to_map() {
		Globals.Inventory.PuchaseGRNReportsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME114);
	}

	@Then("I load the rowise PuchaseGRNReports data for {string} rowname")
	public void i_load_the_rowise_PuchaseGRNReports_data_for_rowname(String row_name) {
		Globals.Inventory.PuchaseGRNReportsrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PuchaseGRNReportsSheetData, row_name);

		System.out.println(Globals.Inventory.PuchaseGRNReportsrowwiseData);
	}

	@Then("I update value to the PuchaseGRNReports page global Variables")
	public void i_update_value_to_the_PuchaseGRNReports_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Brand");
		Globals.Inventory.SubCategory = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("SubCategory");
		Globals.Inventory.GidNo = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("GidNo");
		Globals.Inventory.Manufacture = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Manufacture");
		Globals.Inventory.Floorcode = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Floorcode");
		Globals.Inventory.Class = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("SubClass");
		Globals.Inventory.Location = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Location");
		Globals.Inventory.Tax = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Tax");
		Globals.Inventory.ItemCode = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("ItemCode");
		Globals.Inventory.User = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("User");
		
		Globals.Inventory.Batch1 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("DateWisePurchaseSummary");
		Globals.Inventory.Batch2 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("DateWisePurchaseDetail");
		Globals.Inventory.Batch3 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("DepartmentWisePurchase");
		Globals.Inventory.Batch4 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("CategoryWisePurchase");
		Globals.Inventory.Batch5 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("SubCategoryWise");
		Globals.Inventory.Batch6 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("BrandWise");
		Globals.Inventory.Batch7 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("ClassWise");
		Globals.Inventory.Batch8 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("VendorWisePurchase");
		Globals.Inventory.Batch9 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("VendorWiseSchemeDiscount");
		Globals.Inventory.Batch10 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("InventoryWiseGrn");
		Globals.Inventory.Batch11 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("GrnHoldPending");
		Globals.Inventory.Batch12 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("CancelledGrnSummary");
		Globals.Inventory.Batch13 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("CancelledGrnDeatail");
		Globals.Inventory.Batch14 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("UserWiseGrnCount");
		Globals.Inventory.Batch15 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("DateWisePurchaseReturnSumary");
		Globals.Inventory.Batch16 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("DateWisePurchaseReturnDetail");
		Globals.Inventory.Batch17 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("CostChange");
		Globals.Inventory.Batch18 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("GRNPoComparision");
		Globals.Inventory.Batch19 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("GaDeleteLog");
		Globals.Inventory.Batch20 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("WeighedBasedConversion");
		Globals.Inventory.Date = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Date");
        Globals.Inventory.Batch21 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("Month");
        Globals.Inventory.Batch22 = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("InvoiceDate");
		Globals.Inventory.Batch = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("GrnDate");
	    Globals.Inventory.FromDate = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.PuchaseGRNReportsrowwiseData.get("ToDate");
	}

	@Then("I fill new PuchaseGRNReports data page using excel data")
	public void i_fill_new_PuchaseGRNReports_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.DateWisePurchaseSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.DateWisePurchaseDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.DepartmentWisePurchase_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.CategoryWisePurchase_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.SubCategoryWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.BrandWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.ClassWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.VendorWisePurchase_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.VendorWiseSchemeDiscount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.InventoryWiseGrn_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.GrnHoldPending_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_radioButton_element(icp.CancelledGrnSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			terPage.get_radioButton_element(icp.CancelledGrnDeatail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
			terPage.get_radioButton_element(icp.UserWiseGrnCount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
			terPage.get_radioButton_element(icp.DateWisePurchaseReturnSumary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
			terPage.get_radioButton_element(icp.DateWisePurchaseReturnDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch17)) {
			terPage.get_radioButton_element(icp.CostChange_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch18)) {
			terPage.get_radioButton_element(icp.GRNPoComparision_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch19)) {
			terPage.get_radioButton_element(icp.GaDeleteLog_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch20)) {
			terPage.get_radioButton_element(icp.WeighedBasedConversion_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GidNo)) {
			terpage.terminal_waitClearEnterText_css(icp.GidNo_String, Globals.Inventory.GidNo);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.GidNo, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.GidNo).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tax)) {
			terpage.terminal_waitClearEnterText_css(icp.Tax_String, Globals.Inventory.Tax);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Tax, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Tax).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
			terpage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Manufacture).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
			terpage.terminal_waitClearEnterText_css(icp.Floor_String, Globals.Inventory.Floorcode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.User)) {
			terpage.terminal_waitClearEnterText_css(icp.User_String, Globals.Inventory.User);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.User, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.User).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDatePurchase\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDatePurchase\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.get_radioButton_element(icp.Date_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch21)) {
			terPage.get_radioButton_element(icp.Month_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch22)) {
			terPage.get_checkBox_element(icp.InvoiceDate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_checkBox_element(icp.GrnDate_String).click();
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
