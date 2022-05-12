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

	public class Bin {
		AddInventoryFormPage Category;
		BinField icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public   Bin(BinField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Bin sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.BinSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME16);
		}
		@Then("I load the rowise Bin data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.BinrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.BinSheetData, row_name);

			System.out.println(Globals.Inventory.BinSheetData);

		}

		@Then("I update value to the Bin page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Description = Globals.Inventory.BinrowwiseData.get("Description");
			Globals.Inventory.Qty = Globals.Inventory.BinrowwiseData.get("Qty");
			Globals.Inventory.Bincode = Globals.Inventory.BinrowwiseData.get("Bincode");
			
		
			
		}

		@Then("I fill new Bin data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Bincode)) {
				terPage.terminal_waitClearEnterText_css(icp.Bincode_String, Globals.Inventory.Bincode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terPage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
			
			}
			
		
			
		
	}
		@Then("I close connection to Bin")
		public void I_close_connection_to_Bin() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;


		@Then("I establish connection to Bin")
		public void I_establish_connection_to_Bin() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");


		}	

		@Given("I read the values from table {string} in Bin")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where BinCode='1'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				case "tblBin":
				System.out.println("1");
				String Bincode="";
				try {
					System.out.println("2");
					Bincode = rs.getString("Bincode");
					System.out.println("3");
					System.out.println(Bincode);
					Assert.assertEquals(Globals.Inventory.Bincode.trim(), Bincode.trim());
					pass.Excelcreate("Bin", "tblBin", "",3, 0, 3, 1);
					pass.ExcelFourData("Bin", "BinCode", Globals.Inventory.Bincode, Bincode, "Pass",
							4, 0, 4, 1, 4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Bin", "tblBin", "", 3, 0, 3, 1);
					pass.ExcelFourData("Bin", "BinCode",  Globals.Inventory.Bincode, Bincode, "Fail",
							4, 0, 4, 1, 4, 2, 4, 3);

				}
				
				String Description="";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());
					//pass.Excelcreate("Bin", "tblBin", "", 5, 0, 5, 1);
					pass.ExcelFourData("Bin", "Description", Globals.Inventory.Description, Description,
							"Pass", 6, 0, 6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {
					//pass.Excelcreate("Bin", "tblBin", "", 5, 0, 5, 1);
					pass.ExcelFourData("Bin", "Description", Globals.Inventory.Description, Description,
							"Fail", 6, 0, 6, 1, 6, 2, 6, 3);

				}
				String Qty = "";
				try {
					Qty = rs.getString("Qty");
					System.out.println(Qty);
					Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
					//pass.Excelcreate("Bin", "tblBin", "", 7, 0, 7, 1);
					pass.ExcelFourData("Bin", "Qty", Globals.Inventory.Qty, Qty,
							"Pass", 7, 0, 7, 1, 7, 2, 7, 3);

				} catch (AssertionError e) {
					//pass.Excelcreate("Bin", "tblBin", "", 7, 0, 7, 1);
					pass.ExcelFourData("Bin", "Qty", Globals.Inventory.Qty, Qty,
							"Fail", 7, 0, 7, 1, 7, 2, 7, 3);

				}
				break;
				
				default:
					break;
				}

				}
		}

	

}



