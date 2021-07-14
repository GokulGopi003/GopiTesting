package com.unipro.test.page_objects.unixpro;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class Brand {
	AddInventoryFormPage Category;
	Brandfield icp;

	TerminalPage terPage;

	public  Brand(Brandfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();

		Category = new AddInventoryFormPage();
	}
	
	@Then("I load the Brand sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.BrandSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME5);
	}
	@Then("I load the rowise Brand data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.BrandrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.BrandSheetData, row_name);

		System.out.println(Globals.Inventory.BrandSheetData);

	}

	@Then("I update value to the Brand page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Brandcode = Globals.Inventory.BrandrowwiseData.get("Brandcode");
		Globals.Inventory.Brandname = Globals.Inventory.BrandrowwiseData.get("Brandname");
		Globals.Inventory.Discount = Globals.Inventory.BrandrowwiseData.get("Discount");
		Globals.Inventory.Remark = Globals.Inventory.BrandrowwiseData.get("Remark");
		Globals.Inventory.Category = Globals.Inventory.BrandrowwiseData.get("Category");
	
		
	}

	@Then("I fill new Brand data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brandcode)) {
			terPage.terminal_waitClearEnterText_css(icp.Brandcode_string, Globals.Inventory.Brandcode);
			

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brandname)) {
			terPage.terminal_waitClearEnterText_css(icp.Brandname_String, Globals.Inventory.Brandname);
		
		}
		

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
			terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
			
			
}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Remark)) {
			terPage.terminal_waitClearEnterText_css(icp.Remark_String, Globals.Inventory.Remark);
			
			
}
	
	}

		@Then("I fill the Category values in the inventory page")
		public void i_fill_the_Category_values_in_the_inventory_page() {

			try {
				terPage.return_dd_invoke_element("-- Select --", 0).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				terPage.return_dd_invoke_element("-- Select --", 0).click();
				
			}
			GenericWrappers.sleepInSeconds(4);

			terPage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
		
		}
}
