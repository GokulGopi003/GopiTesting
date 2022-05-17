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
import org.openqa.selenium.interactions.Actions;
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

	public class StockAdjustment extends PageObject {

		AddInventoryFormPage add_inventory;
		StockAdjustmentField icp;
		CommonPages cp;

		TerminalPage terPage;
		ExcelWrite pass;
		Screenshot scr;

		public StockAdjustment(StockAdjustmentField icp, CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();

			this.cp = cp;
			add_inventory = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();
		}

		@Then("I load the StockAdjustment sheet data to map")
		public void i_load_the_PR_sheet_data_to_map() {

			// Globals.Inventory.inventorySheetData1 =
			// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.StockAdjustmentSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME64);

		}

		@Then("I load the rowise StockAdjustment data for {string} rowname")
		public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

			Globals.Inventory.StockAdjustmentrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.StockAdjustmentSheetData, row_name);

			System.out.println(Globals.Inventory.StockAdjustmentrowwiseData);

		}

		@Then("I update value to the StockAdjustment page global Variables")
		public void i_update_value_to_the_PR_page_global_Variables() {
			Globals.Inventory.ItemCode = Globals.Inventory.StockAdjustmentrowwiseData.get("ItemCode");
			Globals.Inventory.Batchno = Globals.Inventory.StockAdjustmentrowwiseData.get("Batchno");
			Globals.Inventory.MRP = Globals.Inventory.StockAdjustmentrowwiseData.get("MRP");
			Globals.Inventory.BasicCost = Globals.Inventory.StockAdjustmentrowwiseData.get("BasicCost");
			Globals.Inventory.Qty = Globals.Inventory.StockAdjustmentrowwiseData.get("Qty");
			Globals.Inventory.Price = Globals.Inventory.StockAdjustmentrowwiseData.get("Price");
			Globals.Inventory.NetSellingPrice = Globals.Inventory.StockAdjustmentrowwiseData.get("NetSellingPrice");
			Globals.Inventory.Reason = Globals.Inventory.StockAdjustmentrowwiseData.get("Reason");
			
		}

		@Then("I fill new StockAdjustment data page using excel data")
		public void i_fill_new_PR_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Reason)) {
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlStkAdjType_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlStkAdjType_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlStkAdjType_chzn > div > div > input[type=text]";
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
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtItemCode\"]")).sendKeys(Keys.RETURN);
				}

				/*if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchno)) {
					try {
						Actions actions = new Actions(webDriver);
						GenericWrappers.sleepInSeconds(1);
						WebElement ele=webDriver.findElement(By.xpath(
								"//*[@id=\"BatchRow_" + Globals.Inventory.Batchno + "\"]"));
						actions.doubleClick(ele).perform();
						

					} catch (Exception e) {
						webDriver.findElement(By.xpath(
								"//*[@id=\"ContentPlaceHolder1_lnkNewBatch" + Globals.Inventory.Batchno + "\"]"))
								.click();
					}
				}*/
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty")).sendKeys(Keys.CONTROL, "a");
					/*webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty"))
			.sendKeys(Keys.SHIFT, Keys.LEFT);*/
					GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty"))
					.sendKeys(Keys.DELETE);
			GenericWrappers.sleepInSeconds(1);
					terPage.terminal_waitClearEnterText_Xpath(icp.Qty_String, Globals.Inventory.Qty);
					webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtQty']")).sendKeys(Keys.RETURN);
				}
				/*if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCost"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCost"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCost"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCost"))
			.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCost"))
					.sendKeys(Keys.DELETE);
					terPage.terminal_waitClearEnterText_css(icp.BasicCost_String, Globals.Inventory.BasicCost);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtCost\"]")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
			.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
					.sendKeys(Keys.DELETE);
					terPage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtMRP\"]")).sendKeys(Keys.RETURN);
				}
				*/
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Price)) {
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlPrcCode_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlPrcCode_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlPrcCode_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Price);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);

				}
				/*if (GenericWrappers.isNotEmpty(Globals.Inventory.NetSellingPrice)) {
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
			.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
					.sendKeys(Keys.DELETE);
					terPage.terminal_waitClearEnterText_css(icp.NetSellingPrice_String, Globals.Inventory.NetSellingPrice);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtSPrice\"]")).sendKeys(Keys.RETURN);
				}*/
				pass.ExcelFourData("StockAdjustment", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("StockAdjustment", "StockAdjustment", "Pass", 1, 0, 1, 3);
			   } 
			  catch (Exception e) {
	// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
	// Xl sheet write
				pass.ExcelFourData("StockAdjustment", "StockAdjustment", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("StockAdjustment", "StockAdjustment", "FAIL", 1, 0, 1, 3);

			}
		}

		@Then("I close connection  DB for StockAdjustment")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection  DB for StockAdjustment")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from StockAdjustment table {string} in DB")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where Qty='2'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "tblStockAdjHeader":

					String Reason = "";
					try {
						Reason = rs.getString("StockAdjTypeCode");
						System.out.println(Reason);
						Assert.assertEquals(Globals.Inventory.Reason.trim(), Reason.trim());
						pass.Excelcreate("StockAdjustment", "tblStockAdjHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("StockAdjustment", "StockAdjTypeCode", Globals.Inventory.Reason, Reason, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockAdjustment", "tblStockAdjHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("StockAdjustment", "StockAdjTypeCode", Globals.Inventory.Reason, Reason, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column PaymentDate");
					}
					/*String ReturnDate = "";
					try {
						ReturnDate = rs.getString("VoucherRef");
						System.out.println(ReturnDate);
						Assert.assertEquals(Globals.Inventory.Refno.trim(), ReturnDate.trim());
						pass.ExcelFourData("Payments", "Refno", Globals.Inventory.Refno, ReturnDate, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Payments", "Refno", Globals.Inventory.Refno, ReturnDate, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column VoucherRef");
					}
					String ReturnDate1 = "";
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
					}*/

					break;

				case "tblStockAdjDetail":
					String Qty = "";
					try {
						Qty = rs.getString("Qty");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
						pass.Excelcreate("StockAdjustment", "tblPaymentDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("StockAdjustment", "Qty", Globals.Inventory.Qty, Qty, "Pass", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockAdjustment", "tblPaymentDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("StockAdjustment", "Qty", Globals.Inventory.Qty, Qty, "Fail", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Qty");
					}
					String Promotiontodate = "";
					try {
						Promotiontodate = rs.getString("Referanceno");
						System.out.println(Promotiontodate);
						Assert.assertEquals(Globals.Inventory.Refno.trim(), Promotiontodate.trim());
						pass.ExcelFourData("StockAdjustment", "Refno", Globals.Inventory.Refno, Promotiontodate, "Pass", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("StockAdjustment", "Refno", Globals.Inventory.Refno, Promotiontodate, "Fail", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Referanceno");
					}
					break;
				case "tblBatchInventoryControl":
					/*String Qty = "";
					try {
						Qty = rs.getString("BalanceQty");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
						pass.Excelcreate("StockAdjustment", "tblBatchInventoryControl", "", 14, 0, 14, 1);
						pass.ExcelFourData("StockAdjustment", "Qty", Globals.Inventory.Qty, Qty, "Pass", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockAdjustment", "tblBatchInventoryControl", "", 14, 0, 14, 1);
						pass.ExcelFourData("StockAdjustment", "Qty", Globals.Inventory.Qty, Qty, "Fail", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (Exception e) {
						System.out.println("null error tblBatchInventoryControl column Qty");
					}
					String Batchno = "";
					try {
						Batchno = rs.getString("BatchNo");
						System.out.println(Batchno);
						Assert.assertEquals(Globals.Inventory.Batchno.trim(), Batchno.trim());
						pass.ExcelFourData("StockAdjustment", "Batchno", Globals.Inventory.Batchno, Batchno, "Pass", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("StockAdjustment", "Batchno", Globals.Inventory.Batchno, Batchno, "Fail", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (Exception e) {
						System.out.println("null error tblBatchInventoryControl column Batchno");
					}
					String ItemCode = "";
					try {
						ItemCode = rs.getString("InventoryCode");
						System.out.println(ItemCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode.trim());
						pass.ExcelFourData("StockAdjustment", "InventoryCode", Globals.Inventory.ItemCode, ItemCode, "Pass", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("StockAdjustment", "InventoryCode", Globals.Inventory.ItemCode, ItemCode, "Fail", 16, 0, 16, 1, 16, 2, 16,
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
				/*case "tblDebitNote":
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
					/*String Reason = "";
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

				default:
					break;
				}*/

			}
		}


}
	}


