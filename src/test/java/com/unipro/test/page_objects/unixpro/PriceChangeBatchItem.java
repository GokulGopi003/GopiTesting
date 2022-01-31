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

	public class PriceChangeBatchItem  extends PageObject {
		AddInventoryFormPage Inventorychange;
		PriceChangeBatchItemField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public PriceChangeBatchItem(PriceChangeBatchItemField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the PriceChangeBatchItem sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.PriceChangeBatchItemSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME51);

		}

		@Then("I load the rowise PriceChangeBatchItem data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.PriceChangeBatchItemrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.PriceChangeBatchItemSheetData, row_name);
			System.out.println(Globals.Inventory.PriceChangeBatchItemrowwiseData);
		}

		@Then("I update value to the PriceChangeBatchItem page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("ShelfCode");
			Globals.Inventory.ItemCode = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("ItemName");
			Globals.Inventory.Barcode = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Barcode");
			Globals.Inventory.Batchno = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Batchno");
			Globals.Inventory.Batch = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Batch");
			Globals.Inventory.Batch1= Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Batch1");
			Globals.Inventory.Batch2= Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Batch2");
			Globals.Inventory.Batch3= Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Batch3");
			Globals.Inventory.Batch4= Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Batch4");
			Globals.Inventory.Qty= Globals.Inventory.PriceChangeBatchItemrowwiseData.get("Qty");
			Globals.Inventory.spfixing= Globals.Inventory.PriceChangeBatchItemrowwiseData.get("spfixing");
			Globals.Inventory.ItemCode1 = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("ItemCode1");

			Globals.Inventory.NetSellingPrice = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("NetSellingPrice");
			Globals.Inventory.WPrice1 = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("WPrice1");
			Globals.Inventory.WPrice2 = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("WPrice2");
			Globals.Inventory.WPrice3 = Globals.Inventory.PriceChangeBatchItemrowwiseData.get("WPrice3");
			
			
			
		}

		@Then("I fill new PriceChangeBatchItem data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
					terpage.get_checkBox_element(icp.Batch4_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
					terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
					terpage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
					terpage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
					terpage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
					terpage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
					terpage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Merchandise);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Merchandise, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Merchandise).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
					terpage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Manufacture).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
					terpage.terminal_waitClearEnterText_css(icp.Floorcode_String, Globals.Inventory.Floorcode);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
					terpage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Section).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
					terpage.terminal_waitClearEnterText_css(icp.Bin_String, Globals.Inventory.Bin);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Bin, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Bin).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ShelfCode_String, Globals.Inventory.ShelfCode);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
				}

				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Barcode)) {
					terpage.terminal_waitClearEnterText_css(icp.Barcode_String, Globals.Inventory.Barcode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBarcode")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchno)) {
					terpage.terminal_waitClearEnterText_css(icp.Batchno_String, Globals.Inventory.Batchno);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBatchNo")).sendKeys(Keys.RETURN);
					

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkFilter")).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode1)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode1);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCode")).sendKeys(Keys.RETURN);
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terpage.get_checkBox_element(icp.Batch_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terpage.get_checkBox_element(icp.Batch1_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
					terpage.get_checkBox_element(icp.Batch2_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
					terpage.get_checkBox_element(icp.Batch3_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.spfixing)) {
					terpage.terminal_waitClearEnterText_css(icp.spfixing_String, Globals.Inventory.spfixing);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBatchNo")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkAdd")).click();
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_cbProfilterheader")).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemName")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkFetch")).click();

				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
					terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRetain")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_cbSelectAll")).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.NetSellingPrice)) {
					terpage.terminal_waitClearEnterText_css(icp.NetSellingPrice_String, Globals.Inventory.NetSellingPrice);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice1)) {
					terpage.terminal_waitClearEnterText_css(icp.WPrice1_String, Globals.Inventory.WPrice1);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice2)) {
					terpage.terminal_waitClearEnterText_css(icp.WPrice2_String, Globals.Inventory.WPrice2);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice3)) {
					terpage.terminal_waitClearEnterText_css(icp.WPrice3_String, Globals.Inventory.WPrice3);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_grdNonBatchPriceChange_txtlblWPrice3_0")).sendKeys(Keys.RETURN);
				}
				
			
			pass.ExcelFourData("PriceChangeBatchItem","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("PriceChangeBatchItem", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("PriceChangeBatchItem","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("PriceChangeBatchItem", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for PriceChangeBatchItem")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for PriceChangeBatchItem")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from PriceChangeBatchItem table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000001'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblinventory":
					
					
					String Sellingprice="";
					try {
						Sellingprice = rs.getString("SellingPrice");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), Sellingprice.trim());
						pass.Excelcreate("PriceChangeBatchItem", "tblinventory", "", 3, 0, 3, 1);
						pass.ExcelFourData("PriceChangeBatchItem", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("PriceChangeBatchItem", "tblinventory", "", 3, 0, 3, 1);
						pass.ExcelFourData("PriceChangeBatchItem", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column SellingPrice");
					}
					
					
					break;
					
				case "tblinventorypricing":
					
			
					String W1="";
					try {
				    W1 = rs.getString("MPWPrice1");
					System.out.println(W1);
					Assert.assertEquals(Globals.Inventory.WPrice1.trim(), W1.trim());
					pass.Excelcreate("PriceChangeBatchItem", "tblinventorypricing", "", 7, 0, 7, 1);
					pass.ExcelFourData("PriceChangeBatchItem", "WPrice1", Globals.Inventory.WPrice1, W1, "Pass",
							8, 0, 8, 1, 8, 2, 8, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PriceChangeBatchItem", "tblinventorypricing", "",  7, 0, 7, 1);
					pass.ExcelFourData("PriceChangeBatchItem", "WPrice1", Globals.Inventory.WPrice1, W1, "Fail",
							8, 0, 8, 1, 8, 2, 8, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice1");
					}
					String W2="";
					try {
				 W2 = rs.getString("MPWPrice2");
					System.out.println(W2);
					Assert.assertEquals(Globals.Inventory.WPrice2.trim(), W2.trim());
					pass.ExcelFourData("PriceChangeBatchItem", "WPrice2", Globals.Inventory.WPrice2, W2, "Pass",
							9, 0, 9, 1, 9, 2, 9, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeBatchItem", "WPrice2", Globals.Inventory.WPrice2, W2, "Fail",
							9, 0, 9, 1, 9, 2, 9, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice2");
					}
					String W3 ="";
					try {
					W3 = rs.getString("MPWPrice3");
					System.out.println(W3);
					Assert.assertEquals(Globals.Inventory.WPrice3.trim(), W3.trim());
					pass.ExcelFourData("PriceChangeBatchItem", "WPrice3", Globals.Inventory.WPrice3, W3, "Pass",
							10, 0, 10, 1, 10, 2, 10, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeBatchItem", "WPrice3", Globals.Inventory.WPrice3, W3, "Fail",
							10, 0, 10, 1, 10, 2, 10, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice3");
					}
					break;
				case "tblinventorystock":
						String BasicSelling1 ="";
						try {
						BasicSelling1 = rs.getString("Price");
						System.out.println(BasicSelling1);
						Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), BasicSelling1.trim());
						pass.Excelcreate("PriceChangeBatchItem", "tblinventorypricing", "", 12, 0, 12, 1);
						pass.ExcelFourData("PriceChangeBatchItem", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling1, "Pass",
								13, 0, 13, 1, 13, 2, 13, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("PriceChangeBatchItem", "tblinventorypricing", "", 12, 0, 12, 1);
						pass.ExcelFourData("PriceChangeBatchItem", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling1, "Fail",
								13, 0, 13, 1, 13, 2, 13, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblinventorystock column NetSellingPrice");
						}
						break;
				case "TBLBATCHINVENTORYCONTROL":
					String SellingPrice="";
					try {
					SellingPrice = rs.getString("SellingPrice");
					System.out.println(SellingPrice);
					Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), SellingPrice.trim());
					pass.Excelcreate("PriceChangeBatchItem", "TBLBATCHINVENTORYCONTROL", "", 15, 0, 15, 1);
					pass.ExcelFourData("PriceChangeBatchItem", "NetSellingPrice", Globals.Inventory.NetSellingPrice, SellingPrice, "Pass",
							16, 0, 16, 1, 16, 2, 16, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PriceChangeBatchItem", "TBLBATCHINVENTORYCONTROL", "",15, 0, 15, 1);
					pass.ExcelFourData("PriceChangeBatchItem", "NetSellingPrice", Globals.Inventory.NetSellingPrice, SellingPrice, "Fail",
							16, 0, 16, 1, 16, 2, 16, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column SellingPrice");
					}
					
					String W11="";
					try {
					W11 = rs.getString("WPrice1");
					System.out.println(W11);
					Assert.assertEquals(Globals.Inventory.WPrice1.trim(), W11.trim());
					pass.ExcelFourData("PriceChangeBatchItem", "WPrice1", Globals.Inventory.WPrice1, W11, "Pass",
							17, 0, 17, 1, 17, 2, 17, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeBatchItem", "WPrice1", Globals.Inventory.WPrice1, W11, "Fail",
							17, 0, 17, 1, 17, 2, 17, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice1");
					}
					String W22="";
					try {
				    W22 = rs.getString("WPrice2");
					System.out.println(W22);
					Assert.assertEquals(Globals.Inventory.WPrice2.trim(), W22.trim());
					pass.ExcelFourData("PriceChangeBatchItem", "WAPrice2", Globals.Inventory.WPrice2, W22, "Pass",
							18, 0, 18, 1, 18, 2, 18, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeBatchItem", "WAPrice2", Globals.Inventory.WPrice2, W22, "Fail",
							18, 0, 18, 1, 18, 2, 18, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice2");
					}
					String W33="";
					try {
						
					W33 = rs.getString("WPrice3");
					System.out.println(W33);
					Assert.assertEquals(Globals.Inventory.WPrice3.trim(), W33.trim());
					pass.ExcelFourData("PriceChangeBatchItem", "WAPrice3", Globals.Inventory.WPrice3, W33, "Pass",
							19, 0, 19, 1, 19, 2, 19, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeBatchItem", "WAPrice3", Globals.Inventory.WPrice3, W33, "Fail",
							19, 0, 19, 1, 19, 2, 19, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice3");
					}
					
					break;
				default:
					break;
				}
			
				
			
				}
			
		}
			



}

