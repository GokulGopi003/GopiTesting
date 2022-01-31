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

	public class PriceImportExport extends PageObject {
		AddInventoryFormPage Inventorychange;
		PriceImportExportField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public PriceImportExport(PriceImportExportField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the PriceImportExport sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.PriceImportExportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME53);

		}

		@Then("I load the rowise PriceImportExport data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.PriceImportExportrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.PriceImportExportSheetData, row_name);
			System.out.println(Globals.Inventory.PriceImportExportrowwiseData);
		}

		@Then("I update value to the PriceImportExport page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.PriceImportExportrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.PriceImportExportrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.PriceImportExportrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.PriceImportExportrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.PriceImportExportrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.PriceImportExportrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.PriceImportExportrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.PriceImportExportrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.PriceImportExportrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.PriceImportExportrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.PriceImportExportrowwiseData.get("ShelfCode");
			Globals.Inventory.WareHouse = Globals.Inventory.PriceImportExportrowwiseData.get("WareHouse");
			Globals.Inventory.ItemCode = Globals.Inventory.PriceImportExportrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.PriceImportExportrowwiseData.get("ItemName");
			Globals.Inventory.ItemType = Globals.Inventory.PriceImportExportrowwiseData.get("ItemType");
			Globals.Inventory.Barcode = Globals.Inventory.PriceImportExportrowwiseData.get("Barcode");
			Globals.Inventory.Batchno = Globals.Inventory.PriceImportExportrowwiseData.get("Batchno");
			Globals.Inventory.Batch = Globals.Inventory.PriceImportExportrowwiseData.get("Batch");
			Globals.Inventory.Batch1= Globals.Inventory.PriceImportExportrowwiseData.get("Batch1");
			Globals.Inventory.Batch2= Globals.Inventory.PriceImportExportrowwiseData.get("Batch2");
			Globals.Inventory.Batch3= Globals.Inventory.PriceImportExportrowwiseData.get("Batch3");
			Globals.Inventory.Batch4= Globals.Inventory.PriceImportExportrowwiseData.get("Batch4");
			Globals.Inventory.Qty= Globals.Inventory.PriceImportExportrowwiseData.get("Qty");
			Globals.Inventory.spfixing= Globals.Inventory.PriceImportExportrowwiseData.get("spfixing");
			Globals.Inventory.MRP = Globals.Inventory.PriceImportExportrowwiseData.get("MRP");	
			Globals.Inventory.NetSellingPrice = Globals.Inventory.PriceImportExportrowwiseData.get("NetSellingPrice");
			Globals.Inventory.WPrice1 = Globals.Inventory.PriceImportExportrowwiseData.get("WPrice1");
			Globals.Inventory.WPrice2 = Globals.Inventory.PriceImportExportrowwiseData.get("WPrice2");
			Globals.Inventory.WPrice3 = Globals.Inventory.PriceImportExportrowwiseData.get("WPrice3");
			
			
			
			
		}

		@Then("I fill new PriceImportExport data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terpage.get_checkBox_element(icp.Batch_String).click();

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
					terpage.terminal_waitClearEnterText_css(icp.Warehouse_String, Globals.Inventory.WareHouse);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
				}

			
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemType)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemType_String, Globals.Inventory.ItemType);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemType, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ItemType).click();
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter")).click();
				}
				
				
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
					terpage.get_checkBox_element(icp.Batch2_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
					terpage.get_checkBox_element(icp.Batch3_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
					terpage.get_checkBox_element(icp.Batch4_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
					terpage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
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
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_Check")).click();
				}
				
			
			pass.ExcelFourData("PriceImportExport","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("PriceImportExport", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("PriceImportExport","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("PriceImportExport", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for PriceImportExport")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for PriceImportExport")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from PriceImportExport table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000003'");
			
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
						pass.Excelcreate("PriceChangeNonBatchItem", "tblinventory", "", 3, 0, 3, 1);
						pass.ExcelFourData("PriceChangeNonBatchItem", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("PriceChangeNonBatchItem", "tblinventory", "", 3, 0, 3, 1);
						pass.ExcelFourData("PriceChangeNonBatchItem", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column SellingPrice");
					}
					String MRP="";
					try
					{
						MRP = rs.getString("MRP");
						System.out.println(MRP);
						Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP.trim());
						pass.ExcelFourData("PriceChangeNonBatchItem", "MRP", Globals.Inventory.MRP, MRP, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PriceChangeNonBatchItem", "MRP", Globals.Inventory.MRP, MRP, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column MRP");
					}
					
					break;
					
				case "tblinventorypricing":
					String BasicSelling ="";
					try {
					BasicSelling = rs.getString("NetSellingPrice");
					System.out.println(BasicSelling);
					Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), BasicSelling.trim());
					pass.Excelcreate("PriceChangeNonBatchItem", "tblinventorypricing", "", 8, 0, 8, 1);
					pass.ExcelFourData("PriceChangeNonBatchItem", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling, "Pass",
							9, 0, 9, 1, 9, 2, 9, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PriceChangeNonBatchItem", "tblinventorypricing", "", 8, 0, 8, 1);
					pass.ExcelFourData("PriceChangeNonBatchItem", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling, "Fail",
							9, 0, 9, 1, 9, 2, 9, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column NetSellingPrice");
					}
					String MRP1="";
					try {
					MRP1= rs.getString("MRP");
					System.out.println(MRP1);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP1.trim());
					pass.ExcelFourData("PriceChangeNonBatchItem", "MRP", Globals.Inventory.MRP, MRP1, "Pass",
							10, 0, 10, 1, 10, 2, 10, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeNonBatchItem", "MRP", Globals.Inventory.MRP, MRP1, "Fail",
							10, 0, 10, 1, 10, 2, 10, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MRP");
					}
			
					String W1="";
					try {
				    W1 = rs.getString("MPWPrice1");
					System.out.println(W1);
					Assert.assertEquals(Globals.Inventory.WPrice1.trim(), W1.trim());
					pass.ExcelFourData("PriceChangeNonBatchItem", "WPrice1", Globals.Inventory.WPrice1, W1, "Pass",
							12, 0, 12, 1, 12, 2, 12, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeNonBatchItem", "WPrice1", Globals.Inventory.WPrice1, W1, "Fail",
							12, 0, 12, 1, 12, 2, 12, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice1");
					}
					String W2="";
					try {
				 W2 = rs.getString("MPWPrice2");
					System.out.println(W2);
					Assert.assertEquals(Globals.Inventory.WPrice2.trim(), W2.trim());
					pass.ExcelFourData("PriceChangeNonBatchItem", "WPrice2", Globals.Inventory.WPrice2, W2, "Pass",
							13, 0, 13, 1, 13, 2, 13, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeNonBatchItem", "WPrice2", Globals.Inventory.WPrice2, W2, "Fail",
							13, 0, 13, 1, 13, 2, 13, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice2");
					}
					String W3 ="";
					try {
					W3 = rs.getString("MPWPrice3");
					System.out.println(W3);
					Assert.assertEquals(Globals.Inventory.WPrice3.trim(), W3.trim());
					pass.ExcelFourData("PriceChangeNonBatchItem", "WPrice3", Globals.Inventory.WPrice3, W3, "Pass",
							14, 0, 14, 1, 14, 2, 14, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PriceChangeNonBatchItem", "WPrice3", Globals.Inventory.WPrice3, W3, "Fail",
							14, 0, 14, 1, 14, 2, 14, 3);
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
						pass.Excelcreate("PriceChangeNonBatchItem", "tblinventorypricing", "", 16, 0, 16, 1);
						pass.ExcelFourData("PriceChangeNonBatchItem", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling1, "Pass",
								17, 0, 17, 1, 17, 2, 17, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("PriceChangeNonBatchItem", "tblinventorypricing", "", 16, 0, 16, 1);
						pass.ExcelFourData("PriceChangeNonBatchItem", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling1, "Fail",
								17, 0, 17, 1, 17, 2, 17, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblinventorystock column NetSellingPrice");
						}
				default:
					break;
				}
			
				}
			
		}
			



}







