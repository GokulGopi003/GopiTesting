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
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class SalesAnalysisReport extends PageObject {
	SalesAnalysisReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public SalesAnalysisReport(SalesAnalysisReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();
	}
	@Then("I load the SalesAnalysisReport sheet data to map")
	public void i_load_the_SalesAnalysisReport_sheet_data_to_map() {
		Globals.Inventory.SalesAnalysisReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME97);
	}

	@Then("I load the rowise SalesAnalysisReport data for {string} rowname")
	public void i_load_the_rowise_SalesAnalysisReport_data_for_rowname(String row_name) {
		Globals.Inventory.SalesAnalysisReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SalesAnalysisReportSheetData, row_name);

		System.out.println(Globals.Inventory.SalesAnalysisReportrowwiseData);
	}

	@Then("I update value to the SalesAnalysisReport page global Variables")
	public void i_update_value_to_the_SalesAnalysisReport_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.SalesAnalysisReportrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.SalesAnalysisReportrowwiseData.get("Department");
		Globals.Inventory.FromDate = Globals.Inventory.SalesAnalysisReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.SalesAnalysisReportrowwiseData.get("ToDate");
		Globals.Inventory.Category = Globals.Inventory.SalesAnalysisReportrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.SalesAnalysisReportrowwiseData.get("Brand");
		Globals.Inventory.Batch = Globals.Inventory.SalesAnalysisReportrowwiseData.get("Batch");
		Globals.Inventory.Batch1 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("VendorWise");
		Globals.Inventory.Batch2 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("DepartmentWise");
		Globals.Inventory.Batch3 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("CategoryWise");
		Globals.Inventory.Batch4 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("CategoryMargin");
		Globals.Inventory.Batch5 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("BrandWise");
		Globals.Inventory.Batch6 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("ClassWise");
		Globals.Inventory.Batch7 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("LocationWiseBill");
		Globals.Inventory.Batch8 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("LocationWiseSold");
		Globals.Inventory.Batch9 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("TerminalWiseProfit");
		Globals.Inventory.Batch10 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("PincodeWise");
		Globals.Inventory.Batch11 = Globals.Inventory.SalesAnalysisReportrowwiseData.get("DailySummarySalesReport");
		Globals.Inventory.Pincode = Globals.Inventory.SalesAnalysisReportrowwiseData.get("Pincode");
	}
	

	@Then("I fill new SalesAnalysisReport data page using excel data")
	public void i_fill_new_SalesAnalysisReport_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_radioButton_element(icp.VendorWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_radioButton_element(icp.DepartmentWiseProfit_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
				terPage.get_radioButton_element(icp.CategoryWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
				terPage.get_radioButton_element(icp.CategoryWiseMargin_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
				terPage.get_radioButton_element(icp.BrandWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
				terPage.get_radioButton_element(icp.ClassWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
				terPage.get_radioButton_element(icp.LocationWiseBill_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
				terPage.get_radioButton_element(icp.LocationWiseSold_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
				terPage.get_radioButton_element(icp.TerminalWiseProfit_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
				terPage.get_radioButton_element(icp.PincodeWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
				terPage.get_radioButton_element(icp.DailySummarySalesReport_String).click();
			}
			

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_rptDeptDrop_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement DepartmentValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_rptDeptDrop_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_rptDeptDrop_chzn div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Department);
			GenericWrappers.sleepInSeconds(1);
			DepartmentValue.sendKeys(Keys.SPACE);
			DepartmentValue.sendKeys(Keys.SPACE);
			DepartmentValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			DepartmentValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_rptCatDrop_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement CategoryValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_rptCatDrop_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_rptCatDrop_chzn div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Category);
			GenericWrappers.sleepInSeconds(1);
			CategoryValue.sendKeys(Keys.SPACE);
			CategoryValue.sendKeys(Keys.SPACE);
			CategoryValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			CategoryValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_rptBrandDrop_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement BrandValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_rptBrandDrop_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_rptBrandDrop_chzn div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Brand);
			GenericWrappers.sleepInSeconds(1);
			BrandValue.sendKeys(Keys.SPACE);
			BrandValue.sendKeys(Keys.SPACE);
			BrandValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			BrandValue.sendKeys(Keys.ENTER);

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtVendor")).sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Pincode)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddPinCode_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement PincodeValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddPinCode_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddPinCode_chzn div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Pincode);
			GenericWrappers.sleepInSeconds(1);
			PincodeValue.sendKeys(Keys.SPACE);
			PincodeValue.sendKeys(Keys.SPACE);
			PincodeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			PincodeValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromDate, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.FromDate).click();
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.ToDate, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.ToDate).click();
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Batch_String, Globals.Inventory.Batch);

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





