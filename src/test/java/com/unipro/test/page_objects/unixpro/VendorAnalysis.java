package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class VendorAnalysis extends PageObject {
	VendorAnalysisTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	public VendorAnalysis(VendorAnalysisTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
	}
	@Then("I load the VendorAnalysis sheet data to map")
	public void i_load_the_VendorAnalysis_sheet_data_to_map() {
		Globals.Inventory.VendorAnalysisSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME94);
	}

	@Then("I load the rowise VendorAnalysis data for {string} rowname")
	public void i_load_the_rowise_VendorAnalysis_data_for_rowname(String row_name) {
		Globals.Inventory.VendorAnalysisrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.VendorAnalysisSheetData, row_name);

		System.out.println(Globals.Inventory.VendorAnalysisrowwiseData);
	}

	@Then("I update value to the VendorAnalysis page global Variables")
	public void i_update_value_to_the_VendorAnalysis_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.VendorAnalysisrowwiseData.get("Vendor");
		Globals.Inventory.Location = Globals.Inventory.VendorAnalysisrowwiseData.get("Location");
		Globals.Inventory.FromDate = Globals.Inventory.VendorAnalysisrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.VendorAnalysisrowwiseData.get("ToDate");
		Globals.Inventory.ZipCode = Globals.Inventory.VendorAnalysisrowwiseData.get("ZipCode");
		Globals.Inventory.MobileNo = Globals.Inventory.VendorAnalysisrowwiseData.get("MobileNo");
	}

	@Then("I fill new VendorAnalysis data page using excel data")
	public void i_fill_new_VendorAnalysis_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {// *[@id="ContentPlaceHolder1_ddlState_chzn"]
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

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
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
		
		

	}
		}

	

