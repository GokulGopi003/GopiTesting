
package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import cucumber.api.java.en.Then;

public class ConsolidatedPocreate extends PageObject {
	AddInventoryFormPage Category;
	ConsolidatedPocreatefield icp;
	TerminalPage terPage;
	CommonPages cp;

	public ConsolidatedPocreate(ConsolidatedPocreatefield icp,CommonPages cp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		this.cp = cp;
	}

	@Then("I load the ConsolidatedPocreate sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.ConsolidatedPocreateSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME31);
	}

	@Then("I load the rowise ConsolidatedPocreate data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.ConsolidatedPocreaterowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.ConsolidatedPocreateSheetData, row_name);

		System.out.println(Globals.Inventory.ConsolidatedPocreateSheetData);

	}

	@Then("I update value to the ConsolidatedPocreate page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Summary = Globals.Inventory.ConsolidatedPocreaterowwiseData.get("Summary");
		Globals.Inventory.Proceed = Globals.Inventory.ConsolidatedPocreaterowwiseData.get("Proceed");
		Globals.Inventory.Batch = Globals.Inventory.ConsolidatedPocreaterowwiseData.get("Batch");
	

	}

	@Then("I fill new ConsolidatedPocreate data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Summary)) {
			webDriver.findElement(By.cssSelector (icp.Summary_String)).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Proceed)) {
			webDriver.findElement(By.cssSelector (icp.Proceed_String)).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_checkBox_element(icp.Batch_String).click();

		}

	}

}
