package com.unipro.test.page_objects.unixpro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class Brand extends PageObject{
	AddInventoryFormPage Category;
	Brandfield icp;
    ExcelWrite pass;
	TerminalPage terPage;
	 Screenshot scr;

	public  Brand(Brandfield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
        pass =new ExcelWrite();
		Category = new AddInventoryFormPage();
		scr =new Screenshot();
	}
	
	@Then("I load the Brand sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.BrandSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME5);
	}
	@Then("I load the rowise Brand data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.BrandrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.BrandSheetData, row_name);

		System.out.println(Globals.Inventory.BrandSheetData);

	}

	@Then("I update value to the Brand page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Brandcode = Globals.Inventory.BrandrowwiseData.get("Brandcode");
		Globals.Inventory.Brandname = Globals.Inventory.BrandrowwiseData.get("Brandname");
		Globals.Inventory.Discount = Globals.Inventory.BrandrowwiseData.get("Discount");
		Globals.Inventory.Remark = Globals.Inventory.BrandrowwiseData.get("Remark");
		Globals.Inventory.Category = Globals.Inventory.BrandrowwiseData.get("Category");
	
		
	}

	@Then("I fill new Brand data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() throws Exception {
		
		try {
			
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brandcode)) {
			terPage.terminal_waitClearEnterText_css(icp.Brandcode_string, Globals.Inventory.Brandcode);
			

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brandname)) {
			terPage.terminal_waitClearEnterText_css(icp.Brandname_String, Globals.Inventory.Brandname);
		
		}
		

		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
			terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
			
			
}*/
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Remark)) {
			terPage.terminal_waitClearEnterText_css(icp.Remark_String, Globals.Inventory.Remark);
			
			
}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			//GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlCategory_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement CategoryValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]"));
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
		catch (Exception e) {
			// screen shot
			scr.Screenshots();
			// Xl sheet write
			System.out.println("Screen shot ");

		}
	}
		@Then("I close connection to Brand")
		public void i_close_connection_to_Brand() {	
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

		

		@Then("I establish connection to Brand")
		public void i_establish_connection_to_Brand() throws SQLException {
			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");
		}

		@Then("I read the values from table {string} in Brand")
		public void i_read_the_values_from_table_in_Brand(String tablename) throws IOException, SQLException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where BrandCode='Gopi'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblBrand":
					String Brandcode = "";
					try {
						Brandcode = rs.getString("BrandCode");
						System.out.println(Brandcode);
						Assert.assertEquals(Globals.Inventory.Brandcode.trim(), Brandcode.trim());
						 pass.Excelcreate("brand","tblBrand", "", 2, 0, 2, 1);
						pass.ExcelFourData("brand", "Brandcode", Globals.Inventory.Brandcode, Brandcode, "Pass", 3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						 pass.Excelcreate("brand", "tblBrand", "", 2, 0, 2, 1);
						pass.ExcelFourData("brand", "Brandcode", Globals.Inventory.Brandcode, Brandcode, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					String Brandname = "";
					try {
						Brandname = rs.getString("BrandName");
						System.out.println(Brandname);
						Assert.assertEquals(Globals.Inventory.Brandname.trim(), Brandname.trim());

						pass.ExcelFourData("brand", "Brandname", Globals.Inventory.Brandname, Brandname, "Pass", 4, 0, 4, 1, 4, 2,
								4, 3);
					} catch (AssertionError e) {

						pass.ExcelFourData("brand", "Brandname", Globals.Inventory.Brandname, Brandname, "Fail", 4, 0, 4, 1, 4, 2,
								4, 3);

					}

					String Remark = "";
					try {
						Remark = rs.getString("Remarks");
						System.out.println(Remark);
						Assert.assertEquals(Globals.Inventory.Remark.trim(), Remark.trim());

						pass.ExcelFourData("brand", "Remark", Globals.Inventory.Remark, Remark, "Pass", 5, 0, 5,
								1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("brand", "Remark", Globals.Inventory.Remark, Remark, "Fail", 5, 0, 5,
								1, 5, 2, 5, 3);

					}

					String Category = "";
					try {
						Category = rs.getString("RefCateCode");
						System.out.println(Category);
						Assert.assertEquals(Globals.Inventory.Category.trim(), Category.trim());

						pass.ExcelFourData("brand", "Category", Globals.Inventory.Category, Category, "Pass", 6, 0,
								6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("brand", "Category", Globals.Inventory.Category, Category, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}
		

				}
			}

		}
		
		
	
	

		@Then("I fill the Category values in the inventory page")
		public void i_fill_the_Category_values_in_the_inventory_page() {

			try {
				terPage.return_dd_invoke_element("-- Select --", 0).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				terPage.return_dd_invoke_element("-- Select --", 0).click();
				
			}
			GenericWrappers.sleepInSeconds(4);

			terPage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
		
		}
}
