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

public class LinkAccount extends PageObject {
	LinkAccounttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public LinkAccount(LinkAccounttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();

}
	@Then("I load the LinkAccount sheet data to map")
	public void i_load_the_LinkAccount_sheet_data_to_map() {
		Globals.Inventory.LinkAccountSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME107);
	}

	@Then("I load the rowise LinkAccount data for {string} rowname")
	public void i_load_the_rowise_LinkAccount_data_for_rowname(String row_name) {
		Globals.Inventory.LinkAccountrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.LinkAccountSheetData, row_name);

		System.out.println(Globals.Inventory.LinkAccountrowwiseData);
	}

	@Then("I update value to the LinkAccount page global Variables")
	public void i_update_value_to_the_LinkAccount_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.LinkAccountrowwiseData.get("CORPID");
		Globals.Inventory.Department = Globals.Inventory.LinkAccountrowwiseData.get("USERID");
		Globals.Inventory.FromDate = Globals.Inventory.LinkAccountrowwiseData.get("AccountNo");
		Globals.Inventory.Batch = Globals.Inventory.LinkAccountrowwiseData.get("Primary");
	}

	@Then("I fill new LinkAccount data page using excel data")
	public void i_fill_new_LinkAccount_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
				terpage.terminal_waitClearEnterText_css(icp.Corpid_String, Globals.Inventory.Location);
				//Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
				//Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtCORPID\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
				terpage.terminal_waitClearEnterText_css(icp.UserId_String, Globals.Inventory.Department);
				//Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
				//Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtUSERID\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
				terpage.terminal_waitClearEnterText_css(icp.AcNumber_String, Globals.Inventory.FromDate);
				//Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromDate, "input#txtSearch");
				//Inventorychange.return_td_invoke_element(Globals.Inventory.FromDate).click();
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtAccountNo\"]")).sendKeys(Keys.RETURN);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_radioButton_element(icp.Primary_String).click();
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



