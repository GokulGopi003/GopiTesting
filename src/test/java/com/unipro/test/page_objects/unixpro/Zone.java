package com.unipro.test.page_objects.unixpro;

	import com.unipro.test.framework.Globals;
	import java.io.IOException;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.testng.Assert;

	import com.gk.test.MssqlConnect;
	import com.unipro.ExcelWrite;

	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class Zone {
		AddInventoryFormPage Category;
		ZoneField icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public  Zone(ZoneField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Zone sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ZoneSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME25);
		}
		@Then("I load the rowise Zone data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ZonerowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ZoneSheetData, row_name);

			System.out.println(Globals.Inventory.ZoneSheetData);

		}

		@Then("I update value to the Zone page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Zonecode = Globals.Inventory.ZonerowwiseData.get("Zonecode");
			Globals.Inventory.ZoneName = Globals.Inventory.ZonerowwiseData.get("ZoneName");

			
		}

		@Then("I fill new Zone data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Zonecode)) {
				terPage.terminal_waitClearEnterText_css(icp.Zonecode_String, Globals.Inventory.Zonecode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ZoneName)) {
				terPage.terminal_waitClearEnterText_css(icp.ZoneName_String, Globals.Inventory.ZoneName);
			
			}
			
		
			
		
	}
		@Then("I close connection to Zone")
		public void I_close_connection_to_Zone() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to Zone")
		public void I_establish_connection_to_Zone() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in Zone")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where ZoneCode='a'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblZone":
					String Zonecode = "";
					try {
						Zonecode = rs.getString("ZoneCode");
						System.out.println(Zonecode);
						Assert.assertEquals(Globals.Inventory.Zonecode.trim(), Zonecode.trim());
						pass.Excelcreate("zone", "tblZone", "", 0, 0, 0, 0);
						pass.ExcelFourData("zone", "Zonecode", Globals.Inventory.Zonecode, Zonecode, "Pass", 1, 0, 1, 1,
								1, 2, 1, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("zone", "tblZone", "", 0, 0, 0, 0);
						pass.ExcelFourData("zone", "Zonecode", Globals.Inventory.Zonecode, Zonecode, "Fail", 1, 0, 1, 1,
								1, 2, 1, 3);

					}
					
					String ZoneName = "";
					try {
						ZoneName = rs.getString("Zonename");
						System.out.println(ZoneName);
						Assert.assertEquals(Globals.Inventory.ZoneName.trim(), ZoneName.trim());

						pass.ExcelFourData("zone", "ZoneName", Globals.Inventory.ZoneName, ZoneName, "Pass", 2, 0, 2, 1,
								2, 2, 2, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("zone", "ZoneName", Globals.Inventory.ZoneName, ZoneName, "Fail", 2, 0, 2, 1,
								2, 2, 2, 3);

					}
					break;
		
			
		
	
	



}

			}}}










