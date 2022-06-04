package com.unipro.test.page_objects.unixpro;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class AccountSettlement extends PageObject {
	AcSettlementtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public AccountSettlement(AcSettlementtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();

}
	@Then("I load the AccountSettlement sheet data to map")
	public void i_load_the_AccountSettlement_sheet_data_to_map() {
		Globals.Inventory.AccountSettlementSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME108);
	}

	@Then("I load the rowise AccountSettlement data for {string} rowname")
	public void i_load_the_rowise_AccountSettlement_data_for_rowname(String row_name) {
		Globals.Inventory.AccountSettlementrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.AccountSettlementSheetData, row_name);

		System.out.println(Globals.Inventory.AccountSettlementrowwiseData);
	}

	@Then("I update value to the AccountSettlement page global Variables")
	public void i_update_value_to_the_AccountSettlement_page_global_Variables() {
		Globals.Inventory.FromDate = Globals.Inventory.AccountSettlementrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.AccountSettlementrowwiseData.get("ToDate");
	}

	@Then("I fill new AccountSettlement data page using excel data")
	public void i_fill_new_AccountSettlement_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
				terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
				
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
				terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
				
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
			}
			
			
			
			
			pass.ExcelFourData("SalesAnalysisReport","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("SalesAnalysisReport", "Filters", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e)
			{
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("SalesAnalysisReport","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("SalesAnalysisReport", "Filters", "FAIL", 1, 0, 1, 3);
			}
	}


}
