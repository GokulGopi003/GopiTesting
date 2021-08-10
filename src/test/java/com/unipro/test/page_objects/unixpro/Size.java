package com.unipro.test.page_objects.unixpro;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Size {
		AddInventoryFormPage Category;
		SizeField icp;

		TerminalPage terPage;

		public  Size(SizeField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Size sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.SizeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME20);
		}
		@Then("I load the rowise Size data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.SizerowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.SizeSheetData, row_name);

			System.out.println(Globals.Inventory.SizeSheetData);

		}

		@Then("I update value to the Size page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Description = Globals.Inventory.SizerowwiseData.get("Description");
			Globals.Inventory.SizeCode = Globals.Inventory.SizerowwiseData.get("SizeCode");

			
		}

		@Then("I fill new Size data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.SizeCode)) {
				terPage.terminal_waitClearEnterText_css(icp.Sizecode_String, Globals.Inventory.SizeCode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
		
			
		
	}
	



}


