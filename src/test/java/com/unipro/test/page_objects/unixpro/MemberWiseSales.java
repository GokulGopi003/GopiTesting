package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class MemberWiseSales extends PageObject {
	MemberWiseSalestypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public MemberWiseSales(MemberWiseSalestypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the MemberWiseSales sheet data to map")
	public void i_load_the_MemberWiseSales_sheet_data_to_map() {
		Globals.Inventory.MemberWiseSalesSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME123);
	}

	@Then("I load the rowise MemberWiseSales data for {string} rowname")
	public void i_load_the_rowise_MemberWiseSales_data_for_rowname(String row_name) {
		Globals.Inventory.MemberWiseSalesrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.MemberWiseSalesSheetData, row_name);

		System.out.println(Globals.Inventory.MemberWiseSalesrowwiseData);
	}

	@Then("I update value to the MemberWiseSales page global Variables")
	public void i_update_value_to_the_MemberWiseSales_page_global_Variables() {
		Globals.Inventory.Customer = Globals.Inventory.MemberWiseSalesrowwiseData.get("Member");
		Globals.Inventory.Location = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberType");
		Globals.Inventory.Cashier = Globals.Inventory.MemberWiseSalesrowwiseData.get("MobileNumber");
		Globals.Inventory.Terminal = Globals.Inventory.MemberWiseSalesrowwiseData.get("Area");
		
		Globals.Inventory.Department = Globals.Inventory.MemberWiseSalesrowwiseData.get("Income");
		Globals.Inventory.Zone = Globals.Inventory.MemberWiseSalesrowwiseData.get("Zone");
		Globals.Inventory.Category = Globals.Inventory.MemberWiseSalesrowwiseData.get("InvoiceNo");
		
		Globals.Inventory.Batch1 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberListByIncome");
		Globals.Inventory.Batch2 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberPoints");
		Globals.Inventory.Batch3 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberPointsAdj");
		Globals.Inventory.Batch4 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberSalesSummary");
		Globals.Inventory.Batch5 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberSalesDetail");
		Globals.Inventory.Batch6 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberSalesWithItems");
		Globals.Inventory.Batch7 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberSalesZone");
		Globals.Inventory.Batch8 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberSalesLevel");
		Globals.Inventory.Batch9 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberCount");
		
		Globals.Inventory.Batch10 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberChangeByInvoice");
		Globals.Inventory.Batch11 = Globals.Inventory.MemberWiseSalesrowwiseData.get("MemberSalesComparision");
		Globals.Inventory.Batch21 = Globals.Inventory.MemberWiseSalesrowwiseData.get("NonVisitor");
		 Globals.Inventory.Batch22 = Globals.Inventory.MemberWiseSalesrowwiseData.get("High");
		 Globals.Inventory.Batch23 = Globals.Inventory.MemberWiseSalesrowwiseData.get("Low");
		  Globals.Inventory.Batch24 = Globals.Inventory.MemberWiseSalesrowwiseData.get("Year");
		  Globals.Inventory.Batch25 = Globals.Inventory.MemberWiseSalesrowwiseData.get("Month");
		  Globals.Inventory.Batch26 = Globals.Inventory.MemberWiseSalesrowwiseData.get("Week");
	     Globals.Inventory.Date = Globals.Inventory.MemberWiseSalesrowwiseData.get("Medium");
			
			Globals.Inventory.Batch = Globals.Inventory.MemberWiseSalesrowwiseData.get("ByDate");
			
		    Globals.Inventory.FromDate = Globals.Inventory.MemberWiseSalesrowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.MemberWiseSalesrowwiseData.get("ToDate");
	}

	@Then("I fill new MemberWiseSales data page using excel data")
	public void i_fill_new_MemberWiseSales_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.MemberListByIncome_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.MemberPoints_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.MemberPointsAdj_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.MemberSalesSummary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.MemberSalesDetail_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.MemberSalesWithItems_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.MemberSalesZone_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.MemberSalesLevel_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.MemberCount_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.MemberChangeByInvoice_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.MemberSalesComparision_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Customer)) {
			terpage.terminal_waitClearEnterText_css(icp.Member_String, Globals.Inventory.Customer);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Customer, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Customer).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.MemberType_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Cashier)) {
			terpage.terminal_waitClearEnterText_css(icp.MobileNumber_String, Globals.Inventory.Cashier);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Cashier, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Cashier).click();
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtMobileNo\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
			terpage.terminal_waitClearEnterText_css(icp.Area_String, Globals.Inventory.Terminal);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Terminal).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.Income_String, Globals.Inventory.Department);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Zone)) {
			terpage.terminal_waitClearEnterText_css(icp.Zone_String, Globals.Inventory.Zone);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Zone, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Zone).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terpage.terminal_waitClearEnterText_css(icp.Invoice_String, Globals.Inventory.Category);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch21)) {
			terPage.get_checkBox_element(icp.NonVisitor_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch22)) {
			terPage.get_radioButton_element(icp.High_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.get_radioButton_element(icp.Medium_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch23)) {
			terPage.get_radioButton_element(icp.Low_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch24)) {
			terPage.get_radioButton_element(icp.Year_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch25)) {
			terPage.get_radioButton_element(icp.Month_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch26)) {
			terPage.get_radioButton_element(icp.Week_String).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_radioButton_element(icp.ByDate_String).click();
		}
		pass.ExcelFourData("terminalnew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("terminalnew", "TerminalNew", "Pass", 1, 0, 1, 3);
		}
       catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("terminalnew","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("terminalnew", "TerminalNew", "FAIL", 1, 0, 1, 3);
}

		
		
		
		
		
	}


}
