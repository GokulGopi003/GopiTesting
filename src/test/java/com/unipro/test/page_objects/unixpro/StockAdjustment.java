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

				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchno)) {
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
				}
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

			ResultSet rs = st.executeQuery("select * from " + tablename + " where InventoryCode='859528'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				/*case "tblStockAdjHeader":

					String StockAdjTypeCode = "";
					try {
						StockAdjTypeCode = rs.getString("StockAdjTypeCode");
						System.out.println(StockAdjTypeCode);
						Assert.assertEquals(Globals.Inventory.Reason.trim(), StockAdjTypeCode.trim());
						pass.Excelcreate("StockAdjustment", "tblStockAdjHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("StockAdjustment", "StockAdjTypeCode", Globals.Inventory.Reason, StockAdjTypeCode, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockAdjustment", "tblStockAdjHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("StockAdjustment", "StockAdjTypeCode", Globals.Inventory.Reason, StockAdjTypeCode, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column PaymentDate");
					}
										break;*/

				case "tblStockAdjDetail":
					String Qty = "";
					try {
						Qty = rs.getString("Qty");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
						pass.Excelcreate("StockAdjustment", "tblStockAdjDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("StockAdjustment", "Qty", Globals.Inventory.Qty, Qty, "Pass", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockAdjustment", "tblStockAdjDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("StockAdjustment", "Qty", Globals.Inventory.Qty, Qty, "Fail", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Qty");
					}
					String Qty1 = "";
					try {
						Qty1 = rs.getString("OldQty");
						System.out.println(Qty1);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty1.trim());
						pass.ExcelFourData("StockAdjustment", "OldQty", Globals.Inventory.Qty, Qty1, "Pass", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("StockAdjustment", "OldQty", Globals.Inventory.Qty, Qty1, "Fail", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Referanceno");
					}
					String Itemcode = "";
					try {
						Itemcode = rs.getString("InventoryCode");
						System.out.println(Itemcode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Itemcode.trim());
						pass.ExcelFourData("StockAdjustment", "Itemcode", Globals.Inventory.ItemCode, Itemcode, "Pass", 13, 0, 13, 1,
								13, 2, 13, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("StockAdjustment", "Itemcode", Globals.Inventory.ItemCode, Itemcode, "Fail", 13, 0, 13, 1,
								13, 2, 13, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Referanceno");
					}
					break;
				case "tblBatchInventoryControl":
					String Qty2 = "";
					try {
						Qty2 = rs.getString("BalanceQty");
						System.out.println(Qty2);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty2.trim());
						pass.Excelcreate("StockAdjustment", "tblBatchInventoryControl", "", 14, 0, 14, 1);
						pass.ExcelFourData("StockAdjustment", "Qty", Globals.Inventory.Qty, Qty2, "Pass", 15, 0, 15, 1,
								15, 2, 15, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockAdjustment", "tblBatchInventoryControl", "", 14, 0, 14, 1);
						pass.ExcelFourData("StockAdjustment", "Qty", Globals.Inventory.Qty, Qty2, "Fail", 15, 0, 15, 1,
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
						pass.ExcelFourData("StockAdjustment", "InventoryCode", Globals.Inventory.ItemCode, ItemCode, "Pass", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("StockAdjustment", "InventoryCode", Globals.Inventory.ItemCode, ItemCode, "Fail", 17, 0, 17, 1, 17, 2, 17,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column Amount");
					}
					break;
				case "tblinventorystock" :
					String ItemCode1 = "";
					try {
						ItemCode1 = rs.getString("InventoryCode");
						System.out.println(ItemCode1);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode1.trim());
						pass.Excelcreate("StockAdjustment", "tblinventorystock", "", 19, 0, 19, 1);
						pass.ExcelFourData("StockAdjustment", "ItemCode", Globals.Inventory.ItemCode, ItemCode1, "Pass", 20, 0, 20, 1, 20, 2, 20,
								3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockAdjustment", "tblinventorystock", "", 19, 0, 19, 1);
						pass.ExcelFourData("StockAdjustment", "ItemCode", Globals.Inventory.ItemCode, ItemCode1, "Fail", 20, 0, 20, 1, 20, 2, 20,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column RefDate");
					}
					String Qty3 = "";
					try {
						Qty3 = rs.getString("QtyOnHand");
						System.out.println(Qty3);
						Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Qty3.trim());
						pass.ExcelFourData("StockAdjustment", "QtyOnHand", Globals.Inventory.BasicCost, Qty3, "Pass", 21, 0, 21, 1, 21, 2, 21 ,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("StockAdjustment", "QtyOnHand", Globals.Inventory.BasicCost, Qty3, "Fail", 21, 0, 21, 1, 21, 2, 21,
								3);
					} catch (Exception e) {
						System.out.println("null error tblRTGS column BankCode1");
					}
					break;
			
			}
		}


}
	}


