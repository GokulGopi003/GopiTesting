package com.unipro.test.page_objects.unixpro;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Zone {
		AddInventoryFormPage Category;
		ZoneField icp;

		TerminalPage terPage;

		public  Zone(ZoneField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Zone sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ZoneSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME25);
		}
		@Then("I load the rowise Zone data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ZonerowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ZoneSheetData, row_name);

			System.out.println(Globals.Inventory.ZoneSheetData);

		}

		@Then("I update value to the Zone page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Zonecode = Globals.Inventory.ZonerowwiseData.get("Zonecode");
			Globals.Inventory.ZoneName = Globals.Inventory.ZonerowwiseData.get("ZoneName");

			
		}

		@Then("I fill new Zone data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Zonecode)) {
				terPage.terminal_waitClearEnterText_css(icp.Zonecode_String, Globals.Inventory.Zonecode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ZoneName)) {
				terPage.terminal_waitClearEnterText_css(icp.ZoneName_String, Globals.Inventory.ZoneName);
			
			}
			
		
			
		
	}
	



}





