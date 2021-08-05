package com.unipro.test.page_objects.unixpro;


	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Bin {
		AddInventoryFormPage Category;
		BinField icp;

		TerminalPage terPage;

		public   Bin(BinField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Bin sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.BinSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME16);
		}
		@Then("I load the rowise Bin data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.BinrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.BinSheetData, row_name);

			System.out.println(Globals.Inventory.BinSheetData);

		}

		@Then("I update value to the Bin page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Description = Globals.Inventory.BinrowwiseData.get("Description");
			Globals.Inventory.Qty = Globals.Inventory.BinrowwiseData.get("Qty");
			Globals.Inventory.Bincode = Globals.Inventory.BinrowwiseData.get("Bincode");
			
		
			
		}

		@Then("I fill new Bin data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Bincode)) {
				terPage.terminal_waitClearEnterText_css(icp.Bincode_String, Globals.Inventory.Bincode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terPage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
			
			}
			
		
			
		
	}
	

}



