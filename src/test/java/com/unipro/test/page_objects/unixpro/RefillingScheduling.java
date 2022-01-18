package com.unipro.test.page_objects.unixpro;
	

	import java.io.IOException;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Iterator;
	import java.util.List;

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

	public class RefillingScheduling  extends PageObject {
		AddInventoryFormPage Inventorychange;
		RefillingSchedulingField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public RefillingScheduling(RefillingSchedulingField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the RefillingScheduling sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.RefillingSchedulingSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME49);

		}

		@Then("I load the rowise RefillingScheduling data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.RefillingSchedulingrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.RefillingSchedulingSheetData, row_name);
			System.out.println(Globals.Inventory.RefillingSchedulingrowwiseData);
		}

		@Then("I update value to the RefillingScheduling page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.RefillingSchedulingrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.RefillingSchedulingrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.RefillingSchedulingrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.RefillingSchedulingrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.RefillingSchedulingrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.RefillingSchedulingrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.RefillingSchedulingrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.RefillingSchedulingrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.RefillingSchedulingrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.RefillingSchedulingrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.RefillingSchedulingrowwiseData.get("ShelfCode");
			Globals.Inventory.ItemCode = Globals.Inventory.RefillingSchedulingrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.RefillingSchedulingrowwiseData.get("ItemName");
			Globals.Inventory.WareHouse = Globals.Inventory.RefillingSchedulingrowwiseData.get("WareHouse");
			Globals.Inventory.Batch = Globals.Inventory.RefillingSchedulingrowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.RefillingSchedulingrowwiseData.get("Batch1");
			Globals.Inventory.Batch2 = Globals.Inventory.RefillingSchedulingrowwiseData.get("Batch2");
			Globals.Inventory.Batch3 = Globals.Inventory.RefillingSchedulingrowwiseData.get("Batch3");
			Globals.Inventory.Selectfield = Globals.Inventory.RefillingSchedulingrowwiseData.get("Selectfield");
			Globals.Inventory.Changefield = Globals.Inventory.RefillingSchedulingrowwiseData.get("Changefield");
			Globals.Inventory.Billdate = Globals.Inventory.RefillingSchedulingrowwiseData.get("Billdate");
			Globals.Inventory.Date = Globals.Inventory.RefillingSchedulingrowwiseData.get("Date");
			Globals.Inventory.EarnedMargin = Globals.Inventory.RefillingSchedulingrowwiseData.get("EarnedMargin");
			Globals.Inventory.MRP = Globals.Inventory.RefillingSchedulingrowwiseData.get("MRP");
			Globals.Inventory.Netcost = Globals.Inventory.RefillingSchedulingrowwiseData.get("Netcost");
			Globals.Inventory.FromDate = Globals.Inventory.RefillingSchedulingrowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.RefillingSchedulingrowwiseData.get("ToDate");
			Globals.Inventory.Earnedmarginclick = Globals.Inventory.RefillingSchedulingrowwiseData.get("Earnedmarginclick");
			Globals.Inventory.MRPclick = Globals.Inventory.RefillingSchedulingrowwiseData.get("MRPclick");
			Globals.Inventory.Netcostclick = Globals.Inventory.RefillingSchedulingrowwiseData.get("Netcostclick");
			Globals.Inventory.NewFromDate = Globals.Inventory.RefillingSchedulingrowwiseData.get("NewFromDate");
			Globals.Inventory.NewToDate = Globals.Inventory.RefillingSchedulingrowwiseData.get("NewToDate");
			Globals.Inventory.Selectall = Globals.Inventory.RefillingSchedulingrowwiseData.get("Selectall");
			Globals.Inventory.AverageCost = Globals.Inventory.RefillingSchedulingrowwiseData.get("AverageCost");
			Globals.Inventory.Qty = Globals.Inventory.RefillingSchedulingrowwiseData.get("Qty");
			
			
			
		}

		@Then("I fill new RefillingScheduling data page using excel data")
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
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_searchFilterUserControlForDialogBox_lnkFilter")).click();

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_gvReFillSchedule_txtReFillQty_0")).sendKeys(Keys.RETURN);

			}
			
			pass.ExcelFourData("InventoryChange","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryChange", "Filters", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("RefillingScheduling","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("RefillingScheduling", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
		}

		@Then("I close connection  DB for RefillingScheduling")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for RefillingScheduling")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from RefillingScheduling table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000001'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblRefillingSchedule":
					String CategoryCode = "";
					try {
						CategoryCode = rs.getString("InventoryCode");
						System.out.println(CategoryCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), CategoryCode.trim());
						pass.Excelcreate("RefillingScheduling", "tblRefillingSchedule", "", 2, 0, 2, 1);
						pass.ExcelFourData("RefillingScheduling", "InventoryCode", Globals.Inventory.ItemCode, CategoryCode, "Pass",
								3, 0, 3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("RefillingScheduling", "tblRefillingSchedule", "", 2, 0, 2, 1);
						pass.ExcelFourData("RefillingScheduling", "InventoryCode", Globals.Inventory.ItemCode, CategoryCode, "Fail",
								3, 0, 3, 1, 3, 2, 3, 3);

					}
					catch(Exception e) {
						System.out.println("null error tblRefillingSchedule column CategoryCode");
						}
					String Departmentcode = "";
					try {
						Departmentcode = rs.getString("LastReFilledQty");
						System.out.println(Departmentcode);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Departmentcode.trim());
						pass.ExcelFourData("RefillingScheduling", "LastReFilledQty", Globals.Inventory.Qty, Departmentcode, "Pass",
								4, 0, 4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("RefillingScheduling", "LastReFilledQty", Globals.Inventory.Qty, Departmentcode, "Fail",
								4, 0, 4, 1, 4, 2, 4, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblRefillingSchedule column Departmentcode");
						}
					break;
				default:
					break;
				}
			
				}
			
		}
			



}
