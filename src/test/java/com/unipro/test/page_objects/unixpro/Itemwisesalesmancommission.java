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
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class Itemwisesalesmancommission extends PageObject {
	ItemWisesalesmantypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	
WebDriver driver;
	public Itemwisesalesmancommission(ItemWisesalesmantypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
		
	} 
	@Then("I load the ItemWiseSalesManCommission sheet data to map")
	public void i_load_the_ItemWiseSalesManCommission_sheet_data_to_map() {
		Globals.Inventory.ItemWiseSalesManCommissionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME84);
	}

	@Then("I load the ItemWiseSalesManCommission rowise  data for {string} rowname")
	public void i_load_the_ItemWiseSalesManCommission_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.ItemWiseSalesManCommissionrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.ItemWiseSalesManCommissionSheetData, row_name);

		System.out.println(Globals.Inventory.ItemWiseSalesManCommissionrowwiseData);
	}

	@Then("I update value to the ItemWiseSalesManCommission page global Variables")
	public void i_update_value_to_the_ItemWiseSalesManCommission_page_global_Variables() {
		Globals.Inventory.Department = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("Department");
		
		Globals.Inventory.Brand = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("Brand");
		Globals.Inventory.Category = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("Category");
		Globals.Inventory.ItemCode = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("ItemCode");
		Globals.Inventory.Description = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("Description");
       
		Globals.Inventory.Cost = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("Cost");
		Globals.Inventory.Price = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("Price");
		Globals.Inventory.Commission = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("Commission");
		Globals.Inventory.Date = Globals.Inventory.ItemWiseSalesManCommissionrowwiseData.get("Date");
		
	}

	@Then("I fill new ItemWiseSalesManCommission data page using excel data")
	public void i_fill_new_ItemWiseSalesManCommission_data_page_using_excel_data() {
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
	}
	@Then("I fill Add the Item")
	public void i_fill_Add_the_Item() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ItemCode_String, Globals.Inventory.ItemCode);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtInventoryCode\"]"))
			.sendKeys(Keys.ENTER);
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Date_String, Globals.Inventory.Date);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtvValidFrom\"]"))
					.sendKeys(Keys.RETURN);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Valid_String, Globals.Inventory.Date);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtvValidTo\"]"))
					.sendKeys(Keys.RETURN);

		}
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Commission)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Commission_String, Globals.Inventory.Commission);

		}
		pass.ExcelFourData("salesmancommissionitem","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("salesmancommissionitem", "ItemWiseSalesManCommission", "Pass", 1, 0, 1, 3);
		}
catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("salesmancommissionitem","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("salesmancommissionitem", "ItemWiseSalesManCommission", "FAIL", 1, 0, 1, 3);
			
		
	}
	}
	
	@Then("I close connection to ItemWiseSalesManCommission")
	public void i_close_connection_to_ItemWiseSalesManCommission() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;
	
	@Then("I establish connection to ItemWiseSalesManCommission")
	public void i_establish_connection_to_ItemWiseSalesManCommission() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Then("I read the values from table {string} in ItemWiseSalesManCommission")
	public void i_read_the_values_from_table_in_ItemWiseSalesManCommission(String tablename) throws IOException, SQLException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where Commission='5'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblSalesManCommissionItem":
				
				String ItemCode = "";
				try {
					ItemCode = rs.getString("InventoryCode");
					System.out.println(ItemCode);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode.trim());
					 pass.Excelcreate("salesmancommissionitem", "tblSalesManCommissionItem", "", 2, 0, 2, 1);
					pass.ExcelFourData("salesmancommissionitem", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Pass", 3, 0,
							3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					 pass.Excelcreate("salesmancommissionitem", "tblSalesManCommissionItem", "", 2, 0, 2, 1);
					pass.ExcelFourData("salesmancommissionitem", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}
				String Department = "";
				try {
					Department = rs.getString("DepartmentCode");
					System.out.println(Department);
					Assert.assertEquals(Globals.Inventory.Department.trim(), Department.trim());

					pass.ExcelFourData("salesmancommissionitem", "Department", Globals.Inventory.Department, Department, "Pass", 4, 0, 4, 1, 4, 2,
							4, 3);
				} catch (AssertionError e) {

					pass.ExcelFourData("salesmancommissionitem", "Department", Globals.Inventory.Department, Department, "Fail", 4, 0, 4, 1, 4, 2,
							4, 3);

				}

				String Category = "";
				try {
					Category = rs.getString("CategoryCode");
					System.out.println(Category);
					Assert.assertEquals(Globals.Inventory.Category.trim(), Category.trim());

					pass.ExcelFourData("salesmancommissionitem", "Category", Globals.Inventory.Category, Category, "Pass", 5, 0, 5,
							1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("salesmancommissionitem", "Category", Globals.Inventory.Category, Category, "Fail", 5, 0, 5,
							1, 5, 2, 5, 3);

				}

				String Brand = "";
				try {
					Brand = rs.getString("BrandCode");
					System.out.println(Brand);
					Assert.assertEquals(Globals.Inventory.Brand.trim(), Brand.trim());

					pass.ExcelFourData("salesmancommissionitem", "Brand", Globals.Inventory.Brand, Brand, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("salesmancommissionitem", "Brand", Globals.Inventory.Brand, Brand, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
				String Commission = "";
				try {
					Commission = rs.getString("Commission");
					System.out.println(Commission);
					Assert.assertEquals(Globals.Inventory.Commission.trim(), Commission.trim());

					pass.ExcelFourData("salesmancommissionitem", "Commission", Globals.Inventory.Commission, Commission, "Pass", 7, 0, 7, 1, 7,
							2, 7, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("salesmancommissionitem", "Commission", Globals.Inventory.Commission, Commission, "Fail", 7, 0, 7, 1, 7,
							2, 7, 3);

				}
				
	}

	

		}
	}
}
