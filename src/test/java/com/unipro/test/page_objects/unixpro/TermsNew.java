package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TermsNew extends PageObject {
	TermsNewTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	

	public TermsNew(TermsNewTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		
	}
	@Then("I load the TermsNew sheet data to map")
	public void i_load_the_TermsNew_sheet_data_to_map() 
	{
		Globals.Inventory.TermsNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME78);
		
	}

	@Then("I load the TermsNew rowise  data for {string} rowname")
	public void i_load_the_TermsNew_rowise_data_for_rowname(String row_name) 
	{
		
		Globals.Inventory.TermsNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.TermsNewSheetData, row_name);

		System.out.println(Globals.Inventory.TermsNewrowwiseData);
		

	}
	

	@Then("I update value to the TermsNew page global Variables")
	public void i_update_value_to_the_TermsNew_page_global_Variables() 
	{
		
		Globals.Inventory.TermsCode = Globals.Inventory.TermsNewrowwiseData.get("Termscode");
		Globals.Inventory.Description = Globals.Inventory.TermsNewrowwiseData.get("Description");
		Globals.Inventory.Value = Globals.Inventory.TermsNewrowwiseData.get("Value");
		
	}

	@Then("I fill new TermsNew data page using excel data")
	public void i_fill_new_TermsNew_data_page_using_excel_data() 
	{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.TermsCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.TermsCode_String, Globals.Inventory.TermsCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Description_String, Globals.Inventory.Description);
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtDescription']"))
			.sendKeys(Keys.RETURN);
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Value)) {
			terPage.get_checkBox_element_Xpath(icp.Active_String).click();
		}
	}
	@Then("I close connection to TermsNew")
	public void I_close_connection_to_TermsNew() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection to TermsNew")
	public void I_establish_connection_to_TermsNew() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Given("I read the values from table {string} in TermsNew")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where Description='10'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblTerms":
				String TermsCode = "";
				try {
					TermsCode = rs.getString("TermsCode");
					System.out.println(TermsCode);
					Assert.assertEquals(Globals.Inventory.TermsCode.trim(), TermsCode.trim());
					pass.Excelcreate("termsnew", "tblTerms", "", 0, 1, 0, 2);
					pass.ExcelFourData("termsnew", "TermsCode", Globals.Inventory.TermsCode, TermsCode, "Pass", 1, 0, 1, 1,
							1, 2, 1, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("termsnew", "tblTerms", "", 0, 1, 0, 2);
					pass.ExcelFourData("termsnew", "TermsCode", Globals.Inventory.TermsCode, TermsCode, "Fail", 1, 0, 1, 1,
							1, 2, 1, 3);

				}

				String Description = "";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

					pass.ExcelFourData("termsnew", "Description", Globals.Inventory.Description, Description, "Pass", 2, 0,
							2, 1, 2, 2, 2, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("termsnew", "Description", Globals.Inventory.Description, Description, "Fail", 2, 0,
							2, 1, 2, 2, 2, 3);

				}
				String Value = "";
				try {
					Value = rs.getString("Active");
					System.out.println(Value);
					Assert.assertEquals(Globals.Inventory.Value.trim(), Value.trim());

					pass.ExcelFourData("termsnew", "Value", Globals.Inventory.Value, Value, "Pass", 3, 0,
							3, 1, 3, 2, 3, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("termsnew", "Value", Globals.Inventory.Value, Value, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}

}

		}
	}
}


