package com.unipro.test.page_objects.unixpro;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
	import java.io.IOException;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.openqa.selenium.By;
	    import org.openqa.selenium.Keys;
	    import org.openqa.selenium.WebElement;
	import org.testng.Assert;

	import com.gk.test.MssqlConnect;
	import com.unipro.ExcelWrite;


public class Origion extends PageObject {
	AddInventoryFormPage Category;
	Origionfield icp;
	TerminalPage terPage;
     ExcelWrite pass;
	public Origion(Origionfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
	}

	@Then("I load the Origion sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.OrigionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME40);
	}

	@Then("I load the rowise Origion data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.OrigionrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.OrigionSheetData, row_name);

		System.out.println(Globals.Inventory.OrigionSheetData);

	}

	@Then("I update value to the Origion page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.OrigionCode = Globals.Inventory.OrigionrowwiseData.get("OrigionCode");
		Globals.Inventory.Description = Globals.Inventory.OrigionrowwiseData.get("Description");

	}

	@Then("I fill new Origion data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.OrigionCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.OrigionCode_String, Globals.Inventory.OrigionCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Description_String, Globals.Inventory.Description);

		}
		

	}	@Then("I close connection to Origion")
	public void I_close_connection_to_Origion() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}

	MssqlConnect mysqlConnect;
	Statement st;


	@Then("I establish connection to Origion")
	public void I_establish_connection_to_Origion() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");


	}	

	@Given("I read the values from table {string} in Origion")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {
		
		
		ResultSet rs = st.executeQuery("select * from "+tablename+" where OriginCode='1'");
		
		System.out.println(rs);
		//ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			switch (tablename) {
			case "tblOrigin":
			System.out.println("1");
			String OrigionCode="";
			try {
				System.out.println("2");
				OrigionCode = rs.getString("OriginCode");
				System.out.println("3");
				System.out.println(OrigionCode);
				Assert.assertEquals(Globals.Inventory.OrigionCode.trim(), OrigionCode.trim());
				pass.Excelcreate("origin", "tblManufacturer", "",1, 0, 1, 1);
				pass.ExcelFourData("origin", "OrigionCode", Globals.Inventory.OrigionCode, OrigionCode, "Pass",
						2, 0, 2, 1, 2, 2, 2, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("origin", "tblManufacturer", "", 1, 0, 1, 1);
				pass.ExcelFourData("origin", "OrigionCode",  Globals.Inventory.OrigionCode, OrigionCode, "Fail",
						2, 0, 2, 1, 2, 2, 2, 3);

			}
			
			String Description="";
			try {
				Description = rs.getString("Description");
				System.out.println(Description);
				Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());
				
				pass.ExcelFourData("origin", "Description", Globals.Inventory.Description, Description,
						"Pass", 3, 0, 3, 1, 3, 2, 3, 3);

			} catch (AssertionError e) {
				
				pass.ExcelFourData("origin", "Description", Globals.Inventory.Description, Description,
						"Fail", 3, 0, 3, 1, 3, 2, 3, 3);

			}

}
		}
	}
}






