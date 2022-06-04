package com.unipro.test.page_objects.unixpro;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class LocationStockMovement extends PageObject {
	LocationStockMovementTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	
	public LocationStockMovement(LocationStockMovementTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();
		
		

}
	@Then("I load the LocationStockMovement sheet data to map")
	public void i_load_the_LocationStockMovement_sheet_data_to_map() {
		Globals.Inventory.LocationStockMovementSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME103);
	}

	@Then("I load the rowise LocationStockMovement data for {string} rowname")
	public void i_load_the_rowise_LocationStockMovement_data_for_rowname(String row_name) {
		Globals.Inventory.LocationStockMovementrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.LocationStockMovementSheetData, row_name);

		System.out.println(Globals.Inventory.LocationStockMovementrowwiseData);
	}

	@Then("I update value to the LocationStockMovement page global Variables")
	public void i_update_value_to_the_LocationStockMovement_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.LocationStockMovementrowwiseData.get("GroupBy");
		Globals.Inventory.Department = Globals.Inventory.LocationStockMovementrowwiseData.get("Branch");
		Globals.Inventory.FromDate = Globals.Inventory.LocationStockMovementrowwiseData.get("Date");
	}

	@Then("I fill new LocationStockMovement data page using excel data")
	public void i_fill_new_LocationStockMovement_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlGroupBy_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement StateValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlGroupBy_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlGroupBy_chzn div > div > input[type=text]";
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
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlLocation_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement StateValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlLocation_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlLocation_chzn div > div > input[type=text]";
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
        
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			//terpage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.FromDate);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDate")).click();
			webDriver.findElement(By.xpath(""));
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromDate, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.FromDate).click();
			//webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDate\"]")).sendKeys(Keys.ENTER);
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
