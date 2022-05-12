
package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import org.openqa.selenium.WebElement;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Merchandise extends PageObject {
	AddInventoryFormPage Category;
	Merchandisefield icp;
	TerminalPage terPage;
    ExcelWrite pass;
	public Merchandise(Merchandisefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
	}

	@Then("I load the Merchandise sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.MerchandiseSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME30);
	}

	@Then("I load the rowise Merchandise data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.MerchandiserowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.MerchandiseSheetData, row_name);

		System.out.println(Globals.Inventory.MerchandiseSheetData);

	}

	@Then("I update value to the Merchandise page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.MerchandiseCode = Globals.Inventory.MerchandiserowwiseData.get("MerchandiseCode");
		Globals.Inventory.Remarks = Globals.Inventory.MerchandiserowwiseData.get("Remarks");
		Globals.Inventory.Description = Globals.Inventory.MerchandiserowwiseData.get("Description");

	}

	@Then("I fill new Merchandise data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.MerchandiseCode)) {
			terPage.terminal_waitClearEnterText_css(icp.MerchandiseCode_String, Globals.Inventory.MerchandiseCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
			terPage.terminal_waitClearEnterText_css(icp.Remarks_String, Globals.Inventory.Remarks);

		}

	}
	@Then("I close connection to Merchandise")
	public void I_close_connection_to_Merchandise() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection to Merchandise")
	public void I_establish_connection_to_Merchandise() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Given("I read the values from table {string} in Merchandise")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where MerchandiseCode='1'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblMerchandise":
				String MerchandiseCode = "";
				try {
					MerchandiseCode = rs.getString("MerchandiseCode");
					System.out.println(MerchandiseCode);
					Assert.assertEquals(Globals.Inventory.MerchandiseCode.trim(), MerchandiseCode.trim());
					pass.Excelcreate("merchandise", "tblMerchandise", "", 0, 0, 0, 0);
					pass.ExcelFourData("merchandise", "Dicountcode", Globals.Inventory.MerchandiseCode, MerchandiseCode, "Pass", 1, 0, 1, 1,
							1, 2, 1, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("merchandise", "tblMerchandise", "", 0, 0, 0, 0);
					pass.ExcelFourData("merchandise", "MerchandiseCode", Globals.Inventory.MerchandiseCode, MerchandiseCode, "Fail", 1, 0, 1, 1,
							1, 2, 1, 3);

				}
				
				String Description = "";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

					pass.ExcelFourData("merchandise", "Description", Globals.Inventory.Description, Description, "Pass", 2, 0, 2, 1,
							2, 2, 2, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("merchandise", "Description", Globals.Inventory.Description, Description, "Fail", 2, 0, 2, 1,
							2, 2, 2, 3);

				}
				String Remarks = "";
				try {
					Remarks = rs.getString("Remarks");
					System.out.println(Remarks);
					Assert.assertEquals(Globals.Inventory.Remarks.trim(), Remarks.trim());
					
					pass.ExcelFourData("merchandise", "Remarks", Globals.Inventory.Remarks, Remarks, "Pass",3, 0,
							3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					
					pass.ExcelFourData("merchandise", "Remarks", Globals.Inventory.Remarks, Remarks, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}
				
			

			}
		}
	}


}
