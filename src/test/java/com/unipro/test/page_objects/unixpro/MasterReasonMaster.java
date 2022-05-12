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

public class MasterReasonMaster extends PageObject {
	ReasonMasterTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	

	public MasterReasonMaster(ReasonMasterTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		
	}
	@Then("I load the ReasonMasterNew sheet data to map")
	public void i_load_the_ReasonMasterNew_sheet_data_to_map() 
	{
		Globals.Inventory.ReasonMasterNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME75);
		System.out.println("0");
	}

	@Then("I load the ReasonMasterNew rowise  data for {string} rowname")
	public void i_load_the_ReasonMasterNew_rowise_data_for_rowname(String row_name) 
	{
		
		Globals.Inventory.ReasonMasterNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.ReasonMasterNewSheetData, row_name);

		System.out.println(Globals.Inventory.ReasonMasterNewrowwiseData);
		

	}
	

	@Then("I update value to the ReasonMasterNew page global Variables")
	public void i_update_value_to_the_ReasonMasterNew_page_global_Variables() 
	{
		
		Globals.Inventory.ReasonCode = Globals.Inventory.ReasonMasterNewrowwiseData.get("ReasonCode");
		Globals.Inventory.ReasonDescription = Globals.Inventory.ReasonMasterNewrowwiseData.get("ReasonDescription");
		Globals.Inventory.TransactionType = Globals.Inventory.ReasonMasterNewrowwiseData.get("TransactionType");
		Globals.Inventory.AdditionOrDeduction = Globals.Inventory.ReasonMasterNewrowwiseData.get("AdditionOrDeduction");
	}

	@Then("I fill new ReasonMasterNew data page using excel data")
	public void i_fill_new_ReasonMasterNew_data_page_using_excel_data() 
	{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ReasonCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ReasonCode_String, Globals.Inventory.ReasonCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ReasonDescription)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ReasonDescription_String, Globals.Inventory.ReasonDescription);
			//webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtReasonDescription']"))
			//.sendKeys(Keys.RETURN);
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.TransactionType)) {
			//GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlTranType_chzn")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement TransactionValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlTranType_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlTranType_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.TransactionType);
			GenericWrappers.sleepInSeconds(1);
			TransactionValue.sendKeys(Keys.SPACE);
			TransactionValue.sendKeys(Keys.SPACE);
			TransactionValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			TransactionValue.sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AdditionOrDeduction)) {
			//GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddladditiondeduction_chzn']")).click();
			//GenericWrappers.sleepInSeconds(1);
            WebElement AddDedValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddladditiondeduction_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddladditiondeduction_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.AdditionOrDeduction);
			GenericWrappers.sleepInSeconds(1);
			AddDedValue.sendKeys(Keys.SPACE);
			AddDedValue.sendKeys(Keys.SPACE);
			AddDedValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			AddDedValue.sendKeys(Keys.ENTER);
		}
	}

	@Then("I close connection to ReasonMasterNew")
	public void I_close_connection_to_ReasonMasterNew() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection to ReasonMasterNew")
	public void I_establish_connection_to_ReasonMasterNew() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Given("I read the values from table {string} in ReasonMasterNew")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where ReasonDescription='8'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblReasonMaster":
				String ReasonCode = "";
				try {
					ReasonCode = rs.getString("ReasonCode");
					System.out.println(ReasonCode);
					Assert.assertEquals(Globals.Inventory.ReasonCode.trim(), ReasonCode.trim());
					pass.Excelcreate("Reasonmasternew", "tblReasonMaster", "", 0, 1, 0, 2);
					pass.ExcelFourData("Reasonmasternew", "ReasonCode", Globals.Inventory.ReasonCode, ReasonCode, "Pass", 1, 0, 1, 1,
							1, 2, 1, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Reasonmasternew", "tblReasonMaster", "", 0, 1, 0, 2);
					pass.ExcelFourData("Reasonmasternew", "ReasonCode", Globals.Inventory.ReasonCode, ReasonCode, "Fail", 1, 0, 1, 1,
							1, 2, 1, 3);

				}

				String ReasonDescription = "";
				try {
					ReasonDescription = rs.getString("ReasonDescription");
					System.out.println(ReasonDescription);
					Assert.assertEquals(Globals.Inventory.ReasonDescription.trim(), ReasonDescription.trim());

					pass.ExcelFourData("Reasonmasternew", "ReasonDescription", Globals.Inventory.ReasonDescription, ReasonDescription, "Pass", 2, 0,
							2, 1, 2, 2, 2, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("Reasonmasternew", "ReasonDescription", Globals.Inventory.ReasonDescription, ReasonDescription, "Fail", 2, 0,
							2, 1, 2, 2, 2, 3);

				}
				String TransactionType = "";
				try {
					TransactionType = rs.getString("TransactionType");
					System.out.println(TransactionType);
					Assert.assertEquals(Globals.Inventory.TransactionType.trim(), TransactionType.trim());
					
					pass.ExcelFourData("Reasonmasternew", "TransactionType", Globals.Inventory.TransactionType, TransactionType, "Pass", 3, 0,
							3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					
					pass.ExcelFourData("Reasonmasternew", "TransactionType", Globals.Inventory.TransactionType, TransactionType, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}
				String AdditionOrDeduction = "";
				try {
					AdditionOrDeduction = rs.getString("AdditionOrDeduction");
					System.out.println(AdditionOrDeduction);
					Assert.assertEquals(Globals.Inventory.AdditionOrDeduction.trim(), AdditionOrDeduction.trim());

					pass.ExcelFourData("Reasonmasternew", "AdditionOrDeduction", Globals.Inventory.AdditionOrDeduction, AdditionOrDeduction, "Pass", 4, 0, 4, 1, 4, 2,
							4, 3);
				} catch (AssertionError e) {

					pass.ExcelFourData("Reasonmasternew", "AdditionOrDeduction", Globals.Inventory.AdditionOrDeduction, AdditionOrDeduction, "Fail", 4, 0, 4, 1, 4, 2,
							4, 3);

				}

}

		}
	}
}

