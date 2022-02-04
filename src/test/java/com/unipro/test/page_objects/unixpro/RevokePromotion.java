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

	public class RevokePromotion extends PageObject {
		AddInventoryFormPage Inventorychange;
		RevokePromotionField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public RevokePromotion(RevokePromotionField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the RevokePromotion sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.RevokePromotionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME58);

		}

		@Then("I load the rowise RevokePromotion data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.RevokePromotionrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.RevokePromotionSheetData, row_name);
			System.out.println(Globals.Inventory.RevokePromotionrowwiseData);
		}

		@Then("I update value to the RevokePromotion page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.RevokePromotionrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.RevokePromotionrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.RevokePromotionrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.RevokePromotionrowwiseData.get("Brand");
			Globals.Inventory.ItemCode = Globals.Inventory.RevokePromotionrowwiseData.get("ItemCode");
			Globals.Inventory.Batch = Globals.Inventory.RevokePromotionrowwiseData.get("Batch");
			Globals.Inventory.Batch1= Globals.Inventory.RevokePromotionrowwiseData.get("Batch1");
			Globals.Inventory.FromDate= Globals.Inventory.RevokePromotionrowwiseData.get("FromDate");
			Globals.Inventory.ToDate= Globals.Inventory.RevokePromotionrowwiseData.get("ToDate");
			Globals.Inventory.LocationCode= Globals.Inventory.RevokePromotionrowwiseData.get("LocationCode");
			
		}

		@Then("I fill new RevokePromotion data page using excel data")
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
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
					terpage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.LocationCode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.LocationCode).click();
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
					terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtfromdate")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
					terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtfromdate")).sendKeys(Keys.RETURN);
				} 
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terpage.get_checkBox_element(icp.Batch_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terpage.get_checkBox_element(icp.Batch1_String).click();

				}
				
			
			pass.ExcelFourData("DayBasedPromotion","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("DayBasedPromotion", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("DayBasedPromotion","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("DayBasedPromotion", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for RevokePromotion")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for RevokePromotion")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from RevokePromotion table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000001'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblPromotionDayBased":
					
					String Sellingprice="";
					try {
						Sellingprice = rs.getString("PromotionDescription");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Sellingprice.trim());
						pass.Excelcreate("DayBasedPromotion", "tblPromotionDayBased", "", 3, 0, 3, 1);
						pass.ExcelFourData("DayBasedPromotion", "Description", Globals.Inventory.Description, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("DayBasedPromotion", "tblPromotionHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("DayBasedPromotion", "Description", Globals.Inventory.Description, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column DayBasedPromotion");
					}
					String MRP="";
					try
					{
						MRP = rs.getString("FromDate");
						System.out.println(MRP);
						Assert.assertEquals(Globals.Inventory.FromDate.trim(), MRP.trim());
						pass.ExcelFourData("DayBasedPromotion", "FromDate", Globals.Inventory.FromDate, MRP, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "FromDate", Globals.Inventory.FromDate, MRP, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column FromDate");
					}
					String Mode="";
					try
					{
						Mode = rs.getString("ToDate");
						System.out.println(Mode);
						Assert.assertEquals(Globals.Inventory.ToDate.trim(), Mode.trim());
						pass.ExcelFourData("DayBasedPromotion", "ToDate", Globals.Inventory.ToDate, Mode, "Pass",
								7, 0, 7, 1, 7, 2, 7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "ToDate", Globals.Inventory.ToDate, Mode, "Fail",
								7, 0, 7, 1, 7, 2, 7, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column ToDate");
					}
					String FromDate="";
					try
					{
						FromDate = rs.getString("fromtime");
						System.out.println(FromDate);
						Assert.assertEquals(Globals.Inventory.FromTime.trim(), FromDate.trim());
						pass.ExcelFourData("DayBasedPromotion", "FromTime", Globals.Inventory.FromTime, FromDate, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "FromTime", Globals.Inventory.FromTime, FromDate, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column fromtime");
					}
					String ToDate="";
					try
					{
						ToDate = rs.getString("totime");
						System.out.println(ToDate);
						Assert.assertEquals(Globals.Inventory.ToTime.trim(), ToDate.trim());
						pass.ExcelFourData("DayBasedPromotion", "ToTime", Globals.Inventory.ToTime, ToDate, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "ToTime", Globals.Inventory.ToTime, ToDate, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column totime");
					}
					
					String Discountper="";
					try
					{
						Discountper = rs.getString("Discountper");
						System.out.println(Discountper);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discountper.trim());
						pass.ExcelFourData("DayBasedPromotion", "Discount", Globals.Inventory.Discount, Discountper, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "Discount", Globals.Inventory.Discount, Discountper, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column Discount");
					}
					
					
					break;
				default:
					break;
				}
			
				}
			
		}


		
			



}




