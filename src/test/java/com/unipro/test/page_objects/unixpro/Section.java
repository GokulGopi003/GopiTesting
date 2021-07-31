package com.unipro.test.page_objects.unixpro;



	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Section {
		AddInventoryFormPage Category;
		SectionField icp;

		TerminalPage terPage;

		public  Section(SectionField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Section sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.SectionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME15);
		}
		@Then("I load the rowise Section data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.SectionrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.SectionSheetData, row_name);

			System.out.println(Globals.Inventory.SectionSheetData);

		}

		@Then("I update value to the Section page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Description = Globals.Inventory.SectionrowwiseData.get("Description");
			Globals.Inventory.Section = Globals.Inventory.SectionrowwiseData.get("Section");
			
		
			
		}

		@Then("I fill new Section data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terPage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
		
			
		
	}
	

}


