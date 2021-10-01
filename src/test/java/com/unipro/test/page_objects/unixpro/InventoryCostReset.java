package com.unipro.test.page_objects.unixpro;


	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

	import cucumber.api.java.en.Then;
	import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

	public class InventoryCostReset extends PageObject {
		AddInventoryFormPage Inventorychange;
		InventoryCostResetField icp;
		CommonPages cp;
		TerminalPage terpage;

		public InventoryCostReset(InventoryCostResetField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();

		}
		

		@Then("I load the InventoryCostReset sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.InventoryCostResetSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME38);

		}

		@Then("I load the rowise InventoryCostReset data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.InventoryCostResetrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.InventoryCostResetSheetData, row_name);
			System.out.println(Globals.Inventory.InventoryCostResetrowwiseData);
		}

		@Then("I update value to the InventoryCostReset page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.InventoryCostResetrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.InventoryCostResetrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.InventoryCostResetrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.InventoryCostResetrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.InventoryCostResetrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.InventoryCostResetrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.InventoryCostResetrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.InventoryCostResetrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.InventoryCostResetrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.InventoryCostResetrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.InventoryCostResetrowwiseData.get("ShelfCode");
			Globals.Inventory.WareHouse = Globals.Inventory.InventoryCostResetrowwiseData.get("WareHouse");
			Globals.Inventory.ItemCode = Globals.Inventory.InventoryCostResetrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.InventoryCostResetrowwiseData.get("ItemName");
			
			
		}

		@Then("I fill new InventoryCostReset data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() {
			
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
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
				terpage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Merchandise);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Merchandise, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Merchandise).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
				terpage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Manufacture).click();
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
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
				terpage.terminal_waitClearEnterText_css(icp.Bin_String, Globals.Inventory.Bin);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Bin, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Bin).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ShelfCode_String, Globals.Inventory.ShelfCode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
				terpage.terminal_waitClearEnterText_css(icp.WareHouse_String, Globals.Inventory.WareHouse);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode")).sendKeys(Keys.RETURN);
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemName")).sendKeys(Keys.RETURN);

			}
			

		}

	}


