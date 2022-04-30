package com.unipro.test.page_objects.unixpro;


	import java.awt.RenderingHints.Key;
	import java.io.IOException;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;

	import com.gk.test.MssqlConnect;
	import com.unipro.ExcelWrite;
	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
	import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;

	public class SalesTransaction extends PageObject {

		AddInventoryFormPage add_inventory;
		SalesTransactionField icp;
		CommonPages cp;

		TerminalPage terPage;
		ExcelWrite pass;
		Screenshot scr;

		public SalesTransaction(SalesTransactionField icp, CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();

			this.cp = cp;
			add_inventory = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();
		}

		@Then("I load the SalesTransaction sheet data to map")
		public void i_load_the_PR_sheet_data_to_map() {

			// Globals.Inventory.inventorySheetData1 =
			// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.SalesTransactionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME63);

		}

		@Then("I load the rowise SalesTransaction data for {string} rowname")
		public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

			Globals.Inventory.SalesTransactionrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.SalesTransactionSheetData, row_name);

			System.out.println(Globals.Inventory.SalesTransactionrowwiseData);

		}

		@Then("I update value to the SalesTransaction page global Variables")
		public void i_update_value_to_the_PR_page_global_Variables() {
			Globals.Inventory.Billno = Globals.Inventory.SalesTransactionrowwiseData.get("Billno");
			Globals.Inventory.Paymode = Globals.Inventory.SalesTransactionrowwiseData.get("Paymode");
			Globals.Inventory.Cashier = Globals.Inventory.SalesTransactionrowwiseData.get("Cashier");
			Globals.Inventory.Terminal = Globals.Inventory.SalesTransactionrowwiseData.get("Terminal");
			Globals.Inventory.CustomerCode = Globals.Inventory.SalesTransactionrowwiseData.get("CustomerCode");
			Globals.Inventory.MinAmt = Globals.Inventory.SalesTransactionrowwiseData.get("MinAmt");
			Globals.Inventory.MaxAmt = Globals.Inventory.SalesTransactionrowwiseData.get("MaxAmt");
			Globals.Inventory.CashSales = Globals.Inventory.SalesTransactionrowwiseData.get("CashSales");
			Globals.Inventory.CreditSales = Globals.Inventory.SalesTransactionrowwiseData.get("CreditSales");
			Globals.Inventory.CancelBill = Globals.Inventory.SalesTransactionrowwiseData.get("CancelBill");
			Globals.Inventory.ExchangeBill = Globals.Inventory.SalesTransactionrowwiseData.get("ExchangeBill");
			Globals.Inventory.DiscountBill = Globals.Inventory.SalesTransactionrowwiseData.get("DiscountBill");
			Globals.Inventory.SalesReturnBill = Globals.Inventory.SalesTransactionrowwiseData.get("SalesReturnBill");
			Globals.Inventory.FromDate = Globals.Inventory.SalesTransactionrowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.SalesTransactionrowwiseData.get("ToDate");
			Globals.Inventory.Date = Globals.Inventory.SalesTransactionrowwiseData.get("Date");
			Globals.Inventory.LocationCode = Globals.Inventory.SalesTransactionrowwiseData.get("LocationCode");
			Globals.Inventory.NewFromDate = Globals.Inventory.SalesTransactionrowwiseData.get("NewFromDate");
			Globals.Inventory.NewToDate = Globals.Inventory.SalesTransactionrowwiseData.get("NewToDate");
			
		}

		@Then("I fill new SalesTransaction data page using excel data")
		public void i_fill_new_PR_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Billno)) {
					terPage.terminal_waitClearEnterText_css(icp.Billno_String, Globals.Inventory.Billno);

					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Paymode)) {
					terPage.terminal_waitClearEnterText_css(icp.Paymode_String, Globals.Inventory.Paymode);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.Paymode, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.Paymode).click();
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Cashier)) {
					terPage.terminal_waitClearEnterText_css(icp.Cashier_String, Globals.Inventory.Cashier);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.Cashier, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.Cashier).click();
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
					terPage.terminal_waitClearEnterText_css(icp.Terminal_String, Globals.Inventory.Terminal);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.Terminal).click();
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.CustomerCode)) {
					terPage.terminal_waitClearEnterText_css(icp.CustomerCode_String, Globals.Inventory.CustomerCode);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.CustomerCode, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.CustomerCode).click();
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.MinAmt)) {
					terPage.terminal_waitClearEnterText_css(icp.MinAmt_String, Globals.Inventory.MinAmt);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.MinAmt, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.MinAmt).click();
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.MaxAmt)) {
					terPage.terminal_waitClearEnterText_css(icp.MaxAmt_String, Globals.Inventory.MaxAmt);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.MaxAmt, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.MaxAmt).click();
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.NewFromDate)) {
					terPage.terminal_waitClearEnterText_css(icp.NewFromDate_String, Globals.Inventory.NewFromDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.NewToDate)) {
					terPage.terminal_waitClearEnterText_css(icp.NewToDate_String, Globals.Inventory.NewToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.CashSales)) {
					terPage.get_checkBox_element(icp.CashSales_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditSales)) {
					terPage.get_checkBox_element(icp.CreditSales_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.CancelBill)) {
					terPage.get_checkBox_element(icp.CancelBill_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ExchangeBill)) {
					terPage.get_checkBox_element(icp.ExchangeBill_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountBill)) {
					terPage.get_checkBox_element(icp.DiscountBill_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesReturnBill)) {
					terPage.get_checkBox_element(icp.SalesReturnBill_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
					terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSettlementDate")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
					terPage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.LocationCode, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.LocationCode).click();
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).click();
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
					terPage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCFromdate")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
					terPage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCTodate")).sendKeys(Keys.RETURN);
					
				}
				pass.ExcelFourData("CustomerReceipts", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("CustomerReceipts", "Filters", "Pass", 1, 0, 1, 3);
			   } 
			  catch (Exception e) {
	// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
	// Xl sheet write
				pass.ExcelFourData("CustomerReceipts", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("CustomerReceipts", "Filters", "FAIL", 1, 0, 1, 3);

			}
		}

		

}


