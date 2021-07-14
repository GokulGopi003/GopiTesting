package com.unipro.test.page_objects.unixpro;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class Subcategory {

	AddInventoryFormPage Category;
	Categoryfield icp;

	TerminalPage terPage;

	public  Subcategory(Categoryfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();

		Category = new AddInventoryFormPage();
            
	}

	@Then("I load the Subcategory sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.SubcategorySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME4);
	}
	@Then("I load the rowise Subcategory data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.SubcategoryrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SubcategorySheetData, row_name);

		System.out.println(Globals.Inventory.SubcategorySheetData);

	}

	@Then("I update value to the Subcategory page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Subcategorycode = Globals.Inventory.SubcategoryrowwiseData.get("Subcategorycode");
		Globals.Inventory.Subcategoryname = Globals.Inventory.SubcategoryrowwiseData.get("Subcategoryname");
		Globals.Inventory.Discounts = Globals.Inventory.SubcategoryrowwiseData.get("Discounts");
	
		
	}

	@Then("I fill new Subcategory data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Subcategorycode)) {
			terPage.terminal_waitClearEnterText_css(icp.Subcategorycode_string, Globals.Inventory.Subcategorycode);
			

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Subcategoryname)) {
			terPage.terminal_waitClearEnterText_css(icp.Subcategoryname_String, Globals.Inventory.Subcategoryname);
		
		}
		

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Discounts)) {
			terPage.terminal_waitClearEnterText_css(icp.Discounts_String, Globals.Inventory.Discounts);
			
			
}
	
		
		}
	}


