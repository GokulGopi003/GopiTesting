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

public class StockReport extends PageObject {
	StockReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public StockReport(StockReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the StockReports sheet data to map")
	public void i_load_the_StockReports_sheet_data_to_map() {
		Globals.Inventory.StockReportsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME128);
	    	}

	@Then("I load the rowise StockReports data for {string} rowname")
	public void i_load_the_rowise_StockReports_data_for_rowname(String row_name) {
		Globals.Inventory.StockReportsrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.StockReportsSheetData, row_name);

		System.out.println(Globals.Inventory.StockReportsrowwiseData);
	   	}

	@Then("I update value to the StockReports page global Variables")
	public void i_update_value_to_the_StockReports_page_global_Variables() {
		Globals.Inventory.ItemCode = Globals.Inventory.StockReportsrowwiseData.get("Inventory");
		Globals.Inventory.Location = Globals.Inventory.StockReportsrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.StockReportsrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.StockReportsrowwiseData.get("Category");
		Globals.Inventory.SubCategory = Globals.Inventory.StockReportsrowwiseData.get("SubCategory");
		Globals.Inventory.Brand = Globals.Inventory.StockReportsrowwiseData.get("Brand");
		Globals.Inventory.Vendor = Globals.Inventory.StockReportsrowwiseData.get("Vendor");
		Globals.Inventory.Class = Globals.Inventory.StockReportsrowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.StockReportsrowwiseData.get("SubClass");
		Globals.Inventory.WareHouse = Globals.Inventory.StockReportsrowwiseData.get("WareHouse");
		Globals.Inventory.Floorcode = Globals.Inventory.StockReportsrowwiseData.get("Floorcode");
		Globals.Inventory.Origin = Globals.Inventory.StockReportsrowwiseData.get("Company");
		Globals.Inventory.Section = Globals.Inventory.StockReportsrowwiseData.get("Section");
		Globals.Inventory.BatchNo = Globals.Inventory.StockReportsrowwiseData.get("BatchNo");
		Globals.Inventory.Manufacture = Globals.Inventory.StockReportsrowwiseData.get("Manufacture");
		Globals.Inventory.Zone = Globals.Inventory.StockReportsrowwiseData.get("StockAdjNo");
		Globals.Inventory.Active = Globals.Inventory.StockReportsrowwiseData.get("StockAdjType");
		
		Globals.Inventory.Cashier = Globals.Inventory.StockReportsrowwiseData.get("StockTakeId");
		Globals.Inventory.Terminal = Globals.Inventory.StockReportsrowwiseData.get("Merchandise");
		Globals.Inventory.Paymode = Globals.Inventory.StockReportsrowwiseData.get("DistributionNo");
		Globals.Inventory.GidNo = Globals.Inventory.StockReportsrowwiseData.get("BillNo");
		Globals.Inventory.ReasonCode = Globals.Inventory.StockReportsrowwiseData.get("BinNo");
		Globals.Inventory.ItemDesc = Globals.Inventory.StockReportsrowwiseData.get("StyleCode");
		
		
		
		

		Globals.Inventory.Batch1 = Globals.Inventory.StockReportsrowwiseData.get("BatchWise");
		Globals.Inventory.Batch2 = Globals.Inventory.StockReportsrowwiseData.get("DepartmentWise");
		Globals.Inventory.Batch3 = Globals.Inventory.StockReportsrowwiseData.get("CategoryWise");
		Globals.Inventory.Batch4 = Globals.Inventory.StockReportsrowwiseData.get("SubCategoryWise");
		Globals.Inventory.Batch5 = Globals.Inventory.StockReportsrowwiseData.get("BrandWise");
		Globals.Inventory.Batch6 = Globals.Inventory.StockReportsrowwiseData.get("StockAdjSummary");
		Globals.Inventory.Batch7 = Globals.Inventory.StockReportsrowwiseData.get("StockAdjDetail");
		Globals.Inventory.Batch8 = Globals.Inventory.StockReportsrowwiseData.get("StockAdjCancelled");
		Globals.Inventory.Batch9 = Globals.Inventory.StockReportsrowwiseData.get("StockUpdate");
		Globals.Inventory.Batch10 = Globals.Inventory.StockReportsrowwiseData.get("NonBatchWiseStock");
		Globals.Inventory.Batch11 = Globals.Inventory.StockReportsrowwiseData.get("LocationWiseStock");
		Globals.Inventory.Batch12 = Globals.Inventory.StockReportsrowwiseData.get("NonMovingItem");
		Globals.Inventory.Batch13 = Globals.Inventory.StockReportsrowwiseData.get("DistributionSummary");
		Globals.Inventory.Batch14 = Globals.Inventory.StockReportsrowwiseData.get("DistributionDetailed");
		Globals.Inventory.Batch15 = Globals.Inventory.StockReportsrowwiseData.get("DistributionDeleted");
		Globals.Inventory.Batch16 = Globals.Inventory.StockReportsrowwiseData.get("BinBasedSummary");
		Globals.Inventory.Batch17 = Globals.Inventory.StockReportsrowwiseData.get("RefillingQtyDetail");
		Globals.Inventory.Batch18 = Globals.Inventory.StockReportsrowwiseData.get("RefillingReport");
		Globals.Inventory.Batch19 = Globals.Inventory.StockReportsrowwiseData.get("MinReorderLevelQty");
		Globals.Inventory.Batch20 = Globals.Inventory.StockReportsrowwiseData.get("StyleCodeReport");
		
		Globals.Inventory.Batch21 = Globals.Inventory.StockReportsrowwiseData.get("ByDate");
	    Globals.Inventory.Batch22 = Globals.Inventory.StockReportsrowwiseData.get("Positive");
	    Globals.Inventory.Batch23 = Globals.Inventory.StockReportsrowwiseData.get("Negative");
	    Globals.Inventory.Batch24 = Globals.Inventory.StockReportsrowwiseData.get("ZeroStock");
		//Globals.Inventory.Date = Globals.Inventory.StockReportsrowwiseData.get("Date");
		Globals.Inventory.Batch26 = Globals.Inventory.StockReportsrowwiseData.get("RefillingQtyDetail");
		Globals.Inventory.Batch27 = Globals.Inventory.StockReportsrowwiseData.get("Grouped");
	    Globals.Inventory.Batch28 = Globals.Inventory.StockReportsrowwiseData.get("SortByCode");
	    Globals.Inventory.Batch29 = Globals.Inventory.StockReportsrowwiseData.get("SortByNAme");
		//Globals.Inventory.Batch = Globals.Inventory.StockReportsrowwiseData.get("ByDate");
		Globals.Inventory.Batch25 = Globals.Inventory.StockReportsrowwiseData.get("BatchOnly");
	    Globals.Inventory.FromDate = Globals.Inventory.StockReportsrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.StockReportsrowwiseData.get("ToDate");
	}

	@Then("I fill new StockReports data page using excel data")
	public void i_fill_new_StockReports_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.BatchWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.DepartmentWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.CategoryWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.SubCategoryWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.BrandWise_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.StockAdjSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.StockAdjDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.StockAdjCancelled_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.StockUpdate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.NonBatchWiseStock_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.LocationWiseStock_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_radioButton_element(icp.NonMovingItem_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			terPage.get_radioButton_element(icp.DistributionSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
			terPage.get_radioButton_element(icp.DistributionDetailed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
			terPage.get_radioButton_element(icp.DistributionDeleted_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
			terPage.get_radioButton_element(icp.BinBasedSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch17)) {
			terPage.get_radioButton_element(icp.RefillingQtyDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch18)) {
			terPage.get_radioButton_element(icp.RefillingReport_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch19)) {
			terPage.get_radioButton_element(icp.MinReorderLevelQty_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch20)) {
			terPage.get_radioButton_element(icp.StyleCodeReport_String).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
			terpage.terminal_waitClearEnterText_css(icp.WareHouse_String, Globals.Inventory.WareHouse);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
			terpage.terminal_waitClearEnterText_css(icp.Floor_String, Globals.Inventory.Floorcode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Origin)) {
			terpage.terminal_waitClearEnterText_css(icp.Company_String, Globals.Inventory.Origin);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Origin, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Origin).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
			terpage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Section).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BatchNo)) {
			terpage.terminal_waitClearEnterText_css(icp.BatchNo_String, Globals.Inventory.BatchNo);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.BatchNo, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.BatchNo).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
			terpage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Manufacture).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Zone)) {
			terpage.terminal_waitClearEnterText_css(icp.StockAdjNo_String, Globals.Inventory.Zone);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Zone, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Zone).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Active)) {
			terpage.terminal_waitClearEnterText_css(icp.StockAdjType_String, Globals.Inventory.Active);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Active, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Active).click();
		}
		
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Cashier)) {
			terpage.terminal_waitClearEnterText_css(icp.StockTakeId_String, Globals.Inventory.Cashier);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Cashier, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Cashier).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
			terpage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Terminal);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Terminal).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Paymode)) {
			terpage.terminal_waitClearEnterText_css(icp.DistributionNo_String, Globals.Inventory.Paymode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Paymode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Paymode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GidNo)) {
			terpage.terminal_waitClearEnterText_css(icp.BillNo_String, Globals.Inventory.GidNo);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.GidNo, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.GidNo).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ReasonCode)) {
			terpage.terminal_waitClearEnterText_css(icp.BinNo_String, Globals.Inventory.ReasonCode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ReasonCode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ReasonCode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemDesc)) {
			terpage.terminal_waitClearEnterText_css(icp.StyleCode_String, Globals.Inventory.ItemDesc);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemDesc, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ItemDesc).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDateStock\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDateStock\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch21)) {
			terPage.get_checkBox_element(icp.ByDate_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch22)) {
			terPage.get_checkBox_element(icp.Positive_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch23)) {
			terPage.get_checkBox_element(icp.Negative_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch24)) {
			terPage.get_checkBox_element(icp.ZeroStock_String).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch25)) {
			terPage.get_checkBox_element(icp.BatchOnly_String).click();
		}
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch26)) {
			terPage.get_radioButton_element(icp.RefillingQtyDetail_String).click();
		}*/
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch27)) {
			terPage.get_radioButton_element(icp.Grouped_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch28)) {
			terPage.get_radioButton_element(icp.SortByCode_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch29)) {
			terPage.get_radioButton_element(icp.SortByName_String).click();
		}
		
	}


}
