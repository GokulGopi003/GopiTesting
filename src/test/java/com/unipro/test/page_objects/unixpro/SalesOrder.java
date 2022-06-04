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

	public class SalesOrder  extends PageObject {

		AddInventoryFormPage add_inventory;
		SalesOrderField icp;
		CommonPages cp;

		TerminalPage terPage;
		ExcelWrite pass;
		Screenshot scr;

		public SalesOrder(SalesOrderField icp, CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();

			this.cp = cp;
			add_inventory = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();
		}

		@Then("I load the SalesOrder sheet data to map")
		public void i_load_the_PR_sheet_data_to_map() {

			// Globals.Inventory.inventorySheetData1 =
			// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.SalesOrderSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME65);

		}

		@Then("I load the rowise SalesOrder data for {string} rowname")
		public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

			Globals.Inventory.SalesOrderrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.SalesOrderSheetData, row_name);

			System.out.println(Globals.Inventory.SalesOrderrowwiseData);

		}

		@Then("I update value to the SalesOrder page global Variables")
		public void i_update_value_to_the_PR_page_global_Variables() {
			Globals.Inventory.Invoiceno = Globals.Inventory.SalesOrderrowwiseData.get("Invoiceno");
			Globals.Inventory.Customername = Globals.Inventory.SalesOrderrowwiseData.get("Customername");
			Globals.Inventory.ItemCode = Globals.Inventory.SalesOrderrowwiseData.get("ItemCode");
			Globals.Inventory.DiscountPer = Globals.Inventory.SalesOrderrowwiseData.get("DiscountPer");
			Globals.Inventory.Discount = Globals.Inventory.SalesOrderrowwiseData.get("Discount");
			Globals.Inventory.Qty = Globals.Inventory.SalesOrderrowwiseData.get("Qty");
			Globals.Inventory.Price = Globals.Inventory.SalesOrderrowwiseData.get("Price");
			Globals.Inventory.Batchrowno = Globals.Inventory.SalesOrderrowwiseData.get("Batchrowno");
			
		}

		@Then("I fill new SalesOrder data page using excel data")
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
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscount23")).sendKeys(Keys.RETURN);
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
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_grdItemDetail_txtSellingPrice_0")).sendKeys(Keys.RETURN);
					//webDriver.findElement(By.xpath("//*[@id=\"Price_000001\"]")).sendKeys(Keys.RETURN);
				}
				pass.ExcelFourData("SalesOrder", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("SalesOrder", "Filters", "Pass", 1, 0, 1, 3);
			   } 
			  catch (Exception e) {
	// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
	// Xl sheet write
				pass.ExcelFourData("SalesOrder", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
				pass.Excelcreate("SalesOrder", "Filters", "FAIL", 1, 0, 1, 3);

			}
		}

		@Then("I close connection  DB for SalesOrder")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection  DB for SalesOrder")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from SalesOrder table {string} in DB")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where InventoryCode='000001'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "tblSODetail":

					String Invoiceno = "";
					try {
						Invoiceno = rs.getString("SONo");
						System.out.println(Invoiceno);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), Invoiceno.trim());
						pass.Excelcreate("SalesOrder", "tblSODetail", "", 3, 0, 3, 1);
						pass.ExcelFourData("SalesOrder", "SONo", Globals.Inventory.Invoiceno, Invoiceno, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("SalesOrder", "tblSODetail", "", 3, 0, 3, 1);
						pass.ExcelFourData("SalesOrder", "SONo", Globals.Inventory.Invoiceno, Invoiceno, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tblSODetail column SONo");
					}
					String ItemCode = "";
					try {
						ItemCode = rs.getString("InventoryCode");
						System.out.println(ItemCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode.trim());
						pass.ExcelFourData("SalesOrder", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tblSODetail column ItemCode");
					}
					String Qty = "";
					try {
						Qty = rs.getString("Qty");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
						pass.ExcelFourData("SalesOrder", "Qty", Globals.Inventory.Qty, Qty, "Pass", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "Qty", Globals.Inventory.Qty, Qty, "Fail", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (Exception e) {
						System.out.println("null error tblSODetail column Qty");
					}
					String Price = "";
					try {
						Price = rs.getString("Price");
						System.out.println(Price);
						Assert.assertEquals(Globals.Inventory.Price.trim(), Price.trim());
						pass.ExcelFourData("SalesOrder", "Price", Globals.Inventory.Price, Price, "Pass", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "Price", Globals.Inventory.Price, Price, "Fail", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (Exception e) {
						System.out.println("null error tblSODetail column Price");
					}
					String DiscountPer = "";
					try {
						DiscountPer = rs.getString("Discount");
						System.out.println(DiscountPer);
						Assert.assertEquals(Globals.Inventory.DiscountPer.trim(), DiscountPer.trim());
						pass.ExcelFourData("SalesOrder", "Discount", Globals.Inventory.DiscountPer, DiscountPer, "Pass", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "Discount", Globals.Inventory.DiscountPer, DiscountPer, "Fail", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (Exception e) {
						System.out.println("null error tblSODetail column Discount");
					}
					String Discount = "";
					try {
						Discount = rs.getString("NetDiscount");
						System.out.println(Discount);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount.trim());
						pass.ExcelFourData("SalesOrder", "NetDiscount", Globals.Inventory.Discount, Discount, "Pass", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "NetDiscount", Globals.Inventory.Discount, Discount, "Fail", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (Exception e) {
						System.out.println("null error tblSODetail column NetDiscount");
					}

					break;

				case "tblSOHeaderERP":
					String Invoiceno1 = "";
					try {
						Invoiceno1 = rs.getString("SOH_SO_NO");
						System.out.println(Invoiceno1);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), Invoiceno1.trim());
						pass.Excelcreate("SalesOrder", "tblSOHeaderERP", "", 10, 0, 10, 1);
						pass.ExcelFourData("SalesOrder", "Invoiceno1", Globals.Inventory.Invoiceno, Invoiceno1, "Pass", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("SalesOrder", "tblSOHeaderERP", "", 10, 0, 10, 1);
						pass.ExcelFourData("SalesOrder", "Invoiceno1", Globals.Inventory.Invoiceno, Invoiceno1, "Fail", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (Exception e) {
						System.out.println("null error tblSOHeaderERP column SOH_SO_NO");
					}
					String TenderAmount = "";
					try {
						TenderAmount = rs.getString("SOH_TENDER_AMOUNT");
						System.out.println(TenderAmount);
						Assert.assertEquals(Globals.Inventory.Price.trim(), TenderAmount.trim());
						pass.ExcelFourData("SalesOrder", "TenderAmount", Globals.Inventory.Price, TenderAmount, "Pass", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "TenderAmount", Globals.Inventory.Price, TenderAmount, "Fail", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (Exception e) {
						System.out.println("null error tblSOHeaderERP column Referanceno");
					}
					break;
				case "tbl_pos_sales_order_header":
					String SONO = "";
					try {
						SONO = rs.getString("SOH_SO_NO");
						System.out.println(SONO);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), SONO.trim());
						pass.Excelcreate("SalesOrder", "tbl_pos_sales_order_header", "", 14, 0, 14, 1);
						pass.ExcelFourData("SalesOrder", "SOH_SO_NO1", Globals.Inventory.Invoiceno, SONO, "Pass", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("SalesOrder", "tbl_pos_sales_order_header", "", 14, 0, 14, 1);
						pass.ExcelFourData("SalesOrder", "SOH_SO_NO1", Globals.Inventory.Invoiceno, SONO, "Fail", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (Exception e) {
						System.out.println("null error tbl_pos_sales_order_header column SOH_SO_NO1");
					}
					String Customername = "";
					try {
						Customername = rs.getString("SOH_CUSTOMER_NAME");
						System.out.println(Customername);
						Assert.assertEquals(Globals.Inventory.Customername.trim(), Customername.trim());
						pass.ExcelFourData("SalesOrder", "Customername", Globals.Inventory.Customername, Customername, "Pass", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "Customername", Globals.Inventory.Customername, Customername, "Fail", 16, 0, 16, 1, 16, 2, 16,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Refno");
					}
					String Amount = "";
					try {
						Amount = rs.getString("SOH_TENDER_AMOUNT");
						System.out.println(Amount);
						Assert.assertEquals(Globals.Inventory.Price.trim(), Amount.trim());
						pass.ExcelFourData("SalesOrder", "SOH_TENDER_AMOUNT", Globals.Inventory.Price, Amount, "Pass", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "SOH_TENDER_AMOUNT", Globals.Inventory.Price, Amount, "Fail", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Amount");
					}
					String TotalValue = "";
					try {
						TotalValue = rs.getString("SOH_TOTAL_VALUE");
						System.out.println(TotalValue);
						Assert.assertEquals(Globals.Inventory.Price.trim(), TotalValue.trim());
						pass.ExcelFourData("SalesOrder", "SOH_TOTAL_VALUE", Globals.Inventory.Price, TotalValue, "Pass", 18, 0, 18, 1, 18, 2, 18,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "SOH_TOTAL_VALUE", Globals.Inventory.Price, TotalValue, "Fail", 18, 0, 18, 1, 18, 2, 18,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column RefDate");
					}
					String DiscountPer1 = "";
					try {
						DiscountPer1 = rs.getString("SOH_NET_DISCOUNT");
						System.out.println(DiscountPer1);
						Assert.assertEquals(Globals.Inventory.DiscountPer.trim(), DiscountPer1.trim());
						pass.ExcelFourData("SalesOrder", "SOH_NET_DISCOUNT", Globals.Inventory.DiscountPer, DiscountPer1, "Pass", 19, 0, 19, 1, 19, 2, 19,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "SOH_NET_DISCOUNT", Globals.Inventory.DiscountPer, DiscountPer1, "Fail", 19, 0, 19, 1, 19, 2, 19,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column BankCode1");
					}
					String Discount1 = "";
					try {
						Discount1 = rs.getString("SOH_BILL_DISCOUNT");
						System.out.println(Discount1);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount1.trim());
						pass.ExcelFourData("SalesOrder", "SOH_NET_DISCOUNT", Globals.Inventory.Discount, Discount1, "Pass", 20, 0, 20, 1, 20, 2, 20,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder", "SOH_NET_DISCOUNT", Globals.Inventory.Discount, Discount1, "Fail", 20, 0, 20, 1, 20, 2, 20,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column BankCode1");
					}
					
				
					String ItemCode4 = "";
					try {
						ItemCode4 = rs.getString("SOD_ITEM_CODE");
						System.out.println(ItemCode4);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode4.trim());
						pass.Excelcreate("SalesOrder ", "tblSODetailERP", "", 21, 0, 21, 1);
						pass.ExcelFourData("SalesOrder ", "SOD_ITEM_CODE", Globals.Inventory.ItemCode, ItemCode4, "Pass", 22, 0, 22, 1, 22, 2,
								22, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("SalesOrder ", "tblSODetailERP", "", 21, 0, 21, 1);
						pass.ExcelFourData("SalesOrder ", "SOD_ITEM_CODE", Globals.Inventory.ItemCode, ItemCode4, "Fail", 22, 0, 22, 1, 22, 2,
								22, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column VendorCode");
					}
					
					String SODNO = "";
					try {
						SODNO = rs.getString("SOD_SO_NO");
						System.out.println(SODNO);
						Assert.assertEquals(Globals.Inventory.Invoiceno.trim(), SODNO.trim());
						pass.ExcelFourData("SalesOrder ", "SOD_SO_NO", Globals.Inventory.Invoiceno, SODNO, "Pass", 23, 0, 23, 1,
								23, 2, 23, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder ", "SOD_SO_NO", Globals.Inventory.Invoiceno, SODNO, "Fail", 23, 0, 23, 1,
								23, 2, 23, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column Refno");
					}
					String SODQTY = "";
					try {
						SODQTY = rs.getString("SOD_SO_NO");
						System.out.println(SODQTY);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), SODQTY.trim());
						pass.ExcelFourData("SalesOrder ", "SOD_SO_NO", Globals.Inventory.Qty, SODQTY, "Pass", 24, 0, 24, 1, 24,
								2, 24, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder ", "SOD_SO_NO", Globals.Inventory.Qty, SODQTY, "Fail",24, 0, 24, 1, 24,
								2, 24, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column Billno");
					}
					String Batchrowno = "";
					try {
						Batchrowno = rs.getString("SOD_BATCH_NO");
						System.out.println(Batchrowno);
						Assert.assertEquals(Globals.Inventory.Batchrowno.trim(), Batchrowno.trim());
						pass.ExcelFourData("SalesOrder ", "Batchrowno", Globals.Inventory.Batchrowno, Batchrowno, "Pass", 25, 0, 25, 1, 25,
								2, 25, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder ", "Batchrowno", Globals.Inventory.Batchrowno, Batchrowno, "Fail", 25, 0, 25, 1, 25,
								2, 25, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column Billdate");
					}
					String SODSELLINGPRICE = "";
					try {
						SODSELLINGPRICE = rs.getString("SOD_SELLING_PRICE");
						System.out.println(SODSELLINGPRICE);
						Assert.assertEquals(Globals.Inventory.Price.trim(), SODSELLINGPRICE.trim());
						pass.ExcelFourData("SalesOrder ", "SODSELLINGPRICE", Globals.Inventory.Price, SODSELLINGPRICE, "Pass", 26, 0, 26, 1, 26,
								2, 26, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder ", "SODSELLINGPRICE", Globals.Inventory.Price, SODSELLINGPRICE, "Fail", 26, 0, 26, 1, 26,
								2, 26, 3);
					} catch (Exception e) {
						System.out.println("null error tblAPtransaction column TranAmt");
					}
					
					String CreateDate = "";
					try {
						CreateDate = rs.getString("BalanceAmt");
						System.out.println(CreateDate);
						Assert.assertEquals(Globals.Inventory.TotalAmount.trim(), CreateDate.trim());
						pass.ExcelFourData("SalesOrder ", "CreateDate", Globals.Inventory.TotalAmount, CreateDate, "Pass", 21, 0, 21, 1, 21,
								2, 21, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("SalesOrder ", "CreateDate", Globals.Inventory.TotalAmount, CreateDate, "Fail", 21, 0, 21, 1, 21,
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
					//break;

				default:
					break;
				}

			}
		}


}


