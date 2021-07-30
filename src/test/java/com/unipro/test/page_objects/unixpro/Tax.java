package com.unipro.test.page_objects.unixpro;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Tax { 
		AddInventoryFormPage Category;
		Taxfield icp;

		TerminalPage terPage;

		public  Tax(Taxfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Tax sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.TaxSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME13);
		}
		@Then("I load the rowise Tax data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.TaxrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.TaxSheetData, row_name);

			System.out.println(Globals.Inventory.TaxSheetData);

		}

		@Then("I update value to the Tax page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Taxcode = Globals.Inventory.TaxrowwiseData.get("Taxcode");
			Globals.Inventory.SGST = Globals.Inventory.TaxrowwiseData.get("SGST");
			Globals.Inventory.CGST = Globals.Inventory.TaxrowwiseData.get("CGST");
			Globals.Inventory.IGST = Globals.Inventory.TaxrowwiseData.get("IGST");
			Globals.Inventory.Batch= Globals.Inventory.TaxrowwiseData.get("Batch");
			Globals.Inventory.Batch1= Globals.Inventory.TaxrowwiseData.get("Batch1");
			Globals.Inventory.Batch2= Globals.Inventory.TaxrowwiseData.get("Batch2");
			Globals.Inventory.Billdate= Globals.Inventory.TaxrowwiseData.get("Billdate");
			Globals.Inventory.Date= Globals.Inventory.TaxrowwiseData.get("Date");
			
			
		
			
		}

		@Then("I fill new Tax data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Taxcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Taxcode_string, Globals.Inventory.Taxcode);
				

			}
			
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element(icp.Batch_String).click();
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_checkBox_element(icp.Batch1_String).click();
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_checkBox_element(icp.Batch2_String).click();
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SGST)) {
				terPage.terminal_waitClearEnterText_css(icp.SGST_String, Globals.Inventory.SGST);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CGST)) {
				terPage.terminal_waitClearEnterText_css(icp.CGST_String, Globals.Inventory.CGST);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.IGST)) {
				terPage.terminal_waitClearEnterText_css(icp.IGST_String, Globals.Inventory.IGST);
			
			}
		

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Billdate)) {
				terPage.terminal_waitClearEnterText_css(icp.Billdate_String, Globals.Inventory.Billdate);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
				terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
			
			}
			
	}
	
}
