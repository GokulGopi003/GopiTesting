package com.unipro.test.page_objects.unixpro;
    import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import com.unipro.test.framework.helpers.utils.ReadXLSXFile;

	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	public class Category {

		AddInventoryFormPage Category;
		Categoryfield icp;

		TerminalPage terPage;

		public  Category(Categoryfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
	            
		}

@Then("I load the Category sheet data to map")
public void i_load_the_Category_sheet_data_to_map() {
	//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

	Globals.Inventory.CategorySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME2);
}
	

		@Then("I load the rowise Category data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.CategoryrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CategorySheetData, row_name);

			System.out.println(Globals.Inventory.CategorySheetData);

		}
		@Then("I update value to the Category page global Variables")
		public void i_update_value_to_the_Category_page_global_Variables() {

		
			Globals.Inventory.Categorycode = Globals.Inventory.CategoryrowwiseData.get("Categorycode");
			Globals.Inventory.Categoryname = Globals.Inventory.CategoryrowwiseData.get("Categoryname");
			Globals.Inventory.Discount = Globals.Inventory.CategoryrowwiseData.get("Discount");
			Globals.Inventory.Remark = Globals.Inventory.CategoryrowwiseData.get("Remark");
			
			
			
		}
		@Then("I fill new Category data page using excel data")
		public void i_fill_new_Category_data_page_using_excel_data() {

			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Categorycode)) {
				terPage.terminal_waitClearEnterText_css(icp.Categorycode_string, Globals.Inventory.Categorycode);
				

			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Categoryname)) {
				terPage.terminal_waitClearEnterText_css(icp.Categoryname_String, Globals.Inventory.Categoryname);
			
			}
			
	
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
				terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
				
				
	}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Remark)) {
				terPage.terminal_waitClearEnterText_css(icp.Remark_String, Globals.Inventory.Remark);
			
			}
		}
	}




