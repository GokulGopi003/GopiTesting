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

	public class Vendorcatelog extends PageObject {

		AddInventoryFormPage add_inventory;
		VendorcatelogField icp;
		CommonPages cp;

		TerminalPage terPage;

		public Vendorcatelog(VendorcatelogField icp, CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();

			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}

		@Then("I load the Vendorcatelog sheet data to map")
		public void i_load_the_GA_sheet_data_to_map() {

			// Globals.Inventory.inventorySheetData1 =
			// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.VendorcatelogSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME35);

		}

		@Then("I load the rowise Vendorcatelog data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.VendorcatelogrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.VendorcatelogSheetData, row_name);

			System.out.println(Globals.Inventory.VendorcatelogrowwiseData);

		}

		@Then("I update value to the Vendorcatelog page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.VendorcatelogrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.VendorcatelogrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.VendorcatelogrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.VendorcatelogrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.VendorcatelogrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.VendorcatelogrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.VendorcatelogrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.VendorcatelogrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.VendorcatelogrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.VendorcatelogrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.VendorcatelogrowwiseData.get("ShelfCode");
			Globals.Inventory.WarehouseCode = Globals.Inventory.VendorcatelogrowwiseData.get("WarehouseCode");
			Globals.Inventory.Barcode = Globals.Inventory.VendorcatelogrowwiseData.get("Barcode");
			Globals.Inventory.Batchrowno = Globals.Inventory.VendorcatelogrowwiseData.get("Batchrowno");
			Globals.Inventory.ItemCode = Globals.Inventory.VendorcatelogrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.VendorcatelogrowwiseData.get("ItemName");


		}

		@Then("I fill new Vendorcatelog data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() {
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
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WarehouseCode)) {
				terPage.terminal_waitClearEnterText_css(icp.WarehouseCode_String, Globals.Inventory.WarehouseCode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.WarehouseCode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.WarehouseCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Barcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Barcode_String, Globals.Inventory.Barcode);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchrowno)) {
				terPage.terminal_waitClearEnterText_css(icp.Batchrowno_String, Globals.Inventory.Batchrowno);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
		
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemName")).sendKeys(Keys.RETURN);

			}


		}

	}


