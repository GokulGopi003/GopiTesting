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

	public class StockReset  extends PageObject {
		AddInventoryFormPage Inventorychange;
		StockResetField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public StockReset(StockResetField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the StockReset sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.StockResetSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME69);

		}

		@Then("I load the rowise StockReset data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.StockResetrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.StockResetSheetData, row_name);
			System.out.println(Globals.Inventory.StockResetrowwiseData);
		}

		@Then("I update value to the StockReset page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.StockResetrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.StockResetrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.StockResetrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.StockResetrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.StockResetrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.StockResetrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.StockResetrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.StockResetrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.StockResetrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.StockResetrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.StockResetrowwiseData.get("ShelfCode");
			Globals.Inventory.ItemCode = Globals.Inventory.StockResetrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.StockResetrowwiseData.get("ItemName");
			Globals.Inventory.Batch = Globals.Inventory.StockResetrowwiseData.get("Batch");
			Globals.Inventory.Batch1= Globals.Inventory.StockResetrowwiseData.get("Batch1");
			Globals.Inventory.Batch2= Globals.Inventory.StockResetrowwiseData.get("Batch2");
			Globals.Inventory.WareHouse= Globals.Inventory.StockResetrowwiseData.get("WareHouse");
			Globals.Inventory.ItemType= Globals.Inventory.StockResetrowwiseData.get("ItemType");
			
			
		}

		@Then("I fill new StockReset data page using excel data")
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

				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
					terpage.terminal_waitClearEnterText_css(icp.WareHouse_String, Globals.Inventory.WareHouse);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter")).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemType)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemType_String, Globals.Inventory.ItemType);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemType, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ItemType).click();
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
			
			pass.ExcelFourData("StockReset","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("StockReset", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("StockReset","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("StockReset", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for StockReset")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for StockReset")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from StockReset table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000005'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblBatchInventoryControl":
					
					
					String InventoryCode="";
					try {
						InventoryCode = rs.getString("InventoryCode");
						System.out.println(InventoryCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), InventoryCode.trim());
						pass.Excelcreate("StockReset", "tblBatchInventoryControl", "", 3, 0, 3, 1);
						pass.ExcelFourData("StockReset", "InventoryCode", Globals.Inventory.ItemCode, InventoryCode, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockReset", "tblBatchInventoryControl", "", 3, 0, 3, 1);
						pass.ExcelFourData("StockReset", "InventoryCode", Globals.Inventory.ItemCode, InventoryCode, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblBatchInventoryControl column InventoryCode");
					}
					
					
					//break;
					
				//case "tblinventorypricing":
					
			
					String Qty="";
					try {
						Qty = rs.getString("InwardQty");
					System.out.println(Qty);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Qty.trim());
					//pass.Excelcreate("StockReset", "tblinventorypricing", "", 7, 0, 7, 1);
					pass.ExcelFourData("StockReset", "Qty", Globals.Inventory.Vendor, Qty, "Pass",
							8, 0, 8, 1, 8, 2, 8, 3);
				} catch (AssertionError e) {
					//pass.Excelcreate("StockReset", "tblinventorypricing", "",  7, 0, 7, 1);
					pass.ExcelFourData("StockReset", "Qty", Globals.Inventory.Vendor, Qty, "Fail",
							8, 0, 8, 1, 8, 2, 8, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblBatchInventoryControl column Brand");
					}
					String Qty1="";
					try {
						Qty1 = rs.getString("BalanceQty");
					System.out.println(Qty1);
					Assert.assertEquals(Globals.Inventory.Brand.trim(), Qty1.trim());
					pass.ExcelFourData("StockReset", "Qty1", Globals.Inventory.Brand, Qty1, "Pass",
							9, 0, 9, 1, 9, 2, 9, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("StockReset", "Qty1", Globals.Inventory.Brand, Qty1, "Fail",
							9, 0, 9, 1, 9, 2, 9, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblBatchInventoryControl column Brand");
					}
					/*String W3 ="";
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
				case "tblinventorystock":
						String ItemCode ="";
						try {
							ItemCode = rs.getString("InventoryCode");
						System.out.println(ItemCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode.trim());
						pass.Excelcreate("StockReset", "tblinventorystock", "", 12, 0, 12, 1);
						pass.ExcelFourData("StockReset", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Pass",
								13, 0, 13, 1, 13, 2, 13, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("StockReset", "tblinventorystock", "", 12, 0, 12, 1);
						pass.ExcelFourData("StockReset", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Fail",
								13, 0, 13, 1, 13, 2, 13, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblinventorystock column ItemCode");
						}
						
					String Qty3="";
					try {
						Qty3 = rs.getString("QtyOnHand");
					System.out.println(Qty3);
					Assert.assertEquals(Globals.Inventory.Category.trim(), Qty3.trim());
					//pass.Excelcreate("StockReset", "TBLBATCHINVENTORYCONTROL", "", 15, 0, 15, 1);
					pass.ExcelFourData("StockReset", "Qty3", Globals.Inventory.Category, Qty3, "Pass",
							14, 0, 14, 1, 14, 2, 14, 3);
				} catch (AssertionError e) {
					//pass.Excelcreate("StockReset", "TBLBATCHINVENTORYCONTROL", "",15, 0, 15, 1);
					pass.ExcelFourData("StockReset", "Qty3", Globals.Inventory.Category, Qty3, "Fail",
							14, 0, 14, 1, 14, 2, 14, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorystock column QtyOnHand");
					}
					break;
					
				case "tblInventoryStockReset":
					String ItemCode1="";
					try {
						ItemCode1 = rs.getString("InventoryCode");
					System.out.println(ItemCode1);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode1.trim());
					pass.Excelcreate("StockReset", "tblInventoryStockReset", "", 17, 0, 17, 1);
					pass.ExcelFourData("StockReset", "ItemCode", Globals.Inventory.ItemCode, ItemCode1, "Pass",
							18, 0, 18, 1, 18, 2, 18, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("StockReset", "tblInventoryStockReset", "", 17, 0, 17, 1);
					pass.ExcelFourData("StockReset", "ItemCode", Globals.Inventory.ItemCode, ItemCode1, "Fail",
							18, 0, 18, 1, 18, 2, 18, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblInventoryStockReset column InventoryCode");
					}
					String Qty4="";
					try {
						Qty4 = rs.getString("QtyBeforeReset");
					System.out.println(Qty4);
					Assert.assertEquals(Globals.Inventory.Department.trim(), Qty4.trim());
					pass.ExcelFourData("StockReset", "Qty4", Globals.Inventory.Department, Qty4, "Pass",
							19, 0, 19, 1, 19, 2, 19, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("StockReset", "Qty4", Globals.Inventory.Department, Qty4, "Fail",
							19, 0, 19, 1, 19, 2, 19, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblInventoryStockReset column Qty4");
					}
					/*String W33="";
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
					}*/
					
					break;
				default:
					break;
				}
			
				
			
				}
			
		}
			



}

