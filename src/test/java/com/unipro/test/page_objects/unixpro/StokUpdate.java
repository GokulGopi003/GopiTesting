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

	public class StokUpdate  extends PageObject {
		AddInventoryFormPage Inventorychange;
		StokUpdateField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public StokUpdate(StokUpdateField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the StockUpdate sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.StockUpdateSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME66);

		}

		@Then("I load the rowise StockUpdate data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.StockUpdaterowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.StockUpdateSheetData, row_name);
			System.out.println(Globals.Inventory.StockUpdaterowwiseData);
		}

		@Then("I update value to the StockUpdate page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.StockUpdaterowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.StockUpdaterowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.StockUpdaterowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.StockUpdaterowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.StockUpdaterowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.StockUpdaterowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.StockUpdaterowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.StockUpdaterowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.StockUpdaterowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.StockUpdaterowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.StockUpdaterowwiseData.get("ShelfCode");
			Globals.Inventory.ItemCode = Globals.Inventory.StockUpdaterowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.StockUpdaterowwiseData.get("ItemName");
			Globals.Inventory.Batch = Globals.Inventory.StockUpdaterowwiseData.get("Batch");
			Globals.Inventory.Batch1= Globals.Inventory.StockUpdaterowwiseData.get("Batch1");
			Globals.Inventory.Batch2= Globals.Inventory.StockUpdaterowwiseData.get("Batch2");
			Globals.Inventory.Batch3= Globals.Inventory.StockUpdaterowwiseData.get("Batch3");
			Globals.Inventory.Batch4= Globals.Inventory.StockUpdaterowwiseData.get("Batch4");
			Globals.Inventory.Batch5= Globals.Inventory.StockUpdaterowwiseData.get("Batch5");
			Globals.Inventory.Qty= Globals.Inventory.StockUpdaterowwiseData.get("Qty");
			Globals.Inventory.WareHouse= Globals.Inventory.StockUpdaterowwiseData.get("WareHouse");
			Globals.Inventory.Path= Globals.Inventory.StockUpdaterowwiseData.get("Path");
			Globals.Inventory.Filter= Globals.Inventory.StockUpdaterowwiseData.get("Filter");
			
			
		}

		@Then("I fill new StockUpdate data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terpage.get_checkBox_element(icp.Batch_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terpage.get_checkBox_element(icp.Batch1_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
					terpage.get_checkBox_element(icp.Batch2_String).click();

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

				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
					terpage.terminal_waitClearEnterText_css(icp.WareHouse_String, Globals.Inventory.WareHouse);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter")).click();
					

				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
					terpage.get_checkBox_element(icp.Batch3_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
					terpage.get_checkBox_element(icp.Batch4_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
					terpage.get_checkBox_element(icp.Batch5_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Filter)) {
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlSort_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlSort_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlSort_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Filter);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Path)) {
				try {

					terpage.terminal_waitClearEnterText_css("input#ContentPlaceHolder1_FileUpload1",Globals.Inventory.Path).sendKeys(Keys.ENTER);
						
				
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_btnImport")).click();
					terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_gvStockUpdate_txtNewQty_0")).sendKeys(Keys.RETURN);
					

				}
			
			pass.ExcelFourData("StockUpdate","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("StockUpdate", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("StockUpdate","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("StockUpdate", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for StockUpdate")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for StockUpdate")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from StockUpdate table {string} in DB")
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

