package com.unipro.test.page_objects.unixpro;

    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
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

	public class AddDed extends PageObject {
		AddInventoryFormPage Category;
		AddDedField icp;
        ExcelWrite pass;
		TerminalPage terPage;
         
		public  AddDed(AddDedField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the AddDed sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.AddDedSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME24);
		}
		@Then("I load the rowise AddDed data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.AddDedrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.AddDedSheetData, row_name);

			System.out.println(Globals.Inventory.AddDedSheetData);

		}

		@Then("I update value to the AddDed page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Dicountcode = Globals.Inventory.AddDedrowwiseData.get("Dicountcode");
			Globals.Inventory.Description = Globals.Inventory.AddDedrowwiseData.get("Description");
			Globals.Inventory.Type = Globals.Inventory.AddDedrowwiseData.get("Type");
			Globals.Inventory.Batch = Globals.Inventory.AddDedrowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.AddDedrowwiseData.get("Batch1");
			Globals.Inventory.GST = Globals.Inventory.AddDedrowwiseData.get("GST");
			
		
			
		}

		@Then("I fill new AddDed data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Dicountcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Dicountcode_String, Globals.Inventory.Dicountcode);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Type)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddltype_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddltype_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddltype_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Type);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element(icp.Batch_String).click();

			}
		    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terPage.get_checkBox_element(icp.Batch1_String).click();

		    }
		    if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
				terPage.terminal_waitClearEnterText_css(icp.GST_String, Globals.Inventory.GST);
			
			}
}
		@Then("I close connection to AddDed")
		public void I_close_connection_to_AddDed() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to AddDed")
		public void I_establish_connection_to_AddDed() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in AddDed")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where DiscountCode='1'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblDiscount":
					String Dicountcode = "";
					try {
						Dicountcode = rs.getString("DiscountCode");
						System.out.println(Dicountcode);
						Assert.assertEquals(Globals.Inventory.Dicountcode.trim(), Dicountcode.trim());
						pass.Excelcreate("addded", "tblDiscount", "", 0, 0, 0, 0);
						pass.ExcelFourData("addded", "Dicountcode", Globals.Inventory.Dicountcode, Dicountcode, "Pass", 1, 0, 1, 1,
								1, 2, 1, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("addded", "tblDiscount", "", 0, 0, 0, 0);
						pass.ExcelFourData("addded", "Dicountcode", Globals.Inventory.Dicountcode, Dicountcode, "Fail", 1, 0, 1, 1,
								1, 2, 1, 3);

					}
					
					String Description = "";
					try {
						Description = rs.getString("Description");
						System.out.println(Description);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

						pass.ExcelFourData("addded", "Description", Globals.Inventory.Description, Description, "Pass", 2, 0, 2, 1,
								2, 2, 2, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("addded", "Description", Globals.Inventory.Description, Description, "Fail", 2, 0, 2, 1,
								2, 2, 2, 3);

					}
					String Type = "";
					try {
						Type = rs.getString("Type");
						System.out.println(Type);
						Assert.assertEquals(Globals.Inventory.Type.trim(), Type.trim());
						
						pass.ExcelFourData("addded", "Type", Globals.Inventory.Type, Type, "Pass",3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("addded", "Type", Globals.Inventory.Type, Type, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					String GST = "";
					try {
						GST = rs.getString("Gst");
						System.out.println(GST);
						Assert.assertEquals(Globals.Inventory.GST.trim(), GST.trim());
						
						pass.ExcelFourData("addded", "GST", Globals.Inventory.GST, GST, "Pass",4, 0,
								4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("addded", "GST", Globals.Inventory.GST, GST, "Fail", 4, 0,
								4, 1, 4, 2, 4, 3);

					}
				

		
}
	

			}
		}}

			

	










