package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class Subclass {
	AddInventoryFormPage Category;
	Subclassfield icp;
	ExcelWrite pass;
	TerminalPage terPage;

	public Subclass(Subclassfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		pass = new ExcelWrite();

		Category = new AddInventoryFormPage();
	}

	@Then("I load the Subclass sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.SubclassSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME10);
	}

	@Then("I load the rowise Subclass data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.SubclassrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SubclassSheetData, row_name);

		System.out.println(Globals.Inventory.SubclassSheetData);

	}

	@Then("I update value to the Subclass page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Subclasscode = Globals.Inventory.SubclassrowwiseData.get("Subclasscode");
		Globals.Inventory.Description = Globals.Inventory.SubclassrowwiseData.get("Description");

	}

	@Then("I fill new Subclass data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Subclasscode)) {
			terPage.terminal_waitClearEnterText_css(icp.Subclasscode_string, Globals.Inventory.Subclasscode);

		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);

		}

	}
	@Then("I close connection to Subclass")
	public void i_close_connection_to_Subclass() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}

	MssqlConnect mysqlConnect;
	java.sql.Statement st;

	
	@Then("I establish connection to Subclass")
	public void i_establish_connection_to_Subclass() throws SQLException  {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	

	}	

	@Then("I read the values from table {string} in Subclass")
	public void i_read_the_values_from_table_in_Subclass(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where SubClassCode='Gopi'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblSubClass":
				String Subclasscode = "";
				try {
					Subclasscode = rs.getString("SubClassCode");
					System.out.println(Subclasscode);
					Assert.assertEquals(Globals.Inventory.Subclasscode.trim(), Subclasscode.trim());
					pass.Excelcreate("subclass", "tblSubClass", "", 0, 1, 0, 2);
					pass.ExcelFourData("subclass", "Subclasscode", Globals.Inventory.Subclasscode, Subclasscode, "Pass",
							1, 0, 1, 1, 1, 2, 1, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("subclass", "tblSubClass", "", 0, 1, 0, 2);
					pass.ExcelFourData("subclass", "Subclasscode", Globals.Inventory.Subclasscode, Subclasscode, "Fail",
							1, 0, 1, 1, 1, 2, 1, 3);

				}

				String Description = "";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

					pass.ExcelFourData("subclass", "Description", Globals.Inventory.Description, Description, "Pass", 2,
							0, 2, 1, 2, 2, 2, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("subclass", "Description", Globals.Inventory.Description, Description, "Fail", 2,
							0, 2, 1, 2, 2, 2, 3);

				
				}
			}
		}


			
	}
}

