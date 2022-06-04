package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class PurchaseAnalysis extends PageObject {
	purchaseanalysistypefield icp;
	TerminalPage terpage;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	WebDriver driver = new ChromeDriver();

	public PurchaseAnalysis(purchaseanalysistypefield icp) {
		this.icp = icp;
		terpage = new TerminalPage();
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	}
	@Then("I load the PurchaseAnalysis sheet data to map")
	public void i_load_the_PurchaseAnalysis_sheet_data_to_map() {
		Globals.Inventory.PurchaseAnalysisSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME95);
	}

	@Then("I load the PurchaseAnalysis rowise  data for {string} rowname")
	public void i_load_the_PurchaseAnalysis_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.PurchaseAnalysisrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PurchaseAnalysisSheetData, row_name);

		System.out.println(Globals.Inventory.PurchaseAnalysisrowwiseData);
		

	}

	@Then("I update value to the PurchaseAnalysis page global Variables")
	public void i_update_value_to_the_PurchaseAnalysis_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.PurchaseAnalysisrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.PurchaseAnalysisrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.PurchaseAnalysisrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.PurchaseAnalysisrowwiseData.get("Brand");
		Globals.Inventory.SubCategory = Globals.Inventory.PurchaseAnalysisrowwiseData.get("SubCategory");
		
		Globals.Inventory.Floorcode = Globals.Inventory.PurchaseAnalysisrowwiseData.get("Floorcode");
		Globals.Inventory.Section = Globals.Inventory.PurchaseAnalysisrowwiseData.get("Section");
		
		Globals.Inventory.ShelfCode = Globals.Inventory.PurchaseAnalysisrowwiseData.get("ShelfCode");
		
		Globals.Inventory.ItemCode = Globals.Inventory.PurchaseAnalysisrowwiseData.get("ItemCode");
		Globals.Inventory.ItemName = Globals.Inventory.PurchaseAnalysisrowwiseData.get("ItemName");
		
		Globals.Inventory.FromDate = Globals.Inventory.PurchaseAnalysisrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.PurchaseAnalysisrowwiseData.get("ToDate");
		Globals.Inventory.Allow = Globals.Inventory.PurchaseAnalysisrowwiseData.get("Allow");
	}

	@Then("I fill new PurchaseAnalysis data page using excel data")
	public void i_fill_new_PurchaseAnalysis_data_page_using_excel_data() throws Exception {
try {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.Vendor_String, Globals.Inventory.Vendor);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.Department_String, Globals.Inventory.Department);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.Category_String, Globals.Inventory.Category);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.Brand_String, Globals.Inventory.Brand);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.SubCategory_String, Globals.Inventory.SubCategory);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.Floor_String, Globals.Inventory.Floorcode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.Section_String, Globals.Inventory.Section);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Section).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.Shelf_String, Globals.Inventory.ShelfCode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.ItemCode_String, Globals.Inventory.ItemCode);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode")).sendKeys(Keys.RETURN);
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terpage.terminal_waitClearEnterText_Xpath(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtItemName\"]")).sendKeys(Keys.TAB);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
				terPage.get_radioButton_element(icp.New_String).click();
			}
			/*if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
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
			}*/
			pass.ExcelFourData("InventoryCostReset","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryCostReset", "Filters", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e)
			{
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("InventoryCostReset","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("InventoryCostReset", "Filters", "FAIL", 1, 0, 1, 3);
			}

	}
	@Then("I fill new Filterations data page using excel data")
	public void i_fill_new_Filterations_data_page_using_excel_data() {
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
