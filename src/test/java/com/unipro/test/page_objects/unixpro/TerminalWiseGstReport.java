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

public class TerminalWiseGstReport extends PageObject {
	TerminalWiseGstTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public TerminalWiseGstReport(TerminalWiseGstTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();

}

	@Then("I load the TerminalWiseGstAnalysis sheet data to map")
	public void i_load_the_TerminalWiseGstAnalysis_sheet_data_to_map() {
		Globals.Inventory.TerminalWiseGstAnalysisSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME100);
	}

	@Then("I load the rowise TerminalWiseGstAnalysis data for {string} rowname")
	public void i_load_the_rowise_TerminalWiseGstAnalysis_data_for_rowname(String row_name) {
		Globals.Inventory.TerminalWiseGstAnalysisrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.TerminalWiseGstAnalysisSheetData, row_name);

		System.out.println(Globals.Inventory.TerminalWiseGstAnalysisrowwiseData);
	}

	@Then("I update value to the TerminalWiseGstAnalysis page global Variables")
	public void i_update_value_to_the_TerminalWiseGstAnalysis_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("Department");
		Globals.Inventory.FromDate = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("ToDate");
		Globals.Inventory.Terminal = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("Terminal");
		Globals.Inventory.Brand = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("Date");
		Globals.Inventory.Batch = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("Batch");
		//Globals.Inventory.Batch1 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("Month");
		//Globals.Inventory.Batch2 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("None");
		Globals.Inventory.Batch3 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("SalesGstInvoiceWise");
		Globals.Inventory.Batch4 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("SalesGstItemWise");
		Globals.Inventory.Batch5 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("SalesReturnGst");
		Globals.Inventory.Batch6 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("SalesReturnGstInvoiceWise");
		Globals.Inventory.Batch7 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("SalesReturnGstItemWise");
		Globals.Inventory.Batch8 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("CreditSales");
		Globals.Inventory.Batch9 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("SalesGstLocationWise");
		Globals.Inventory.Batch10 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("SalesGstHsnCodeWise");
		Globals.Inventory.Batch11 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("Month");
		Globals.Inventory.Batch12 = Globals.Inventory.TerminalWiseGstAnalysisrowwiseData.get("None");
	}

	@Then("I fill new TerminalWiseGstAnalysis data page using excel data")
	public void i_fill_new_TerminalWiseGstAnalysis_data_page_using_excel_data() throws Exception {

			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terPage.get_radioButton_element(icp.SalesGstInvoiceWise_String).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
					terPage.get_radioButton_element(icp.SalesGstItemWise_String).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
					terPage.get_radioButton_element(icp.SalesReturnGst_String).click();
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
					terPage.get_radioButton_element(icp.SalesReturnGstInvoiceWise_String).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
					terPage.get_radioButton_element(icp.SalesReturnGstItemWise_String).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
					terPage.get_radioButton_element(icp.CreditSales_String).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
					terPage.get_radioButton_element(icp.SalesGstLocationWise_String).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
					terPage.get_radioButton_element(icp.SalesGstHsnCodeWise_String).click();
				}
				/*if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
					terPage.get_radioButton_element(icp.IncomeGroup_String).click();
				}*/
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
				terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
				terpage.terminal_waitClearEnterText_css(icp.Terminal_String, Globals.Inventory.Terminal);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Terminal).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
				terpage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
				terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
				
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
				terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
				
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Batch_String, Globals.Inventory.Batch);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
				terPage.get_radioButton_element(icp.Date_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
				terPage.get_radioButton_element(icp.Month_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
				terPage.get_radioButton_element(icp.None_String).click();
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

