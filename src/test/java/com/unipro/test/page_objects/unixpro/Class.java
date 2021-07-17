package com.unipro.test.page_objects.unixpro;




	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

	import cucumber.api.java.en.Then;

	public class Class {
		AddInventoryFormPage Class;
		Classfield icp;

		TerminalPage terPage;

		public  Class(Classfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Class = new AddInventoryFormPage();
		}
		
		@Then("I load the Class sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ClassSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME9);
		}
		@Then("I load the rowise Class data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ClassrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ClassSheetData, row_name);

			System.out.println(Globals.Inventory.ClassSheetData);

		}

		@Then("I update value to the Class page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Classcode = Globals.Inventory.ClassrowwiseData.get("Classcode");
			Globals.Inventory.Description = Globals.Inventory.ClassrowwiseData.get("Description");
			
		
			
		}

		@Then("I fill new Class data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Classcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Classcode_string, Globals.Inventory.Classcode);
				

			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
	

		}
	}
