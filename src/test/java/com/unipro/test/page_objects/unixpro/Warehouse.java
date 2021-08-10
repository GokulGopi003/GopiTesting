package com.unipro.test.page_objects.unixpro;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Warehouse {
		AddInventoryFormPage Category;
		Warehousefield icp;

		TerminalPage terPage;

		public  Warehouse(Warehousefield  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Warehouse sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.WarehouseSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME19);
		}
		@Then("I load the rowise Warehouse data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.WarehouserowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.WarehouseSheetData, row_name);

			System.out.println(Globals.Inventory.WarehouseSheetData);

		}

		@Then("I update value to the Warehouse page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.WarehouseCode = Globals.Inventory.WarehouserowwiseData.get("WarehouseCode");
			Globals.Inventory.WarehouseName = Globals.Inventory.WarehouserowwiseData.get("WarehouseName");
			Globals.Inventory.Address = Globals.Inventory.WarehouserowwiseData.get("Address");
			Globals.Inventory.Address1 = Globals.Inventory.WarehouserowwiseData.get("Address1");
			Globals.Inventory.Address2 = Globals.Inventory.WarehouserowwiseData.get("Address2");
			Globals.Inventory.Pincode = Globals.Inventory.WarehouserowwiseData.get("Pincode");
			Globals.Inventory.Phone = Globals.Inventory.WarehouserowwiseData.get("Phone");
			Globals.Inventory.Fax = Globals.Inventory.WarehouserowwiseData.get("Fax");
			Globals.Inventory.Netcost = Globals.Inventory.WarehouserowwiseData.get("Netcost");

			
		}

		@Then("I fill new Warehouse data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.WarehouseCode)) {
				terPage.terminal_waitClearEnterText_css(icp.WarehouseCode_String, Globals.Inventory.WarehouseCode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WarehouseName)) {
				terPage.terminal_waitClearEnterText_css(icp.WarehouseName_String, Globals.Inventory.WarehouseName);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address)) {
				terPage.terminal_waitClearEnterText_css(icp.Address_String, Globals.Inventory.Address);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
				terPage.terminal_waitClearEnterText_css(icp.Address1_String, Globals.Inventory.Address1);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address2)) {
				terPage.terminal_waitClearEnterText_css(icp.Address2_String, Globals.Inventory.Address2);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Pincode)) {
				terPage.terminal_waitClearEnterText_css(icp.Pincode_String, Globals.Inventory.Pincode);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
				terPage.terminal_waitClearEnterText_css(icp.Phone_String, Globals.Inventory.Phone);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Fax)) {
				terPage.terminal_waitClearEnterText_css(icp.Fax_String, Globals.Inventory.Fax);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Netcost)) {
				terPage.terminal_waitClearEnterText_css(icp.Netcost_String, Globals.Inventory.Netcost);
			
			}
			
	}
	
}

