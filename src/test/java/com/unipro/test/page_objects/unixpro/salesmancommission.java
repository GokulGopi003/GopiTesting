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

public class salesmancommission extends PageObject {

	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;

    //WebDriver driver;
	public salesmancommission() {
		
		terPage = new TerminalPage();
		
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
		
	} 
	@Then("I load the SalesManComission sheet data to map")
	public void i_load_the_SalesManComission_sheet_data_to_map() {
		Globals.Inventory.SalesManComissionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME85);
	}

	@Then("I load the SalesManComission rowise  data for {string} rowname")
	public void i_load_the_SalesManComission_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.SalesManCommissionrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.SalesManComissionSheetData, row_name);

		System.out.println(Globals.Inventory.SalesManCommissionrowwiseData);
	}

	@Then("I update value to the SalesManComission page global Variables")
	public void i_update_value_to_the_SalesManComission_page_global_Variables() {
		Globals.Inventory.Department = Globals.Inventory.SalesManCommissionrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.SalesManCommissionrowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.SalesManCommissionrowwiseData.get("Brand");
		//Globals.Inventory.DOB = Globals.Inventory.CustomerNewrowwiseData.get("DOB");
	}

	@Then("I fill new SalesManComission data page using excel data")
	public void i_fill_new_SalesManComission_data_page_using_excel_data() throws Exception {
		try {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlDepartment_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement DepartmentValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlDepartment_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlDepartment_chzn > div > div > input[type=text]";
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
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlBrand_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement BrandValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlBrand_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBrand_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Brand);
			GenericWrappers.sleepInSeconds(1);
			BrandValue.sendKeys(Keys.SPACE);
			BrandValue.sendKeys(Keys.SPACE);
			BrandValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			BrandValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlCategory_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement CategoryValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Category);
			GenericWrappers.sleepInSeconds(1);
			CategoryValue.sendKeys(Keys.SPACE);
			CategoryValue.sendKeys(Keys.SPACE);
			CategoryValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			CategoryValue.sendKeys(Keys.ENTER);

		}
		pass.ExcelFourData("salesmancitemlist","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("salesmancitemlist", "SalesManComission", "Pass", 1, 0, 1, 3);
		}
catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("salesmancitemlist","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("salesmancitemlist", "SalesManComission", "FAIL", 1, 0, 1, 3);
			
		
	}
	}
	@Then("I close connection to SalesManComission")
	public void i_close_connection_to_SalesManComission() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;
	
	@Then("I establish connection to SalesManComission")
	public void i_establish_connection_to_SalesManComission() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in SalesManComission")
	public void i_read_the_values_from_table_in_SalesManComission(String tablename) throws IOException, SQLException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where DepartmentCode='HOME ESSENTIAL 7'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblSalesManCommissionItem":
				
				
				String Department = "";
				try {
					Department = rs.getString("DepartmentCode");
					System.out.println(Department);
					Assert.assertEquals(Globals.Inventory.Department.trim(), Department.trim());
					 pass.Excelcreate("salesmancitemlist", "tblSalesManCommissionItem", "", 2, 0, 2, 1);
					pass.ExcelFourData("salesmancitemlist", "Department", Globals.Inventory.Department, Department, "Pass", 4, 0, 4, 1, 4, 2,
							4, 3);
				} catch (AssertionError e) {
					 pass.Excelcreate("salesmancitemlist", "tblSalesManCommissionItem", "", 2, 0, 2, 1);
					pass.ExcelFourData("salesmancitemlist", "Department", Globals.Inventory.Department, Department, "Fail", 4, 0, 4, 1, 4, 2,
							4, 3);

				}

				String Category = "";
				try {
					Category = rs.getString("CategoryCode");
					System.out.println(Category);
					Assert.assertEquals(Globals.Inventory.Category.trim(), Category.trim());

					pass.ExcelFourData("salesmancitemlist", "Category", Globals.Inventory.Category, Category, "Pass", 5, 0, 5,
							1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("salesmancitemlist", "Category", Globals.Inventory.Category, Category, "Fail", 5, 0, 5,
							1, 5, 2, 5, 3);

				}

				String Brand = "";
				try {
					Brand = rs.getString("BrandCode");
					System.out.println(Brand);
					Assert.assertEquals(Globals.Inventory.Brand.trim(), Brand.trim());

					pass.ExcelFourData("salesmancitemlist", "Brand", Globals.Inventory.Brand, Brand, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("salesmancitemlist", "Brand", Globals.Inventory.Brand, Brand, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
	}

	

		}
	}

}
