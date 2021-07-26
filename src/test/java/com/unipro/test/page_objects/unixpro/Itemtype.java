package com.unipro.test.page_objects.unixpro;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

	import cucumber.api.java.en.Then;

	public class Itemtype {
		AddInventoryFormPage Itemtype;
		Itemtypefield icp;

		TerminalPage terPage;

		public  Itemtype(Itemtypefield icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Itemtype = new AddInventoryFormPage();
		}
		
		@Then("I load the Itemtype sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ItemtypeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME11);
		}
		@Then("I load the rowise Itemtype data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ItemtyperowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ItemtypeSheetData, row_name);

			System.out.println(Globals.Inventory.ItemtypeSheetData);

		}

		@Then("I update value to the Itemtype page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Itemtypecode = Globals.Inventory.ItemtyperowwiseData.get("Itemtypecode");
			Globals.Inventory.Description = Globals.Inventory.ItemtyperowwiseData.get("Description");
			
		
			
		}

		@Then("I fill new Itemtype data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Itemtypecode)) {
				terPage.terminal_waitClearEnterText_css(icp.Itemtypecode_string, Globals.Inventory.Itemtypecode);
				

			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
	

		}
	}


