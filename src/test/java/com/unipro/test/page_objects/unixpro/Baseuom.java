package com.unipro.test.page_objects.unixpro;


    import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.Assert;
import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
    import com.unipro.test.framework.PageObject;
    import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class Baseuom extends PageObject {
		AddInventoryFormPage Category;
		BaseuomField icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public  Baseuom(BaseuomField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Baseuom sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.BaseuomSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME22);
		}
		@Then("I load the rowise Baseuom data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.BaseuomrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.BaseuomSheetData, row_name);

			System.out.println(Globals.Inventory.BaseuomSheetData);

		}

		@Then("I update value to the Baseuom page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Uomcode = Globals.Inventory.BaseuomrowwiseData.get("Uomcode");
			Globals.Inventory.Description = Globals.Inventory.BaseuomrowwiseData.get("Description");
			Globals.Inventory.Baseuomcode = Globals.Inventory.BaseuomrowwiseData.get("Baseuomcode");
			Globals.Inventory.Baseuomdescription = Globals.Inventory.BaseuomrowwiseData.get("Baseuomdescription");
			Globals.Inventory.Qty = Globals.Inventory.BaseuomrowwiseData.get("Qty");
			
		
			
		}

		@Then("I fill new Baseuom data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Uomcode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlUOMCode_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlUOMCode_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlUOMCode_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Uomcode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Baseuomcode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlBaseUOMCode_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlBaseUOMCode_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBaseUOMCode_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Baseuomcode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Baseuomdescription)) {
				terPage.terminal_waitClearEnterText_css(icp.Baseuomdescription_String, Globals.Inventory.Description);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terPage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Description);
			
			}
			
		
	}
	@Then("I close connection to Baseuom")
	public void I_close_connection_to_Baseuom() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection to Baseuom")
	public void I_establish_connection_to_Baseuom() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Given("I read the values from table {string} in Baseuom")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where UOMCode='PCS'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "TBLUOMCONVMASTER":
				String Uomcode = "";
				try {
					Uomcode = rs.getString("UomCode");
					System.out.println(Uomcode);
					Assert.assertEquals(Globals.Inventory.Uomcode.trim(), Uomcode.trim());
					pass.Excelcreate("baseuom", "tblUOM", "", 0, 0, 0, 0);
					pass.ExcelFourData("baseuom", "Uomcode", Globals.Inventory.Uomcode, Uomcode, "Pass", 1, 0, 1, 1,
							1, 2, 1, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("baseuom", "tblUOM", "", 0, 0, 0, 0);
					pass.ExcelFourData("baseuom", "Uomcode", Globals.Inventory.Uomcode, Uomcode, "Fail", 1, 0, 1, 1,
							1, 2, 1, 3);

				}
				
				String Baseuomcode = "";
				try {
					Baseuomcode = rs.getString("BaseUomCode");
					System.out.println(Baseuomcode);
					Assert.assertEquals(Globals.Inventory.Baseuomcode.trim(), Baseuomcode.trim());

					pass.ExcelFourData("baseuom", "Baseuomcode", Globals.Inventory.Baseuomcode, Baseuomcode, "Pass", 2, 0, 2, 1,
							2, 2, 2, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("baseuom", "Baseuomcode", Globals.Inventory.Baseuomcode, Baseuomcode, "Fail", 2, 0, 2, 1,
							2, 2, 2, 3);

				}
				String Qty = "";
				try {
					Qty = rs.getString("UomConv");
					System.out.println(Qty);
					Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());

					pass.ExcelFourData("baseuom", "Qty", Globals.Inventory.Qty, Qty, "Pass", 3, 0, 3, 1,
							3, 2, 3, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("baseuom", "Qty", Globals.Inventory.Qty, Qty, "Fail", 3, 0, 3, 1,
							3, 2, 3, 3);

				}
				

}
		}
		}
	}












