package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class PoVendorChange extends PageObject {

	AddInventoryFormPage Category;
	PovendorChaneField icp;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terPage;

	public PoVendorChange(PovendorChaneField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass = new ExcelWrite();
		scr = new Screenshot();
	}

	@Then("I load the PoVendorChange sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.PoVendorChangeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME26);
	}

	@Then("I load the rowise PoVendorChange data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.PoVendorChangerowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PoVendorChangeSheetData, row_name);

		System.out.println(Globals.Inventory.PoVendorChangeSheetData);

	}

	@Then("I update value to the PoVendorChange page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.PoNo = Globals.Inventory.PoVendorChangerowwiseData.get("PoNo");
		Globals.Inventory.Vendor = Globals.Inventory.PoVendorChangerowwiseData.get("Vendor");

	}

	@Then("I fill new PoVendorChange data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() throws Exception {
		try {
	

		if (GenericWrappers.isNotEmpty(Globals.Inventory.PoNo)) {
			terPage.terminal_waitClearEnterText_css(icp.PoNo_String, Globals.Inventory.PoNo);
			Category.clearAndTypeSlowly(Globals.Inventory.PoNo, "input#txtSearch");
			Category.return_td_invoke_element(Globals.Inventory.PoNo).click();

		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Category.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Category.return_td_invoke_element(Globals.Inventory.Vendor).click();

		}
		pass.ExcelFourData("PoVendorChange","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("PoVendorChange", "Filters", "Pass", 1, 0, 1, 3);
	}
	catch(Exception e) {
	// screen shot
	scr.Screenshots();
	System.out.println("Screen shot taken");
	// Xl sheet write
	pass.ExcelFourData("PoVendorChange","Filters", "Actual", "Expected", "Status",
		0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
	pass.Excelcreate("PoVendorChange", "Filters", "FAIL", 1, 0, 1, 3);
			
		}
	}

	@Then("I close connection  DB for PoVendorChange")
	public void I_close_connection_to_DB() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}

	MssqlConnect mysqlConnect;
	Statement st;
	@Then("I establish connection  DB for PoVendorChange")
	public void I_establish_connection_to_DB() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}
	@Given("I read the values from PoVendorChange table {string} in DB")
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
					pass.Excelcreate("PoVendorChange", "tblpoheader", "", 3, 0, 3, 1);
					pass.ExcelFourData("PoVendorChange", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Pass",
							5, 0, 5, 1, 5, 2, 5, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PoVendorChange", "tblpoheader", "", 3, 0, 3, 1);
					pass.ExcelFourData("PoVendorChange", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Fail",
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
					Promotionfromdate = rs.getString("VendorCode");
					System.out.println(Promotionfromdate);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Promotionfromdate.trim());
					pass.Excelcreate("PoVendorChange", "tblpoDetail", "", 7, 0, 7, 1);
					pass.ExcelFourData("PoVendorChange", "VendorCode", Globals.Inventory.Vendor, Promotionfromdate, "Pass",
							8, 0, 8, 1, 8, 2, 8, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PoVendorChange", "tblpoDetail", "", 7, 0, 7, 1);
					pass.ExcelFourData("PoVendorChange", "VendorCode", Globals.Inventory.Vendor, Promotionfromdate, "Fail",
							8, 0, 8, 1, 8, 2, 8, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column VendorCode");
				}
				
				
			default:
				break;
			}
		
		}
	}
	

}
