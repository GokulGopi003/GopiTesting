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

public class LocationWiseSale extends PageObject {
	LocationWiseSaleTypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public LocationWiseSale(LocationWiseSaleTypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();

}
	@Then("I load the LocationWiseSales sheet data to map")
	public void i_load_the_LocationWiseSales_sheet_data_to_map() {
		Globals.Inventory.LocationWiseSalesSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME104);
	}

	@Then("I load the rowise LocationWiseSales data for {string} rowname")
	public void i_load_the_rowise_LocationWiseSales_data_for_rowname(String row_name) {
		Globals.Inventory.LocationWiseSalesrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.LocationWiseSalesSheetData, row_name);

		System.out.println(Globals.Inventory.LocationWiseSalesrowwiseData);
	}

	@Then("I update value to the LocationWiseSales page global Variables")
	public void i_update_value_to_the_LocationWiseSales_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.LocationWiseSalesrowwiseData.get("Branch");
		Globals.Inventory.Department = Globals.Inventory.LocationWiseSalesrowwiseData.get("GroupBy");
		Globals.Inventory.FromDate = Globals.Inventory.LocationWiseSalesrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.LocationWiseSalesrowwiseData.get("ToDate");
		Globals.Inventory.Terminal = Globals.Inventory.LocationWiseSalesrowwiseData.get("Terminal");
		Globals.Inventory.Brand = Globals.Inventory.LocationWiseSalesrowwiseData.get("Date");
		Globals.Inventory.Batch = Globals.Inventory.LocationWiseSalesrowwiseData.get("Batch");
		//Globals.Inventory.Batch1 = Globals.Inventory.LocationWiseSalesrowwiseData.get("Month");
		//Globals.Inventory.Batch2 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("None");
	}

	@Then("I fill new LocationWiseSales data page using excel data")
	public void i_fill_new_LocationWiseSales_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlGroupBy_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement StateValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlGroupBy_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlGroupBy_chzn div > div > input[type=text]";
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlLocation_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement StateValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlLocation_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlLocation_chzn div > div > input[type=text]";
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
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_radioButton_element(icp.Batch_String).click();
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
