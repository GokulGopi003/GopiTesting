package com.unipro.test.page_objects.unixpro;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class Floor {
	AddInventoryFormPage Category;
	Floorfield icp;

	TerminalPage terPage;

	public  Floor(Floorfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();

		Category = new AddInventoryFormPage();
	}
	
	@Then("I load the Floor sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.FloorSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME7);
	}
	@Then("I load the rowise Floor data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.FloorrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.FloorSheetData, row_name);

		System.out.println(Globals.Inventory.FloorSheetData);

	}

	@Then("I update value to the Floor page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Floorcode = Globals.Inventory.FloorrowwiseData.get("Floorcode");
		Globals.Inventory.Description = Globals.Inventory.FloorrowwiseData.get("Description");
		
	
		
	}

	@Then("I fill new Floor data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
			terPage.terminal_waitClearEnterText_css(icp.Floorcode_string, Globals.Inventory.Floorcode);
			

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
		
		}
		
}
}