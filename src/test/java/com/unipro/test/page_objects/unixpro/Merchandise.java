
package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import cucumber.api.java.en.Then;

public class Merchandise extends PageObject {
	AddInventoryFormPage Category;
	Merchandisefield icp;
	TerminalPage terPage;

	public Merchandise(Merchandisefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
	}

	@Then("I load the Merchandise sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.MerchandiseSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME30);
	}

	@Then("I load the rowise Merchandise data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.MerchandiserowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.MerchandiseSheetData, row_name);

		System.out.println(Globals.Inventory.MerchandiseSheetData);

	}

	@Then("I update value to the Merchandise page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.MerchandiseCode = Globals.Inventory.MerchandiserowwiseData.get("MerchandiseCode");
		Globals.Inventory.Remarks = Globals.Inventory.MerchandiserowwiseData.get("Remarks");
		Globals.Inventory.Description = Globals.Inventory.MerchandiserowwiseData.get("Description");

	}

	@Then("I fill new Merchandise data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.MerchandiseCode)) {
			terPage.terminal_waitClearEnterText_css(icp.MerchandiseCode_String, Globals.Inventory.MerchandiseCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
			terPage.terminal_waitClearEnterText_css(icp.Remarks_String, Globals.Inventory.Remarks);

		}

	}

}
