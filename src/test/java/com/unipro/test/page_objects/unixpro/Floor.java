package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class Floor extends PageObject{
	AddInventoryFormPage Category;
	Floorfield icp;
    ExcelWrite pass;
	TerminalPage terPage;
    
	public  Floor(Floorfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
        pass=new ExcelWrite();
		Category = new AddInventoryFormPage();
	}
	
	@Then("I load the Floor sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.FloorSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME7);
	}
	@Then("I load the rowise Floor data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.FloorrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.FloorSheetData, row_name);

		System.out.println(Globals.Inventory.FloorSheetData);

	}

	@Then("I update value to the Floor page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Floorcode = Globals.Inventory.FloorrowwiseData.get("Floorcode");
		Globals.Inventory.Description = Globals.Inventory.FloorrowwiseData.get("Description");
		Globals.Inventory.Location = Globals.Inventory.FloorrowwiseData.get("LocationCode");
		
	
		
	}

	@Then("I fill new Floor data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlLocation_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlLocation_chzn div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlLocation_chzn div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Location);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.ENTER);

		}

		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
		
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
			terPage.terminal_waitClearEnterText_css(icp.Floorcode_string, Globals.Inventory.Floorcode);
			

		}
		
		
		
		
}
	@Then("I close connection to Floor")
	public void i_close_connection_to_Floor() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;
	
	@Then("I establish connection to Floor")
	public void i_establish_connection_to_Floor() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}
	@Then("I read the values from table {string} in Floor")
	public void i_read_the_values_from_table_in_Floor(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where FloorCode='PKS'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblFloor":
				String Floorcode = "";
				try {
					Floorcode = rs.getString("FloorCode");
					System.out.println(Floorcode);
					Assert.assertEquals(Globals.Inventory.Floorcode.trim(), Floorcode.trim());
					 pass.Excelcreate("floor", "tblFloor", "", 2, 0, 2, 1);
					pass.ExcelFourData("floor", "Floorcode", Globals.Inventory.Floorcode, Floorcode, "Pass", 3, 0,
							3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					 pass.Excelcreate("floor", "tblFloor", "", 2, 0, 2, 1);
					pass.ExcelFourData("floor", "Floorcode", Globals.Inventory.Floorcode, Floorcode, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}
				

				String Description = "";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

					pass.ExcelFourData("floor", "Description", Globals.Inventory.Description, Description, "Pass", 4, 0, 4,
							1, 4, 2, 4, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("floor", "Description", Globals.Inventory.Description, Description, "Fail", 4, 0, 4,
							1, 4, 2, 4, 3);

				}

				String LocationCode = "";
				try {
					LocationCode = rs.getString("LocationCode");
					System.out.println(LocationCode);
					Assert.assertEquals(Globals.Inventory.Location.trim(), LocationCode.trim());

					pass.ExcelFourData("floor", "LocationCode", Globals.Inventory.Location, LocationCode, "Pass", 5, 0, 5,
							1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("floor", "LocationCode", Globals.Inventory.Location, LocationCode, "Fail", 5, 0, 5,
							1, 5, 2, 5, 3);

				}

			}

		}
}
}