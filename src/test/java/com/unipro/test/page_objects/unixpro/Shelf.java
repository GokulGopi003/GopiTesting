package com.unipro.test.page_objects.unixpro;


	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Shelf {
		AddInventoryFormPage Category;
		ShelfField icp;

		TerminalPage terPage;

		public  Shelf(ShelfField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Shelf sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ShelfSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME18);
		}
		@Then("I load the rowise Shelf data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ShelfrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ShelfSheetData, row_name);

			System.out.println(Globals.Inventory.ShelfSheetData);

		}

		@Then("I update value to the Shelf page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Description = Globals.Inventory.ShelfrowwiseData.get("Description");
			Globals.Inventory.ShelfCode = Globals.Inventory.ShelfrowwiseData.get("ShelfCode");

			
		}

		@Then("I fill new Shelf data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
				terPage.terminal_waitClearEnterText_css(icp.Shelfcode_String, Globals.Inventory.ShelfCode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
		
			
		
	}
	



}
