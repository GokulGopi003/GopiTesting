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
import org.openqa.selenium.support.ui.Select;
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


public class ReorderSettings  extends PageObject {
		AddInventoryFormPage Inventorychange;
		ReordersettingsField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;
		
		public ReorderSettings(ReordersettingsField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;
			pass = new ExcelWrite();
			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			 scr=new Screenshot();

		}

		@Then("I load the ReorderSettings sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.ReorderSettingsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME44);

		}

		@Then("I load the rowise ReorderSettings data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.ReorderSettingsrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ReorderSettingsSheetData, row_name);
			System.out.println(Globals.Inventory.ReorderSettingsrowwiseData);
		}

		@Then("I update value to the ReorderSettings page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.LocationCode = Globals.Inventory.ReorderSettingsrowwiseData.get("LocationCode");
			Globals.Inventory.Vendor = Globals.Inventory.ReorderSettingsrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.ReorderSettingsrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.ReorderSettingsrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.ReorderSettingsrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.ReorderSettingsrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.ReorderSettingsrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.ReorderSettingsrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.ReorderSettingsrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.ReorderSettingsrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.ReorderSettingsrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.ReorderSettingsrowwiseData.get("ShelfCode");
			Globals.Inventory.ItemCode = Globals.Inventory.ReorderSettingsrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.ReorderSettingsrowwiseData.get("ItemName");
			Globals.Inventory.Class = Globals.Inventory.ReorderSettingsrowwiseData.get("Class");
			Globals.Inventory.SubClass = Globals.Inventory.ReorderSettingsrowwiseData.get("SubClass");
			Globals.Inventory.WareHouse = Globals.Inventory.ReorderSettingsrowwiseData.get("WareHouse");
			Globals.Inventory.ItemType = Globals.Inventory.ReorderSettingsrowwiseData.get("ItemType");
			Globals.Inventory.Orderby = Globals.Inventory.ReorderSettingsrowwiseData.get("Orderby");
			Globals.Inventory.CheckBox1 = Globals.Inventory.ReorderSettingsrowwiseData.get("CheckBox1");
			Globals.Inventory.CheckBox2 = Globals.Inventory.ReorderSettingsrowwiseData.get("CheckBox2");
			Globals.Inventory.Cycledays = Globals.Inventory.ReorderSettingsrowwiseData.get("Cycledays");
			Globals.Inventory.MinQty = Globals.Inventory.ReorderSettingsrowwiseData.get("MinQty");
			Globals.Inventory.MaxQty = Globals.Inventory.ReorderSettingsrowwiseData.get("MaxQty");
			
			
			
		}

		@Then("I fill new ReorderSettings data page using excel data")
		public void i_fill_new_ReorderSettings_data_page_using_excel_data() throws Exception {
			try {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
				GenericWrappers.sleepInSeconds(10);
				terpage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.LocationCode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.LocationCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				GenericWrappers.sleepInSeconds(10);
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
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
				terpage.terminal_waitClearEnterText_css(icp.Class_String, Globals.Inventory.Class);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.Class).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SubClass)) {
				terpage.terminal_waitClearEnterText_css(icp.SubClass_String, Globals.Inventory.SubClass);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubClass, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.SubClass).click();
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
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode")).sendKeys(Keys.RETURN);
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemName")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemType)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemType_String, Globals.Inventory.ItemType);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemType, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ItemType).click();

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Orderby)) {
				Select checkbox = new Select(webDriver.findElement((By.id("ContentPlaceHolder1_ddReOrderBy_chzn"))));
				checkbox.selectByVisibleText(Globals.Inventory.Orderby);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CheckBox1)) {
				Select checkbox = new Select(webDriver.findElement((By.id("ContentPlaceHolder1_ddMinQty_chzn"))));
				checkbox.selectByVisibleText(Globals.Inventory.CheckBox1);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Cycledays)) {
				terpage.terminal_waitClearEnterText_css(icp.Cycledays_String, Globals.Inventory.Cycledays);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CheckBox2)) {
				Select checkbox = new Select(webDriver.findElement((By.id("ContentPlaceHolder1_ddAutoPo_chzn"))));
				checkbox.selectByVisibleText(Globals.Inventory.CheckBox2);

			}
			pass.ExcelFourData("ReorderSettings","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("ReorderSettings", "Filters", "PASS", 1, 0, 1, 3);
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("ReorderSettings","Modules", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("ReorderSettings", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
			

		}

		@Then("I fill min and maxqty")
		public void i_fill_filter() throws IOException {
			try {
			
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.MinQty)) {
				terpage.terminal_waitClearEnterText_css(icp.MinQty_String, Globals.Inventory.MinQty);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.MaxQty)) {
				terpage.terminal_waitClearEnterText_css(icp.MaxQty_String, Globals.Inventory.MaxQty);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ReorderQty)) {
				terpage.terminal_waitClearEnterText_css(icp.ReorderQty_String, Globals.Inventory.ReorderQty);
			}
			pass.Excelcreate("ReorderSettings", "Filters", "PASS", 2, 0, 2, 3);
			}
			catch(Exception e) {
				
				pass.Excelcreate("ReorderSettings", "Filters", "PASS", 2, 0, 2, 3);
			}
			
			
		}
		@Then("I close connection  DB for Reordersettings")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}
		MssqlConnect mysqlConnect;
		Statement st;
		 
		@Then("I establish connection  DB for Reordersettings")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from Reordersettings table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000001'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblinventory":
					String MinQty="";
					try
					{
						MinQty = rs.getString("MinimumQtyLevel");
						System.out.println(MinQty);
						Assert.assertEquals(Globals.Inventory.MinQty.trim(), MinQty.trim());
						pass.Excelcreate("Inventory", "tbldepartment", "", 3, 0, 3, 1);
						pass.ExcelFourData("Inventory", "MinQty", Globals.Inventory.MinQty, MinQty, "Pass",
								4, 0, 4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("Inventory", "tbldepartment", "", 3, 0, 3, 1);
						pass.ExcelFourData("Inventory", "MinQty", Globals.Inventory.MinQty, MinQty, "Fail",
								4, 0, 4, 1, 4, 2, 4, 3);
					}
					String MaxQty="";
					try {
						MaxQty = rs.getString("MaximumQtyLevel");
						System.out.println(MaxQty);
						Assert.assertEquals(Globals.Inventory.MaxQty.trim(), MaxQty.trim());
						pass.ExcelFourData("Inventory", "MaxQty", Globals.Inventory.MaxQty, MaxQty, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "MaxQty", Globals.Inventory.MaxQty, MaxQty, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					String ReorderQty="";
					try {
						ReorderQty = rs.getString("ReOrderLevel");
						System.out.println(ReorderQty);
						Assert.assertEquals(Globals.Inventory.ReorderQty.trim(), ReorderQty.trim());
						pass.Excelcreate("Inventory", "tbldepartment", "", 7, 0, 7, 1);
						pass.ExcelFourData("Inventory", "ReorderQty", Globals.Inventory.ReorderQty, ReorderQty, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "ReorderQty", Globals.Inventory.ReorderQty, ReorderQty, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					String Cycledays="";
					try {
						Cycledays = rs.getString("ReOrderDays");
						System.out.println(Cycledays);
						Assert.assertEquals(Globals.Inventory.Cycledays.trim(), Cycledays.trim());
						pass.ExcelFourData("Inventory", "Cycledays", Globals.Inventory.Cycledays, Cycledays, "Pass",
								7, 0, 7, 1, 7, 2, 7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "Cycledays", Globals.Inventory.Cycledays, Cycledays, "Fail",
								7, 0, 7, 1, 7, 2, 7, 3);
					}
					String Orderby="";
					try {
						Orderby = rs.getString("AutoPOReqBy");
						System.out.println(Orderby);
						Assert.assertEquals(Globals.Inventory.Orderby.trim(), Orderby.trim());
						pass.ExcelFourData("Inventory", "Orderby", Globals.Inventory.Orderby, Orderby, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "Orderby", Globals.Inventory.Orderby, Orderby, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					String CheckBox1="";
					try {
					    CheckBox1 = rs.getString("MinQtycalBy");
						System.out.println(CheckBox1);
						Assert.assertEquals(Globals.Inventory.CheckBox1.trim(), CheckBox1.trim());
						pass.ExcelFourData("Inventory", "MinQtycalBy", Globals.Inventory.CheckBox1, CheckBox1, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "MinQtycalBy", Globals.Inventory.CheckBox1, CheckBox1, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					String CheckBox2="";
					try {
						CheckBox2 = rs.getString("ReOrderBy");
						System.out.println(CheckBox2);
						Assert.assertEquals(Globals.Inventory.CheckBox2.trim(), CheckBox2.trim());
						pass.ExcelFourData("Inventory", "ReOrderBy", Globals.Inventory.CheckBox2, CheckBox2, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "ReOrderBy", Globals.Inventory.CheckBox2, CheckBox2, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					break;
				
				default:
					break;
				}}
			}
		
		
			



}
