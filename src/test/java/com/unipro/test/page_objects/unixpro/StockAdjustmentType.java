package com.unipro.test.page_objects.unixpro;

	import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import com.unipro.test.framework.Globals;
    import com.unipro.test.framework.PageObject;
    import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class StockAdjustmentType  extends PageObject {
		AddInventoryFormPage Category;
		StockAdjustmentTypefield icp;
		TerminalPage terPage;

		public  StockAdjustmentType(StockAdjustmentTypefield  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the StockAdjustmentType sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.StockAdjustmentTypeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME29);
		}
		@Then("I load the rowise StockAdjustmentType data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.StockAdjustmentTyperowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.StockAdjustmentTypeSheetData, row_name);

			System.out.println(Globals.Inventory.StockAdjustmentTypeSheetData);

		}

		@Then("I update value to the StockAdjustmentType page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.AdjtypeCode = Globals.Inventory.StockAdjustmentTyperowwiseData.get("AdjtypeCode");
			Globals.Inventory.AdjtypeName = Globals.Inventory.StockAdjustmentTyperowwiseData.get("AdjtypeName");
			Globals.Inventory.Batch = Globals.Inventory.StockAdjustmentTyperowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.StockAdjustmentTyperowwiseData.get("Batch1");
			Globals.Inventory.Description = Globals.Inventory.StockAdjustmentTyperowwiseData.get("Description");
	
		}

		@Then("I fill new StockAdjustmentType data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AdjtypeCode)) {
				   terPage.terminal_waitClearEnterText_css(icp.AdjtypeCode_String, Globals.Inventory.AdjtypeCode);
			
                }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AdjtypeName)) {
				   terPage.terminal_waitClearEnterText_css(icp.AdjtypeName_String, Globals.Inventory.AdjtypeName);
			
             }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
		        terPage.get_checkBox_element(icp.Batch_String).click();

	        }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
		        terPage.get_checkBox_element(icp.Batch1_String).click();

	        }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				   terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
             }
			
			
	}
	
}





