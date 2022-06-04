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
	import com.unipro.test.framework.helpers.utils.ReadXLSXFile;

	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	public class Category {

		AddInventoryFormPage Category;
		Categoryfield icp;
		ExcelWrite pass;
		TerminalPage terPage;

		public  Category(Categoryfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
	            
		}

@Then("I load the Category sheet data to map")
public void i_load_the_Category_sheet_data_to_map() {
	//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

	Globals.Inventory.CategorySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME2);
}
	

		@Then("I load the rowise Category data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.CategoryrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CategorySheetData, row_name);

			System.out.println(Globals.Inventory.CategorySheetData);

		}
		@Then("I update value to the Category page global Variables")
		public void i_update_value_to_the_Category_page_global_Variables() {

		
			Globals.Inventory.Categorycode = Globals.Inventory.CategoryrowwiseData.get("Categorycode");
			Globals.Inventory.Categoryname = Globals.Inventory.CategoryrowwiseData.get("Categoryname");
			Globals.Inventory.Discount = Globals.Inventory.CategoryrowwiseData.get("Discount");
			Globals.Inventory.Remark = Globals.Inventory.CategoryrowwiseData.get("Remark");
			
			
			
		}
		@Then("I fill new Category data page using excel data")
		public void i_fill_new_Category_data_page_using_excel_data() {

			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Categorycode)) {
				terPage.terminal_waitClearEnterText_css(icp.Categorycode_string, Globals.Inventory.Categorycode);
				

			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Categoryname)) {
				terPage.terminal_waitClearEnterText_css(icp.Categoryname_String, Globals.Inventory.Categoryname);
			
			}
			
	
			/*if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
				terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
				
				
	}*/
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Remark)) {
				terPage.terminal_waitClearEnterText_css(icp.Remark_String, Globals.Inventory.Remark);
			
			}
		}
		@Then("I close connection to Category")
		public void I_close_connection_to_Category() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to Category")
		public void I_establish_connection_to_Category() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
	
		@Given("I read the values from table {string} in Category")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where CategoryCode='CATEGORY'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblCategory":
					String Categorycode = "";
					try {
						Categorycode = rs.getString("CategoryCode");
						System.out.println(Categorycode);
						Assert.assertEquals(Globals.Inventory.Categorycode.trim(), Categorycode.trim());
						 pass.Excelcreate("category", "tblCategory", "", 2, 0, 2, 1);
						pass.ExcelFourData("category", "Categorycode", Globals.Inventory.Categorycode, Categorycode, "Pass", 3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("category", "tblCategory", "", 2, 0, 2, 1);
						pass.ExcelFourData("category", "Categorycode", Globals.Inventory.Categorycode, Categorycode, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					String Categoryname = "";
					try {
						Categoryname = rs.getString("CategoryName");
						System.out.println(Categoryname);
						Assert.assertEquals(Globals.Inventory.Categoryname.trim(), Categoryname.trim());

						pass.ExcelFourData("category", "Categoryname", Globals.Inventory.City, Categoryname, "Pass", 4, 0, 4, 1, 4, 2,
								4, 3);
					} catch (AssertionError e) {

						pass.ExcelFourData("category", "Categoryname", Globals.Inventory.City, Categoryname, "Fail", 4, 0, 4, 1, 4, 2,
								4, 3);

					}

					String Remark = "";
					try {
						Remark = rs.getString("Remarks");
						System.out.println(Remark);
						Assert.assertEquals(Globals.Inventory.Remark.trim(), Remark.trim());

						pass.ExcelFourData("category", "Remark", Globals.Inventory.Remark, Remark, "Pass", 5, 0, 5,
								1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("category", "Remark", Globals.Inventory.Remark, Remark, "Fail", 5, 0, 5,
								1, 5, 2, 5, 3);

					}

					String Discount = "";
					try {
						Discount = rs.getString("RefDeptCode");
						System.out.println(Discount);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount.trim());

						pass.ExcelFourData("category", "Discount", Globals.Inventory.Discount, Discount, "Pass", 6, 0,
								6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("category", "Discount", Globals.Inventory.Discount, Discount, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}
					
	}


			}

	}
	}



