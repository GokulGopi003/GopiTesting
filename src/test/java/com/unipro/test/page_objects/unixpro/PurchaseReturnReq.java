package com.unipro.test.page_objects.unixpro;


	import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

	public class PurchaseReturnReq  extends PageObject {

		AddInventoryFormPage add_inventory;
		PurchasereturnReqfield icp;
		CommonPages cp;
		ExcelWrite pass;
		Screenshot scr;
		TerminalPage terPage;
		
		

		public PurchaseReturnReq(PurchasereturnReqfield icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();
		}
		

		@Then("I load the PRR sheet data to map")
		public void i_load_the_PR_sheet_data_to_map() {

			//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.PurchasereturnReqSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME17);

		}
		@Then("I load the rowise PRR data for {string} rowname")
		public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

			Globals.Inventory.PurchasereturnReqrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.PurchasereturnReqSheetData, row_name);

			System.out.println(Globals.Inventory.PurchasereturnReqrowwiseData);

		}
		@Then("I update value to the PRR page global Variables")
		public void i_update_value_to_the_PR_page_global_Variables() {
			Globals.Inventory.ItemCode = Globals.Inventory.PurchasereturnReqrowwiseData.get("ItemCode");
			Globals.Inventory.InvQty = Globals.Inventory.PurchasereturnReqrowwiseData.get("InvQty");
			Globals.Inventory.Remark = Globals.Inventory.PurchasereturnReqrowwiseData.get("Remark");
			Globals.Inventory.LocationCode = Globals.Inventory.PurchasereturnReqrowwiseData.get("LocationCode");
			Globals.Inventory.Vendor = Globals.Inventory.PurchasereturnReqrowwiseData.get("Vendor");
			Globals.Inventory.Batchrowno = Globals.Inventory.PurchasereturnReqrowwiseData.get("Batchrowno");
			Globals.Inventory.Batchno = Globals.Inventory.PurchasereturnReqrowwiseData.get("Batchno");
			Globals.Inventory.Reason = Globals.Inventory.PurchasereturnReqrowwiseData.get("Reason");
		}

		@Then("I fill new PRR data page using excel data")
		public void i_fill_new_PR_data_page_using_excel_data() throws Exception {
			 try
			 {
			        if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
					terPage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.LocationCode, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.LocationCode).click();
					
                    
				    }
			       if (GenericWrappers.isNotEmpty(Globals.Inventory.Remark)) {
				   terPage.terminal_waitClearEnterText_css(icp.Remark_String, Globals.Inventory.Remark);
			

			        }
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);				
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInventoryCode")).sendKeys(Keys.ENTER);
						GenericWrappers.sleepInSeconds(1);

						}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchrowno)) {
						try {

							webDriver.findElement(By.cssSelector("#dataGridBatchTable_master_row"+ Globals.Inventory.Batchrowno +"> td.BatchNo")).click();
							} catch (Exception e) {
								System.out.println("Element  not found");
							}

					}
						
					
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.InvQty)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPRRQty")).sendKeys(Keys.SHIFT,
								Keys.LEFT);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPRRQty")).sendKeys(Keys.SHIFT,
								Keys.LEFT);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPRRQty")).sendKeys(Keys.SHIFT,
								Keys.LEFT);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPRRQty")).sendKeys(Keys.SHIFT,
								Keys.LEFT);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPRRQty")).sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.InvQty_String, Globals.Inventory.InvQty);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPRRQty")).sendKeys(Keys.RETURN);
					}
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_DropDownVendor_chzn.chzn-container.chzn-container-single")).click();
						GenericWrappers.sleepInSeconds(1);
						//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_DropDownVendor_chzn > div > div > input[type=text]"));
						String css_location_dropDownValue = "#ContentPlaceHolder1_DropDownVendor_chzn > div > div > input[type=text]";
						By ddlocator = By.cssSelector(css_location_dropDownValue);
						waitForExpectedElement(ddlocator);
						js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Vendor);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.ARROW_DOWN);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.ENTER);
                       
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Reason)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ReturnTypeDropDown_chzn.chzn-container.chzn-container-single")).click();
						GenericWrappers.sleepInSeconds(1);
						//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ReturnTypeDropDown_chzn > div > div > input[type=text]"));
						String css_location_dropDownValue = "#ContentPlaceHolder1_ReturnTypeDropDown_chzn > div > div > input[type=text]";
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
					pass.ExcelFourData("PRR", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
					pass.Excelcreate("PRR", "Filters", "Pass", 1, 0, 1, 3);
			 }
			 catch (Exception e) {
				// screen shot
							scr.Screenshots();
							System.out.println("Screen shot taken");
				// Xl sheet write
							pass.ExcelFourData("PRR", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
							pass.Excelcreate("PRR", "Filters", "FAIL", 1, 0, 1, 3);

						}

						}
					
		@Then("I close connection  DB for PRR")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection  DB for PRR")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from PRR table {string} in DB")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where PRReqNo='HQ00000112'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "tblPurchaseReturnReqDetail":

					String Sellingprice = "";
					try {
						Sellingprice = rs.getString("InventoryCode");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Sellingprice.trim());
						pass.Excelcreate("PRR", "tblOutletStockRequestHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("PRR", "InventoryCode", Globals.Inventory.ItemCode, Sellingprice, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("PRR", "tblOutletStockRequestHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("PRR", "InventoryCode", Globals.Inventory.ItemCode, Sellingprice, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tblPurchaseReturnReqDetail column InventoryCode");
					}
					String ReturnDate = "";
					try {
						ReturnDate = rs.getString("Batchno");
						System.out.println(ReturnDate);
						Assert.assertEquals(Globals.Inventory.Batchno.trim(), ReturnDate.trim());
						pass.ExcelFourData("PRR", "Batchno", Globals.Inventory.Batchno, ReturnDate, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PRR", "Batchno", Globals.Inventory.Batchno, ReturnDate, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tblPurchaseReturnReqDetail column Batchno");
					}
					String ReturnDate1 = "";
					try {
						ReturnDate1 = rs.getString("VendorName");
						System.out.println(ReturnDate1);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), ReturnDate1.trim());
						pass.ExcelFourData("PRR", "Reason", Globals.Inventory.Vendor, ReturnDate1, "Pass", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PRR", "Reason", Globals.Inventory.Vendor, ReturnDate1, "Fail", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (Exception e) {
						System.out.println("null error tblPurchaseReturnReqDetail column Vendor");
					}
					String Basiccost = "";
					try {
						Basiccost = rs.getString("PRReqQty");
						System.out.println(Basiccost);
						Assert.assertEquals(Globals.Inventory.InvQty.trim(), Basiccost.trim());
						pass.ExcelFourData("PRR", "InvQty", Globals.Inventory.InvQty, Basiccost, "Pass", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PRR", "InvQty", Globals.Inventory.InvQty, Basiccost, "Fail", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (Exception e) {
						System.out.println("null error tblPurchaseReturnReqDetail column InvQty");
					}

					break;

				case "tblPurchaseReturnReqHeader":
					String Vendor = "";
					try {
						Vendor = rs.getString("TotalQty");
						System.out.println(Vendor);
						Assert.assertEquals(Globals.Inventory.InvQty.trim(), Vendor.trim());
						pass.Excelcreate("PRR", "tblPurchaseReturnReqHeader", "", 10, 0, 10, 1);
						pass.ExcelFourData("PRR", "InvQty", Globals.Inventory.InvQty, Vendor, "Pass", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("PRR", "tblPurchaseReturnReqHeader", "", 10, 0, 10, 1);
						pass.ExcelFourData("PRR", "InvQty", Globals.Inventory.InvQty, Vendor, "Fail", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (Exception e) {
						System.out.println("null error tblPurchaseReturnReqHeader column TotalQty");
					}
					String Promotiontodate = "";
					try {
						Promotiontodate = rs.getString("ReturnType");
						System.out.println(Promotiontodate);
						Assert.assertEquals(Globals.Inventory.Reason.trim(), Promotiontodate.trim());
						pass.ExcelFourData("PRR", "Reason", Globals.Inventory.Reason, Promotiontodate, "Pass", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PRR", "Reason", Globals.Inventory.Reason, Promotiontodate, "Fail", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (Exception e) {
						System.out.println("null error tblPurchaseReturnReqHeader column Reason");
					}
					String Remarks = "";
					try {
						Remarks = rs.getString("Remarks");
						System.out.println(Remarks);
						Assert.assertEquals(Globals.Inventory.Remark.trim(), Remarks.trim());
						pass.ExcelFourData("PRR", "Remarks", Globals.Inventory.Remark, Remarks, "Pass", 13, 0, 13, 1,
								13, 2, 13, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PRR", "Remarks", Globals.Inventory.Remark, Remarks, "Fail", 12, 0, 12, 1,
								13, 2, 13, 3);
					} catch (Exception e) {
						System.out.println("null error tblPurchaseReturnReqHeader column Remarks");
					}
					break;
				default:
					break;
				}

			}
		}
				
		   }
		   








