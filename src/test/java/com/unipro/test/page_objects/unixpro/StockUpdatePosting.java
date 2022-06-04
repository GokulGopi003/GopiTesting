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


public class StockUpdatePosting extends PageObject {
		AddInventoryFormPage Inventorychange;
		StockUpdatePostingField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public StockUpdatePosting(StockUpdatePostingField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the StockUpdatePosting sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.StockUpdatePostingSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME67);

		}

		@Then("I load the rowise StockUpdatePosting data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.StockUpdatePostingrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.StockUpdatePostingSheetData, row_name);
			System.out.println(Globals.Inventory.StockUpdatePostingrowwiseData);
		}

		@Then("I update value to the StockUpdatePosting page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.StockUpdatePostingrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.StockUpdatePostingrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.StockUpdatePostingrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.StockUpdatePostingrowwiseData.get("Brand");
			Globals.Inventory.ItemCode = Globals.Inventory.StockUpdatePostingrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.StockUpdatePostingrowwiseData.get("ItemName");
			Globals.Inventory.Batch = Globals.Inventory.StockUpdatePostingrowwiseData.get("Batch");
		//	Globals.Inventory.Qty= Globals.Inventory.StockUpdaterowwiseData.get("Qty");
			
			
			
		}

		@Then("I fill new StockUpdatePosting data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				
				
				
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
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					//Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
					//Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName).sendKeys(Keys.TAB);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter")).click();
					

				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terpage.get_checkBox_element(icp.Batch_String).click();

				}
				/*if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
					//terpage.get_checkBox_element(icp.Qty_String).click();

				}*/
				
			
			pass.ExcelFourData("StockUpdatePosting","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("StockUpdatePosting", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("StockUpdatePosting","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("StockUpdatePosting", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for StockUpdatePosting")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for StockUpdatePosting")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from StockUpdatePosting table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='859529'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblStockTakeAdjustment":
					
					
					String ItemCode="";
					try {
						ItemCode = rs.getString("InventoryCode");
						System.out.println(ItemCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode.trim());
						pass.Excelcreate("StockUpdatePosting", "tblStockTakeAdjustment", "", 3, 0, 3, 1);
						pass.ExcelFourData("StockUpdatePosting", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockUpdatePosting", "tblStockTakeAdjustment", "", 3, 0, 3, 1);
						pass.ExcelFourData("StockUpdatePosting", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblStockTakeAdjustment column InventoryCode");
					}
					
					
					//break;
					
				//case "tblinventorypricing":
					
			
					String Qty="";
					try {
						Qty = rs.getString("ScannedQty");
					System.out.println(Qty);
					Assert.assertEquals(Globals.Inventory.Department.trim(), Qty.trim());
					//pass.Excelcreate("StockUpdatePosting", "tblinventorypricing", "", 7, 0, 7, 1);
					pass.ExcelFourData("StockUpdatePosting", "Qty", Globals.Inventory.Department, Qty, "Pass",
							8, 0, 8, 1, 8, 2, 8, 3);
				} catch (AssertionError e) {
					//pass.Excelcreate("StockUpdatePosting", "tblinventorypricing", "",  7, 0, 7, 1);
					pass.ExcelFourData("StockUpdatePosting", "Qty", Globals.Inventory.Department, Qty, "Fail",
							8, 0, 8, 1, 8, 2, 8, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice1");
					}
					/*String W2="";
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
					}*/
					break;
				case "vwInventoryStockLoc":
						String InventoryCode ="";
						try {
							InventoryCode = rs.getString("INVENTORYCODE");
						System.out.println(InventoryCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), InventoryCode.trim());
						//pass.Excelcreate("StockUpdatePosting", "tblinventorypricing", "", 12, 0, 12, 1);
						pass.ExcelFourData("StockUpdatePosting", "InventoryCode", Globals.Inventory.ItemCode, InventoryCode, "Pass",
								13, 0, 13, 1, 13, 2, 13, 3);
					} catch (AssertionError e) {
						//pass.Excelcreate("StockUpdatePosting", "tblinventorypricing", "", 12, 0, 12, 1);
						pass.ExcelFourData("StockUpdatePosting", "InventoryCode", Globals.Inventory.ItemCode, InventoryCode, "Fail",
								13, 0, 13, 1, 13, 2, 13, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblinventorystock column NetSellingPrice");
						}
						//break;
				//case "TBLBATCHINVENTORYCONTROL":
					String qtyonhand="";
					try {
						qtyonhand = rs.getString("QTYONHAND");
					System.out.println(qtyonhand);
					Assert.assertEquals(Globals.Inventory.Department.trim(), qtyonhand.trim());
					//pass.Excelcreate("StockUpdatePosting", "TBLBATCHINVENTORYCONTROL", "", 15, 0, 15, 1);
					pass.ExcelFourData("StockUpdatePosting", "NetSellingPrice", Globals.Inventory.Department, qtyonhand, "Pass",
							16, 0, 16, 1, 16, 2, 16, 3);
				} catch (AssertionError e) {
					//pass.Excelcreate("StockUpdatePosting", "TBLBATCHINVENTORYCONTROL", "",15, 0, 15, 1);
					pass.ExcelFourData("StockUpdatePosting", "NetSellingPrice", Globals.Inventory.Department, qtyonhand, "Fail",
							16, 0, 16, 1, 16, 2, 16, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column SellingPrice");
					}
					
					/*String W11="";
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
					
					break;*/
				default:
					break;
				}
			
				
			
				}
			
		}
			



}

