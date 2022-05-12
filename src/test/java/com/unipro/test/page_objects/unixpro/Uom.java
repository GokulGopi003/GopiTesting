package com.unipro.test.page_objects.unixpro;


	import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.Assert;
import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Uom {
		AddInventoryFormPage Category;
		Uomfield icp;
        ExcelWrite pass;
		TerminalPage terPage;
        Screenshot scr;
		public  Uom(Uomfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
            scr = new Screenshot();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Uom sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.UomSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME14);
		}
		@Then("I load the rowise Uom data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.UomrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.UomSheetData, row_name);

			System.out.println(Globals.Inventory.UomSheetData);

		}

		@Then("I update value to the Uom page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Uomcode = Globals.Inventory.UomrowwiseData.get("Uomcode");
			Globals.Inventory.Description = Globals.Inventory.UomrowwiseData.get("Description");
			Globals.Inventory.Units = Globals.Inventory.UomrowwiseData.get("Units");
			
		
			
		}

		@Then("I fill new Uom data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() throws Exception {
			try
			{
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Uomcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Uomcode_string, Globals.Inventory.Uomcode);
				

			}
			
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Units)) {
				terPage.terminal_waitClearEnterText_css(icp.Units_String, Globals.Inventory.Units);
			
			}
		
			pass.ExcelFourData("uomnew","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("uomnew", "UOM", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e) {
				
				scr.Screenshots();
				System.out.println("Screen shot taken");
				
				pass.ExcelFourData("uomnew","Modules", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("uomnew", "UOM", "FAIL", 1, 0, 1, 3);
				
			}
		
		
	}
		@Then("I close connection to Uom")
		public void i_close_connection_to_Uom() {
			
				mysqlConnect.disconnect();
				System.out.println(" closed succesfully");
			}
		
			MssqlConnect mysqlConnect;
			Statement st; 
		

		@Then("I establish connection to Uom")
		public void i_establish_connection_to_Uom() throws SQLException {
			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");
		}

		@Then("I read the values from table {string} in Uom")
		public void i_read_the_values_from_table_in_Uom(String tablename) throws SQLException, IOException {
			ResultSet rs = st.executeQuery("select * from " + tablename + " where UOMCode='1'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblUOM":
					String Uomcode = "";
					try {
						Uomcode = rs.getString("UOMCode");
						System.out.println(Uomcode);
						Assert.assertEquals(Globals.Inventory.Uomcode.trim(), Uomcode.trim());
						pass.Excelcreate("uomnew", "tblUOM", "", 3, 1, 3, 2);
						pass.ExcelFourData("uomnew", "Uomcode", Globals.Inventory.Uomcode, Uomcode, "Pass", 4, 0, 4, 1,
								4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("uomnew", "tblUOM", "", 3, 1, 3, 2);
						pass.ExcelFourData("uomnew", "Uomcode", Globals.Inventory.Uomcode, Uomcode, "Fail", 4, 0, 4, 1,
								4, 2, 4, 3);

					}

					String Description = "";
					try {
						Description = rs.getString("UOMDescription");
						System.out.println(Description);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

						pass.ExcelFourData("uomnew", "Description", Globals.Inventory.Description, Description, "Pass", 5, 0,
								5, 1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("uomnew", "Description", Globals.Inventory.Description, Description, "Fail", 5, 0,
								5, 1, 5, 2, 5, 3);

					}
					String Units = "";
					try {
						Units = rs.getString("Units");
						System.out.println(Units);
						Assert.assertEquals(Globals.Inventory.Units.trim(), Units.trim());

						pass.ExcelFourData("uomnew", "Units", Globals.Inventory.Units, Units, "Pass", 6, 0,
								6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("uomnew", "Units", Globals.Inventory.Units, Units, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}

		}
			}
		
		}

	

}
