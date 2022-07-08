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

	public class CustomerReceipts  extends PageObject {

		AddInventoryFormPage add_inventory;
		CustomerReceiptsField icp;
		CommonPages cp;

		TerminalPage terPage;
		ExcelWrite pass;
		Screenshot scr;

		public CustomerReceipts(CustomerReceiptsField icp, CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();

			this.cp = cp;
			add_inventory = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();
		}

		@Then("I load the CustomerReceipts sheet data to map")
		public void i_load_the_PR_sheet_data_to_map() {

			// Globals.Inventory.inventorySheetData1 =
			// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.CustomerReceiptsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME61);

		}

		@Then("I load the rowise CustomerReceipts data for {string} rowname")
		public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

			Globals.Inventory.CustomerReceiptsrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CustomerReceiptsSheetData, row_name);

			System.out.println(Globals.Inventory.CustomerReceiptsrowwiseData);

		}

		@Then("I update value to the CustomerReceipts page global Variables")
		public void i_update_value_to_the_PR_page_global_Variables() {
			Globals.Inventory.Customername = Globals.Inventory.CustomerReceiptsrowwiseData.get("Customername");
			Globals.Inventory.LocationCode = Globals.Inventory.CustomerReceiptsrowwiseData.get("LocationCode");
			Globals.Inventory.Batch = Globals.Inventory.CustomerReceiptsrowwiseData.get("Batch");
			Globals.Inventory.FromDate = Globals.Inventory.CustomerReceiptsrowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.CustomerReceiptsrowwiseData.get("ToDate");
			Globals.Inventory.Paymode = Globals.Inventory.CustomerReceiptsrowwiseData.get("Paymode");
			Globals.Inventory.Refno = Globals.Inventory.CustomerReceiptsrowwiseData.get("Refno");
			Globals.Inventory.BankCode = Globals.Inventory.CustomerReceiptsrowwiseData.get("BankCode");
			Globals.Inventory.Amount = Globals.Inventory.CustomerReceiptsrowwiseData.get("Amount");
			Globals.Inventory.Remarks = Globals.Inventory.CustomerReceiptsrowwiseData.get("Remarks");
			
		}

		@Then("I fill new CustomerReceipts data page using excel data")
		public void i_fill_new_PR_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
					webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlPaymode_chzn")).click();
					GenericWrappers.sleepInSeconds(1);
					//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlPaymode_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlPaymode_chzn > div > div > input[type=text]";
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
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Customername)) {
					terPage.terminal_waitClearEnterText_css(icp.Customername_String, Globals.Inventory.Customername);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.Customername, "input#txtSearch");
					GenericWrappers.sleepInSeconds(1);
					add_inventory.return_td_invoke_element(Globals.Inventory.Customername).click();
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkRefresh")).click();
					GenericWrappers.sleepInSeconds(1);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_gvCustomerReceipts > tbody > tr > td:nth-child(1) > input[type=button]")).click();

				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terPage.get_checkBox_element(icp.Batch_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
					terPage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
					terPage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Paymode)) {
					webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlPaymode_chzn")).click();
					GenericWrappers.sleepInSeconds(1);
					//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlPaymode_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlPaymode_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Paymode);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);
					
	               
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Refno)) {
					terPage.terminal_waitClearEnterText_css(icp.Refno_String, Globals.Inventory.Refno);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtReferenceNo")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.BankCode)) {
					webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlBank_chzn")).click();
					GenericWrappers.sleepInSeconds(1);
					//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlBank_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBank_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.BankCode);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);
	               
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
					
					terPage.terminal_waitClearEnterText_css(icp.Remarks_String, Globals.Inventory.Remarks);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRemarks")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Amount)) {
					
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAmountPaid")).sendKeys(Keys.SHIFT,
							Keys.LEFT);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAmountPaid")).sendKeys(Keys.SHIFT,
							Keys.LEFT);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAmountPaid")).sendKeys(Keys.SHIFT,
							Keys.LEFT);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAmountPaid")).sendKeys(Keys.SHIFT,
							Keys.LEFT);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAmountPaid")).sendKeys(Keys.SHIFT,
							Keys.LEFT);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAmountPaid")).sendKeys(Keys.SHIFT,
							Keys.LEFT);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAmountPaid")).sendKeys(Keys.DELETE);
					GenericWrappers.sleepInSeconds(1);
					terPage.terminal_waitClearEnterText_css(icp.Amount_String, Globals.Inventory.Amount);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAmountPaid")).sendKeys(Keys.RETURN);
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

		@Then("I close connection  DB for CustomerReceipts")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection  DB for CustomerReceipts")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from CustomerReceipts table {string} in DB")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where ReferenceNo='213213'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "tblReceiptDetail":

					String Paymode = "";
					try {
						Paymode = rs.getString("PayMode");
						System.out.println(Paymode);
						Assert.assertEquals(Globals.Inventory.Paymode.trim(), Paymode.trim());
						pass.Excelcreate("CustomerReceipts", "tblReceiptDetail", "", 3, 0, 3, 1);
						pass.ExcelFourData("CustomerReceipts", "CustomerReceipts", Globals.Inventory.Paymode, Paymode, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("CustomerReceipts", "tblReceiptDetail", "", 3, 0, 3, 1);
						pass.ExcelFourData("CustomerReceipts", "CustomerReceipts", Globals.Inventory.Paymode, Paymode, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptDetail column PayMode");
					}
					String Refno = "";
					try {
						Refno = rs.getString("ReferenceNo");
						System.out.println(Refno);
						Assert.assertEquals(Globals.Inventory.Refno.trim(), Refno.trim());
						pass.ExcelFourData("CustomerReceipts", "Refno", Globals.Inventory.Refno, Refno, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CustomerReceipts", "Refno", Globals.Inventory.Refno, Refno, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptDetail column ReferenceNo");
					}
					String BankCode = "";
					try {
						BankCode = rs.getString("Bank");
						System.out.println(BankCode);
						Assert.assertEquals(Globals.Inventory.BankCode.trim(), BankCode.trim());
						pass.ExcelFourData("CustomerReceipts", "BankCode", Globals.Inventory.BankCode, BankCode, "Pass", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CustomerReceipts", "BankCode", Globals.Inventory.BankCode, BankCode, "Fail", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptDetail column Bank");
					}
					String Amount = "";
					try {
						Amount = rs.getString("ReceiptAmount");
						System.out.println(Amount);
						Assert.assertEquals(Globals.Inventory.Amount.trim(), Amount.trim());
						pass.ExcelFourData("CustomerReceipts", "Amount", Globals.Inventory.Amount, Amount, "Pass", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CustomerReceipts", "Amount", Globals.Inventory.Amount, Amount, "Fail", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptDetail column Amount");
					}
					String Amount1 = "";
					try {
						Amount1 = rs.getString("BalanceAmount");
						System.out.println(Amount1);
						Assert.assertEquals(Globals.Inventory.Amount.trim(), Amount1.trim());
						pass.ExcelFourData("CustomerReceipts", "BalanceAmount", Globals.Inventory.Amount, Amount1, "Pass", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CustomerReceipts", "BalanceAmount", Globals.Inventory.Amount, Amount1, "Fail", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptDetail column BalanceAmount");
					}
					
					
					String Amount2 = "";
					try {
						Amount2 = rs.getString("BillAmount");
						System.out.println(Amount2);
						Assert.assertEquals(Globals.Inventory.Amount.trim(), Amount2.trim());
						//pass.Excelcreate("Payments", "tblPaymentDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("CustomerReceipts", "BillAmount", Globals.Inventory.Amount, Amount2, "Pass", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (AssertionError e) {
						//pass.Excelcreate("Payments", "tblPaymentDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("CustomerReceipts", "BillAmount", Globals.Inventory.Amount, Amount2, "Fail", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptDetail column Createdate");
					}
					/*String Promotiontodate = "";
					try {
						Promotiontodate = rs.getString("Referanceno");
						System.out.println(Promotiontodate);
						Assert.assertEquals(Globals.Inventory.Refno.trim(), Promotiontodate.trim());
						pass.ExcelFourData("Payments", "Refno", Globals.Inventory.Refno, Promotiontodate, "Pass", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments", "Refno", Globals.Inventory.Refno, Promotiontodate, "Fail", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Referanceno");
					}*/
					break;
				case "tblReceiptHeader":
					String Customername = "";
					try {
						Customername = rs.getString("CustomerName");
						System.out.println(Customername);
						Assert.assertEquals(Globals.Inventory.Customername.trim(), Customername.trim());
						pass.Excelcreate("CustomerReceipts", "tblReceiptHeader", "", 14, 0, 14, 1);
						pass.ExcelFourData("CustomerReceipts", "Customername", Globals.Inventory.Customername, Customername, "Pass", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("CustomerReceipts", "tblReceiptHeader", "", 14, 0, 14, 1);
						pass.ExcelFourData("CustomerReceipts", "Customername", Globals.Inventory.Customername, Customername, "Fail", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptHeader column Customername");
					}
					String Paymode1 = "";
					try {
						Paymode1 = rs.getString("Paymode");
						System.out.println(Paymode1);
						Assert.assertEquals(Globals.Inventory.Paymode.trim(), Paymode1.trim());
						pass.ExcelFourData("CustomerReceipts", "Paymode", Globals.Inventory.Paymode, Paymode1, "Pass", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CustomerReceipts", "Paymode", Globals.Inventory.Paymode, Paymode1, "Fail", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptHeader column Refno");
					}
					String Refno1 = "";
					try {
						Refno1 = rs.getString("ReferenceNo");
						System.out.println(Refno1);
						Assert.assertEquals(Globals.Inventory.Refno.trim(), Refno1.trim());
						pass.ExcelFourData("CustomerReceipts", "ReferenceNo", Globals.Inventory.Refno, Refno1, "Pass", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CustomerReceipts", "ReferenceNo", Globals.Inventory.Refno, Refno1, "Fail", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptHeader column Amount");
					}
					String Amount3 = "";
					try {
						Amount3 = rs.getString("TotalReceiptAmount");
						System.out.println(Amount3);
						Assert.assertEquals(Globals.Inventory.Amount.trim(), Amount3.trim());
						pass.ExcelFourData("CustomerReceipts", "TotalAmount", Globals.Inventory.Amount, Amount3, "Pass", 18, 0, 18, 1, 18, 2, 18,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CustomerReceipts", "TotalAmount", Globals.Inventory.Amount, Amount3, "Fail", 18, 0, 18, 1, 18, 2, 18,
								3);
					} catch (Exception e) {
						System.out.println("null error tblReceiptHeader column TotalAmount");
					}
					String Bank = "";
					try {
						Bank = rs.getString("BankName");
						System.out.println(Bank);
						Assert.assertEquals(Globals.Inventory.BankCode.trim(), Bank.trim());
						pass.ExcelFourData("CustomerReceipts", "BankCode", Globals.Inventory.BankCode, Bank, "Pass", 19, 0, 19, 1, 19, 2, 19,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("CustomerReceipts", "BankCode", Globals.Inventory.BankCode, Bank, "Fail", 19, 0, 19, 1, 19, 2, 19,
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
					}*/
					

				default:
					break;
				}

			}
		}


}

