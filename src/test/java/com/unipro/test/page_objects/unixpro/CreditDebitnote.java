package com.unipro.test.page_objects.unixpro;

	import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
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

	public class CreditDebitnote  extends PageObject {

		AddInventoryFormPage add_inventory;
		CreditDebitnotefield icp;
		CommonPages cp;
		ExcelWrite pass;
		Screenshot scr;

		TerminalPage terPage;
		

		public CreditDebitnote(CreditDebitnotefield icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			pass = new ExcelWrite();
			scr = new Screenshot();
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}
		
		@Then("I load the CreditDebitnote sheet data to map")
		public void i_load_the_GA_sheet_data_to_map() {

			//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.CreditDebitnoteSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME23);

		}
		@Then("I load the rowise CreditDebitnote data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.CreditDebitnoterowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CreditDebitnoteSheetData, row_name);

			System.out.println(Globals.Inventory.CreditDebitnoterowwiseData);

		}
		@Then("I update value to the CreditDebitnote page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.Batch = Globals.Inventory.CreditDebitnoterowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.CreditDebitnoterowwiseData.get("Batch1");
			Globals.Inventory.Batch2 = Globals.Inventory.CreditDebitnoterowwiseData.get("Batch2");
			Globals.Inventory.LocationCode = Globals.Inventory.CreditDebitnoterowwiseData.get("LocationCode");
			Globals.Inventory.Vendor = Globals.Inventory.CreditDebitnoterowwiseData.get("Vendor");
			Globals.Inventory.Billno = Globals.Inventory.CreditDebitnoterowwiseData.get("Billno");
			Globals.Inventory.Billdate = Globals.Inventory.CreditDebitnoterowwiseData.get("Billdate");
			Globals.Inventory.Vendorno = Globals.Inventory.CreditDebitnoterowwiseData.get("Vendorno");
			Globals.Inventory.Date = Globals.Inventory.CreditDebitnoterowwiseData.get("Date");
			Globals.Inventory.Description = Globals.Inventory.CreditDebitnoterowwiseData.get("Description");
			Globals.Inventory.TotalAmount = Globals.Inventory.CreditDebitnoterowwiseData.get("TotalAmount");
			Globals.Inventory.GST = Globals.Inventory.CreditDebitnoterowwiseData.get("GST");
			Globals.Inventory.Reason = Globals.Inventory.CreditDebitnoterowwiseData.get("Reason");
		}

		@Then("I fill new CreditDebitnote data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() throws Exception {
			try {
				
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terPage.get_checkBox_element(icp.Batch_String).click();

				    }
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
						terPage.get_checkBox_element(icp.Batch1_String).click();

					}
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
						terPage.get_checkBox_element(icp.Batch2_String).click();

					}
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlCDLocationCode_chzn")).click();
						GenericWrappers.sleepInSeconds(1);
						//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlCDLocationCode_chzn > div > div > input[type=text]"));
						String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCDLocationCode_chzn > div > div > input[type=text]";
						By ddlocator = By.cssSelector(css_location_dropDownValue);
						waitForExpectedElement(ddlocator);
						js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.LocationCode);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.ARROW_DOWN);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.ENTER);
		               
					}
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Billno)) {
						terPage.terminal_waitClearEnterText_css(icp.Billno_String, Globals.Inventory.Billno);
						

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Billdate)) {
						terPage.terminal_waitClearEnterText_css(icp.Billdate_String, Globals.Inventory.Billdate);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRefInvDate")).sendKeys(Keys.RETURN);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendorno)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendorno_String, Globals.Inventory.Vendorno);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
						terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtVendorCDDate")).sendKeys(Keys.RETURN);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
						terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Date);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.TotalAmount)) {
						terPage.terminal_waitClearEnterText_css(icp.TotalAmount_String, Globals.Inventory.TotalAmount);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlTaxPerc_chzn")).click();
						GenericWrappers.sleepInSeconds(1);
						//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlTaxPerc_chzn > div > div > input[type=text]"));
						String css_location_dropDownValue = "#ContentPlaceHolder1_ddlTaxPerc_chzn > div > div > input[type=text]";
						By ddlocator = By.cssSelector(css_location_dropDownValue);
						waitForExpectedElement(ddlocator);
						js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.GST);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.ARROW_DOWN);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.ENTER);
		               
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Reason)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlReason_chzn")).click();
						GenericWrappers.sleepInSeconds(1);
						//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlReason_chzn > div > div > input[type=text]"));
						String css_location_dropDownValue = "#ContentPlaceHolder1_ddlReason_chzn > div > div > input[type=text]";
						By ddlocator = By.cssSelector(css_location_dropDownValue);
						waitForExpectedElement(ddlocator);
						js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Reason);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.ARROW_DOWN);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.ENTER);
		               
					}	
					pass.ExcelFourData("CreditDebitnote ", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
					pass.Excelcreate("CreditDebitnote ", "Filters", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
	// Xl sheet write
				pass.ExcelFourData("CreditDebitnote ", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("CreditDebitnote ", "Filters", "FAIL", 1, 0, 1, 3);
			}
		}
		@Then("I need to click on the  print")
		public void i_update_value_to_the_CreditDebitnote_page_global_Variables() {
			WebElement ele = cp.waitForExpectedElement(By.xpath("//*[@id=\"tblSupplierNote\"]/tbody/tr/td[3]/input"), 3);
			ele.click();
			
		}
		@Then("I need to click on the  Delete")
		public void i_update_value_to_the_Delete() {
			WebElement ele = cp.waitForExpectedElement(By.xpath("//*[@id=\"tblSupplierNote\"]/tbody/tr/td[4]/input"), 3);
			ele.click();
		}
		   
		@Then("I close connection  DB for CreditDebitnote")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection  DB for CreditDebitnote")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from CreditDebitnote table {string} in DB")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where Vendorcode='V00750'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "tbldebitnote":

					String Sellingprice = "";
					try {
						Sellingprice = rs.getString("VendorCode");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), Sellingprice.trim());
						pass.Excelcreate("CreditDebitnote ", "tbldebitnote", "", 3, 0, 3, 1);
						pass.ExcelFourData("CreditDebitnote ", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("CreditDebitnote ", "tbldebitnote", "", 3, 0, 3, 1);
						pass.ExcelFourData("CreditDebitnote ", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column VendorCode");
					}
					String ReturnDate = "";
					try {
						ReturnDate = rs.getString("Vendorcnno");
						System.out.println(ReturnDate);
						Assert.assertEquals(Globals.Inventory.Vendorno.trim(), ReturnDate.trim());
						pass.ExcelFourData("CreditDebitnote ", "Vendorno", Globals.Inventory.Vendorno, ReturnDate, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Vendorno", Globals.Inventory.Vendorno, ReturnDate, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Vendorno");
					}
					String ReturnDate1 = "";
					try {
						ReturnDate1 = rs.getString("vendorcndate");
						System.out.println(ReturnDate1);
						Assert.assertEquals(Globals.Inventory.Date.trim(), ReturnDate1.trim());
						pass.ExcelFourData("CreditDebitnote ", "Date", Globals.Inventory.Date, ReturnDate1, "Pass", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Date", Globals.Inventory.Date, ReturnDate1, "Fail", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Date");
					}
					String Basiccost = "";
					try {
						Basiccost = rs.getString("Refinvoiceno");
						System.out.println(Basiccost);
						Assert.assertEquals(Globals.Inventory.Billno.trim(), Basiccost.trim());
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billno, Basiccost, "Pass", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billno, Basiccost, "Fail", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Billno");
					}
					String Refinvoicedate = "";
					try {
						Refinvoicedate = rs.getString("Refinvoicedate");
						System.out.println(Refinvoicedate);
						Assert.assertEquals(Globals.Inventory.Billdate.trim(), Refinvoicedate.trim());
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billdate, Refinvoicedate, "Pass", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billdate, Refinvoicedate, "Fail", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Billdate");
					}
					String Remarks = "";
					try {
						Remarks = rs.getString("Remarks");
						System.out.println(Remarks);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Remarks.trim());
						pass.ExcelFourData("CreditDebitnote ", "Description", Globals.Inventory.Description, Remarks, "Pass", 10, 0, 10, 1, 10,
								2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Description", Globals.Inventory.Description, Remarks, "Fail", 10, 0, 10, 1, 10,
								2, 10, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Description");
					}
					String TotalAmount = "";
					try {
						TotalAmount = rs.getString("TotalAmount");
						System.out.println(TotalAmount);
						Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), TotalAmount.trim());
						pass.ExcelFourData("CreditDebitnote ", "TotalAmount", Globals.Inventory.TotalAmount, TotalAmount, "Pass", 11, 0, 11, 1, 11,
								2, 11, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "TotalAmount", Globals.Inventory.TotalAmount, TotalAmount, "Fail", 11, 0, 11, 1, 11,
								2, 11, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column TotalAmount");
					}
					String Tax = "";
					try {
						Tax = rs.getString("Tax");
						System.out.println(Tax);
						Assert.assertEquals(Globals.Inventory.GST.trim(), Tax.trim());
						pass.ExcelFourData("CreditDebitnote ", "Tax", Globals.Inventory.GST, Tax, "Pass", 12, 0, 12, 1, 12,
								2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Tax", Globals.Inventory.GST, Tax, "Fail", 12, 0, 12, 1, 12,
								2, 12, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Tax");
					}
					String Reason = "";
					try {
						Reason = rs.getString("Reason");
						System.out.println(Reason);
						Assert.assertEquals(Globals.Inventory.Reason.trim(), Reason.trim());
						pass.ExcelFourData("CreditDebitnote ", "Reason", Globals.Inventory.Reason, Reason, "Pass", 13, 0, 13, 1, 13,
								2, 13, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Reason", Globals.Inventory.Reason, Reason, "Fail", 13, 0, 13, 1, 13,
								2, 13, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Reason");
					}
					break;

				case "tblAPtransaction":
					String Vendor = "";
					try {
						Vendor = rs.getString("VendorCode");
						System.out.println(Vendor);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendor.trim());
						pass.Excelcreate("CreditDebitnote ", "tblAPtransaction", "", 14, 0, 14, 1);
						pass.ExcelFourData("CreditDebitnote ", "Vendor", Globals.Inventory.Vendor, Vendor, "Pass", 15, 0, 15, 1, 15, 2,
								15, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("CreditDebitnote ", "tblAPtransaction", "", 14, 0, 14, 1);
						pass.ExcelFourData("CreditDebitnote ", "Vendor", Globals.Inventory.Vendor, Vendor, "Fail", 15, 0, 15, 1, 15, 2,
								15, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column VendorCode");
					}
					String Promotiontodate = "";
					try {
						Promotiontodate = rs.getString("Remarks");
						System.out.println(Promotiontodate);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Promotiontodate.trim());
						pass.ExcelFourData("CreditDebitnote ", "Reason", Globals.Inventory.Description, Promotiontodate, "Pass", 16, 0, 16, 1,
								16, 2, 16, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Reason", Globals.Inventory.Description, Promotiontodate, "Fail", 16, 0, 16, 1,
								16, 2, 16, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column Description");
					}
					String Basiccost1 = "";
					try {
						Basiccost1 = rs.getString("Refinvoiceno");
						System.out.println(Basiccost1);
						Assert.assertEquals(Globals.Inventory.Billno.trim(), Basiccost1.trim());
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billno, Basiccost1, "Pass", 17, 0, 17, 1, 17,
								2, 17, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billno, Basiccost1, "Fail",17, 0, 17, 1, 17,
								2, 17, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Billno");
					}
					String Refinvoicedate1 = "";
					try {
						Refinvoicedate1 = rs.getString("Refinvoicedate");
						System.out.println(Refinvoicedate1);
						Assert.assertEquals(Globals.Inventory.Billdate.trim(), Refinvoicedate1.trim());
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billdate, Refinvoicedate1, "Pass", 18, 0, 18, 1, 18,
								2, 18, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billdate, Refinvoicedate1, "Fail", 18, 0, 18, 1, 18,
								2, 18, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Billdate");
					}
					String TranAmt = "";
					try {
						TranAmt = rs.getString("TranAmt");
						System.out.println(TranAmt);
						Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), TranAmt.trim());
						pass.ExcelFourData("CreditDebitnote ", "TotalAmount", Globals.Inventory.TotalAmount, TranAmt, "Pass", 19, 0, 19, 1, 19,
								2, 19, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "TotalAmount", Globals.Inventory.TotalAmount, TranAmt, "Fail", 19, 0, 19, 1, 19,
								2, 19, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column TranAmt");
					}
					String CreditAmt = "";
					try {
						CreditAmt = rs.getString("CreditAmt");
						System.out.println(CreditAmt);
						Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), CreditAmt.trim());
						pass.ExcelFourData("CreditDebitnote ", "CreditAmt", Globals.Inventory.TotalAmount, CreditAmt, "Pass", 20, 0, 20, 1, 20,
								2, 20, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "CreditAmt", Globals.Inventory.TotalAmount, CreditAmt, "Fail", 20, 0, 20, 1, 20,
								2, 20, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column CreditAmt");
					}
					String BalanceAmt = "";
					try {
						BalanceAmt = rs.getString("BalanceAmt");
						System.out.println(BalanceAmt);
						Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), BalanceAmt.trim());
						pass.ExcelFourData("CreditDebitnote ", "TotalAmount", Globals.Inventory.TotalAmount, BalanceAmt, "Pass", 21, 0, 21, 1, 21,
								2, 21, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "TotalAmount", Globals.Inventory.TotalAmount, BalanceAmt, "Fail", 21, 0, 21, 1, 21,
								2, 21, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column BalanceAmt");
					}
					break;
				default:
					break;
				}

			}
		}
		
	}




