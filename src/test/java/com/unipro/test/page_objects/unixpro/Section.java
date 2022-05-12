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

	public class Section {
		AddInventoryFormPage Category;
		SectionField icp;
       ExcelWrite pass;
		TerminalPage terPage;

		public  Section(SectionField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Section sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.SectionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME15);
		}
		@Then("I load the rowise Section data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.SectionrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.SectionSheetData, row_name);

			System.out.println(Globals.Inventory.SectionSheetData);

		}

		@Then("I update value to the Section page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Description = Globals.Inventory.SectionrowwiseData.get("Description");
			Globals.Inventory.Section = Globals.Inventory.SectionrowwiseData.get("Section");
			
		
			
		}

		@Then("I fill new Section data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terPage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
		
			
		
	}
		@Then("I close connection to Section")
		public void I_close_connection_to_Section() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();
		}

		MssqlConnect mysqlConnect;
		Statement st;


		@Then("I establish connection to Section")
		public void I_establish_connection_to_Section() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");


		}	

		@Given("I read the values from table {string} in Section")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where Section='1'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				case "tblSection":
				System.out.println("1");
				String Section="";
				try {
					System.out.println("2");
					Section = rs.getString("Section");
					System.out.println("3");
					System.out.println(Section);
					Assert.assertEquals(Globals.Inventory.Section.trim(), Section.trim());
					pass.Excelcreate("section", "tblSection", "",3, 0, 3, 1);
					pass.ExcelFourData("section", "Section", Globals.Inventory.Section, Section, "Pass",
							4, 0, 4, 1, 4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("section", "tblSection", "", 3, 0, 3, 1);
					pass.ExcelFourData("section", "Section",  Globals.Inventory.Section, Section, "Fail",
							4, 0, 4, 1, 4, 2, 4, 3);

				}
				
				String Description="";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());
					//pass.Excelcreate("Bin", "tblBin", "", 5, 0, 5, 1);
					pass.ExcelFourData("section", "Description", Globals.Inventory.Description, Description,
							"Pass", 5, 0, 5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {
					//pass.Excelcreate("Bin", "tblBin", "", 5, 0, 5, 1);
					pass.ExcelFourData("section", "Description", Globals.Inventory.Description, Description,
							"Fail", 5, 0, 5, 1, 5, 2, 5, 3);

				}
				
				break;
				
				default:
					break;
				}
		
	
}


		}
		
	}


	




