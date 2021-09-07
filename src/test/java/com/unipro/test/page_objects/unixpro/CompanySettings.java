package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class CompanySettings extends PageObject {
	    CompanySettingsField icp;
        TerminalPage terPage;

		public  CompanySettings(CompanySettingsField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();

		}
		
		@Then("I load the CompanySettings sheet data to map")
		public void i_load_the_CompanySettings_sheet_data_to_map() {
			Globals.Inventory.CompanySettingsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME27);
		}
		@Then("I load the rowise CompanySettings data for {string} rowname")
		public void i_load_the_rowise_CompanySettings_data_for_rowname(String row_name) {

			Globals.Inventory.CompanySettingsrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CompanySettingsSheetData, row_name);

			System.out.println(Globals.Inventory.CompanySettingsSheetData);

		}
		@Then("I update value to the CompanySettings page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.CompanyCode = Globals.Inventory.CompanySettingsrowwiseData.get("CompanyCode");
			Globals.Inventory.CompanyName = Globals.Inventory.CompanySettingsrowwiseData.get("Department");
			Globals.Inventory.GST = Globals.Inventory.CompanySettingsrowwiseData.get("GST");
			Globals.Inventory.Date = Globals.Inventory.CompanySettingsrowwiseData.get("Date");
			Globals.Inventory.Billno = Globals.Inventory.CompanySettingsrowwiseData.get("Billno");
			Globals.Inventory.Remarks = Globals.Inventory.CompanySettingsrowwiseData.get("Remarks");
			Globals.Inventory.Batch = Globals.Inventory.CompanySettingsrowwiseData.get("Batch");
		}

		@Then("I fill new CompanySettings data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() {
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.CompanyCode)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCompanyCode")).sendKeys(Keys.RETURN);
						terPage.terminal_waitClearEnterText_css(icp.CompanyCode_String, Globals.Inventory.CompanyCode);
						
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.CompanyName)) {
						terPage.terminal_waitClearEnterText_css(icp.CompanyName_String, Globals.Inventory.CompanyName);

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
						terPage.terminal_waitClearEnterText_css(icp.GST_String, Globals.Inventory.GST);

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
						terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Billno)) {
						terPage.terminal_waitClearEnterText_css(icp.Billno_String, Globals.Inventory.Billno);

					}
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
						terPage.terminal_waitClearEnterText_css(icp.Remarks_String, Globals.Inventory.Remarks);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
						terPage.get_checkBox_element(icp.Batch_String).click();

					}
		        
		
		}
		
		   
		
}


