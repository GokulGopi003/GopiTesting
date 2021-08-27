package com.unipro.test.page_objects.unixpro;

    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import com.unipro.test.framework.Globals;
    import com.unipro.test.framework.PageObject;
    import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class AddDed extends PageObject {
		AddInventoryFormPage Category;
		AddDedField icp;

		TerminalPage terPage;

		public  AddDed(AddDedField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the AddDed sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.AddDedSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME24);
		}
		@Then("I load the rowise AddDed data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.AddDedrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.AddDedSheetData, row_name);

			System.out.println(Globals.Inventory.AddDedSheetData);

		}

		@Then("I update value to the AddDed page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Dicountcode = Globals.Inventory.AddDedrowwiseData.get("Dicountcode");
			Globals.Inventory.Description = Globals.Inventory.AddDedrowwiseData.get("Description");
			Globals.Inventory.Type = Globals.Inventory.AddDedrowwiseData.get("Type");
			Globals.Inventory.Batch = Globals.Inventory.AddDedrowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.AddDedrowwiseData.get("Batch1");
			Globals.Inventory.GST = Globals.Inventory.AddDedrowwiseData.get("GST");
			
		
			
		}

		@Then("I fill new AddDed data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Dicountcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Dicountcode_String, Globals.Inventory.Dicountcode);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Type)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddltype_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddltype_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddltype_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Type);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element(icp.Batch_String).click();

			}
		    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terPage.get_checkBox_element(icp.Batch1_String).click();

		    }
		    if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
				terPage.terminal_waitClearEnterText_css(icp.GST_String, Globals.Inventory.GST);
			
			}
}
			
}
	










