package com.unipro.test.framework.helpers.utils;



	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;
import com.unipro.test.page_objects.unixpro.Origionfield;
import com.unipro.test.page_objects.unixpro.TerminalPage;

import cucumber.api.java.en.Then;

	public class Transport  extends PageObject {
		AddInventoryFormPage Category;
		Transportfield icp;
		TerminalPage terPage;

		public Transport(Transportfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
		}

		@Then("I load the Transport sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.TransportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME41);
		}

		@Then("I load the rowise Transport data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.TransportrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.TransportSheetData, row_name);

			System.out.println(Globals.Inventory.TransportSheetData);

		}

		@Then("I update value to the Transport page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Transportname = Globals.Inventory.TransportrowwiseData.get("Transportname");
			Globals.Inventory.Person = Globals.Inventory.TransportrowwiseData.get("Person");
			Globals.Inventory.Address = Globals.Inventory.TransportrowwiseData.get("Address");
			Globals.Inventory.Address1 = Globals.Inventory.TransportrowwiseData.get("Address1");
			Globals.Inventory.Phone = Globals.Inventory.TransportrowwiseData.get("Phone");
			Globals.Inventory.ModelNo = Globals.Inventory.TransportrowwiseData.get("ModelNo");
			Globals.Inventory.Fax = Globals.Inventory.TransportrowwiseData.get("Fax");
			Globals.Inventory.Email = Globals.Inventory.TransportrowwiseData.get("Email");
			Globals.Inventory.URL = Globals.Inventory.TransportrowwiseData.get("URL");
			Globals.Inventory.Batch = Globals.Inventory.TransportrowwiseData.get("Batch");
		}

		@Then("I fill new Transport data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Transportname)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Transportname_String, Globals.Inventory.Transportname);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Person)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Person_String, Globals.Inventory.Person);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address_String, Globals.Inventory.Address);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address1_String, Globals.Inventory.Address1);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Phone_String, Globals.Inventory.Phone);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ModelNo)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.ModelNo_String, Globals.Inventory.ModelNo);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Fax)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Fax_String, Globals.Inventory.Fax);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Email)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Email_String, Globals.Inventory.Email);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.URL)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.URL_String, Globals.Inventory.URL);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element_Xpath(icp.Batch_String).click();

			}
			

		}

	}





