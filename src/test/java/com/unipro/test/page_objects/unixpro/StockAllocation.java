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

public class StockAllocation extends PageObject {
	StockAllocationtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public StockAllocation(StockAllocationtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the StockAllocation sheet data to map")
	public void i_load_the_StockAllocation_sheet_data_to_map() {
		Globals.Inventory.StockAllocationSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME136);
	}

	@Then("I load the rowise StockAllocation data for {string} rowname")
	public void i_load_the_rowise_StockAllocation_data_for_rowname(String row_name) {
		Globals.Inventory.StockAllocationrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.StockAllocationSheetData, row_name);

		System.out.println(Globals.Inventory.StockAllocationrowwiseData);
	}

	@Then("I update value to the StockAllocation page global Variables")
	public void i_update_value_to_the_StockAllocation_page_global_Variables() {
		Globals.Inventory.FromDate = Globals.Inventory.StockAllocationrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.StockAllocationrowwiseData.get("ToDate");
		Globals.Inventory.GidNo = Globals.Inventory.StockAllocationrowwiseData.get("GidNo");
		Globals.Inventory.Active = Globals.Inventory.StockAllocationrowwiseData.get("Allocation");
		
		Globals.Inventory.Batch1 = Globals.Inventory.StockAllocationrowwiseData.get("GrnOnly");
		Globals.Inventory.Batch2 = Globals.Inventory.StockAllocationrowwiseData.get("All");
		Globals.Inventory.Batch = Globals.Inventory.StockAllocationrowwiseData.get("AutoPo");
	}

	@Then("I fill new StockAllocation data page using excel data")
	public void i_fill_new_StockAllocation_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		} 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GidNo)) {
			terpage.terminal_waitClearEnterText_css(icp.Gid_String, Globals.Inventory.GidNo);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.GidNo, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.GidNo).click();
		}
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.Active)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div[1]/div[2]/div[2]/div[4]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#main > div.container-fluid > div.main-container > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div > div > input[type=text]"));
			String css_location_dropDownValue = "#main > div.container-fluid > div.main-container > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Active);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.ENTER);

		}*/
       if (GenericWrappers.isNotEmpty(Globals.Inventory.Active)) {
			
			webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div[1]/div[2]/div[2]/div[4]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			
			
			//GenericWrappers.sleepInSeconds(1);
			//webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlStkAllMethod\"]")).sendKeys(Keys.RETURN);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlStkAllMethod\"]")).sendKeys(Keys.DOWN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.GrnOnly_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.All_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terpage.terminal_waitClearEnterText_css(icp.AutoPo_String, Globals.Inventory.Batch);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Batch, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Batch).click();
		}
	}


}
