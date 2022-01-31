package com.unipro.test.page_objects.unixpro;


	import java.io.IOException;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Iterator;
	import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;

	import com.gk.test.MssqlConnect;
	import com.unipro.ExcelWrite;
	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

	public class FreeItem extends PageObject {
		AddInventoryFormPage Inventorychange;
		FreeItemField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public FreeItem(FreeItemField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the FreeItem sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.FreeItemSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME54);

		}

		@Then("I load the rowise FreeItem data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.FreeItemrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.FreeItemSheetData, row_name);
			System.out.println(Globals.Inventory.FreeItemrowwiseData);
		}

		@Then("I update value to the FreeItem page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.GrpCode = Globals.Inventory.FreeItemrowwiseData.get("GrpCode");
			Globals.Inventory.Description = Globals.Inventory.FreeItemrowwiseData.get("Description");
			Globals.Inventory.Date = Globals.Inventory.FreeItemrowwiseData.get("Date");
			Globals.Inventory.ToDate = Globals.Inventory.FreeItemrowwiseData.get("ToDate");
			Globals.Inventory.Mode = Globals.Inventory.FreeItemrowwiseData.get("Mode");
			Globals.Inventory.ItemCode = Globals.Inventory.FreeItemrowwiseData.get("ItemCode");
			Globals.Inventory.ItemCode1 = Globals.Inventory.FreeItemrowwiseData.get("ItemCode1");
			Globals.Inventory.Batchno = Globals.Inventory.FreeItemrowwiseData.get("Batchno");
			Globals.Inventory.Batchno1 = Globals.Inventory.FreeItemrowwiseData.get("Batchno1");
			Globals.Inventory.Batch = Globals.Inventory.FreeItemrowwiseData.get("Batch");
			Globals.Inventory.Qty = Globals.Inventory.FreeItemrowwiseData.get("Qty");
			Globals.Inventory.Qty1 = Globals.Inventory.FreeItemrowwiseData.get("Qty1");
			Globals.Inventory.EligibilityQty = Globals.Inventory.FreeItemrowwiseData.get("EligibilityQty");
												
		}

		@Then("I fill new FreeItem data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.GrpCode)) {
					terpage.terminal_waitClearEnterText_css(icp.GrpCode_String, Globals.Inventory.GrpCode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtGroupCode")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
					terpage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDesc")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
					terpage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtfrmDate")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
					terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Mode)) {
					terpage.terminal_waitClearEnterText_css(icp.Mode_String, Globals.Inventory.Mode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFreeMode")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terpage.get_checkBox_element(icp.Batch_String).click();

				}
	
			
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQItemCode")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchno)) {
					try {
						GenericWrappers.sleepInSeconds(1);
						webDriver.findElement(By.xpath(
								"//*[@id=\"dataGridBatchTable_master_row" + Globals.Inventory.Batchno + "\"]"))
								.click();

					} catch (Exception e) {
						System.out.println("Element  not found");
					}

				}

				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
					terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQQty")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkAdd")).click();
					
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode1)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode1_String, Globals.Inventory.ItemCode1);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFItemcode")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchno1)) {
					try {
						GenericWrappers.sleepInSeconds(1);
						webDriver.findElement(By.xpath(
								"//*[@id=\"dataGridBatchTable_master_row" + Globals.Inventory.Batchno1 + "\"]"))
								.click();

					} catch (Exception e) {
						System.out.println("Element  not found");
					}

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty1)) {
					terpage.terminal_waitClearEnterText_css(icp.Qty1_String, Globals.Inventory.Qty1);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFQty")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.EligibilityQty)) {
					terpage.terminal_waitClearEnterText_css(icp.EligibilityQty_String, Globals.Inventory.EligibilityQty);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLimitQty")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkAddFreeItem")).click();
				}
				
				
			
			pass.ExcelFourData("FreeItem","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("FreeItem", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("FreeItem","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("FreeItem", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for FreeItem")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for FreeItem")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from FreeItem table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where GroupCode='12'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblFreeItemGroup":
						
					String Sellingprice="";
					try {
						Sellingprice = rs.getString("GroupCode");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.GrpCode.trim(), Sellingprice.trim());
						pass.Excelcreate("FreeItem", "tblGroup", "", 3, 0, 3, 1);
						pass.ExcelFourData("FreeItem", "GroupCode", Globals.Inventory.GrpCode, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("FreeItem", "tblGroup", "", 3, 0, 3, 1);
						pass.ExcelFourData("FreeItem", "GroupCode", Globals.Inventory.GrpCode, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column GrpCode");
					}
					String MRP="";
					try
					{
						MRP = rs.getString("Description");
						System.out.println(MRP);
						Assert.assertEquals(Globals.Inventory.Description.trim(), MRP.trim());
						pass.ExcelFourData("FreeItem", "Description", Globals.Inventory.Description, MRP, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Description", Globals.Inventory.Description, MRP, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column MRP");
					}
					String Mode="";
					try
					{
						Mode = rs.getString("Fmode");
						System.out.println(Mode);
						Assert.assertEquals(Globals.Inventory.Mode.trim(), Mode.trim());
						pass.ExcelFourData("FreeItem", "Mode", Globals.Inventory.Mode, Mode, "Pass",
								7, 0, 7, 1, 7, 2, 7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Mode", Globals.Inventory.Mode, Mode, "Fail",
								7, 0, 7, 1, 7, 2, 7, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Mode");
					}
					String Qty="";
					try
					{
						Qty = rs.getString("BuyQty");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
						pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, Qty, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, Qty, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Qty");
					}
					String Qty1="";
					try
					{
						Qty1 = rs.getString("OfferedQty");
						System.out.println(Qty1);
						Assert.assertEquals(Globals.Inventory.Qty1.trim(), Qty1.trim());
						pass.ExcelFourData("FreeItem", "Qty1", Globals.Inventory.Qty1, Qty1, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Qty1", Globals.Inventory.Qty1, Qty1, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Qty1");
					}
					String FromDate="";
					try
					{
						FromDate = rs.getString("ValidFrom");
						System.out.println(Qty1);
						Assert.assertEquals(Globals.Inventory.Date.trim(), FromDate.trim());
						pass.ExcelFourData("FreeItem", "Date", Globals.Inventory.Date, FromDate, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Date", Globals.Inventory.Date, FromDate, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Date");
					}
					String ToDate="";
					try
					{
						ToDate = rs.getString("ValidTo");
						System.out.println(ToDate);
						Assert.assertEquals(Globals.Inventory.ToDate.trim(), ToDate.trim());
						pass.ExcelFourData("FreeItem", "Date", Globals.Inventory.ToDate, ToDate, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Date", Globals.Inventory.ToDate, ToDate, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column ToDate");
					}
					
					break;
					
				case "tblQualifyingItemsForFree":
					String BasicSelling ="";
					try {
					BasicSelling = rs.getString("GroupCode");
					System.out.println(BasicSelling);
					Assert.assertEquals(Globals.Inventory.GrpCode.trim(), BasicSelling.trim());
					pass.Excelcreate("FreeItem", "tblQualifingitemforfree", "", 12, 0, 12, 1);
					pass.ExcelFourData("FreeItem", "GrpCode", Globals.Inventory.GrpCode, BasicSelling, "Pass",
							13, 0, 13, 1, 13, 2, 13, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("FreeItem", "tblQualifingitemforfree", "", 12, 0, 12, 1);
					pass.ExcelFourData("FreeItem", "GrpCode", Globals.Inventory.GrpCode, BasicSelling, "Fail",
							13, 0, 13, 1, 13, 2, 13, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblQualifingitemforfree column GrpCode");
					}
					String MRP1="";
					try {
					MRP1= rs.getString("itemcode");
					System.out.println(MRP1);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), MRP1.trim());
					pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, MRP1, "Pass",
							14, 0, 14, 1, 14, 2, 14, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, MRP1, "Fail",
							14, 0, 14, 1, 14, 2, 14, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblQualifingitemforfree column ItemCode");
					}
			
					String W1="";
					try {
				    W1 = rs.getString("BuyQty");
					System.out.println(W1);
					Assert.assertEquals(Globals.Inventory.Qty.trim(), W1.trim());
					pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, W1, "Pass",
							15, 0, 15, 1, 15, 2,15, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, W1, "Fail",
							15, 0, 15, 1, 15, 2,15, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblQualifingitemforfree column Qty");
					}
				
					break;
				case "tblfreeitemslist":
						String BasicSelling1 ="";
						try {
						BasicSelling1 = rs.getString("GroupCode");
						System.out.println(BasicSelling1);
						Assert.assertEquals(Globals.Inventory.GrpCode.trim(), BasicSelling1.trim());
						pass.Excelcreate("FreeItem", "tblslist", "", 16, 0, 16, 1);
						pass.ExcelFourData("FreeItem", "GrpCode", Globals.Inventory.GrpCode, BasicSelling1, "Pass",
								17, 0, 17, 1, 17, 2, 17, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("FreeItem", "tblslist", "", 16, 0, 16, 1);
						pass.ExcelFourData("FreeItem", "GrpCode", Globals.Inventory.GrpCode, BasicSelling1, "Fail",
								17, 0, 17, 1, 17, 2, 17, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column NetSellingPrice");
						}
						String Itemcode ="";
						try {
							Itemcode = rs.getString("Itemcode");
						System.out.println(Itemcode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Itemcode.trim());
					
						pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, Itemcode, "Pass",
								18, 0, 18, 1, 18, 2, 18, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, Itemcode, "Fail",
								18, 0, 18, 1, 18, 2, 18, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column NetSellingPrice");
						}
						String Itemcode1 ="";
						try {
							Itemcode1 = rs.getString("Itemcode");
						System.out.println(Itemcode1);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Itemcode1.trim());
					
						pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, Itemcode1, "Pass",
								19, 0, 19, 1, 19, 2, 19, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, Itemcode1, "Fail",
								19, 0, 19, 1, 19, 2, 19, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column NetSellingPrice");
						}
						String Qty11 ="";
						try {
							Qty11 = rs.getString("FreeQty");
						System.out.println(Qty11);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty11.trim());
					
						pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, Qty11, "Pass",
								20, 0, 20, 1, 20, 2, 20, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, Qty11, "Fail",
								20, 0, 20, 1, 20, 2, 20, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column NetSellingPrice");
						}
						String EligibilityQty ="";
						try {
							EligibilityQty = rs.getString("InputQty");
						System.out.println(EligibilityQty);
						Assert.assertEquals(Globals.Inventory.EligibilityQty.trim(), EligibilityQty.trim());
					
						pass.ExcelFourData("FreeItem", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty, "Pass",
								21, 0, 21, 1, 21, 2, 21, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("FreeItem", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty, "Fail",
								21, 0, 21, 1, 21, 2, 21, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column EligibilityQty");
						}
				default:
					break;
				}
			
				}
			
		}
			



}


