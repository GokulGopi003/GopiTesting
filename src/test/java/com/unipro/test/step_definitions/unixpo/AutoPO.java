package com.unipro.test.step_definitions.unixpo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;
import com.unipro.test.page_objects.unixpro.CommonPages;
import com.unipro.test.page_objects.unixpro.CreateGRN;
import com.unipro.test.page_objects.unixpro.TerminalPage;
import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

import bsh.Console;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AutoPO extends PageObject {

	AddInventoryFormPage add_inventory;
	AutoPOField icp;
	CommonPages cp;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terPage;

	public AutoPO(AutoPOField icp, CommonPages cp) {
		this.icp = icp;
		terPage = new TerminalPage();

		this.cp = cp;
		add_inventory = new AddInventoryFormPage();
		pass = new ExcelWrite();
		scr = new Screenshot();
	}

	@Then("I load the AutoPO sheet data to map")
	public void i_load_the_GA_sheet_data_to_map() {

		// Globals.Inventory.inventorySheetData1 =
		// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

		Globals.Inventory.AutoPOSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME34);

	}

	@Then("I load the rowise AutoPO data for {string} rowname")
	public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

		Globals.Inventory.AutoPOrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.AutoPOSheetData, row_name);

		System.out.println(Globals.Inventory.AutoPOrowwiseData);

	}

	@Then("I update value to the AutoPO page global Variables")
	public void i_update_value_to_the_GA_page_global_Variables() {
		Globals.Inventory.LocationCode = Globals.Inventory.AutoPOrowwiseData.get("LocationCode");
		Globals.Inventory.Vendor = Globals.Inventory.AutoPOrowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.AutoPOrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.AutoPOrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.AutoPOrowwiseData.get("Brand");
		Globals.Inventory.SubCategory = Globals.Inventory.AutoPOrowwiseData.get("SubCategory");
		Globals.Inventory.Merchandise = Globals.Inventory.AutoPOrowwiseData.get("Merchandise");
		Globals.Inventory.Manufacture = Globals.Inventory.AutoPOrowwiseData.get("Manufacture");
		Globals.Inventory.Floorcode = Globals.Inventory.AutoPOrowwiseData.get("Floorcode");
		Globals.Inventory.Section = Globals.Inventory.AutoPOrowwiseData.get("Section");
		Globals.Inventory.Bin = Globals.Inventory.AutoPOrowwiseData.get("Bin");
		Globals.Inventory.ShelfCode = Globals.Inventory.AutoPOrowwiseData.get("ShelfCode");
		Globals.Inventory.ItemCode = Globals.Inventory.AutoPOrowwiseData.get("ItemCode");
		Globals.Inventory.ItemName = Globals.Inventory.AutoPOrowwiseData.get("ItemName");
		Globals.Inventory.Class = Globals.Inventory.AutoPOrowwiseData.get("Class");
		Globals.Inventory.Date = Globals.Inventory.AutoPOrowwiseData.get("Date");
		Globals.Inventory.Billdate = Globals.Inventory.AutoPOrowwiseData.get("Billdate");
		Globals.Inventory.Qty = Globals.Inventory.AutoPOrowwiseData.get("Qty");
		Globals.Inventory.BasicCost = Globals.Inventory.AutoPOrowwiseData.get("BasicCost");
		Globals.Inventory.MinMax = Globals.Inventory.AutoPOrowwiseData.get("MinMax");
		Globals.Inventory.Bulkchild = Globals.Inventory.AutoPOrowwiseData.get("Bulkchild");
		Globals.Inventory.Presupplywise = Globals.Inventory.AutoPOrowwiseData.get("Presupplywise");
		Globals.Inventory.Basedoninventory = Globals.Inventory.AutoPOrowwiseData.get("Basedoninventory");
		Globals.Inventory.Soldqty = Globals.Inventory.AutoPOrowwiseData.get("Soldqty");
		Globals.Inventory.Reorderbynoofdays = Globals.Inventory.AutoPOrowwiseData.get("Reorderbynoofdays");
		Globals.Inventory.Soldqtyinlastpurchase = Globals.Inventory.AutoPOrowwiseData.get("Soldqtyinlastpurchase");
		Globals.Inventory.Reqtycycledays = Globals.Inventory.AutoPOrowwiseData.get("Reqtycycledays");

	}

	@Then("I fill new AutoPO data page using excel data")
	public void i_fill_new_GA_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
			terPage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.LocationCode, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.LocationCode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terPage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terPage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Category).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terPage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Brand).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
			terPage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.SubCategory).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
			terPage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Merchandise);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Merchandise, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Merchandise).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
			terPage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Manufacture).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
			terPage.terminal_waitClearEnterText_css(icp.Floorcode_String, Globals.Inventory.Floorcode);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Floorcode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
			terPage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Section).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
			terPage.terminal_waitClearEnterText_css(icp.Bin_String, Globals.Inventory.Bin);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Bin, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Bin).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
			terPage.terminal_waitClearEnterText_css(icp.ShelfCode_String, Globals.Inventory.ShelfCode);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.ItemCode).click();
		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
			terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemName")).sendKeys(Keys.RETURN);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
			terPage.terminal_waitClearEnterText_css(icp.Class_String, Globals.Inventory.Class);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Class).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Billdate)) {
			terPage.terminal_waitClearEnterText_css(icp.Billdate_String, Globals.Inventory.Billdate);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
			webDriver.findElement(By.cssSelector("h1#ui-id-8")).click();
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
			terPage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty")).sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
			terPage.terminal_waitClearEnterText_css(icp.BasicCost_String, Globals.Inventory.BasicCost);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice")).sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.MinMax)) {
			terPage.get_checkBox_element(icp.MinMax_String).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Bulkchild)) {
			terPage.get_checkBox_element(icp.Bulkchild_String).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Presupplywise)) {
			terPage.get_checkBox_element(icp.Presupplywise_String).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Basedoninventory)) {
			terPage.get_checkBox_element(icp.Basedoninventory_String).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Soldqty)) {
			terPage.get_checkBox_element(icp.Soldqty_String).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Reorderbynoofdays)) {
			terPage.get_checkBox_element(icp.Reorderbynoofdays_String).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Soldqtyinlastpurchase)) {
			terPage.get_checkBox_element(icp.Soldqtyinlastpurchase_String).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Reqtycycledays)) {
			terPage.get_checkBox_element(icp.Reqtycycledays_String).click();

		}
	
	pass.ExcelFourData("AutoPO","Modules", "Actual", "Expected", "Status",
			0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
	pass.Excelcreate("AutoPO", "Filters", "Pass", 1, 0, 1, 3);
}
catch(Exception e) {
// screen shot
scr.Screenshots();
System.out.println("Screen shot taken");
// Xl sheet write
pass.ExcelFourData("AutoPO","Filters", "Actual", "Expected", "Status",
	0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
pass.Excelcreate("AutoPO", "Filters", "FAIL", 1, 0, 1, 3);

}
	}

	@Then("I close connection  DB for AutoPO")
	public void I_close_connection_to_DB() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}

	MssqlConnect mysqlConnect;
	Statement st;
	@Then("I establish connection  DB for AutoPO")
	public void I_establish_connection_to_DB() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}
	@Given("I read the values from AutoPO table {string} in DB")
	public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
		
		
		ResultSet rs = st.executeQuery("select * from "+tablename+" where Vendorcode='V00246'");
		
		System.out.println(rs);
		//ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			switch (tablename) {
			
			case "tblpoheader":
					
				String Sellingprice="";
				try {
					Sellingprice = rs.getString("VendorCode");
					System.out.println(Sellingprice);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Sellingprice.trim());
					pass.Excelcreate("AutoPO", "tblpoheader", "", 3, 0, 3, 1);
					pass.ExcelFourData("AutoPO", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Pass",
							5, 0, 5, 1, 5, 2, 5, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("AutoPO", "tblpoheader", "", 3, 0, 3, 1);
					pass.ExcelFourData("AutoPO", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Fail",
							5, 0, 5, 1, 5, 2, 5, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoheader column VendorCode");
				}
				
				
				break;
				
			case "tblpoDetail":
				String Promotionfromdate="";
				try
				{
					Promotionfromdate = rs.getString("ItemCode");
					System.out.println(Promotionfromdate);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Promotionfromdate.trim());
					pass.Excelcreate("AutoPO", "tblpoDetail", "", 7, 0, 7, 1);
					pass.ExcelFourData("AutoPO", "RangeFrom", Globals.Inventory.ItemCode, Promotionfromdate, "Pass",
							8, 0, 8, 1, 8, 2, 8, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("AutoPO", "tblpoDetail", "", 7, 0, 7, 1);
					pass.ExcelFourData("AutoPO", "RangeFrom", Globals.Inventory.ItemCode, Promotionfromdate, "Fail",
							8, 0, 8, 1, 8, 2, 8, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column ItemCode");
				}
				String Promotiontodate="";
				try
				{
					Promotiontodate = rs.getString("VendorCode");
					System.out.println(Promotiontodate);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Promotiontodate.trim());
					pass.ExcelFourData("AutoPO", "VendorCode", Globals.Inventory.Vendor, Promotiontodate, "Pass",
							9, 0, 9, 1, 9, 2, 9, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("AutoPO", "VendorCode", Globals.Inventory.Vendor, Promotiontodate, "Fail",
							9, 0, 9, 1, 9, 2, 9, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column VendorCode");
				}
				String Promotionfromtime="";
				try
				{
					Promotionfromtime = rs.getString("LQty");
					System.out.println(Promotionfromtime);
					Assert.assertEquals(Globals.Inventory.InvQty.trim(), Promotionfromtime.trim());
					pass.ExcelFourData("AutoPO", "InvQty", Globals.Inventory.InvQty, Promotionfromtime, "Pass",
							10, 0, 10, 1, 10, 2,10, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("AutoPO", "InvQty", Globals.Inventory.InvQty, Promotionfromtime, "Fail",
							10, 0, 10, 1, 10, 2,10, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column InvQty");
				}
				String WQty="";
				try
				{
					WQty = rs.getString("WQty");
					System.out.println(WQty);
					Assert.assertEquals(Globals.Inventory.InvQty.trim(), WQty.trim());
					pass.ExcelFourData("AutoPO", "InvQty", Globals.Inventory.InvQty, WQty, "Pass",
							11, 0, 11, 1, 11, 2,11, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("AutoPO", "InvQty", Globals.Inventory.InvQty, WQty, "Fail",
							11, 0, 11, 1, 11, 2,11, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column WQty");
				}
				String Foc="";
				try
				{
					Foc = rs.getString("FocQty");
					System.out.println(Foc);
					Assert.assertEquals(Globals.Inventory.foc.trim(), Foc.trim());
					pass.ExcelFourData("AutoPO", "foc", Globals.Inventory.foc, Foc, "Pass",
							11, 0, 11, 1, 11, 2,11, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("AutoPO", "foc", Globals.Inventory.foc, Foc, "Fail",
							11, 0, 11, 1, 11, 2,11, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column foc");
				}
				String UnitCost="";
				try
				{
					UnitCost = rs.getString("UnitCost");
					System.out.println(UnitCost);
					Assert.assertEquals(Globals.Inventory.foc.trim(), UnitCost.trim());
					pass.ExcelFourData("AutoPO", "foc", Globals.Inventory.foc, UnitCost, "Pass",
							11, 0, 11, 1, 11, 2,11, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("AutoPO", "foc", Globals.Inventory.foc, UnitCost, "Fail",
							11, 0, 11, 1, 11, 2,11, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column foc");
				}
				String SellingPrice="";
				try
				{
					SellingPrice = rs.getString("Disc1Per");
					System.out.println(SellingPrice);
					Assert.assertEquals(Globals.Inventory.SDP.trim(), SellingPrice.trim());
					pass.ExcelFourData("AutoPO", "foc", Globals.Inventory.SDP, SellingPrice, "Pass",
							12, 0, 12, 1, 12, 2,12, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("AutoPO", "foc", Globals.Inventory.SDP, SellingPrice, "Fail",
							12, 0, 12, 1, 12, 2,12, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column SDP");
				}
				
			default:
				break;
			}
		
			}
		
	}
}
