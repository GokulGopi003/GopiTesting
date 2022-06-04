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

		public class Billcancel extends PageObject {
			AddInventoryFormPage add_inventory;
			BillcancelField icp;
			CommonPages cp;

			TerminalPage terPage;
			ExcelWrite pass;
			Screenshot scr;

			public Billcancel(BillcancelField icp, CommonPages cp) {
				this.icp = icp;
				terPage = new TerminalPage();

				this.cp = cp;
				add_inventory = new AddInventoryFormPage();
				pass = new ExcelWrite();
				scr = new Screenshot();
			}

			@Then("I load the Billcancel sheet data to map")
			public void i_load_the_PR_sheet_data_to_map() {

				// Globals.Inventory.inventorySheetData1 =
				// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

				Globals.Inventory.BillcancelSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME62);

			}

			@Then("I load the rowise Billcancel data for {string} rowname")
			public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

				Globals.Inventory.BillcancelrowwiseData = ReadTestData
						.getRowFilteredValueFromTable(Globals.Inventory.BillcancelSheetData, row_name);

				System.out.println(Globals.Inventory.BillcancelrowwiseData);

			}

			@Then("I update value to the Billcancel page global Variables")
			public void i_update_value_to_the_PR_page_global_Variables() {
				Globals.Inventory.Billno = Globals.Inventory.BillcancelrowwiseData.get("Billno");
				Globals.Inventory.LocationCode = Globals.Inventory.BillcancelrowwiseData.get("LocationCode");
				
				
			}

			@Then("I fill new Billcancel data page using excel data")
			public void i_fill_new_PR_data_page_using_excel_data() throws Exception {
				try {
					if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
						terPage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.LocationCode, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.LocationCode).click();
						
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Billno)) {
						terPage.terminal_waitClearEnterText_css(icp.Billno_String, Globals.Inventory.Billno);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Billno, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Billno).click();
						
					}
					
					pass.ExcelFourData("Billcancel", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
					pass.Excelcreate("Billcancel", "Filters", "Pass", 1, 0, 1, 3);
				   } 
				  catch (Exception e) {
		// screen shot
					scr.Screenshots();
					System.out.println("Screen shot taken");
		// Xl sheet write
					pass.ExcelFourData("Billcancel", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
					pass.Excelcreate("Billcancel", "Filters", "FAIL", 1, 0, 1, 3);

				}
			}

			@Then("I close connection  DB for Billcancel")
			public void I_close_connection_to_DB() throws SQLException {

				mysqlConnect.disconnect();
				System.out.println(" closed succesfully");

				// mysqlConnect.disconnect();

			}

			MssqlConnect mysqlConnect;
			Statement st;

			@Then("I establish connection  DB for Billcancel")
			public void I_establish_connection_to_DB() throws SQLException {

				mysqlConnect = new MssqlConnect();
				st = mysqlConnect.connect().createStatement();
				System.out.println(" Connected succesfully");

			}

			@Given("I read the values from Billcancel table {string} in DB")
			public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

				ResultSet rs = st.executeQuery("select * from " + tablename + " where InvoiceNo='2001B3R0000595'");

				System.out.println(rs);
				// ResultSet rs = st.executeQuery("");

				while (rs.next()) {

					switch (tablename) {

					/*case "tblSalesReturnDetail":

						String Billno = "";
						try {
							Billno = rs.getString("ReturnNo");
							System.out.println(Billno);
							Assert.assertEquals(Globals.Inventory.Billno.trim(), Billno.trim());
							pass.Excelcreate("Billcancel", "tblSalesReturnDetail", "", 3, 0, 3, 1);
							pass.ExcelFourData("Billcancel", "Billno", Globals.Inventory.Billno, Billno, "Pass", 5, 0, 5, 1,
									5, 2, 5, 3);
						} catch (AssertionError e) {
							pass.Excelcreate("Billcancel", "tblSalesReturnDetail", "", 3, 0, 3, 1);
							pass.ExcelFourData("Billcancel", "Billno", Globals.Inventory.Billno, Billno, "Fail", 5, 0, 5, 1,
									5, 2, 5, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column PaymentDate");
						}
						String LocationCode = "";
						try {
							LocationCode = rs.getString("InventoryCode");
							System.out.println(LocationCode);
							Assert.assertEquals(Globals.Inventory.LocationCode.trim(), LocationCode.trim());
							pass.ExcelFourData("Billcancel", "LocationCode", Globals.Inventory.LocationCode, LocationCode, "Pass", 6, 0, 6, 1, 6, 2, 6,
									3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Billcancel", "LocationCode", Globals.Inventory.LocationCode, LocationCode, "Fail", 6, 0, 6, 1, 6, 2, 6,
									3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column VoucherRef");
						}
						/*String ReturnDate1 = "";
						try {
							ReturnDate1 = rs.getString("ReferanceDate");
							System.out.println(ReturnDate1);
							Assert.assertEquals(Globals.Inventory.RefDate.trim(), ReturnDate1.trim());
							pass.ExcelFourData("Payments", "ReferanceDate", Globals.Inventory.RefDate, ReturnDate1, "Pass", 7, 0, 7, 1, 7, 2,
									7, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Payments", "ReferanceDate", Globals.Inventory.RefDate, ReturnDate1, "Fail", 7, 0, 7, 1, 7, 2,
									7, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column RefDate");
						}
						String Basiccost = "";
						try {
							Basiccost = rs.getString("Vendorname");
							System.out.println(Basiccost);
							Assert.assertEquals(Globals.Inventory.Vendor.trim(), Basiccost.trim());
							pass.ExcelFourData("Payments", "Vendor", Globals.Inventory.Vendor, Basiccost, "Pass", 8, 0, 8, 1, 8,
									2, 8, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Payments", "Vendor", Globals.Inventory.Vendor, Basiccost, "Fail", 8, 0, 8, 1, 8,
									2, 8, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column Vendor");
						}
						String Paidamount = "";
						try {
							Paidamount = rs.getString("Paidamount");
							System.out.println(Paidamount);
							Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), Paidamount.trim());
							pass.ExcelFourData("Payments", "TotalAmount", Globals.Inventory.TotalAmount, Paidamount, "Pass", 9, 0, 9, 1, 9,
									2, 9, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Payments", "TotalAmount", Globals.Inventory.TotalAmount, Paidamount, "Fail", 9, 0, 9, 1, 9,
									2, 9, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column TotalAmount");
						}
						String Paymenttype = "";
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
						}

						break;*/

					case "tblSalesReturnheader":
						String Billno1 = "";
						try {
							Billno1 = rs.getString("InvoiceNo");
							System.out.println(Billno1);
							Assert.assertEquals(Globals.Inventory.Billno.trim(), Billno1.trim());
							pass.Excelcreate("Billcancel", "tblSalesReturnheader", "", 10, 0, 10, 1);
							pass.ExcelFourData("Billcancel", "InvoiceNo", Globals.Inventory.Billno, Billno1, "Pass", 11, 0, 11, 1, 11, 2,
									11, 3);
						} catch (AssertionError e) {
							pass.Excelcreate("Billcancel", "tblSalesReturnheader", "", 10, 0, 10, 1);
							pass.ExcelFourData("Billcancel", "InvoiceNo", Globals.Inventory.Billno, Billno1, "Fail", 11, 0, 11, 1, 11, 2,
									11, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentDetail column Createdate");
						}
						String LocationCode1 = "";
						try {
							LocationCode1 = rs.getString("LocationCode");
							System.out.println(LocationCode1);
							Assert.assertEquals(Globals.Inventory.LocationCode.trim(), LocationCode1.trim());
							pass.ExcelFourData("Billcancel", "LocationCode", Globals.Inventory.LocationCode, LocationCode1, "Pass", 12, 0, 12, 1,
									12, 2, 12, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Billcancel", "LocationCode", Globals.Inventory.LocationCode, LocationCode1, "Fail", 12, 0, 12, 1,
									12, 2, 12, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentDetail column Referanceno");
						}
						break;
					/*case "tblRTGS":
						String Promotionfromtime = "";
						try {
							Promotionfromtime = rs.getString("Vendorname");
							System.out.println(Promotionfromtime);
							Assert.assertEquals(Globals.Inventory.Vendor.trim(), Promotionfromtime.trim());
							pass.Excelcreate("Payments", "tblRTGS", "", 14, 0, 14, 1);
							pass.ExcelFourData("Payments", "Vendor", Globals.Inventory.Vendor, Promotionfromtime, "Pass", 15, 0, 15, 1,
									15, 2, 15, 3);
						} catch (AssertionError e) {
							pass.Excelcreate("Payments", "tblRTGS", "", 14, 0, 14, 1);
							pass.ExcelFourData("Payments", "Vendor", Globals.Inventory.Vendor, Promotionfromtime, "Fail", 15, 0, 15, 1,
									15, 2, 15, 3);
						} catch (Exception e) {
							System.out.println("null error tblRTGS column Vendorname");
						}
						String WQty = "";
						try {
							WQty = rs.getString("Description");
							System.out.println(WQty);
							Assert.assertEquals(Globals.Inventory.Refno.trim(), WQty.trim());
							pass.ExcelFourData("Payments", "Refno", Globals.Inventory.Refno, WQty, "Pass", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Payments", "Refno", Globals.Inventory.Refno, WQty, "Fail", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (Exception e) {
							System.out.println("null error tblRTGS column Refno");
						}
						String Amount = "";
						try {
							Amount = rs.getString("Amount");
							System.out.println(Amount);
							Assert.assertEquals(Globals.Inventory.Paymode1.trim(), Amount.trim());
							pass.ExcelFourData("Payments", "Paymode", Globals.Inventory.Paymode1, Amount, "Pass", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Payments", "Paymode", Globals.Inventory.Paymode1, Amount, "Fail", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (Exception e) {
							System.out.println("null error tblRTGS column Amount");
						}
						String Createddate = "";
						try {
							Createddate = rs.getString("Createdate");
							System.out.println(Createddate);
							Assert.assertEquals(Globals.Inventory.RefDate.trim(), Createddate.trim());
							pass.ExcelFourData("Payments", "RefDate", Globals.Inventory.RefDate, Createddate, "Pass", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Payments", "RefDate", Globals.Inventory.RefDate, Createddate, "Fail", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (Exception e) {
							System.out.println("null error tblRTGS column RefDate");
						}
						String Bank = "";
						try {
							Bank = rs.getString("Bank");
							System.out.println(Bank);
							Assert.assertEquals(Globals.Inventory.BankCode1.trim(), Bank.trim());
							pass.ExcelFourData("Payments", "BankCode1", Globals.Inventory.BankCode1, Bank, "Pass", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (AssertionError e) {
							pass.ExcelFourData("Payments", "BankCode1", Globals.Inventory.BankCode1, Bank, "Fail", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (Exception e) {
							System.out.println("null error tblRTGS column BankCode1");
						}
						break;
					case "tblAPtransaction":
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
