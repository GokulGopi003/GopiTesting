package com.unipro.test.page_objects.unixpro;

	import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class Size {
		AddInventoryFormPage Category;
		SizeField icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public  Size(SizeField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Size sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.SizeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME20);
		}
		@Then("I load the rowise Size data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.SizerowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.SizeSheetData, row_name);

			System.out.println(Globals.Inventory.SizeSheetData);

		}

		@Then("I update value to the Size page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Description = Globals.Inventory.SizerowwiseData.get("Description");
			Globals.Inventory.SizeCode = Globals.Inventory.SizerowwiseData.get("SizeCode");

			
		}

		@Then("I fill new Size data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.SizeCode)) {
				terPage.terminal_waitClearEnterText_css(icp.Sizecode_String, Globals.Inventory.SizeCode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
		
			
		
	}
		@Then("I close connection to Size")
		public void I_close_connection_to_Size() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to Size")
		public void I_establish_connection_to_Size() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in Size")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where Description ='Big'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblSize":
					
					String Description = "";
					try {
						
						Description = rs.getString("Description");
						System.out.println("3");
						System.out.println(Description);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());
						pass.Excelcreate("size", "tblSize", "", 1, 0, 1, 1);
						pass.ExcelFourData("size", "Description", Globals.Inventory.Description, Description, "Pass", 2, 0, 2, 1,
								2, 2, 2, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("size", "tblSize", "", 1, 0, 1, 1);
						pass.ExcelFourData("size", "Description", Globals.Inventory.Description, Description, "Fail", 2, 0, 2, 1,
								2, 2, 2, 3);

					}

					String SizeCode = "";
					try {
						SizeCode = rs.getString("SizeCode");
						System.out.println(SizeCode);
						Assert.assertEquals(Globals.Inventory.SizeCode.trim(), SizeCode.trim());

						pass.ExcelFourData("size", "SizeCode", Globals.Inventory.SizeCode, SizeCode, "Pass", 3,
								0, 3, 1, 3, 2, 3, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("size", "SizeCode", Globals.Inventory.SizeCode, SizeCode,"Fail",3,0,3, 1, 3, 2, 3, 3);

					}
	
}




}

		}}







