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

public class Subcategory {

	AddInventoryFormPage Category;
	Categoryfield icp;
ExcelWrite pass;
	TerminalPage terPage;

	public  Subcategory(Categoryfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
         pass=new ExcelWrite();
		Category = new AddInventoryFormPage();
            
	}

	@Then("I load the Subcategory sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.SubcategorySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME4);
	}
	@Then("I load the rowise Subcategory data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.SubcategoryrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SubcategorySheetData, row_name);

		System.out.println(Globals.Inventory.SubcategorySheetData);

	}

	@Then("I update value to the Subcategory page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Subcategorycode = Globals.Inventory.SubcategoryrowwiseData.get("Subcategorycode");
		Globals.Inventory.Subcategoryname = Globals.Inventory.SubcategoryrowwiseData.get("Subcategoryname");
		Globals.Inventory.Discounts = Globals.Inventory.SubcategoryrowwiseData.get("Discounts");
	
		
	}

	@Then("I fill new Subcategory data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Subcategorycode)) {
			terPage.terminal_waitClearEnterText_css(icp.Subcategorycode_string, Globals.Inventory.Subcategorycode);
			

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Subcategoryname)) {
			terPage.terminal_waitClearEnterText_css(icp.Subcategoryname_String, Globals.Inventory.Subcategoryname);
		
		}
		

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Discounts)) {
			terPage.terminal_waitClearEnterText_css(icp.Discounts_String, Globals.Inventory.Discounts);
			
			
}
	
		
		}
	@Then("I close connection to Subcategory")
	public void i_close_connection_to_Subcategory() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}	

	MssqlConnect mysqlConnect;
	Statement st;
	
	
@Then("I establish connection to Subcategory")
public void i_establish_connection_to_Subcategory() throws SQLException {
	mysqlConnect = new MssqlConnect();
	st = mysqlConnect.connect().createStatement();
	System.out.println(" Connected succesfully");

}

@Then("I read the values from table {string} in Subcategory")
public void i_read_the_values_from_table_in_Subcategory(String tablename) throws IOException, SQLException {

	ResultSet rs = st.executeQuery("select * from " + tablename + " where SubcategoryCode='Gopi'");

	System.out.println(rs);

	while (rs.next()) {

		switch (tablename) {
		case "tblSubCategory":
			String Subcategorycode = "";
			try {
				Subcategorycode = rs.getString("SubcategoryCode");
				System.out.println(Subcategorycode);
				Assert.assertEquals(Globals.Inventory.Subcategorycode.trim(), Subcategorycode.trim());
				 pass.Excelcreate("subcategory", "tblSubCategory", "", 2, 0, 2, 1);
				pass.ExcelFourData("subcategory", "Categorycode", Globals.Inventory.Subcategorycode, Subcategorycode, "Pass", 3, 0,
						3, 1, 3, 2, 3, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("subcategory", "tblSubCategory", "", 2, 0, 2, 1);
				pass.ExcelFourData("subcategory", "Subcategorycode", Globals.Inventory.Subcategorycode, Subcategorycode, "Fail", 3, 0,
						3, 1, 3, 2, 3, 3);

			}
			String Subcategoryname = "";
			try {
				Subcategoryname = rs.getString("SubcategoryName");
				System.out.println(Subcategoryname);
				Assert.assertEquals(Globals.Inventory.Subcategoryname.trim(), Subcategoryname.trim());

				pass.ExcelFourData("subcategory", "Subcategoryname", Globals.Inventory.City, Subcategoryname, "Pass", 4, 0, 4, 1, 4, 2,
						4, 3);
			} catch (AssertionError e) {

				pass.ExcelFourData("subcategory", "Subcategoryname", Globals.Inventory.City, Subcategoryname, "Fail", 4, 0, 4, 1, 4, 2,
						4, 3);

			}

			String Discounts = "";
			try {
				Discounts = rs.getString("DiscountPercent");
				System.out.println(Discounts);
				Assert.assertEquals(Globals.Inventory.Discounts.trim(), Discounts.trim());

				pass.ExcelFourData("subcategory", "Discounts", Globals.Inventory.Discounts, Discounts, "Pass", 5, 0, 5,
						1, 5, 2, 5, 3);

			} catch (AssertionError e) {

				pass.ExcelFourData("subcategory", "Discounts", Globals.Inventory.Discounts, Discounts, "Fail", 5, 0, 5,
						1, 5, 2, 5, 3);

			}
		/*case  "tblCategory":
			String Refcategorycode = "";
			try {
				Refcategorycode = rs.getString("RefCategoryCode");
				System.out.println(Refcategorycode);
				Assert.assertEquals(Globals.Inventory.Refcategorycode.trim(), Refcategorycode.trim());

				pass.ExcelFourData("subcategory", "Refcategorycode", Globals.Inventory.Refcategorycode, Refcategorycode, "Pass", 6, 0,
						6, 1, 6, 2, 6, 3);

			} catch (AssertionError e) {

				pass.ExcelFourData("subcategory", "Refcategorycode", Globals.Inventory.Refcategorycode, Refcategorycode, "Fail", 6, 0,
						6, 1, 6, 2, 6, 3);

			}*/
			
}



	}
}
		
		
	}

	

