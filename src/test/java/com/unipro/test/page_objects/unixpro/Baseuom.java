package com.unipro.test.page_objects.unixpro;


    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import com.unipro.test.framework.Globals;
    import com.unipro.test.framework.PageObject;
    import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Baseuom extends PageObject {
		AddInventoryFormPage Category;
		BaseuomField icp;

		TerminalPage terPage;

		public  Baseuom(BaseuomField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Baseuom sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.BaseuomSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME22);
		}
		@Then("I load the rowise Baseuom data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.BaseuomrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.BaseuomSheetData, row_name);

			System.out.println(Globals.Inventory.BaseuomSheetData);

		}

		@Then("I update value to the Baseuom page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Uomcode = Globals.Inventory.BaseuomrowwiseData.get("Uomcode");
			Globals.Inventory.Description = Globals.Inventory.BaseuomrowwiseData.get("Description");
			Globals.Inventory.Baseuomcode = Globals.Inventory.BaseuomrowwiseData.get("Baseuomcode");
			Globals.Inventory.Baseuomdescription = Globals.Inventory.BaseuomrowwiseData.get("Baseuomdescription");
			Globals.Inventory.Qty = Globals.Inventory.BaseuomrowwiseData.get("Qty");
			
		
			
		}

		@Then("I fill new Baseuom data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Uomcode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlUOMCode_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlUOMCode_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlUOMCode_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Uomcode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Baseuomcode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlBaseUOMCode_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlBaseUOMCode_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBaseUOMCode_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Baseuomcode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Baseuomdescription)) {
				terPage.terminal_waitClearEnterText_css(icp.Baseuomdescription_String, Globals.Inventory.Description);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terPage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Description);
			
			}
			
		
	}
	

}





