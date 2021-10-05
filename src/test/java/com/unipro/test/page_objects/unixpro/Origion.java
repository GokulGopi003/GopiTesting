package com.unipro.test.page_objects.unixpro;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import cucumber.api.java.en.Then;

public class Origion extends PageObject {
	AddInventoryFormPage Category;
	Origionfield icp;
	TerminalPage terPage;

	public Origion(Origionfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
	}

	@Then("I load the Origion sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.OrigionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME40);
	}

	@Then("I load the rowise Origion data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.OrigionrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.OrigionSheetData, row_name);

		System.out.println(Globals.Inventory.OrigionSheetData);

	}

	@Then("I update value to the Origion page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.OrigionCode = Globals.Inventory.OrigionrowwiseData.get("OrigionCode");
		Globals.Inventory.Description = Globals.Inventory.OrigionrowwiseData.get("Description");

	}

	@Then("I fill new Origion data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.OrigionCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.OrigionCode_String, Globals.Inventory.OrigionCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Description_String, Globals.Inventory.Description);

		}
		

	}

}


