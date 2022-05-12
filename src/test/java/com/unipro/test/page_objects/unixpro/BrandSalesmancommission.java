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

public class BrandSalesmancommission extends PageObject {
	BrandSalesManCommisionTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	

	public BrandSalesmancommission(BrandSalesManCommisionTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	}


	@Then("I load the BrandWiseSalesManCommission sheet data to map")
	public void i_load_the_BrandWiseSalesManCommission_sheet_data_to_map() {
		Globals.Inventory.BrandWiseSalesManCommissionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME83);
	}

	@Then("I load the BrandWiseSalesManCommission rowise  data for {string} rowname")
	public void i_load_the_BrandWiseSalesManCommission_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.BrandWiseSalesManCommissionrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.BrandWiseSalesManCommissionSheetData, row_name);

		System.out.println(Globals.Inventory.BrandWiseSalesManCommissionrowwiseData);
	}

	@Then("I update value to the BrandWiseSalesManCommission page global Variables")
	public void i_update_value_to_the_BrandWiseSalesManCommission_page_global_Variables() {
		Globals.Inventory.Brandcode = Globals.Inventory.BrandWiseSalesManCommissionrowwiseData.get("Brandcode");
		Globals.Inventory.Brand = Globals.Inventory.BrandWiseSalesManCommissionrowwiseData.get("Name");
		Globals.Inventory.Commission = Globals.Inventory.BrandWiseSalesManCommissionrowwiseData.get("commission");
		
	}

	@Then("I fill new BrandWiseSalesManCommission data page using excel data")
	public void i_fill_new_BrandWiseSalesManCommission_data_page_using_excel_data() throws Exception {
		try
		{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brandcode)) {
			
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlBrandCode_chzn']")).click();
			
			
			WebElement BrandCodeValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlBrandCode_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBrandCode_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Brandcode);
			GenericWrappers.sleepInSeconds(1);
			BrandCodeValue.sendKeys(Keys.SPACE);
			BrandCodeValue.sendKeys(Keys.SPACE);
			BrandCodeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			BrandCodeValue.sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.BrandName_String, Globals.Inventory.Brand);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Commission)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Commission_String, Globals.Inventory.Commission);
			
			
		}
		pass.ExcelFourData("brandwisesalesmancommission","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("brandwisesalesmancommission", "SalesManCommissionBrand", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("brandwisesalesmancommission","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("brandwisesalesmancommission", "SalesManCommissionBrand", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to BrandWiseSalesManCommission")
	public void i_close_connection_to_BrandWiseSalesManCommission() {
		
			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");
		}
	
		MssqlConnect mysqlConnect;
		Statement st; 
	

	@Then("I establish connection to BrandWiseSalesManCommission")
	public void i_establish_connection_to_BrandWiseSalesManCommission() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in BrandWiseSalesManCommission")
	public void i_read_the_values_from_table_in_BrandWiseSalesManCommission(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where BrandCode='BRU'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblSalesManCommissionBrand":
				String Brandcode = "";
				try {
					Brandcode = rs.getString("BrandCode");
					System.out.println(Brandcode);
					Assert.assertEquals(Globals.Inventory.Brandcode.trim(), Brandcode.trim());
					pass.Excelcreate("brandwisesalesmancommission", "tblSalesManCommissionBrand", "", 3, 1, 3, 2);
					pass.ExcelFourData("brandwisesalesmancommission", "Brandcode", Globals.Inventory.Brandcode, Brandcode, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("brandwisesalesmancommission", "tblSalesManCommissionBrand", "", 3, 1, 3, 2);
					pass.ExcelFourData("brandwisesalesmancommission", "Brandcode", Globals.Inventory.Brandcode, Brandcode, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String Brand = "";
				try {
					Brand = rs.getString("BrandName");
					System.out.println(Brand);
					Assert.assertEquals(Globals.Inventory.Brand.trim(), Brand.trim());

					pass.ExcelFourData("brandwisesalesmancommission", "Brand", Globals.Inventory.Brand, Brand, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("brandwisesalesmancommission", "Brand", Globals.Inventory.Brand, Brand, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
				String Commission = "";
				try {
					Commission = rs.getString("Commission");
					System.out.println(Commission);
					Assert.assertEquals(Globals.Inventory.Commission.trim(), Commission.trim());

					pass.ExcelFourData("brandwisesalesmancommission", "Commission", Globals.Inventory.Commission, Commission, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("brandwisesalesmancommission", "Commission", Globals.Inventory.Commission, Commission, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}

	}

	
	}

	

	}
}
