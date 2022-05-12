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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class Shelf {
		AddInventoryFormPage Category;
		ShelfField icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public  Shelf(ShelfField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Shelf sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ShelfSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME18);
		}
		@Then("I load the rowise Shelf data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ShelfrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ShelfSheetData, row_name);

			System.out.println(Globals.Inventory.ShelfSheetData);

		}

		@Then("I update value to the Shelf page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Description = Globals.Inventory.ShelfrowwiseData.get("Description");
			Globals.Inventory.ShelfCode = Globals.Inventory.ShelfrowwiseData.get("ShelfCode");

			
		}

		@Then("I fill new Shelf data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
				terPage.terminal_waitClearEnterText_css(icp.Shelfcode_String, Globals.Inventory.ShelfCode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
		
			
		
	}
		@Then("I close connection to Shelf")
		public void I_close_connection_to_Shelf() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to Shelf")
		public void I_establish_connection_to_Shelf() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in Shelf")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where ShelfCode='1'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblShelf":
					System.out.println("1");
					String ShelfCode = "";
					try {
						System.out.println("2");
						ShelfCode = rs.getString("ShelfCode");
						System.out.println("3");
						System.out.println(ShelfCode);
						Assert.assertEquals(Globals.Inventory.ShelfCode.trim(), ShelfCode.trim());
						pass.Excelcreate("shelf", "tblShelf", "", 1, 0, 1, 1);
						pass.ExcelFourData("shelf", "ShelfCode", Globals.Inventory.ShelfCode, ShelfCode, "Pass", 2, 0, 2, 1,
								2, 2, 2, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("shelf", "tblShelf", "", 1, 0, 1, 1);
						pass.ExcelFourData("shelf", "ShelfCode", Globals.Inventory.ShelfCode, ShelfCode, "Fail", 2, 0, 2, 1,
								2, 2, 2, 3);

					}

					String Description = "";
					try {
						Description = rs.getString("Description");
						System.out.println(Description);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

						pass.ExcelFourData("shelf", "Description", Globals.Inventory.Description, Description, "Pass", 3,
								0, 3, 1, 3, 2, 3, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("shelf", "Description", Globals.Inventory.Description, Description, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}

					break;
				}
			}
		}
	}





