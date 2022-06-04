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

public class SalesAnalysisMemberReport extends PageObject {
	SalesAnalysisMemberReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	TerminalPage terpage;
	Screenshot scr;
	public SalesAnalysisMemberReport(SalesAnalysisMemberReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr = new Screenshot();

}
	@Then("I load the SalesAnalysisMemberReport sheet data to map")
	public void i_load_the_SalesAnalysisMemberReport_sheet_data_to_map() {
		Globals.Inventory.SalesAnalysisMemberReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME99);
	}

	@Then("I load the rowise SalesAnalysisMemberReport data for {string} rowname")
	public void i_load_the_rowise_SalesAnalysisMemberReport_data_for_rowname(String row_name) {
		Globals.Inventory.SalesAnalysisMemberReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SalesAnalysisMemberReportSheetData, row_name);

		System.out.println(Globals.Inventory.SalesAnalysisMemberReportrowwiseData);
	}

	@Then("I update value to the SalesAnalysisMemberReport page global Variables")
	public void i_update_value_to_the_SalesAnalysisMemberReport_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("Department");
		Globals.Inventory.FromDate = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("ToDate");
		Globals.Inventory.Category = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("Brand");
		Globals.Inventory.Batch = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("Batch");
		Globals.Inventory.Batch1 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("InActive");
		Globals.Inventory.Batch2 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("All");
		Globals.Inventory.Batch3 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("MemberDetails");
		Globals.Inventory.Batch4 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("MemberList");
		Globals.Inventory.Batch5 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("MemberTransaction");
		Globals.Inventory.Batch6 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("MemberPointAdj");
		Globals.Inventory.Batch7 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("AgeGroup");
		Globals.Inventory.Batch8 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("IncomeGroup");
		Globals.Inventory.Batch9 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("MemberListByAge");
		Globals.Inventory.Batch10 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("MemberListByIncome");
		Globals.Inventory.Batch11 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("MemberOutstanding");
		Globals.Inventory.Customer = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("Membercode");
		Globals.Inventory.Batch12 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("GiftIssued");
		Globals.Inventory.Batch13 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("DayWiseSales");
		Globals.Inventory.Batch14 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("CreditSales");
		Globals.Inventory.Batch15 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("HourlySale");
		Globals.Inventory.Batch16 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("AvgPurchaseProfit");
		//Globals.Inventory.Batch17 = Globals.Inventory.SalesAnalysisMemberReportrowwiseData.get("AvgPurchaseProfit");
	}
	

	@Then("I fill new SalesAnalysisMemberReport data page using excel data")
	public void i_fill_new_SalesAnalysisMemberReport_data_page_using_excel_data() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_radioButton_element(icp.InActive_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_radioButton_element(icp.All_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
				terPage.get_radioButton_element(icp.MemberDetails_String).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
				terPage.get_radioButton_element(icp.MemberList_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
				terPage.get_radioButton_element(icp.MemberTransaction_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
				terPage.get_radioButton_element(icp.MemberPointAdj_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
				terPage.get_radioButton_element(icp.AgeGroup_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
				terPage.get_radioButton_element(icp.IncomeGroup_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
				terPage.get_radioButton_element(icp.MemberListByAge_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
				terPage.get_radioButton_element(icp.MemberListByIncome_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
				terPage.get_radioButton_element(icp.MemberOutstanding_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
				terPage.get_radioButton_element(icp.GiftIssued_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch13)) {
				terPage.get_radioButton_element(icp.DayWiseSales_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch14)) {
				terPage.get_radioButton_element(icp.CreditSales_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch15)) {
				terPage.get_radioButton_element(icp.HourlySales_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch16)) {
				terPage.get_radioButton_element(icp.AvgPurchase_String).click();
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Customer)) {
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_DropMemberCode_chzn")).click();
				GenericWrappers.sleepInSeconds(1);

				WebElement DepartmentValue = webDriver
						.findElement(By.cssSelector("#ContentPlaceHolder1_DropMemberCode_chzn div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_DropMemberCode_chzn div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Customer);
				GenericWrappers.sleepInSeconds(1);
				DepartmentValue.sendKeys(Keys.SPACE);
				DepartmentValue.sendKeys(Keys.SPACE);
				DepartmentValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				DepartmentValue.sendKeys(Keys.ENTER);

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


