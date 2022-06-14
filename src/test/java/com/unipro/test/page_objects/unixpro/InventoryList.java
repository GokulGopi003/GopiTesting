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

public class InventoryList extends PageObject {
	InventoryListtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public InventoryList(InventoryListtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();
	}
	@Then("I load the InventoryList sheet data to map")
	public void i_load_the_InventoryList_sheet_data_to_map() {
		Globals.Inventory.InventoryListSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME110);
	}

	@Then("I load the rowise InventoryList data for {string} rowname")
	public void i_load_the_rowise_InventoryList_data_for_rowname(String row_name) {
		Globals.Inventory.InventoryListrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.InventoryListSheetData, row_name);

		System.out.println(Globals.Inventory.InventoryListrowwiseData);
	}

	@Then("I update value to the InventoryList page global Variables")
	public void i_update_value_to_the_InventoryList_page_global_Variables() {
		Globals.Inventory.ItemCode = Globals.Inventory.InventoryListrowwiseData.get("Inventory");
		Globals.Inventory.Department = Globals.Inventory.InventoryListrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.InventoryListrowwiseData.get("Category");
		Globals.Inventory.SubCategory = Globals.Inventory.InventoryListrowwiseData.get("SubCategory");
		Globals.Inventory.Brand = Globals.Inventory.InventoryListrowwiseData.get("Brand");
		Globals.Inventory.Vendor = Globals.Inventory.InventoryListrowwiseData.get("Vendor");
		Globals.Inventory.Class = Globals.Inventory.InventoryListrowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.InventoryListrowwiseData.get("SubClass");
		Globals.Inventory.Floorcode = Globals.Inventory.InventoryListrowwiseData.get("Floor");
		Globals.Inventory.Section = Globals.Inventory.InventoryListrowwiseData.get("Section");
		Globals.Inventory.Location = Globals.Inventory.InventoryListrowwiseData.get("Location");
		//Globals.Inventory.ToDate = Globals.Inventory.InventoryListrowwiseData.get("ToDate");
		//Globals.Inventory.Category = Globals.Inventory.InventoryListrowwiseData.get("Category");
		
		//Globals.Inventory.Department = Globals.Inventory.InventoryListrowwiseData.get("Department");
		Globals.Inventory.FromDate = Globals.Inventory.InventoryListrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.InventoryListrowwiseData.get("ToDate");
		
		
		
		
		Globals.Inventory.Batch1 = Globals.Inventory.InventoryListrowwiseData.get("CompleteInfo");
		Globals.Inventory.Batch2 = Globals.Inventory.InventoryListrowwiseData.get("ItemWise");
		Globals.Inventory.Batch3 = Globals.Inventory.InventoryListrowwiseData.get("BatchWise");
		Globals.Inventory.Batch4 = Globals.Inventory.InventoryListrowwiseData.get("MarginNotSet");
		Globals.Inventory.Batch5 = Globals.Inventory.InventoryListrowwiseData.get("DepartmentWise");
		Globals.Inventory.Batch6 = Globals.Inventory.InventoryListrowwiseData.get("CategoryWise");
		Globals.Inventory.Batch7 = Globals.Inventory.InventoryListrowwiseData.get("BrandWise");
		Globals.Inventory.Batch8 = Globals.Inventory.InventoryListrowwiseData.get("VendorWise");
		Globals.Inventory.Batch9 = Globals.Inventory.InventoryListrowwiseData.get("BarcodeWise");
		Globals.Inventory.Batch10 = Globals.Inventory.InventoryListrowwiseData.get("BreakQty");
		Globals.Inventory.Batch11 = Globals.Inventory.InventoryListrowwiseData.get("DeActrivateItem");
		Globals.Inventory.Batch12 = Globals.Inventory.InventoryListrowwiseData.get("DeactivateBatch");
		
		
		
		Globals.Inventory.Batch13 = Globals.Inventory.InventoryListrowwiseData.get("MinQty");
		Globals.Inventory.Batch14 = Globals.Inventory.InventoryListrowwiseData.get("MaxQty");
		Globals.Inventory.Batch15 = Globals.Inventory.InventoryListrowwiseData.get("ItemNameChangeLog");
		Globals.Inventory.Batch16 = Globals.Inventory.InventoryListrowwiseData.get("PriceChange");
		Globals.Inventory.Batch17 = Globals.Inventory.InventoryListrowwiseData.get("BatchWiseInventory");
		Globals.Inventory.Batch18 = Globals.Inventory.InventoryListrowwiseData.get("ActivePromotion");
		Globals.Inventory.Batch19 = Globals.Inventory.InventoryListrowwiseData.get("ActivePromotionPrice");
		Globals.Inventory.Batch20 = Globals.Inventory.InventoryListrowwiseData.get("ActivePromotionFree");
		Globals.Inventory.Batch21 = Globals.Inventory.InventoryListrowwiseData.get("ExpiredItem");
		Globals.Inventory.Batch22 = Globals.Inventory.InventoryListrowwiseData.get("Netcost");
		Globals.Inventory.Batch23 = Globals.Inventory.InventoryListrowwiseData.get("ParentChild");
		
		Globals.Inventory.Batch = Globals.Inventory.InventoryListrowwiseData.get("ByDate");
		Globals.Inventory.Batch24 = Globals.Inventory.InventoryListrowwiseData.get("IsActive");
		Globals.Inventory.Batch25 = Globals.Inventory.InventoryListrowwiseData.get("VendorWise");
		Globals.Inventory.Batch26 = Globals.Inventory.InventoryListrowwiseData.get("Batchcount");
		Globals.Inventory.Batch27 = Globals.Inventory.InventoryListrowwiseData.get("ParentChild");
		Globals.Inventory.Batch28 = Globals.Inventory.InventoryListrowwiseData.get("DeactivateBatch");
		Globals.Inventory.Batch29 = Globals.Inventory.InventoryListrowwiseData.get("DeactivateBatch");
	}

	@Then("I fill new InventoryList data page using excel data")
	public void i_fill_new_InventoryList_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_radioButton_element(icp.CompleteInfo_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_radioButton_element(icp.ItemWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
				terPage.get_radioButton_element(icp.BatchWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
				terPage.get_radioButton_element(icp.MarginNotSet_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
				terPage.get_radioButton_element(icp.DepartmentWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
				terPage.get_radioButton_element(icp.CategoryWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
				terPage.get_radioButton_element(icp.BrandWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
				terPage.get_radioButton_element(icp.VendorWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
				terPage.get_radioButton_element(icp.BarcodeWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
				terPage.get_radioButton_element(icp.BreakQty_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
				terPage.get_radioButton_element(icp.DeactivateItem_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
				terPage.get_radioButton_element(icp.DeActivateBatch_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
				terPage.get_radioButton_element(icp.MinQty_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
				terPage.get_radioButton_element(icp.MaxQty_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
				terPage.get_radioButton_element(icp.ItemNameChangeLog_string).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
				terPage.get_radioButton_element(icp.PriceChange_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch17)) {
				terPage.get_radioButton_element(icp.BatchWiseInventory_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch18)) {
				terPage.get_radioButton_element(icp.ActivePromotion_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch19)) {
				terPage.get_radioButton_element(icp.ActivePromotionPrice_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch20)) {
				terPage.get_radioButton_element(icp.ActivePrmotionFree_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch21)) {
				terPage.get_radioButton_element(icp.ExpiredItem_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch22)) {
				terPage.get_radioButton_element(icp.SPlessNetCost_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch23)) {
				terPage.get_radioButton_element(icp.ParentChild_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch26)) {
				terpage.terminal_waitClearEnterText_css(icp.BatchCount_String, Globals.Inventory.Batch26);
				//Inventorychange.clearAndTypeSlowly(Globals.Inventory.Batch26, "input#txtSearch");
				//Inventorychange.return_td_invoke_element(Globals.Inventory.Batch26).click();
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtBatchCount\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_css(icp.InventoryCode_String, Globals.Inventory.ItemCode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
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
				terpage.terminal_waitClearEnterText_css(icp.SubClass_string, Globals.Inventory.SubClass);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubClass, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.SubClass).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
				terpage.terminal_waitClearEnterText_css(icp.Floor_String, Globals.Inventory.Floorcode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terpage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Section).click();
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ReportFilterUserControl_txtSection\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
				terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
			}
			
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
				terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
				
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
				terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
				
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element(icp.ByDate_String).click();

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch24)) {
				terPage.get_checkBox_element(icp.IsActive_String).click();

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch25)) {
				terPage.get_checkBox_element(icp.Vendorwise_String).click();

			}
			//if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
			//	terPage.get_checkBox_element_Xpath(icp.User_string).click();
			//}
			pass.ExcelFourData("SalesAnalysisReport","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("SalesAnalysisReport", "Filters", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e)
			{
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("SalesAnalysisReport","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("SalesAnalysisReport", "Filters", "FAIL", 1, 0, 1, 3);
			}
	}


}
