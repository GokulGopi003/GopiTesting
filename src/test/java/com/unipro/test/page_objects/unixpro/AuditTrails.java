package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class AuditTrails extends PageObject {
	AuditTrailstypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public AuditTrails(AuditTrailstypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();

}
	@Then("I load the AuditTrails sheet data to map")
	public void i_load_the_AuditTrails_sheet_data_to_map() {
		Globals.Inventory.AuditTrailsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME105); 
	}

	@Then("I load the rowise AuditTrails data for {string} rowname")
	public void i_load_the_rowise_AuditTrails_data_for_rowname(String row_name) {
		Globals.Inventory.AuditTrailsrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.AuditTrailsSheetData, row_name);

		System.out.println(Globals.Inventory.AuditTrailsrowwiseData);
	}

	@Then("I update value to the AuditTrails page global Variables")
	public void i_update_value_to_the_AuditTrails_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.AuditTrailsrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.AuditTrailsrowwiseData.get("AuditCode");
		Globals.Inventory.FromDate = Globals.Inventory.AuditTrailsrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.AuditTrailsrowwiseData.get("ToDate");
		Globals.Inventory.Terminal = Globals.Inventory.AuditTrailsrowwiseData.get("Terminal");
		Globals.Inventory.Brand = Globals.Inventory.AuditTrailsrowwiseData.get("FormName");
		Globals.Inventory.Batch = Globals.Inventory.AuditTrailsrowwiseData.get("Batch");
		//Globals.Inventory.Batch1 = Globals.Inventory.AuditTrailsrowwiseData.get("Month");
		//Globals.Inventory.Batch2 = Globals.Inventory.AuditTrailsrowwiseData.get("None");
	}

	@Then("I fill new AuditTrails data page using excel data")
	public void i_fill_new_AuditTrails_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromDate, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.FromDate).click();
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.ToDate, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.ToDate).click();
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_DropDownLocation_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement StateValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_DropDownLocation_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_DropDownLocation_chzn div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Location);
			GenericWrappers.sleepInSeconds(1);
			StateValue.sendKeys(Keys.SPACE);
			StateValue.sendKeys(Keys.SPACE);
			StateValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			StateValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_DropDownAutitCode_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement StateValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_DropDownAutitCode_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_DropDownAutitCode_chzn div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Department);
			GenericWrappers.sleepInSeconds(1);
			StateValue.sendKeys(Keys.SPACE);
			StateValue.sendKeys(Keys.SPACE);
			StateValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			StateValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_DropDownFormname_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement StateValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_DropDownFormname_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_DropDownFormname_chzn div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Brand);
			GenericWrappers.sleepInSeconds(1);
			StateValue.sendKeys(Keys.SPACE);
			StateValue.sendKeys(Keys.SPACE);
			StateValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			StateValue.sendKeys(Keys.ENTER);

		}
		
		
	}


}
