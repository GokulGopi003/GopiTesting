package com.unipro.test.page_objects.unixpro;


	import java.io.FileNotFoundException;

	import java.io.IOException;
	import java.util.NoSuchElementException;

	import org.openqa.selenium.By;

	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.remote.server.handler.SendKeys;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.testng.asserts.SoftAssert;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
	import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;
	import com.unipro.test.page_objects.unixpro.CommonPages;
	import com.unipro.test.page_objects.unixpro.CreateGRN;
	import com.unipro.test.page_objects.unixpro.TerminalPage;
	import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

	import bsh.Console;
	import cucumber.api.java.en.Then;

	public class ConsolidatedPO extends PageObject {

		AddInventoryFormPage add_inventory;
		ConsolidatedPOField icp;
		CommonPages cp;

		TerminalPage terPage;

		public ConsolidatedPO(ConsolidatedPOField icp, CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();

			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}

		@Then("I load the ConsolidatedPO sheet data to map")
		public void i_load_the_ConsolidatedPO_sheet_data_to_map() {

			// Globals.Inventory.inventorySheetData1 =
			// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.ConsolidatedPOSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME36);

		}

		@Then("I load the rowise ConsolidatedPO data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.ConsolidatedPOrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ConsolidatedPOSheetData, row_name);

			System.out.println(Globals.Inventory.ConsolidatedPOrowwiseData);

		}

		@Then("I update value to the ConsolidatedPO page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.LocationCode = Globals.Inventory.ConsolidatedPOrowwiseData.get("LocationCode");
			//Globals.Inventory.LocationCode1 = Globals.Inventory.ConsolidatedPOrowwiseData.get("LocationCode1");
			//Globals.Inventory.LocationCode2 = Globals.Inventory.ConsolidatedPOrowwiseData.get("LocationCode1");
			Globals.Inventory.Vendor = Globals.Inventory.ConsolidatedPOrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.ConsolidatedPOrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.ConsolidatedPOrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.ConsolidatedPOrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.ConsolidatedPOrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.ConsolidatedPOrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.ConsolidatedPOrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.ConsolidatedPOrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.ConsolidatedPOrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.ConsolidatedPOrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.ConsolidatedPOrowwiseData.get("ShelfCode");
			Globals.Inventory.ItemCode = Globals.Inventory.ConsolidatedPOrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.ConsolidatedPOrowwiseData.get("ItemName");
			Globals.Inventory.Class = Globals.Inventory.ConsolidatedPOrowwiseData.get("Class");
			Globals.Inventory.Date = Globals.Inventory.ConsolidatedPOrowwiseData.get("Date");
			Globals.Inventory.Billdate = Globals.Inventory.ConsolidatedPOrowwiseData.get("Billdate");
			Globals.Inventory.Qty = Globals.Inventory.ConsolidatedPOrowwiseData.get("Qty");
			Globals.Inventory.BasicCost = Globals.Inventory.ConsolidatedPOrowwiseData.get("BasicCost");
			Globals.Inventory.MinMax = Globals.Inventory.ConsolidatedPOrowwiseData.get("MinMax");
			Globals.Inventory.Bulkchild = Globals.Inventory.ConsolidatedPOrowwiseData.get("Bulkchild");
			Globals.Inventory.Presupplywise = Globals.Inventory.ConsolidatedPOrowwiseData.get("Presupplywise");
			Globals.Inventory.Basedoninventory = Globals.Inventory.ConsolidatedPOrowwiseData.get("Basedoninventory");
			Globals.Inventory.Soldqty = Globals.Inventory.ConsolidatedPOrowwiseData.get("Soldqty");
			Globals.Inventory.Reorderbynoofdays = Globals.Inventory.ConsolidatedPOrowwiseData.get("Reorderbynoofdays");
			Globals.Inventory.Soldqtyinlastpurchase = Globals.Inventory.ConsolidatedPOrowwiseData.get("Soldqtyinlastpurchase");
			Globals.Inventory.Reqtycycledays = Globals.Inventory.ConsolidatedPOrowwiseData.get("Reqtycycledays");

		}

		@Then("I fill new ConsolidatedPO data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
				terPage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
				
			}
			//if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode1)) {
				//terPage.terminal_waitClearEnterText_css(icp.LocationCode1_String, Globals.Inventory.LocationCode1);
				//add_inventory.clearAndTypeSlowly(Globals.Inventory.LocationCode1, "input#txtSearch");
				//add_inventory.return_td_invoke_element(Globals.Inventory.LocationCode1).click();
			//}
			//if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode2)) {
				//terPage.terminal_waitClearEnterText_css(icp.LocationCode2_String, Globals.Inventory.LocationCode2);
				//add_inventory.clearAndTypeSlowly(Globals.Inventory.LocationCode2, "input#txtSearch");
				//add_inventory.return_td_invoke_element(Globals.Inventory.LocationCode2).click();
			//}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
				terPage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Department).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
				terPage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Category).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
				terPage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Brand).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
				terPage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.SubCategory).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
				terPage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Merchandise);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Merchandise, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Merchandise).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
				terPage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Manufacture).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Floorcode_String, Globals.Inventory.Floorcode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Floorcode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terPage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Section).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
				terPage.terminal_waitClearEnterText_css(icp.Bin_String, Globals.Inventory.Bin);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Bin, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Bin).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
				terPage.terminal_waitClearEnterText_css(icp.ShelfCode_String, Globals.Inventory.ShelfCode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.ItemCode).click();
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemName")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
				terPage.terminal_waitClearEnterText_css(icp.Class_String, Globals.Inventory.Class);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Class).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
				terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Billdate)) {
				terPage.terminal_waitClearEnterText_css(icp.Billdate_String, Globals.Inventory.Billdate);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terPage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty")).sendKeys(Keys.RETURN);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
				terPage.terminal_waitClearEnterText_css(icp.BasicCost_String, Globals.Inventory.BasicCost);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice")).sendKeys(Keys.RETURN);
			}
			

		}

	}


