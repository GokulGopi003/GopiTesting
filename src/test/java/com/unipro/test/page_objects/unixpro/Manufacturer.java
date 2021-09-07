package com.unipro.test.page_objects.unixpro;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Manufacturer  {
		AddInventoryFormPage Category;
		ManufacturerField icp;

		TerminalPage terPage;

		public  Manufacturer(ManufacturerField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Manufacturer sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ManufacturerSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME32);
		}
		@Then("I load the rowise Manufacturer data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ManufacturerrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ManufacturerSheetData, row_name);

			System.out.println(Globals.Inventory.ManufacturerSheetData);

		}

		@Then("I update value to the Manufacturer page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.ManufacturerCode = Globals.Inventory.ManufacturerrowwiseData.get("Manufacturercode");
			Globals.Inventory.ManufacturerName = Globals.Inventory.ManufacturerrowwiseData.get("ManufacturerName");
			Globals.Inventory.Address = Globals.Inventory.ManufacturerrowwiseData.get("Address");
			Globals.Inventory.Address1 = Globals.Inventory.ManufacturerrowwiseData.get("Address1");
			Globals.Inventory.Address2 = Globals.Inventory.ManufacturerrowwiseData.get("Address2");
			Globals.Inventory.Pincode = Globals.Inventory.ManufacturerrowwiseData.get("Pincode");
			Globals.Inventory.Email = Globals.Inventory.ManufacturerrowwiseData.get("Email");
			Globals.Inventory.Phone = Globals.Inventory.ManufacturerrowwiseData.get("Phone");
			Globals.Inventory.Fax = Globals.Inventory.ManufacturerrowwiseData.get("Fax");

			
		}

		@Then("I fill new Manufacturer data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ManufacturerCode)) {
				terPage.terminal_waitClearEnterText_css(icp.Manufacturercode_String, Globals.Inventory.ManufacturerCode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ManufacturerName)) {
				terPage.terminal_waitClearEnterText_css(icp.ManufacturerName_String, Globals.Inventory.ManufacturerName);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address)) {
				terPage.terminal_waitClearEnterText_css(icp.Address_String, Globals.Inventory.Address);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
				terPage.terminal_waitClearEnterText_css(icp.Address1_String, Globals.Inventory.Address1);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address2)) {
				terPage.terminal_waitClearEnterText_css(icp.Address2_String, Globals.Inventory.Address2);
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Pincode)) {
			}
				terPage.terminal_waitClearEnterText_css(icp.Pincode_String, Globals.Inventory.Pincode);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Email)) {
				terPage.terminal_waitClearEnterText_css(icp.Email_String, Globals.Inventory.Email);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
				terPage.terminal_waitClearEnterText_css(icp.Phone_String, Globals.Inventory.Phone);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Fax)) {
				terPage.terminal_waitClearEnterText_css(icp.Fax_String, Globals.Inventory.Fax);
			
			}
			
		
			
		
	}
	



}


