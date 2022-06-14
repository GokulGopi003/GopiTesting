package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class PromotionReport extends PageObject {
	PromotionReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public PromotionReport(PromotionReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the PromotionReports sheet data to map")
	public void i_load_the_PromotionReports_sheet_data_to_map() {
		Globals.Inventory.PromotionReportsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME127);
	}

	@Then("I load the rowise PromotionReports data for {string} rowname")
	public void i_load_the_rowise_PromotionReports_data_for_rowname(String row_name) {
		Globals.Inventory.PromotionReportsrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PromotionReportsSheetData, row_name);

		System.out.println(Globals.Inventory.PromotionReportsrowwiseData);
	}

	@Then("I update value to the PromotionReports page global Variables")
	public void i_update_value_to_the_PromotionReports_page_global_Variables() {
		Globals.Inventory.ItemCode = Globals.Inventory.PromotionReportsrowwiseData.get("Inventory");
		Globals.Inventory.Location = Globals.Inventory.PromotionReportsrowwiseData.get("Location");
        Globals.Inventory.Department = Globals.Inventory.PromotionReportsrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.PromotionReportsrowwiseData.get("Category");
		Globals.Inventory.SubCategory = Globals.Inventory.PromotionReportsrowwiseData.get("SubCategory");
	    Globals.Inventory.Brand = Globals.Inventory.PromotionReportsrowwiseData.get("Brand");
		Globals.Inventory.Class = Globals.Inventory.PromotionReportsrowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.PromotionReportsrowwiseData.get("SubClass");
	    Globals.Inventory.Vendor = Globals.Inventory.PromotionReportsrowwiseData.get("Vendor");
		Globals.Inventory.Cashier = Globals.Inventory.PromotionReportsrowwiseData.get("Cashier");
		Globals.Inventory.Terminal = Globals.Inventory.PromotionReportsrowwiseData.get("Terminal");
		Globals.Inventory.Batch1 = Globals.Inventory.PromotionReportsrowwiseData.get("DepartmentWiseSales");
		Globals.Inventory.Batch2 = Globals.Inventory.PromotionReportsrowwiseData.get("CategoryWiseSales");
		Globals.Inventory.Batch3 = Globals.Inventory.PromotionReportsrowwiseData.get("BrandWiseSales");
		Globals.Inventory.Batch4 = Globals.Inventory.PromotionReportsrowwiseData.get("FreeItemSale");
		Globals.Inventory.Batch5 = Globals.Inventory.PromotionReportsrowwiseData.get("CouponIssuedList");
		Globals.Inventory.Batch6 = Globals.Inventory.PromotionReportsrowwiseData.get("DiscountCouponUsedList");
		Globals.Inventory.Batch7 = Globals.Inventory.PromotionReportsrowwiseData.get("DiscountCouponExpiredList");
		Globals.Inventory.Batch8 = Globals.Inventory.PromotionReportsrowwiseData.get("CoupenUnusedList");
		Globals.Inventory.Batch9 = Globals.Inventory.PromotionReportsrowwiseData.get("DuplicateCouponReprint");
		Globals.Inventory.Batch10 = Globals.Inventory.PromotionReportsrowwiseData.get("DiscountPromotionList");
		Globals.Inventory.Batch11 = Globals.Inventory.PromotionReportsrowwiseData.get("FreePromotionList");
		Globals.Inventory.Batch12 = Globals.Inventory.PromotionReportsrowwiseData.get("PromotionMaster");
		Globals.Inventory.Batch13 = Globals.Inventory.PromotionReportsrowwiseData.get("IsActive");
		Globals.Inventory.Batch14 = Globals.Inventory.PromotionReportsrowwiseData.get("CurrentDate");
		Globals.Inventory.Batch15 = Globals.Inventory.PromotionReportsrowwiseData.get("Revoke");
		Globals.Inventory.Batch16 = Globals.Inventory.PromotionReportsrowwiseData.get("Expired");
		Globals.Inventory.Batch17 = Globals.Inventory.PromotionReportsrowwiseData.get("PromotionExpired");
		Globals.Inventory.Batch = Globals.Inventory.PromotionReportsrowwiseData.get("ByDate");
		
	    Globals.Inventory.FromDate = Globals.Inventory.PromotionReportsrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.PromotionReportsrowwiseData.get("ToDate");
	}

	@Then("I fill new PromotionReports data page using excel data")
	public void i_fill_new_PromotionReports_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.DepartmentWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.CategoryWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.BrandWiseSales_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.FreeItemSale_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.CouponIssuedList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.DiscountCouponUsedList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.DiscountCouponExpiredList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.CoupenUnusedList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.DuplicateCouponReprint_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.DiscountPromotionList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.FreePromotionList_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_radioButton_element(icp.PromotionMaster_String).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
			terpage.terminal_waitClearEnterText_css(icp.TerminalString, Globals.Inventory.Terminal);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Terminal).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDatePromo\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDatePromo\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			terPage.get_checkBox_element(icp.IsActive_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
			terPage.get_radioButton_element(icp.CurrentDate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
			terPage.get_radioButton_element(icp.Revoke_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
			terPage.get_radioButton_element(icp.Expired_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch17)) {
			terpage.terminal_waitClearEnterText_css(icp.PromotionExpired_String, Globals.Inventory.Batch17);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.Batch17, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.Batch17).click();
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
