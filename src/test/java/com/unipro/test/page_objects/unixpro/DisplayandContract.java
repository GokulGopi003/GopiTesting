package com.unipro.test.page_objects.unixpro;

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
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DisplayandContract extends PageObject {
	DisplayandContractTypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	

	public DisplayandContract(DisplayandContractTypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		
	}

	@Then("I load the DisplayandContractNew sheet data to map")
	public void i_load_the_DisplayandContractNew_sheet_data_to_map() {
		Globals.Inventory.DisplayandContractNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME79);
		
	}

	@Then("I load the DisplayandContractNew rowise  data for {string} rowname")
	public void i_load_the_DisplayandContractNew_rowise_data_for_rowname(String row_name) 
	{
		Globals.Inventory.DisplayandContractNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.DisplayandContractNewSheetData, row_name);

		System.out.println(Globals.Inventory.DisplayandContractNewrowwiseData);
	    
	}

	@Then("I update value to the DisplayandContractNew page global Variables")
	public void i_update_value_to_the_DisplayandContractNew_page_global_Variables() 
	{
		Globals.Inventory.DisplayCode = Globals.Inventory.DisplayandContractNewrowwiseData.get("DisplayCode");
		Globals.Inventory.DisplayName = Globals.Inventory.DisplayandContractNewrowwiseData.get("Displayname");
		Globals.Inventory.Location = Globals.Inventory.DisplayandContractNewrowwiseData.get("Location");
		Globals.Inventory.Department = Globals.Inventory.DisplayandContractNewrowwiseData.get("Department");
		Globals.Inventory.Floor = Globals.Inventory.DisplayandContractNewrowwiseData.get("Floor");
		Globals.Inventory.Shelf = Globals.Inventory.DisplayandContractNewrowwiseData.get("shelf");
		Globals.Inventory.DisplayChargesPerday = Globals.Inventory.DisplayandContractNewrowwiseData.get("Perday");
		Globals.Inventory.DisplayChargesPermonth = Globals.Inventory.DisplayandContractNewrowwiseData.get("permonth");
		Globals.Inventory.PersonInCharge = Globals.Inventory.DisplayandContractNewrowwiseData.get("Personincharge");
		Globals.Inventory.Remarks = Globals.Inventory.DisplayandContractNewrowwiseData.get("Remarks");
		Globals.Inventory.Active = Globals.Inventory.DisplayandContractNewrowwiseData.get("Active");
		
	}

	@Then("I fill new DisplayandContractNew data page using excel data")
	public void i_fill_new_DisplayandContractNew_data_page_using_excel_data()
	{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DisplayCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.DisplayCode_String, Globals.Inventory.DisplayCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DisplayName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.DisplayName_String, Globals.Inventory.DisplayName);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLocation_chzn']")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlLocation_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlLocation_chzn > div > div > input[type=text]";
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment_chzn']")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement DepartmentValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlDepartment_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlDepartment_chzn >div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Department);
			GenericWrappers.sleepInSeconds(1);
			DepartmentValue.sendKeys(Keys.SPACE);
			DepartmentValue.sendKeys(Keys.SPACE);
			DepartmentValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			DepartmentValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floor)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFloor_chzn']")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement FloorValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlFloor_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlFloor_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Floor);
			GenericWrappers.sleepInSeconds(1);
			FloorValue.sendKeys(Keys.SPACE);
			FloorValue.sendKeys(Keys.SPACE);
			FloorValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			FloorValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Shelf)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlShelf_chzn']")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement shelfValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlShelf_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlShelf_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Shelf);
			GenericWrappers.sleepInSeconds(1);
			shelfValue.sendKeys(Keys.SPACE);
			shelfValue.sendKeys(Keys.SPACE);
			shelfValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			shelfValue.sendKeys(Keys.ENTER);

		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.DisplayChargesPerday)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.DisplayChargesPerday_String, Globals.Inventory.DisplayChargesPerday);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DisplayChargesPermonth)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.DisplayChargesPermonth_String, Globals.Inventory.DisplayChargesPermonth);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PersonInCharge)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PersonInCharge_String, Globals.Inventory.PersonInCharge);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Remarks_String, Globals.Inventory.Remarks);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Active)) {
			terPage.get_checkBox_element_Xpath(icp.Active1_String).click();
		}

	}

	@Then("I close connection to DisplayandContractNew")
	public void I_close_connection_to_DisplayandContractNew() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection to DisplayandContractNew")
	public void I_establish_connection_to_DisplayandContractNew() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	
	}

	@Given("I read the values from table {string} in DisplayandContractNew")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where DisplayName='15'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblDisplayandContracts":
				String DisplayCode = "";
				try {
					DisplayCode = rs.getString("DisplayCode");
					System.out.println(DisplayCode);
					Assert.assertEquals(Globals.Inventory.DisplayCode.trim(), DisplayCode.trim());
					pass.Excelcreate("displayandcontract", "tblDisplayandContracts", "", 0, 1, 0, 2);
					pass.ExcelFourData("displayandcontract", "DisplayCode", Globals.Inventory.DisplayCode, DisplayCode, "Pass", 1, 0, 1, 1,
							1, 2, 1, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("displayandcontract", "tblDisplayandContracts", "", 0, 1, 0, 2);
					pass.ExcelFourData("displayandcontract", "DisplayCode", Globals.Inventory.DisplayCode, DisplayCode, "Fail", 1, 0, 1, 1,
							1, 2, 1, 3);

				}

				String DisplayName = "";
				try {
					DisplayName = rs.getString("DisplayName");
					System.out.println(DisplayName);
					Assert.assertEquals(Globals.Inventory.DisplayName.trim(), DisplayName.trim());

					pass.ExcelFourData("displayandcontract", "DisplayName", Globals.Inventory.DisplayName, DisplayName, "Pass", 2, 0,
							2, 1, 2, 2, 2, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "DisplayName", Globals.Inventory.DisplayName, DisplayName, "Fail", 2, 0,
							2, 1, 2, 2, 2, 3);

				}
				String Location = "";
				try {
					Location = rs.getString("LocationCode");
					System.out.println(Location);
					Assert.assertEquals(Globals.Inventory.Location.trim(), Location.trim());
					
					pass.ExcelFourData("displayandcontract", "Location", Globals.Inventory.Location, Location, "Pass", 3, 0,
							3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					
					pass.ExcelFourData("displayandcontract", "Location", Globals.Inventory.Location, Location, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}
				String Department = "";
				try {
					Department = rs.getString("Departmentcode");
					System.out.println(Department);
					Assert.assertEquals(Globals.Inventory.Department.trim(), Department.trim());

					pass.ExcelFourData("displayandcontract", "Department", Globals.Inventory.Department, Department, "Pass", 4, 0, 4, 1, 4, 2,
							4, 3);
				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "Department", Globals.Inventory.Department, Department, "Fail", 4, 0, 4, 1, 4, 2,
							4, 3);

				}

				String Floor = "";
				try {
					Floor = rs.getString("Floor");
					System.out.println(Floor);
					Assert.assertEquals(Globals.Inventory.Floor.trim(), Floor.trim());

					pass.ExcelFourData("displayandcontract", "Floor", Globals.Inventory.Floor, Floor, "Pass", 5, 0, 5,
							1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "Floor", Globals.Inventory.Floor, Floor, "Fail", 5, 0, 5,
							1, 5, 2, 5, 3);

				}

				String Shelf = "";
				try {
					Shelf = rs.getString("Shelf");
					System.out.println(Shelf);
					Assert.assertEquals(Globals.Inventory.Shelf.trim(), Shelf.trim());

					pass.ExcelFourData("displayandcontract", "Shelf", Globals.Inventory.Shelf, Shelf, "Pass", 8, 0,
							8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "Shelf", Globals.Inventory.Shelf, Shelf, "Fail", 8, 0,
							8, 1, 8, 2, 8, 3);

				}
				String DisplayChargesPerday = "";
				try {
					DisplayChargesPerday = rs.getString("DisplayChargesPerDay");
					System.out.println(DisplayChargesPerday);
					Assert.assertEquals(Globals.Inventory.DisplayChargesPerday.trim(), DisplayChargesPerday.trim());

					pass.ExcelFourData("displayandcontract", "DisplayChargesPerday", Globals.Inventory.DisplayChargesPerday, DisplayChargesPerday, "Pass", 9, 0, 9, 1, 9,
							2, 9, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "DisplayChargesPerday", Globals.Inventory.DisplayChargesPerday, DisplayChargesPerday, "Fail", 9, 0, 9, 1, 9,
							2, 9, 3);

				}
				String DisplayChargesPermonth = "";
				try {
					DisplayChargesPermonth = rs.getString("DisplayChargesPerMonth");
					System.out.println(DisplayChargesPermonth);
					Assert.assertEquals(Globals.Inventory.DisplayChargesPermonth.trim(), DisplayChargesPermonth.trim());

					pass.ExcelFourData("displayandcontract", "DisplayChargesPermonth", Globals.Inventory.DisplayChargesPermonth, DisplayChargesPermonth, "Pass", 10, 0, 10,
							1, 10, 2, 10, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "DisplayChargesPermonth", Globals.Inventory.DisplayChargesPermonth, DisplayChargesPermonth, "Fail", 10, 0, 10,
							1, 10, 2, 10, 3);

				}
				String PersonInCharge = "";
				try {
					PersonInCharge = rs.getString("PersonInCharge");
					System.out.println(PersonInCharge);
					Assert.assertEquals(Globals.Inventory.PersonInCharge.trim(), PersonInCharge.trim());

					pass.ExcelFourData("displayandcontract", "PersonInCharge", Globals.Inventory.Country, PersonInCharge, "Pass", 11, 0, 11,
							1, 11, 2, 11, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "PersonInCharge", Globals.Inventory.Country, PersonInCharge, "Fail", 11, 0, 11,
							1, 11, 2, 11, 3);

				}
				String Remarks = "";
				try {
					Remarks = rs.getString("Remarks");
					System.out.println(Remarks);
					Assert.assertEquals(Globals.Inventory.Remarks.trim(), Remarks.trim());

					pass.ExcelFourData("displayandcontract", "Remarks", Globals.Inventory.Remarks, Remarks, "pass", 12, 0, 12, 1,
							12, 2, 12, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "Remarks", Globals.Inventory.Remarks, Remarks, "Fail", 12, 0, 12, 1,
							12, 2, 12, 3);

				}
				String Active = "";
				try {
					Active = rs.getString("Active");
					System.out.println(Active);
					Assert.assertEquals(Globals.Inventory.Active.trim(), Active.trim());

					pass.ExcelFourData("displayandcontract", "Active", Globals.Inventory.Active, Remarks, "pass", 13, 0, 13, 1,
							13, 2, 13, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("displayandcontract", "Active", Globals.Inventory.Active, Active, "Fail", 13, 0, 13, 1,
							13, 2, 13, 3);

				}
				

}
}
	}
}