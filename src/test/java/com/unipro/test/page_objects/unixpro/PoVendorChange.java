package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import cucumber.api.java.en.Then;

public class PoVendorChange extends PageObject {

	AddInventoryFormPage Category;
	PovendorChaneField icp;

	TerminalPage terPage;

	public PoVendorChange(PovendorChaneField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
	}

	@Then("I load the PoVendorChange sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.PoVendorChangeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME26);
	}

	@Then("I load the rowise PoVendorChange data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.PoVendorChangerowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PoVendorChangeSheetData, row_name);

		System.out.println(Globals.Inventory.PoVendorChangeSheetData);

	}

	@Then("I update value to the PoVendorChange page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.PoNo = Globals.Inventory.PoVendorChangerowwiseData.get("PoNo");
		Globals.Inventory.Vendor = Globals.Inventory.PoVendorChangerowwiseData.get("Vendor");

	}

	@Then("I fill new PoVendorChange data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.PoNo)) {
			terPage.terminal_waitClearEnterText_css(icp.PoNo_String, Globals.Inventory.PoNo);
			Category.clearAndTypeSlowly(Globals.Inventory.PoNo, "input#txtSearch");
			Category.return_td_invoke_element(Globals.Inventory.PoNo).click();

		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Category.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Category.return_td_invoke_element(Globals.Inventory.Vendor).click();

		}

	}

}
