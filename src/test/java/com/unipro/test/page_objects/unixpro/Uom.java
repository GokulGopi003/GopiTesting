package com.unipro.test.page_objects.unixpro;


	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Uom {
		AddInventoryFormPage Category;
		Uomfield icp;

		TerminalPage terPage;

		public  Uom(Uomfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Uom sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.UomSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME14);
		}
		@Then("I load the rowise Uom data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.UomrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.UomSheetData, row_name);

			System.out.println(Globals.Inventory.UomSheetData);

		}

		@Then("I update value to the Uom page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Uomcode = Globals.Inventory.UomrowwiseData.get("Uomcode");
			Globals.Inventory.Description = Globals.Inventory.UomrowwiseData.get("Description");
			Globals.Inventory.Units = Globals.Inventory.UomrowwiseData.get("Units");
			
		
			
		}

		@Then("I fill new Uom data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Uomcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Uomcode_string, Globals.Inventory.Uomcode);
				

			}
			
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Units)) {
				terPage.terminal_waitClearEnterText_css(icp.Units_String, Globals.Inventory.Units);
			
			}
		
			
		
	}
	

}
