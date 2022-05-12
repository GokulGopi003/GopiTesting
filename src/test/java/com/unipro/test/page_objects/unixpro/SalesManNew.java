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
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class SalesManNew extends PageObject {
	Salesmantypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	

	public SalesManNew(Salesmantypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();

}
	@Then("I load the SalesManNew sheet data to map")
	public void i_load_the_SalesManNew_sheet_data_to_map() {
		Globals.Inventory.SalesManNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME81);
	}

	@Then("I load the SalesManNew rowise  data for {string} rowname")
	public void i_load_the_SalesManNew_rowise_data_for_rowname(String row_name) 
	{
		Globals.Inventory.SalesManNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SalesManNewSheetData, row_name);

		System.out.println(Globals.Inventory.SalesManNewrowwiseData);
	}

	@Then("I update value to the SalesManNew page global Variables")
	public void i_update_value_to_the_SalesManNew_page_global_Variables()
	{

		Globals.Inventory.SalesManID = Globals.Inventory.SalesManNewrowwiseData.get("Salesmanid");
		Globals.Inventory.EmployeeCode = Globals.Inventory.SalesManNewrowwiseData.get("Employeecode");
		Globals.Inventory.SalesManName = Globals.Inventory.SalesManNewrowwiseData.get("Salesmanname");
		Globals.Inventory.Commission = Globals.Inventory.SalesManNewrowwiseData.get("commission");
		Globals.Inventory.Location = Globals.Inventory.SalesManNewrowwiseData.get("Location");
		Globals.Inventory.Active = Globals.Inventory.SalesManNewrowwiseData.get("Active");

	}

	@Then("I fill new SalesManNew data page using excel data")
	public void i_fill_new_SalesManNew_data_page_using_excel_data() throws Exception 
	{
		try
		{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesManID)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ID_String, Globals.Inventory.SalesManID);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.EmployeeCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.EmployeeCode_String, Globals.Inventory.EmployeeCode);
			//webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtReasonDescription']"))
			//.sendKeys(Keys.RETURN);
			
		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesManName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.SalesmanName_String, Globals.Inventory.SalesManName);

		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Commission)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Commission_String, Globals.Inventory.Commission);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLocation_chzn']")).click();
	
			
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Active)) {
			terPage.get_checkBox_element_Xpath(icp.Active_String).click();
		}

		pass.ExcelFourData("salesmannew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("salesmannew", "SalesManMaster", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("salesmannew","SalesManMaster", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("salesmannew", "SalesManMaster", "FAIL", 1, 0, 1, 3);
			
		}
		
		
	}
	@Then("I close connection to SalesManNew")
	public void i_close_connection_to_SalesManNew() 
	{
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;
	
	    
	

	@Then("I establish connection to SalesManNew")
	public void i_establish_connection_to_SalesManNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in SalesManNew")
	public void i_read_the_values_from_table_in_SalesManNew(String tablename) throws SQLException, IOException
	{
		
			ResultSet rs = st.executeQuery("select * from " + tablename + " where SalesManID='5'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblSalesMan":
					String SalesManID = "";
					try {
						SalesManID = rs.getString("SalesManID");
						System.out.println(SalesManID);
						Assert.assertEquals(Globals.Inventory.SalesManID.trim(), SalesManID.trim());
						pass.Excelcreate("salesmannew", "tblSalesMan", "", 3, 1, 3, 2);
						pass.ExcelFourData("salesmannew", "SalesManID", Globals.Inventory.SalesManID, SalesManID, "Pass", 4, 0, 4, 1,
								4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("salesmannew", "tblSalesMan", "", 3, 1, 3, 2);
						pass.ExcelFourData("salesmannew", "SalesManID", Globals.Inventory.SalesManID, SalesManID, "Fail", 4, 0, 4, 1,
								4, 2, 4, 3);

					}

					String EmployeeCode = "";
					try {
						EmployeeCode = rs.getString("SalesManCode");
						System.out.println(EmployeeCode);
						Assert.assertEquals(Globals.Inventory.EmployeeCode.trim(), EmployeeCode.trim());

						pass.ExcelFourData("salesmannew", "EmployeeCode", Globals.Inventory.EmployeeCode, EmployeeCode, "Pass", 5, 0,
								5, 1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("salesmannew", "EmployeeCode", Globals.Inventory.EmployeeCode, EmployeeCode, "Fail", 5, 0,
								5, 1, 5, 2, 5, 3);

					}

					String SalesManName = "";
					try {
						SalesManName = rs.getString("SalesManName");
						System.out.println(SalesManName);
						Assert.assertEquals(Globals.Inventory.SalesManName.trim(), SalesManName.trim());

						pass.ExcelFourData("salesmannew", "SalesManName", Globals.Inventory.SalesManName, SalesManName, "Pass", 6,
								0, 6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("salesmannew", "SalesManName", Globals.Inventory.SalesManName, SalesManName, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}
					String Commission = "";
					try {
						Commission = rs.getString("Commission");
						System.out.println(Commission);
						Assert.assertEquals(Globals.Inventory.Commission.trim(), Commission.trim());

						pass.ExcelFourData("salesmannew", "Commission", Globals.Inventory.Commission, Commission, "Pass", 7,
								0, 7, 1, 7, 2, 7, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("salesmannew", "Commission", Globals.Inventory.Commission, Commission, "Fail", 7, 0,
								7, 1, 7, 2, 7, 3);

					}
					String Location = "";
					try {
						Location = rs.getString("Location");
						System.out.println(Location);
						Assert.assertEquals(Globals.Inventory.Location.trim(), Location.trim());

						pass.ExcelFourData("salesmannew", "Location", Globals.Inventory.Location, Location, "Pass", 8,
								0, 8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("salesmannew", "Location", Globals.Inventory.Location, Location, "Fail", 8, 0,
								8, 1, 8, 2, 8, 3);

					}
					String Active = "";
					try {
						Active = rs.getString("IsActive");
						System.out.println(Active);
						Assert.assertEquals(Globals.Inventory.Active.trim(), Active.trim());

						pass.ExcelFourData("salesmannew", "Active", Globals.Inventory.Active, Active, "Pass", 9,
								0, 9, 1, 9, 2, 9, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("salesmannew", "Active", Globals.Inventory.Active, Active, "Fail", 9, 0,
								9, 1, 9, 2, 9, 3);

					}
				}
			}
		}
	
		
	}

	


