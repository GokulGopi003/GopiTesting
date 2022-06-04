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

	public class LocationWisePriceChange extends PageObject {
		AddInventoryFormPage Inventorychange;
		LocationWisePriceChangeField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public LocationWisePriceChange(LocationWisePriceChangeField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the LocationWisePriceChange sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.LocationWisePriceChangeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME50);

		}

		@Then("I load the rowise LocationWisePriceChange data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.LocationWisePriceChangerowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.LocationWisePriceChangeSheetData, row_name);
			System.out.println(Globals.Inventory.LocationWisePriceChangerowwiseData);
		}

		@Then("I update value to the LocationWisePriceChange page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.NetSellingPrice = Globals.Inventory.LocationWisePriceChangerowwiseData.get("NetSellingPrice");
			Globals.Inventory.WPrice1 = Globals.Inventory.LocationWisePriceChangerowwiseData.get("WPrice1");
			Globals.Inventory.WPrice2 = Globals.Inventory.LocationWisePriceChangerowwiseData.get("WPrice2");
			Globals.Inventory.WPrice3 = Globals.Inventory.LocationWisePriceChangerowwiseData.get("WPrice3");
			Globals.Inventory.ItemCode = Globals.Inventory.LocationWisePriceChangerowwiseData.get("ItemCode");
			Globals.Inventory.Batch = Globals.Inventory.LocationWisePriceChangerowwiseData.get("Batch");
			Globals.Inventory.BasicCost = Globals.Inventory.LocationWisePriceChangerowwiseData.get("BasicCost");
			Globals.Inventory.MRP = Globals.Inventory.LocationWisePriceChangerowwiseData.get("MRP");
			
			
			
		}

		@Then("I fill new LocationWisePriceChange data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInvertoryCode_Regular")).sendKeys(Keys.RETURN);
				
			}
			 
			if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
				terpage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP_Regular")).sendKeys(Keys.RETURN);

			}
		 	
            if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
				terpage.terminal_waitClearEnterText_css(icp.BasicCost_String, Globals.Inventory.BasicCost);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtNewCost")).sendKeys(Keys.RETURN);

            }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.NetSellingPrice)) {
				terpage.terminal_waitClearEnterText_css(icp.NetSellingPrice_String, Globals.Inventory.NetSellingPrice);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSellingPrice_Regular")).sendKeys(Keys.RETURN);

			}
			
	        	
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice1)) {
				terpage.terminal_waitClearEnterText_css(icp.WPrice1_String, Globals.Inventory.WPrice1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRWprice1")).sendKeys(Keys.RETURN);

			}
	       
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice2)) {
				terpage.terminal_waitClearEnterText_css(icp.WPrice2_String, Globals.Inventory.WPrice2);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRWprice2")).sendKeys(Keys.RETURN);

			}
	       		if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice3)) {
				terpage.terminal_waitClearEnterText_css(icp.WPrice3_String, Globals.Inventory.WPrice3);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRWprice3")).sendKeys(Keys.RETURN);
				webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkHQPriceRegular")).click();

			}
	       
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terpage.get_checkBox_element(icp.Batch_String).click();

			}
			
				
			
			pass.ExcelFourData("LocationWisePriceChange","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("LocationWisePriceChange", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("LocationWisePriceChange","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("LocationWisePriceChange", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for LocationWisePriceChange")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for LocationWisePriceChange")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from LocationWisePriceChange table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000020'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblOutletPricingControl":
					String CategoryCode = "";
					try {
						System.out.println("a");
						CategoryCode = rs.getString("InventoryCode");
						System.out.println(CategoryCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), CategoryCode.trim());
						pass.Excelcreate("LocationWisePriceChange", "tblOutletPricingControl", "", 2, 0, 2, 1);
						pass.ExcelFourData("LocationWisePriceChange", "InventoryCode", Globals.Inventory.ItemCode, CategoryCode, "Pass",
								3, 0, 3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("LocationWisePriceChange", "tblOutletPricingControl", "", 2, 0, 2, 1);
						pass.ExcelFourData("LocationWisePriceChange", "InventoryCode", Globals.Inventory.ItemCode, CategoryCode, "Fail",
								3, 0, 3, 1, 3, 2, 3, 3);

					}
					catch(Exception e) {
						System.out.println("null error LocationWisePriceChange column CategoryCode");
						}
					String Departmentcode = "";
					try {
						Departmentcode = rs.getString("MRP");
						System.out.println(Departmentcode);
						Assert.assertEquals(Globals.Inventory.MRP.trim(), Departmentcode.trim());
						pass.ExcelFourData("LocationWisePriceChange", "MRP", Globals.Inventory.MRP, Departmentcode, "Pass",
								4, 0, 4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("LocationWisePriceChange", "MRP", Globals.Inventory.MRP, Departmentcode, "Fail",
								4, 0, 4, 1, 4, 2, 4, 3);
					}
					catch(Exception e) {
						System.out.println("null error LocationWisePriceChange column MRP");
						}
					String Departmentcode1 = "";
					try {
						Departmentcode1 = rs.getString("SugSellingPrice");
						System.out.println(Departmentcode1);
						Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), Departmentcode1.trim());
						pass.ExcelFourData("LocationWisePriceChange", "SugSellingPrice", Globals.Inventory.NetSellingPrice, Departmentcode1, "Pass",
								4, 0, 4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("LocationWisePriceChange", "SugSellingPrice", Globals.Inventory.NetSellingPrice, Departmentcode1, "Fail",
								4, 0, 4, 1, 4, 2, 4, 3);
					}
					catch(Exception e) {
						System.out.println("null error LocationWisePriceChange column SugSellingPrice");
						}
					break;
				default:
					break;
				}
			
				}
			
		}
			



}



