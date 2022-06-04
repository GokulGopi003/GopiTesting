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

	public class Creditinvoice extends PageObject {

		AddInventoryFormPage add_inventory;
		CreditinvoiceField icp;
		CommonPages cp;

		TerminalPage terPage;
		ExcelWrite pass;
		Screenshot scr;

		public Creditinvoice(CreditinvoiceField icp, CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();

			this.cp = cp;
			add_inventory = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();
		}

		@Then("I load the Creditinvoice sheet data to map")
		public void i_load_the_PR_sheet_data_to_map() {

			// Globals.Inventory.inventorySheetData1 =
			// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.CreditinvoiceSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME60);

		}

		@Then("I load the rowise Creditinvoice data for {string} rowname")
		public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

			Globals.Inventory.CreditinvoicerowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CreditinvoiceSheetData, row_name);

			System.out.println(Globals.Inventory.CreditinvoicerowwiseData);

		}

		@Then("I update value to the Creditinvoice page global Variables")
		public void i_update_value_to_the_PR_page_global_Variables() {
			Globals.Inventory.Invoiceno = Globals.Inventory.CreditinvoicerowwiseData.get("Invoiceno");
			Globals.Inventory.Customername = Globals.Inventory.CreditinvoicerowwiseData.get("Customername");
			Globals.Inventory.ItemCode = Globals.Inventory.CreditinvoicerowwiseData.get("ItemCode");
			Globals.Inventory.DiscountPer = Globals.Inventory.CreditinvoicerowwiseData.get("DiscountPer");
			Globals.Inventory.Discount = Globals.Inventory.CreditinvoicerowwiseData.get("Discount");
			Globals.Inventory.Qty = Globals.Inventory.CreditinvoicerowwiseData.get("Qty");
			Globals.Inventory.Price = Globals.Inventory.CreditinvoicerowwiseData.get("Price");
			Globals.Inventory.Batchrowno = Globals.Inventory.CreditinvoicerowwiseData.get("Batchrowno");
			
		}

		@Then("I fill new Creditinvoice data page using excel data")
		public void i_fill_new_PR_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Invoiceno)) {
					terPage.terminal_waitClearEnterText_css(icp.Invoiceno_String, Globals.Inventory.Invoiceno);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtInvoiceNo\"]")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Customername)) {
					terPage.terminal_waitClearEnterText_css(icp.Customername_String, Globals.Inventory.Customername);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtCustName\"]")).sendKeys(Keys.RETURN);

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtInventory\"]")).sendKeys(Keys.RETURN);
				}

				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchrowno)) {
					try {
						GenericWrappers.sleepInSeconds(1);
						webDriver.findElement(By.xpath(
								"//*[@id=\"dataGridBatchTable_master_row" + Globals.Inventory.Batchrowno + "\"]"))
								.click();

					} catch (Exception e) {
						System.out.println("Element  not found");
					}
					JavascriptExecutor js = (JavascriptExecutor) webDriver;
					js.executeScript("window.scrollBy(0,1000)");
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
					terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDiscount\"]")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer)) {
					terPage.terminal_waitClearEnterText_css(icp.DiscountPer_String, Globals.Inventory.DiscountPer);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDiscPercent\"]")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
					terPage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
					webDriver.findElement(By.xpath("//*[@id=\"Qty_000001\"]")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Price)) {
					terPage.terminal_waitClearEnterText_css(icp.Price_String, Globals.Inventory.Price);
					webDriver.findElement(By.xpath("//*[@id=\"Price_000001\"]")).sendKeys(Keys.RETURN);
				}
				pass.ExcelFourData("Creditinvoice", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("Creditinvoice", "Filters", "Pass", 1, 0, 1, 3);
			   } 
			  catch (Exception e) {
	// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
	// Xl sheet write
				pass.ExcelFourData("Creditinvoice", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("Creditinvoice", "Filters", "FAIL", 1, 0, 1, 3);

			}
		}

		@Then("I close connection  DB for Creditinvoice")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection  DB for Creditinvoice")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from Creditinvoice table {string} in DB")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where InvoiceNo='CRT1005798'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "tblSalesDetailCur":

					String ItemCode = "";
					try {
						ItemCode = rs.getString("InventoryCode");
						System.out.println(ItemCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode.trim());
						pass.Excelcreate("Creditinvoice", "tblSalesDetailCur", "", 3, 0, 3, 1);
						pass.ExcelFourData("Creditinvoice", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("Creditinvoice", "tblSalesDetailCur", "", 3, 0, 3, 1);
						pass.ExcelFourData("Creditinvoice", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column PaymentDate");
					}
					String Invoiceno = "";
					try {
						Invoiceno = rs.getString("InvoiceNo");
						System.out.println(Invoiceno);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), Invoiceno.trim());
						pass.ExcelFourData("Creditinvoice", "Invoiceno", Globals.Inventory.Invoiceno, Invoiceno, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice", "Invoiceno", Globals.Inventory.Invoiceno, Invoiceno, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column VoucherRef");
					}
					String Batchrowno = "";
					try {
						Batchrowno = rs.getString("BatchNo");
						System.out.println(Batchrowno);
						Assert.assertEquals(Globals.Inventory.Batchrowno.trim(), Batchrowno.trim());
						pass.ExcelFourData("Creditinvoice", "Batchrowno", Globals.Inventory.Batchrowno, Batchrowno, "Pass", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice", "Batchrowno", Globals.Inventory.Batchrowno, Batchrowno, "Fail", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column RefDate");
					}
					String Qty = "";
					try {
						Qty = rs.getString("Qty");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
						pass.ExcelFourData("Creditinvoice", "Qty", Globals.Inventory.Qty, Qty, "Pass", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice", "Qty", Globals.Inventory.Qty, Qty, "Fail", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column Vendor");
					}
					String Price = "";
					try {
						Price = rs.getString("Price");
						System.out.println(Price);
						Assert.assertEquals(Globals.Inventory.Price.trim(), Price.trim());
						pass.ExcelFourData("Creditinvoice", "Price", Globals.Inventory.Price, Price, "Pass", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice", "Price", Globals.Inventory.Price, Price, "Fail", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column TotalAmount");
					}
					String Discount = "";
					try {
						Discount = rs.getString("NetDiscount");
						System.out.println(Discount);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount.trim());
						pass.ExcelFourData("Creditinvoice", "Discount", Globals.Inventory.Discount, Discount, "Pass", 10, 0, 10, 1, 10,
								2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice", "Discount", Globals.Inventory.Discount, Discount, "Fail", 10, 0, 10, 1, 10,
								2, 10, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column Paymode");
					}

					break;

				
				case "tblSalesHeaderCur":
					String Invoice = "";
					try {
						Invoice = rs.getString("InvoiceNo");
						System.out.println(Invoice);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), Invoice.trim());
						pass.Excelcreate("Creditinvoice", "tblSalesHeaderCur", "", 14, 0, 14, 1);
						pass.ExcelFourData("Creditinvoice", "InvoiceNo", Globals.Inventory.Invoiceno, Invoice, "Pass", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("Creditinvoice", "tblSalesHeaderCur", "", 14, 0, 14, 1);
						pass.ExcelFourData("Creditinvoice", "InvoiceNo", Globals.Inventory.Invoiceno, Invoice, "Fail", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Vendorname");
					}
					String Customername = "";
					try {
						Customername = rs.getString("CustomerName");
						System.out.println(Customername);
						Assert.assertEquals(Globals.Inventory.Customername.trim(), Customername.trim());
						pass.ExcelFourData("Creditinvoice", "Customername", Globals.Inventory.Customername, Customername, "Pass", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice", "Customername", Globals.Inventory.Customername, Customername, "Fail", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Refno");
					}
					String Discount1 = "";
					try {
						Discount1 = rs.getString("Discount");
						System.out.println(Discount1);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount1.trim());
						pass.ExcelFourData("Creditinvoice", "Discount", Globals.Inventory.Discount, Discount1, "Pass", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice", "Discount", Globals.Inventory.Discount, Discount1, "Fail", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Amount");
					}
					break;
				case "tblPaymodeDetailCur":
					String INVOICE = "";
					try {
						INVOICE = rs.getString("InvoiceNo");
						System.out.println(INVOICE);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), INVOICE.trim());
						pass.Excelcreate("Creditinvoice ", "tblPaymodeDetailCur", "", 20, 0, 20, 1);
						pass.ExcelFourData("Creditinvoice ", "InvoiceNo", Globals.Inventory.Invoiceno, INVOICE, "Pass", 21, 0, 21, 1, 21, 2,
								21, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("Creditinvoice ", "tblPaymodeDetailCur", "", 20, 0, 20, 1);
						pass.ExcelFourData("Creditinvoice ", "InvoiceNo", Globals.Inventory.Invoiceno, INVOICE, "Fail", 21, 0, 21, 1, 21, 2,
								21, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column VendorCode");
					}
					String Price1 = "";
					try {
						Price1 = rs.getString("Amount");
						System.out.println(Price1);
						Assert.assertEquals(Globals.Inventory.Price.trim(), Price1.trim());
						pass.ExcelFourData("Creditinvoice ", "Amount", Globals.Inventory.Price, Price1, "Pass", 22, 0, 22, 1,
								22, 2, 22, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice ", "Amount", Globals.Inventory.Price, Price1, "Fail", 22, 0, 22, 1,
								22, 2, 22, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column Refno");
					}
					break;
				/*case "tblsalesheaderERP":
					String invoice = "";
					try {
						invoice = rs.getString("PSH_BILL_NO");
						System.out.println(invoice);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), invoice.trim());
						pass.Excelcreate("Creditinvoice ", "tblsalesheaderERP", "", 24, 0, 24, 1);
						pass.ExcelFourData("Creditinvoice ", "PSH_BILL_NO", Globals.Inventory.Invoiceno, invoice, "Pass", 25, 0, 25, 1,
								25, 2, 25, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("Creditinvoice ", "tblsalesheaderERP", "", 24, 0, 24, 1);
						pass.ExcelFourData("Creditinvoice ", "PSH_BILL_NO", Globals.Inventory.Invoiceno, invoice, "Fail", 25, 0, 25, 1,
								25, 2, 25, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column VendorCode");
					}
					String Batchrowno1 = "";
					try {
						Batchrowno1 = rs.getString("PSH_SEQ");
						System.out.println(Batchrowno1);
						Assert.assertEquals(Globals.Inventory.Batchrowno.trim(), Batchrowno1.trim());
						pass.ExcelFourData("Creditinvoice ", "PSH_SEQ", Globals.Inventory.Batchrowno, Batchrowno1, "Pass", 26, 0, 26, 1, 26, 2, 26,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice ", "PSH_SEQ", Globals.Inventory.Batchrowno, Batchrowno1, "Fail", 26, 0, 26, 1, 26, 2, 26,
								3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Vendorno");
					}
					break;
				case"tbl_pos_Sales_header":
					String PSH_SEQ = "";
					try {
						PSH_SEQ = rs.getString("PSH_SEQ");
						System.out.println(PSH_SEQ);
						Assert.assertEquals(Globals.Inventory.Batchrowno.trim(), PSH_SEQ.trim());
						pass.Excelcreate("Creditinvoice ", "tbl_pos_Sales_header", "", 28, 0, 28, 1);
						pass.ExcelFourData("Creditinvoice ", "PSH_SEQ", Globals.Inventory.Batchrowno, PSH_SEQ, "Pass", 29, 0, 29, 1, 29, 2,
								29, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("Creditinvoice ", "tbl_pos_Sales_header", "", 28, 0, 28, 1);
						pass.ExcelFourData("Creditinvoice ", "PSH_SEQ", Globals.Inventory.Batchrowno, PSH_SEQ, "Fail", 29, 0, 29, 1, 29, 2,
								29, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Date");
					}
					String PSH_BILL_NO = "";
					try {
						PSH_BILL_NO = rs.getString("PSH_BILL_NO");
						System.out.println(PSH_BILL_NO);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), PSH_BILL_NO.trim());
						pass.ExcelFourData("Creditinvoice ", "PSH_BILL_NO", Globals.Inventory.Invoiceno, PSH_BILL_NO, "Pass", 30, 0, 30, 1, 30,
								2, 30, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice ", "PSH_BILL_NO", Globals.Inventory.Invoiceno, PSH_BILL_NO, "Fail", 30, 0, 30, 1, 30,
								2, 30, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Billno");
					}
					String Customername2 = "";
					try {
						Customername2 = rs.getString("PSH_CUSTOMER_NAME");
						System.out.println(Customername2);
						Assert.assertEquals(Globals.Inventory.Customername.trim(), Customername2.trim());
						pass.ExcelFourData("Creditinvoice ", "PSH_CUSTOMER_NAME", Globals.Inventory.Customername, Customername2, "Pass", 31, 0, 31, 1, 31,
								2, 31, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Creditinvoice ", "PSH_CUSTOMER_NAME", Globals.Inventory.Customername, Customername2, "Fail", 31, 0, 31, 1, 31,
								2, 31, 3);
					} catch (Exception e) {
						System.out.println("null error tbldebitnote column Billdate");
					}
					/*String Remarks = "";
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

