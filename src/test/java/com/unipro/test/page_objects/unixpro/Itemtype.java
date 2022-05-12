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

	public class Itemtype {
		AddInventoryFormPage Itemtype;
		Itemtypefield icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public  Itemtype(Itemtypefield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Itemtype = new AddInventoryFormPage();
		}
		
		@Then("I load the Itemtype sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ItemtypeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME11);
		}
		@Then("I load the rowise Itemtype data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ItemtyperowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ItemtypeSheetData, row_name);

			System.out.println(Globals.Inventory.ItemtypeSheetData);

		}

		@Then("I update value to the Itemtype page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Itemtypecode = Globals.Inventory.ItemtyperowwiseData.get("Itemtypecode");
			Globals.Inventory.Description = Globals.Inventory.ItemtyperowwiseData.get("Description");
			
		
			
		}

		@Then("I fill new Itemtype data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Itemtypecode)) {
				terPage.terminal_waitClearEnterText_css(icp.Itemtypecode_string, Globals.Inventory.Itemtypecode);
				

			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
	

		}
		@Then("I close connection to Itemtype")
		public void i_close_connection_to_Itemtype() {
			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;
		
		@Then("I establish connection to Itemtype")
		public void i_establish_connection_to_Itemtype() throws SQLException {
			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");
		}
		@Then("I read the values from table {string} in Itemtype")
		public void i_read_the_values_from_table_in_Itemtype(String tablename) throws SQLException, IOException {
			ResultSet rs = st.executeQuery("select * from " + tablename + " where ItemCode='Gokul'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblItemType":
					String Itemtypecode = "";
					try {
						Itemtypecode = rs.getString("ItemCode");
						System.out.println(Itemtypecode);
						Assert.assertEquals(Globals.Inventory.Itemtypecode.trim(), Itemtypecode.trim());
						 pass.Excelcreate("itemtype", "tblItemType", "", 2, 0, 2, 1);
						pass.ExcelFourData("itemtype", "Position", Globals.Inventory.Itemtypecode, Itemtypecode, "Pass", 3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						 pass.Excelcreate("itemtype", "tblItemType", "", 2, 0, 2, 1);
						pass.ExcelFourData("itemtype", "Itemtypecode", Globals.Inventory.Itemtypecode, Itemtypecode, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					

					String Description = "";
					try {
						Description = rs.getString("Description");
						System.out.println(Description);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

						pass.ExcelFourData("itemtype", "Description", Globals.Inventory.Description, Description, "Pass", 4, 0, 4,
								1, 4, 2, 4, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("itemtype", "Description", Globals.Inventory.Description, Description, "Fail", 4, 0, 4,
								1, 4, 2, 4, 3);

					}

				}

			}

		}
	}


