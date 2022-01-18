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
	import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

	public class Inventorymovement  extends PageObject {
		AddInventoryFormPage Inventorychange;
		InventorymovementField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;
		public Inventorymovement(InventorymovementField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;
			scr = new Screenshot();
			pass = new ExcelWrite();
			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();

		}
		

		@Then("I load the Inventorymovement sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.InventorymovementSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME39);

		}

		@Then("I load the rowise Inventorymovement data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.InventorymovementrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.InventorymovementSheetData, row_name);
			System.out.println(Globals.Inventory.InventorymovementrowwiseData);
		}

		@Then("I update value to the Inventorymovement page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.InventorymovementrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.InventorymovementrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.InventorymovementrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.InventorymovementrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.InventorymovementrowwiseData.get("SubCategory");
			Globals.Inventory.Floorcode = Globals.Inventory.InventorymovementrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.InventorymovementrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.InventorymovementrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.InventorymovementrowwiseData.get("ShelfCode");
			Globals.Inventory.WareHouse = Globals.Inventory.InventorymovementrowwiseData.get("WareHouse");
			Globals.Inventory.ItemCode = Globals.Inventory.InventorymovementrowwiseData.get("ItemCode");
			Globals.Inventory.ItemType = Globals.Inventory.InventorymovementrowwiseData.get("ItemType");
			Globals.Inventory.ItemName = Globals.Inventory.InventorymovementrowwiseData.get("ItemName");
			Globals.Inventory.Date = Globals.Inventory.InventorymovementrowwiseData.get("Date");
			Globals.Inventory.RefDate = Globals.Inventory.InventorymovementrowwiseData.get("RefDate");
			Globals.Inventory.MinMax = Globals.Inventory.InventorymovementrowwiseData.get("MinMax");
			Globals.Inventory.Price = Globals.Inventory.InventorymovementrowwiseData.get("Price");
			Globals.Inventory.Batch = Globals.Inventory.InventorymovementrowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.InventorymovementrowwiseData.get("Batch1");
			
			
		}

		@Then("I fill new Inventorymovement data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
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
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
				terpage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
				terpage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
				terpage.terminal_waitClearEnterText_css(icp.Floorcode_String, Globals.Inventory.Floorcode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terpage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Section).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ShelfCode_String, Globals.Inventory.ShelfCode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemType)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemType_String, Globals.Inventory.ItemType);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemType, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ItemType).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCode")).sendKeys(Keys.RETURN);
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemName")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
				terpage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.RefDate)) {
				terpage.terminal_waitClearEnterText_css(icp.RefDate_String, Globals.Inventory.RefDate);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terpage.get_checkBox_element(icp.Batch_String).click();

			 }
		   if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			   terpage.get_checkBox_element(icp.Batch1_String).click();

			}
		   if (GenericWrappers.isNotEmpty(Globals.Inventory.MinMax)) {
				terpage.terminal_waitClearEnterText_css(icp.MinMax_String, Globals.Inventory.MinMax);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtNoofItems")).sendKeys(Keys.RETURN);

			}
		   if (GenericWrappers.isNotEmpty(Globals.Inventory.Price)) {
				terpage.terminal_waitClearEnterText_css(icp.Price_String, Globals.Inventory.Price);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtNewItem")).sendKeys(Keys.RETURN);

			}
		   pass.ExcelFourData("InventoryMovement","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryMovement", "MASTERS", "PASS", 1, 0, 1, 3);
		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot taken");
			// Xl sheet write
			pass.ExcelFourData("InventoryMovement","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryMovement", "MASTERS", "FAIL", 1, 0, 1, 3);

		}

		}

	}




