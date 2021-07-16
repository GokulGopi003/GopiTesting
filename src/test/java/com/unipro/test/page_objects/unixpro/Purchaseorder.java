package com.unipro.test.page_objects.unixpro;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
	import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

	import cucumber.api.java.en.Then;

	public class Purchaseorder  extends PageObject {

		AddInventoryFormPage add_inventory;
		Purchaseorder1 icp;
		CommonPages cp;
		
		

		TerminalPage terPage;
		
		

		public Purchaseorder(Purchaseorder1 icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}
		

		@Then("I load the PO sheet data to map")
		public void i_load_the_GA_sheet_data_to_map() {

			//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.PurchaseorderSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME8);

		}
		@Then("I load the rowise PO data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.PurchaseorderrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.PurchaseorderSheetData, row_name);

			System.out.println(Globals.Inventory.PurchaseorderrowwiseData);

		}
		@Then("I update value to the PO page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.PurchaseorderrowwiseData.get("Vendor");
	
		}

		@Then("I fill new PO data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() {
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();

					}
					
			 
		   }
		   
		
		}



