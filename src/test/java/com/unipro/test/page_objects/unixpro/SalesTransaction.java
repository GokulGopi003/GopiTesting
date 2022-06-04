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
				/*if (GenericWrappers.isNotEmpty(Globals.Inventory.CustomerCode)) {
					terPage.terminal_waitClearEnterText_css(icp.CustomerCode_String, Globals.Inventory.CustomerCode);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.CustomerCode, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.CustomerCode).click();
					
				}*/
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.MinAmt)) {
					terPage.terminal_waitClearEnterText_css(icp.MinAmt_String, Globals.Inventory.MinAmt);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.MinAmt, "input#txtSearch");
					//add_inventory.return_td_invoke_element(Globals.Inventory.MinAmt).click();
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMinimumAmt")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.MaxAmt)) {
					terPage.terminal_waitClearEnterText_css(icp.MaxAmt_String, Globals.Inventory.MaxAmt);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.MaxAmt, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.MaxAmt).click();
					
				}
				/*if (GenericWrappers.isNotEmpty(Globals.Inventory.NewFromDate)) {
					terPage.terminal_waitClearEnterText_css(icp.NewFromDate_String, Globals.Inventory.NewFromDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.NewToDate)) {
					terPage.terminal_waitClearEnterText_css(icp.NewToDate_String, Globals.Inventory.NewToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
					
				}*/
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
				pass.ExcelFourData("SalesTransaction", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("SalesTransaction", "Filters", "Pass", 1, 0, 1, 3);
			   } 
			  catch (Exception e) {
	// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
	// Xl sheet write
				pass.ExcelFourData("SalesTransaction", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("SalesTransaction", "Filters", "FAIL", 1, 0, 1, 3);

			}
		}
		@Then("I close connection  DB for SalesTransaction")
		public void i_close_connection_DB_for_SalesTransaction() {
			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;  
		
		@Then("I establish connection  DB for SalesTransaction")
		public void i_establish_connection_DB_for_SalesTransaction() throws SQLException {
			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully"); 
		}

		@Then("I read the values from SalesTransaction table {string} in DB")
		public void i_read_the_values_from_SalesTransaction_table_in_DB(String tablename) throws SQLException, IOException {
			ResultSet rs = st.executeQuery("select * from " + tablename + " where InvoiceNo='CRT1005797'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "vwPaymodeDetail":

					String Billno = "";
					try {
						Billno = rs.getString("InvoiceNo");
						System.out.println(Billno);
						Assert.assertEquals(Globals.Inventory.Billno.trim(), Billno.trim());
						pass.Excelcreate("SalesTransaction", "vwPaymodeDetail", "", 3, 0, 3, 1);
						pass.ExcelFourData("SalesTransaction", "InvoiceNo", Globals.Inventory.Billno, Billno, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("SalesTransaction", "vwPaymodeDetail", "", 3, 0, 3, 1);
						pass.ExcelFourData("SalesTransaction", "InvoiceNo", Globals.Inventory.Billno, Billno, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column PaymentDate");
					}
					String Paymode = "";
					try {
						Paymode = rs.getString("PayMode");
						System.out.println(Paymode);
						Assert.assertEquals(Globals.Inventory.Paymode.trim(), Paymode.trim());
						pass.ExcelFourData("SalesTransaction", "Paymode", Globals.Inventory.Paymode, Paymode, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "Paymode", Globals.Inventory.Paymode, Paymode, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column VoucherRef");
					}
					String Cashier = "";
					try {
						Cashier = rs.getString("CreateUser");
						System.out.println(Cashier);
						Assert.assertEquals(Globals.Inventory.Cashier.trim(), Cashier.trim());
						pass.ExcelFourData("SalesTransaction", "Cashier", Globals.Inventory.Cashier, Cashier, "Pass", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "Cashier", Globals.Inventory.Cashier, Cashier, "Fail", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column RefDate");
					}
					String LocationCode = "";
					try {
						LocationCode = rs.getString("Locationcode");
						System.out.println(LocationCode);
						Assert.assertEquals(Globals.Inventory.LocationCode.trim(), LocationCode.trim());
						pass.ExcelFourData("SalesTransaction", "LocationCode", Globals.Inventory.LocationCode, LocationCode, "Pass", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "SalesTransaction", Globals.Inventory.LocationCode, LocationCode, "Fail", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column Vendor");
					}
					String Paidamount = "";
					try {
						Paidamount = rs.getString("Amount");
						System.out.println(Paidamount);
						Assert.assertEquals(Globals.Inventory.MinAmt.trim(), Paidamount.trim());
						pass.ExcelFourData("SalesTransaction", "Amount", Globals.Inventory.MinAmt, Paidamount, "Pass", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "Amount", Globals.Inventory.MinAmt, Paidamount, "Fail", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column TotalAmount");
					}
					/*String Paymenttype = "";
					try {
						Paymenttype = rs.getString("Paidamount");
						System.out.println(Paymenttype);
						Assert.assertEquals(Globals.Inventory.Paymode1.trim(), Paymenttype.trim());
						pass.ExcelFourData("Payments", "Paymode", Globals.Inventory.Paymode1, Paymenttype, "Pass", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments", "Paymode", Globals.Inventory.Paymode1, Paymenttype, "Fail", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column Paymode");
					}*/

					break;

				case "vwSalesheader":
					String InvoiceNo = "";
					try {
						InvoiceNo = rs.getString("InvoiceNo");
						System.out.println(InvoiceNo);
						Assert.assertEquals(Globals.Inventory.Billno.trim(), InvoiceNo.trim());
						pass.Excelcreate("SalesTransaction", "tblPaymentDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("SalesTransaction", "InvoiceNo", Globals.Inventory.Billno, InvoiceNo, "Pass", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("SalesTransaction", "tblPaymentDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("SalesTransaction", "InvoiceNo", Globals.Inventory.Billno, InvoiceNo, "Fail", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Createdate");
					}
					String Paymode1 = "";
					try {
						Paymode1 = rs.getString("SalesType");
						System.out.println(Paymode1);
						Assert.assertEquals(Globals.Inventory.Paymode.trim(), Paymode1.trim());
						pass.ExcelFourData("SalesTransaction", "SalesType", Globals.Inventory.Paymode, Paymode1, "Pass", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "SalesType", Globals.Inventory.Paymode, Paymode1, "Fail", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Referanceno");
					}
					
					String Cashier1 = "";
					try {
						Cashier1 = rs.getString("CashierID");
						System.out.println(Cashier1);
						Assert.assertEquals(Globals.Inventory.Cashier.trim(), Cashier1.trim());
						//pass.Excelcreate("Payments", "tblRTGS", "", 14, 0, 14, 1);
						pass.ExcelFourData("SalesTransaction", "Cashier", Globals.Inventory.Cashier, Cashier1, "Pass", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (AssertionError e) {
						//pass.Excelcreate("Payments", "tblRTGS", "", 14, 0, 14, 1);
						pass.ExcelFourData("SalesTransaction", "Cashier", Globals.Inventory.Cashier, Cashier1, "Fail", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Vendorname");
					}
					String LocationCode1 = "";
					try {
						LocationCode1 = rs.getString("LocationCode");
						System.out.println(LocationCode1);
						Assert.assertEquals(Globals.Inventory.LocationCode.trim(), LocationCode1.trim());
						pass.ExcelFourData("SalesTransaction", "LocationCode", Globals.Inventory.LocationCode, LocationCode1, "Pass", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "LocationCode", Globals.Inventory.LocationCode, LocationCode1, "Fail", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Refno");
					}
					String Terminal1 = "";
					try {
						Terminal1 = rs.getString("TerminalCode");
						System.out.println(Terminal1);
						Assert.assertEquals(Globals.Inventory.Terminal.trim(), Terminal1.trim());
						pass.ExcelFourData("SalesTransaction", "TerminalCode", Globals.Inventory.Terminal, Terminal1, "Pass", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "TerminalCode", Globals.Inventory.Terminal, Terminal1, "Fail", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Amount");
					}
					String MinAmt = "";
					try {
						MinAmt = rs.getString("NetTotal");
						System.out.println(MinAmt);
						Assert.assertEquals(Globals.Inventory.MinAmt.trim(), MinAmt.trim());
						pass.ExcelFourData("SalesTransaction", "NetTotal", Globals.Inventory.MinAmt, MinAmt, "Pass", 18, 0, 18, 1, 18, 2, 18,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "NetTotal", Globals.Inventory.MinAmt, MinAmt, "Fail", 18, 0, 18, 1, 18, 2, 18,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column RefDate");
					}
					String MaxAmt = "";
					try {
						MaxAmt = rs.getString("TotalValue");
						System.out.println(MaxAmt);
						Assert.assertEquals(Globals.Inventory.MaxAmt.trim(), MaxAmt.trim());
						pass.ExcelFourData("SalesTransaction", "TotalValue", Globals.Inventory.MaxAmt, MaxAmt, "Pass", 19, 0, 19, 1, 19, 2, 19,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesTransaction", "TotalValue", Globals.Inventory.MaxAmt, MaxAmt, "Fail", 19, 0, 19, 1, 19, 2, 19,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column BankCode1");
					}
					break;
				/*case "tblAPtransaction":
					String Vendor1 = "";
					try {
						Vendor1 = rs.getString("VendorCode");
						System.out.println(Vendor1);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendor1.trim());
						pass.Excelcreate("Payments ", "tblAPtransaction", "", 14, 0, 14, 1);
						pass.ExcelFourData("Payments ", "Vendor", Globals.Inventory.Vendor, Vendor1, "Pass", 15, 0, 15, 1, 15, 2,
								15, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("Payments ", "tblAPtransaction", "", 14, 0, 14, 1);
						pass.ExcelFourData("Payments ", "Vendor", Globals.Inventory.Vendor, Vendor1, "Fail", 15, 0, 15, 1, 15, 2,
								15, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column VendorCode");
					}
					String Promotiontodate1 = "";
					try {
						Promotiontodate1 = rs.getString("Remarks");
						System.out.println(Promotiontodate1);
						Assert.assertEquals(Globals.Inventory.Refno.trim(), Promotiontodate1.trim());
						pass.ExcelFourData("Payments ", "Refno", Globals.Inventory.Refno, Promotiontodate1, "Pass", 16, 0, 16, 1,
								16, 2, 16, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments ", "Refno", Globals.Inventory.Refno, Promotiontodate1, "Fail", 16, 0, 16, 1,
								16, 2, 16, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column Refno");
					}
					String Basiccost1 = "";
					try {
						Basiccost1 = rs.getString("Refinvoiceno");
						System.out.println(Basiccost1);
						Assert.assertEquals(Globals.Inventory.Billno.trim(), Basiccost1.trim());
						pass.ExcelFourData("Payments ", "Billno", Globals.Inventory.Billno, Basiccost1, "Pass", 17, 0, 17, 1, 17,
								2, 17, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments ", "Billno", Globals.Inventory.Billno, Basiccost1, "Fail",17, 0, 17, 1, 17,
								2, 17, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column Billno");
					}
					String Refinvoicedate1 = "";
					try {
						Refinvoicedate1 = rs.getString("Refinvoicedate");
						System.out.println(Refinvoicedate1);
						Assert.assertEquals(Globals.Inventory.Date.trim(), Refinvoicedate1.trim());
						pass.ExcelFourData("Payments ", "Date", Globals.Inventory.Date, Refinvoicedate1, "Pass", 18, 0, 18, 1, 18,
								2, 18, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments ", "Date", Globals.Inventory.Date, Refinvoicedate1, "Fail", 18, 0, 18, 1, 18,
								2, 18, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column Billdate");
					}
					String TranAmt = "";
					try {
						TranAmt = rs.getString("TranAmt");
						System.out.println(TranAmt);
						Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), TranAmt.trim());
						pass.ExcelFourData("Payments ", "TotalAmount", Globals.Inventory.TotalAmount, TranAmt, "Pass", 19, 0, 19, 1, 19,
								2, 19, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments ", "TotalAmount", Globals.Inventory.TotalAmount, TranAmt, "Fail", 19, 0, 19, 1, 19,
								2, 19, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column TranAmt");
					}
					String CreditAmt = "";
					try {
						CreditAmt = rs.getString("CreditAmt");
						System.out.println(CreditAmt);
						Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), CreditAmt.trim());
						pass.ExcelFourData("Payments ", "CreditAmt", Globals.Inventory.TotalAmount, CreditAmt, "Pass", 20, 0, 20, 1, 20,
								2, 20, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments ", "CreditAmt", Globals.Inventory.TotalAmount, CreditAmt, "Fail", 20, 0, 20, 1, 20,
								2, 20, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column CreditAmt");
					}
					String BalanceAmt = "";
					try {
						BalanceAmt = rs.getString("BalanceAmt");
						System.out.println(BalanceAmt);
						Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), BalanceAmt.trim());
						pass.ExcelFourData("Payments ", "TotalAmount", Globals.Inventory.TotalAmount, BalanceAmt, "Pass", 21, 0, 21, 1, 21,
								2, 21, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments ", "TotalAmount", Globals.Inventory.TotalAmount, BalanceAmt, "Fail", 21, 0, 21, 1, 21,
								2, 21, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column BalanceAmt");
					}					
					break;
				case "tblDebitNote":
					String VendorCode = "";
					try {
						VendorCode = rs.getString("VendorCode");
						System.out.println(VendorCode);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), VendorCode.trim());
						pass.Excelcreate("CreditDebitnote ", "tbldebitnote", "", 3, 0, 3, 1);
						pass.ExcelFourData("CreditDebitnote ", "VendorCode", Globals.Inventory.Vendor, VendorCode, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("CreditDebitnote ", "tbldebitnote", "", 3, 0, 3, 1);
						pass.ExcelFourData("CreditDebitnote ", "VendorCode", Globals.Inventory.Vendor, VendorCode, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column VendorCode");
					}
					String Vendorcnno = "";
					try {
						Vendorcnno = rs.getString("Vendorcnno");
						System.out.println(Vendorcnno);
						Assert.assertEquals(Globals.Inventory.Vendorno.trim(), Vendorcnno.trim());
						pass.ExcelFourData("CreditDebitnote ", "Vendorno", Globals.Inventory.Vendorno, Vendorcnno, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Vendorno", Globals.Inventory.Vendorno, Vendorcnno, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Vendorno");
					}
					String vendorcndate = "";
					try {
						vendorcndate = rs.getString("vendorcndate");
						System.out.println(vendorcndate);
						Assert.assertEquals(Globals.Inventory.Date.trim(), vendorcndate.trim());
						pass.ExcelFourData("CreditDebitnote ", "Date", Globals.Inventory.Date, vendorcndate, "Pass", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Date", Globals.Inventory.Date, vendorcndate, "Fail", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Date");
					}
					String Refinvoiceno = "";
					try {
						Refinvoiceno = rs.getString("Refinvoiceno");
						System.out.println(Refinvoiceno);
						Assert.assertEquals(Globals.Inventory.Billno.trim(), Refinvoiceno.trim());
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billno, Refinvoiceno, "Pass", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CreditDebitnote ", "Billno", Globals.Inventory.Billno, Refinvoiceno, "Fail", 8, 0, 8, 1, 8,
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
					break;*/

				default:
					break;
				}

			}

		}

		



		

}


