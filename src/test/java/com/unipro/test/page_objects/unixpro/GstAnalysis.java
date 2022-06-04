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

public class GstAnalysis extends PageObject {
	GstAnalysistypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public GstAnalysis(GstAnalysistypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();


}
	@Then("I load the GstAnalysis sheet data to map")
	public void i_load_the_GstAnalysis_sheet_data_to_map() {
		Globals.Inventory.GstAnalysisSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME101);
	}

	@Then("I load the rowise GstAnalysis data for {string} rowname")
	public void i_load_the_rowise_GstAnalysis_data_for_rowname(String row_name) {
		Globals.Inventory.GstAnalysisrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.GstAnalysisSheetData, row_name);

		System.out.println(Globals.Inventory.GstAnalysisrowwiseData);
	}

	@Then("I update value to the GstAnalysis page global Variables")
	public void i_update_value_to_the_GstAnalysis_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.GstAnalysisrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.GstAnalysisrowwiseData.get("Date");
		Globals.Inventory.FromDate = Globals.Inventory.GstAnalysisrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.GstAnalysisrowwiseData.get("ToDate");
		Globals.Inventory.Terminal = Globals.Inventory.GstAnalysisrowwiseData.get("Month");
		Globals.Inventory.Brand = Globals.Inventory.GstAnalysisrowwiseData.get("None");
		Globals.Inventory.Batch = Globals.Inventory.GstAnalysisrowwiseData.get("Batch");
		Globals.Inventory.Batch1 = Globals.Inventory.GstAnalysisrowwiseData.get("PurchaseGstInvoiceWise");
		Globals.Inventory.Batch2 = Globals.Inventory.GstAnalysisrowwiseData.get("PurchaseGstItemWise");
		Globals.Inventory.Batch3 = Globals.Inventory.GstAnalysisrowwiseData.get("SalesGst");
		Globals.Inventory.Batch4 = Globals.Inventory.GstAnalysisrowwiseData.get("SalesGstInvoiceWise");
		Globals.Inventory.Batch5 = Globals.Inventory.GstAnalysisrowwiseData.get("SalesGstItemWise");
		Globals.Inventory.Batch6 = Globals.Inventory.GstAnalysisrowwiseData.get("PaymodeWiseGst");
		Globals.Inventory.Batch7 = Globals.Inventory.GstAnalysisrowwiseData.get("PurchaseReturnGst");
		Globals.Inventory.Batch8 = Globals.Inventory.GstAnalysisrowwiseData.get("PurchaseReturnGstDetail");
		Globals.Inventory.Batch9 = Globals.Inventory.GstAnalysisrowwiseData.get("SalesReturnGst");
		Globals.Inventory.Batch10 = Globals.Inventory.GstAnalysisrowwiseData.get("SalesReturnGstItemWise");
		Globals.Inventory.Batch11 = Globals.Inventory.GstAnalysisrowwiseData.get("SalesReturnGstInvoiceWise");
		Globals.Inventory.Batch12 = Globals.Inventory.GstAnalysisrowwiseData.get("CreditSales");
		Globals.Inventory.Batch13 = Globals.Inventory.GstAnalysisrowwiseData.get("SalesGstLocationWise");
		Globals.Inventory.Batch14 = Globals.Inventory.GstAnalysisrowwiseData.get("SalesGstHsnCodeWise");
		Globals.Inventory.Batch15 = Globals.Inventory.GstAnalysisrowwiseData.get("PurchaseGstHsnCodeWise");
		Globals.Inventory.Batch16 = Globals.Inventory.GstAnalysisrowwiseData.get("GstLiabilitySummerReort");
		Globals.Inventory.Batch17 = Globals.Inventory.GstAnalysisrowwiseData.get("GstLiabilityDetailReport");
		//Globals.Inventory.Batch1 = Globals.Inventory.GstAnalysisrowwiseData.get("None");
	}

	@Then("I fill new GstAnalysis data page using excel data")
	public void i_fill_new_GstAnalysis_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_radioButton_element(icp.PurchaseGstInvoiceWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_radioButton_element(icp.PurchaseGstItemWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
				terPage.get_radioButton_element(icp.SalesGst_String).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
				terPage.get_radioButton_element(icp.SalesGstInvoiceWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
				terPage.get_radioButton_element(icp.SalesGstItemWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
				terPage.get_radioButton_element(icp.PaymodeWiseGst_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
				terPage.get_radioButton_element(icp.PurchaseReturnGst_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
				terPage.get_radioButton_element(icp.PurchaseReturnGstDetail_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
				terPage.get_radioButton_element(icp.SalesReturnGst_String).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
				terPage.get_radioButton_element(icp.SalesReturnGstItemwise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
				terPage.get_radioButton_element(icp.SalesReturnGstInvoiceWise_String).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
				terPage.get_radioButton_element(icp.CreditSales_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
				terPage.get_radioButton_element(icp.SalesGstLocationWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
				terPage.get_radioButton_element(icp.SalesGstHsnCode_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
				terPage.get_radioButton_element(icp.PurchaseGstHsnCodeWise_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
				terPage.get_radioButton_element(icp.GstLiabilitySummerReport_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch17)) {
				terPage.get_radioButton_element(icp.GstLiabilityDetailReport_String).click();
			}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terPage.get_radioButton_element(icp.Date_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
			terPage.get_radioButton_element(icp.Month_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terPage.get_radioButton_element(icp.None_String).click();
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